package com.droid.hermes.teams.domain.usecase

import com.droid.hermes.teams.domain.model.RequestState
import com.droid.hermes.teams.domain.model.TeamDomainModel
import com.droid.hermes.teams.domain.model.isValid
import com.droid.hermes.teams.domain.repository.TeamsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created on 19/07/20.
 */
internal class SearchTeamUseCase @Inject constructor(private val teamsRepository: TeamsRepository) {

    operator fun invoke(teamName : String) : Flow<RequestState<List<TeamDomainModel>>> {
        return teamsRepository.searchTeam(teamName).map { requestState ->
            var updatedState = requestState
            when(requestState){
                is RequestState.Success -> {
                    if(requestState.data.isNotEmpty()){
                        //filter teams which do not have required properties
                        //ideally server should not return teams with incomplete data
                        updatedState = RequestState.Success(
                            requestState.data.filter { teamDomainModel -> teamDomainModel.isValid()})
                    }
                }
            }
            updatedState
        }
    }

}