package villagegaulois;

import personnages.Gaulois;
import produit.IProduit;

public interface IVillage {
	public <P extends IProduit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix);

	public void acheterProduit(String produit, int quantiteSouhaitee);
}