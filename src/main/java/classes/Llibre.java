package classes;

import pkgFitxers.Fitxers;

import javax.swing.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * CLASSE llibre
 * representa un llibre
 * es podrà guardar en fitxers
 * per això implementa la classe serializable
 */
public class Llibre implements Serializable {


    // <editor-fold defaultstate="collapsed" desc="Variables i constructors classe">

    //////////////////////////////////////////
    // variables classe (propietats objectes)
    //////////////////////////////////////////

    private String titol;
    private int numeroPagines;
    private String dimensions;
    private String ColorPortada;
    private int anyEdicio;
    private String contingutLlibre;

    private List<String> autors_id=new ArrayList<>();    // VARIABLE DEPEN D'AUTOR. Agafarem l'ID



    private static String dir=".data";
    private static String rutaFitxer=dir+"/.llibres.dat";


    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">

    public String getTitol() {
        return titol;
    }

    public int getNumeroPagines() {
        return numeroPagines;
    }

    public String getDimensions() {
        return dimensions;
    }


    public String getColorPortada() {
        return ColorPortada;
    }

    public int getAnyEdicio() {
        return anyEdicio;
    }

    public String getContingutLlibre() {
        return contingutLlibre;
    }

    public List<String> getAuts() {
        return autors_id;
    }

    public static String getRutaFitxer() {
        return rutaFitxer;
    }


    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Mètodes classe">


    // CONSTRUCTORS
    public Llibre() {
    }

    public Llibre(String titol, int numeroPagines, String dimensions,
                  String colorPortada, int anyEdicio, String contingutLlibre, List<String> autors_id) {
        this.titol = titol;
        this.numeroPagines = numeroPagines;
        this.dimensions = dimensions;
        ColorPortada = colorPortada;
        this.anyEdicio = anyEdicio;
        this.contingutLlibre = contingutLlibre;
        this.autors_id = autors_id;
    }


    /**
     * Escriu un objecte en un fitxer binari
     * utilitzant la llibreria fitxers
     */
    public void escriuObjecteEnFitxerBinari() throws IOException {
        Fitxers f = new Fitxers();
        // comprovar directori
        if (!f.existeix("fitxers"))
            f.creaDirectori("fitxers");

        // escriure en fitxer
        if (!f.existeix(rutaFitxer))
            f.escriuObjecteFitxer(this,rutaFitxer, false);
        else
            f.escriuObjecteFitxer(this,rutaFitxer, true);

    }

    /**
     * Converteix una llista d'Objectes a una llista de llibres
     * @param Lobj Llista d'objectes a convertir
     * @return Llista de llibres
     */
    public List<Llibre> converteixALlibre(List<Object> Lobj) {
        List<Llibre> Llibres = new ArrayList<Llibre>();
        int i;
        for (i = 0; i < Lobj.size(); i++)
            Llibres.add((Llibre) Lobj.get(i));

        return Llibres;
    }

    /**
     * Retorna una llista de llibres amb el contingut del fitxer binari
     * @return Llista de llibres amb el contingut del fitxer binari
     * @throws IOException Excepció d'E/S
     * @throws ClassNotFoundException Excepció  de classe no trobada
     * @throws InterruptedException Excepció d'Interrupció
     */
    public List<Llibre> retornaLlibresEnLlista() throws IOException, ClassNotFoundException, InterruptedException {

        Fitxers f = new Fitxers();
        if (!f.existeix(rutaFitxer)) {
            JOptionPane.showMessageDialog(null, "No existeix el fitxer: \n" + rutaFitxer, "ERROR", 0);
            return null;
        } else {
            List<Object> LObj = f.retornaFitxerObjecteEnLlista(rutaFitxer);
            List<Llibre> LLlibres = converteixALlibre(LObj);
            return LLlibres;
        }
    }



    //</editor-fold>

} // FINAL CLASSE LLIBRE
