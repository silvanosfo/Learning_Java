/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import business.Formando;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author efapp0122
 */
public class DBWorker {
    private Connection conn;
    
    
    public DBWorker(String servidor, String user, String password, String baseDados) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://" + servidor + "/" + baseDados + "?" + "user=" + user + "&password=" + password);
    }
    
    public void guardar(Formando f) throws SQLException {
        
        String stringSQL = "INSERT INTO formando(nome, idade, nota) VALUES(?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(stringSQL);
        pst.setString(1, f.GetNome());
        pst.setInt(2, f.getIdade());
        pst.setDouble(3, f.getNota());
        
        pst.executeUpdate();
        
        if (pst != null) {
            pst.close();
        }
    }
    
    public ArrayList<Formando> getAllFormandos() throws SQLException {
        ArrayList<Formando> formandos = new ArrayList<>();
        
        String stringSQL = "SELECT * FROM formando";
        
        PreparedStatement pst = conn.prepareStatement(stringSQL);
        
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()) {
            Formando f = new Formando();
            f.SetNome(rs.getString("nome"));
            f.setIdade(rs.getInt("idade"));
            f.setNota(rs.getDouble("nota"));
            
            formandos.add(f);
        }
        
        if (pst != null) {
            pst.close();
        }
        
        return formandos;
    }
}
