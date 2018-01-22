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
## 标准委托
## 小结
