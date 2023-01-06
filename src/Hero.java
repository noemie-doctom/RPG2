import java.util.List;

public abstract class Hero extends Combattant {

    @Override
    public void Combattre() {
        if (pointDeVie >0) {
            super.Combattre();
            System.out.println("Point de vie du héros  : " + pointDeVie);
        } else {
        }
    }

    @Override
    public void Defense(){
        if (pointDeVie>0) {
            super.Defense();
            pointDeVie+=15;
            System.out.println("Point de vie : " + pointDeVie);
        } else {
        }
    }

    public void Manger(Food f){
        if (pointDeVie>0) {
            System.out.println("pv food = " + f.getNbEffet());
            pointDeVie += f.getNbEffet();
            System.out.println("Point de vie : " + pointDeVie);
        } else {
        }
    }

    public void Boire(Consumable potion){
        if (pointDeVie>0){
            System.out.println("pv potion = " + potion.getNbEffet());
            pointDeVie += potion.nbEffet;
            System.out.println("Point de vie : " + pointDeVie);
        } else {
        }
    }
}
