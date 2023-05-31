/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import business.Animal;
import business.Box;
import java.util.ArrayList;

/**
 *
 * @author efapp0122
 */
public class TestBox {
    public static void main(String[] args) {
        ArrayList<Box> boxes = new ArrayList<>();
        
        Box b1 = new Box("Domésticos", "Cão");
    
        Animal a1 = new Animal("Tobias", "Pincha", "Cão", "7 anos");
        b1.addAnimal(a1);
        Animal a2 = new Animal("Bobi", "Rafeiro", "Cão", "11 anos");
        b1.addAnimal(a2);
        boxes.add(b1);
        
        Box b2 = new Box("Mamíferos", "Tigre");
        
        Animal a21 = new Animal("Grisado", "Tigre das Neves", "Tigre", "7 anos");
        b2.addAnimal(a21);
        Animal a22 = new Animal("Abrasado", "Tigre Africano", "Tigre", "11 anos");
        b2.addAnimal(a22);
        boxes.add(b2);
        
        System.out.println(boxes.toString());
    }
}
