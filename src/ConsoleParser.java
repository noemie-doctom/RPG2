import java.util.List;
import java.util.Scanner;

public class ConsoleParser implements InputParser {
    Scanner scanner;

    public ConsoleParser() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int getInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("L'entrée int est incorrecte.");
            scanner.nextLine();
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }

    @Override
    public String getString() {
        while (scanner.hasNextInt()) {
            System.out.println("L'entrée est incorrecte");
            scanner.nextLine();
        }
        String val = scanner.nextLine();
        scanner.nextLine();
        return val;
    }

    @Override
    public int getIntWithMessage(String msg) {
        System.out.println(msg);
        return getInt();
    }

    @Override
    public String GetStringWithMessage(String msg) {
        System.out.println(msg);
        return getString();
    }


    @Override
    public int getIntInRange(int min, int max) {
        int val = getInt();
        while (val < min || val > max) {
            System.out.println("La valeur n'est pas dans l'intervalle demandé.");
            val = getInt();
        }
        return val;
    }

    @Override
    public Potion getPotion() {

        Potion Philtre = new Potion(50);
        Potion Elixir = new Potion(30);

        List<String> potions = List.of("Philtre", "Elixir");
        StringBuilder ld = new StringBuilder("Veuillez sélectionner votre potion : ");

        for (String potion : potions) {
            ld.append(String.format("%s ", potion));
        }

        System.out.println(ld);
        String potion = scanner.nextLine();
        while (!potions.contains(potion)) {
            System.out.println("Cette potion n'existe pas.");
            potion = scanner.nextLine();
        }

        switch (potion) {
            case "Philtre":
                return Philtre;
            case "Elixir":
                return Elixir;
        }
        return Philtre;
    }

    @Override
    public Food getFood() {

        Food Viande = new Food(20);
        Food Féculent = new Food(30);
        Food Légume = new Food(10);

        List<String> foods = List.of("Viande", "Feculent", "Légume");
        StringBuilder sf = new StringBuilder("Veuillez sélectionner votre plat parmis les choix suivants : ");

        for (String food : foods) {
            sf.append(String.format("%s ", food));
        }

        System.out.println(sf);
        String nourritures = scanner.nextLine();
        while (!foods.contains(nourritures)) {
            System.out.println("Ce plat n'existe pas.");
            nourritures = scanner.nextLine();
        }

        switch (nourritures) {
            case "Viande":
                System.out.println("Un bon morceau de viande me fera du bien !");
                return Viande;
            case "Feculent":
                System.out.println("Des féculents me donneront un peu de force !");
                return Féculent;
            case "Legume":
                System.out.println("Les légumes m'apaiseront !");
                return Légume;
            default:
                return Viande;
        }
    }

    @Override
    public Weapon getWeapon() {

        Weapon Flèche = new Weapon(-2);
        Weapon Baton = new Weapon(-1);
        Weapon Epée = new Weapon(-3);

        List<String> weapons = List.of("Flèche", "Baton", "Epée");
        StringBuilder sf = new StringBuilder("Veuillez sélectionner votre arme parmis les choix suivants : ");

        for (String weapon : weapons) {
            sf.append(String.format("%s ", weapon));
        }

        System.out.println(sf);
        String arme = scanner.nextLine();
        while (!weapons.contains(arme)) {
            System.out.println("Cette arme n'existe pas.");
            arme = scanner.nextLine();
        }

        switch (arme){
            case "Flèche":
                System.out.println("Touc !");
                return Flèche;
            case "Baton":
                System.out.println("Taac !");
                return Baton;
            case "Epée":
                System.out.println("Routch !");
                return Epée;
            default: return Flèche;
        }
    }

    @Override
    public Hero getHero() {

        Hero Hunter = new Hunter();
        Hero Healer = new Healer();
        Hero Warrior = new Warrior();
        Hero Mage = new Mage();

        List<String> heroes = List.of("Hunter", "Healer", "Warrior", "Mage");
        StringBuilder sb = new StringBuilder("Veuillez sélectionner vos joueurs parmis les choix suivants : ");
        System.out.print("En sachant que vous ne pouvez pas sélectionner plusieurs fois le même joueur, ");

        for (String hero : heroes) {
            sb.append(String.format("%s ", hero));
        }
        System.out.println(sb);
        String character = scanner.nextLine();
        while (!heroes.contains(character)) {
            System.out.println("Ce héros n'existe pas.");
            character = scanner.nextLine();
        }
        switch (character) {
            case "Hunter":
                return Hunter;
            case "Healer":
                return Healer;
            case "Warrior":
                return Warrior;
            case "Mage":
                return Mage;
        }
        return Hunter;
    }
}





