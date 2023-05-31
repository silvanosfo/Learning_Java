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
public class Turma {
    private String nomeCurso = "";
    private String nomeTurma = "";
    private ArrayList<Formando> formandos = new ArrayList<>();
    
    public Turma(String nomeCursoInicial, String nomeTurmaInicial) {
        nomeCurso = nomeCursoInicial;
        nomeTurma = nomeTurmaInicial;
    }
    
    public Turma() {
        
    }
    
    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }
    
    public ArrayList<Formando> getFormandos() {
        return formandos;
    }
    
    public void addForm(Formando obj){
        formandos.add(obj);
    }
    
    public void remForm(Formando obj){
        formandos.remove(obj);
    }
    
    public void remForm(int pos){
        if (pos > 0 && pos < formandos.size()) {
            formandos.remove(pos);    
        }
    }
    
    @Override
    public String toString(){
        String str = "";
        str += "\n\t\tNome da Turma: " + nomeTurma + "\n";
        str += "\t\tFormandos: " + formandos.toString();

        return str;
    }
}
