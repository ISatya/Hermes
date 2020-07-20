package com.droid.hermes.teams

import com.droid.hermes.teams.data.network.service.TeamsService
import com.droid.hermes.teams.data.repository.TeamsRepositoryImpl
import com.droid.hermes.teams.domain.repository.TeamsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

/**
 * Created on 19/07/20.
 */
@InstallIn(ActivityComponent::class)
@Module
internal class TeamModule {

    @Provides
    fun providesTeamsService(retrofit : Retrofit) = retrofit.create(TeamsService::class.java)

    @Provides
    fun providesTeamsRepository(service: TeamsService) : TeamsRepository  = TeamsRepositoryImpl(service)

}