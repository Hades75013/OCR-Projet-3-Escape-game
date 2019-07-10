package main.java.enums;

import main.java.*;

public enum ModeDeJeu {

    CHALLENGER(1) {
        @Override
        public ModeJeu initJeu(Config config) {
            return new ModeJeuChallenger(config);
        }
    },
    DEFENSEUR(2) {
        @Override
        public ModeJeu initJeu(Config config) {
            return new ModeJeuDefenseur(config);
        }
    },
    DUEL(3) {
        @Override
        public ModeJeu initJeu(Config config) {
            return new ModeJeuDuel(config);
        }
    };


    Integer mode;

    ModeDeJeu(Integer mode) {
        this.mode = mode;
    }


    public static ModeDeJeu valueFromInt(Integer value) {
        for (ModeDeJeu modeDeJeu : ModeDeJeu.values()) {
            if (modeDeJeu.mode.equals(value)) {
                return modeDeJeu;
            }
        }
        return null;
    }

    public abstract ModeJeu initJeu(Config config);
}
