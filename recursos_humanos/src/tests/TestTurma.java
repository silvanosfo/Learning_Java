/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import business.Formando;
import business.Turma;

/**
 *
 * @author efapp0122
 */
public class TestTurma {
    public static void main(String[] args) {
        Turma t = new Turma();
        t.setNomeTurma("Programação");
        Formando f1 = new Formando();
        f1.SetNome("Marta");
        t.addForm(f1);
        
        Formando f2 = new Formando();
        f2.SetNome("Jorge");
        t.addForm(f2);
        
        System.out.println(t.toString());
    }
}
