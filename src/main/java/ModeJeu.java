package main.java;

import main.java.enums.ModeDeJeu;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public abstract class ModeJeu {

    DialogApi dialogApi = new DialogApi();
    protected Scanner sc = new Scanner(System.in);
    protected GameIA gameIA = new GameIA();
    protected int nbEssais;
    protected Config config;
    protected Logger logger = Logger.getLogger("ModeJeu");

    protected String nbMystereIA;
    protected String propositionIA;
    protected String reponseIA;

    protected String propositionJoueur;
    protected String reponseJoueur;

    boolean victoireJoueur = true;
    boolean victoireIA = true;

    boolean exceptionChoixMenuOuFinDePartie = true;
    boolean exceptionNbCaractere;
    boolean exceptionChiffres = true;
    boolean exceptionSignes = true;



    protected void run() {
    }


    public boolean isWin(String signe) {
        return signe.equals("====");
    }


    public void messageFinDePartie() {

        int choixOption = dialogApi.choixFinPartie();

        switch (choixOption) {
            case 1:
                rejouerMemeModeDeJeu();
                break;

            case 2:
                menuModeDeJeu();
                break;

            case 3:
                quitterJeu();
                break;

            default:

                logger.info("Mauvaise saisie de l'utilisateur pour le choix de fin de partie ");

                System.out.println("Veuillez entrer 1, 2 ou 3 comme valeur svp ! ");
                messageFinDePartie();

        }
    }

    public void menuModeDeJeu() {
        logger.info("L'utilisateur a décidé de revenir au menu Mode de jeu");

        System.out.println("Selectionnez votre mode de jeu\n" +
                "1 - Challenger\n" +
                "2 - Defenseur\n" +
                "3 - Duel\n");

        Integer modeJeu = dialogApi.ChoixModeJeu();

        do {
            exceptionChoixMenuOuFinDePartie = SaisiesException.choixMenuOuFinDePartieOK(modeJeu);
            if (exceptionChoixMenuOuFinDePartie = true) {

                logger.info("Mauvaise saisie de l'utilisateur pour le choix du mode de jeu ");

                System.out.print("Veuillez saisir uniquement 1,2 ou 3 svp : ");
                modeJeu = sc.nextInt();
            }
        } while (modeJeu != 1 && modeJeu != 2 && modeJeu != 3);

        ModeDeJeu modeJeuEnum = ModeDeJeu.valueFromInt(modeJeu);

        logger.info("le mode de jeu choisi est " + modeJeuEnum.name());

        System.out.println("le mode de jeu choisi est " + modeJeuEnum.name());

        config = null;
        try {
            config = new Config();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ModeJeu modeJeuObject = modeJeuEnum.initJeu(config);
        modeJeuObject.run();
    }


    public void rejouerMemeModeDeJeu() {
        logger.info("L'utilisateur a décidé de rejouer au même mode de jeu ");

        ModeJeu.this.run();
    }


    public void quitterJeu() {
        logger.info("L'utilisateur a décidé de quitter le jeu ");

        System.out.println("Merci d'avoir participé, au revoir et à bientot !");
        System.exit(0);
    }

}
