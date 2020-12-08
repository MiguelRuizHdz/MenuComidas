package menucomidas;

import java.sql.Connection; //libreria connection.
import java.sql.DriverManager;

public class Conexion {
    //DECLARAMOS LOS ATRIBUTOS DE LA CLASE CONEXION.
    public static final String URL = "jdbc:mysql://localhost:3306/menu?autoReconnet=true&useSSL=false";
    public static final String usuario = "root";
    public static final String contraseña = "";
    
    //CREAMOS EL METODO DE TIPO CONNECTION QUE NOS HARA ACCEDER CUANDO LO LLAMEMOS.
    public static Connection getConnection(){
        //DECLARAMOS UNA VARIABLE TIPO CONNECTION CON VALOR INICIALIZADO CON NULL.
        Connection conexion = null;
        //CREAMOS UN TRY CATCH, QUE NOS SERVIRA PARA CAPTURAR LOS POSIBLES ERROES QUE TENGA LA CONEXION.
        try {
            //DECLARAMOS QUE ESTA CLASE BUSQUE EL DRIVER PARA CONECTAR MYSQL A JAVA.
            Class.forName("com.mysql.jdbc.Driver");
            
            //LE PASAMOS LOS PARAMETROS DE LOS ATRIBUTOS A NUESTRA VARIABLE CONEXION.
            conexion = (Connection) DriverManager.getConnection(URL, usuario, contraseña);
        } catch (Exception error) {
            //EN DADO CASO DE QUE OCURRA UN ERROR EN LA CONEXION, VA PONER EL SIGUIENTE MENSAJE.
            System.err.println("Error en la conexion de base de datos" + error);
        }
        
        //LE ESTAMOS DICIENDO QUE VA RETORNAR LO QUE TENGA LA VARIABLE CONEXION.
        //EN POCAS PALABRAS EL METODO GETCONNECTION TENDRA EL VALOR DE CONEXION.
        return conexion;
    }
}
