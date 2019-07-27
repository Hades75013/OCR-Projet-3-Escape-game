package main;

import java.util.Scanner;

public class DialogApi {

    private static String ENTRER_PROPOSITION = "Veuillez saisir une proposition : ";
    private static String ENTRER_REPONSE = "Veuillez saisir les indications à l'aide des signes +, -, et = : ";
    private static String PROPOSITION = "Proposition : ";
    private static String REPONSE = " -> Réponse : ";
    private static String CHOIXMODEJEU = "Veuillez choisir un mode de jeu : ";
    private static String CHOIXFINPARTIE = "Que désirez-vous faire à présent ? \n" +
            "1 - Rejouer au même mode ? \n" +
            "2 - Lancer un autre mode ? \n" +
            "3 - Quitter l'application ? \n" +
            "Veuillez choisir une option de jeu : ";

    private Scanner sc = new Scanner(System.in);

    public DialogApi() {
    }

    //Méthode permettant à l'utilisateur de saisir le choix du mode de jeu
    public String choixModeJeu() {
        System.out.println("Veuillez sélectionner votre mode de jeu\n" +
                "1 - Challenger\n" +
                "2 - Defenseur\n" +
                "3 - Duel\n");

        System.out.print(CHOIXMODEJEU);
        return sc.nextLine();
    }

    //Méthode permettant à l'utilisateur de saisir une proposition
    public String entrerProposition() {
        System.out.print(ENTRER_PROPOSITION);
        return sc.nextLine();
    }

    //Méthode permettant à l'utilisateur de saisir une réponse
    public String entrerReponse() {
        System.out.print(ENTRER_REPONSE);
        return sc.nextLine();
    }

    //Méthode permettant d'afficher le resultat de la comparaison
    public void afficherResultat(String proposition, String reponseIndication) {
        System.out.println(PROPOSITION + proposition + REPONSE + reponseIndication+"\n");
    }

    //Méthode permettant à l'utilisateur de selectionner le choix de fin de partie
    public String choixFinPartie() {
        System.out.print(CHOIXFINPARTIE);
        return sc.nextLine();
    }

}
