package com.nicolaspetras.splfantasy.api

import com.nicolaspetras.splfantasy.SplFantasyManager
import com.nicolaspetras.splfantasy.model.fantasyteam.FantasyTeamPicks
import com.nicolaspetras.splfantasy.model.SmiteRole
import com.nicolaspetras.splfantasy.model.fantasyteam.SplPlayer
import com.nicolaspetras.splfantasy.model.SplTeamName
import com.nicolaspetras.splfantasy.model.api.FantasyTeamApiData
import com.nicolaspetras.splfantasy.model.fantasyteam.FantasyTeamGroup
import com.nicolaspetras.splfantasy.service.scorer.Scorer
import com.nicolaspetras.splfantasy.service.scorer.teams.FantasyTeamScorer
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SplFantasyApi() {

    final val scorer = Scorer()
    private final val fantasyTeamDrafts = arrayListOf<FantasyTeamPicks>(
        FantasyTeamPicks(
            "Xenico",
            FantasyTeamGroup.AO_KUANG,
            SplPlayer("SOLOORTROLL", SplTeamName.TITAN, SmiteRole.SOLO),
            SplPlayer("SCREAM", SplTeamName.JADE, SmiteRole.JUNGLE),
            SplPlayer("PAUL", SplTeamName.TITAN, SmiteRole.MID),
            SplPlayer("RONNGYU", SplTeamName.LVTHN, SmiteRole.SUPPORT),
            SplPlayer("JARCORR", SplTeamName.KINGS, SmiteRole.HUNTER)
        ),
        FantasyTeamPicks(
            "Outso",
            FantasyTeamGroup.AO_KUANG,
            SplPlayer("DEATHWALKER", SplTeamName.MAMBO, SmiteRole.SOLO),
            SplPlayer("QVOFRED", SplTeamName.ONI, SmiteRole.JUNGLE),
            SplPlayer("BIGMANTINGZ", SplTeamName.KINGS, SmiteRole.MID),
            SplPlayer("NEILMAH", SplTeamName.ONI, SmiteRole.SUPPORT),
            SplPlayer("ECHROME", SplTeamName.MAMBO, SmiteRole.HUNTER)
        ),
        FantasyTeamPicks(
            "LordLysander",
            FantasyTeamGroup.AO_KUANG,
            SplPlayer("VARIETY", SplTeamName.KINGS, SmiteRole.SOLO),
            SplPlayer("CAPTAINTWIG", SplTeamName.KINGS, SmiteRole.JUNGLE),
            SplPlayer("SHEENTO", SplTeamName.LVTHN, SmiteRole.MID),
            SplPlayer("PBM", SplTeamName.JADE, SmiteRole.SUPPORT),
            SplPlayer("VOTE", SplTeamName.ONI, SmiteRole.HUNTER)
        ),
        FantasyTeamPicks(
            "Sped",
            FantasyTeamGroup.AO_KUANG,
            SplPlayer("FINEOKAY", SplTeamName.JADE, SmiteRole.SOLO),
            SplPlayer("PANITOM", SplTeamName.LVTHN, SmiteRole.JUNGLE),
            SplPlayer("VENENU", SplTeamName.BOLTS, SmiteRole.MID),
            SplPlayer("GENETICS", SplTeamName.KINGS, SmiteRole.SUPPORT),
            SplPlayer("PANDACAT", SplTeamName.JADE, SmiteRole.HUNTER)
        ),
        FantasyTeamPicks(
            "Lochie",
            FantasyTeamGroup.AO_KUANG,
            SplPlayer("HADDIX", SplTeamName.LVTHN, SmiteRole.SOLO),
            SplPlayer("DZONI", SplTeamName.MAMBO, SmiteRole.JUNGLE),
            SplPlayer("PEGON", SplTeamName.JADE, SmiteRole.MID),
            SplPlayer("TRIXTANK", SplTeamName.MAMBO, SmiteRole.SUPPORT),
            SplPlayer("ZAPMAN", SplTeamName.LVTHN, SmiteRole.HUNTER)
        ),
        FantasyTeamPicks(
            "Merandus",
            FantasyTeamGroup.BAKASURA,
            SplPlayer("", SplTeamName.JADE, SmiteRole.SOLO),
            SplPlayer("", SplTeamName.KINGS, SmiteRole.JUNGLE),
            SplPlayer("", SplTeamName.TITAN, SmiteRole.MID),
            SplPlayer("", SplTeamName.MAMBO, SmiteRole.SUPPORT),
            SplPlayer("", SplTeamName.LVTHN, SmiteRole.HUNTER)
        ),
        FantasyTeamPicks(
            "Threadus",
            FantasyTeamGroup.BAKASURA,
            SplPlayer("", SplTeamName.KINGS, SmiteRole.SOLO),
            SplPlayer("", SplTeamName.LVTHN, SmiteRole.JUNGLE),
            SplPlayer("", SplTeamName.LVTHN, SmiteRole.MID),
            SplPlayer("", SplTeamName.KINGS, SmiteRole.SUPPORT),
            SplPlayer("", SplTeamName.TITAN, SmiteRole.HUNTER)
        ),
        FantasyTeamPicks(
            "Bazilias",
            FantasyTeamGroup.BAKASURA,
            SplPlayer("", SplTeamName.MAMBO, SmiteRole.SOLO),
            SplPlayer("", SplTeamName.RAVEN, SmiteRole.JUNGLE),
            SplPlayer("", SplTeamName.RAVEN, SmiteRole.MID),
            SplPlayer("", SplTeamName.ONI, SmiteRole.SUPPORT),
            SplPlayer("", SplTeamName.JADE, SmiteRole.HUNTER)
        ),
        FantasyTeamPicks(
            "King",
            FantasyTeamGroup.BAKASURA,
            SplPlayer("", SplTeamName.LVTHN, SmiteRole.SOLO),
            SplPlayer("", SplTeamName.JADE, SmiteRole.JUNGLE),
            SplPlayer("", SplTeamName.KINGS, SmiteRole.MID),
            SplPlayer("", SplTeamName.LVTHN, SmiteRole.SUPPORT),
            SplPlayer("", SplTeamName.KINGS, SmiteRole.HUNTER)
        ),
        FantasyTeamPicks(
            "Dawzy",
            FantasyTeamGroup.BAKASURA,
            SplPlayer("", SplTeamName.TITAN, SmiteRole.SOLO),
            SplPlayer("", SplTeamName.MAMBO, SmiteRole.JUNGLE),
            SplPlayer("", SplTeamName.JADE, SmiteRole.MID),
            SplPlayer("", SplTeamName.JADE, SmiteRole.SUPPORT),
            SplPlayer("", SplTeamName.ONI, SmiteRole.HUNTER)
        ),
    )
    private final val fantasyScorer = FantasyTeamScorer(fantasyTeamDrafts)

    val splFantasyManager = SplFantasyManager(scorer = scorer, fantasyTeamScorer = fantasyScorer)

    @CrossOrigin
    @GetMapping("/scores")
    fun getScores(): ArrayList<FantasyTeamApiData> {
        return splFantasyManager.getFantasyApiData()
    }
}