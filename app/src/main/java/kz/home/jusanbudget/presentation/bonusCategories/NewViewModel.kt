package kz.home.jusanbudget.presentation.bonusCategories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kz.home.jusanbudget.domain.Repository

class NewViewModel(
    private val repository: Repository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    fun getAllBonus(): String {
        var x = ""
        viewModelScope.launch(ioDispatcher) {
            x = repository.getBonus()
        }
        return x
    }
}