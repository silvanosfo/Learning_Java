/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author efapp0122
 */
public class FormandoEfa extends Formando{

    public FormandoEfa(boolean presentePRA, int n, String nomeInicial, int idadeInicial, double notaInicial) {
        super(nomeInicial, idadeInicial, notaInicial);
        this.presentePRA = presentePRA;
    }
    
    private boolean presentePRA;
    
    public boolean verificarPresenca(){
        return presentePRA == true;
    }
    
    @Override
    public boolean verificarAprovacao(){
        return super.verificarAprovacao() && verificarPresenca();
    }
}
