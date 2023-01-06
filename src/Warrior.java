public class Warrior extends Hero {

    @Override
    public void Combattre() {
        if (pointDeVie > 0) {
            super.Combattre();
            System.out.println("Come on bro !");
        } else System.out.println("Votre joueur est mort");
    }

    @Override
    public void Defense() {
        if (pointDeVie > 0) {
            super.Defense();
            System.out.println("Chest protector !");
        } else System.out.println("Votre joueur est mort");
    }

    @Override
    public Potion Boire() {
        if (pointDeVie > 0) {
            System.out.println("Votre joueur est mort");
        } else System.out.println("Votre joueur est mort");
        return null;
    }
}

