package com.nicolaspetras.splfantasy.model.fantasyteam

class FantasyTeamPicks(
    val playerName: String,
    val group: FantasyTeamGroup,
    val soloPick: SplPlayer,
    val junglePick: SplPlayer,
    val midPick: SplPlayer,
    val supportPick: SplPlayer,
    val hunterPick: SplPlayer
) {
}