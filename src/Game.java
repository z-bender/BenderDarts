/**
 * Created by bender on 27.09.2016.
 */
abstract class Game {

    //------------------- Constants ------------------------------//

    static final short DEFAULT_DARTS_COUNT = 3;

    //------------------- Constructors ---------------------------//

    public Game(short pointsToEnd) {
        this.pointsToEnd = pointsToEnd;
        this.dartsCount = DEFAULT_DARTS_COUNT;
        playersList = new PlayersInGameList();
    }


    //------------------- Fields ---------------------------------//

    // Список игроков
    PlayersInGameList playersList;
    // Количество дротиков TODO: dont use
    protected final short dartsCount;
    // Количество очков для победы
    protected final short pointsToEnd;

    //-------------------- Open methods ---------------------------//

    //TODO
    public void play() {

        playersList.resetListToNewGame();
        while (true) {
            PlayerInGame player = playersList.getNextPlayerForStep();
            if (player == null) {
                break;
            }
            this.step(player, Helper.getUserInputShort("Бросает " + player.getName() + ". Введи результат: "), new HomerGameTest());
        }

    }

    /**
     * Выполнить ход игрока
     *
     * @param player - игрок
     * @param points - количество выбитых очков
     * @param shotsCountUI - Интерфейс для UI-элемента, в котором будет вводится количество бросков игрока
     * @return - игрок закончил игру?
     */
    public abstract boolean step(PlayerInGame player, short points, ShotsCountUI shotsCountUI);


    //-------------------- Getters/Setters ------------------------//


    public short getPointsToEnd() {
        return pointsToEnd;
    }
}
