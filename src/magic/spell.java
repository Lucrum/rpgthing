package magic;

public class spell {

    protected String name;
    protected double damage;
    protected String description;
    protected int spellEffectID, manaCost, duration;

    //identifier for the spell
    protected int spellID;

    public String getName() {
        return name;
    }

    public double getDamage() {
        return damage;
    }

    public String getDescription() {
        return description;
    }

    public int getSpellEffectID() {
        return spellEffectID;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getDuration() {
        return duration;
    }

    public int getSpellID() {
        return spellID;
    }

    public int getSpellType() {
        return spellType;
    }



    /*spell type identifier
        0 = offensive
        1 = defensive
        etc
         */
    public int spellType;


    spell(String name, double damage, String description, int spellEffectID, int manaCost, int duration, int spellType) {
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.spellEffectID = spellEffectID;
        this.manaCost = manaCost;
        this.duration = duration;
        this.spellType = spellType;
    }
}