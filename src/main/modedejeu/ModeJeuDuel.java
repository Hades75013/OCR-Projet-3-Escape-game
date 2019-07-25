package main.modedejeu;


import main.Config;


public class ModeJeuDuel extends ModeDeJeu {

    public ModeJeuDuel(Config config) {
        this.config = config;
    }

    public void lancerPartie() {
        //Message d'accueil avec énoncé des règles du mode de jeuplusoumoins
        System.out.println("Bienvenue dans ce mode de jeuplusoumoins ! Voici l'énoncé des règles : \n" +
                "Vous devez définir une combinaison de " + config.getNbDeChiffres() + " chiffres que l'ordinateur doit deviner !\n" +
                "Mais l'ordinateur doit également définir une combinaison que vous devez deviner !\n" +
                "Chacun joue à tour de rôle jusqu'à trouver en premier la combinaison de l'autre ...\n" +
                "A vous de jouer ! Bonne chance !\n");

        //On demande à l'utilisateur de définir une combinaison à deviner par l'ordinateur
        System.out.println("Veuillez réflechir à une combinaison à " + config.getNbDeChiffres() + " chiffres ...");

        System.out.println();

        //Génération par l'ordinateur de la combinaison aléatoire à deviner par l'utilisateur
        System.out.println("C'est au tour de l'ordi de générer une combinaison, il réfléchit ... et a choisi lui aussi sa combinaison.");
        nbMystereIA = String.format("%04d", gameIA.genererCombinaisonAleatoire());

        System.out.println();

        //On questionne si le mode développeur est activé
        if (config.getModeDev()) {
            System.out.println("(nbMystereIA = " + nbMystereIA + ")");
        }

        System.out.println();

        nbEssais = 0;
        //Echange proposition de l'utilisateur - reponse de l'ordinateur
        tourJoueur();
        System.out.println();
        //Echange proposition de l'ordinateur - reponse de l'utilisateur
        tourIA();

        //On boucle tant que les conditions de la victoire de l'utilisateur ou de l'ordinateur ne sont pas réunies
        do {
            //On incrémente afin d'avoir le nombre d'essais du joueur et de l'ordinateur
            nbEssais++;

            //On affiche le nombre d'essais en cours
            System.out.println("Tour N° " + nbEssais);

            //On questionne les booléens sur les conditions de la victoire de chaque joueur
            victoireIA = gagneOK(reponseJoueur);
            victoireJoueur = gagneOK(reponseIA);

            //Si victoire de l'un ou de l'autre dès le premier essai
            if (victoireJoueur) {
                logger.info("Victoire de l'utilisateur");

                System.out.print("Bravo ! Vous avez gagné, vous avez deviné la combinaison avant l'ordinateur en " + nbEssais + " essai(s) !");

            } else if (victoireIA) {
                logger.info("Victoire de l'ordinateur");

                System.out.print("Désolé ! Vous avez perdu, l'ordinateur a deviné la combinaison avant vous en " + nbEssais + " essai(s)!\n" +
                        "Sa combinaison secrète à trouver était :" + nbMystereIA);

                System.out.println();

                //Sinon on boucle un nouveau tour de jeuplusoumoins tant qu'il n'y a pas la victoire de l'un ou l'autre
            } else {

                System.out.println();

                tourJoueur();

                System.out.println();

                //Echange proposition de l'ordinateur avec paramètres - reponse de l'utilisateur
                tourIAParametres();
            }

        } while (!victoireIA && !victoireJoueur);

        System.out.println();

        //On propose à l'utilisateur les options de fin de partie
        finDePartie();

    }


    private void tourJoueur() {

        //On demande à l'utilisateur de commencer en premier en faisant une proposition
        propositionJoueur = dialogApi.entrerProposition();

        //On s'assure que l'utilisateur ait saisi une valeur correcte à l'aide d'un booléen
        verifChiffres();

        //L'ordinateur compare la valeur saisie à celle du nombre mystère
        reponseIA = gameIA.comparerValeur(propositionJoueur, nbMystereIA);
        System.out.println("L'ordi vous donne des indications à l'aide des signes +, -, et = : " + reponseIA);

        //On affiche le resultat de la comparaison
        dialogApi.afficherResultat(propositionJoueur, reponseIA);
    }


    private void tourIA() {

        //C'est au tour de l'ordinateur de commencer en générant une combinaison aléatoire
        propositionIA = String.format("%04d", gameIA.genererCombinaisonAleatoire());
        System.out.println("L'ordi propose une combinaison : " + propositionIA);

        //On demande à l'utilisateur de rendre une réponse en saisissant les signes +,- ou =
        reponseJoueur = dialogApi.entrerReponse();

        //On s'assure que l'utilisateur ait saisi une valeur correcte à l'aide d'un booléen
        verifSignes();

        //On affiche le resultat de la comparaison
        dialogApi.afficherResultat(propositionIA, reponseJoueur);
    }


    private void tourIAParametres() {
        //Dorénavant, l'ordinateur fait une proposition mais en prenant en compte les indications de l'utilisateur
        propositionIA = gameIA.genererCombinaisonParametres(propositionIA, reponseJoueur);
        System.out.println("L'ordi propose une combinaison : " + propositionIA);

        //On demande à l'utilisateur de rendre une réponse en saisissant les signes +,- ou =
        reponseJoueur = dialogApi.entrerReponse();

        //On s'assure que l'utilisateur ait saisi une valeur correcte à l'aide d'un booléen
        verifSignes();

        //On affiche le resultat de la comparaison
        dialogApi.afficherResultat(propositionIA, reponseJoueur);
    }
}










