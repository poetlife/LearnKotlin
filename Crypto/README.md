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
```
package encryto

import java.math.BigInteger
import java.security.MessageDigest

/*
MD5(Message Digest algorithm 5，信息摘要算法)
通常我们不直接使用上述MD5加密。通常将MD5产生的字节数组交给BASE64再加密一把，得到相应的字符串
Digest:汇编
*/

class MD5{
    companion object {
        val KEY_MD5 = "MD5"
        fun getResult(inputStr: String){
            // output the original data
            println("加密前数据为：${inputStr}")
            var bigInteger: BigInteger

            try {
                var md = MessageDigest.getInstance(KEY_MD5)
                md.update(inputStr.toByteArray())
                bigInteger = BigInteger(md.digest())
                println("加密后数据为：${bigInteger.toString(16)}")
            } catch (e: Exception){
                println(e.message)}
        }
    }
}

fun main(args: Array<String>){
    // main function
    val string_test = "Uozoyo, love you forever"
    MD5.Companion.getResult(string_test)
}


```
MD5算法具有以下特点：

1、压缩性：任意长度的数据，算出的MD5值长度都是固定的。  
2、容易计算：从原数据计算出MD5值很容易。  
3、抗修改性：对原数据进行任何改动，哪怕只修改1个字节，所得到的MD5值都有很大区别。  
4、弱抗碰撞：已知原数据和其MD5值，想找到一个具有相同MD5值的数据（即伪造数据）是非常困难的。  
5、强抗碰撞：想找到两个不同的数据，使它们具有相同的MD5值，是非常困难的。  
MD5的作用是让大容量信息在用数字签名软件签署私人密钥前被”压缩”成一种保密的格式（就是把一个任意长度的字节串变换成一定长的十六进制数字串）。除了MD5以外，其中比较有名的还有sha-1、RIPEMD以及Haval等。  

