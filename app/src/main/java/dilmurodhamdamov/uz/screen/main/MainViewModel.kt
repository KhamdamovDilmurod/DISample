package dilmurodhamdamov.uz.screen.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dilmurodhamdamov.uz.api.NetworkClient
import dilmurodhamdamov.uz.model.PhotoModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel: ViewModel() {
    private var compositeDisposable = CompositeDisposable()

    var error = MutableLiveData<String>()
    var progress = MutableLiveData<Boolean>()
    var photoListData = MutableLiveData<List<PhotoModel>>()

    fun getPhotoList(){
        compositeDisposable.clear()
        compositeDisposable.add(
            NetworkClient.getClientInstance().getPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {  }
                .doOnComplete {  }
                .subscribeWith(object: DisposableObserver<List<PhotoModel>>(){
                    override fun onNext(t: List<PhotoModel>) {
                        photoListData.value = t
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