# day26

## 三层架构

三层架构：将程序划分为表示层、业务逻辑层、数据访问层三层，各层之间采用接口相互访问，并通过实体类对象作为数据传递的载体。

- 表示【界面】层（User Interface Layer）
- 业务逻辑【服务】层（Business Logic Layer）
- 数据访问【持久】层（Data Access Layer）

调用关系：表示层调用业务逻辑层，业务逻辑层调用数据访问层。

目的：是为了实现“高内聚低耦合”的思想。

## 优化工具类的增删改方法，查询方法

```java
package week06.day02.booksys.utils;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author 10431
 * @version v1.0
 * @porject QF5
 * @package week05.day05
 * @company lpc
 * date 2023/8/18 10:19
 */

public class JDBCUtil {
    //key:ThreadLocal value:Connection
    public static ThreadLocal<Connection> threadLocal = new InheritableThreadLocal<>();
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(JDBCUtil.class.getResource("jdbc.properties").openStream());
            Class.forName(properties.getProperty("driverClass"));
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("注册驱动失败");
        }
    }

    public static Connection getConnection() {
        Connection conn = threadLocal.get();
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(
                        properties.getProperty("url") + properties.getProperty("database"),
                        properties.getProperty("user"),
                        properties.getProperty("password"));
                threadLocal.set(conn);
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeResource(PreparedStatement ps, Connection con, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) {
                if (con.getAutoCommit()) {
                    con.close();
                    threadLocal.remove();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void begin() throws SQLException {
        Connection conn = getConnection();
        if (conn != null) {
            conn.setAutoCommit(false);
        }
    }
    public static void commit() throws SQLException {
        Connection conn = getConnection();
        if (conn != null) {
            conn.commit();
        }
    }
    public static void rollback() throws SQLException {
        Connection conn = getConnection();
        if (conn != null) {
            conn.rollback();
        }
    }
    public static void close() throws SQLException {
        Connection conn = getConnection();
        if (conn != null) {
            conn.close();
            threadLocal.remove();
        }
    }

    public static int commonUpdata(String sql, Object... params) {
        Connection connection = null;
        PreparedStatement ps = null;
        int res;
        try {
            connection = JDBCUtil.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            res = ps.executeUpdate();
            closeResource(ps, connection, null);
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> selectList(String sql,Class<T> tClass,Object...params){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            connection = JDBCUtil.getConnection();
            ps = connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1,params[i]);
                }
            }
            res = ps.executeQuery();

            //获取结果集的标题
            ResultSetMetaData metaData = res.getMetaData();
            List<T> list = new ArrayList<>();
            while (res.next()){

                T t = tClass.newInstance();

                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    try {
                        //获取结果集标题
                        String columnLabel = metaData.getColumnLabel(i + 1);
                        //创建属性描述对象
                        PropertyDescriptor pd = new PropertyDescriptor(columnLabel,tClass);
                        //获取set方法
                        Method writeMethod = pd.getWriteMethod();
                        //调用方法
                        writeMethod.invoke(t,res.getObject(columnLabel));
                    } catch (Exception e) {
                        continue;
                    }
                }

                list.add(t);
            }
            return list;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            closeResource(ps,connection,res);
        }
    }
}
```

## 连接池

druid【德鲁伊】

private static DruidDataSource ds;

创建连接池：

ds = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties); 

```java
package week06.day02.booksys.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author 10431
 * @version v1.0
 * @porject QF5
 * @package week05.day05
 * @company lpc
 * date 2023/8/18 10:19
 */

public class JDBCUtil_druid {
    //key:ThreadLocal value:Connection
    public static ThreadLocal<Connection> threadLocal = new InheritableThreadLocal<>();
    private static Properties properties = new Properties();
    private static DruidDataSource dataSource;

    static {
        try {
            properties.load(JDBCUtil_druid.class.getResource("druid.properties").openStream());
            dataSource = new DruidDataSource();
            dataSource.configFromPropety(properties);

        } catch (Exception e) {
            System.out.println("连接池创建失败:" + e.getMessage());
        }
    }

    public static Connection getConnection() {
        Connection conn = threadLocal.get();
        try {
            if (conn == null) {
                conn = dataSource.getConnection();
                threadLocal.set(conn);
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeResource(PreparedStatement ps, Connection con, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) {
                if (con.getAutoCommit()) {
                    con.close();
//                    dataSource.close();
                    threadLocal.remove();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void begin() throws SQLException {
        Connection conn = getConnection();
        if (conn != null) {
            conn.setAutoCommit(false);
        }
    }
    public static void commit() throws SQLException {
        Connection conn = getConnection();
        if (conn != null) {
            conn.commit();
        }
    }
    public static void rollback() throws SQLException {
        Connection conn = getConnection();
        if (conn != null) {
            conn.rollback();
        }
    }
    public static void close() throws SQLException {
        Connection conn = getConnection();
        if (conn != null) {
            conn.close();
            threadLocal.remove();
        }
    }

    public static int commonUpdata(String sql, Object... params) {
        Connection connection = null;
        PreparedStatement ps = null;
        int res;
        try {
            connection = JDBCUtil_druid.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            res = ps.executeUpdate();
            closeResource(ps, connection, null);
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> selectList(String sql,Class<T> tClass,Object...params){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            connection = JDBCUtil_druid.getConnection();
            ps = connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1,params[i]);
                }
            }
            res = ps.executeQuery();

            //获取结果集的标题
            ResultSetMetaData metaData = res.getMetaData();
            List<T> list = new ArrayList<>();
            while (res.next()){

                T t = tClass.newInstance();

                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    try {
                        //获取结果集标题
                        String columnLabel = metaData.getColumnLabel(i + 1);
                        //创建属性描述对象
                        PropertyDescriptor pd = new PropertyDescriptor(columnLabel,tClass);
                        //获取set方法
                        Method writeMethod = pd.getWriteMethod();
                        //调用方法
                        writeMethod.invoke(t,res.getObject(columnLabel));
                    } catch (Exception e) {
                        continue;
                    }
                }

                list.add(t);
            }
            return list;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            closeResource(ps,connection,res);
        }
    }
}
```

## Apache DbUtils工具库

### QueryRunner类(执行SQL语句的类)

- 增、删、改：update();
- 查：query();

### ResultSetHandler接口(类型转换接口)

| **实现类**      | **描述**                   |
| --------------- | -------------------------- |
| BeanHandler     | 把一条记录转换成一个对象。 |
| BeanListHandler | 把多条记录转换成List集合。 |
| ScalarHandler   | 适合获取一行一列的数据。   |

```java
package week06.day02.commons_dbutils.util;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author 10431
 * @version v1.0
 * @porject QF5
 * @package week06.day02.commons_dbutils.util
 * @company lpc
 * date 2023/8/22 16:39
 * 返回数据源的工具类
 */
public class DataSourceUitls {
    private static DruidDataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            properties.load(DataSourceUitls.class.getResource("druid.properties").openStream());
            dataSource = new DruidDataSource();
            dataSource.configFromPropety(properties);

        } catch (Exception e) {
            System.out.println("连接池创建失败:" + e.getMessage());
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
}

//使用
 QueryRunner qr = new QueryRunner(DataSourceUitls.getDataSource());
//查询
qr.query(sql, new BeanListHandler<>(Book.class));
//增删改
 qr.update("insert into  book values (?,?,?,?,?,?,?,?,?)", params);
```