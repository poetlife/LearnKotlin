# 未解决的疑难知识点

## 集合类
Kotlin中提供了不可变集合类与可变集合类。
> 世间本无集合（只有数组）
> 但有人想要，于是就用数组创造了集合类
> 有人想要可以自动扩展容量的数组，于是有了List
> 有人想要元素不重复的数组，于是有了Set
> 有人想要有序的数组，于是有了TreeSet、TreeList
> 有人想要通过复杂对象来查找另一个对象的关联数组于是有了Map



## 对象，类，抽象类和接口直接的区别与联系
### 面向对象的思想
1. 一切皆为映射
2. 二进制的0和1通过计算机里能够创造出一个虚拟的、纷繁的世界。
3. 面向对象编程是一种自顶向下的程序设计方法，万事万物都是对象，对象有其行为，状态。
### 抽象类
含有抽象函数的类（这样的类需要使用`abstract`修饰符来声明），称为抽象类。
#### 抽象函数
抽象函数是一种特殊的函数：它只有声明，而没有具体的实现。抽象函数的特征可以总结如下：
+ 抽象函数必须用abstract关键字进行修饰
+ 抽象函数默认被open修饰
+ 抽象函数无具体的实现
+ 含有抽象函数的类成为抽象类，必须由abstract修饰。抽象类中可以有具体实现的函数，这样的函数默认为final。
#### 抽象属性
抽象属性就是在Var或val前被abstract修饰的，抽象属性不能被初始化。
#### 抽象类与普通类的区别
1. 抽象函数必须为public或者protected，默认情况为public
2. 抽象类不能创建对象实例
3. 如果一个类继承于一个抽象类，则子类必须实现父类的抽象方法，否则需要将子类也定义为抽象类。
### 接口（interface）
#### 接口定义
用interface作为借口的关键词，与抽象类相同都可以实现抽象属性和方法。
#### 实现接口
接口是没有构造函数的。我们使用冒号:语法来实现一个接口，如果有多个用逗号隔开。
#### 覆盖冲突
在Kotlin中，实现继承通常遵循如下规则：**如果一个类从它的直接父类继承了同一个函数的多种实现，那么它必须重写这个函数并且提供自己的实现**。为表示使用父类中提供的方法，我们用super关键字表示。
#### 接口中的属性
在接口中声明的属性可以是抽象的，或者是提供访问器的实现。
### 抽象类和接口的差异
1. 概念上的区别。 接口主要是对动作的抽象，而抽象类是对根源的抽象；
2. 语法上的区别。 接口不能保存状态，可以有属性但必须是抽象的。一个类只能继承一个抽象类，而一个类可以实现多个接口。接口中，所有方法隐含都是抽象的。
3. 设计层面上的区别。 抽象类是对一种事物的抽象，而接口是对行为的抽象。
4. 实际应用上的区别。 在实际使用中，使用抽象类是一种强耦合的设计，用来描述“A is a B"的关系； 如果你设计中有两个类型的关系不是"is a"而是"is like a"，那么就必须慎重考虑继承。
### Object对象
Kotlin中没有”静态属性和方法“，但是提供了object对象。
匿名对象的使用：
```
fun distance(x: Double, y: Double): Double{
    val porigin = object {
        var x = 0.0
        var y = 0.0
    }
    return Math.sqrt(Math.pow((x - porigin.x), 2.0) + Math.pow((y - porigin.y), 2.0))
}

fun main(args: Array<String>){
    val result = distance(3.0, 4.0)
    println(result)
}
```
## 泛型
泛型（Generic Type)即参数化类型（Parameterized Type），顾名思义，就是将原来的具体的类型改为参数。
### 泛型与多态
完整的多态（Polymorphic）概念由以下三个组成部分：
1. 特殊多态。 此类下又包含函数重载以及类型转换多态。
2. 参数化多态。 即Java里面的泛型。
3. 子类型多态。 通过类型继承得到的多态。
### 型变（variant）
型变有3中基本类型：协变（Covariant）、逆变（Contravariant）和不变（Invariant）。
**PECS**: producer-extends, consumer-super
生产者就是我们去读取数据的对象，消费者则是我们写入数据的对象。
### 类型投射（type projection）
```
/*
类型投射
 */

class Array<T>(val size:Int){
    fun get(index: Int): T{}
    fun set(index: Int, value: T){}
}

/*
我们可以看到，T既作为get方法的返回类型，也作为set方法第2个参数的类型，无法进行子类化
 */
```
考虑到如下情况：
```
/*
考虑如下函数
 */

fun copy(from: Array<Any>, to: Array<Any>){
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
}

fun main(args: Array<String>){
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3){""}
    copy(ints,any)  // 错误
}
```
这里我们将遇到同样的问题：Array<T>在T上是不变的，因此Array<Int>和Array<Any>都不是另一个的子类型。那么我们唯一要确保的就是copy()不会做任何坏事。我们阻止它写入from，所以我们修改函数为
```
fun copy(from: Array<out Any>, to: Array<Any>){
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
}

fun main(args: Array<String>){
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3){""}
    copy(ints,any)  // 错误
}
```
现在这个from就是一个受Array<out Any>限制的（投影的）数组。其主要作用是参数作限定 ，避免不安全操作。
## 委托

## 内联函数

## as
在Kotlin中，不安全的类型转换使用中缀操作符as。

## 注解与反射

## 类型

## 操作符重载
