
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static Scanner leer = new Scanner(System.in);
    static RandomAccessFile rafEquipos,rafJugadores,rafCodigo;
    static File f = new File(System.getProperty("user.dir"));
   
 public static void main(String [] args) {
     File equipos= new File(f,"Equipos.tm");
     try{
        
     rafEquipos = new RandomAccessFile(equipos,"rw");}catch(Exception e){System.out.println("Error");}
    do{
        System.out.println("1. Crear equipo");
        System.out.println("2. Modificar");
        System.out.println("3. Eliminar Equipos");
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
                    rafEquipos.close();
                    equipos.delete();
                    
                   /* for(Equipos f:arrayequipos){
                        if(f.getCodigo()==codigoEliminar){
                            System.out.println("Equipo eliminado");
                        }else{
                            rafEquipos.writeInt(f.getCodigo());
                            rafEquipos.writeUTF(f.getNombre());
                            rafEquipos.writeUTF(f.getCiudad());
                            rafEquipos.writeInt(f.getCapacidad());
                        }
                    }*/
                    }catch(Exception e){System.out.println("Error ELiminando Equipo");}
                    
                
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


