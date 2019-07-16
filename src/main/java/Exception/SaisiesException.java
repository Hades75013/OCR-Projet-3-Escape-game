package main.java.Exception;


public class SaisiesException {

    //Méthode permettant de gérer l'exception sur le nombre et le format des chiffres
    public static boolean nbDeChiffreOK(String saisieJoueur) {

        boolean nbDeCaractereOK = false;

        if (saisieJoueur.length() == 4 && saisieJoueur.matches("^\\p{Digit}+$")) {
            nbDeCaractereOK = true;
        }
        return nbDeCaractereOK;
    }

    //Méthode permettant de gérer l'exception sur le nombre et le format des signes
    public static boolean nbDeSignesOK(String saisieJoueur) {

        boolean signesOK = true;
        char[] signesSaisiesJoueur = saisieJoueur.toCharArray();

        if (saisieJoueur.length() != 4) {
            signesOK = false;
        }

        for (char signe : signesSaisiesJoueur) {
            if ((!String.valueOf(signe).equals("+")
                    && !String.valueOf(signe).equals("-")
                    && !String.valueOf(signe).equals("="))) {
                signesOK = false;
            }
        }
        return signesOK;
    }

    //Méthode permettant de gérer l'exception sur le nombre et le format du choix
    public static boolean choixMenuOK(String saisieJoueur) {

        boolean choixMenuOK = true;

        if (!String.valueOf(saisieJoueur).equals("1") && !String.valueOf(saisieJoueur).equals("2") && !String.valueOf(saisieJoueur).equals("3")) {
            choixMenuOK = false;
        }
        return choixMenuOK;
    }


}









