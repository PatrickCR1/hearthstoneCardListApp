package com.example.hearthstonelist.di.modules

import com.example.hearthstonelist.service.repository.CardRepository
import com.example.hearthstonelist.service.repository.CardService
import com.example.hearthstonelist.service.repository.RetrofitClient
import com.example.hearthstonelist.ui.adapter.CardsAdapter
import com.example.hearthstonelist.ui.viewmodel.CardListViewModel
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val hearthstoneWebClientModules = module {
    single<OkHttpClient> {
        RetrofitClient.getHttpClientInstance()
    }
    single<Retrofit> {
        RetrofitClient.getRetrofitInstance(get())
    }
    single<CardService> { get<Retrofit>().create(CardService::class.java) }
}

val hearthstoneRepositoryModules = module {
    single<CardRepository> { CardRepository(get(), androidContext()) }
}

val hearthstoneViewModelModules = module {
    viewModel<CardListViewModel> { CardListViewModel(get()) }
}

val hearthstoneAdapterModules = module {
    factory { CardsAdapter(androidContext()) }
}
