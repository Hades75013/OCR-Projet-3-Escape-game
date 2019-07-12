package main.java;

public class SaisiesException {

    static boolean nbDeChiffreOK(String saisieJoueur) {

        boolean nbDeCaractereOK = false;

        if (saisieJoueur.length() == 4 && saisieJoueur.matches("^\\p{Digit}+$")) {
            nbDeCaractereOK = true;
        }
        return nbDeCaractereOK;
    }


    static boolean choixMenuOK(Integer saisieJoueur) {

        boolean choixMenuOK = false;

        if (saisieJoueur == 1 || saisieJoueur == 2 || saisieJoueur == 3) {
            choixMenuOK = true;
        }
        return choixMenuOK;
    }

    static boolean signesOK(String saisieJoueur) {

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









