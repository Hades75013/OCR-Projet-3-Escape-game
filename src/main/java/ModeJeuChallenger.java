package main.java;


import static main.java.SaisiesException.nbDeChiffreOK;


public class ModeJeuChallenger extends ModeJeu {

    public ModeJeuChallenger(Config config) {
        this.config = config;
    }

    public void run() {

        //Message d'accueil avec énoncé des règles du mode de jeu
        System.out.println("Bienvenue dans ce mode de jeu ! Voici l'énoncé des règles : \n" +
                "L'ordinateur a défini une combinaison de " + config.getNbDeChiffres() + " chiffres que vous devez deviner en " + config.getNbEssaisMax() + " essais maximum !\n" +
                "A vous de jouer ! Bonne chance !");

        System.out.println();

        //Generation de la combinaison aléatoire par l'ordinateur
        nbMystereIA = String.format("%04d", gameIA.genererCombinaisonAleatoire());

        if (config.getModeDev()) {

            System.out.println("(nbMystereIA = " + nbMystereIA + ")");
        }

        nbEssais = 0;

        //On boucle tant que les conditions de la victoire ne sont pas réunies
        do {
            //On demande à l'utilisateur de faire une proposition en saisissant une valeur

            propositionJoueur = dialogApi.entrerProposition();

            do {

                exceptionNbDeChiffre = nbDeChiffreOK(propositionJoueur);

                if (!exceptionNbDeChiffre) {

                    logger.info("Mauvaise saisie de l'utilisateur pour la proposition : nombre de caractère superieur à " + config.getNbDeChiffres() + " ou/et differents d'un chiffre");

                    System.out.print("Veuillez saisir uniquement 4 chiffres svp : ");
                    propositionJoueur = sc.nextLine();
                }

            } while (!exceptionNbDeChiffre);


            //On compare la valeur saisie et celle du nombre mystère
            reponseIA = gameIA.comparerValeurChallenger(propositionJoueur, nbMystereIA);

            //On affiche le resultat de la comparaison
            dialogApi.afficherResultat(propositionJoueur, reponseIA);

            //On questionne le booleen sur les conditions de la victoire
            victoireJoueur = isWin(reponseIA);

            //On incrémente afin d'avoir le nombre d'essais du joueur
            nbEssais++;

        } while (!victoireJoueur && nbEssais <= config.getNbEssaisMax());

        System.out.println();

        if (victoireJoueur) {

            logger.info("Victoire de l'utilisateur ");

            System.out.println("Bravo, vous avez gagné en " + nbEssais + " essai(s)! ");

        } else {

            logger.info("Victoire de l'ordinateur ");

            System.out.println("Désolé, vous avez perdu , vous avez épuisez le nombre de tentatives ! (" + config.getNbEssaisMax() + ")\n" +
                    "La combinaison secrète à trouver était : " + nbMystereIA);
        }

        System.out.println();

        messageFinDePartie();
    }

}

