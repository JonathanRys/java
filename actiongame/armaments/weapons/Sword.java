package armaments.weapons;

public class Sword extends Weapon {
    private int numEdges;
    
    public Sword(int hands, double dmg, double rng, int edges) {
        super(hands, dmg, rng);
        numEdges = edges;
    }
}