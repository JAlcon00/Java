package Pilas.HanoiTower;

import java.util.Scanner;
import java.util.Stack;

public class HanoiTower{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese la cantidad de discos: ");
        int cantidadDiscos = scanner.nextInt();
        
        moverTorreHanoi(cantidadDiscos);
    }
    
    public static void moverTorreHanoi(int n) {
        Stack<Integer> torreA = new Stack<>();
        Stack<Integer> torreB = new Stack<>();
        Stack<Integer> torreC = new Stack<>();
        
        // Llenar la torre A con discos
        for (int i = n; i > 0; i--) {
            torreA.push(i);
        }
        
        boolean esPar = (n % 2 == 0);
        int movimientos = (int) (Math.pow(2, n) - 1);
        
        for (int i = 1; i <= movimientos; i++) {
            if (i % 3 == 1) {
                moverDiscos(torreA, torreC, esPar);
            } else if (i % 3 == 2) {
                moverDiscos(torreA, torreB, esPar);
            } else if (i % 3 == 0) {
                moverDiscos(torreB, torreC, esPar);
            }
            
            imprimirTorres(torreA, torreB, torreC);
        }
    }
    
    public static void moverDiscos(Stack<Integer> origen, Stack<Integer> destino, boolean esPar) {
        if (esPar) {
            if (origen.isEmpty() || (!destino.isEmpty() && destino.peek() < origen.peek())) {
                destino.push(origen.pop());
            } else {
                origen.push(destino.pop());
            }
        } else {
            if (origen.isEmpty() || (!destino.isEmpty() && destino.peek() < origen.peek())) {
                origen.push(destino.pop());
            } else {
                destino.push(origen.pop());
            }
        }
    }
    
    public static void imprimirTorres(Stack<Integer> torreA, Stack<Integer> torreB, Stack<Integer> torreC) {
        System.out.println("Torre 1: " + torreA);
        System.out.println("Torre 2: " + torreB);
        System.out.println("Torre 3: " + torreC);
        System.out.println();
    }
}
