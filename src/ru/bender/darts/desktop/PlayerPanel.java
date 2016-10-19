package ru.bender.darts.desktop;

import ru.bender.darts.api.PlayerInGame;

import javax.swing.*;

/**
 * Created by bender on 18.10.16.
 */
class PlayerPanel extends JPanel {

    private final PlayerInGame player;
    private JLabel name;
    private JLabel position;
    private JLabel shots;
    private JLabel pointsToEnd;

    PlayerPanel(PlayerInGame player) {
        this.player = player;
        makeGUI();
        update();
    }

    void update() {
        //TODO: обновить UI
    }

    private void makeGUI() {
        //TODO: статическое расположение элементов
        //TODO: кнопки

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//        this.setLayout(null);
        name = new JLabel(player.getName());
        position = new JLabel("0");
        shots = new JLabel("0");
        pointsToEnd = new JLabel("0");
        JButton stepBtn = new JButton("+");

//        name.setSize(120, ELEMENTS_HEIGHT);
//        name.setLocation(0, ELEMENTS_HEIGHT);

        this.add(name);
        this.add(position);
        this.add(shots);
        this.add(pointsToEnd);
        this.add(stepBtn);
    }
}
