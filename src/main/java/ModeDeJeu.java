package main.java;


import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import static main.java.SaisiesException.choixMenuOK;


public class ModeDeJeu {

    protected Scanner sc = new Scanner(System.in);
    protected GameIA gameIA = new GameIA();
    protected int nbEssais;
    protected Config config;
    protected Logger logger = Logger.getLogger("");
    protected String nbMystereIA;
    protected String propositionIA;
    protected String reponseIA;
    protected String propositionJoueur;
    protected String reponseJoueur;
    DialogApi dialogApi = new DialogApi();
    boolean victoireJoueur = true;
    boolean victoireIA = true;

    boolean exceptionNbDeChiffre;
    boolean exceptionNbDeSignes;


    protected void run() {
    }


    public boolean isWin(String signe) {
        return signe.equals("====");
    }


    public void messageFinDePartie() {

        boolean exceptionFinDePartie;
        String choixOption = dialogApi.choixFinPartie();


        do {
            exceptionFinDePartie = choixMenuOK(choixOption);

            if (!exceptionFinDePartie) {
                logger.info("Mauvaise saisie de l'utilisateur pour le choix de jeu ");

                System.out.print("Veuillez saisir uniquement 1, 2 ou 3 comme valeurs svp : ");
                choixOption = sc.nextLine();
            }

        } while (!exceptionFinDePartie);


        switch (choixOption) {
            case "1":
                logger.info("L'utilisateur a décidé de rejouer au meme mode de jeu");

                rejouerMemeModeDeJeu();
                break;

            case "2":
                logger.info("L'utilisateur a décidé de revenir au menu Mode de jeu");

                menuModeDeJeu();
                break;

            case "3":
                logger.info("L'utilisateur a décidé de quitter le jeu");

                System.out.println("Merci d'avoir participé et à bientot !");
                quitterJeu();
                break;

            default:

        }
    }


    public void rejouerMemeModeDeJeu() {
        ModeDeJeu.this.run();
    }


    public void menuModeDeJeu() {

        config = null;
        try {
            config = new Config();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Selectionnez votre mode de jeu\n" +
                "1 - Challenger\n" +
                "2 - Defenseur\n" +
                "3 - Duel\n");

        boolean exceptionMenuModeJeu;
        String choixModeJeu = dialogApi.ChoixModeJeu();

        do {
            exceptionMenuModeJeu = choixMenuOK(choixModeJeu);

            if (!exceptionMenuModeJeu) {
                logger.info("Mauvaise saisie de l'utilisateur pour le choix de jeu ");

                System.out.print("Veuillez saisir uniquement 1, 2 ou 3 comme valeurs svp : ");
                choixModeJeu = sc.nextLine();
            }

        } while (!exceptionMenuModeJeu);


        switch (choixModeJeu) {
            case "1":
                logger.info("L'utilisateur a décidé de jouer au mode Challenger");

                System.out.println("Vous avez choisi de jouer au mode Challenger");
                ModeJeuChallenger challenger = new ModeJeuChallenger(config);
                challenger.run();
                break;

            case "2":
                logger.info("L'utilisateur a décidé de jouer au mode Defenseur");

                System.out.println("Vous avez choisi de jouer au mode Defenseur");
                ModeJeuDefenseur defenseur = new ModeJeuDefenseur(config);
                defenseur.run();
                break;

            case "3":
                logger.info("L'utilisateur a décidé de jouer au mode Duel");

                System.out.println("Vous avez choisi de jouer au mode Duel");
                ModeJeuDuel duel = new ModeJeuDuel(config);
                duel.run();
                break;

            default:

        }

    }


    public void quitterJeu() {
        System.exit(0);
    }

}
