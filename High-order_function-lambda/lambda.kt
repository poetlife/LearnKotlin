package high_order_function

// Lambda expression
/*
1. lambda表达式总是被大括号{}括着
2. 其参数（如果有的话）在->之前声明，参数类型可以省略
3. 函数体（如果有的话）在->之后声明
4. 如果函数字面值只有一个参数，那么它的声明可以省略（连同->），其名称是it
 */

val sum = {x: Int -> {y:Int -> x + y}}

fun main(args:Array<String>){
    // main function
    var a = sum(1)(2)
    println(a)
}
