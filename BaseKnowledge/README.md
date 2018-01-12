# Kotlin基础知识
人生第一段Kotlin代码
```
package com.pjd.helloworld

fun main(args: Array<String>)
{
    println("Hello, world!")
}
```
## 基本语法
### 定义变量
1. 定义常量
```
var n: Int = 30  // 定义变量
```
2. 定义变量
```
val m: Int = 30  // 定义常量
```
### 定义函数
```
fun process(m: Int): Unit
{
println(m * m)
}
```
若返回为Unit，可以没有返回值，这个unit也可以省略。
## 基础数据类型
### 数值类型
数值类型 | 占用字节数
-------- | ---------
Double | 8
Float | 4
Long | 8
Int | 4
Short | 2
Byte | 1

整数默认类型是`Int`，浮点数的默认类型是`Double`.
### 字符类型
在Kotlin中，字符类型用Char描述，不过和Java不同的是，在Kotlin中，字符不能**直接看做是数字**。
### 布尔类型
三种逻辑操作符，与(&&)，或(||)，非(!)
### 数组
在Kotlin中，数组使用`Array`类描述，在该类中包含了get和set方法，size属性等其他很多有用的成员方法。
```
// 指定数组
    // 1. 使用arrayOf函数定义可以储存任意值的数组
    var arr1 = arrayOf(1, 2, 3, 'a')
    println(arr1[3])
    arr1[2] = 'b'
    println(arr1[2])

    // 使用arrayOfNull定义数组
    var arr2 = arrayOfNulls<Int>(10)
    println("arr2的长度：" + arr2.size)

    // 使用Array类的构造器定义数组，其中第二个参数是指初始化每个数组元素的值
    // 每个数组元素的值就是当前数组索引的乘积
    var arr3 = Array(10, {i -> (i * i) .toString()})
    println(arr3[3])

    // 使用intArrayOf函数定义数组
    var arr4 = intArrayOf(20, 30, 40, 50, 60)
    println("arr4[2] = " + arr4[2])
```
输出为
```
a
b
arr2的长度：10
9
arr4[2] = 40
```
### 字符串
Kotlin中，使用String表示字符串类型，有如下两种类型：
1. 普通字符串类型，这种字符串中可以加入转义符，需要放在双引号中
2. 保留原始格式的字符串：这种字符串不能使用转义符，需要在3个引号中
### 字符串模板
所谓字符串模板就是在字符串中**添加若干个占位符**，内容会在后期指定。模板使用美元符号（$）设置。
```
    // 字符串模板
    val i = 10
    val s1 = "i = $i"  // 相当于“i = 10”
    println(s1)
```
## 包（Package）
Package和Ｃ#中的命名空间类似，是为了**尽可能避免类名重复**而设计的。在Java中，Package和目录同一到了一起，也就是说，Package就是目录。例如有个Java类MyClass，该类的包是util.net.system，那么就意味着存在一个/util/net/system目录结构，而MyClass.class或MyClass.java文件就在这个目录里面。
在Kotlin中，也存在包的概念，包在表达方式上和Java完全一样，但是**Kotlin中的包和目录没什么关系**，而仅仅是为了**引用文件中的资源**而设计的。
1. 引用其他文件的函数或类
`Person.kt`文件
```
package com.pjd.helloworld

fun getName(): String
{
    return "Bill Gates"
}

class MyClass {}
```
`Hello.kt`文件
```
package com.pjd.helloworld

fun main(args: Array<String>)
{
    println("Hello, world!")
    println(com.pjd.helloworld.getName())
    println(com.pjd.helloworld.MyClass())  // 创建对象的实例
}

```
2. 使用import导入资源
```
import com.pjd.helloworld.getName
import com.pjd.helloworld.*  // 导入所有的资源
import com.pjd.helloworld.MyClass as mc  // 起别名
```
3. Kotlin默认导入的包
    1. kotlin.*
    2. Kotlin.annotation.*
    3. kotlin.collections.*
    4. kotlin.comparisons.*
    5. kotlin.io.*
    6. kotlin.ranges.*
    7. kotlin.sequences.*
    8. kotlin.text.*
4. JavaSCript默认导入的包如下
    1. kotlin.js.*
## 控制流
### 条件语句
```
// 学习if
    // Traditional
    var a: Int = 20
    var b = 30
    var max: Int
    if (a < b) max = b
    
    var min: Int
    if (a > b) {
        min = a
    } else{
        min = b
    }
    // 表达式使用
    max = if (a < b) a else b
```
### when语句
在kotlin中，when替换了C语言风格的switch语句，标准的switch语句用法如下：
1. when作为语句使用
```
var x = 1
    when (x)
    {
        1 -> {
            println("x == 1")
            println("hello world!")
        }
        2 -> println("x == 2")
        else -> {
            println("x is neither 1 or 2")
        }
    }
```
   + when语句会根据传入的值寻找第一个满足条件的分支，找到后执行分支的语句
   + 如果分支中多于1条语句要用{…}
   + 满足条件之后会自动终止when语句的执行，并不需要像switch那样每个case语句都加上break
2. when作为表达式使用
```
// when作为表达式使用
    var x = 1
    var m = when (x) {
        1 -> {
            println("x == 1")
            20
        }
        2 -> {
            println("x == 2")
            60
        }
        else -> {
            println("x is neither 1 or 2")
            40
        }
    }
    println("the value of m is $m")
```
3. 多个分支执行相同的代码
使用逗号分隔条件
4. 使用`in`关键字确定一个范围
```
// 使用in关键字确定范围
    var n = 25
    when (n) {
        in 1..10 -> println("满足条件")
        in 11..20 -> println("不满足条件")
        !in 30..60 -> println("hello world")  // !in 表示不再这个范围内
        else -> println("条件未知")
    }
```
5. when的分支条件不仅可以使常量也可以使任意表达式
```
fun getValue(x:Int): Int{
    return x * x
}

fun main(args: Array<String>)
{
    // 分支条件是函数
    var n = 4
    when (n) {
        getValue(2) -> println("满足条件")
        getValue(3) -> println("不满足条件")
        else -> {
            println("条件未知")
        }
    }
}
```
### for循环
### while循环
