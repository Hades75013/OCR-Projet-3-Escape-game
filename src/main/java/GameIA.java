package main.java;


public class GameIA {


    public GameIA() {
    }

    //Méthode permettant de comparer la proposition de l'utilisateur avec le nombre mystère généré par l'ordinateur
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

    //Méthode permettant à l'ordinateur de générer une combinaison aléatoire comprise entre 0 et 9999
    public int genererCombinaisonAleatoire() {
        int borneMin = 0;
        int borneMax = 9999;
        return (int) (Math.random() * (borneMax - borneMin));
    }

    //Méthode permettant à l'ordinateur de générer une combinaison avec prise en compte des indications de l'utilisateur
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
