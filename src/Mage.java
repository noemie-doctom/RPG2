public class Mage extends SpellCaster {

    @Override
    public void Combattre(){
        if (pointDeVie>0) {
            super.Combattre();
            System.out.println("Magic towards you !");
        } else System.out.println("Votre joueur est mort");
    }

    @Override
    public void Defense() {
        if (pointDeVie > 0) {
            super.Defense();
            System.out.println("Leap of faith !");
        } else System.out.println("Votre joueur est mort");
    }

    /*@Override
    public void Manger() {
        if (pointDeVie>0) {
            super.Manger();
            System.out.println("A little snack please !");
        }
    }*/

    @Override
    public Potion Boire() {
        if (pointDeVie >0) {
            super.Boire();
            System.out.println("Renewal !");
        } else System.out.println("Votre joueur est mort");
        return null;
    }
}
