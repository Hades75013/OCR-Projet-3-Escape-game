package main.java.jeuplusoumoins;

import main.java.jeuplusoumoins.modedejeu.ModeDeJeu;

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

            System.out.println("Bienvenue dans le menu principal du jeuplusoumoins Escape Game - ONLINE !\n" +
                    "Pour vous échapper de la pièce, selon le mode de jeuplusoumoins sélectionné, vous allez devoir deviner ou empêcher de deviner\n" +
                    "une combinaison secrète face à une intelligence artificielle.");

            System.out.println();

            ModeDeJeu modejeu = new ModeDeJeu();
            modejeu.menuModeDeJeu();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

