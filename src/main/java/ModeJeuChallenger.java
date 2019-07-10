package main.java;

import java.util.Scanner;

public class ModeJeuChallenger extends ModeJeu {
    Config config;

    public ModeJeuChallenger(Config config) {
        this.config = config;
    }

    public void run() {

        //Message d'accueil avec énoncé des règles du mode de jeu
        System.out.println("Bienvenue dans ce mode de jeu ! Voici l'énoncé des règles : \n" +
                "L'ordinateur a défini une combinaison de " + nbDeChiffres + " chiffres que vous devez deviner en " + nbEssaiMax + " essais maximum !\n" +
                "A vous de jouer ! Bonne chance !");

        System.out.println();

        //Generation de la combinaison aléatoire par l'ordinateur
        GameIA gameIA = new GameIA();
        nbMystereIA = String.format("%04d", gameIA.genererCombinaisonAleatoire());

        if (config.getModeDev()) {
            System.out.println("(nbMystereIA = " + nbMystereIA + ")");
        }

        nbEssais = 0;
        Scanner sc = new Scanner(System.in);


        //On boucle tant que les conditions de la victoire ne sont pas réunies
        do {
            //On demande à l'utilisateur de faire une proposition en saisissant une valeur
            propositionJoueur = dialogApi.entrerProposition();

            do {
                exceptionNbCaractere = SaisiesException.nbDeCaractereOK(propositionJoueur);
                if (exceptionNbCaractere = true)
                    System.out.print("Veuillez saisir uniquement 4 caractères svp : ");
                propositionJoueur = sc.nextLine();

            } while (propositionJoueur.length() != 4);


            //On compare la valeur saisie et celle du nombre mystère
            reponseIA = gameIA.comparerValeurChallenger(propositionJoueur, nbMystereIA);

            //On affiche le resultat de la comparaison
            dialogApi.afficherResultat(propositionJoueur, reponseIA);

            //On questionne le booleen sur les conditions de la victoire
            victoireJoueur = isWin(reponseIA);

            //On incrémente afin d'avoir le nombre d'essais du joueur
            nbEssais++;

        } while (!victoireJoueur && nbEssais <= nbEssaiMax);

        System.out.println();

        if (victoireJoueur) {
            System.out.println("Bravo, vous avez gagné en " + nbEssais + " essai(s)! ");

        } else {
            System.out.println("Désolé, vous avez perdu , vous avez épuisez le nombre de tentatives ! (" + nbEssaiMax + ")\n" +
                    "La combinaison secrète à trouver était : " + nbMystereIA);
        }

        System.out.println();

        messageFinDePartie();
    }

}

