package ru.bender.darts.desktop;

import ru.bender.darts.api.*;

import javax.swing.*;
import java.awt.*;

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

        playersListPanel = new JPanel();
        playersListPanel.setLayout(new BoxLayout(playersListPanel, BoxLayout.Y_AXIS));
        this.getContentPane().add(playersListPanel, BorderLayout.CENTER);
        //TODO: IDEA подсказывает: can be replaced with foreach call
        for (PlayerInGame player: game.playersList.getPlayers()) {
            addPlayerPanel(player);
        }
        this.setSize(500, 500);
        this.setVisible(true);
    }
}
