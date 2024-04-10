package Produit;

public class Poisson extends Produit {
	private String nom = "Poisson";
	private Unite unite = Unite.KILOGRAMME;
	private String datePeche;
	private int qtteUnite;
	
	public Poisson(int qtteUnite, String datePeche) {
		this.qtteUnite = qtteUnite;
		this.datePeche = datePeche;
	}
	
	public String description() {
		return (nom + " pêché " + datePeche);
	}
	
}