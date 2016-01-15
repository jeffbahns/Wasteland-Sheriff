package Model;

/**
 * Created by jeffbahns on 1/11/16.
 */
public class MagicSkill extends Skill {


    MagicSkill(String name, String DESCRIPTION, char TYPE, String STAT_TARGET, int STAT_VALUE, int SP_COST, int DURATION, boolean eot) {
        super(name, DESCRIPTION, TYPE, STAT_TARGET, STAT_VALUE, SP_COST, DURATION, eot);
    }
}
