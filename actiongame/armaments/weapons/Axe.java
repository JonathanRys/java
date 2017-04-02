package armaments.weapons;

public class Axe extends Weapon {
    private int numEdges;

    public Axe(int hands, double dmg, double rng, double bonus, int edges) {
        super(hands, dmg, rng, 5.0);
        numEdges = edges;
    }
}