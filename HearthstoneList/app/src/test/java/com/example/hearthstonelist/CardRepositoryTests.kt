package com.example.hearthstonelist

import com.example.hearthstonelist.service.listener.APIListener
import com.example.hearthstonelist.service.model.apimodel.CardListModel
import com.example.hearthstonelist.service.model.apimodel.CardModelApi
import com.example.hearthstonelist.service.model.domainmodel.CardModel
import com.example.hearthstonelist.service.repository.CardRepository
import com.example.hearthstonelist.service.repository.CardService
import com.example.hearthstonelist.service.toCardModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class CardRepositoryTests {

    lateinit var cardRepository: CardRepository

    @Before
    fun setup() {
        cardRepository = CardRepository(webService)
    }

    val webService = mockk<CardService>()
    val listener = mockk<APIListener<List<CardModel?>>>()
    val mockResponseAll = mockk<CardListModel>()
    val mockResponseClass = mockk<List<CardModelApi>>()

    @Test
    fun listAllShouldCallOnSucesssWithCode200() = runBlocking {
        // Arrange

        var apiList = arrayListOf<CardModelApi?>()
        apiList.addAll(cardListApiSample)
        val allCardList: List<CardModel?> = apiList.map { it?.toCardModel() }

        coEvery { webService.listAll() } returns Response.success(cardListModelSample)
        coEvery { listener.onSuccess(any()) } returns Unit

        // Act
        cardRepository.listAll(listener)
        // Assert
        Assert.assertTrue((allCardList.isNotEmpty()))
        coVerify {
            listener.onSuccess(emptyCardListSample)
        }
    }

    @Test
    fun listAllShouldCallOnFailureWithCodeNot200() = runBlocking {
        // Arrange

        coEvery { webService.listAll() } returns Response.success(205, mockResponseAll)
        coEvery { listener.onFailure(any()) } returns Unit

        // Act
        cardRepository.listAll(listener)
        // Assert
        coVerify {
            listener.onFailure(null)
        }
    }

    @Test
    fun listAllShouldCallOnFailureWhenResponseIsNotSucessful() = runBlocking {
        // Arrange
        coEvery { webService.listAll() } returns Response.error(404, mockk())
        coEvery { listener.onFailure(null) } returns Unit

        // Act
        cardRepository.listAll(listener)
        // Assert
        coVerify {
            listener.onFailure(null)
        }
    }

    @Test
    fun listClassShouldCallOnSucesssWithCode200() = runBlocking {
        // Arrange
        coEvery { webService.listClass(any()) } returns Response.success(emptyCardListApiSample)
        coEvery { listener.onSuccess(any()) } returns Unit

        // Act
        cardRepository.listClass(stringSample, listener)
        // Assert
        coVerify {
            listener.onSuccess(emptyCardListSample)
        }
    }

    @Test
    fun listClassShouldCallOnFailureWithCodeNot200() = runBlocking {
        // Arrange

        coEvery { webService.listClass(any()) } returns Response.success(205, mockResponseClass)
        coEvery { listener.onFailure(any()) } returns Unit

        // Act
        cardRepository.listClass(stringSample, listener)
        // Assert
        coVerify {
            listener.onFailure(null)
        }
    }

    @Test
    fun listClassShouldCallOnFailureWhenResponseIsNotSucessful() = runBlocking {
        // Arrange
        coEvery { webService.listClass(any()) } returns Response.error(404, mockk())
        coEvery { listener.onFailure(null) } returns Unit

        // Act
        cardRepository.listClass(stringSample, listener)
        // Assert
        coVerify {
            listener.onFailure(null)
        }
    }
}
