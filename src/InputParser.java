public interface InputParser {
    public int getInt();
    public String getString();

    public String GetStringWithMessage (String msg);

    public Food getFood();

    public int getIntInRange(int min, int max);

    public Hero getHero();

    public Weapon getWeapon();

    public Potion getPotion();

    public int getIntWithMessage(String msg);


}
