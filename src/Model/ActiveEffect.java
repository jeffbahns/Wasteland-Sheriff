package Model;

/**
 * Created by Corey on 1/14/16.
 */
public class ActiveEffect {

    public int statValue;
    public String statTarget;
    public int duration;
    //Effect over time?
    public boolean eot;
    //Will serve as the go between Item status effects and Player/NPC stats


    public ActiveEffect(int statValue, String statTarget, int duration, boolean eot) {
        this.statValue = statValue;
        this.statTarget = statTarget;
        this.duration = duration;
    }
}
