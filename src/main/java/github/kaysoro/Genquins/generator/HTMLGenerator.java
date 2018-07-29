package github.kaysoro.Genquins.generator;

import github.kaysoro.Genquins.payload.Match;
import github.kaysoro.Genquins.payload.ResponseNode;
import github.kaysoro.Genquins.payload.Team;
import j2html.tags.ContainerTag;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static j2html.TagCreator.*;

public class HTMLGenerator {

    public static String generateTree(ResponseNode node) {
        //Map<id, name> des différentes équipes
        Map<String, String> teams = node.getTournament().getTeams().stream()
                .map(map -> map.values().stream().findFirst().orElse(Team.NONE))
                .collect(Collectors.toMap(Team::getId, Team::getName));

        // On ne récupère que les matches en état ouvert ou terminé de la ronde la plus récente
        List<Match> matches = node.getTournament().getMatches().stream()
                .map(map -> map.values().stream().findFirst().orElse(Match.NONE))
                .filter(match -> !match.getState().equals(Match.STATE_PENDING))
                .collect(Collectors.toList());

        int currentRound = matches.stream().map(Match::getRoundNumber).max(Integer::compare).orElse(1);
        matches = matches.stream()
                .filter(match -> match.getRoundNumber() == currentRound)
                .collect(Collectors.toList());

        ContainerTag matchesToPlay = table().with(tr().with(h2().withText("Matchs à jouer")));
        ContainerTag matchesPlayed = table().with(tr().with(h2().withText("Matchs joués")));
        for (Match match : matches) {
            if (match.getState().equals(Match.STATE_COMPLETE))
                matchesPlayed.with(tr()
                        .with(td(teams.get(match.getTeamId1()) + " VS " + teams.get(match.getTeamId2()) + " : "))
                        .with(td("Victoire de " + teams.get(match.getWinnerId()) + " par " + match.getScores()))
                );
            else
                matchesToPlay.with(tr(teams.get(match.getTeamId1()) + " VS " + teams.get(match.getTeamId2())));
        }

        return tr().with(matchesPlayed).with(matchesToPlay).renderFormatted();
    }

    public static String generateLadder(ResponseNode node) {
        //Map<id, Team> des différentes équipes
        Map<String, Team> teamsMap = node.getTournament().getTeams().stream()
                .map(map -> map.values().stream().findFirst().orElse(Team.NONE))
                .collect(Collectors.toMap(Team::getId, Function.identity()));

        // On ne récupère que les matches en état terminé de toutes les rondes joués (ou en cours)
        List<Match> matches = node.getTournament().getMatches().stream()
                .map(map -> map.values().stream().findFirst().orElse(Match.NONE))
                .filter(match -> match.getState().equals(Match.STATE_COMPLETE))
                .collect(Collectors.toList());

        for(Match match : matches){
            Team player1 = teamsMap.get(match.getTeamId1());
            Team player2 = teamsMap.get(match.getTeamId2());
            Team winner = teamsMap.get(match.getWinnerId());

            player1.setMatchNumber(player1.getMatchNumber() + 1);
            player2.setMatchNumber(player2.getMatchNumber() + 1);
            winner.setVictoryNumber(winner.getVictoryNumber() + 1);
            Matcher m = Pattern.compile("(\\d+)-(\\d+),(\\d+)-(\\d+)(,(\\d+)-(\\d+))?").matcher(match.getScores());
            if (m.matches()){
                int team1match1 = Integer.parseInt(m.group(1));
                int team2match1 = Integer.parseInt(m.group(2));
                int team1match2 = Integer.parseInt(m.group(3));
                int team2match2 = Integer.parseInt(m.group(4));
                int team1match3 = 0;
                int team2match3 = 0;
                if (m.group(5) != null){
                    team1match3 = Integer.parseInt(m.group(6));
                    team2match3 = Integer.parseInt(m.group(7));
                }
                player1.setGoalAverage(player1.getGoalAverage() + team1match1 + team1match2 + team1match3
                        - team2match1 - team2match2 - team2match3);
                player2.setGoalAverage(player2.getGoalAverage() + team2match1 + team2match2 + team2match3
                        - team1match1 - team1match2 - team1match3);
            }
        }

        // La récupération des données de match est faite, on génère le classement
        ContainerTag result = table().with(tr()
                .with(th("Equipe"))
                .with(th("Matchs"))
                .with(th("Victoires"))
                .with(th("Goal Average")))
                .attr("border", "1");
        teamsMap.values().stream()
                .sorted(Team::compareTeams)
                .collect(Collectors.toList()).forEach(team -> result.with(tr()
                .with(td(team.getName()))
                .with(td(String.valueOf(team.getMatchNumber())))
                .with(td(String.valueOf(team.getVictoryNumber()))
                .with(td(String.valueOf(team.getGoalAverage()))))
        ));

        return tr().withText("Classement").with(result).renderFormatted();
    }
}
