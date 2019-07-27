package main.exception;


public class SaisiesException {

    //Méthode permettant de gérer l'exception sur le nombre et le format des chiffres
    public static boolean nbDeChiffresOK(String saisie) {
        boolean nbDeCaractereOK = false;

        if (saisie.length() == 4 && saisie.matches("^\\p{Digit}+$")) {
            nbDeCaractereOK = true;
        }
        return nbDeCaractereOK;
    }

    //Méthode permettant de gérer l'exception sur le nombre et le format des signes
    public static boolean nbDeSignesOK(String saisie) {
        boolean signesOK = true;
        char[] signesSaisie = saisie.toCharArray();

        if (saisie.length() != 4) {
            signesOK = false;
        }

        for (char signe : signesSaisie) {
            if ((!String.valueOf(signe).equals("+")
                    && !String.valueOf(signe).equals("-")
                    && !String.valueOf(signe).equals("="))) {
                signesOK = false;
            }
        }
        return signesOK;
    }

    //Méthode permettant de gérer l'exception sur le nombre et le format du choix des menus
    public static boolean choixOK(String saisie) {
        boolean choixMenuOK = true;

        if (!String.valueOf(saisie).equals("1") && !String.valueOf(saisie).equals("2") && !String.valueOf(saisie).equals("3")) {
            choixMenuOK = false;
        }
        return choixMenuOK;
    }

}









