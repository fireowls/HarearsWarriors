package com.fireowls.harearswarriors;

import com.fireowls.harearswarriors.gameapi.GameApi;
import com.fireowls.harearswarriors.gameapi.plugin.HWPlugin;

public class HarearsWarriors extends HWPlugin {

    @Override
    public void onLoad(GameApi gameApi) {
        System.out.println("HarearsWarriors test is loaded !");
    }

    @Override
    public void onStart() {
        System.out.println("HarearsWarriors test is started !");
    }

    @Override
    public void onStop() {
        System.out.println("HarearsWarriors test is stoped !");
    }

}