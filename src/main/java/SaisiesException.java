package main.java;

public class SaisiesException {

    static boolean nbDeCaractereOK(String saisieJoueur) {

        boolean nbDeCaractereOK = false;

        if (saisieJoueur.length() == 4) {
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

        for (char signe : signesSaisiesJoueur) {
            if (String.valueOf(signe).equals("+") || String.valueOf(signe).equals("-") || String.valueOf(signe).equals("=")) {
                signesOK = true;
            }
        }
        return signesOK;
    }


    static boolean chiffresOK(String saisieJoueur) {

        boolean chiffresOK = false;
        char[] signesSaisiesJoueur = saisieJoueur.toCharArray();

        for (char signe : signesSaisiesJoueur) {
            if (String.valueOf(signe).equals("1") || String.valueOf(signe).equals("2") || String.valueOf(signe).equals("3") || String.valueOf(signe).equals("4")
                    || String.valueOf(signe).equals("5") || String.valueOf(signe).equals("6") || String.valueOf(signe).equals("7") || String.valueOf(signe).equals("8")
                    || String.valueOf(signe).equals("9")) {
                chiffresOK = true;
            }
        }
        return chiffresOK;
    }


}






