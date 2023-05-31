/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author efapp0122
 */
public class FormandoJD extends Formando{

    public FormandoJD(int notaTrabalho, int n, String nomeInicial, int idadeInicial, double notaInicial) {
        super(nomeInicial, idadeInicial, notaInicial);
        this.notaTrabalho = notaTrabalho;
    }
    
    private int notaTrabalho;
    
    public boolean verificarNotaTrabalho(){
        return notaTrabalho > 9.99;
    }
    
    @Override
    public boolean verificarAprovacao(){
        return super.verificarAprovacao() && verificarNotaTrabalho();
    }
    
}
