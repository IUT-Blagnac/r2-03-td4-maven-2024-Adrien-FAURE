package entity;

public class Enemy {
    private int life;
    private int degats;
    private String nom;

    /**
     * Objet Enemy
     * 
     * @param nom    le nom
     * @param life   le nombre de pv
     * @param degats le nom de degats
     */
    public Enemy(String nom, int life, int degats) {
        this.nom = nom;
        this.life = life;
        this.degats = degats;
    }

    /**
     * Permet qu'un Schtroumpf attaque l'enemie
     * 
     * @param sc Le Schtroumpf
     */
    public void attack(Schtroumpf sc) {
        this.life -= 5;
        sc.addAge(this.degats);
    }

    /**
     * Getter de nom
     *
     * @return String le nom de l'enemie
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Getter de life
     *
     * @return String la vie de l'enemie
     */
    public int getLife() {
        return this.life;
    }
}
