package main.java;

public class SaisiesException {

    static boolean nbDeChiffreOK(String saisieJoueur) {

        boolean nbDeCaractereOK = false;

        if (saisieJoueur.length() == 4 && saisieJoueur.matches("^\\p{Digit}+$")) {
            nbDeCaractereOK = true;
        }
        return nbDeCaractereOK;
    }


    static boolean choixMenuOK(String saisieJoueur) {

        boolean choixMenuOK = true;

        if (!String.valueOf(saisieJoueur).equals("1") && !String.valueOf(saisieJoueur).equals("2") && !String.valueOf(saisieJoueur).equals("3")) {
            choixMenuOK = false;
        }
        return choixMenuOK;
    }

    static boolean nbDeSignesOK(String saisieJoueur) {

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


}









