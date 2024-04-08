package Pilas.Calculator;

import java.util.*;

public class calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa una expresión aritmética: ");
        String expresion = scanner.nextLine();

        double resultado = evaluarExpresion(expresion);
        System.out.println("La expresión " + expresion + " = " + resultado);
    }

    public static double evaluarExpresion(String expresion) {
        Stack<Double> pilaNumeros = new Stack<>();
        Stack<Character> pilaOperadores = new Stack<>();
        StringBuilder numeroStr = new StringBuilder();

        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);

            if (Character.isDigit(caracter)) {
                // Si es un dígito, agregamos el dígito al número
                numeroStr.append(caracter);
            } else if (esOperadorAritmetico(caracter)) {
                // Si es un operador, convertimos el número acumulado a double y lo agregamos a la pila de números
                if (numeroStr.length() > 0) {
                    double numero = Double.parseDouble(numeroStr.toString());
                    pilaNumeros.push(numero);
                    numeroStr.setLength(0); // Limpiamos el StringBuilder
                }

                // Continuamos con la lógica del operador como en tu implementación original
                while (!pilaOperadores.isEmpty() && precedencia(pilaOperadores.peek()) >= precedencia(caracter)) {
                    aplicarOperador(pilaNumeros, pilaOperadores.pop());
                }
                pilaOperadores.push(caracter);
            }
        }

        // Al final del bucle, si queda un número en el StringBuilder, lo convertimos y lo agregamos a la pila
        if (numeroStr.length() > 0) {
            double numero = Double.parseDouble(numeroStr.toString());
            pilaNumeros.push(numero);
        }

        // Evaluamos los operadores restantes
        while (!pilaOperadores.isEmpty()) {
            aplicarOperador(pilaNumeros, pilaOperadores.pop());
        }

        // El resultado final estará en la cima de la pila de números
        return pilaNumeros.pop();
    }

    public static boolean esOperadorAritmetico(char caracter) {
        return caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/';
    }

    public static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    public static void aplicarOperador(Stack<Double> pilaNumeros, char operador) {
        double b = pilaNumeros.pop();
        double a = pilaNumeros.pop();

        switch (operador) {
            case '+':
                pilaNumeros.push(a + b);
                break;
            case '-':
                pilaNumeros.push(a - b);
                break;
            case '*':
                pilaNumeros.push(a * b);
                break;
            case '/':
                pilaNumeros.push(a / b);
                break;
        }
    }
}
