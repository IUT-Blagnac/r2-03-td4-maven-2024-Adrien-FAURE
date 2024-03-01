package entity;

import java.util.ArrayList;

public class Village {
	private String nom;
	private ArrayList<Schtroumpf> habitants;
	private int nbStockSalsepareille;
	
    /**
     * Constructeur pour initialiser un village avec un nom, un stock de salsepareille et une liste de noms de Schtroumpfs.
     * @param pfNomV Le nom du village
     * @param pfStockSalsepareille Le stock initial de salsepareille du village
     * @param pfNomsDesSchtroumpfs La liste des noms des Schtroumpfs à créer dans le village
     */
    public Village(String pfNomV, int pfStockSalsepareille, String[] pfNomsDesSchtroumpfs) {
        this.nom = pfNomV;
        this.nbStockSalsepareille = pfStockSalsepareille;
        this.habitants = new ArrayList<Schtroumpf>();
        for (int i = 0; i < pfNomsDesSchtroumpfs.length; i++) {
            this.habitants.add(new Schtroumpf(pfNomsDesSchtroumpfs[i], (int)(Math.random() * 150), this));
        }
    }

    /**
     * Getter pour obtenir le nom du village.
     * @return Le nom du village
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Getter pour obtenir le nombre de Schtroumpfs dans le village.
     * @return Le nombre de Schtroumpfs dans le village
     */
    public int getNbSchtroumpf() {
        return this.habitants.size();
    }

    /**
     * Getter pour obtenir le stock de salsepareille du village.
     * @return Le stock de salsepareille du village
     */
    public int getStockSalsepareille() {
        return this.nbStockSalsepareille;
    }

    /**
     * Getter pour obtenir la liste des habitants du village.
     * @return La liste des habitants du village
     */
    public ArrayList<Schtroumpf> getHabitants() {
        return this.habitants;
    }

    /**
     * Setter pour définir le stock de salsepareille du village.
     * @param nbSalsepareille Le nouveau stock de salsepareille du village
     */
    public void setStockSalsepareille(int nbSalsepareille) {
        this.nbStockSalsepareille = nbSalsepareille;
    }

    /**
     * Méthode pour célébrer le solstice d'été dans le village.
     * Affiche le chant de chaque Schtroumpf et le nombre de Schtroumpfs contents.
     */
    public void solstice_d_ete() {
        System.out.println("Village : " + this.nom);
        int nbSchtroumpfContent = 0;
        for (int i = 0; i < this.habitants.size(); i++) {
            this.habitants.get(i).chanter();
            if (this.habitants.get(i).estContent()) {
                nbSchtroumpfContent++;
            }
        }
        System.out.println("Il y avait " + nbSchtroumpfContent + " Schtroumpfs contents");
    }

    /**
     * Méthode pour trouver le Schtroumpf le plus âgé du village.
     * @return Le Schtroumpf le plus âgé du village
     */
    public Schtroumpf chefDuVillage() {
        Schtroumpf currentSchtroumpf = this.habitants.get(0);
        for (int i = 1; i < this.habitants.size(); i++) {
            if (currentSchtroumpf.getAge() < this.habitants.get(i).getAge()) {
                currentSchtroumpf = this.habitants.get(i);
            }
        }
        return currentSchtroumpf;
    }

    /**
     * Méthode pour faire chanter tous les Schtroumpfs contents du village.
     */
    public void schtroumpsfHeureux() {
        for (int i = 0; i < this.habitants.size(); i++) {
            if (this.habitants.get(i).estContent()) {
                this.habitants.get(i).chanter();
            }
        }
    }

    /**
     * Méthode pour envoyer des Schtroumpfs cueillir de la salsepareille.
     * Chaque Schtroumpf content récolte de la salsepareille, augmentant le stock du village.
     */
    public void envoyerCueillirSalsepareille() {
        ArrayList<Schtroumpf> schtroumpfContent = getSchtroumpfContent();
        for (int i = 0; i < schtroumpfContent.size(); i = i + 2) {
            schtroumpfContent.get(i).recolterSalsepareille();
            this.nbStockSalsepareille += 5;
        }
    }

    /**
     * Méthode privée pour obtenir la liste des Schtroumpfs contents du village.
     * @return La liste des Schtroumpfs contents du village
     */
    private ArrayList<Schtroumpf> getSchtroumpfContent() {
        ArrayList<Schtroumpf> schtroumpfContent = new ArrayList<>();
        for (int i = 0; i < this.habitants.size(); i++) {
            if (this.habitants.get(i).estContent()) {
                schtroumpfContent.add(this.habitants.get(i));
            }
        }
        return schtroumpfContent;
    }
}
