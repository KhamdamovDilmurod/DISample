package dilmurodhamdamov.uz.screen.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dilmurodhamdamov.uz.api.NetworkClient
import dilmurodhamdamov.uz.model.PhotoModel
import dilmurodhamdamov.uz.repository.MainRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel: ViewModel() {
    val repository = MainRepository()

    private var _error = MutableLiveData<String>()
    var error : LiveData<String> = _error
    private var _progress = MutableLiveData<Boolean>()
    var progress: LiveData<Boolean> = _progress
    private var _photoListData = MutableLiveData<List<PhotoModel>>()
    var photoListData: LiveData<List<PhotoModel>> = _photoListData

    fun getPhotoList(){
        repository.getPhotoList(_error, _progress, _photoListData)
    }

}