import armaments.armor.*;
import armaments.weapons.*;

interface attack {
    public double calcDamage();
}

interface defend {
    public double calcShield();
}

class Character implements attack, defend {
    protected double hitPoints;
    private Weapon weapon;
    private Armor armor;

    Character() {
        hitPoints = roll(80, 6);
    }
    Weapon getWeapon() {
        return weapon;
    }
    void setWeapon(Weapon arms) {
        weapon = arms;
    }
    Armor getArmor() {
        return armor;
    }
    void setArmor(Armor protection) {
        armor = protection;
    }
    protected double roll(int numDice, int numSides) {
        int min = numDice,
            max = numDice * numSides;
        return (Math.random() * (max - min)) + min;
    }
    public double calcDamage() {
        return (weapon.getDamage() + weapon.getBonusDamage()) * roll(1, 6);
    }
    public double calcShield() {
        return armor.getDefense() * roll(1, 6);
    }
}

class Hero extends Character {
    Hero() {
        super.setWeapon(new Scimitar()); //new Sword(1, 20, 2, 1);
        super.setArmor(new ChainMail());
    }
}

class Monster extends Character {
    Monster() {
        super.setWeapon(new BattleAxe()); //new Sword(1, 20, 2, 1);
        super.setArmor(new Armor(roll(2, 6))); // 
    }
}

class ActionGame {
    public static void main(String args[]) {
        Hero champ = new Hero();
        Monster currentFoe = new Monster();

        double dmg;
        int counter = 0;

        System.out.println("Starting game:");
        System.out.println("    Hero:    " + (int)champ.hitPoints + "hp");
        System.out.println("    Monster: " + (int)currentFoe.hitPoints + "hp");
        System.out.println("");

        while (champ.hitPoints > 0 && currentFoe.hitPoints > 0) {
            if (counter % 2 == 0) {
                // Hero's turn
                dmg = champ.calcDamage() - currentFoe.calcShield();

                if (dmg < 0) dmg = 0.0;

                currentFoe.hitPoints -= dmg;
                System.out.println("The hero attacks for " + (int)dmg + " damage.");
                System.out.println("    Hero:    " + (int)champ.hitPoints + "hp");
                System.out.println("    Monster: " + (int)currentFoe.hitPoints + "hp");
            } else {
                // Monster's turn
                dmg = currentFoe.calcDamage() - champ.calcShield();

                if (dmg < 0) dmg = 0.0;

                champ.hitPoints -= dmg;
                System.out.println("The monster attacks for " + (int)dmg + " damage.");
                System.out.println("    Hero:    " + (int)champ.hitPoints + "hp");
                System.out.println("    Monster: " + (int)currentFoe.hitPoints + "hp");
            }

            System.out.println("");
            counter++;
        }
        if (champ.hitPoints <=0) {
            System.out.println("The hero lost this battle.");
        } else {
            System.out.println("The hero defeated the monster.");
        }
    }
}
