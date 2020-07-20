package com.droid.hermes.teams.presentation.teamSearch.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.droid.hermes.R
import com.droid.hermes.databinding.ItemTeamSearchResultBinding
import com.droid.hermes.teams.domain.model.TeamDomainModel

/**
 * Created on 19/07/20.
 */
internal class TeamSearchResultAdapter : ListAdapter<TeamDomainModel,
        TeamSearchResultAdapter.TeamSearchResultViewHolder>(DIFF_CALLBACK){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TeamSearchResultViewHolder(
            ItemTeamSearchResultBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: TeamSearchResultViewHolder, position: Int) =
        holder.onBind(getItem(position))

    internal class TeamSearchResultViewHolder(val binding : ItemTeamSearchResultBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun onBind(teamSearchResult : TeamDomainModel){
            binding.teamNameTv.text = teamSearchResult.name
            binding.teamLogoIv.load(teamSearchResult.badgeUrl){
                placeholder(R.drawable.ic_baseline_sports_soccer_24)
            }
        }

    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TeamDomainModel>() {
            override fun areItemsTheSame(oldItem: TeamDomainModel, newItem: TeamDomainModel): Boolean =
                oldItem.id == newItem.id

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: TeamDomainModel, newItem: TeamDomainModel): Boolean =
                oldItem == newItem
        }
    }

}