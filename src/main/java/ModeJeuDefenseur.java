package main.java;

import java.util.Scanner;
import java.util.logging.Logger;


public class ModeJeuDefenseur extends ModeJeu {

    static Logger logger = Logger.getLogger("ModeJeuDefenseur");
    Config config;

    public ModeJeuDefenseur(Config config) {
        this.config = config;
    }

    public void run() {
        System.out.println("Bienvenue dans ce mode de jeu ! Voici l'énoncé des règles : \n" +
                "Vous devez definir une combinaison de " + nbDeChiffres + " chiffres que l'ordinateur doit deviner en " + nbEssaiMax + " essais maximum !\n" +
                "A vous de jouer ! Bonne chance !");

        Scanner sc = new Scanner(System.in);
        GameIA gameIA = new GameIA();

        nbEssais = 0;


        System.out.println("Veuillez definir une combinaison de " + nbDeChiffres + " chiffres ...");


        propositionIA = String.format("%04d", gameIA.genererCombinaisonAleatoire());
        System.out.println("Proposition de l'IA : " + propositionIA);

        logger.info("génération de la combinaison aléatoire");

        do {
            System.out.print("Veuillez saisir les indications à l'aide des signes +, -, et = : ");

            do {
                reponseJoueur = sc.nextLine();
                exceptionNbCaractere = SaisiesException.nbDeCaractereOK(reponseJoueur);

                if (exceptionNbCaractere = true)

                    logger.info("mauvaise saisie de l'utilisateur pour la réponse");

                System.out.print("Veuillez saisir uniquement 4 caractères avec les signes +, - et = svp : ");
                reponseJoueur = sc.nextLine();
                exceptionNbCaractere = SaisiesException.nbDeCaractereOK(reponseJoueur);

            } while (exceptionNbCaractere = true);

            dialogApi.afficherResultat(propositionIA, reponseJoueur);

            nbEssais++;

            victoireIA = isWin(reponseJoueur);

            if (victoireIA) {
                System.out.println("Désolé, vous avez perdu ! L'ordinateur a réussi à deviner votre combinaison secrète en " + (nbEssais) + " essai(s)\n");

                logger.info("victoire de l'ordinateur");

            } else if (nbEssais < nbEssaiMax) {
                propositionIA = gameIA.genererCombinaisonParametres(propositionIA, reponseJoueur);
                System.out.println("Proposition de l'IA : " + propositionIA);
            }

        } while (!victoireIA && nbEssais < nbEssaiMax);

        if (nbEssais == nbEssaiMax) {
            System.out.println("Bravo, vous avez gagné ! L'ordinateur n'a pas réussi à deviner votre combinaison secrète en " + nbEssaiMax + " essais!");
        }
        logger.info("victoire de l'utilisateur");

        System.out.println();

        messageFinDePartie();


    }
}





