# 第10章 其他Kotlin技术
## 数据解构
所谓数据解构就是**将对象中的数据解析成相应的独立变量**，也就是脱离原来的对象而存在。
```
data class Person(val name: String, var age: Int, var salary: Float)
fun main(args: Array<String>){
    // main function
    var person = Person("uozoyo", 21, 20000F)
    // 数据解构
    var (name, age, salary) = person
}
```
如果想让一个函数返回多个值，并能够解构这些值，也需要返回**数据类对象**。

有很多对象，可以保存一组值，并且可以通过for...in语句，将这些值解构出来。例如，Map对象就是这样子。
```
var map = mutableMapOf<Int, String>()
    map.put(10, "bill")
    map.put(20, "Mike")

    // 解构map对象中的key-value键值对
    for ((key, value) in map){
        println("key=${key}  value=${value}")
    }
```
## 集合
Kotlin标准库将集合分为**可修改的和不可修改的**
+ 不可修改的集合API包括：
    - List
    - Set
    - Map
+ 可修改的集合API包括：
    - MutableList
    - MutableSet
    - MutableMap
这些API都是接口，而且它们都是Collection的子接口。
这些不可修改的集合，在声明的时候都使用了关键字out
```
public interface List<out E>: Collection<E>
{
   ...
}
```
集合常用方式
```
// main function
    val numbers: MutableList<Int> = mutableListOf(1, 2, 3)  // 创建可读写的列表对象
    val readOnlyView: List<Int> = numbers  // 将读写列表变成字段列表
    println(numbers)  // output is [1, 2, 3]
    numbers.add(4)  // add new element to the list
    println(readOnlyView)  // output is [1, 2, 3, 4] (remain kind of confused)
```
下面是常见的用来创建集合对象的函数：
+ listOf
+ setOf
+ mapOf
+ mutableListOf
+ mutableSetOf
+ mutableMapOf

对于可读写的集合，可以通过**toXxx函数**将其转化为只读的版本，其中Xxx是List、Set和Map。

## 值范围
### 值范围的应用
值范围表达是使用rangeTo函数实现，该函数的操作符形式是两个点（..），另外还有两个相关操作符in和!in。任何可比较大小的数据类型（comparable type）都可以定义值范，但是对整数基本类型有个特殊优化：
```
// range
    var n = 20
    if (n in 1..100)
    {
        println("满足要求")
    }
    if (n !in 30 .. 80)
    {
        println("符合条件")
    }
```
而对于整数的值范围，可以对这些值范围进行遍历。编译器会负责将这些代码变换为java中基于下标的for循环，不会产生不必要的性能损耗。
```
for (i in 1..10 step 2)  // 相当于for (int i = 1; i <= 10; i++)
    {
        println(i*i)
    }
    // 倒序输出
    for (i in 10 downTo 1)
    {
        println(i*i)
    }
```
## 类型检查与类型转换
## this表达式
## 相等判断
## 操作符重载

## null值安全性
## 异常类
## 注解（Annotation）
## 反射（Reflection）
