package produit;

public abstract class Fixe implements IProduit {
    @Override
    public int calculerPrix(int prix) {
        return prix;
    }
}