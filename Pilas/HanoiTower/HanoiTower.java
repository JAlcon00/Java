package Pilas.HanoiTower;

import java.util.*;

public class HanoiTower {
    static Stack<Integer>[] towers = new Stack[3];
    static int moves = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        towers[0] = new Stack<>();
        towers[1] = new Stack<>();
        towers[2] = new Stack<>();

        System.out.println("Ingrese el número de discos: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            towers[0].push(i);
        }
        printTowers();

        hanoi(n, 0, 2, 1);

    }

    public static void hanoi(int n, int from, int to, int aux) {
        if (n == 1) {
            towers[to].push(towers[from].pop());
            printTowers();
            return;
        }
        hanoi(n - 1, from, aux, to);
        towers[to].push(towers[from].pop());
        printTowers();
        hanoi(n - 1, aux, to, from);
    }

    static void moveDisk(int from, int to) {
        int disk = towers[from].pop();
        towers[to].push(disk);
        System.out.println("Mover disco " + disk + " de torre " + (from + 1) + " a torre " + (to + 1));

    }

    static void printTowers() {
        System.out.println("Estado actual de las torres");
        for (int i = 0; i < 3; i++) {
            System.out.println("Torre " + (i + 1) + ": " + towers[i]);
            for(int disk : towers[i]){
                System.out.println(disk + " ");


            }
            System.out.println();
        }
        System.out.println("------------------------------------------");
        
    }
}
