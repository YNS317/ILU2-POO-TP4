package Produit;


public abstract class Produit {
	private String nom;
	protected Unite unite;
	
	
	public String getNom() {
		return this.nom;
	}
	
	
	public abstract String description();
}