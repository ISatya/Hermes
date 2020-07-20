package com.droid.hermes.teams.presentation.teamSearch

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.droid.hermes.R
import com.droid.hermes.databinding.FragmentTeamSearchBinding
import com.droid.hermes.teams.domain.model.TeamDomainModel
import com.droid.hermes.teams.presentation.teamSearch.adapters.TeamSearchResultAdapter
import com.droid.hermes.teams.presentation.teamSearch.itemDecoration.SearchResultPaddingDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_team_search.view.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

/**
 * Created on 19/07/20.
 */
@FlowPreview
@ExperimentalCoroutinesApi
@AndroidEntryPoint
internal class TeamSearchFragment : Fragment(R.layout.fragment_team_search){

    val viewModel: TeamSearchViewModel by viewModels()

    private var _binding : FragmentTeamSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var teamSearchResultAdapter: TeamSearchResultAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTeamSearchBinding.bind(view)

        addSearchTextChangedListener()
        initializeSearchResultsView()
        observeViewState()

    }

    private fun addSearchTextChangedListener(){
        binding.teamSearchEt.doAfterTextChanged {
            it?.toString()?.let {query ->
                viewModel.searchQuery.value = query
            }
        }
    }

    private fun initializeSearchResultsView(){
        teamSearchResultAdapter = TeamSearchResultAdapter()

        val dividerDecoration = DividerItemDecoration(requireContext(),
            LinearLayoutManager.VERTICAL)

        val paddingDecoration = SearchResultPaddingDecoration(
            resources.getDimensionPixelSize(R.dimen.spacing_xsmall))

        binding.teamsRv.apply {
            adapter = teamSearchResultAdapter
            addItemDecoration(dividerDecoration)
            addItemDecoration(paddingDecoration)
        }

    }

    private fun observeViewState(){
        viewModel.viewState.observe(viewLifecycleOwner, Observer{state ->
            when(state){
                is TeamSearchViewState.Loading -> {
                    clearSearchResults()
                    showLoader()
                }
                is TeamSearchViewState.TeamsFound -> showTeams(state.teams)
                is TeamSearchViewState.NoTeamsFound -> showNoTeamsFound(state.errorMessage)
                is TeamSearchViewState.ServerError -> onServerError(state.errorCode)
                is TeamSearchViewState.NetworkError -> onNetworkError()
            }!!
        })
    }

    private fun showLoader(){
        binding.content.displayedChild = 1
    }

    private fun showTeams(teamDataModels : List<TeamDomainModel>){
        teamSearchResultAdapter.submitList(teamDataModels)
        binding.content.displayedChild = 0
    }

    private fun clearSearchResults(){
        teamSearchResultAdapter.submitList(emptyList())
    }

    private fun showNoTeamsFound(searchText: String){
        binding.content.msg_Tv.text = getString(R.string.no_teams_found_message, searchText)
        binding.content.displayedChild = 2
    }

    private fun onServerError(errorCode: Int) {
        binding.content.msg_Tv.text = getString(R.string.server_error, errorCode)
        binding.content.displayedChild = 2
    }

    private fun onNetworkError(){
        binding.content.displayedChild = 3
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}