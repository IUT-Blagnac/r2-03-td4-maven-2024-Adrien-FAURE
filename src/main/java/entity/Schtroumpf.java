package entity;

public class Schtroumpf {
    private String nom;
    private int age;
    private boolean content;
    private Village village;

    /**
     * Constructeur pour initialiser un Schtroumpf avec un nom et un âge.
     * 
     * @param pfNom Le nom du Schtroumpf
     * @param pfAge L'âge du Schtroumpf
     */
    public Schtroumpf(String pfNom, int pfAge) {
        this.nom = pfNom;
        this.age = pfAge;
        this.content = true;
        this.village = null;
    }

    /**
     * Constructeur pour initialiser un Schtroumpf avec un nom, un âge et un
     * village.
     * 
     * @param pfNom     Le nom du Schtroumpf
     * @param pfAge     L'âge du Schtroumpf
     * @param pfVillage Le village où habite le Schtroumpf
     */
    public Schtroumpf(String pfNom, int pfAge, Village pfVillage) {
        this.nom = pfNom;
        this.age = pfAge;
        this.content = true;
        this.village = pfVillage;
    }

    /**
     * Getter pour obtenir le village où habite le Schtroumpf.
     * 
     * @return Le village où habite le Schtroumpf
     */
    public Village getVillage() {
        return this.village;
    }

    /**
     * Setter pour définir le village où habite le Schtroumpf.
     * 
     * @param pfV Le village où habite le Schtroumpf
     */
    public void setVillage(Village pfV) {
        this.village = pfV;
    }

    /**
     * Getter pour obtenir le nom du Schtroumpf.
     * 
     * @return Le nom du Schtroumpf
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Getter pour obtenir l'âge du Schtroumpf.
     * 
     * @return L'âge du Schtroumpf
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Méthode pour ajouter un certain nombre d'années à l'âge du Schtroumpf.
     * Si l'âge dépasse 150, le Schtroumpf est retiré du village.
     * 
     * @param pfAge Le nombre d'années à ajouter à l'âge actuel du Schtroumpf
     */
    public void addAge(int pfAge) {
        this.age += age;
        if (age > 150) {
            village.getHabitants().remove(this);
        }
    }

    /**
     * Méthode pour vérifier si le Schtroumpf est content.
     * 
     * @return true si le Schtroumpf est content, false sinon
     */
    public boolean estContent() {
        return this.content;
    }

    /**
     * Méthode pour générer le chant du Schtroumpf.
     * 
     * @return Le chant du Schtroumpf en fonction de son état de contentement
     */
    public String leChant() {
        if (this.content) {
            return "la, la, la Schtroumpf la, la";
        }
        return "gloups";
    }

    /**
     * Méthode pour faire chanter le Schtroumpf.
     */
    public void chanter() {
        System.out.println(this.leChant());
    }

    /**
     * Méthode pour fêter l'anniversaire du Schtroumpf (augmente son âge d'une
     * année).
     */
    public void anniversaire() {
        this.age++;
    }

    /**
     * Méthode pour indiquer que le Schtroumpf va travailler (le rend non-content).
     */
    public void allerTravailler() {
        this.content = false;
    }

    /**
     * Méthode pour faire manger le Schtroumpf.
     * Si la quantité de nourriture est positive, le Schtroumpf devient content.
     * 
     * @param pfQte La quantité de nourriture que le Schtroumpf mange
     */
    public void manger(int pfQte) {
        if (pfQte > 0) {
            this.content = true;
        }
    }

    /**
     * Redéfinition de la méthode toString pour obtenir une représentation textuelle
     * du Schtroumpf.
     * 
     * @return Une chaîne de caractères représentant le Schtroumpf
     */
    public String toString() {
        String phrase = "";
        if (this.content) {
            phrase = "Je suis " + this.nom + ", j’ai " + this.age + " ans et je suis content";
        } else {
            phrase = "Je suis " + this.nom + ", j’ai " + this.age + " ans  et je suis PAS content";
        }

        if (this.village != null) {
            phrase += ", j'habite au village " + this.village.getNom();
        } else {
            phrase += ", je suis un ermite";
        }

        return phrase;
    }

    /**
     * Méthode pour récolter de la salsepareille.
     * Si le Schtroumpf habite dans un village, il devient non-content et le stock
     * de salsepareille du village augmente.
     */
    public void recolterSalsepareille() {
        if (this.village == null) {
            this.manger(5);
        } else {
            this.content = false;
            this.village.setStockSalsepareille(this.village.getStockSalsepareille() + 3);
        }
    }
}
