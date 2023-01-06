public abstract class Consumable extends Item {


    public int nbEffet;

    public Consumable(int nbEffet){

        this.nbEffet = nbEffet;
    }

    public int getNbEffet() {

        return this.nbEffet;
    }

}
