package main.java.ModeDeJeu;


import main.java.Config;
import main.java.DialogApi;
import main.java.GameIA;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import static main.java.Exception.SaisiesException.*;


public class ModeDeJeu {

    protected Config config;
    protected DialogApi dialogApi = new DialogApi();
    protected GameIA gameIA = new GameIA();
    protected Logger logger = Logger.getLogger("");

    protected String nbMystereIA;
    protected String propositionIA;
    protected String reponseIA;

    protected String propositionJoueur;
    protected String reponseJoueur;

    protected int nbEssais;
    protected String choix;

    protected boolean victoireJoueur;
    protected boolean victoireIA;


    //Méthode redéfinie dans les classes filles permettant de lancer les différents modes de jeu
    protected void run() {
    }

    //Méthode booléenne permettant de tester la victoire
    protected boolean gagneOK(String signe) {
        return signe.equals("====");
    }

    //Méthode permettant de verifier la saisie correcte de l'utilisateur pour des chiffres
    protected void verifChiffres() {

        Scanner sc = new Scanner(System.in);
        boolean exceptionNbDeChiffre;

        do {
            exceptionNbDeChiffre = nbDeChiffresOK(propositionJoueur);

            if (!exceptionNbDeChiffre) {
                logger.info("Mauvaise saisie de l'utilisateur pour la proposition : nombre de caractère superieur à " + config.getNbDeChiffres() + " ou/et differents d'un chiffre");

                System.out.print("Veuillez saisir uniquement 4 chiffres svp : ");
                propositionJoueur = sc.nextLine();
            }
        } while (!exceptionNbDeChiffre);
    }

    //Méthode permettant de verifier la saisie correcte de l'utilisateur pour des signes
    protected void verifSignes() {

        Scanner sc = new Scanner(System.in);
        boolean exceptionNbDeSignes;

        do {
            exceptionNbDeSignes = nbDeSignesOK(reponseJoueur);

            if (!exceptionNbDeSignes) {
                logger.info("Mauvaise saisie de l'utilisateur pour la proposition : nombre de caractère superieur à " + config.getNbDeChiffres() + " ou/et differents d'un signe +,- ou = ");

                System.out.print("Veuillez saisir uniquement 4 signes (+,- ou =) svp : ");
                reponseJoueur = sc.nextLine();
            }
        } while (!exceptionNbDeSignes);
    }

    //Méthode permettant de verifier la saisie correcte de l'utilisateur pour le choix du menu ou de la fin de partie
    protected void verifChoix() {

        Scanner sc = new Scanner(System.in);
        boolean exceptionChoix;

        do {
            exceptionChoix = choixOK(choix);

            if (!exceptionChoix) {
                logger.info("Mauvaise saisie de l'utilisateur pour le choix de jeu ");

                System.out.print("Veuillez saisir uniquement 1, 2 ou 3 comme valeurs svp : ");
                choix = sc.nextLine();
            }
        } while (!exceptionChoix);
    }


    //Méthode permettant de lancer le Mode de jeu
    public void menuModeDeJeu() {

        config = null;
        try {
            config = new Config();
        } catch (IOException e) {
            e.printStackTrace();
        }

        choix = dialogApi.choixModeJeu();

        verifChoix();

        switch (choix) {
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


    //Méthode permettant de choisir les options de fin de partie
    protected void finDePartie() {

        choix = dialogApi.choixFinPartie();

        verifChoix();

        switch (choix) {
            case "1":
                logger.info("L'utilisateur a décidé de rejouer au meme mode de jeu");

                rejouerModeDeJeu();
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

    //Méthode permettant de rejouer la même partie
    private void rejouerModeDeJeu() {
        ModeDeJeu.this.run();
    }


    //Méthode permettant de quitter le jeu
    private void quitterJeu() {
        System.exit(0);
    }


}


