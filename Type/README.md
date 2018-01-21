# 基本数据类型与类型系统
> 道生一，一生二，二生三，三生万物。

在每一门编程语言中，都有一个特定的类型系统（Type System）。类型系统是一门编程语言最核心也是最基础的部分。可以简单的理解为下面的两个部分：
1. 一组基本类型构成的PTS（Primary Type System）；
2. PTS上定义的一系列组合、运算、转换规则等。

## 什么是类型？
> 一切皆映射

类型（Type），本质上是内存中的数值或变量的逻辑映射。
> 易有太极，是生两仪，两仪生四象，四象生八卦。

类型系统用于定义如何将编程语言中的数值和表达式归类为许多不同的类型，如何操作这些类型，这些类型如何互相作用等。

类型系统主要功能如下：
+ 安全性
+ 最优化
+ 可读性
+ 抽象化

## 编译时类型与运行时类型
> Kotlin是一门强类型的、静态类型、支持隐式类型的显示类型语言。

### Weakly Checked Language & Strongly Checked Language
弱类型语言在运行时会隐式做数据类型转换。强类型语言在运行时会确保不会发生未经明确转换的类型转换。

### Statically Checked Language & Dynamically Checked Language
类型检查可以发生在编译时期（静态检查）或运行时期（动态检查）。

### Explicitly Typed Language & Implicitlt Typed Language
根据变量名是否需要显示给出类型声明来区分。

## 根类型Any
```
E:\pjd\软件\kotlin\kotlinc\bin>kotlinc-jvm
Welcome to Kotlin version 1.2.20 (JRE 1.8.0_144-b01)
Type :help for help, :quit for quit
>>> val any = Any()
val any = Any()>>> any
java.lang.Object@169d577
>>> any :: class
class kotlin.Any
>>> any:: class.java
class java.lang.Object
```
Kotlin所有类都有一个共同的超类Any，如果类声明时没有指定超类，则默认为Any。
Any只有`equals()`、`hashCode()`、`toString()`三个方法。
在Kotlin中，操作符`==`会被编译器翻译成`equals()`函数。

## 基本类型（Primitive Types）
在Kotlin中，一切皆对象，所有类型都是引用类型，没有Java中的基本类型。但是，可以把Kotlin中对应的这几种基本数据类型，理解为Java的基本类型的装箱类。

## `Any?`可空类型（Nullable Types）
我们知道，在Java中如果一个变量可以是`null`，那么使用它调用一个方法就是不安全的，因为它会导致：`NullPointerException`。
Kotlin把可空性（nullability）作为类型系统的一部分，Kotlin编译器可以直接在编译的过程中发现许多可能的错误，并减少在运行时抛出异常的可能性。

### What's null?
我们通常把null理解为编程语言中定义的特殊的0，把我们初始化的指针指向它，以防止“野指针”的恶果。在Java中，`null`是任何引用类型的默认值，不严格的说是所有Object类型的默认值。

### Kotlin中的`null`

```

>>> null.equals(null)
null.equals(null)true
>>> null is Any
false
>>> null is Any?
true
>>> null == null
true
>>> var a = null
>>> a
null
>>> a = 1
error: the integer literal does not conform to the expected type Nothing?
a = 1
    ^

>>> "1" +null
1null
>>> null + 20
null20
>>> 20 + null
error: none of the following functions can be called with the arguments supplied:
public final operator fun plus(other: Byte): Int defined in kotlin.Int
public final operator fun plus(other: Double): Double defined in kotlin.Int
public final operator fun plus(other: Float): Float defined in kotlin.Int
public final operator fun plus(other: Int): Int defined in kotlin.Int
public final operator fun plus(other: Long): Long defined in kotlin.Int
public final operator fun plus(other: Short): Int defined in kotlin.Int
20 + null
   ^
```

## Kotlin.Unit类型

## Kotlin.Nothing类型
