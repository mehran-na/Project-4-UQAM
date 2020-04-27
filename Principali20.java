
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
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
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
        for(int index = 0; index < tab.length - 1; index++) {
            min = index;
            max = index;

            for(int scan = index; scan < tab.length; scan++) {
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
                if (max == index && min == tab.length - 1) {
                    tab[index] = tempMin;
                    tab[tab.length - 1] = tempMax;
                }else if (max == index) {
                    tab[max] = tab[tab.length - 1];
                    tab[tab.length - 1] = tempMax;
                    tab[min] = tab[index];
                    tab[index] = tempMin;
                }else{
                    tab[min] = tab[index];
                    tab[index] = tempMin;
                    tab[max] = tab[tab.length - 1];
                    tab[tab.length - 1] = tempMax;
                }
            }else{
                tab[min] = tab[index];
                tab[index] = tempMin;
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
     *
     *
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
