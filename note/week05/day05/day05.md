# day24

## Mysql

### 权限管理(DCL)

- 创建用户：

  create user 用户名 identified by 密码;

- 授权：

  grant all on 数据库.表 to 用户名;

  ```mysql
  #添加远程用户访问
  grant all privileges on *.* to 'root'@'%' identified by 'root' with grant option;
  ```

- 撤销：

  revoke all on 数据库.表名 from 用户名;

- 刷新：

  flush privileges;

- 删除：

  drop user 用户名;

### 视图

#### 概念

视图即虚拟表，从一个表或多个表中查询出来的表，类似于真实表

#### 作用

方便用户操作，隔离真实表，保障数据库系统安全

#### 创建视图

create view 视图名 as  查询数据源表语句;

#### 修改视图

1. 方式一：create or replace view 视图名 as 查询语句;

   如果视图存在则替换，反之新建

2. 方式二：alter view 视图名 as 查询语句;

   对已存在视图进行修改

#### 删除视图

drop view 视图名;

注意：视图的删除不会影响原表

#### 视图特点

视图不会独立存储数据，原表数据发生改变，视图也发生改变。

如果视图包含以下结构中的一种，则视图不可更新【增删改】

- 聚合函数的结果。
- distinct 去重后的结果
- group by 分组后的结果
- having 筛选过滤后的结果
- union、union all 合并后的结果

## JDBC

### JDBC连接

注册驱动 -> 获取连接 -> 创建命令对象 -> 执行SQL语句 -> 处理结果 -> 释放资源

```java
//封装JDBC工具类
public class JDBCUtil {
    private static Properties properties = new Properties();
    static {
        try {
            properties.load(new FileInputStream("src\\week05\\day05\\jdbc.properties"));     
			//1.注册驱动
            Class.forName(properties.getProperty("driverClass"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("user"),properties.getProperty("password"));
    }
}

//连接操作
public class TestJDBC {
    public static void main(String[] args) throws Exception {
        //2.获取连接
        Connection connection = JDBCUtil.getConnection();
        //3.创建命令对象
        String sql = "select first_name from t_employees;";
        PreparedStatement ps = connection.prepareStatement(sql);//预加载sql语句
		//4.执行sql语句
        ResultSet set = ps.executeQuery();
        //5.处理结果
        while(set.next()){
            System.out.println(set.getString("first_name"));
        }
        //6.释放资源
        ps.close();
        connection.close();
    }
}
```

|   SQL    | Java(都可用java.util.Date接受) |
| :------: | :----------------------------: |
|   date   |         java.sql.date          |
|   time   |         java.sql.time          |
| datetime |       java.sql.TimeSramp       |

**使用PreparedStatement与占位符防止SQL注入**

