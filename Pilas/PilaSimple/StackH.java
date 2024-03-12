package Pilas.PilaSimple;

import java.util.*;

public class StackH {
  
    public static void main(String[] args) {
        Stack <Character> pila = new Stack <Character> ();
        Scanner scanner = new Scanner(System.in);
        String palabra;
        palabra = scanner.next();
        
        for(int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == ('(') || palabra.charAt(i) == ('[') || palabra.charAt(i) == ('{')){
                pila.push(palabra.charAt(i));
                
            } else if (palabra.charAt(i) == (')') || palabra.charAt(i) == (')') || palabra.charAt(i) == (')')){
                char aux = pila.peek();
                if (aux == '(' && palabra.charAt(i) == ')' || aux == '[' && palabra.charAt(i) == ']' || aux == '{' && palabra.charAt(i) == '}'){
                    pila.pop();
                    System.out.println("Esta balanceado");

                } else {
                    System.out.println("No esta balanceado");
                    break;
                }
                

            }
        
        }
        if (pila.empty()){
            System.out.println("Esta balanceado");
        } else {
            System.out.println("No esta balanceado");
        }
    }

}
