# Kotlin加密解密方法

## Base64
按照RFC2045的定义，Base64被定义为：Base64内容传送编码被设计用来把任意序列的8位字节描述为一种不易被人直接识别的形式。
> The Base64 Content-Transfer-Encoding is designed to represent arbitrary sequences of octets in a form that need not be humanly readable.

这里解密就是一个非常坑爹的过程了，由于kotlin中的`println()`默认是调用对象的`toString`方法，而这里的ByteArray并没有覆盖的toString方法，因此不能输出合适的字符，所以使用了Map的方法。
```
package encryto
import java.util.*
/*
this file aims to encoding with base64
 */

fun main(args: Array<String>){
    // main function
    val string_test = "Uozoyo, love you forever!"
    var encryed_string = Base64.getEncoder().encodeToString(string_test.toByteArray())
    var decryed_info = Base64.getDecoder().decode(encryed_string).map { i -> i.toChar() }.toCharArray()

    println(encryed_string)
    println(decryed_info)
}

```

## md5
MD5即Message-Digest Algorithm 5（信息-摘要算法5），用于确保信息传输完整一致。是计算机广泛使用的杂凑算法之一（又译摘要算法、哈希算法），主流编程语言普遍已有MD5实现。将数据（如汉字）运算为另一固定长度值，是杂凑算法的基础原理，MD5的前身有MD2、MD3和MD4。广泛用于加密和解密技术，常用于文件校验。校验？不管文件多大，经过MD5后都能生成唯一的MD5值。
