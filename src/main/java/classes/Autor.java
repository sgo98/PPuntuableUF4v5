package classes;

import pkgFitxers.Fitxers;

import javax.swing.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Autor implements Serializable {

    // <editor-fold defaultstate="collapsed" desc="Variables classe i Constructors">

    private String id;          // identificador de l'autor. No estarà al formulari. Es genera autonumèricament
    private String nom;         // nom de l'autor
    private String cognom;      // cognom de l'autor
    private String editorial;   // editorial de l'autor

    private static String dir = ".data";
    private static String rutaFitxer = dir + "/.autors.dat";

    // constructors
    public Autor() {
    }

    public Autor(String nom,
                 String cognom,
                 String editorial) {
        this.id = generarID(5);     // cada cop que guardem un autor ho farem amb un id de l'últim autor +1
        this.nom = nom;
        this.cognom = cognom;
        this.editorial = editorial;
    }


    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Mètodes classe">

    /**
     * Converteix un LObj en altre tipus d'objecte
     *
     * @param LObj Llista a convertir
     * @return Llista convertida
     */
    public List<Autor> converteixAutor(List<Object> LObj) {
        List<Autor> LAutors = new ArrayList<Autor>();
        int i;
        Autor aut = new Autor();  // nom, cognom, edat
        for (i = 0; i < LObj.size(); i++) {
            LAutors.add((Autor) LObj.get(i));
        }
        return LAutors;
    }

    /**
     * Escriu un objecte en un Fitxer Binari
     *
     * @throws IOException
     */
    public void escriuObjecteEnFitxerBinari() throws IOException {

        Fitxers f = new Fitxers();

        // comprovar directori
        if (!f.existeix(dir))
            f.creaDirectori(dir);


        f.escriuObjecteFitxer(this, rutaFitxer, true);

    }

    /**
     * Cerca un nom d'autor dintre del fitxer
     * retornarà el mateix objecte si el troba
     * o un valor nul si no el troba
     *
     * @param nomAutor nom de l'autor a cercar
     * @return objecte autor si el troba o null si no el troba
     * @throws IOException            excepció d'entrada / sortida
     * @throws ClassNotFoundException excepció de classe no trobada
     */
    public Autor cercarAutor(String nomAutor) throws IOException, ClassNotFoundException, InterruptedException {
        // retorna un objecte autor si el troba
        // en cas que no trobe res torna un null

        List<Autor> LAutors = new ArrayList<Autor>();
        int i = 0;

        // llegim el fitxer d'autors
        LAutors = retornaAutorsEnLlista();

        do {
            if (LAutors.get(i).nom.equals(nomAutor))
                return LAutors.get(i);              // si l'autor existeix, retorna'l
            i++;
        } while (i < LAutors.size());

        return null;                            // si no el trobem retorna null
    }

    /**
     * Retorna autors en llista a partir de la lectura d'un fitxer
     *
     * @return llista d'autors
     * @throws IOException            excepció d'entrada/sortida
     * @throws ClassNotFoundException excepció de classe no trobada
     */
    public List<Autor> retornaAutorsEnLlista() throws IOException, ClassNotFoundException, InterruptedException {

        Fitxers f = new Fitxers();
        if (!f.existeix(rutaFitxer)) {
            JOptionPane.showMessageDialog(null, "No existeix el fitxer: \n" + rutaFitxer, "ERROR", 0);
            return null;
        } else {

            List<Object> LObj = f.retornaFitxerObjecteEnLlista(rutaFitxer);
            List<Autor> LAutors = converteixAutor(LObj);

            return LAutors;
        }
    }

    /**
     * Retorna el nom i cognom d'un autor a partir del seu idAutor
     *
     * @param idAutor Número sencer que representa un autor
     * @return nom i cognom de l'autor. Retorna null si no existeix l'id
     * @throws InterruptedException   excepció d'Interrupcoins
     * @throws IOException            exepció d'E/S
     * @throws ClassNotFoundException exepció de classe no trobada
     */
    public String retornaNomCognomAutor(String idAutor) throws InterruptedException, IOException, ClassNotFoundException {
        List<Autor> auts;
        int i;

        auts = retornaAutorsEnLlista();

        for (i = 0; i < auts.size(); i++) {
            if (auts.get(i).getId().equals(idAutor)) {
                return auts.get(i).getNom() + " " + auts.get(i).getCognom();
            }
        }

        return null;
    }

    /**
     * retorna el total d'autors que hi ha al fitxer
     *
     * @return número sencer del total d'autors que hi han al fitxer
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private String generarID(int numCaracters) {
        // retorna números i lletres aleatoris.
        // depen del numCaracters
        int i;
        Random rnd = new Random();
        String id = "";
        char abc[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm','n', 'o', 'p', 'q', 'r', 's',
                't','u', 'v', 'w', 'x', 'y', 'z'};
        for (i = 0; i < numCaracters; i++) {
            if (rnd.nextInt() % 2 == 0) {
                id = id + rnd.nextInt(10);
            } else
                id = id + abc[rnd.nextInt(abc.length)];
        }
        return id;
    }


    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getRutaFitxer() {
        return rutaFitxer;
    }


    //</editor-fold>


}
