package main.java;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class Config {
    public boolean modeDev;
    public int nbDeChiffres;
    public int nbEssaisMax;

    public Config() throws IOException {
        // TODO trouver le bon chemin relatif
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\sifk\\IdeaProjects\\Workspace\\escape-game\\src\\main\\resources\\config.properties"));
        BufferedInputStream bis = new BufferedInputStream(fis);

        Properties proprietes = new Properties();
        proprietes.load(bis);

        fis.close();
        bis.close();

        modeDev = parseBoolean(proprietes.getProperty("modeDev"));
        nbDeChiffres = parseInt(proprietes.getProperty("nbDeChiffres"));
        nbEssaisMax = parseInt(proprietes.getProperty("nbEssaisMax"));
    }

    public boolean getModeDev() {
        return modeDev;
    }

    public int getNbDeChiffres() {
        return nbDeChiffres;
    }

    public int getNbEssaisMax() {
        return nbEssaisMax;
    }
}
