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
