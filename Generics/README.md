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
## 类型投射
## 星号投射
## 泛型函数
## 泛型约束
## 小结
