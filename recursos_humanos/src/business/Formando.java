/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.util.Objects;

/**
 *
 * @author efapp0122
 */
public class Formando {
    // ## VARIÁVEIS DA INSTÂNCIA ## \\
    private int numero = 0;
    private String nome = "";
    private int idade = 0;
    private double nota;

    public Formando() {}
    
    public Formando (String nomeInicial, int idadeInicial, double notaInicial) {
        nome = nomeInicial;
        idade = idadeInicial;
        nota = notaInicial;
    }
    
    public boolean verificarAprovacao() {
        return nota > 9.99;
    }
    
    // ## MÉTODOS DA INSTÂNCIA ## \\
    public void SetNome (String novoNome) {
        this.nome = novoNome;
    }
    
    public String GetNome() {
        return nome;
    }
    
    @Override
    public String toString(){
        String str = "";
        str += "\n\t\t\tNome: " + GetNome();
        str += "\n\t\t\tIdade: " + getIdade();
        str += "\n\t\t\tNota: " + this.nota;
        
        return str;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
