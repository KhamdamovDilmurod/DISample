package dilmurodhamdamov.uz.api


import dilmurodhamdamov.uz.model.PhotoModel
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("photos")
    suspend fun getPhotos(): Response<List<PhotoModel>>
}