package com.nicolaspetras.splfantasy.model.fantasyteam

import com.nicolaspetras.splfantasy.model.score.SplPlayerSeasonScore

class SplFantasyTeamScores(
    val playerName: String,
    val group: FantasyTeamGroup,
    val solo: SplPlayerSeasonScore,
    val jungle: SplPlayerSeasonScore,
    val mid: SplPlayerSeasonScore,
    val support: SplPlayerSeasonScore,
    val hunter: SplPlayerSeasonScore
) {
    fun overallTeamScore(): Double {
        return solo.overallSeasonScore() +
                jungle.overallSeasonScore() +
                mid.overallSeasonScore() +
                support.overallSeasonScore() +
                hunter.overallSeasonScore()
    }
}