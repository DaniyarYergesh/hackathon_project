package kz.home.jusanbudget.data

import kz.home.jusanbudget.domain.Repository
import retrofit2.Retrofit

const val login = "test"
const val password = "123"

class RepositoryImpl(retrofit: Retrofit) : Repository {
    private val apiService = retrofit.create(ApiService::class.java)

    override suspend fun authUser(login: AuthenticationRequest){
        apiService.authUser(login)
    }

    override suspend fun registerUser(login: AuthenticationRequest) {
        apiService.registerUser(login)
    }

    override suspend fun getBonus(): String {
        return apiService.getBonus()
    }

    override suspend fun getGames(): GamesResponse {
        return apiService.getGames()
    }
}