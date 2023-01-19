package com.example.hearthstonelist.viewModelTests

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.hearthstonelist.cardListSample
import com.example.hearthstonelist.emptyCardModelSample
import com.example.hearthstonelist.getOrAwaitValue
import com.example.hearthstonelist.service.repository.CardRepository
import com.example.hearthstonelist.stringSample
import com.example.hearthstonelist.ui.viewmodel.CardListViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CardListViewModelTests {

    lateinit var viewModel: CardListViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        viewModel = CardListViewModel(repository = cardRepository, context = InstrumentationRegistry.getInstrumentation().targetContext)
    }
    val cardRepository =mockk<CardRepository>()

    @Test
    fun listenerOnSuccessShouldChangeLiveDataValue() {

        //Act
        viewModel.listener.onSuccess(cardListSample)

        val returnedValue = viewModel.cards.getOrAwaitValue()

        //Assert
        Assert.assertEquals(cardListSample, returnedValue)
    }

    @Test
    fun listenerOnFailureShouldChangeLiveDataValue() {

        //Act
        viewModel.listener.onFailure(stringSample)

        val returnedValue =viewModel.toastMessage.getOrAwaitValue()

        //Assert
        Assert.assertEquals(stringSample, returnedValue)
    }

    @Test
    fun listFunctionShouldCallRepository() = runBlocking {

        // Arrange
        coEvery { cardRepository.listAll(any()) } returns Unit

        //Act
        viewModel.list()

        //Assert
        coVerify {
            cardRepository.listAll(any())
        }
    }

    @Test
    fun listClassFunctionShouldCallRepository() = runBlocking {

        // Arrange
        coEvery { cardRepository.listClass(any(), any()) } returns Unit

        //Act
        viewModel.listClass(stringSample)

        //Assert
        coVerify {
            cardRepository.listClass(any(), any())
        }
    }

    @Test
    fun navigationShouldChangeLiveDataValue() {

        //Act
        viewModel.navigate(emptyCardModelSample)

        val returnedValue = viewModel.clickCard.getOrAwaitValue()

        //Assert
        Assert.assertEquals(emptyCardModelSample, returnedValue)
    }

    @Test
    fun resetToastValueShouldChangeLiveDataValue() {

        //Act
        viewModel.resetToastValue()

        val returnedValue = viewModel.toastMessage.getOrAwaitValue()

        //Assert
        Assert.assertEquals("", returnedValue)
    }
}
