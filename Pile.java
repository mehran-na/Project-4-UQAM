
public class Pile<E> {
    private class Chainon {
        public E valeur;
        public Chainon precedant;

        public Chainon(E valeur, Chainon precedant) {
            this.valeur = valeur;
            this.precedant = precedant;
        }
    }

    protected Chainon sommet;

    /**
     * QUESTION 4
     *
     * Echange les deux premier chainons de place.
     *
     * Le chainon contenant le sommet et le chainon precedant sont echanges.
     * Ce N'EST PAS seulement les valeurs qui change, mais les chainons.
     * Cela va vous demander de deplacer les references (pointeur).
     *
     *
     * ************************************************************************
     * Placez vos explications ici :
     *
     * au début j'ai utiliser "if", si pile est vide ou il a seulement une valeur alors la méthod
     * ne fait rien. si il a plus que une valeur alors :
     *
     * Avec le code "Chainon temp = sommet; "J'ai créer une variable objet local
     * qui référe au premier élément(comme sommet).
     *
     * puis avec le code "sommet = sommet.precedant;" sommet référe au deuxiem élément.
     *
     * puis avec le code "temp.precedant = sommet.precedant;" le premier élément va référer
     * Au Au troisième élément ou null (si il n'y a pas troisième élément).
     *
     * puis avec le code "sommet.precedant = temp;" le deuxième élément référe au premier élément.
     * ************************************************************************
     */
    public void echanger() {
        // Placez votre code ici pour la question 4.
        if (sommet != null && sommet.precedant != null) {
            Chainon temp = sommet;
            sommet = sommet.precedant;
            temp.precedant = sommet.precedant;
            sommet.precedant = temp;
        }
    }

    public boolean estVide() {
        return null == sommet;
    }

    public E sommet() throws ExceptionPileVide {
        if (null == sommet) {
            throw new ExceptionPileVide("sommet");
        }

        return sommet.valeur;
    }

    public void empiler(E valeur) {
        sommet = new Chainon(valeur, sommet);
    }

    public E depiler() throws ExceptionPileVide {
        if (null == sommet) {
            throw new ExceptionPileVide("depiler");
        }

        E temp = sommet.valeur;
        sommet = sommet.precedant;

        return temp;
    }
}
