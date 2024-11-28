package produit;

public abstract class Produit implements IProduit {

	protected String nom;
	protected Unite unite;

	protected Produit(String nom) {
		this.nom = nom;
	}

	@Override
	public String getNom() {
		return nom;
	}

}