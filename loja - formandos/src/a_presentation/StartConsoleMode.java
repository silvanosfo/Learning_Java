
package a_presentation;

import b_business.Encomenda;
import b_business.Loja;
import b_business.Produto;
import b_business.ProdutoEmbalagemPapel;
import b_business.ProdutoEmbalagemPlastico;
import c_persistence.DBWorker;
import excecoes.TaxaIvaInvalidaException;
import excecoes.ValorInvalidoException;
import java.sql.SQLException;
import lib.Console;



/**
 *
 * @author silvano
 */
public class StartConsoleMode {
    
    public static void pause(){
        Console.readString("\n\n !! PRIMA ENTER PARA CONTINUAR !! \n\n");
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBWorker dbWorker = new DBWorker("192.168.64.5:3306", "silvano_master", "123", "javaLoja");
        
        // --- Criacao da loja -------------------------------------------------
        String designacaLoja = Console.readString("Indique a designacao da Loja: ");
        Loja lj = new Loja(designacaLoja);
        
        int opcao = 0;

        // --- INTERATIVO ------------------------------------------------------
        do{
            // --- MENU --------------------------------------------------------
            //System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("=== LOJA DO BOM SUCESSO ======================");
            System.out.println("1. Ver dados da loja");
            System.out.println("2. Total de Iva da Loja");
            System.out.println("------ ENCOMENDAS --------------------------- ");
            System.out.println("3. Nova Encomenda");
            System.out.println("4. Remover Encomenda");
            System.out.println("5. Ver Total da Encomenda com Iva");
            System.out.println("6. Ver Total da Encomenda sem Iva");
            System.out.println("------ PRODUTOS ------------------------ ");
            System.out.println("7. Adicionar Produtos a Encomenda Existente");
            System.out.println("8. Remover Produto de Encomenda Existente");
            System.out.println("0. Sair");
            System.out.println("----------------------------------------- ");
            
            
            opcao = Console.readInt("[ESCOLHA OPCAO]# ");
            System.out.println("\n\n\n");
            switch(opcao){
                case 1:
                        // DADOS DA LOJA
                        System.out.println("=== Loja: " + lj.getDesignacao());
                        System.out.println("=== Total Encomendas: " + lj.getEncomendas().size());
                        System.out.println("--- ENCOMENDAS -------------------------");
                        System.out.println(lj.getEncomendas().toString());
                        pause();
                        break;
                
                case 2:
                        // TOTAL DE IVA LOJA
                        float totalIva = 0.0f;
                        for (Encomenda encomenda : lj.getEncomendas()) {
                            totalIva += (encomenda.calculaTotalComIva() - encomenda.calculaTotalSemIva());
                        }
                        System.out.println("\nTotal de IVA a Loja: " + totalIva);
                        pause();
                        break;
                
                case 3:
                        // NOVA ENCOMENDA
                        System.out.println("\n Criacao de um nova encomenda\n");
                        Encomenda enc = new Encomenda(Console.readString("Indique o nome do Cliente: "));
                        
                        int quantidade = Console.readInt("Quantos produtos irá adicionar à encomenda? ");
                        
                        for (int i = 0; i < quantidade; i++) {
                            
                            String designProd = Console.readString("Escreva a designacao do " + (i+1) + "º produto: ");
                            float precoProd = (float)Console.readDouble("Introduza o preco do " + (i+1) + "º produto: ");
                            int ivaProd = Console.readInt("Introduza o Iva do " + (i+1) + "º produto: ");
                            int tipoEmbalagem = Console.readInt("Escolha 1 para Embalagem Papel, 2 para Embalagem Plastico: ");
                            
                            if (tipoEmbalagem == 1) {
                                try {
                                    Produto produto = new ProdutoEmbalagemPapel(designProd, precoProd, ivaProd);
                                    enc.adicionarProduto(produto);
                                    dbWorker.guardar(produto);
                                } catch (TaxaIvaInvalidaException | ValorInvalidoException ex) {
                                    System.out.println(ex.getMessage());
                                }
                            }else{
                                float taxaSupl = (float)Console.readDouble("Introduza a taxa suplementar a pagar do " + (i+1) + "º produto: ");
                                try {
                                    Produto produto = new ProdutoEmbalagemPlastico(designProd, precoProd, ivaProd, taxaSupl);
                                    enc.adicionarProduto(produto);
                                    dbWorker.guardar(produto);
                                } catch (TaxaIvaInvalidaException | ValorInvalidoException ex) {
                                    System.out.println(ex.getMessage());
                                }
                            }
                        }
                        lj.adicionaEncomenda(enc);
                        break;
                
                case 4:
                        // REMOVER ENCOMENDA
                        System.out.println("Lista de Encomendas");
                        for (int i = 0; i < lj.getEncomendas().size(); i++) {
                            Encomenda encomenda = lj.getEncomendas().get(i);
                            System.out.println(i + " - " + encomenda.getNomeCliente());
                        }
                        int escolhaRemocao = Console.readInt("Qual a encomenda a eliminar? ");
                        try{
                            lj.getEncomendas().remove(escolhaRemocao);
                        }catch(IndexOutOfBoundsException ex){
                            System.out.println("\n !! ERRO: " + ex.getMessage());
                        }
                        pause();
                        break;
                
                case 5:
                        // VER TOTAL DA ENCOMENDA COM IVA
                        System.out.println("Lista de Encomendas");
                        for (int i = 0; i < lj.getEncomendas().size(); i++) {
                            Encomenda encomenda = lj.getEncomendas().get(i);
                            System.out.println(i + " - " + encomenda.getNomeCliente());
                        }
                        int escolhaEncomendaComIva = Console.readInt("Indique qual a encomenda: ");
                        try{
                            System.out.println("Total sem Iva: " + lj.getEncomendas().get(escolhaEncomendaComIva).calculaTotalComIva());
                        }catch(IndexOutOfBoundsException ex){
                            System.out.println("\n !! ERRO: " + ex.getMessage());
                            pause();
                        }

                        pause();
                        break;
                
                case 6:
                        // VER TOTAL DA ENCOMENDA SEM IVA
                        System.out.println("Lista de Encomendas");
                        for (int i = 0; i < lj.getEncomendas().size(); i++) {
                            Encomenda encomenda = lj.getEncomendas().get(i);
                            System.out.println(i + " - " + encomenda.getNomeCliente());
                        }
                        int escolhaEncomendaSemIva = Console.readInt("Indique qual a encomenda: ");
                        try{
                            System.out.println("Total sem Iva: " + lj.getEncomendas().get(escolhaEncomendaSemIva).calculaTotalSemIva());
                        }catch(IndexOutOfBoundsException ex){
                            System.out.println("\n !! ERRO: " + ex.getMessage());
                            pause();
                        }
                        pause();
                        break;
                
                case 7:
                        // Adicionar produtos a encomenda existente
                        System.out.println("Lista de Encomendas");
                        for (int i = 0; i < lj.getEncomendas().size(); i++) {
                            Encomenda encomenda = lj.getEncomendas().get(i);
                            System.out.println(i + " - " + encomenda.getNomeCliente());
                        }
                        int escolhaEncomenda = Console.readInt("Indique qual a encomenda: ");
                        
                        int quant = Console.readInt("Quantos produtos estarao na encomenda? ");
                        
                        for (int i = 0; i < quant; i++) {
                            
                            String designProd = Console.readString("Escreva a designacao do " + (i+1) + "º produto: ");
                            float precoProd = (float)Console.readDouble("Introduza o preco do " + (i+1) + "º produto: ");
                            int ivaProd = Console.readInt("Introduza o Iva do " + (i+1) + "º produto: ");
                            int tipoEmbalagem = Console.readInt("Escolha 1 para Embalagem Papel, 2 para Embalagem Plastico: ");
                            
                            if (tipoEmbalagem == 1) {
                                try {
                                    Produto produto = new ProdutoEmbalagemPapel(designProd, precoProd, ivaProd);
                                    try{
                                        lj.getEncomendas().get(escolhaEncomenda).adicionarProduto(produto);
                                        dbWorker.guardar(produto);
                                    }catch(IndexOutOfBoundsException ex){
                                        System.out.println("\n !! ERRO: " + ex.getMessage());
                                        pause();
                                    }
                                } catch (TaxaIvaInvalidaException | ValorInvalidoException ex) {
                                    System.out.println(ex.getMessage());
                                }
                            }else{
                                float taxaSupl = (float)Console.readDouble("Introduza a taxa suplementar a pagar do " + (i+1) + "º produto: ");
                                try {
                                    Produto produto = new ProdutoEmbalagemPlastico(designProd, precoProd, ivaProd, taxaSupl);
                                    try{
                                        lj.getEncomendas().get(escolhaEncomenda).adicionarProduto(produto);
                                        dbWorker.guardar(produto);
                                    }catch(IndexOutOfBoundsException ex){
                                        System.out.println("\n !! ERRO: " + ex.getMessage());
                                        pause();
                                    }
                                } catch (TaxaIvaInvalidaException | ValorInvalidoException ex) {
                                    System.out.println(ex.getMessage());
                                }
                            }
                        }
                        pause();
                        break;
                
                case 8:
                        // Remover produtos de encomenda existe
                        System.out.println("Lista de Encomendas");
                        for (int i = 0; i < lj.getEncomendas().size(); i++) {
                            Encomenda encomenda = lj.getEncomendas().get(i);
                            System.out.println(i + " - " + encomenda.getNomeCliente());
                        }
                        int escolhaEncomendaRemoverProduto = Console.readInt("Indique qual a encomenda: ");
                        Encomenda encomRemoverProduto = lj.getEncomendas().get(escolhaEncomendaRemoverProduto);
                        for (int i = 0; i < encomRemoverProduto.getProdutosEncomendados().size(); i++) {
                            System.out.println(i + " - " + encomRemoverProduto.getProdutosEncomendados().get(i).getDesignacao());                       
                        }
                        int produtoARemover = Console.readInt("Qual a produto a remover? ");
                        try{
                            encomRemoverProduto.removeProduto(produtoARemover);
                            dbWorker.removeProdDB(produtoARemover+1);
                        }catch(IndexOutOfBoundsException ex){
                            System.out.println("\n !! ERRO: " + ex.getMessage());
                            pause();
                        }
                        break;
                                
                case 0:
                        System.out.println("Volte sempre");
                        dbWorker.limpaDB();
                        pause();
                        break;
                default:
                        System.out.println("Opcao Invalida!!!!!");
                        pause();
            }
        }while(opcao != 0);
    }
}
