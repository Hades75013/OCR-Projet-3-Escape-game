package main;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class Config {
    private boolean modeDev;
    private int nbDeChiffres;
    private int nbEssaisMax;

    //Constructeur
    public Config() throws IOException {

        //On lit le fichier de configuration config.properties
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\sifk\\IdeaProjects\\Workspace\\escape-game\\src\\main\\resources\\config.properties"));
        BufferedInputStream bis = new BufferedInputStream(fis);

        //On charge le fichier lu dans l'objet proprietes de la classe Properties
        Properties proprietes = new Properties();
        proprietes.load(bis);

        fis.close();
        bis.close();

        //on attribue les valeurs du fichier config aux variables de la classe Config
        modeDev = parseBoolean(proprietes.getProperty("modeDev"));
        nbDeChiffres = parseInt(proprietes.getProperty("nbDeChiffres"));
        nbEssaisMax = parseInt(proprietes.getProperty("nbEssaisMax"));
    }

    //On crée des getters pour chaques variables de portée private afin de pouvoir les utiliser en dehors de cette classe
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
