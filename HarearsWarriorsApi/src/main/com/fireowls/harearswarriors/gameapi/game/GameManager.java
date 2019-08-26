package com.fireowls.harearswarriors.gameapi.game;

import java.util.ArrayList;
import java.util.List;

/**
 * This the class for access to all games
 */
public class GameManager {

    private ArrayList<Game> games;

    /**
     * Constructor of the class.
     * For get the main instance of the class,
     * you need to use the <code>GameApi</code> class.
     */
    public GameManager() {
        games = new ArrayList<Game>();
    }

    /**
     * Get the list of all games
     * @return all games
     */
    public List<Game> getAllGames() {
        return games;
    }

}
