
public class Equipos {
    int codigo;
    String nombre;
    String ciudad;
    int capacidad;
    public Equipos(int codigo, String nombre, String ciudad, int capacidad){
    this.codigo = codigo;
    this.nombre= nombre;
    this.ciudad= ciudad;
    this.capacidad= capacidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
