package high_order_function

class function1{
    /*
    单表达式函数
     */
    fun double(x:Int):Int = x*2
}

class High_order_function{
    /*
    高阶函数是将函数用作参数或者返回值的函数。
*/
    inline fun <T> Iterable<T>.filter(predicate: (T) -> Boolean): List<T>{
        return filterTo(ArrayList(), predicate)
    }

    // 调用
    fun isOdd(x:Int):Boolean{
        return x% 2 ==1
    }

    val list = listOf(1, 2, 3, 4, 5)
    var a = list.filter(::isOdd)  // :: 表示引用函数
}
