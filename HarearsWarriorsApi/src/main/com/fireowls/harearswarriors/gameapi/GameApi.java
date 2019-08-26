package com.fireowls.harearswarriors.gameapi;

import com.fireowls.harearswarriors.gameapi.game.GameManager;
import com.fireowls.harearswarriors.gameapi.system.commands.CommandManager;
import com.fireowls.harearswarriors.gameapi.system.events.EventManager;

/**
 * HarearsWarriosAPI contain all models class of the game
 * just like:
 * <ul>
 *     <li>cards models</li>
 *     <li>board models</li>
 *     <li>player models</li>
 *     <li>games models</li>
 *     <li>event system</li>
 *     <li>command system</li>
 *     <li>plugin gestion for server</li>
 * </ul>
 */
public class GameApi {

    private static GameManager gameManager;

    private static CommandManager commandManager;
    private static EventManager eventManager;

    /**
     * Constructor of The class they ara one instance of the class
     * for all game.
     */
    public GameApi() {
        gameManager = new GameManager();

        commandManager = new CommandManager();
        eventManager = new EventManager();
    }

    /**
     * Get the main instance of the GameManager
     * @return GameManager
     */
    public static GameManager getGameManager() {
        return gameManager;
    }

    /**
     * Get the main instance of the CommandManager
     * @return CommandManager
     */
    public static CommandManager getCommandManager() {
        return commandManager;
    }

    /**
     * Get the main instance of the EventManager
     * @return EventManager
     */
    public static EventManager getEventManager() {
        return eventManager;
    }

}