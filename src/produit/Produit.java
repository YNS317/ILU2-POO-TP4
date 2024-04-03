package produit;

public abstract class Produit {
    private String nom;

    public Produit(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public abstract String description();
}