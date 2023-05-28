/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package c_persistence;

import b_business.Produto;
import b_business.ProdutoEmbalagemPapel;
import b_business.ProdutoEmbalagemPlastico;
import excecoes.TaxaIvaInvalidaException;
import excecoes.ValorInvalidoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
    
    public void guardar(Produto prod) throws SQLException {
        String stringSQL = "INSERT INTO produto(referencia, designacao, preco, taxa_iva) VALUES(?, ?, ?, ?);";
        PreparedStatement pst = conn.prepareStatement(stringSQL);
        pst.setInt(1, prod.getReferencia());
        pst.setString(2, prod.getDesignacao());
        pst.setFloat(3, prod.getPrecoSemIva());
        pst.setInt(4, prod.getTaxaIva());
        
        pst.executeUpdate();
        
        if (pst != null) {
            pst.close();
        }
    }
    
    public void removeProdDB(int referencia) throws SQLException {
        String stringSQL = "DELETE FROM produto WHERE referencia = "+referencia+";";
        PreparedStatement pst = conn.prepareStatement(stringSQL);
        pst.executeUpdate();
    }
    
    public void limpaDB() throws SQLException{
        String stringSQL = "DELETE FROM produto WHERE referencia > 0;";
        PreparedStatement pst = conn.prepareStatement(stringSQL);
        pst.executeUpdate();
    }
    
    public ArrayList<Produto> getAllProdutos() throws SQLException, ValorInvalidoException, TaxaIvaInvalidaException {
        ArrayList<Produto> produtos = new ArrayList<>();
        
        String stringSQL = "SELECT * FROM produto";
        
        PreparedStatement pst = conn.prepareStatement(stringSQL);
        
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()) {
            if (rs.getInt("taxa_suplementar") > 0) {
                ProdutoEmbalagemPlastico prod = new ProdutoEmbalagemPlastico(rs.getString("designacao"));
                prod.setReferencia(rs.getInt("referencia"));
                prod.setPrecoSemIva(rs.getFloat("preco"));
                prod.setTaxaIva(rs.getInt("taxa_iva"));
                prod.setTaxaSuplementarSemIva(rs.getFloat("taxa_suplementar"));
                produtos.add(prod);
            } else {
                ProdutoEmbalagemPapel prod = new ProdutoEmbalagemPapel(rs.getString("designacao"));
                prod.setReferencia(rs.getInt("referencia"));
                prod.setPrecoSemIva(rs.getFloat("preco"));
                prod.setTaxaIva(rs.getInt("taxa_iva"));
                produtos.add(prod);
            }
        }
        
        if (pst != null) {
            pst.close();
        }
        return produtos;
    }
}
