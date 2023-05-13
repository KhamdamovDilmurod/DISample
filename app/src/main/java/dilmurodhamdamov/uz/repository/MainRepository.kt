package dilmurodhamdamov.uz.repository

import android.provider.ContactsContract.Data
import androidx.lifecycle.MutableLiveData
import dilmurodhamdamov.uz.api.NetworkClient
import dilmurodhamdamov.uz.model.PhotoModel
import dilmurodhamdamov.uz.model.sealed.DataResult
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository {
    val api = NetworkClient.getClientInstance()
    var compositeDisposable = CompositeDisposable()

    suspend fun getPhotoList() = withContext(Dispatchers.IO){
        try {
            val response = api.getPhotos()
            if (response.isSuccessful){
                return@withContext DataResult.Success(response.body())
            } else{
                return@withContext DataResult.Error(response.message())
            }
        } catch (e: Exception){
            return@withContext DataResult.Error(e.localizedMessage)
        }
    }
}