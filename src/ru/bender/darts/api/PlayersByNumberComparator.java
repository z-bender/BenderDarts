package ru.bender.darts.api;

import java.util.Comparator;

/**
 * Created by bender on 19.10.16.
 */
public class PlayersByNumberComparator implements Comparator<PlayerInGame>{
    @Override
    public int compare(PlayerInGame playerInGame, PlayerInGame t1) {
        return (playerInGame.getNumber() < t1.getNumber()) ? 1 : -1;
    }
}
