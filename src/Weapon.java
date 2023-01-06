import java.util.LinkedList;
import java.util.Scanner;

public class Weapon extends Item {

    private int LbEffect;
    public Weapon(int LbEffect) {
        this.LbEffect = LbEffect;
    }

    public int GetLbffect(int LbEffect) {
        return this.LbEffect;
    }

}
