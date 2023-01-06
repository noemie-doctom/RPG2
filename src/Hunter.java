public class Hunter extends Hero{

    @Override
    public void Combattre() {
        if (pointDeVie>0){
            super.Combattre();
            System.out.println("Let's-a go!");
        } else System.out.println("Votre joueur est mort !");
    }

    @Override
    public void Defense() {
        if (pointDeVie>0) {
            super.Defense();
            System.out.println("Major deviation !");
        } else System.out.println("Votre joueur est mort !");
    }

    @Override
    public Potion Boire() {
        if (pointDeVie>0){
            System.out.println("Le joueur ne peut pas boire de potion, votre tour a donc été sauté !");
        } else System.out.println("Votre joueur est mort !");
        return null;
    }
}
