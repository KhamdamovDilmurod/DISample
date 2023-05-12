package dilmurodhamdamov.uz.api


import dilmurodhamdamov.uz.model.PhotoModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface Api {
    @GET("photos")
    fun getPhotos(): Observable<List<PhotoModel>>
}