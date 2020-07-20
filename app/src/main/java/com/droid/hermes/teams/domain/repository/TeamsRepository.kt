package com.droid.hermes.teams.domain.repository

import com.droid.hermes.teams.domain.model.RequestState
import com.droid.hermes.teams.domain.model.TeamDomainModel
import kotlinx.coroutines.flow.Flow

/**
 * Created on 19/07/20.
 */
internal interface TeamsRepository {

    fun searchTeam(teamName : String) : Flow<RequestState<List<TeamDomainModel>>>

}