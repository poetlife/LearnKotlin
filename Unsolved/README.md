# 未解决的疑难知识点

## 集合类
Kotlin中提供了不可变集合类与可变集合类。  
> 世间本无集合（只有数组）   
> 但有人想要，于是就用数组创造了集合类  
> 有人想要可以自动扩展容量的数组，于是有了List  
> 有人想要元素不重复的数组，于是有了Set  
> 有人想要有序的数组，于是有了TreeSet、TreeList  
> 有人想要通过复杂对象来查找另一个对象的关联数组于是有了Map  

### List
```
    /*
    some methods of List
     */
    var list = listOf<Int>(1, 2, 3)
    /*
    some methods to iterate the elements of list
     */

    // 1. iterator

    var iter = list.iterator()
    // get the element
    println(iter.next())
    // judge the iterator exist or not an element
    println(iter.hasNext())

    // 2. forEach

    list.forEach(::println)  // ::是函数引用符
    list.forEach { println(it) }
```
List元素操作函数
```
    val mutableList = mutableListOf(1, 2, 3)

    // 1. add/remove operation

    mutableList.add(4)
    mutableList.add(0, 0)  // 在下标为0的位置添加元素0
    mutableList.remove(1)  // 删除元素1
    mutableList.removeAt(1)  // 删除下标为1的元素
    mutableList.removeAll(listOf(3, 4))  // 删除子集合
    mutableList.addAll(listOf(1, 3, 4))  // 添加子集合

    // 2. set/clear operation

    mutableList.set(0, 100)  // 将下标为0的元素设置为100
    mutableList.clear()  // 清空集合
    mutableList.toList()  // 将可变集合转变为不可变集合
    
    // 3. retainAll
    val mlist1 = mutableListOf(1, 2, 4)
    val mlist2 = mutableListOf(1, 2, 3)
    mlist1.retainAll(mlist2)  // 取交集

    // 4. contains
    mlist1.contains(1)  // 判断集合中是否有指定元素

    // 5. elementAt
    mlist1.elementAt(1)  // 查找下标是1的元素

    // 6. last(predicate: (T) -> Boolean)
    var list = listOf(1, 2, 3)
    list.last { it == 3 }  // 返回符合条件的最后一个元素，没有的话就抛出异常
    
```
List集合类的基本运算函数
```
    /*
    List类的基本运算函数
     */

    var mutableList = mutableListOf(1, 2, 3)

    // 1. any() 判断集合至少有一个元素
    mutableList.any()  // true

    // 2. any(predicate: (T) -> Boolean)  判断集合中过是否有符合条件的元素
    mutableList.any { it == 2 }  // true

    // 3. all(predicate: (T) -> Boolean)  判断集合中的元素是否都符合条件
    mutableList.all{ it % 2 == 0 }  // false

    // 4. none()  // 判断集合无元素
    mutableList.none()  // false

    // 5. none(predicate: (T) -> Boolean)  判断集合中所有元素都不满足条件
    mutableList.none { it > 4 }  // true

    // 6. count()  计算集合中元素的个数
    mutableList.count()  // 3

    // 7. count(predicate: (T) -> Boolean)  计算集合中符合条件的元素个数
    mutableList.count{ it > 1 }  // 2

    // 8. reduce  从第一项到最后一项进行累计计算
    // reduce(operation: int, int -> ....)
    mutableList.reduce({sum, next -> sum + next})  // 6
    mutableList.reduce({sum, next -> sum * next})  // 6

    // 9. reduceRight 从最后一项到第一项进行累计运算

    // 10. fold(initial: R, operation: (acc:R, T) -> R): R
    // fold 函数给累加子赋了初始值initial。而不是像reduce赋给了第一个值
    mutableList.fold(100,{sum,next -> sum + next})  // 106

    // 11. foldRight 从最后一项到第一项进行累计运算，并赋予初始值

    // max、 min 返回集合中最大、最小的元素
    mutableList.max()  // 3
    mutableList.min()  // 1
    // kotlin中比较字符串大小比较有意思

    // 12. maxBy(selector: (T) -> R): T?、minBy(selector: (T) -> R): T?
    mutableList.maxBy { -it*it + 10 }  // 1
```
List过滤操作函数
```
    /*
    List过滤操作函数
     */

    val mutableList = mutableListOf(1, 2, 3, 4, 5)
    // 1. take(n: Int): List<T>
    mutableList.take(3)  // [1, 2, 3]

    // 2. takeWhile(predicate:(T) -> Boolean) :List<T>
    mutableList.takeWhile { it >= 2 }  // [2, 3, 4, 5]

    // 3. takeLast(n: Int)  挑出后n个元素的子集合

    // 4. takeLastWhile(predicate: (T) -> Boolean): List<T>

    // 5. drop(n: Int)  去除前n个元素返回剩下的元素的子集合

    // 6. dropWhile; dropLast; dropLastWhile 同前面

    // 7. slice(indices: IntRange)  即开始下标至结束下标元素子集合
    mutableList.slice(1..2)  // [2, 3]
    
    // 9. slice(indices: Iterable<Int>)  返回指定下标的元素子集合
    mutableList.slice(listOf(1, 2))  // [2, 3]
    
    // 10. filterTo(destination: C, predicate: (T) -> Boolean)  过滤出满足条件的元素并赋值给destination
    val dest = mutableListOf<Int>()
    mutableList.filterTo(dest, {it != 2})  // dest = [1, 3, 4, 5]
```
List映射操作函数
```
    /*
    映射操作函数
     */
    val mutableList = mutableListOf(1, 2, 3, 4, 5)

    // 1. map(transform: (T) -> R): List<R>  将集合中的元素通过转换函数transform映射后的结果，存到一个集合中并返回
    mutableList.map { it * it }  // [1, 4, 9, 16, 25]

    // 2. mapIndexed(transform: (kotlin. Int, T) -> R)  转换函数transform中带有下标参数
    mutableList.mapIndexed({index, it -> index*it})  // [0, 2, 6, 12, 20]

    // 3. mapNotNull(transform: (T)->R?)  返回一个无null值的集合

    // 4. flatMap(transform: (T) -> Iterable<R>): List<R>  在原始集合上的每个元素上调用transform转换函数，得到的映射组成的单个列表
    mutableList.flatMap { it -> listOf(it, it + 1) }  // [1, 2, 2, 3, 3, 4, 4, 5, 5, 6]
    mutableList.map { it -> listOf(it, it + 1) }  // [[1, 2], [2, 3], [3, 4], [4, 5], [5, 6]]
```
List分组操作函数
```
    /*
    分组操作函数
     */

    val mutableList = mutableListOf<String>("ab", "bvd", "fasd", "dfas", "ad")

    // 1. groupBy(keySelector: (T) -> K): Map<K, List<T>>
    // 将集合中的元素按照条件选择器分组，并返回Map
    mutableList.groupBy { it.length }  // {2=[ab, ad], 3=[bvd], 4=[fasd, dfas]}

    // 2. groupingBy(crossinline keySelector: (T) -> K): Grouping<T, K>
    // 可以使用eachCount统计分组
    val words = "one two three four five six seven eight nine ten".split(" ")
    words.groupingBy { it.first() }.eachCount()  // {o=1, t=3, f=2, s=2, e=1, n=1}
```
List排序操作符
```
    /*
    排序操作符
     */

    val mutableList = mutableListOf<Int>(1, 2, 3, 4, 5)

    // 1. reversed(): List<T>  倒序排列集合元素
    mutableList.reversed()  // [5, 4, 3, 2, 1]

    // 2. sorted sortedDescending  升/降序排列

    // 3. sortedBy sortedDescendingBy  根据函数映射的结果进行升降序排列
    val words = "one two three four five six seven eight nine ten".split(" ")
    words.sortedBy { it.length }  // [one, two, six, ten, four, five, nine, three, seven, eight]
```
List生产操作符
```
    /*
    生产操作符
     */

    val list1 = listOf<Int>(1, 2, 3)
    val list2 = listOf<String>("a", "b", "c")

    // 1. zip(other: Iterable<R>): List<Pair<T, R>>  两个集合按照下标配对，组合成的Pair作为新的List集合中的元素
    list1.zip(list2)  // [(1, a), (2, b), (3, c)]
    // 如果两个集合长度不一样，取短的

    // 2. partition(predicate: (T) -> Boolean): Pair<List<T>, List<T>>  根据判断条件是否成立，将集合拆分成两个子集组成的Pair
    val list = listOf<Int>(1, 3, 5, 7, 9)
    list.partition { it>5 }  // ([7, 9], [1, 3, 5])

    // 3. plus(elements: Iterable<T>): List<T>  合并两个List，可以用+替代
    
    // 4. plusElement 在集合中添加一个元素
```
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
### 代理模式
代理模式（proxy pattern）也称为委托模式。在代理模式中，有两个对象参与处理同一个请求，接受请求的对象将请求委托（delegation）给另一个对象来处理。
代理模式使得我们可以用聚合来替代继承，它还使我们可以模拟mixin（混合类型）。委托模式的作用是将委托者与实际实现代码分离开来，以达到[解耦](https://baike.baidu.com/item/解耦/8592042?fr=aladdin)的目的。
### 类的委托
### 委托属性

## 内联函数

## as
在Kotlin中，不安全的类型转换使用中缀操作符as。

## 注解与反射

## 类型

## 操作符重载

## Kotlin与Java互操作
