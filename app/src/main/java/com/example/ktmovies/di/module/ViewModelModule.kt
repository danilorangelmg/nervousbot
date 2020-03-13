package com.example.ktmovies.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ktmovies.di.factory.ViewModelProviderFactory
import com.example.ktmovies.ui.chat.ChatViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory?

    @Binds
    @IntoMap
    @ViewModelKey(ChatViewModel::class)
    abstract fun bindLoginViewModel(viewModel: ChatViewModel?): ViewModel?
}
