package entidades;

/**
 *
 * @author ronar
 */
public class Carreras {
     // Atributos
    private int idcarrera;
    private String carrera;

    // Constructor
    public Carreras() {
        //vacio
    }

    public Carreras(String carrera) {
        this.carrera = carrera;
    }
    
    //Getters
    public int getIdcarreras() {
        return idcarrera;
    }

    public String getCarrera() {
        return carrera;
    }
    
    //setters

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    //Métodos

    @Override
    public String toString() {
        return "Carreras{" + "idcarrera=" + idcarrera + ", carrera=" + carrera + '}';
    }
    
}
