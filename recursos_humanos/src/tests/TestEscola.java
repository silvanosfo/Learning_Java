/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import business.Escola;
import business.Formando;
import business.Turma;

/**
 *
 * @author efapp0122
 */
public class TestEscola {
    public static void main(String[] args) {
        Escola e = new Escola();
        e.setNome("Escola Dom Zé de Trouçes");
        
        Turma t1 = new Turma();
        t1.setNomeTurma("EFA0122");
        
        Formando f1 = new Formando();
        f1.SetNome("Marta");
        t1.addForm(f1);
        Formando f2 = new Formando();
        f2.SetNome("Jorge");
        t1.addForm(f2);
        Formando f3 = new Formando();
        f3.SetNome("Manuel");
        t1.addForm(f3);
        
        e.criarTurma(t1);
        
        Turma t2 = new Turma();
        t2.setNomeTurma("Jovem +Digital");
        
        Formando f21 = new Formando();
        f21.SetNome("Maria");
        t2.addForm(f21);
        Formando f22 = new Formando();
        f22.SetNome("Joao");
        t2.addForm(f22);
        Formando f23 = new Formando();
        f23.SetNome("Matias");
        t2.addForm(f23);
        
        e.criarTurma(t2);
        
        System.out.println(e.toString());
    }
}
