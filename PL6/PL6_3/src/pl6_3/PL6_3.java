/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl6_3;

import java.util.Scanner;

/**
 * Exercício 3 da PL6 (validado)
 * @summary Dadas 3 medidas verifica se é possível construir um triângulo e quais os seu ângulos internos
 * @author Tiago Leite (115780)
 * @since 19/10/2015
 */
public class PL6_3 {
    static Scanner input = new Scanner(System.in);
    
    /**
     * Calcular um ângulo interno de um triângulo dando as medidas dos lados
     * @param a Lado adjacente ao ângulo
     * @param b Lado adjacente ao ângulo
     * @param c Lado oposto ao ângulo
     * @return Ângulo entre a^b
     */
    public static double calcularAngulo(double a, double b, double c){
        double ang =  Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2))/(2*a*b));
        return Math.toDegrees(ang);
    }
    
    /**
     * Verifica a existência de desigualdade triângular
     * @param a Lado do triângulo
     * @param b Lado do triângulo
     * @param c Lado do triângulo
     * @return Triângulo ou não
     */
    public static boolean verificarTriangulo(double a, double b, double c){
        if(((a + b) > c) && ((a + c) > b) && ((b + c) > a)){
            return true;
        }
        return false;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Insira os 3 lados");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        
        if(verificarTriangulo(a, b, c)){
           System.out.println("a^b = " + calcularAngulo(a, b, c));
           System.out.println("a^c = " + calcularAngulo(a, c, b)); 
           System.out.println("b^c = " + calcularAngulo(b, c, a)); 
        }else{
            System.out.println("Não é triângulo"); 
        }
    }
    
}
