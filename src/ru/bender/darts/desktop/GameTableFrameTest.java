package ru.bender.darts.desktop;

import ru.bender.darts.api.HomerGame;
import ru.bender.darts.api.PlayerInGame;

/**
 * Created by bender on 19.10.16.
 */
public class GameTableFrameTest {
    public static void main(String[] args) {
        HomerGame game = new HomerGame();
        game.playersList.addPlayer(new PlayerInGame("потап", game));
        game.playersList.addPlayer(new PlayerInGame("фёдор", game));
        game.playersList.addPlayer(new PlayerInGame("эльцебальт", game));
        GameTableFrame frame = new GameTableFrame(game);
    }
}
