package kz.home.jusanbudget.presentation.analytics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.home.jusanbudget.domain.Category
import kz.home.jusanbudget.utils.categoriesData

class FutureViewModel():ViewModel() {

    private var data = categoriesData
    private val _categoryList = MutableLiveData<List<Category>>(data)
    val categoryList: LiveData<List<Category>> = _categoryList

    fun addNewCategory(newCategory:Category){
        data.add(newCategory)
        _categoryList.value = data
    }

    fun deleteCategory(category:Category){
        data.remove(category)
        _categoryList.value = data
    }
}