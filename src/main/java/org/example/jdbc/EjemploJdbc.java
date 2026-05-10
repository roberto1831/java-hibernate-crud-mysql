package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EjemploJdbc {

    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/productos?serverTimezone=UTC";
        String usuario="superadmin";
        String clave="19851831";
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultado = null;

        try {
            conexion=DriverManager.getConnection(url,usuario,clave);
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery("select * from productos");
            while(resultado.next()){
                System.out.println(resultado.getString("nombre"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {sentencia.close(); conexion.close(); resultado.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
