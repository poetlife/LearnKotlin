  package network

import okhttp3.*
import java.io.IOException

class SynchronizationGet(url:String){
    // 同步get，会阻塞
    val client = OkHttpClient()  // instance
    val request = Request.Builder()
            .url(url)
            .build()

    fun connect(){
        val response = client.newCall(request).execute()
        // detection
        if (!response.isSuccessful){
            throw IOException("unexpected code" + response.code())
        }
        // headers
        val headers = response.headers()
        for (i in 0 until  headers.size()){
            // 左闭右开区间
            println(headers.name(i) + " " + headers.value(i))
        }
    }
}
class AsynchronizationGet(url:String){
    // 异步get，不会阻塞
    val client = OkHttpClient()
    val request = Request.Builder()
            .url(url)
            .build()
    fun connect(){
        // 异步执行的步骤
        client.newCall(request).enqueue(
                object: Callback{
                    override fun onFailure(p0: Call?, p1: IOException?) {
                        // when failure do something
                        println("failed to get response")
                    }

                    override fun onResponse(p0: Call?, p1: Response) {
                        val response= p1
                        if (!response.isSuccessful){
                            throw IOException("unexpected code" + response.code())
                        }
                        // headers
                        val headers = response.headers()
                        for (i in 0 until  headers.size()){
                            // 左闭右开区间
                            println(headers.name(i) + " " + headers.value(i))
                        }
                    }
                }
        )
    }
}
class StreamPost(url: String){
    // Post
    val requestBody = FormBody.Builder()
            .add("name", "Bill")
            .add("age", "30")
            .build()
    val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .build()
    val client = OkHttpClient()
    fun connect(){
        val response = client.newCall(request).execute()
        println(response.body()?.string())
    }
}
fun main(args: Array<String>){
    // main function
    val post = StreamPost("https://geekori.com")
    post.connect()
}
