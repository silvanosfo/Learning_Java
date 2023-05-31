/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author efapp0122
 */
public class Escola {
    String nome = "";
    String localizacao = "";
    String telefone = "";
    public final int MAX_TURMAS;
    private ArrayList<Turma> turmas =  new ArrayList<>(4);

    public Escola(String nomeInicial, String localizacaoInicial, String telefoneInicial, int MAX) {
        nome = nomeInicial;
        localizacao = localizacaoInicial;
        telefone = telefoneInicial;
        MAX_TURMAS = MAX;
    }
    
    public Escola() {
        MAX_TURMAS = 4;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void criarTurma(Turma obj) {
        if (turmas.size() < MAX_TURMAS) {
            turmas.add(obj);
        }
        else {
            System.out.println("LIMITE ATINGIDO!");
        }
    }
    
    public void removeTurma(Turma obj){
       turmas.remove(obj);
    }
    
    public void removeTurma(int pos){
        if (pos > 0 && pos < turmas.size()) {
            turmas.remove(pos);    
        }
    }
    
    @Override
    public String toString() {
        String str = "";
        str += "Escola\n";
        str += "\tNome: " + this.nome + "\n";
        str += "\tTurmas: " + turmas;
        return str;
    }
    
    public String listaDadosTurma(Turma obj){
        return obj.toString();
    }
            

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }
}
