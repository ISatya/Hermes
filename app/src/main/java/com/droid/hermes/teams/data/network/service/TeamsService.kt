package com.droid.hermes.teams.data.network.service

import com.droid.hermes.teams.data.network.response.SearchTeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created on 19/07/20.
 */
internal interface TeamsService {

    @GET("searchteams.php/")
    suspend fun searchTeam(@Query("t") teamName : String): Response<SearchTeamResponse>

}