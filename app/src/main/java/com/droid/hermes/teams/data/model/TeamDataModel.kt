package com.droid.hermes.teams.data.model

import com.droid.hermes.teams.domain.model.TeamDomainModel
import com.squareup.moshi.Json

/**
 * Created on 19/07/20.
 */
internal data class TeamDataModel(@Json(name="idTeam") val id : String,
                                  @Json(name="strTeam") val name : String,
                                  @Json(name="strLeague") val league : String,
                                  @Json(name="idLeague") val leagueId : String,
                                  @Json(name="strDescriptionEN") val descriptionEn : String?,
                                  @Json(name="strTeamBadge") val badgeUrl: String?,
                                  @Json(name="strTeamJersey") val jerseyUrl: String?,
                                  @Json(name="strTeamLogo") val logoUrl: String?)

internal fun TeamDataModel.toDomainModel()
        = TeamDomainModel(id, name, league, leagueId, descriptionEn, badgeUrl, jerseyUrl, logoUrl)