

import java.util.ArrayList;
import java.util.Collection;

public class Phrase extends ArrayList< String > {
    /**
     * Tableau contenant les 'Mot Vide' possibles.
     * Reference : https://www.ranks.nl/stopwords/french
     */
    public static String [] MOT_VIDE = {
            "alors", "au", "aucuns", "aussi", "autre", "avant", "avec", "avoir",
            "bon", "ca", "car", "ce", "cela", "ces", "ceux", "chaque", "ci",
            "comme", "comment", "dans", "debut", "dedans", "dehors", "depuis",
            "des", "devrait", "doit", "donc", "dos", "du", "elle", "elles", "en",
            "encore", "essai", "est", "et", "etaient", "etat", "ete", "etions",
            "etre", "eu", "fait", "faites", "fois", "font", "hors", "ici", "il",
            "ils", "je", "juste", "la", "la", "le", "les", "leur", "ma",
            "maintenant", "mais", "meme", "mes", "mien", "moins", "mon", "mot",
            "ni", "nommes", "notre", "nous", "ou", "par", "parce", "pas", "peu",
            "peut", "plupart", "pour", "pourquoi", "quand", "que", "quel",
            "quelle", "quelles", "quels", "qui", "sa", "sans", "ses", "seulement",
            "si", "sien", "son", "sont", "sous", "soyez", "sujet", "sur", "ta",
            "tandis", "tellement", "tels", "tes", "ton", "tous", "tout", "tres",
            "trop", "tu", "voient", "vont", "votre", "vous", "vu"
    };


    public Phrase(){}

    public Phrase( Collection< String > collection ) {
        super( collection );
    }

    /**
     * QUESTION 3
     *
     * Enleve les 'Mot Vide' de la Phrase sans changer l'ordre des autres Mots.
     */
    public void nettoyer() {
        // Placez votre code ici pour la question 3.
        ArrayList<Integer> index = new ArrayList<>();

        for(String item : MOT_VIDE) {
            for(int i = 0; i < this.size(); i++) {
                if (this.get(i).toLowerCase().equals(item) && !index.contains(i)) {
                    index.add(i);
                }
            }
        }


        int min;
        int temp;
        for(int i = 0; i < index.size() - 1; i++) {
            min = i;
            for(int j = i + 1; j < index.size(); j++) {
                if (index.get(j).compareTo(index.get(min)) < 0) {
                    min = j;
                }
            }
            temp = index.get(min);
            index.set(min,index.get(i));
            index.set(i,temp);
        }

        int num = -1;
        for(int i = index.size() - 1; i >= 0; i--) {
            num = index.get(i);
            this.remove(num);
        }
    }
}
