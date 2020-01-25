/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PERSONAL
 */
public class comandos {
    
    private String dirInicio;
    private String dirFin;
    
    public void setDirI(String dirInicio){
        this.dirInicio=dirInicio;
    }
    public void setDirF(String dirFin){
        this.dirFin=dirFin;
    }
    public String getDirI(String dirInicio){
        return this.dirInicio;
    }
    public String getDirF(){
        return this.dirFin;
    }
    
    public void copiar(String dirInicio , String dirFin ,  int i){
        BufferedInputStream Original = null; 
        BufferedOutputStream Copia = null;
        String cop;
        
        if(i==1)
            cop="Copia_";
        else 
            cop="";
        File dirOrigen = new File( dirInicio);
        if( dirOrigen.exists() == true ){
        try{
                Original = new BufferedInputStream( new FileInputStream( dirOrigen ) );
                Copia = new BufferedOutputStream( new FileOutputStream( dirFin+cop+dirOrigen.getName() ) );
                int copia = Original.read();
                while( copia != -1 ){
                    Copia.write( copia );
                    copia = Original.read();
                }            
                Copia.close();
                Original.close();
            }catch( Exception e ){
                System.out.println( "Error: "+e.getLocalizedMessage() );
            }
        }
        else 
            System.out.println( "No existe el archivo" );
    }
    public void eliminar(String dirInicio){
        File dirOrigen = new File( dirInicio );
        if(dirOrigen.exists()){
            if(dirOrigen.isDirectory()){
                File Lista[] = dirOrigen.listFiles();
                    if( Lista.length > 0 ){
                        for( int x = 0; x < Lista.length; x++ )
                            this.eliminar( Lista[ x ].getPath() );
                    }else
                        dirOrigen.delete();
            }else
                dirOrigen.delete();
            dirOrigen.delete();
        }else 
            System.out.println("No encontrado!");
    }
    public void info(String dirInicio) throws IOException{
        File dirOrigen = new File( dirInicio );
        Path file = Paths.get(dirInicio);
        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
        FileTime date1 = attr.creationTime();
        FileTime date2 = attr.lastAccessTime();
        FileTime date3 = attr.lastModifiedTime();
        DateFormat df = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");
        System.out.println("Hora y fecha de creacion: "+df.format(date1.toMillis()));
        System.out.println("Hora y fecha de ultimo acceso: "+df.format(date2.toMillis()));
        System.out.println("Hora y fecha de modificacion: "+df.format(date3.toMillis()));
        
        System.out.println("nombre del archivo y extencion: "+dirOrigen.getName());
        System.out.println("ruta del archivo: "+dirOrigen.getPath());
        
       
    }
    public void rutaActual(){
        File miDir = new File ("");
        try {
            System.out.println ("Directorio actual: " + miDir.getCanonicalPath());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void ir(String dirInicio){
        File ruta = new File(dirInicio);
        if(ruta.isDirectory()){
            System.setProperty("user.dir", dirInicio);
            System.out.println("Ahora estás en el directorio " + System.getProperty("user.dir"));
        }else {
            System.out.println("Directorio no existe, o inválido");
        }
    }
    public void ejecutar(String dirInicio){
        try {
        File dirOrigen = new File (dirInicio);
            Desktop.getDesktop().open(dirOrigen);
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    public boolean terminal(String comando){
        String salida = null;
        boolean b=false;
        try{
 
            Process proceso = Runtime.getRuntime().exec(comando);
            InputStreamReader entrada = new InputStreamReader(proceso.getInputStream());
            BufferedReader stdInput = new BufferedReader(entrada);
            
            //Si el comando tiene una salida la mostramos
            if((salida=stdInput.readLine()) != null){
                System.out.println("Comando ejecutado Correctamente");
                while ((salida=stdInput.readLine()) != null){
                    System.out.println(salida);
                }
            }else{
                System.out.println("No se a producido ninguna salida");
            }
            b=true;
        }catch (IOException e) {
                System.out.println("Excepción: ");
                //e.printStackTrace();
                b=false;
        }
        return b;
    }
}
