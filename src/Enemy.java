public class Enemy extends Combattant {

    protected int puissanceAttack = 15;
    public Enemy() {

    }

    @Override
    public void Combattre() {
//        pointDeVie += 10;
        System.out.println("ATTAQUE HEROS !! SPLAAATCH ! HAHAHAHAHA !!");
    }

    public int getPointDeVie() {
        return this.pointDeVie;
    }

    public int getPuissanceAttack(){
        return this.puissanceAttack;
    }
}