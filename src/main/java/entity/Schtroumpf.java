package entity;

public class Schtroumpf {
	private String nom;
	private int age;
	private boolean content;
	private Village village;
	
	
	public Schtroumpf(String pfNom, int pfAge) {
		this.nom = pfNom;
		this.age = pfAge;
		this.content = true;
		this.village = null;
	}
	
	public Schtroumpf(String pfNom, int pfAge, Village pfVillage) {
		this.nom = pfNom;
		this.age = pfAge;
		this.content = true;
		this.village = pfVillage;
	}
	
	public Village getVillage() {
		return this.village;
	}
	
	public void setVillage(Village pfV) {
		this.village = pfV;
	}
	
	
	public String getNom() {
		return this.nom;
	}
	
	public int getAge() {
		return this.age;
	}
	public boolean estContent() {
		return this.content;
	}
	
	public String leChant() {
		if(this.content) {
			return "la, la, la Schtroumpf la, la";
		}
		return "gloups";
	}
	
	public void chanter() {
		System.out.println(this.leChant());
	}
	
	public void anniversaire() {
		this.age++;
	}
	public void allerTravailler() {
		this.content = false;
	}
	
	public void manger(int pfQte) {
		if(pfQte > 0) {
			this.content = true;
		}
	}
	
	public String toString() {
		String phrase = "";
		if(this.content) {
			phrase = "Je suis " + this.nom + ", j’ai " + this.age + " ans et je suis content";
		}else {
			phrase = "Je suis " + this.nom + ", j’ai " + this.age + " ans  et je suis PAS content";
		}
		
		if(this.village != null) {
			phrase += ", j'habite au village "+ this.village.getNom();
		}else {
			phrase += ", je suis un ermite";
		}
		
		return phrase;

	}
	
	public void recolterSalsepareille() {
		if(this.village == null) {
			this.manger(5);
		}else {
			this.content = false;
			this.village.setStockSalsepareille(this.village.getStockSalsepareille()+3);
		}
	}
	
	public void dinerAuVillage() {
		if(this.village == null) {
			this.content = false;
		}else {
			this.manger(3);
			this.village.setStockSalsepareille(this.village.getStockSalsepareille()-3);
		}
	}
	
	
	public void sePresenter() {
		System.out.println(this.toString());
	}
	
}

