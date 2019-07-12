package main.java;

import java.util.Scanner;

public class DialogApi {

    static String ENTRER_PROPOSITION = "Veuillez saisir une proposition : ";
    static String PROPOSITION = "Proposition : ";
    static String REPONSE = " -> Réponse : ";
    static String CHOIXMODEJEU = "Veuillez choisir un mode de jeu : ";
    static String CHOIXFINPARTIE = "Veuillez choisir une option de jeu : ";

    Scanner sc = new Scanner(System.in);

    public DialogApi() {
    }


    public Integer ChoixModeJeu() {
        System.out.print(CHOIXMODEJEU);
        return sc.nextInt();
    }


    public String entrerProposition() {
        System.out.print(ENTRER_PROPOSITION);
        return sc.nextLine();
    }


    public void afficherResultat(String proposition, String reponseIndication) {
        System.out.println(PROPOSITION + proposition + REPONSE + reponseIndication);
    }


    public String choixFinPartie() {
        System.out.println("Que désirez-vous faire à présent ? \n" +
                "1 - Rejouer au meme mode ? \n" +
                "2 - Lancer un autre mode ? \n" +
                "3 - Quitter l'application ? \n");
        System.out.print(CHOIXFINPARTIE);
        return sc.nextLine();
    }

}
