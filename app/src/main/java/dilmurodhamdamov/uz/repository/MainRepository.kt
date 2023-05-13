package dilmurodhamdamov.uz.repository

import androidx.lifecycle.MutableLiveData
import dilmurodhamdamov.uz.api.NetworkClient
import dilmurodhamdamov.uz.model.PhotoModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class MainRepository {
    val api = NetworkClient.getClientInstance()
    var compositeDisposable = CompositeDisposable()

    fun getPhotoList(
        error: MutableLiveData<String>,
        progress: MutableLiveData<Boolean>,
        data: MutableLiveData<List<PhotoModel>>,
    ) {
        compositeDisposable.add(api.getPhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                progress.value = true
            }.doOnComplete {
                progress.value = false
            }.subscribeWith(object : DisposableObserver<List<PhotoModel>>() {
                override fun onNext(t: List<PhotoModel>) {
                    data.value = t
                }

                override fun onError(e: Throwable) {
                    error.value = e.localizedMessage
                }

                override fun onComplete() {
                    //
                }
            })
        )
    }
}