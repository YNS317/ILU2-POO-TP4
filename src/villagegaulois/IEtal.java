package villagegaulois;

import personnages.Gaulois;

public interface IEtal {
	Gaulois getVendeur();
	int donnerPrix();
	int contientProduit(String produit, int quantiteSouhaitee);
	int acheterProduit(int quantiteSouhaitee);
	String etatEtal();
	boolean isEtalOccupe();
}