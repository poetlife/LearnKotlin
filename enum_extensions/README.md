# 第四章 枚举类和扩展
## 枚举类
### 枚举类的基本用法
```
// 枚举类的基本用法
enum class Direction{
    NORTH, SOUTH, WEST, EAST
    // Kotlin中一切皆对象，因此枚举值也是对象
}


fun main(args: Array<String>){
    // main function
    // 定义一个枚举类的变量
    var direction1: Direction
    // 定义一个枚举类的变量，并初始化
    var direction2: Direction = Direction.NORTH
    // 未指定数据类型，通过右侧的赋值自动检测类型
    var direction3 = Direction.EAST
    // 未指定数据类型，通过右侧的赋值自动检测类型
    var direction4 = Direction.EAST
    // 判断两个枚举类型变量的值是否相等
    if (direction3 == direction4){
        println("枚举类型值相等")
    }
    else{
        println("枚举类型值不相等")
    }
}
```
### 为枚举值指定对应的数值
```
// 为枚举类指定数值
// 之前就已经说过，枚举值也是对象，而枚举值的对像对应的类就是枚举类，因此给他们赋值，在构造器中处理就好了
enum class Direction private constructor(val d:Int)
{
    // 通过Direction的构造器传入枚举值对应的值
    NORTH(1), SOUTH(2), WEST(3), EAST(4);

    override fun toString(): String {
        return d.toString()  // 返回当前枚举值对应的数字
    }
}
```
### 枚举类的其他功能
```
// other functions
    // 无论是Java还是Kotlin都提供了相应的API来获取枚举值的名字和索引
    println(direction2.name)  // 获取名字
    println(direction3.ordinal)  // 获取索引
    // 传入枚举值名称来获取枚举值对应的数值
    println(Direction.valueOf("WEST"))
    // 遍历枚举类中所有的枚举值对应的数值
    for (d in Direction.values()){
        println(d)
    }
```
## 扩展
扩展是Kotlin中非常重要的功能，通过扩展，可以在没有源代码的情况下向类中添加成员，也可以在团队开发的情况下，通过扩展，将功能模块分散给多人开发。
### 扩展原生API
声明一个扩展函数，我们需要用一个*接收者类型*也就是被扩展的类型来作为它的前缀。
```
// 扩展原生API
// 对Kotlin原生集合类MutableList进行扩展，让该类有交换任意两个集合元素位置的能力
fun MutableList<Int>.swap(index1: Int, index2:Int)
{
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

fun main(args: Array<String>){
    // main function
    var mutableList = mutableListOf(1, 2, 3)
    // 调用已经定义好的拓展方法Swap
    mutableList.swap(0, 2)  // 交换第一个和最后一个元素的位置
    println(mutableList)
}
```
### 扩展自定义类
```
// 扩展自定义类
open class Parent(val value1: Int, val value2: Int){
    var mValue1: Int = value1
    var mValue2: Int = value2
    fun add():Int{
        return mValue1 + mValue2
    }
}
class Child(value1: Int, value2: Int): Parent(value1, value2){
    fun sub(): Int{
        return mValue1 - mValue2
    }
}
// 通过扩展向Parent中添加一个printResult的方法
fun Parent.printResult()
{
    println("${mValue1} + ${mValue2} = ${add()}")
}
// 通过拓展向Child中添加一个printResult的方法
fun Child.printResult()
{
    println("${mValue1} - ${mValue2} = ${sub()}")
}

fun main(args: Array<String>){
    // main function
    var parent1: Parent = Parent(1, 2)
    var parent2: Parent = Child(1, 2)
    parent1.printResult()  // 1 + 2 = 3 
    parent2.printResult()  // 1 + 2 = 3
}
```
我们可以看到，`parent2`的实例虽然是`Child`但输出的仍然和`parent1.printResult（）`一样，所以我们可以看到：**通过扩展是不能添加可继承的成员函数的**，解决方法是将`printResult()`放到类中，再override。
### 成员函数冲突的解决方案

### 扩展属性

### 扩展伴随对象（companion object）

### 扩展的范围

### 在类中使用扩展

### 调用特定类的成员函数

## 小结
