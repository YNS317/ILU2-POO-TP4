package villagegaulois;

import personnages.Gaulois;
import produit.IProduit;

public class Etal<P extends IProduit> implements IEtal {
	private Gaulois vendeur;
	private P[] produit;
	private int nbProduit;
	private int prix;
	private int quantiteDebutMarche;
	private int quantite;
	private boolean etalOccupe = false;

	public boolean isEtalOccupe() {
		return etalOccupe;
	}

	public Gaulois getVendeur() {
		return vendeur;
	}

	public int getQuantite() {
		return quantite;
	}

	public P[] getProduit() {
		return produit;
	}

	public void installerVendeur(Gaulois vendeur, P[] produit, int prix) {
		this.vendeur = vendeur;
		int i;
		this.produit = produit;
		this.nbProduit = produit.length;
		this.prix = prix;

	}

	public void occuperEtal(Gaulois vendeur, P[] produit, int quantite) {
		this.vendeur = vendeur;
		this.produit = produit;
		this.quantite = quantite;
		quantiteDebutMarche = quantite;
		etalOccupe = true;
	}

	public boolean contientProduit(P[] produit) {
		return this.produit == produit;
	}

	public void libererEtal() {
		etalOccupe = false;
	}

	/**
	 * 
	 * @return donneesVente est un tableau de chaine contenant [0] : un boolean
	 *         indiquant si l'�tal est occup� [1] : nom du vendeur [2] : produit
	 *         vendu [2] : quantit� de produit � vendre au d�but du march� [4] :
	 *         quantit� de produit vendu
	 */
	@Override
	public String etatEtal() {
		StringBuilder chaine = new StringBuilder(vendeur.getNom());
		if (nbProduit > 0) {
			chaine.append(" vend ");
			chaine.append(nbProduit + " produits :");
			for (int i = 0; i < nbProduit; i++) {
				chaine.append("\n- " + produit[i].decrireProduit());
			}
		} else {
			chaine.append(" n'a plus rien à vendre.");
		}
		chaine.append("\n");
		return chaine.toString();
	}

	@Override
	public int donnerPrix() {
		return prix;
	}

	@Override
	public int contientProduit(String produit, int quantiteSouhaitee) {
		int quantiteAVendre = 0;
		if (nbProduit != 0 && this.produit[0].getNom().equals(produit)) {
			if (nbProduit >= quantiteSouhaitee) {
				quantiteAVendre = quantiteSouhaitee;
			} else {
				quantiteAVendre = nbProduit;
			}
		}
		return quantiteAVendre;
	}

	@Override
	public int acheterProduit(int quantiteSouhaite) {
		int prixPaye = 0;
		for (int i = nbProduit - 1; i > nbProduit - quantiteSouhaite - 1 || i > 1; i--) {
			prixPaye += produit[i].calculerPrix(prix); // question 3.d
		}
		if (nbProduit >= quantiteSouhaite) {
			nbProduit -= quantiteSouhaite;
		} else {
			nbProduit = 0;
		}
		return prixPaye;
	}

}
