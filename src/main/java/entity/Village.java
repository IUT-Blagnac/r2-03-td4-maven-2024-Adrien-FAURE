package entity;

import java.util.ArrayList;

public class Village {
	private String nom;
	private ArrayList<Schtroumpf> habitants;
	private int nbStockSalsepareille;
	
	public Village (String pfNomV, int pfStockSalsepareille, String[] pfNomsDesSchtroumpfs) {
		this.nom = pfNomV;
		this.nbStockSalsepareille = pfStockSalsepareille;
		this.habitants = new ArrayList<Schtroumpf>();
		for (int i = 0 ; i<pfNomsDesSchtroumpfs.length ; i++) {
			this.habitants.add(new Schtroumpf(pfNomsDesSchtroumpfs[i], (int)(Math.random()*150), this));
		}
		
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getNbSchtroumpf() {
		return this.habitants.size();
	}
	
	
	public int getStockSalsepareille() {
		return this.nbStockSalsepareille;
	}

    public ArrayList<Schtroumpf> getHabitants(){
        return this.habitants;
    } 
	
	
	public void setStockSalsepareille(int nbSalsepareille) {
		this.nbStockSalsepareille = nbSalsepareille;
		
	}
	
	public void solstice_d_ete() {
		System.out.println("Village : " + this.nom);
		int nbSchtroumpfContent = 0;
		for(int i = 0 ; i < this.habitants.size() ; i++) {
			this.habitants.get(i).sePresenter();
			this.habitants.get(i).chanter();
			if(this.habitants.get(i).estContent()) {
				nbSchtroumpfContent++;
			}
		}
		System.out.println("Il y avait " + nbSchtroumpfContent + " Schtroumpf content");
	}
	
	public Schtroumpf chefDuVillage() {
		Schtroumpf currentSchtroumpf = this.habitants.get(0);
		for(int i = 1 ; i < this.habitants.size() ; i++) {
			if(currentSchtroumpf.getAge() < this.habitants.get(i).getAge()) {
				currentSchtroumpf = this.habitants.get(i);
			}
		}
		return currentSchtroumpf;
	}
    

    
	
	
	
	public void schtroumpsfHeureux () {
		for(int i = 0 ; i < this.habitants.size(); i++) {
			if (this.habitants.get(i).estContent()) {
				this.habitants.get(i).chanter();
			}
		}
	}

	
	public void dinerTousEnsemble() {
		for(int i = 0 ; i < this.habitants.size() ; i++) {
			if (this.nbStockSalsepareille >= 3) {
				this.habitants.get(i).dinerAuVillage();
			}
		}
	}
	
	public void envoyerCueillirSalsepareille() {
		ArrayList<Schtroumpf> schtroumpfContent = getSchtroumpfContent();
		for(int i = 0 ; i < schtroumpfContent.size() ; i=i+2) {
			schtroumpfContent.get(i).recolterSalsepareille();
			this.nbStockSalsepareille += 5;
		}
	}
	
	private ArrayList<Schtroumpf> getSchtroumpfContent(){
		ArrayList<Schtroumpf> schtroumpfContent = new ArrayList<>();
		for(int i = 0 ; i < this.habitants.size() ; i++) {
			if(this.habitants.get(i).estContent()) {
				schtroumpfContent.add(this.habitants.get(i));
			}
		}
		return schtroumpfContent;
	}
	
	public void envoyerAuTravail() {
		ArrayList<Schtroumpf> schtroumpfContent = getSchtroumpfContent();
		for(int i = 0 ; i < schtroumpfContent.size() ; i=i+2) {
			schtroumpfContent.get(i).allerTravailler();
		}
	}

	
	
}

