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
数据类型 | 占用字节数
-------- | ---------
Double | 8
Float | 4
Long | 8
Int | 4
Short | 2
Byte | 1

整数默认类型是`Int`，浮点数的默认类型是`Double`.
### 数值类型
### 字符类型
### 布尔类型
### 数组
### 字符串
### 字符串模板

## 包

## 控制流
### 条件语句
### when语句
### for循环
### while循环
