/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadorasimple;

/**
 *
 * @author Melody Rincón Abengózar
 * @version 1.0
 * @since 2025-11-19
 */
public class CalculadoraSimple {

    /**
     * Constructor por defecto de la clase CalculadoraSimple.
     */
    public CalculadoraSimple() {
        // No se requiere ninguna inicialización
    }
    /**
     * Realiza la operación de suma entre dos números enteros.
     * Este método acepta números positivos, negativos o cero.
     *
     * @param a El primer número a sumar (sumando).
     * @param b El segundo número a sumar (sumando).
     * @return El resultado entero de la suma de 'a' y 'b'.
     */
    public int sumar(int a, int b) {
        return a + b;
    }
    
    /**
     * Realiza la operación de resta entre dos números enteros.
     *
     * @param a El número del que se va a restar (minuendo).
     * @param b El número a restar (sustraendo).
     * @return El resultado entero de la resta de 'a' menos 'b'.
     */
    public int restar(int a, int b) {
        return a - b;
    }
    
    /**
     * Método principal que se ejecuta al iniciar el programa.
     * Sirve para probar las funcionalidades de la calculadora.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CalculadoraSimple calc = new CalculadoraSimple();
        
        // Prueba de suma
        int resultadoSuma = calc.sumar(25, 17);
        System.out.println("25 + 17 = " + resultadoSuma);
        
        // Prueba de resta
        int resultadoResta = calc.restar(50, 8);
        System.out.println("50 - 8 = " + resultadoResta);
    }
    
}
