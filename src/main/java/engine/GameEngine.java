package engine;
import java.util.Scanner;

import java.util.Scanner;
import java.util.*;

import entity.Schtroumpf;
import entity.Village;

public class GameEngine {
    private Village village;

    public GameEngine(){
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

    }


    public void launch(){
        while (true){
           System.out.println("Liste des Schtroumpf : ");
           
        }
    }

    private void afficherSchtroumpf(){
        ArrayList<Schtroumpf> currentHabitants = new ArrayList<>();
        currentHabitants = village.getHabitants();

        for (Schtroumpf sc : currentHabitants){
            System.out.println(sc.getNom() + " " + sc.getAge() );
        }
    }

    private void askUser(String awser){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Que voulez vous faire : ");

        
    }

}
