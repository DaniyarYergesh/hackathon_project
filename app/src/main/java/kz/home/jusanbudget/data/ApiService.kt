package kz.home.jusanbudget.data

import retrofit2.http.*

interface ApiService {
    @POST("auth")
    suspend fun authUser(@Body login: AuthenticationRequest)

    @POST("register")
    suspend fun registerUser(@Body login: AuthenticationRequest)

    @GET("user/get-bonus")
    suspend fun getBonus(): String

    @GET("user/games")
    suspend fun getGames(): GamesResponse

}