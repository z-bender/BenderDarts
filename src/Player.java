/**
 * Created by bender on 27.09.2016.
 */
abstract class Player {
    // имя
    protected String name;
    // лучший результат за ход TODO
    protected short bestResultOfStep;
    // лучший результат количества бросков TODO
    protected short bestResultOfCountShots;

    public Player(String name) {
        this.name = name;
    }

    //-------------------- Getters/Setters ------------------------//


    public String getName() {
        return name;
    }
}
