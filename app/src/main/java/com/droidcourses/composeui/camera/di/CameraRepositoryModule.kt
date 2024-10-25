package com.droidcourses.composeui.camera.di

import com.droidcourses.composeui.camera.data.CameraRepositoryImpl
import com.droidcourses.composeui.camera.domain.CameraRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CameraRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindCameraRepository(cameraRepositoryImpl: CameraRepositoryImpl): CameraRepository
}