package main.java;

import java.util.Scanner;

public class DialogApi {

    private static String ENTRER_PROPOSITION = "Veuillez saisir une proposition : ";
    private static String ENTRER_REPONSE = "Veuillez saisir les indications à l'aide des signes +, -, et = : ";
    private static String PROPOSITION = "Proposition : ";
    private static String REPONSE = " -> Réponse : ";
    private static String CHOIXMODEJEU = "Veuillez choisir un mode de jeu : ";
    private static String CHOIXFINPARTIE = "Veuillez choisir une option de jeu : ";

    private Scanner sc = new Scanner(System.in);

    public DialogApi() {
    }

    //Méthode permettant de saisir le choix du mode de jeu
    public String ChoixModeJeu() {
        System.out.print(CHOIXMODEJEU);
        return sc.nextLine();
    }

    //Méthode permettant de saisir une proposition
    public String entrerProposition() {
        System.out.print(ENTRER_PROPOSITION);
        return sc.nextLine();
    }

    //Méthode permettant de saisir une réponse
    public String entrerReponse() {
        System.out.print(ENTRER_REPONSE);
        return sc.nextLine();
    }

    //Méthode permettant d'afficher le resultat de la comparaison
    public void afficherResultat(String proposition, String reponseIndication) {
        System.out.println(PROPOSITION + proposition + REPONSE + reponseIndication);
    }

    //Méthode permettant de saisir le choix de fin de partie
    public String choixFinPartie() {
        System.out.println("Que désirez-vous faire à présent ? \n" +
                "1 - Rejouer au meme mode ? \n" +
                "2 - Lancer un autre mode ? \n" +
                "3 - Quitter l'application ? \n");
        System.out.print(CHOIXFINPARTIE);
        return sc.nextLine();
    }

}
