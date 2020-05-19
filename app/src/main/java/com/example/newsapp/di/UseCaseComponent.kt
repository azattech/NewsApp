package com.example.newsapp.di

import com.example.newsapp.network.NewsUseCase
import dagger.Component


/*************************
 * Created by AZAT SAYAN *
 *                       *
 * Contact: @theazat     *
 *                       *
 * 19/05/2020 - 11:52 AM  *
 ************************/
@Component(modules = [ApiModule::class])
interface UseCaseComponent {

    fun inject(newsUseCase: NewsUseCase)
}