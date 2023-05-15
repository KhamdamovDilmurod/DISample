package dilmurodhamdamov.uz.repository.base_repository

import dilmurodhamdamov.uz.model.sealed.DataResult
import retrofit2.Response

open class BaseRepository {
    fun <T> wrapResponse(response: Response<T>): DataResult<T> {
        if (response.isSuccessful) {
            return DataResult.Success(response.body()!!)
        } else {
            var error = "unknown error"
            when (response.code()) {
                404 -> {
                    error = "404 url not found ${response.message()}"
                }
                401 -> {
                    error = "401 url not found ${response.message()}"
                }
                402 -> {
                    error = "402 url not found ${response.message()}"
                }
                405 -> {
                    error = "403 url not found ${response.message()}"
                }
            }
            return DataResult.Error(error)
        }
    }
}