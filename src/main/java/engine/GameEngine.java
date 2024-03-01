package engine;

import java.util.Scanner;

import java.util.Scanner;
import java.util.*;

import entity.Schtroumpf;
import entity.Village;
import entity.Enemy;

public class GameEngine {
    private Village village;
    private Enemy enemy;

/**
     * Constructeur de la classe GameEngine.
     * Initialise le village des Schtroumpfs et l'ennemi Gargamel.
     */
    public GameEngine() {
        String[] nomsSchtroumpfs = {
                "Grand Schtroumpf",
                "Schtroumpf courant (et pas ordinaire)",
                "Schtroumpf ordinaire (et pas courant)",
                "Schtroumpf moralisateur à lunettes",
                "Schtroumpf boudeur",
                "Schtroumpf volant",
                "Schtroumpf étonné",
                "Schtroumpf acrobate",
                "Schtroumpf paresseux"
        };

        this.village = new Village("SchtroumpfCity", 20, nomsSchtroumpfs);
        System.out.println("Nom : " + village.getNom());
        System.out.println("Nombre d'habitants : " + village.getNbSchtroumpf());
        System.out.println("Stock de salsepareille : " + village.getStockSalsepareille());
        this.enemy = new Enemy("Gargamel", 100, 35);

    }

    /**
     * Méthode pour démarrer le jeu.
     * Cette méthode lance une boucle permettant aux joueurs d'interagir avec le jeu jusqu'à la fin.
     */
    public void launch() {
        while (true) {
            if(this.village.getHabitants().size() == 0){
                System.out.println("Vous avez perdu.. GG");
                break;
            }
            System.out.println("Liste des Schtroumpf : ");
            afficherSchtroumpf();
            System.out.println("");
            System.out.println("1) Recup stock de salsepareille");
            System.out.println("2) Soltice d'été");
            System.out.println("3) Attacker gargamel");
            int choice = askUser("Que voulez-vous faire ? : ");

            switch (choice) {
                case 1:
                    System.out.println(this.village.getStockSalsepareille());
                    break;
                case 2:
                    this.village.solstice_d_ete();
                    break;
                case 3:
                    attack();
                    break;
                default:
                    System.out.println("Erreur");
                    break;

            }
        }
    }

    /**
     * Méthode privée pour attaquer l'ennemi Gargamel.
     * Elle déclenche l'attaque de l'ennemi sur le premier Schtroumpf du village.
     */
    private void attack(){
       this.enemy.attack(this.village.getHabitants().get(0));
       System.out.println("Vous avez attaqué Gargamel, il a maintenant " + this.enemy.getLife() + " points de vie");
    }

    /**
     * Méthode privée pour afficher la liste des Schtroumpfs habitant le village.
     */
    private void afficherSchtroumpf() {
        ArrayList<Schtroumpf> currentHabitants = new ArrayList<>();
        currentHabitants = village.getHabitants();

        for (Schtroumpf sc : currentHabitants) {
            System.out.println(sc.getNom() + " " + sc.getAge());
        }
    }

    /**
     * Méthode privée pour demander une entrée à l'utilisateur.
     * @param awser La question posée à l'utilisateur.
     * @return La réponse de l'utilisateur.
     */
    private int askUser(String awser) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(awser);
        return scanner.nextInt();
    }
}
