package magic;

public class spell {

    protected String name;
    protected int damage;
    protected String description;
    protected effect spellEffect;
    protected int manaCost;
    protected int duration;

    //identifier for the spell
    protected int spellID;

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public String getDescription() {
        return description;
    }

    public effect getSpellEffect() {
        return spellEffect;
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


    public spell(String name, int damage, String description, effect spellEffect, int manaCost, int duration, int spellType) {
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.spellEffect = spellEffect;
        this.manaCost = manaCost;
        this.duration = duration;
        this.spellType = spellType;
    }

}