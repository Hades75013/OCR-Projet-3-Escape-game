package main.java;

public class GameIA {


    public GameIA() {
    }


    public String comparerValeur(String propositionJoueur, String nbMystereIA) {

        char[] propositionsJoueur = propositionJoueur.toCharArray();
        String indication = "";
        int i = 0;

        for (int chiffre : propositionsJoueur) {
            int chiffreMystere = nbMystereIA.charAt(i);

            if (chiffre == chiffreMystere) {
                indication += "=";

            } else if (chiffre > chiffreMystere) {
                indication += "-";

            } else {
                indication += "+";
            }

            i++;
        }

        return indication;

    }


    public int genererCombinaisonAleatoire() {
        int borneMin = 0;
        int borneMax = 9999;
        return (int) (Math.random() * (borneMax - borneMin));
    }


    public String genererCombinaisonParametres(String propositionIA, String reponse) {

        char[] reponses = reponse.toCharArray();

        String nouvelleProposition = "";
        int chiffrePropositionIA;
        int i = 0;


        for (char signe : reponses) {
            chiffrePropositionIA = Integer.parseInt(String.valueOf(propositionIA.charAt(i)));

            if (String.valueOf(signe).equals("=")) {
                nouvelleProposition += chiffrePropositionIA;

            } else if (String.valueOf(signe).equals("+")) {
                if ((chiffrePropositionIA + 1) > 9) {
                    nouvelleProposition += 9;
                } else {
                nouvelleProposition += chiffrePropositionIA + 1;
                }

            } else if (String.valueOf(signe).equals("-")) {
                if ((chiffrePropositionIA - 1) < 0) {
                    nouvelleProposition += 0;
                } else {
                    nouvelleProposition += chiffrePropositionIA - 1;
                }
            }

            i++;
        }
        return nouvelleProposition;
    }
}

/*
    Map<Integer, List<Integer>> historyBorne = new HashMap<>();


    public GameIA() {
        for (int i = 0; i < 4; i++) {
            List bornByPosition = new ArrayList();
            bornByPosition.add(0);
            bornByPosition.add(9);
            historyBorne.put(i, bornByPosition);
        }
    }
*/
/*
    public String genererCombinaisonHistorique(String propositionIA, String reponseIndication) {

        char[] reponseIndications = reponseIndication.toCharArray();

        String nouvelleProposition = "";
        int chiffrePropositionIA;
        int i = 0;


        for (char signe : reponseIndications) {
            chiffrePropositionIA = Integer.parseInt(String.valueOf(propositionIA.charAt(i)));

            if (String.valueOf(signe).equals("=")) {
                nouvelleProposition += chiffrePropositionIA;

            } else if (String.valueOf(signe).equals("+")) {
                int newBornMax = historyBorne.get(i).get(1);
                int newBornMin = chiffrePropositionIA;
                nouvelleProposition += generateCombinaison(i, newBornMin, newBornMax);

            } else if (String.valueOf(signe).equals("-")) {
                int newBornMin = historyBorne.get(i).get(0);
                int newBornMax = chiffrePropositionIA;
                nouvelleProposition += generateCombinaison(i, newBornMin, newBornMax);
            }
            i++;
        }
        return nouvelleProposition;
    }

    private String generateCombinaison(int positionIndex, int newBornMin, int newBornMax) {
        miseAjourHistoriqueBorne(positionIndex, newBornMin, newBornMax);
        int nouvelleProposition = combinaisonDichotomique(newBornMin, newBornMax);
        return String.valueOf(nouvelleProposition);
    }

    private void miseAjourHistoriqueBorne(int indexPosition, int newBornMin, int newBornMax) {
        List bornByPosition = new ArrayList();
        bornByPosition.add(newBornMin);
        bornByPosition.add(newBornMax);
        historyBorne.get(indexPosition).clear();
        historyBorne.get(indexPosition).addAll(bornByPosition);
    }

    private int combinaisonDichotomique(int borneMin, int bornMax) {
        int proposition = (borneMin + bornMax) / 2;
        return proposition;
    }


}
*/
