package dilmurodhamdamov.uz.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {
    private var client: Api? = null
    fun initClient() {
        client = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(
                GsonConverterFactory.create()
            )
//            .addCallAdapterFactory(
//                RxJava3CallAdapterFactory.create()
//            )
            .build()
            .create(Api::class.java)
    }

    fun getClientInstance(): Api{
        if (client == null){
            initClient()
        }
        return client!!
    }
}