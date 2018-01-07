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

    private int[] effectSlotArray = new int[]{
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

    private int[] effectDurationArray = new int[]{
            3,
            1
    };


    //refer to effectAction for IDs
    private int[] effectActivityArray = new int[]{
            0
    };




    public effect(int effectID, String effectName, int effectPotency, int effectType) {
        this.effectName = effectNameArray[effectID];
        this.effectPotency = effectPotency;
        this.effectType = effectTypeArray[effectID];
        this.effectDuration = 1;
        this.effectSlot = effectSlotArray[effectID];
        this.effectActivity = effectActivityArray[effectID];
    }
}