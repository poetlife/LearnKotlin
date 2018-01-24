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
以上涉及值范围的都是闭区间，如果我们想使用左闭右开区间需要用`until`函数。
```
for (i in 2 until 10)  // 左闭右开
    {
        println(i)
    }
```
### 常用的工具函数
+ rangeTo
+ downTo
+ reversed
+ step
## 类型检查与类型转换
Kotlin的类型检查操作符更智能，会自动转换类型。

### is与!is操作符
如果is表达式满足条件，Kotlin编译器会自动转换is前面的对象到后面的数据类型。
```
var obj: Any = "abcd"
    // 判断obj是否为String类型
    if (obj is String)
    {
        println("obj是字符串")
        println(obj.length)
    }
```
### 强行类型转换
如果类型强制转换，而且类型不兼容，类型转换操作符通常会抛出一个异常。因此我们称之为不安全的（unsafe）。在Kotlin中，不安全的类型转换使用中缀操作符as。
```
var y: Any = "abcd"
    val x: Int = y as Int  // 无法转换，抛出异常

    val a: Any? = "abcd"
    val b: Int? = a as? Int?  // 转换错误但不会抛出异常，b的值是null
```
## this表达式
为了表示当前函数的接收者（receiver），可以使用this表达式。
在类的成员函数中，this指向这个类的当前对象实例。
在扩展函数中，或者带接收者的函数字面值（function literal）中，this代表调用函数时，在点号左侧传递的接收者参数。
```
class A {  // 隐含标签@A
    inner class B {  // 隐含标签@B  
        fun Int.foo(){  // 隐含标签 @foo
            val a = this@A  // 指向A的this
            val b = this@B  // 指向B的this
            
            val c = this  // 指向foo函数的接受者，一个Int值
            val c1 = this@foo  // 指向foo函数的接受者，一个Int值
            
            val funLit = lambda@ fun String.(){
                val d = this  // 指向foo()函数的接受者
            }
        }
    }
    
}
```
## 相等判断
在Kotlin中存在两种相等判断：
+ 引用相等，也就是说，两个引用指向同一个对象
+ 结构相等，使用equals函数判断
引用相等，使用`===`
结构相等，使用`==`

## 操作符重载（remain unsolved）
Kotlin允许我们对数据类型的一组预定义的操作符提供实现函数。用于实现操作符重载的函数应该使用operator修饰符进行标记。
## null值安全性
在Java中，用户经常饱受NPE的干扰，而在Kotlin中尽量避免null异常带来的麻烦。
### 可为null类型和不可为null类型
+ 可为null引用
```
val a: String? = null
```
+ 不可为null引用
```
val a: String = null  // 编译错误
```
### 在条件语句中进行null检查
在上面中，由于a是不安全的，因此访问a的属性时kotlin不会让编译通过，但如果非得访问到话就需要做null检查。
```
    // null test
    var b: String? = "abc"
    
    val len = if (b != null) b.length else -1
```
### 安全调用操作符
使用安全调用操作符“?”
```
    var b: String? = null
    val len = b?.length  // output is null
```
### Elvis操作符
假设我们有一个可为null得引用r，我们可以认为：“如果r不为null，那么就使用它，否则，就使用某个非null的值x”
Elvis操作符的表示形式是?:
```
// null test
    var b: String? = null
    val len = b?.length ?: -1
```
## !!操作符
对于NPE的热爱者来说，还有另外的解决方案。我们可以写b!!，对于b不为null的情况，这个表达式将会返回这个非null的值，如果b是null，这个表达式将抛出NPE。
```
val len = b!!.length
```
## 异常类
Kotlin中所有异常类都是Throwable的子类。每个异常都带有一个错误消息，调用堆栈，以及可选的错误原因。
要抛出异常，可以使用throw表达式。
```
throw MyException("hi there!")
```
## 注解（Annotation）
## 反射（Reflection）
