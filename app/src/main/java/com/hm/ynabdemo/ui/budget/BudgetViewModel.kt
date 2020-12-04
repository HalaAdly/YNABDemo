package com.hm.ynabdemo.ui.budget

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hm.ynabdemo.data.DataRepository
import com.hm.ynabdemo.data.dto.budgets.BudgetItem
import javax.inject.Inject

class BudgetViewModel @Inject constructor(
    private val repo: DataRepository
) : ViewModel() {
fun openBudgetDetails(item: BudgetItem) {

}
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}