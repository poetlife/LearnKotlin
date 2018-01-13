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
## 类成员

## 修饰符（Modifiers）

## 类的继承

## 接口

## 抽象类

## 小结
