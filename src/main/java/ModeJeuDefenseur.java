package main.java;


import static main.java.SaisiesException.signesOK;

public class ModeJeuDefenseur extends ModeJeu {

    public ModeJeuDefenseur(Config config) {
        this.config = config;
    }

    public void run() {
        System.out.println("Bienvenue dans ce mode de jeu ! Voici l'énoncé des règles : \n" +
                "Vous devez definir une combinaison de " + config.getNbDeChiffres() + " chiffres que l'ordinateur doit deviner en " + config.getNbEssaisMax() + " essais maximum !\n" +
                "A vous de jouer ! Bonne chance !");

        nbEssais = 0;

        System.out.println("Veuillez definir une combinaison de " + config.getNbDeChiffres() + " chiffres ...");

        System.out.println();

        propositionIA = String.format("%04d", gameIA.genererCombinaisonAleatoire());
        System.out.println("Proposition de l'IA : " + propositionIA);


        do {
            System.out.print("Veuillez saisir les indications à l'aide des signes +, -, et = : ");

            do {
                reponseJoueur = sc.nextLine();

                exceptionNbCaractere = signesOK(reponseJoueur);

                if (!exceptionNbCaractere) {
                    logger.info("Mauvaise saisie de l'utilisateur pour la proposition : nombre de caractère superieur à " + config.getNbDeChiffres());

                    System.out.print("Veuillez saisir uniquement 4 caractères avec les signes +, - et = svp : ");

                }
            } while (!exceptionNbCaractere);


            dialogApi.afficherResultat(propositionIA, reponseJoueur);

            nbEssais++;

            victoireIA = isWin(reponseJoueur);

            if (victoireIA) {
                System.out.println("Désolé, vous avez perdu ! L'ordinateur a réussi à deviner votre combinaison secrète en " + (nbEssais) + " essai(s)\n");

                logger.info("victoire de l'ordinateur");

            } else if (nbEssais < config.getNbEssaisMax()) {
                propositionIA = gameIA.genererCombinaisonParametres(propositionIA, reponseJoueur);
                System.out.println("Proposition de l'IA : " + propositionIA);
            }

        }
        while (!victoireIA && nbEssais < config.getNbEssaisMax());

        if (nbEssais == config.getNbEssaisMax()) {

            logger.info("victoire de l'utilisateur");

            System.out.println("Bravo, vous avez gagné ! L'ordinateur n'a pas réussi à deviner votre combinaison secrète en " + config.getNbEssaisMax() + " essais!");

        }

        System.out.println();

        messageFinDePartie();


    }
}







