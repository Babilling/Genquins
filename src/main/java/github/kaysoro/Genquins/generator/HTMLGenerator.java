package github.kaysoro.Genquins.generator;

import github.kaysoro.Genquins.payload.ResponseNode;

import static j2html.TagCreator.tr;

public class HTMLGenerator {

    public static String generateTree(ResponseNode node){
        //TODO
        return tr().withText(node.getTournament() != null ? node.getTournament().getName() : "null").renderFormatted();
    }

    public static String generateLadder(ResponseNode node){
        //TODO
        return tr().withText(node.getTournament() != null ? node.getTournament().getName() : "null").renderFormatted();
    }
}
