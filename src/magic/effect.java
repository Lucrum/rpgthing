package magic;

public class effect{

    protected String effectName;
    protected int effectPotency;
    protected int effectType;
    protected effectAction effectActivity;
    protected int effectDuration;
    protected int effectSlot;

    protected int effectID;

    protected static effect burn;
    protected static effect freeze;

    public effectAction getEffectActivity(){
        return effectActivity;
    }

    private String[] effectNameArray = new String[]{
            "Burn"
    };

    private int[] effectSlotArray = new int[]{
            1
    };

    /*whether or not effect is offensive, defensive, etc
    0 = offensive
     */
    private int[] effectTypeArray = new int[]{
            0
    };

    private int[] effectDurationArray = new int[]{
            1
    };

    private effect[] effectActionArray = new effectAction[]{
            effectAction.burn(),
    };




    public effect(int effectID, String effectName, int effectPotency, int effectType) {
        this.effectName = effectNameArray[effectID];
        this.effectPotency = effectPotency;
        this.effectType = effectTypeArray[effectID];
        this.effectActivity = effectActionArray[effectID];
        this.effectDuration = 1;
        this.effectSlot = effectSlotArray[effectID];
    }
}