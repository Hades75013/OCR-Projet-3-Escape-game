package main.java;

public class SaisiesException {

    static boolean nbDeChiffreOK(String saisieJoueur) {

        boolean nbDeCaractereOK = false;

        if (saisieJoueur.length() == 4 && saisieJoueur.matches("^\\p{Digit}+$")) {
            nbDeCaractereOK = true;
        }
        return nbDeCaractereOK;
    }


    static boolean choixMenuOuFinDePartieOK(Integer saisieJoueur) {

        boolean choixMenuOuFinDePartieOK = false;

        if (saisieJoueur == 1 || saisieJoueur == 2 || saisieJoueur == 3) {
            choixMenuOuFinDePartieOK = true;
        }
        return choixMenuOuFinDePartieOK;
    }

    static boolean signesOK(String saisieJoueur) {

        boolean signesOK = false;
        char[] signesSaisiesJoueur = saisieJoueur.toCharArray();

        for (char signe : signesSaisiesJoueur)
            if (saisieJoueur.length() == 4 && (String.valueOf(signe).contains("+") || String.valueOf(signe).contains("-") || String.valueOf(signe).contains("="))) {
                signesOK = true;
            }

        return signesOK;
    }


}









