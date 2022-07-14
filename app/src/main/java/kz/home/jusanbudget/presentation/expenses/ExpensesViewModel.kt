package kz.home.jusanbudget.presentation.expenses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kz.home.jusanbudget.data.AuthenticationRequest
import kz.home.jusanbudget.data.login
import kz.home.jusanbudget.data.password
import kz.home.jusanbudget.domain.Repository

class ExpensesViewModel(
    private val repository: Repository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    fun authorization() {
        val job = viewModelScope.launch(ioDispatcher) {
            repository.authUser(AuthenticationRequest(login, password))
        }

        runBlocking {
            job.join()
        }

        //Log.e("", getAllBonus())
    }

    fun getAllBonus(): String {
        var x = ""
        viewModelScope.launch(ioDispatcher) {
            x = repository.getBonus()
        }
        return x
    }

    /*fun getGames(): GamesResponse{
        var c
        viewModelScope.launch(ioDispatcher) {
            val c = repository.getGames()
        }
        return
    }*/

    fun register() {
        viewModelScope.launch(ioDispatcher) {
            repository.registerUser(AuthenticationRequest(login, password))
        }
    }

}