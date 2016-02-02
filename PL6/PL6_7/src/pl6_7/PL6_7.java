/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl6_7;

import java.util.Scanner;
/**
 * Exercício 7 da PL6 (validado)
 * @author Tiago Leite (115780)
 * @since 20/10/2015
 */
public class PL6_7 {
    static Scanner input = new Scanner(System.in);
    
    /**
     * Verifica se um número está em base octal
     * @param num Numero a verificar
     * @return Se está em octal ou não
     */
    public static boolean verificarOctal(long num){
        boolean octal = true;
        
        if(num < 0){
            octal = false;
        }else{
            while((num > 0)&&(octal == true)){
                if((num % 10) > 7){
                    octal = false;
                }
                num /= 10;
            }
        }
        
        return octal;
    }
    
    /**
     * Converte da base octal para a base decimal
     * @param num Número em octal
     * @return Número em decimal ou -1 se o número inserido não for octal
     */
    public static long converterOctal(long num){
        long resultado = 0;
        int ordem = 0;
        if(verificarOctal(num)){
            do{
                resultado += (num % 10) * (long)Math.pow(8, ordem);
                num /= 10;
                ordem++;
            }while(num > 0);
            return resultado;
        }else{
            return -1;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long num;
        System.out.println("Insira o número octal");
        num = input.nextLong();
        
        while(verificarOctal(num)){
            System.out.println(num + "(8) = " + converterOctal(num) + "(10)");
            System.out.println("Insira o número octal");
            num = input.nextLong();
        }
        
        System.out.println("Inseriu um número que não é octal");
    }
    
}
