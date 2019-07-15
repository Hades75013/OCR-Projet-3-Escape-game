package main.java;

import java.io.IOException;
import java.util.logging.Logger;


public class Main {


    public static void main(String[] args) {

        Logger logger = Logger.getLogger("");
        Config config;


        try {
            config = new Config();

            if (config.getModeDev()) {

                logger.info("Mode développeur activé");
            }

            System.out.println("Bienvenue dans le menu principal du jeu Escape Game - ONLINE !");

            ModeDeJeu modejeu = new ModeDeJeu();
            modejeu.menuModeDeJeu();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

