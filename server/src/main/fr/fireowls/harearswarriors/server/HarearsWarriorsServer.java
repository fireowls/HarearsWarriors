package fr.fireowls.harearswarriors.server;

import fr.fireowls.harearswarriors.harearsapi.GameApi;

import java.io.File;

public class HarearsWarriorsServer {

    public static void main(String[] args) {

        System.out.println("hello, world");
        GameApi gameApi = new GameApi();
        System.out.println(gameApi.getGameManager().getAllGames().toArray());
        new File("test").mkdirs();

    }

}