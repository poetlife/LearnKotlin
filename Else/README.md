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
## 值范围
## 类型检查与类型转换
## this表达式
## 相等判断
## 操作符重载

## null值安全性
## 异常类
## 注解（Annotation）
## 反射（Reflection）
