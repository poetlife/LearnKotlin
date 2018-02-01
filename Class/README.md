# 类和接口
## 类的声明
Kotlin类的声明和Java没有任何区别。
## 构造器
### 主构造器和第二构造器
`Person.kt`代码
```
package com.pjd.helloworld

fun getName(): String
{
    return "Bill Gates"
}


// 构造器
class Person constructor(firstName: String){

}
// 如果没有任何注释（annotation)或修饰器(modifier)，关键字constructor可以省略
class Person1 (firstName: String){

}
// 实现构造器
class Person2 (firstName: String){
    var name = firstName
    init {
        println(firstName)
        println(name)
    }
}
// 第二构造器
class Person3 (firstName: String){
    // 主构造器的实现部分
    init {
        println("[primary]主构造器实现了！传入的字符为$firstName")
    }
    // 第二构造器，通过this调用了主构造器
    constructor(value: Int): this("纪东"){
        println("[secondary1]传入的第二构造器1实现了。传入值为$value")
    }
    // 第二构造器，通过this调用了主构造器
    constructor(description: String, firstName: String): this("[" + firstName + "]"){
        println("[secondary2]传入的第二构造器2实现了，传入的值为$description")
    }
    // 第二构造器，通过this调用了第二构造器，并间接调用主构造器
    constructor(): this(20)
    {
        println("[secondary3]成功间接调用了构造器并传入值20")
    }
}
```
`Hello.kt`代码
```
package com.pjd.helloworld

import com.pjd.helloworld.Person3 as p3

fun main(args: Array<String>)
{
    // 构造器
    // instance
    p3("Jidong")
    p3(100)
    p3("This is the first name of the author", "Jidong")
    p3()
}
```
Output
```
[primary]主构造器实现了！传入的字符为Jidong
[primary]主构造器实现了！传入的字符为纪东
[secondary1]传入的第二构造器1实现了。传入值为100
[primary]主构造器实现了！传入的字符为[Jidong]
[secondary2]传入的第二构造器2实现了，传入的值为This is the first name of the author
[primary]主构造器实现了！传入的字符为纪东
[secondary1]传入的第二构造器1实现了。传入值为20
[secondary3]成功间接调用了构造器并传入值20
```
### Kotlin中的Singleton
singleton模式又被称为单例模式，是一种常见的软件设计模式，通过单例模式可以保证系统中一个类只有一个实例。
java:
```
class Singleton {
    private static Singleton instance;  // 声明一个私有静态变量

    private Singleton() {}  // 私有构造函数，使得无法在外部声明一个对象

    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}

public class Hello {
    public static void main(String[] args){
        Singleton singleton = new Singleton();  // error
    }
}
```
kotlin
```

class Singleton private constructor()
{
    public var value: Singleton? = null
    private object mHolder { val INSTANCE = Singleton()}
    companion object Factory {
        fun getInstance(): Singleton{
            return mHolder.INSTANCE
        }
    }
}
```
## 类成员
类可以包含：  

+ 构造函数和初始化代码块  
+ 函数  
+ 属性  
+ 内部类  
+ 对象声明  

### 类属性
Kotlin中属性的语法
var/val \<propertyName> \[: \<PropertyType>] \[= \<property_initializer>]  
    \[\<getter>]  
    \[\<setter>]  
```
open class Uozoyo
{
    // 只读属性
    val name: String
        get() = "Bill"

    var v: Int = 20
    // 读写属性
    
    open var value: Int
        get() = v
        set(value)
        {
            println("Value属性被设置")
            v = value
        }
     
    // 保存属性的字段field
    var value2: Int = 0
        get() = field
        set(value)
        {
            println("value2属性被设置")
            field = value
        }
}
```

## 修饰符（Modifiers）

## 类的继承

## 接口(remain confused)
```
// 定义MyInterface接口
interface MyInterface
{
    fun process()
    // 有方法体的可以在继承的类中不重写
    fun getName(): String
    {
        return "Bill"
    }
}

// MyClass类实现了MyInterface接口，必须重写MyInterface中的两个方法
class MyClass: MyInterface
{
    override fun process() {
        println("function process...")
    }

    override fun getName(): String {
        return "Mike"
    }
}
```
## 抽象类
```
// 抽象类
open class Base{
    open fun f(){
        
    }
}

abstract class Derived: Base(){
    override abstract fun f()
}
```
## 小结
