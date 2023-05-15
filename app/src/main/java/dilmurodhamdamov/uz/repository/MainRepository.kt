package dilmurodhamdamov.uz.repository

import dilmurodhamdamov.uz.api.NetworkClient
import dilmurodhamdamov.uz.model.sealed.DataResult
import dilmurodhamdamov.uz.repository.base_repository.BaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository: BaseRepository() {
    val api = NetworkClient.getClientInstance()

    suspend fun getPhotoList() = withContext(Dispatchers.IO){
        try {
            val response = api.getPhotos()
            return@withContext wrapResponse(response)
        } catch (e: Exception){
            return@withContext DataResult.Error(e.localizedMessage)
        }
    }
}