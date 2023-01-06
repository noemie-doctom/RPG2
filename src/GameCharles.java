import java.util.*;

public class GameCharles {
    ArrayList<Combattant> heroes = new ArrayList<>();
    ArrayList<Combattant> ennemie = new ArrayList<>();
    ArrayList<Combattant> listeCombattant = new ArrayList<>();
    int i = 0;
    public int nbPart =1;




    private static final InputParser inputParser = new ConsoleParser();
    private int nbPlayer;
    private int nbPartMax = 5;


    public GameCharles() {

        RegleDuJeu();
        selection();
        for (int nbPart=1;nbPart<=nbPartMax; nbPart++) {
            createAllEnemy();
            triAllCombatant();
            playPartie();
            if (nbPart < nbPartMax) {
            }
        }
    }

    public void RegleDuJeu() {
        System.out.println("Annonce des règles du jeu : \n");
        System.getProperty(  "line.separator"  );
        System.out.println("BrowserBoss est l'ennemie n°1 de la contrée d'Hawaïki. Il y a un an, BrowserBoss a brûlé tous les villages d'Hawaïki et capturer 10 nouveau-nés.");
        System.out.println("Les protecteurs de Hawaïki (Hunter, Healer, Mage et Warrior) sont parties à la recherche de BrowserBoss pour venger les leurs. Le but du jeu ? \n");
        System.out.println("Il faut tuer Browserboss. Cela ne va pas être simple car il a une capacité régénérante qui lui permet d'échapper à la mort 4 fois. Ainsi, l'équipe doit tuer");
        System.out.println("le BrowserBoss en 5 manches. Durant les 5 manches, les héros devront combattre et se défendre. Mais également en reprenant des forces en pouvant man-");
        System.out.println("ger, et boire des potions pour le Mage et le Healer et le Mage. \n");
        System.out.println("Dans le cas où un des héros de l'équipe que vous formerez meurt, vous perdrez le jeu. \n");
    }

    public void playPartie() {

            System.out.println("Manche n°" + nbPart);

                for (Combattant hero : this.heroes) {
                    System.out.println(String.format("C'est au tour du %s%n", hero));


                    System.out.println("Point de vie du " + hero + ": " + hero.pointDeVie + "\n");

                    if (hero.pointDeVie<1){
                        System.out.println("Un de vos hero " + hero + " est mort. Vous avez perdu.");
                        nbPart=6;
                        break;
                    }

                    System.getProperty(  "line.separator"  );

                    Enemy BrowserBoss = (Enemy) ennemie.get(0);
                    System.out.println("Point de vie de l'ennemie Browser Boss : " + BrowserBoss.pointDeVie);
                    BrowserBoss.Combattre();
                    hero.pointDeVie = hero.pointDeVie - BrowserBoss.getPuissanceAttack();

                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Quelle action voulez-vous effectuer entre : Combattre, Se défendre, Manger ou Boire ?");
                    String choix = scanner.nextLine();

                    this.choixHeros(choix, (Hero) hero, BrowserBoss);

                    if (BrowserBoss.pointDeVie < 1) {
                        System.out.println("Votre ennemie est mort, vous avez gagner la partie n°" + nbPart + ".");
                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        nbPart++;
                        BrowserBoss.pointDeVie=100;
                    }
                }
    }

    private void choixHeros(String choix, Hero hero, Enemy BrowserBoss) {

        switch (choix) {

            case "Combattre":

                if (hero.pointDeVie > 0) {
                    hero.Combattre();
                    inputParser.getWeapon();
                    BrowserBoss.pointDeVie-=30;
                    break;

                } else {
                    System.out.println("Votre joueur est mort " + hero + " est mort.");
                    heroes.remove(hero);
                    break;
                }

            case "Se défendre":

                if (hero.pointDeVie > 0) {
                    hero.Defense();
                    BrowserBoss.pointDeVie += 5;
                    break;

                } else {
                    System.out.println("Votre joueur est mort " + hero + " est mort.");
                    heroes.remove(hero);
                    break;
                }

            case "Manger":

                if (hero.pointDeVie > 0) {
                    hero.Manger(inputParser.getFood());
                    BrowserBoss.pointDeVie += 5;
                    break;
                } else {
                    System.out.println("Votre joueur est mort " + hero + " est mort.");
                    heroes.remove(hero);
                    break;
                }

            case "Boire":

                if (hero.pointDeVie<0) {
                    System.out.println("Votre héros " + hero + " est mort.");
                    heroes.remove(hero);
                    break;
                }

                if ((hero.toString().contains("Mage")) || hero.toString().contains("Healer")) {

                    if (hero.pointDeVie > 0) {
                        hero.Boire(inputParser.getPotion());
                    } else {
                        System.out.println("Les héros Hunter et Warrior ne peuvent pas boire de potions. Votre tour a sauté");
                    }
                    break;
                }

            default:
                System.out.println("L'action que vous voulez réaliser n'est pas possible, votre tour a donc été sauté.");
                BrowserBoss.puissanceAttack += 5;
                break;
        }
    }

    private void triAllCombatant() {

        listeCombattant.addAll(heroes);
        listeCombattant.addAll(ennemie);
        Collections.shuffle(listeCombattant);

    }

    private void createAllEnemy() {
            ennemie.add(new Enemy());
        }


    private void createAllHeros() {

        for (int i = 0; i < nbPlayer; i++) {
            heroes.add(inputParser.getHero());
            System.out.println(heroes);
        }
    }


    private void nbPerso() {
        do {
            this.nbPlayer = inputParser.getIntWithMessage("Choisissez le nombre de héros avec lequel vous voulez jouer. Sachant le nombre de joueur autorisé est compris entre 1 à 4 !");
        } while (nbPlayer>4 || this.nbPlayer<1);

        for (int i = 0; i+1 < this.nbPlayer; i++) {
            heroes.add(inputParser.getHero());
        }
    }


    public void selection() {

        int nombre;
        do {
            nombre = inputParser.getIntWithMessage("Choisissez le nombre de héros avec lequel vous voulez jouer. Sachant le nombre de joueurs autorisés est compris entre 1 à 4 !");
        } while (nombre>4 || nombre<1);

          for (int i = 0; i < nombre; i++) {
            heroes.add(inputParser.getHero());
        }
    }
}


