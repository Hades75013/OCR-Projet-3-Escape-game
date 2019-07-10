package main.java;

import main.java.enums.ModeDeJeu;

import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Config config;
        try {
            config = new Config();

            DialogApi dialogApi = new DialogApi();
            Scanner sc = new Scanner(System.in);
            boolean exception;

            if (config.getModeDev()) {
                System.out.println("Mode développeur activé");
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
                    System.out.print("Veuillez saisir uniquement 1,2 ou 3 svp : ");
                    modeJeu = sc.nextInt();
                }
            } while (modeJeu != 1 && modeJeu != 2 && modeJeu != 3);


            ModeDeJeu modeJeuEnum = ModeDeJeu.valueFromInt(modeJeu);
            System.out.println("Le mode de jeu choisi est " + modeJeuEnum.name());

            ModeJeu modeJeuObject = modeJeuEnum.initJeu(config);
            modeJeuObject.run();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

