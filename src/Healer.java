public class Healer extends SpellCaster {

    @Override
    public void Combattre(){
        if (pointDeVie>0) {
            super.Combattre();
            System.out.println("Force attack !");
        } else System.out.println("Votre joueur est mort");
    }

    @Override
    public void Defense() {
        if (pointDeVie>0) {
            super.Defense();
            System.out.println("Big gap!");
        } else System.out.println("Votre joueur est mort");
    }

    /*@Override
    public void Manger() {
        if (pointDeVie>0) {
            super.Manger();
            System.out.println("I want to regain my strength !");
        } else System.out.println("Votre joueur est mort");
    }*/

    @Override
    public Potion Boire() {
        if (pointDeVie>0) {
            super.Boire();
            System.out.println("Renewal !");
        } else System.out.println("Votre joueur est mort");
        return null;
    }

}
