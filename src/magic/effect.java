package magic;

public class effect{

    protected String effectName;
    protected int effectPotency;
    protected int effectType;
    protected int effectActivity;
    protected int effectDuration;
    protected int effectSlot;

    protected int effectID;

    protected static effect burn;
    protected static effect freeze;

    public String getEffectName() {
        return effectName;
    }

    public int getEffectPotency() {
        return effectPotency;
    }

    public int getEffectType() {
        return effectType;
    }

    public int getEffectActivity() {
        return effectActivity;
    }

    public int getEffectDuration() {
        return effectDuration;
    }

    public int getEffectSlot() {
        return effectSlot;
    }

    public int getEffectID() {
        return effectID;
    }

    public void setEffectDuration(int effectDuration) {
        this.effectDuration = effectDuration;
    }

    private String[] effectNameArray = new String[]{
            "Burn",
            "Freeze"
    };

    public int[] effectSlotArray = new int[]{
            0,
            1
    };

    /*whether or not effect is offensive, defensive, etc
    0 = offensive
    1 = defensive
    2 = utility
     */

    private int[] effectTypeArray = new int[]{
            0,
            2
    };

    public static int[] effectDurationArray = new int[]{
            3,
            1
    };


    //refer to effectAction for IDs
    private int[] effectActivityArray = new int[]{
            0,
            1
    };




    public effect(int effectID) {
        this.effectName = effectNameArray[effectID];
        this.effectPotency = 1;
        this.effectType = effectTypeArray[effectID];
        this.effectDuration = effectDurationArray[effectID];
        this.effectSlot = effectSlotArray[effectID];
        this.effectActivity = effectActivityArray[effectID];
    }
}