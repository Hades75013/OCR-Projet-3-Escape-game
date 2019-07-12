package main.java;

import main.java.enums.ModeDeJeu;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {


    public static void main(String[] args) {

        Logger logger = Logger.getLogger("Main");
        Config config;

        try {
            config = new Config();
            DialogApi dialogApi = new DialogApi();
            Scanner sc = new Scanner(System.in);
            boolean exception;

            if (config.getModeDev()) {

                logger.info("Mode développeur activé");
            }

            System.out.println("Bienvenue dans le menu principal du jeu Escape Game - ONLINE !");

            System.out.println("Selectionnez votre mode de jeu\n" +
                    "1 - Challenger\n" +
                    "2 - Defenseur\n" +
                    "3 - Duel\n");

            Integer modeJeu = dialogApi.ChoixModeJeu();

            do {
                exception = SaisiesException.choixMenuOuFinDePartieOK(modeJeu);
                if (!exception) {

                    logger.info("Mauvaise saisie de l'utilisateur pour le choix : nombre diférents de 1,2 ou 3");

                    System.out.print("Veuillez saisir uniquement 1,2 ou 3 svp : ");
                    modeJeu = sc.nextInt();
                }
            } while (!exception);


            ModeDeJeu modeJeuEnum = ModeDeJeu.valueFromInt(modeJeu);

            logger.info("Mode de jeu = " + modeJeuEnum.name());

            System.out.println("Le mode de jeu choisi est " + modeJeuEnum.name());

            ModeJeu modeJeuObject = modeJeuEnum.initJeu(config);
            modeJeuObject.run();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

