package com.hm.ynabdemo.ui.home.budget

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hm.ynabdemo.data.DataRepository
import com.hm.ynabdemo.data.Resource
import com.hm.ynabdemo.data.dto.budgets.Budgets
import com.hm.ynabdemo.data.error.NETWORK_ERROR
import com.hm.ynabdemo.utils.InstantExecutorExtension
import com.hm.ynabdemo.utils.MainCoroutineRule
import com.hm.ynabdemo.utils.TestModelsGenerator
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExperimentalCoroutinesApi
@ExtendWith(InstantExecutorExtension::class)
class BudgetViewModelTest {
    // Subject under test
    private lateinit var budgetsListViewModel: BudgetViewModel

    // Use a fake UseCase to be injected into the viewModel
    private val dataRepository: DataRepository = mockk()

    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private val testModelsGenerator: TestModelsGenerator = TestModelsGenerator()

    @Before
    fun setUp() {
        // Create class under test
        // We initialise the repository with no tasks
    }

    @Test
    fun `get Budgets List`() {
        // Let's do an answer for the liveData
        val budgetsModel = testModelsGenerator.generateBudgets()

        //1- Mock calls
        coEvery { dataRepository.requestBudgets() } returns flow {
            emit(Resource.Success(budgetsModel))
        }

        //2-Call
        budgetsListViewModel = BudgetViewModel(dataRepository)
        budgetsListViewModel.getBudgets()
        //active observer for livedata
        budgetsListViewModel.budgetsLiveData.observeForever { }

        //3-verify
        val isEmptyList = budgetsListViewModel.budgetsLiveData.value?.data?.list.isNullOrEmpty()
        assertEquals(budgetsModel, budgetsListViewModel.budgetsLiveData.value?.data)
        Assert.assertEquals(false, isEmptyList)
    }

    @Test
    fun `get Budgets Empty List`() {
        // Let's do an answer for the liveData
        val budgetsModel = testModelsGenerator.generateBudgetsModelWithEmptyList()

        //1- Mock calls
        coEvery { dataRepository.requestBudgets() } returns flow {
            emit(Resource.Success(budgetsModel))
        }

        //2-Call
        budgetsListViewModel = BudgetViewModel(dataRepository)
        budgetsListViewModel.getBudgets()
        //active observer for livedata
        budgetsListViewModel.budgetsLiveData.observeForever { }

        //3-verify
        val isEmptyList = budgetsListViewModel.budgetsLiveData.value?.data?.list.isNullOrEmpty()
        assertEquals(budgetsModel, budgetsListViewModel.budgetsLiveData.value?.data)
        Assert.assertEquals(true, isEmptyList)
    }

    @Test
    fun `get Budgets Error`() {
        // Let's do an answer for the liveData
        val error: Resource<Budgets> = Resource.DataError(NETWORK_ERROR)

        //1- Mock calls
        coEvery { dataRepository.requestBudgets() } returns flow {
            emit(error)
        }

        //2-Call
        budgetsListViewModel = BudgetViewModel(dataRepository)
        budgetsListViewModel.getBudgets()
        //active observer for livedata
        budgetsListViewModel.budgetsLiveData.observeForever { }

        //3-verify
        assertEquals(NETWORK_ERROR, budgetsListViewModel.budgetsLiveData.value?.errorCode)
    }


}