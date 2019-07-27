package main;


import main.modedejeu.ModeDeJeu;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.io.IOException;



public class Main {

    public static void main(String[] args) {

        final Logger logger = Logger.getLogger(Main.class);
        logger.error("on reyest");
        if(true)
            return;
        Config config;

        try {
            config = new Config();
            if (config.getModeDev()) {
                logger.info("Mode développeur activé");
            }

            System.out.println("Bienvenue dans le menu principal du jeu Escape Game - ONLINE !\n" +
                    "Pour vous échapper de la pièce, selon le mode de jeu sélectionné, vous allez devoir deviner ou empêcher de deviner\n" +
                    "une combinaison secrète face à une intelligence artificielle.\n");

            ModeDeJeu modejeu = new ModeDeJeu();
            modejeu.menuModeDeJeu();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

