package dilmurodhamdamov.uz.api


import dilmurodhamdamov.uz.model.PhotoModel
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("photoss")
    suspend fun getPhotos(): Response<List<PhotoModel>>
}