package com.mycompany.proyecto1_bda;

import datos.ClienteDAO;
import datos.ConexionBD;
import excepciones.PersistenciaException;
import interfaces.ICliente;
import interfaces.IConexion;
import java.sql.Date;
import objetos.Cliente;

/**
 * @author Pedro Moya, Adriana Gutiérrez
 */
public class Proyecto1_BDA {

    public static void main(String[] args) {

        String cadenaConexion = "jdbc:mysql://localhost:3306/banco";
        String user = "root";
        String password = "1234";
        
        try {
            IConexion baseDatos = new ConexionBD(cadenaConexion, user, password);
            Cliente cliente = new Cliente("adriana","gutierrez","robles", new Date(2003,04,04), "1234","calle","178","f");
            ICliente daoCliente = new ClienteDAO(baseDatos);
            Cliente agregado = daoCliente.registrarCliente(cliente);
            
            System.out.println("Cliente registrado");
            System.out.println(agregado.toString());
            
        } catch (PersistenciaException e) {
            System.out.println("Hubo un error");
            System.out.println(e.getStackTrace());
        }
        
        
        
        
    }
    
    
}
