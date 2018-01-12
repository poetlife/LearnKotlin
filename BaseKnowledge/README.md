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
## 控制流
### 条件语句
### when语句
### for循环
### while循环
