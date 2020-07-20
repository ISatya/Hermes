package com.droid.hermes.teams.presentation.teamSearch

import com.droid.hermes.teams.domain.model.TeamDomainModel

/**
 * Created on 19/07/20.
 */
internal sealed class TeamSearchViewState {

    object Loading : TeamSearchViewState()

    data class NoTeamsFound(val errorMessage : String) : TeamSearchViewState()

    object NetworkError : TeamSearchViewState()

    data class TeamsFound(val teams : List<TeamDomainModel>) : TeamSearchViewState()

    data class ServerError(val errorCode: Int) : TeamSearchViewState()

}