package produit;

public class Poisson extends Produit {
	private String date;

	public Poisson(String date) {
		super("poisson");
		this.date = date;

	}

	@Override
	public String decrireProduit() {
		return nom + " péchés " + date + ".";
	}

	@Override
	public int calculerPrix(int prix) {
		return prix;
	}

}