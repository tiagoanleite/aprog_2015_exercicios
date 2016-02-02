/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl6_5;

import java.util.Scanner;

/**
 * Exercício 5 da PL6 (validado)
 * @author Tiago Leite (115780)
 * @since 20/10/2015
 */
public class PL6_5 {
    static Scanner input = new Scanner(System.in);
    
    /**
     * Número de dígitos comuns entre um par de números inteiros positivos
     * @param num1 Primeiro número
     * @param num2 Segundo número
     * @return Número de algarismos ou -1 se inseridos números negativos
     */
    public static int digitosComuns(int num1, int num2) {
        int contador = 0;
        
        if((num1 <= 0) || (num2 <=0)){
            return -1;
        }else{
            do{
                if((num1 % 10) == (num2 % 10)){
                    contador ++;
                }
                num1 /= 10;
                num2 /= 10;
            }while((num1 > 0) && (num2 > 0));
            return contador;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int limite, n1, n2, par1 = 0, par2 = 0, maximo = 0;
        
        do{
            System.out.println("Insira o limite");
            limite = input.nextInt();
        }while(limite < 1);
        
        do{
            do{
                System.out.println("Insira n1");
                n1 = input.nextInt();
            }while(n1 <= 0);

            do{
                System.out.println("Insira n2");
                n2 = input.nextInt();
            }while(n2 <= 0);

            if(digitosComuns(n1, n2) > maximo){
                maximo = digitosComuns(n1, n2);
                par1 = n1;
                par2 = n2;
            }

            limite--;
        }while(limite != 0);
        
        if (maximo == 0){
            System.out.println("Não foram inseridos números com dígitos comuns");
        }else{
            System.out.println("Par {" + par1 + ", " + par2 + "} com " + maximo + " digitos comuns.");
        }
        
    }
    
}
