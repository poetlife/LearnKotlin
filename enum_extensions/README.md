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

## 扩展

## 小结
