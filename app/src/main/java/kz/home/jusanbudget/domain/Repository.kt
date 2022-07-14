package kz.home.jusanbudget.domain

import kz.home.jusanbudget.data.AuthenticationRequest
import kz.home.jusanbudget.data.GamesResponse

interface Repository {

    suspend fun authUser(login: AuthenticationRequest)

    suspend fun registerUser(login: AuthenticationRequest)

    suspend fun getBonus(): String

    suspend fun getGames(): GamesResponse
}