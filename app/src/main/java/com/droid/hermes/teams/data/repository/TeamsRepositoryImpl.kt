package com.droid.hermes.teams.data.repository

import com.droid.hermes.teams.data.model.toDomainModel
import com.droid.hermes.teams.data.network.service.TeamsService
import com.droid.hermes.teams.domain.model.RequestState
import com.droid.hermes.teams.domain.model.TeamDomainModel
import com.droid.hermes.teams.domain.repository.TeamsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

/**
 * Created on 19/07/20.
 */
internal class TeamsRepositoryImpl @Inject constructor(private val teamsService: TeamsService) : TeamsRepository {

    override fun searchTeam(teamName : String) : Flow<RequestState<List<TeamDomainModel>>> {
        return flow<RequestState<List<TeamDomainModel>>> {
            emit(RequestState.Started())
            try {
                val response = teamsService.searchTeam(teamName)
                if(response.isSuccessful){
                    response.body()?.teams?.let{
                        emit(RequestState.Success(it.map { dataModel -> dataModel.toDomainModel() }))
                    } ?: emit(RequestState.Success(emptyList()))
                } else {
                    emit(RequestState.ServerError(response.code(), response.message()))
                }
            } catch (io : IOException){
                emit(RequestState.NetworkError())
            }
        }.flowOn(Dispatchers.IO)
    }

}