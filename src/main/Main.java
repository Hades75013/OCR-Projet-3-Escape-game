package main;


import main.modedejeu.ModeDeJeu;
import org.apache.log4j.Logger;



public class Main {

    public static void main(String[] args) {


        final Logger logger = Logger.getLogger(Main.class);
        Config config = new Config();
        config.chargementConfig();
        if (config.getModeDev()) {
            logger.info("Mode développeur activé");
        }

        logger.info("Lancement du programme");

        System.out.println("Bienvenue dans le menu principal du jeu Escape Game - ONLINE !\n" +
                "Pour vous échapper de la pièce, selon le mode de jeu sélectionné, vous allez devoir deviner ou empêcher de deviner\n" +
                "une combinaison secrète face à une intelligence artificielle.\n");

        ModeDeJeu modejeu = new ModeDeJeu();
        modejeu.menuModeDeJeu();


    }
}

