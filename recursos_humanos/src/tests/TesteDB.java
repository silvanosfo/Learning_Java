/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import business.Formando;
import java.sql.SQLException;
import persistence.DBWorker;

/**
 *
 * @author efapp0122
 */
public class TesteDB {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBWorker dbWorker = new DBWorker("192.168.64.5:3306", "silvano_master", "123", "javaForm");
        
        Formando f = new Formando("Rodri", 39, 16.0);
        
        dbWorker.guardar(f);
        
        System.out.println(dbWorker.getAllFormandos());
    }
}
