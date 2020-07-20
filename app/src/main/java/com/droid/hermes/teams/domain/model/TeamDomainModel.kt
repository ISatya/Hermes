package com.droid.hermes.teams.domain.model

/**
 * Created on 19/07/20.
 */
internal class TeamDomainModel(val id : String,
                               val name : String,
                               val league : String,
                               val leagueId : String,
                               val descriptionEn : String?,
                               val badgeUrl: String?,
                               val jerseyUrl: String?,
                               val logoUrl: String?)

internal fun TeamDomainModel.isValid() = !listOf(descriptionEn, badgeUrl).any {it == null}



