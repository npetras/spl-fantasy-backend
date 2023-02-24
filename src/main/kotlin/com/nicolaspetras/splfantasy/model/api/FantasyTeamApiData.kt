package com.nicolaspetras.splfantasy.model.api

import com.nicolaspetras.splfantasy.model.fantasyteam.FantasyTeamGroup

data class FantasyTeamApiData(
    val fantasyPlayerName: String,
    val fantasyTeamGroup: String,
    val solo: String,
    val soloScore: Double,
    val jungle: String,
    val jungleScore: Double,
    val mid: String,
    val midScore: Double,
    val support: String,
    val supportScore: Double,
    val hunter: String,
    val hunterScore: Double,
    val totalTeamScore: Double
)
