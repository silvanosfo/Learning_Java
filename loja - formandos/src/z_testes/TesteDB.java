/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package z_testes;

import b_business.Produto;
import b_business.ProdutoEmbalagemPapel;
import b_business.ProdutoEmbalagemPlastico;
import c_persistence.DBWorker;
import excecoes.TaxaIvaInvalidaException;
import excecoes.ValorInvalidoException;
import java.sql.SQLException;


/**
 *
 * @author efapp0122
 */
public class TesteDB {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, TaxaIvaInvalidaException, ValorInvalidoException {
        DBWorker dbWorker = new DBWorker("192.168.64.5:3306", "silvano_master", "123", "javaLoja");
        
        Produto prod = new ProdutoEmbalagemPlastico("batata", 10, 23, 5);
        
        dbWorker.guardar(prod);
        
        System.out.println(dbWorker.getAllProdutos());
    }
}
