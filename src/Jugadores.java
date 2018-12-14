
public class Jugadores {
    int codigoEquipo;
    String nombre;
    int dorsal;
    String posicion;
    int edad;
    String nacionalidad;
    
           
    public Jugadores(int codigoEquipo, String nombre, int dorsal, String posicion,int edad, String nacionalidad){
        this.codigoEquipo=codigoEquipo;
        this.nombre = nombre;
        this.dorsal= dorsal;
        this.edad = edad;
        this.posicion = posicion;
        this.nacionalidad = nacionalidad;
        
    }



    public int getCodigoEquipo() {
        return codigoEquipo;
    }

    public int getEdad() {
        return edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

   

    public void setCodigoEquipo(int codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    
    
}
