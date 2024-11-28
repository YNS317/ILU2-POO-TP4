package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;
import villagegaulois.IVillage;

public class ScenarioTest {

	public static void acheterProduit(Etal[] marche, String produit, int quantiteSouhaitee) {
		int quantiteRestante = quantiteSouhaitee;
		for (int i = 0; i < marche.length && quantiteRestante != 0; i++) {
			Etal etal = marche[i];
			int quantiteDisponible = etal.contientProduit(produit, quantiteRestante);
			if (quantiteDisponible != 0) {
				int prix = etal.acheterProduit(quantiteDisponible);
				String chaineProduit = accorderNomProduit(produit, quantiteDisponible);
				System.out.println("A l'étal n° " + (i + 1) + ", j'achete " + quantiteDisponible + " " + chaineProduit
						+ " et je paye " + prix + " sous.");
				quantiteRestante -= quantiteDisponible;
			}
		}
		String chaineProduit = accorderNomProduit(produit, quantiteSouhaitee);
		System.out.println("Je voulais " + quantiteSouhaitee + " " + chaineProduit + ", j'en ai acheté "
				+ (quantiteSouhaitee - quantiteRestante) + ".");
	}

	private static String accorderNomProduit(String produit, int quantiteSouhaitee) {
		String chaineProduit = produit;
		if (quantiteSouhaitee > 1) {
			chaineProduit = produit + "s";
		}
		return chaineProduit;
	}

	public static void main(String[] args) {
		Gaulois ordralfabetix=new Gaulois("Ordralfabetix",9);
		Gaulois obelix=new Gaulois("Ob�lix",20);
		Gaulois asterix=new Gaulois("Ast�rix",6);
		Sanglier sanglier1=new Sanglier(2000,obelix);
		Sanglier sanglier2=new Sanglier(1500,obelix);
		Sanglier sanglier3=new Sanglier(1000,asterix);
		Sanglier sanglier4=new Sanglier(500,asterix);
		Sanglier[] sangliersObelix= {sanglier1,sanglier2};
		Sanglier[] sangliersAsterix= {sanglier3,sanglier4};
		Poisson poisson1=new Poisson("lundi");
		Poisson[] poissons= {poisson1};
		Etal[] marche=new Etal[3];
		Etal<Sanglier> etalSanglier1=new Etal<>();
		Etal<Sanglier> etalSanglier2=new Etal<>();
		Etal<Poisson> etalPoisson1=new Etal<>();
		IVillage village = new IVillage() {
            private Etal<Produit>[] marche = new Etal[3];

            private int nbEtals = 0;

            @Override
            public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produits, int prix) {
                if (nbEtals < marche.length) {
                    etal.installerVendeur(vendeur, produits, prix);
                    marche[nbEtals++] = etal;
                    return true;
                }
                return false;
            }

            @Override
            public void acheterProduit(String produit, int quantiteSouhaitee) {
                int quantiteAchetee = 0;

                for (int i = 0; i < nbEtals && quantiteAchetee < quantiteSouhaitee; i++) {
                    Etal<?> etal = marche[i];
                    int quantiteDisponible = etal.contientProduit(produit, quantiteSouhaitee - quantiteAchetee);
                    if (quantiteDisponible > 0) {
                        int prix = etal.acheterProduit(quantiteDisponible);
                        quantiteAchetee += quantiteDisponible;
                        System.out.println("A l'étal n° " + (i + 1) + ", j'achète " + quantiteDisponible + " " + produit + (quantiteDisponible > 1 ? "s" : "") + " et je paye " + prix + " sous.");
                    }
                }

                System.out.println("Je voulais " + quantiteSouhaitee + " " + produit + (quantiteSouhaitee > 1 ? "s" : "") + ", j'en ai acheté " + quantiteAchetee + ".");
            }
            public void afficherMarche() {
                for (int i = 0; i < nbEtals; i++) {
                    System.out.println(marche[i].etatEtal());
                }
            }
		};
		village.installerVendeur(etalSanglier1, asterix, sangliersAsterix, 10);
        village.installerVendeur(etalSanglier2, obelix, sangliersObelix, 8);
        village.installerVendeur(etalPoisson1, ordralfabetix, poissons, 7);
        village.afficherMarche();
        village.acheterProduit("sanglier", 3);

        village.afficherMarche();
		
	}

}