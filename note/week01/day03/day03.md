# DAY03

## 运算符

### 算数运算符

- #### 加	+

- #### 减	-

- #### 乘	*

- #### 除	/

- #### 求余	%

- #### 自增	++

  - ##### 可放在变量前或者变量后进行运算
  - ##### (a--)6  +  (b++)/3  -  (--a)2  -  (--b)2  +  (++a)

- #### 自减	- -

  - ##### 可放在变量前或者变量后进行运算

### 赋值运算符(不会进行类型提升)

- #### 直接赋值	=

- #### 求和后赋值	+=

- #### 求差后赋值	-=

- #### 求积后赋值	*=

- #### 求商后赋值	/=

- #### 求余后赋值	%=

### 关系运算符

- #### 大于	>

- #### 小于	<

- #### 大于等于	>=

- #### 小于等于	<=

- #### 等于	==

- #### 不等于	!=

### 逻辑运算符

- #### 短路与(并且)	  &&	 两个操作数，同时为真，结果为真  前面为false不在执行

- #### 短路或(或者)	||	  两个操作数，有一个为真，结果为真  前面为true不在执行

- #### 非(取反)	!	意为“不是”，真转成假，假转成真  

### 三元（目）运算符

- #### 			？:	布尔表达式?结果1(true):结果2(false)


### 位运算符对（二进制层面）

- #### (二进制数据进行按位操作;1表示true、0表示false)

- #### 按位与	&	10->0   00->0  11->1 有0取0

- #### 按位或	|	00 –>0 有1取1

- #### 按位取反	~

- #### 按位异或	^	相同为假、不同为真

- #### 右移	‘>>’	右移相当于除以2	二进制左边补符号位	类型最大位数倍数还原

- #### 左移	‘<<’	左移相当于乘以2	二进制右边补0

- #### 无符号右移	‘>>>’	右移相当于除以2	二进制左边补0

### 优先级

| **操作符优先级**      | **结合性** |
| --------------------- | ---------- |
| [  ] . ( )            | 从左向右   |
| ! ~   ++ -- -(负号)   | 从右向左   |
| *  / %                | 从左向右   |
| +  -                  | 从左向右   |
| <<  >> >>>            | 从左向右   |
| <  <= > >= instanceof | 从左向右   |
| ==  !=                | 从左向右   |
| &                     | 从左向右   |
| ^                     | 从左向右   |
| \|                    | 从左向右   |
| &&                    | 从左向右   |
| \|\|                  | 从左向右   |
| ?:                    | 从右向左   |
| =、+=、-=.......      | 从右向左   |

- #### 算术>关系>逻辑

- #### 大部分左结合，单目、三目、赋值右结合

- #### 优先级相同看结合性

## 自动类型提升

- #### 两个操作数有一个为double，计算结果提升为double。

- #### 如果操作数中没有double，有一个为float，计算结果提升为float。

- #### 如果操作数中没有float，有一个为long，计算结果提升为long。

- #### 如果操作数中没有long，有一个为int，计算结果提升为int。

- #### 如果操作数中没有int，均为short或byte，计算结果仍旧提升为int。

- #### 任何类型与String相加（+）时，实为拼接，其结果自动提升为String。

## 三种基本结构

- ### 顺序结构

- ### 选择结构

  - #### if语句

    - equals()方法用于字符串比较 

  - #### switch语句

    - switch适用等值判断；多重if没有限制，可以区间、等值等。
    - switch类型可以是byte、short、int、char、String（JDK7+）、枚举
    - break关键字可在匹配的case执行后，跳出switch结构。
    - switch的值不能重复
    - default可以省略 
    - case穿透，没有break语句，会执行case下面的语句，直到遇到break                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           

- ### 循环结构

