
package base.de.datos;


public class Objeto {
    private int clave;
    private String nombre,grado;

    public Objeto(int clave, String nombre, String grado) {
        this.clave = clave;
        this.nombre = nombre;
        this.grado = grado;
    }

    public String getNombre() {
        return this. nombre;
    }

    public String getGrado() {
        return this. grado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public int getClave() {
        return this. clave;
    }
   
}
