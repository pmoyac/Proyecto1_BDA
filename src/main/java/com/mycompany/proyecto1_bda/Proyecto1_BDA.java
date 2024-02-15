package com.mycompany.proyecto1_bda;

import datos.ClienteDAO;
import datos.ConexionBD;
import datos.CuentaDAO;
import excepciones.PersistenciaException;
import interfaces.ICliente;
import interfaces.IConexion;
import interfaces.ICuenta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import objetos.Cuenta;

/**
 * @author Pedro Moya, Adriana Gutiérrez
 */
public class Proyecto1_BDA {

    public static void main(String[] args) throws PersistenciaException {
        System.out.println("Hello !");
        System.out.println("este es jovani");
        
        
        String cadenaConexion = "jdbc:mysql://localhost:3306/banco";
        String user = "root";
        String password = "moya";
        
        IConexion baseDatos= new ConexionBD(cadenaConexion, user, password);
        
//        ICuenta cu = new CuentaDAO(baseDatos);
//        Cuenta c1= new Cuenta(3000, new Date(120, 6, 12));
//        cu.agregarCuenta(c1);
    }
}
