package main.java.ModeDeJeu;


import main.java.Config;


public class ModeJeuChallenger extends ModeDeJeu {

    public ModeJeuChallenger(Config config) {
        this.config = config;
    }

    public void run() {

        //Message d'accueil avec énoncé des règles du mode de jeu
        System.out.println("Bienvenue dans ce mode de jeu ! Voici l'énoncé des règles : \n" +
                "L'ordinateur a défini une combinaison de " + config.getNbDeChiffres() + " chiffres que vous devez deviner en " + config.getNbEssaisMax() + " essais maximum !\n" +
                "A vous de jouer ! Bonne chance !");

        System.out.println();

        //Génération de la combinaison aléatoire par l'ordinateur
        nbMystereIA = String.format("%04d", gameIA.genererCombinaisonAleatoire());

        //On questionne si le mode développeur est activé
        if (config.getModeDev()) {

            System.out.println("(nbMystereIA = " + nbMystereIA + ")");
        }

        nbEssais = 0;

        //On boucle tant que les conditions de la victoire ne sont pas réunies et que l'on n'a pas dépassé le nombre d'essais max
        do {
            System.out.println();

            //On demande à l'utilisateur de faire une proposition en saisissant une valeur
            propositionJoueur = dialogApi.entrerProposition();

            //On s'assure que l'utilisateur ait saisi une valeur correcte à l'aide d'un booléen
            verifChiffres();

            //L'ordinateur compare la valeur saisie à celle du nombre mystère
            reponseIA = gameIA.comparerValeur(propositionJoueur, nbMystereIA);

            //On incrémente afin d'avoir le nombre d'essais du joueur
            nbEssais++;

            //On affiche le nombre d'essais en cours
            System.out.println("Essai N° " + nbEssais);

            //On affiche le resultat de la comparaison
            dialogApi.afficherResultat(propositionJoueur, reponseIA);

            //On questionne le booléen sur les conditions de la victoire
            victoireJoueur = gagneOK(reponseIA);

        } while (!victoireJoueur && nbEssais < config.getNbEssaisMax());

        System.out.println();

        if (victoireJoueur) {

            logger.info("Victoire de l'utilisateur ");

            System.out.println("Bravo, vous avez gagné en " + nbEssais + " essai(s)! ");

        } else {

            logger.info("Victoire de l'ordinateur ");

            System.out.println("Désolé, vous avez perdu , vous avez épuisez le nombre de tentatives (" + config.getNbEssaisMax() + ") !\n" +
                    "La combinaison secrète à trouver était : " + nbMystereIA);
        }

        System.out.println();

        //On propose à l'utilisateur les options de fin de partie
        finDePartie();
    }


}

