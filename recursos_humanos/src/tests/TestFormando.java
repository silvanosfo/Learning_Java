/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import business.Formando;
import business.FormandoEfa;
import business.FormandoJD;
import business.Turma;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import lib.Console;

/**
 *
 * @author efapp0122
 */
public class TestFormando {

    public static void main(String[] args) {
//        Formando f1  = new Formando();
//        
//        System.out.println("Nome original: " + f1.GetNome());
//        
//        String novoNome = Console.readString("Escreva um nome: ");
//        
//        f1.SetNome(novoNome);
//        
//        System.out.println("Nome modificado: " + f1.GetNome()); 

//        ArrayList<String> frases = new ArrayList<>();
//        String f;
//        f = Console.readString("introduzir uma frase: ");
//        frases.add(f);
//        frases.add("Ola Pimpampum");
//        frases.add("Banana Split");
//        frases.add("Caixamagica");
//        frases.add("TamlaDaCa");
//        frases.add("Ze Manecas");
//        frases.remove(3);
//        frases.set(4, "fim exemplo");
//        
//        for (String frase : frases) {
//            System.out.println(frase);
//        }
        ArrayList<Turma> turma = new ArrayList<>();
        
        Turma t = new Turma();
        t.setNomeTurma(Console.readString("Introduza nome da turma: "));
        turma.add(t);
        
        Formando f1 = new FormandoJD(10,1,"João",29, 9);
        t.addForm(f1);
        
        if (f1.verificarAprovacao()) {
            System.out.println("Este formando foi APROVADO");
        }
        else{
            System.out.println("Este formando REPROVOU");
        }
        
        System.out.println(t.toString());
    }
}

//ergeruntar qunatos formansod tem uma turma
//pedem ao utilizador intrudizir o numero de formandos
//mostra os detelhashes dos formandos da turma
