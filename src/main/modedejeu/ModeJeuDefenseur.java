package main.modedejeu;


import main.Config;


public class ModeJeuDefenseur extends ModeDeJeu {

    public ModeJeuDefenseur(Config config) {
        this.config = config;
    }

    public void lancerPartie() {

        //Message d'accueil avec énoncé des règles du mode de jeuplusoumoins
        System.out.println("Bienvenue dans ce mode de jeuplusoumoins ! Voici l'énoncé des règles : \n" +
                "Vous devez définir une combinaison de " + config.getNbDeChiffres() + " chiffres que l'ordinateur doit deviner en " + config.getNbEssaisMax() + " essais maximum !\n" +
                "A vous de jouer ! Bonne chance !");


        System.out.println("Veuillez définir une combinaison de " + config.getNbDeChiffres() + " chiffres ...");

        System.out.println();

        //Génération de la combinaison aléatoire par l'ordinateur
        propositionIA = String.format("%04d", gameIA.genererCombinaisonAleatoire());
        System.out.println("Proposition de l'IA : " + propositionIA);

        nbEssais = 0;

        //On boucle tant que les conditions de la victoire de l'ordinateur ne sont pas réunies et que l'on n'a pas atteint le nombre d'essais max
        do {
            //On demande à l'utilisateur de rendre une réponse en saisissant les signes +,- ou =
            reponseJoueur = dialogApi.entrerReponse();

            //On s'assure que l'utilisateur ait saisi une valeur correcte à l'aide d'un booléen
            verifSignes();

            //On incrémente afin d'avoir le nombre d'essais du joueur
            nbEssais++;

            //On affiche le nombre d'essais en cours
            System.out.println("Essai N° " + nbEssais);

            //On affiche le resultat de la comparaison
            dialogApi.afficherResultat(propositionIA, reponseJoueur);

            //On questionne le booléen sur les conditions de la victoire
            victoireIA = gagneOK(reponseJoueur);

            //Si victoire de l'ordinateur au premier essai
            if (victoireIA) {
                logger.info("victoire de l'ordinateur");

                System.out.print("Désolé, vous avez perdu ! L'ordinateur a réussi à deviner votre combinaison secrète en " + (nbEssais) + " essai(s)\n");

                //Sinon l'ordinateur continue de faire une proposition
            } else if (nbEssais < config.getNbEssaisMax()) {

                System.out.println();

                propositionIA = gameIA.genererCombinaisonParametres(propositionIA, reponseJoueur);
                System.out.println("Proposition de l'IA : " + propositionIA);
            }

        } while (!victoireIA && nbEssais < config.getNbEssaisMax());

        //Si le nombre d'essais max est atteint par l'ordinateur sans avoir deviné la combinaison, l'utilisateur a gagné
        if (nbEssais == config.getNbEssaisMax()) {
            logger.info("victoire de l'utilisateur");

            System.out.println("Bravo, vous avez gagné ! L'ordinateur n'a pas réussi à deviner votre combinaison secrète en " + config.getNbEssaisMax() + " essais!");
        }

        System.out.println();

        //On propose à l'utilisateur les options de fin de partie
        finDePartie();

    }


}







