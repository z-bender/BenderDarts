/**
 * Created by user on 29.09.2016.
 */
public class HomerGameTest implements ShotsCountUI{
    public static void main(String[] args) {
        HomerGame homerGame = new HomerGame();
        homerGame.playersList.addPlayer(new PlayerInGame("василий", homerGame));
        homerGame.playersList.addPlayer(new PlayerInGame("юрий павлович", homerGame));
        homerGame.playersList.addPlayer(new PlayerInGame("алёшка", homerGame));

        homerGame.play();
    }

    @Override
    public short getShotsCount() {
        return 2;
    }
}
