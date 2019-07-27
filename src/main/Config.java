package main;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class Config {

    final Logger logger = Logger.getLogger(Config.class);
    private boolean modeDev;
    private int nbDeChiffres;
    private int nbEssaisMax;

    //Constructeur
    public Config()  {

    }

    public void chargementConfig() {
        try {
            Properties proprietes = getProperties();
            //on attribue les valeurs du fichier config aux variables de la classe Config
            modeDev = parseBoolean(proprietes.getProperty("modeDev"));
            nbDeChiffres = parseInt(proprietes.getProperty("nbDeChiffres"));
            nbEssaisMax = parseInt(proprietes.getProperty("nbEssaisMax"));
        } catch (IOException e) {
            modeDev =false;
            nbDeChiffres =4;
            nbEssaisMax =10;
            logger.error("Erreur lors du chargement du fichier "+e.getMessage());
            logger.info("Configuration par default \n  - modeDev = false\n  - nbDeChiffres = 4\n  - nbEssaisMax = 10");
        }
    }

    private Properties getProperties() throws IOException {
        //On lit le fichier de configuration config.properties
        FileInputStream fis = null;
        fis = new FileInputStream(new File("C:\\Users\\sifk\\IdeaProjects\\Workspace\\escape-game\\src\\main\\resources\\config.properties"));
        BufferedInputStream bis = new BufferedInputStream(fis);
        //On charge le fichier lu dans l'objet proprietes de la classe Properties
        Properties proprietes = new Properties();
        proprietes.load(bis);
        //On ferme les flux ouverts pour la lecture
        fis.close();
        bis.close();

        return proprietes;
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
