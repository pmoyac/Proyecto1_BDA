package com.mycompany.proyecto1_bda;

import datos.ClienteDAO;
import datos.ConexionBD;
import excepciones.PersistenciaException;
import interfaces.ICliente;
import interfaces.IConexion;
import java.sql.Date;
import objetos.Cliente;
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
import vista.frmPrincipal;

/**
 * @author Pedro Moya, Adriana Gutiérrez
 */
public class Proyecto1_BDA {
    
    public static void main(String[] args) throws PersistenciaException {
// 
//        ICliente cl = new ClienteDAO();
//        ICuenta cu = new CuentaDAO();
////        Cuenta c1 = new Cuenta(3000, new Date(120, 6, 12));
////        cu.agregarCuenta(c1);
////        Cliente cliente = new Cliente("contrasena", "Antonio", "Castro", "Moya", new Date(120, 6, 12), "sgdfg", "asdfas", "sdfasdf");
////            cl.registrarCliente(cliente);
////        cu.transferir(1, 2, 100);
//
//        System.out.println(cu.buscarCuentas(7));
        frmPrincipal p = new frmPrincipal();
        p.setVisible(true);
    }

}
