package encrypt

import java.io.File
import java.util.*
import javax.crypto.KeyGenerator
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

fun writeFile(text: String, destFile: String){
    val f = File(destFile)
    if (f.exists()){
        f.createNewFile()
    }
    f.writeText(text)
}

class HAMC{
    companion object {
        private const val KEY = "HmacMD5"
        // 初始化Hmac密钥
        private fun initMacKey(): String{
            val keyGenerator = KeyGenerator.getInstance(KEY)
            val secretKey = keyGenerator.generateKey()
            return Base64.getEncoder().encodeToString(secretKey.encoded)
        }

        // 主要加密方法
        private fun encryptHMAC(data: ByteArray, key: String): String{
            val secretKey = SecretKeySpec(Base64.getDecoder().decode(key), KEY)
            val mac = Mac.getInstance(secretKey.algorithm)
            mac.init(secretKey)
            val final = mac.doFinal(data)
            return final.contentToString()
        }

        // 1
        fun getResult1(inputStr: String): String{
            println("加密前的数据为: ${inputStr}")
            val path = "/home/pengjidong/IdeaProjects/formal/src/encrypt"
            val fileSource = path + "/file/HMAC_KEY.txt"
            var result = ""
            try {
                // 产生密钥
                val key = HAMC.Companion.initMacKey()
                println("密钥为：${key}")
                // 将密钥写入文件
                writeFile(key, fileSource)
                // 加密
                result = HAMC.Companion.encryptHMAC(inputStr.toByteArray(), key)
                println("加密后的数据为：${result}")
            } catch (e: Exception){e.printStackTrace()}
            return result
        }

        // 2
        fun getResult2(inputStr: String): String{
            println("加密前的数据为: ${inputStr}")
            val path = "/home/pengjidong/IdeaProjects/formal/src/encrypt"
            val fileSource = path + "/file/HMAC_KEY.txt"
            var result = ""
            var key = ""
            try {
                // 将密钥从文件中读取出来
                val f = File(fileSource)
                key = f.readText()
                println("读取的密钥为：${key}")
            } catch (e1: Exception){e1.printStackTrace()}

            try {
                // 对数据进行加密
                result = HAMC.Companion.encryptHMAC(inputStr.toByteArray(), key)
                println("加密后的数据为：$result")
            } catch (e: Exception){e.printStackTrace()}
            return result
        }
    }
}

fun main(args: Array<String>){
    // main function
    val inputStr = "Uozoyo, Love U!"
    try {
        HAMC.Companion.getResult1(inputStr)
        HAMC.Companion.getResult2(inputStr)
    } catch (e: Exception){
        e.printStackTrace()
    }
}
