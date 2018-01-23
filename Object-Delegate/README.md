# 第7章 对象和委托
## 对象（Object）
有时候我们需要创建一个对某个类做了轻微改动的类的对象，而不用为之显示声明新的子类。Java用匿名内部类处理这种情况。Kotlin使用**对象表达式和对象声明**对这个概念稍微概括了一下。
### 对象表达式
```
// 对象表达式
open class MyClass(name: String){
    open var name = name
    open fun verify(){
        println("Verify")
    }
}
interface MyInterface
{
    // 默认实现了closeData函数
    fun closeData(){
        println("closeData")
    }
}
fun process(obj: MyClass){
    obj.verify()
    // 判断obj是否是MyInterface的实例，如果是，则调用closeData方法
    if (obj is MyInterface)
    {
        obj.closeData()
    }
}

fun main(args:Array<String>){
    // main function
    process(object: MyClass("Bill"), MyInterface{
        override fun verify() {
            println("object verify")
        }
    })
}
```
### 声明匿名对象
匿名对象**只能用在本地（函数）或private声明中**。如果将匿名对象用于public函数的返回值，或public属性的类型，那么Kotlin编译器会将这些函数或属性的返回类型重新定义为匿名对象的父类型，如果匿名对象没有实现任何接口，也没有任何类继承，那么父类型就是Any。
### 访问封闭作用域的变量
Kotlin在匿名对象中可以任意访问变量，并且可以修改变量。
### 陪伴对象
Kotlin中并没有静态类成员的概念，因此，陪伴对象（Companion Objects）就是Kotlin用来解决这个问题的语法糖。陪伴对象需要用关键字`companion`来声明。
```
// 陪伴对象
class MyClass
{
    companion object Factory{
        fun create(): MyClass = MyClass()
    }
}

fun main(args:Array<String>){
    val instance = MyClass.create()
}
```
## 委托
委托（Delegate）其实是一种非常好的代码重用的方式，有点类似[AOP](https://baike.baidu.com/item/AOP/1332219?fr=aladdin)
委托模式是软件设计模式中的一项基本技巧。在委托模式中，有两个对象参与处理同一个请求，接受请求的对象将请求委托给另一个对象来处理。
### 类的委托
Kotlin直接支持委托模式。
```
// 类的委托
interface Base
{
    fun print()
}
class BaseImpl(val x: Int): Base
{
    override fun print() {
        println(x)
    }
}
class Derived(b: Base): Base by b
{
    // Derived本身的方法
    fun getName(): String{
        return "Bill"
    }
}

fun main(args:Array<String>){
    val b = BaseImpl(10)
    Derived(b).print()  // output is 10
}
```
### 委托属性
使用委托属性之前
```
// 委托属性之前
class MyClass1{
    var name: String = ""
    get() : String{
        println("MyClass1.get已经被调用")
        return field
    }
    set(value: String){
        println("MyClass1.set已经被调用")
        field = value
    }
}

class MyClass2{
    var name: String = ""
        get() : String{
            println("MyClass2.get已经被调用")
            return field
        }
        set(value: String){
            println("MyClass2.set已经被调用")
            field = value
        }
}

fun main(args: Array<String>){
    // main function
    var c1 = MyClass1()
    var c2 = MyClass2()
    c1.name = "Mike"
    c2.name = "Jack"
    println(c1.name)
    println(c2.name)
}

/*
output is like this:
MyClass1.set已经被调用
MyClass2.set已经被调用
MyClass1.get已经被调用
Mike
MyClass2.get已经被调用
Jack
 */
```
委托属性之后
```
import kotlin.reflect.KProperty
// 委托属性
class Delegate
{
    // 用于保存属性值的成员变量
    var name: String = ""
    // 调用委托属性的getter函数，会调用委托类的getValue函数
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String{
        // 获取thisRef指定的类名
        val className = thisRef.toString().substringBefore('@')
        // 调用了String类的方法
        println("${className}.get已经被调用")
        return name
    }
    // 调用委托函数的setter函数，会调用委托类的setValue函数
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String){
        // 获取thisRef指定的类名
        val className = thisRef.toString().substringBefore('@')
        println("${className}.set已经被调用")
        name = value
    }
}

class MyClass1
{
    // 将name属性委托给Delegate类
    var name: String by Delegate()
}
class MyClass2
{
    var name: String by Delegate()
}

fun main(args: Array<String>){
    // main function
    var c1 = MyClass1()
    var c2 = MyClass2()
    c1.name = "Mike"
    c2.name = "Jack"
    println(c1.name)
    println(c2.name)
}
```
### 委托类的初始化函数

### 委托的前提条件

## 标准委托
Kotlin标准库中提供了一些委托函数，可以实现几种很有用的委托。
### 惰性装载
### 可观察属性
### 阻止属性的赋值操作
### Map委托
## 小结
