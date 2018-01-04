package magic;

public class spell {

    public String name;
    public int damage;
    public String description;
    public effect spellEffect;
    public int manaCost;
    public int duration;

    //identifier for the spell
    protected int spellID;



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