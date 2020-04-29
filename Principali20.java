
import java.util.function.Function;

public class Principali20 {
    /**
     * QUESTION 1
     *
     * Cette methode tri le tableau.
     * Le tri est fait comme le tri slection, mais a chaque tour de la boucle
     * interne, vous devez choisir le minimum et le maximum.
     * Lorsque la boucle interne les a trouve, alors elle les places au bon
     * endroit.
     *
     * ************************************************************************
     * Placez votre analyse de complexite temporelle ici, analyse de pire cas :
     * Le pire des cas est lorsque le nombre maximum est dans l'index zéro ou
     * le nombre minimum dans le dernier index.Dans ce cas,
     * l'ordre de mouvement est important.
     * Par exemple : si le nombre maximum est dans l'index  zéro nous devons
     * d'abord le déplacer à la fin du tableau.sinon si nous apportons d'abord
     * le minimum à l'index zéro dans le tableau et essayons ensuite de déplacer
     * le nombre maximum, nous envoyons par erreur le minimum à la fin du tableau.
     * résumer : Lorsque le nombre maximum est dans l'index zéro du tableau,
     * il faut d'abord le aporter à la fin du tableau puis ramener le nombre minimum au début. et
     * Lorsque le nombre minimum est dernier élément du tableau, il faut d'abord le aporter au début
     * du tableau puis ramener le nombre maximum à la fin.
     * ************************************************************************
     *
     * @param tab Le tableau a trier.
     * @param <E> Le type des elements du tableau.  Le tri utilise le comparateur
     *           de ce type (Comparable).
     */
    public static < E extends Comparable< E > >
    void triDoubleSelection( E [] tab ) {
        // Placez votre code ici pour la question 1.
        int min;
        int max;
        E tempMin;
        E tempMax;
        for(int i = 0; i < tab.length - 1; i++) {
            min = i;
            max = i;

            for(int scan = i; scan < tab.length; scan++) {
                if (tab[scan].compareTo(tab[min]) < 0) {
                    min = scan;
                }
                if (tab[scan].compareTo(tab[max]) > 0) {
                    max = scan;
                }
            }

            tempMin = tab[min];
            tempMax = tab[max];
            if (tab.length > 2) {
                if (max == i && min == tab.length - 1) {
                    tab[i] = tempMin;
                    tab[tab.length - 1] = tempMax;
                }else if (max == i) {
                    tab[max] = tab[tab.length - 1];
                    tab[tab.length - 1] = tempMax;
                    tab[min] = tab[i];
                    tab[i] = tempMin;
                }else{
                    tab[min] = tab[i];
                    tab[i] = tempMin;
                    tab[max] = tab[tab.length - 1];
                    tab[tab.length - 1] = tempMax;
                }
            }else{
                tab[min] = tab[i];
                tab[i] = tempMin;
            }
        }
    }


    /**
     * QUESTION 2
     *
     * type F : equals.
     *
     * ************************************************************************
     * Placez votre Lamda ici :
     * public static Function< String, Boolean > trouverMots =
     * x -> {
     *  return Character.isUpperCase(x.charAt(0)) && x.length() >= 5;
     * };
     * La sortie de cette méthod est true ou false. true signifie ce mot commence par
     * une majuscule et il a plus de 4 caractères. puis on peut regrouper les mots dans le algorithm.
     *
     *
     * ************************************************************************
     *
     * @param tab Le tableau a classer.
     * @param classification Une fonction qui transforme les éléments en éléments utiliés
     *                       pour la comparaison et la classification.
     * @param <E> Type des éléments de bases
     * @param <F> Type des éléments transformés
     */
    public static < E, F >
    void classer( E [] tab, Function< E, F > classification ) {
        // Placez votre code ici pour la question 2.

        for(int i = 1; i < tab.length; i++) {
            E key = tab[i];
            int position = i;
            while (position > 0 && !tab[position - 1].equals(classification.apply(key))) {
                tab[position] = tab[position - 1];
                position--;
            }
            tab[position] = key;
        }
    }


    public static void main( String [] argv ) {

    }
}
