package ru.bender.darts.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by bender on 28.09.2016.
 */
public class PlayersInGameList {

    public PlayersInGameList(ArrayList<PlayerInGame> players) {
        this.players = players;
        this.queueOfPlayersForStep = new PriorityQueue<>();
        resetListToNewGame();
    }

    public PlayersInGameList() {
        this(new ArrayList<>());
    }



    //----------------------- fields ------------------------------------//

    // Список игроков
    private ArrayList<PlayerInGame> players;
    // Очередь для хода TODO: удалить после реализации UI
    private PriorityQueue<PlayerInGame> queueOfPlayersForStep;


    //--------------------- public methods ------------------------------//
    //-------------------------------------------------------------------//

    /**
     * Добавить игрока
     *
     * @param player - игрок
     */
    public void addPlayer(PlayerInGame player) {
        players.add(player);
        refreshPositions();
        // TODO: добавить в очередь?
    }

    /**
     * Сбросить результаты игроков и выдать рандомные номера
     */
    public void resetListToNewGame(){
        resetPlayersResult();
        shufflePlayers();
        addAllPlayersToQueue();
    }

    /*TODO - хранить прошлые состояния players - посмотреть System.arraycopy
    * копируем players после step и храним его в очереди
    * */
    public void rollback(){}

    /**
     * Обновляем места игроков, по их результатам
     */
    public void refreshPositions() {
        Collections.sort(players);
        for (PlayerInGame player : players) {
            player.setPosition(players);
        }
    }

    /**
     * Получить следующего игрока для хода
     *
     * @return
     */
    public PlayerInGame getNextPlayerForStep() {
        PlayerInGame nextPlayer = queueOfPlayersForStep.poll();
        if (!nextPlayer.isEnd()) {
            queueOfPlayersForStep.offer(nextPlayer);
        }
        return nextPlayer;
    }


    //-------------------- private methods ---------------------------//

    /**
     * Задаем рандомные номера для игроков
     */
    private void shufflePlayers(){
        Collections.shuffle(players);
        short number = 0;
        for (PlayerInGame player : players) {
            player.setNumber(number++);
        }
    }

    /**
     * Сбросить результаты игроков
     */
    private void resetPlayersResult() {
        for (PlayerInGame player : players) {
            player.resetResults();
        }
    }

    /**
     * Добавить всех игроков в очередь для хода
     */
    private void addAllPlayersToQueue() {
        queueOfPlayersForStep = new PriorityQueue<>();
        for (PlayerInGame player : players) {
            queueOfPlayersForStep.offer(player);
        }
    }

    //-------------------- Getters/Setters ------------------------//


    /**
     * Возвращает копию списка игроков отсортированных по номеру в игре
     *
     * @return
     */
    public ArrayList<PlayerInGame> getPlayers() {
        return (ArrayList<PlayerInGame>) players.clone();
    }

    public ArrayList<PlayerInGame> getPlayers(Comparator<PlayerInGame> comparator){
        ArrayList<PlayerInGame> playersClone = getPlayers();
        playersClone.sort(comparator);
        return playersClone;
    }


}
