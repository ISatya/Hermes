package com.droid.hermes.teams.presentation.teamSearch

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droid.hermes.teams.domain.model.RequestState
import com.droid.hermes.teams.domain.usecase.SearchTeamUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * Created on 19/07/20.
 */
@ExperimentalCoroutinesApi
@FlowPreview
internal class TeamSearchViewModel @ViewModelInject constructor(
    private val searchTeam: SearchTeamUseCase
) : ViewModel() {

    private val _viewState = MutableLiveData<TeamSearchViewState>()
    val viewState : LiveData<TeamSearchViewState>
        get() = _viewState

    val searchQuery = MutableStateFlow<String>("")

    init {
        viewModelScope.launch {
            initializeIntentHandler()
        }
    }

    private suspend fun initializeIntentHandler(){
        searchQuery.debounce(500)
            .filter { it.isNotBlank() }
            .distinctUntilChanged()
            .flatMapLatest {
                flowOf(it).combine(searchTeam(it)){ searchText, requestState ->
                    Pair(searchText, requestState)
                }
            }.collect{(searchText, requestState)->
                when(requestState){
                    is RequestState.Started -> { _viewState.value = TeamSearchViewState.Loading }
                    is RequestState.Success -> {
                        if(requestState.data.isNotEmpty()){
                            _viewState.value = TeamSearchViewState.TeamsFound(requestState.data)
                        } else {
                            _viewState.value = TeamSearchViewState.NoTeamsFound(searchText)
                        }
                    }
                    is RequestState.ServerError -> {
                        _viewState.value = TeamSearchViewState.ServerError(requestState.errocCode)
                    }
                    is RequestState.NetworkError -> {
                        _viewState.value = TeamSearchViewState.NetworkError
                    }
                }!!
            }
    }

}