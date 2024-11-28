package produit;

public abstract class Change implements IProduit {
    private int poids;

    public Change(int poids) {
        this.poids = poids;
    }

    @Override
    public int calculerPrix(int prix) {

        return (poids * prix) / 1000;
    }
}