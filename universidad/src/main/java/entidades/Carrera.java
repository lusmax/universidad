package entidades;

/**
 *
 * @author ronar
 */
public class Carrera {
     // Atributos
    private int idcarrera;
    private String carrera;

    // Constructor
    public Carrera() {
        //vacio
    }

    public Carrera(String carrera) {
        this.carrera = carrera;
    }
    
    //Getters
    public int getIdcarrera() {
        return idcarrera;
    }

    public String getCarrera() {
        return carrera;
    }
    
    //setters

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setIdcarrera(int idcarrera) {
        this.idcarrera = idcarrera;
    }
    
        
    //Métodos

    @Override
    public String toString() {
        return "Carrera{" + "idcarrera=" + idcarrera + ", carrera=" + carrera + '}';
    }
    
}
