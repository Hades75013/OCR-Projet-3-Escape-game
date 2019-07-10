package main.java;

import main.java.enums.ModeDeJeu;

import java.io.IOException;
import java.util.Scanner;

public abstract class ModeJeu {

    Scanner sc = new Scanner(System.in);
    DialogApi dialogApi = new DialogApi();
    Boolean modeDev = false;


    String nbMystereIA;
    String propositionIA;
    String reponseIA;

    String propositionJoueur;
    String reponseJoueur;

    boolean exceptionChoixMenuOuFinDePartie = true;
    boolean exceptionNbCaractere = true;
    boolean exceptionChiffres = true;
    boolean exceptionSignes = true;


    boolean victoireJoueur = true;
    boolean victoireIA = true;

    protected void run() {
    }


    public boolean isWin(String signe) {
        return signe.equals("====");
    }


    public void messageFinDePartie() {

        int choixOption = dialogApi.choixFinPartie();

        switch (choixOption) {
            case 1:
                rejouerMemeModeDeJeu();
                break;

            case 2:
                menuModeDeJeu();
                break;

            case 3:
                quitterJeu();
                break;

            default:
                System.out.println("Veuillez entrer 1, 2 ou 3 comme valeur svp ! ");
                messageFinDePartie();

        }
    }

    public void menuModeDeJeu() {
        System.out.println("Selectionnez votre mode de jeu\n" +
                "1 - Challenger\n" +
                "2 - Defenseur\n" +
                "3 - Duel\n");

        Integer modeJeu = dialogApi.ChoixModeJeu();

        do {
            exceptionChoixMenuOuFinDePartie = SaisiesException.choixMenuOuFinDePartieOK(modeJeu);
            if (exceptionChoixMenuOuFinDePartie = true) {
                System.out.print("Veuillez saisir uniquement 1,2 ou 3 svp : ");
                modeJeu = sc.nextInt();
            }
        } while (modeJeu != 1 && modeJeu != 2 && modeJeu != 3);

        ModeDeJeu modeJeuEnum = ModeDeJeu.valueFromInt(modeJeu);
        System.out.println("le mode de jeu choisi est " + modeJeuEnum.name());

        Config config = null;
        try {
            config = new Config();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ModeJeu modeJeuObject = modeJeuEnum.initJeu(config);
        modeJeuObject.run();
    }


    public void rejouerMemeModeDeJeu() {
        ModeJeu.this.run();
    }


    public void quitterJeu() {
        System.out.println("Merci d'avoir participé, au revoir et à bientot !");
        System.exit(0);
    }

}
