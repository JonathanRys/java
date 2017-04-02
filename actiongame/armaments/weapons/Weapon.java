package armaments.weapons;

public class Weapon {
    private int numHands;
    private double damage;
    private double range;
    private double bonusDamage;

    public Weapon(int hands, double dmg, double rng, double bonus) {
        numHands = hands;
        damage = dmg;
        range = rng;
        bonusDamage = bonus;
    }
    public Weapon(int hands, double dmg, double rng) {
        numHands = hands;
        damage = dmg;
        range = rng;
        bonusDamage = 0;
    }
    public double getDamage() {
        return damage;
    }
    public double getRange() {
        return range;
    }
    public double getBonusDamage() {
        return bonusDamage;
    }
}