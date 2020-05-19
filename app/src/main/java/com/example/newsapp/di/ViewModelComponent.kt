package com.example.newsapp.di

import com.example.newsapp.network.NewsUseCase
import dagger.Component


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 12/04/2020 -3:13 PM   *
 ************************/

@Component(modules = [ApiModule::class])
interface ViewModelComponent {

    fun inject(newsUseCase: NewsUseCase)
}