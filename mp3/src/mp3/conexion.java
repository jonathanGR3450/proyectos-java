
package mp3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author personal
 */
public class conexion {
    private Connection conexion=null ;
    private ArrayList <String> datos= new ArrayList<String>();
    private ResultSetMetaData rsmetadatos;
    private ResultSet rs=null; 
    private Statement s=null;
    private int n_c=0;
    /**
    * Método utilizado para recuperar el valor del atributo conexion
    * @return conexion contiene el estado de la conexión
    *
    */
    public Connection getConexion()
    {
       return conexion;
    }
    
    /**
    * Método utilizado para establecer la conexión con la base de datos
    * @return estado regresa el estado de la conexión, true si se estableció la conexión,
    * falso en caso contrario
    */
    public boolean crearConexion()
    {
       boolean f=false;
        try {
            System.out.println("1");
            conexion = null;
            String servidorBD = "jdbc:postgresql://localhost:5432/mp3"; 
            //String usuarioDB="postgres";
            String usuarioDB="admi";
            //String passwordDB="96112606243";
            String passwordDB="cueca";
            Class.forName("org.postgresql.Driver");
            //coneccionn es un objeto de la clase Connection de la libreria
            conexion = DriverManager.getConnection(servidorBD, usuarioDB, passwordDB);
            System.out.println("conectado");
            f=true;
            //System.out.println("2 "+f);
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,"Error en la conexion "+e);
        } catch (ClassNotFoundException e) {
             JOptionPane.showMessageDialog(null,"Error en el driver"+e);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error Desconocido (conexionBD)"+e);
        }
        return f;
    }

    /**
    *
    *Método utilizado para realizar las instrucciones: INSERT, DELETE y UPDATE
    *@param sql Cadena que contiene la instrucción SQL a ejecutar
    *@return estado regresa el estado de la ejecución, true(éxito) o false(error)
    *
    */
    public boolean ejecutarSQL(String sql)
    {
        // el administrador ingresa canciones a la base de datos.
         try{
                    s=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
                    s.execute(sql);
                    return true;
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Error****"+e);
                    return false;
                }
    }

    /**
    *
    *Método utilizado para realizar la instrucción SELECT
    *@param sql Cadena que contiene la instrucción SQL a ejecutar
    *@return resultado regresa los registros generados por la consulta
    *
    */
    
    
    /*public ResultSet ejecutarSQLSelect(String sql)
    {
       //sql es el que da los resultados de la consulta 
       ResultSet resultado;
       try {
          PreparedStatement sentencia = conexion.prepareStatement(sql);
          resultado = sentencia.executeQuery();
          return resultado;
       } catch (SQLException ex) {
          System.err.println("Error "+ex);
          return null;
       }
    }*/
    
    
    public void rconsulta(){
        try{
            rsmetadatos =  rs.getMetaData();
            
            //n_c es para saber el numero de columnas que tiene la tabla
            n_c = rsmetadatos.getColumnCount();
                while(rs.next()){
                    for(int i=1;i<rsmetadatos.getColumnCount()+1;i++){
                        //aqui metemos la informacion de las canciones a un arraylist(arreglo dinamico)
                        datos.add(rs.getString(i));
                    }
                    }
        
        }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Error_"+e);
            }
    }
    
    public void accionpsql(String psql){
                try{
                    //sql es el que da los resultados de la consulta 
                    s=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
                    rs=s.executeQuery(psql);
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Error****"+e);
                }
    }
    
    
    public ArrayList<String> GetDatosBD(){
        //obtiene el arraylist de los datos de la tabla
        return this.datos;
    
    }
    public void limpiard (){
        //elimina la informacion del arraylist
        datos.clear();
    }
    public int GetN_columnas(){
        //obtener numero de columnas
        return this.n_c;
    
    }
}
