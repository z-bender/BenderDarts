package ru.bender.darts.desktop;

import ru.bender.darts.api.Game;
import ru.bender.darts.api.PlayerInGame;
import ru.bender.darts.api.PlayersInGameList;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by bender on 18.10.16.
 */
class GameTableFrame extends JFrame {

    private final static String WINDOW_TITLE = "Игра";
    private final Game game;
    private JPanel playersListPanel;

    public GameTableFrame(Game game) {
        this.game = game;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle(WINDOW_TITLE);
        makeGUI();
    }

    private void addPlayerPanel(PlayerInGame player) {
        playersListPanel.add(new PlayerPanel(player));
    }

    private void makeGUI() {
        //TODO

        ArrayList<PlayerInGame> players = game.playersList.getPlayers(PlayersInGameList.CompareBy.Number);

        playersListPanel = new JPanel();
        playersListPanel.setLayout(new BoxLayout(playersListPanel, BoxLayout.Y_AXIS));
        this.getContentPane().add(playersListPanel, BorderLayout.CENTER);
        players.forEach(player -> addPlayerPanel(player));
        this.setSize(500, 500);
        this.setVisible(true);
    }
}
