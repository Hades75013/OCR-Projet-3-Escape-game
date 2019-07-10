package main.java;

import java.util.Scanner;

public class ModeJeuDuel extends ModeJeu {

    Config config;

    public ModeJeuDuel(Config config) {
        this.config = config;
    }

    @Override
    public void run() {

        //Message d'accueil avec énoncé des règles du mode de jeu
        System.out.println("Bienvenue dans ce mode de jeu ! Voici l'énoncé des règles : \n" +
                "Vous devez définir une combinaison de " + nbDeChiffres + " chiffres que l'ordinateur doit deviner !\n" +
                "Mais l'ordinateur doit également définir une combinaison que vous devez deviner !\n" +
                "Chacun joue à tour de role jusqu'à trouver en premier la combinaison de l'autre ...\n" +
                "A vous de jouer ! Bonne chance !");

        System.out.println();

        Scanner sc = new Scanner(System.in);
        GameIA gameIA = new GameIA();
        nbEssais = 0;

        System.out.println("Veuillez réflechir à une combinaison à " + nbDeChiffres + " chiffres ...");

        System.out.println();

        System.out.println("C'est au tour de l'ordi de générer une combinaison, il reflechit ... et a choisi lui aussi sa combinaison.");
        nbMystereIA = String.format("%04d", gameIA.genererCombinaisonAleatoire());

        if (config.getModeDev()) {
            System.out.println("(nbMystereIA = " + nbMystereIA + ")");
        }

        System.out.println();

        System.out.print("Veuillez faire une proposition : ");
        propositionJoueur = sc.nextLine();

        do {
            exceptionNbCaractere = SaisiesException.nbDeCaractereOK(propositionJoueur);
            if (exceptionNbCaractere = true) {
                System.out.print("Veuillez saisir uniquement 4 caractères svp : ");
                propositionJoueur = sc.nextLine();
            }
        } while (propositionJoueur.length() != 4);

        reponseIA = gameIA.comparerValeurChallenger(propositionJoueur, nbMystereIA);
        System.out.println("L'ordi vous donne des indications : " + reponseIA);

        System.out.println();

        propositionIA = String.format("%04d", gameIA.genererCombinaisonAleatoire());
        System.out.println("L'ordi propose une combinaison : " + propositionIA);
        System.out.print("Veuillez donnez des indications : ");
        reponseJoueur = sc.nextLine();

        do {
            exceptionNbCaractere = SaisiesException.nbDeCaractereOK(reponseJoueur);
            if (exceptionNbCaractere = true) {
                System.out.print("Veuillez saisir uniquement 4 caractères svp : ");
                reponseJoueur = sc.nextLine();
            }
        } while (reponseJoueur.length() != 4);

        System.out.println();


        do {
            nbEssais++;

            victoireIA = isWin(reponseJoueur);
            victoireJoueur = isWin(reponseIA);

            if (victoireJoueur) {
                System.out.print("Bravo ! Vous avez gagné, vous avez deviné la combinaison avant l'ordinateur en " + nbEssais + " essai(s) !");

            } else if (victoireIA) {
                System.out.print("Désolé ! Vous avez perdu, l'ordinateur a deviné la combinaison avant vous en " + nbEssais + " essai(s)!\n" +
                        "Sa combinaison secrète à trouver était :" + nbMystereIA);

            } else {
                System.out.print("Veuillez faire une proposition : ");

                do {
                    propositionJoueur = sc.nextLine();
                    exceptionNbCaractere = SaisiesException.nbDeCaractereOK(propositionJoueur);
                    if (exceptionNbCaractere = true) {
                        System.out.print("Veuillez saisir uniquement 4 caractères svp : ");
                    }
                } while (propositionJoueur.length() != 4);

                reponseIA = gameIA.comparerValeurChallenger(propositionJoueur, nbMystereIA);
                System.out.println("L'ordi vous donne des indications : " + reponseIA);

                System.out.println();

                propositionIA = gameIA.genererCombinaisonParametres(propositionIA, reponseJoueur);
                System.out.println("L'ordi propose une combinaison : " + propositionIA);
                System.out.print("Veuillez donnez des indications : ");

                do {
                    reponseJoueur = sc.nextLine();
                    exceptionNbCaractere = SaisiesException.nbDeCaractereOK(reponseJoueur);
                    if (exceptionNbCaractere = true) {
                        System.out.print("Veuillez saisir uniquement 4 caractères svp : ");
                        reponseJoueur = sc.nextLine();
                    }
                } while (reponseJoueur.length() != 4);

                System.out.println();
            }


        } while (!victoireIA && !victoireJoueur);

        System.out.println();

        messageFinDePartie();


    }
}









