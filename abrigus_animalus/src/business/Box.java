/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author efapp0122
 * @version 1.10.1.5624
 */
public class Box {
    private static int contador = 0;
    private String setor = "";
    private int numero;
    private String tipo = "";
    private ArrayList<Animal> animais = new ArrayList<>();
    
    /**
     *
     * @param novoSetor
     * @param novoTipo
     */
    public Box(String novoSetor, String novoTipo){
        setor = novoSetor;
        tipo = novoTipo;
        incrementaContador();
        numero = contador;
        
    }
    
    private static void incrementaContador(){
        contador++;
    }
    
    /**
     *
     * Adiciona um novo animal
     * @param animal
     */
    public void addAnimal(Animal animal) {
        
        if (animais.isEmpty()) {
            animais.add(animal);
        }
        
        else if (animais.size() < 3) {
            if (animal.getEspecie() == tipo) {
                animais.add(animal);
            }
            
            else {
                System.out.println("O animal a inserir tem de ser da mesma espécie dos já existentes");
                }
            }
        
        else {
            System.out.println("Máximo 3 animais por box!");
        }
    }
    
    /**
     *
     * @param obj
     */
    public void removeAnimal (Animal obj) {
        animais.remove(obj);
    }
    
    /**
     *
     * @param pos
     */
    public void removeAnimal (int pos) {
        animais.remove(pos);
    }
    
    /**
     *
     * @param box
     * @param animal
     */
    public void moverAnimal (Box box, Animal animal) {
        box.addAnimal(animal);
        this.removeAnimal(animal);
    }

    /**
     *
     * @return
     */
    public String getSetor() {
        return setor;
    }

    /**
     *
     * @return
     */
    public int getNumero() {
        return numero;
    }

    /**
     *
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @return
     */
    public ArrayList<Animal> getAnimais() {
        return animais;
    }

    /**
     *
     * @param setor
     */
    public void setSetor(String setor) {
        this.setor = setor;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "\nSetor: " + setor + 
               "\nNumero: " + numero + 
               "\nTipo: " + tipo + 
               "\nAnimais=" + animais;
    }
    
    
}
