public abstract class Combattant {

    int pointDeVie = 100;


    public void Combattre() {
        System.out.println("Prêt à combattre ?");
    }


    public void Defense() {
        System.out.println("En efet, la protection est une sage décision !");
    }


    public Potion Boire() {
        System.out.println("Boire ! Quelle excellente idée");
        return null;
    }

}
