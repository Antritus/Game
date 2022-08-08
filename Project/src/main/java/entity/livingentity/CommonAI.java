package entity.livingentity;

import damage.Damage;
import main.GamePanel;

import java.util.HashMap;
import java.util.List;

public abstract class CommonAI extends LivingEntity{
    private boolean isAttacking;
    private boolean isHurt;
    private boolean isBeingHurt;
    private boolean isRunning;
    private boolean isAIEnabled;
    private boolean isMovementEnabled;
    private List<String> movementHistory;
    /*
     * Movement History { // Example
     *  MOVE_NORTH(10); | 1010923712903
     *  MOVE_SOUTH(1);
     *  MOVE_BACKWARDS(10); // moves 10 to north
     *  MOVE_LEFT(10); // Moves 10 to west
     *  TURN_NORTH(1);
     *  {
     *      TURN_(DIRECTION(BASE(NORTH,SOUTH)) (direction) (Common AI only supports as many pictures the game has registered for the entity, max 9)
     *      TURN(360) does nothing
     *      turn 90 = 1 image change
     *      turn 45
     *  }
     * }
     */
    private HashMap<LivingEntity, Long> entityTargetHistory;
    private HashMap<LivingEntity, Long> attackHistory;
    private HashMap<Damage, Long> damageTakenHistory;
    private HashMap<Damage, Long> damageDealtHistory;
    private long lastHitTime;

    private LivingEntity lastAttacker;

    private void setAction() {

    }

    private void scanForEntities() {

    }


    public CommonAI(GamePanel gp) {
        super(gp);
    }

    public boolean isAttacking() {
        return false;
    }

    @Override
    protected void onKill(boolean cancelled, LivingEntity victim, Damage damage) {

    }

    @Override
    protected void onDeath(boolean cancelled, LivingEntity attacker, Damage damage) {

    }

}
