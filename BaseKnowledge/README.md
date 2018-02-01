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
/*
    some basic methods for Array
     */
    val arr1 = arrayOf(1, 2, 3, "a")
    println(arr1[3])
    arr1[2] = "b"
    println(arr1[2])

    // use arrayOfNulls define an array
    var arr2 = arrayOfNulls<Int>(10)
    println("the length of arr2 is ${arr2.size}")

    // use the constructor of Array to set an array
    var arr3 = Array(10, {i: Int -> i * i })
    for (i in arr3){
        println(i)
    }

    // use intArrayOf to define an array
    var arr4 = intArrayOf(20, 30, 40, 50)
    println(arr4)
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
在Kotlin中，for循环可以直接枚举集合中的元素，也可以按集合索引来枚举元素
### while循环
和Java中一样，也分为while和do...while。
## 标签
在Kotlin中，任何表达式都可以用标签（label）来标记。标签的格式为标识符后跟@符号，例如`abc@`都是有效的符号。我们可以用Label标签来控制return、break、continue的跳转（jump）行为。
Kotlin的函数是可以被嵌套的。它有函数字面量、局部函数等。有了标签限制的return，我们就可以从外层函数返回了。
## 小结
虽然编程语言之间都是互通的，但是由于Kotlin中**加入了很多语法糖**，因此要充分了解Kotlin语言，，还要下一番功夫。
