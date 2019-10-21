package fr.fireowls.harearswarriors.basicplugin;

import fr.fireowls.harearswarriors.harearsapi.GameApi;
import fr.fireowls.harearswarriors.harearsapi.plugin.HWPlugin;

public class BasicPlugin extends HWPlugin {

    private GameApi api;

    @Override
    public void onLoad(GameApi gameApi) {
        System.out.println("loaded");
        api = gameApi;
    }

    @Override
    public void onStart() {
        System.out.println("start");
        api.getGameManager().getAllGames();
    }

    @Override
    public void onStop() {
        System.out.println("stop");
    }
}
