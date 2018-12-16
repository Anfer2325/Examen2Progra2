
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    static Scanner leer = new Scanner(System.in);
    static RandomAccessFile rafEquipos,rafJugadores,rafCodigo;
    static File f = new File(System.getProperty("user.dir"));
   
 public static void main(String [] args) {
     File equipos= new File(f,"Equipos.tm");
     File jugadores = new File(f,"Jugadores.tm");
     try{
        
     rafEquipos = new RandomAccessFile(equipos,"rw");
     rafJugadores= new RandomAccessFile(jugadores,"rw");
     }catch(Exception e){System.out.println("Error");}
    do{
        System.out.println("1. Crear equipo");
        System.out.println("2. Modificar");
        System.out.println("3. Eliminar Equipos");
        System.out.println("4. Crear Jugador");
        System.out.println("6. Listar jugadores por edad");
        System.out.println("7. Listar equipos con jugadores");
        int opcion = leer.nextInt();
        
        switch(opcion){
            case 1: 
                System.out.println("Ingrese el nombre");
                leer.nextLine();
                String titulo = leer.nextLine();
                System.out.println("Ingrese ciudad");
               
                String ciudad = leer.nextLine();
                System.out.println("Ingrese Capacidad");
                int capacidad = leer.nextInt();
                try{
                Equipos nuevo = new Equipos(Codigo(),titulo,ciudad,capacidad);
               
                rafEquipos.seek(rafEquipos.length());
                rafEquipos.writeInt(nuevo.getCodigo());
                rafEquipos.writeUTF(nuevo.getNombre());
                rafEquipos.writeUTF(nuevo.getCiudad());
                rafEquipos.writeInt(nuevo.getCapacidad());
                                              
                }catch(Exception e){System.out.println("No se pudo crear Equipo");
                    System.out.println(e.fillInStackTrace());
                }
                break;
                
            case 2:
                do{
                
                    System.out.println("1. Modificar Nombre");
                    System.out.println("2. Modificar Ciudad");
                    System.out.println("3. Modificar Capacidad del estadio");
                    System.out.println("4.Salir ");
                    opcion = leer.nextInt();
                    ArrayList<Equipos> arrayequipos = new ArrayList<>();
                    try{
                    rafEquipos.seek(0);
                    while(rafEquipos.getFilePointer()<rafEquipos.length()){
                        Equipos capturado = new Equipos(rafEquipos.readInt(),rafEquipos.readUTF(),rafEquipos.readUTF(),rafEquipos.readInt());
                        arrayequipos.add(capturado);
                        
                    }
                    
                    }catch(Exception e ){System.out.println("Error capturando Equipos");}
                    switch(opcion){
                        case 1:
                                System.out.println("Ingrese el codigo del equipo");
                                int codigo= leer.nextInt();
                                System.out.println("Ingrese el nuevo nombre: ");
                                leer.nextLine();
                                String nombre = leer.nextLine();
                                try{equipos.delete();
                                rafEquipos.seek(0);
                                for(Equipos f : arrayequipos){
                                    if(f.getCodigo()==codigo){
                                        rafEquipos.writeInt(f.getCodigo());
                                        rafEquipos.writeUTF(nombre);
                                        rafEquipos.writeUTF(f.getCiudad());
                                        rafEquipos.writeInt(f.getCapacidad());
                                    }else{
                                        rafEquipos.writeInt(f.getCodigo());
                                        rafEquipos.writeUTF(f.getNombre());
                                        rafEquipos.writeUTF(f.getCiudad());
                                        rafEquipos.writeInt(f.getCapacidad());
                                    }
                                    
                                }
                                }catch(Exception e){System.out.println("Error al cambiar nombre");}
                            break;
                            
                        case 2: 
                           System.out.println("Ingrese el codigo del equipo");
                                int codigo2= leer.nextInt();
                                System.out.println("Ingrese la nueva ciudad: ");
                                leer.nextLine();
                                String ciudad2 = leer.nextLine();
                                try{equipos.delete();
                                rafEquipos.seek(0);
                                for(Equipos f : arrayequipos){
                                    if(f.getCodigo()==codigo2){
                                        rafEquipos.writeInt(f.getCodigo());
                                        rafEquipos.writeUTF(f.getNombre());
                                        rafEquipos.writeUTF(ciudad2);
                                        rafEquipos.writeInt(f.getCapacidad());
                                    }else{
                                        rafEquipos.writeInt(f.getCodigo());
                                        rafEquipos.writeUTF(f.getNombre());
                                        rafEquipos.writeUTF(f.getCiudad());
                                        rafEquipos.writeInt(f.getCapacidad());
                                    }
                                    
                                } 
                                  }catch(Exception e){System.out.println("Error al cambiar musica");}
                            break;
                            
                        case 3:
                            System.out.println("Ingrese el codigo del equipo");
                                int codigo3= leer.nextInt();
                                System.out.println("Ingrese la nueva capacidad: ");
                                leer.nextLine();
                                String capacidad2 = leer.nextLine();
                                try{equipos.delete();
                                rafEquipos.seek(0);
                                for(Equipos f : arrayequipos){
                                    if(f.getCodigo()==codigo3){
                                        rafEquipos.writeInt(f.getCodigo());
                                        rafEquipos.writeUTF(f.getNombre());
                                        rafEquipos.writeUTF(f.getCiudad());
                                        rafEquipos.writeInt(Integer.valueOf(capacidad2));
                                    }else{
                                        rafEquipos.writeInt(f.getCodigo());
                                        rafEquipos.writeUTF(f.getNombre());
                                        rafEquipos.writeUTF(f.getCiudad());
                                        rafEquipos.writeInt(f.getCapacidad());
                                    }
                                    
                                } 
                                  }catch(Exception e){System.out.println("Error al cambiar musica");}
                            break;
                    }
                
                }while(opcion<4);
                
            case 3:
                System.out.println("Ingrese el codigo del Equipo que quiere Eliminar");
                int codigoEliminar= leer.nextInt();
                
                 ArrayList<Equipos> arrayequipos = new ArrayList<>();
                    try{
                    rafEquipos.seek(0);
                    while(rafEquipos.getFilePointer()<rafEquipos.length()){
                        Equipos capturado = new Equipos(rafEquipos.readInt(),rafEquipos.readUTF(),rafEquipos.readUTF(),rafEquipos.readInt());
                        arrayequipos.add(capturado);
                        
                    }
                    
                    }catch(Exception e ){System.out.println("Error capturando Equipos");}
                    try{
                    rafEquipos.seek(0);
                   
                   
                    
                    for(Equipos f:arrayequipos){
                        if(f.getCodigo()==codigoEliminar){
                          rafEquipos.writeInt(0);
                            rafEquipos.writeUTF(f.getNombre());
                            rafEquipos.writeUTF(f.getCiudad());
                            rafEquipos.writeInt(f.getCapacidad());
                        }else{
                            rafEquipos.writeInt(f.getCodigo());
                            rafEquipos.writeUTF(f.getNombre());
                            rafEquipos.writeUTF(f.getCiudad());
                            rafEquipos.writeInt(f.getCapacidad());
                        }
                    }
                    }catch(Exception e){System.out.println("Error ELiminando Equipo");System.out.println(e.fillInStackTrace());}
                    
                
                break;
            case 4:
              ArrayList<Equipos> arrayequipos2 = new ArrayList<>();
                    try{
                    rafEquipos.seek(0);
                    while(rafEquipos.getFilePointer()<rafEquipos.length()){
                        Equipos capturado = new Equipos(rafEquipos.readInt(),rafEquipos.readUTF(),rafEquipos.readUTF(),rafEquipos.readInt());
                        arrayequipos2.add(capturado);
                        
                    }
                    }catch(Exception e ){System.out.println("Error capturando Equipos"); System.out.println(e.fillInStackTrace());}
                    System.out.println("Seleccione el equipo que desea");
                    for(Equipos f : arrayequipos2){
                        if(f.getCodigo()!=0){
                        System.out.println(f.getCodigo()+". "+f.getNombre());}
                    }
                    int codequipo = leer.nextInt();
                    System.out.println(" Ingrese el nombre del jugador: ");
                    leer.nextLine();
                    String nombreJugador = leer.nextLine();
                    System.out.println("Ingrese el numero del dorsal");
                    int dorsal = leer.nextInt();
                    System.out.println("Ingrese la posicion");
                    String posicion= leer.next();
                    System.out.println("Ingrese la edad");
                    int edad = leer.nextInt();
                    System.out.println("Nacionalidad");
                    String nacionalidad = leer.next();
                    try{
                    Jugadores jugador = new Jugadores(codequipo,nombreJugador,dorsal,posicion,edad,nacionalidad);
                    rafJugadores = new RandomAccessFile(jugadores,"rw");
                    rafJugadores.seek(rafJugadores.length());
                    rafJugadores.writeInt(jugador.getCodigoEquipo());
                    rafJugadores.writeUTF(jugador.getNombre());
                    rafJugadores.writeInt(jugador.getDorsal());
                    rafJugadores.writeUTF(jugador.getPosicion());
                    rafJugadores.writeInt(jugador.getEdad());
                    rafJugadores.writeUTF(jugador.getNacionalidad());
                    }catch(Exception e ){System.out.println("Error el crear juguador");}
                break;
                
            case 7: 
                try{
                rafEquipos.seek(0);
                rafJugadores.seek(0);
                while(rafEquipos.getFilePointer()<rafEquipos.length()){
                    
                    int cod =rafEquipos.readInt();
                    String equipo=rafEquipos.readUTF();
                    if(cod!=0){
                    rafJugadores.seek(0);
                    System.out.println("Equipo : "+ equipo);
                    while(rafJugadores.getFilePointer()<rafJugadores.length()){
                        
                        if(rafJugadores.readInt()==cod){
                            
                            System.out.println("Nombre: "+rafJugadores.readUTF()+" Dorsal: "+rafJugadores.readInt());
                            rafJugadores.readUTF();
                            rafJugadores.readInt();
                            rafJugadores.readUTF();
                            
                        }else{
                            rafJugadores.readUTF();
                            rafJugadores.readInt();
                             rafJugadores.readUTF();
                            rafJugadores.readInt();
                            rafJugadores.readUTF();
                        }
                    
                    }
                     
                   rafEquipos.readUTF();
                   rafEquipos.readInt();
                    }else{
                  
                   rafEquipos.readUTF();
                   rafEquipos.readInt();}
                    
                }
                }catch(Exception e){System.out.println("Error al listar equipos");System.out.println(e.fillInStackTrace());}
                break;
                
            case 6:
                try{
                rafJugadores.seek(0);
                ArrayList<Jugadores> jugadoresarray = new ArrayList<>();
                while(rafJugadores.getFilePointer()<rafJugadores.length()){
                 Jugadores jugador= new Jugadores(rafJugadores.readInt(),rafJugadores.readUTF(),rafJugadores.readInt(),rafJugadores.readUTF(),rafJugadores.readInt(),rafJugadores.readUTF());
                 jugadoresarray.add(jugador);
                }
               ArrayList<Integer>edades = new ArrayList<>();
               
                for(Jugadores x:jugadoresarray){
                    edades.add(x.getEdad());
                    
                }
                Collections.sort(edades);
                int po= 0;
                for(int g=0;g<=jugadoresarray.size();g++){
                    if(jugadoresarray.get(g).getEdad()==edades.get(po)){
                        System.out.println(jugadoresarray.get(g).getNombre());
                        g--;
                        po+=1;
                    }
                }
                }catch(Exception e){System.out.println("Error al listar los jugadores por edad");}
                break;
            
        }
    
    
    }while(true);
 } 

public static int Codigo()throws Exception{
File codigos = new File(f,"codes.tm");
rafCodigo=new RandomAccessFile(codigos,"rw");
rafCodigo.seek(0);
if(!codigos.isFile()){
codigos.createNewFile();
}

if(rafCodigo.length()==0){
rafCodigo.seek(0);
int codigo = 1;
rafCodigo.writeInt(codigo);
  
}
rafCodigo.seek(0);
int codigo = rafCodigo.readInt();
rafCodigo.seek(0);
rafCodigo.writeInt(codigo+1);
return codigo;
}
}


