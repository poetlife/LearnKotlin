# 第6章 泛型（Generic）
所谓泛型，就是指在定义数据结构时，只指定类型的占位符，待到使用该数据结构时再指定具体的数据类型。
## 泛型基础
```
// 泛型
// T为泛型的占位符
class Box<T>(t:T){
    var value = t
}

fun main(args:Array<String>){
    // main function
    var box1: Box<Int> = Box(20)
    var box2: Box<String> = Box("Bill")
    println(box1.value)  // 是Int类型
    println(box2.value)  // 是String类型
}
```
## 类型变异
Kotlin泛型并没有提供通配符，取而代之的是out和in关键字。用out声明的泛型占位符只能在获取泛型类型值的地方，如函数的返回值。用in声明的泛型占位符只能在设置泛型类型值的地方，如函数的参数。我们习惯将只能读取的对象称为生产者（Producer），将只能设置的对象称为消费者（Consumer）。
### out
```
// 使用out关键字
// 我们可以标注Source的类型参数T来确保它仅从Source<T>成员中返回（生产）并从不被消费
interface Source<out T>
{
    fun nextT(): T
}

fun demo(strs: Source<String>){
    // 这个没问题，因为T是一个out-参数
    val objects: Source<Any> = strs
}
```
### in
```
// 使用in关键字
abstract class Comparable<in T>{
    abstract fun compareTo(other: T): Int // 这里不能用T，因为T被声明为in
}

fun demo(x: Comparable<Number>){
    x.compareTo(1.0)  // 1.0是Double类型，是Number的子类型
    val y: Comparable<Double> = x  // OK! 
}
```
## 类型投射
## 星号投射
## 泛型函数
## 泛型约束
## 小结
