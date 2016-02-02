/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl6_8;

import java.util.Scanner;

/**
 * Exercício 8 da PL6 (validado)
 * @author Tiago Leite (115780)
 * @since 20/10/2015
 */
public class PL6_8 {
    static Scanner input = new Scanner(System.in);
    
    /**
     * Converte de base decimal para base hexadecimal
     * @param num10 Número em base decimal
     * @return Número em base hexadecimal ou "erro"
     */
    public static String converterDecimal(int num10){
        String num16 = "";
        int alg10;
        String alg16;
        
        if(num10 < 0){
            return "erro";
        }else{
            do{
                alg10 = num10 % 16;
                if(alg10 <= 15){
                    switch (alg10) {
                        case 10:
                            alg16 = "A"; break;
                        case 11:
                            alg16 = "B"; break;
                        case 12:
                            alg16 = "C"; break;
                        case 13:
                            alg16 = "D"; break;
                        case 14:
                            alg16 = "E"; break;
                        case 15:
                            alg16 = "F"; break;
                        default:
                            alg16 = Integer.toString(alg10);
                    }
                    num16 = alg16 + num16;
                }else{
                    return "erro";
                }
                num10 /= 16;
            }while(num10 > 0);
            
            return num16;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num;
        System.out.println("Insira o número decimal");
        num = input.nextInt();
        
        while(num > 0){
            if(num < 0){
                System.out.println("Impossível converter números negativos");
            }else{
                System.out.println(num + "(10) = " + converterDecimal(num) + "(16)");
            }
            
            System.out.println("Insira o número decimal");
            num = input.nextInt();
        }
        
        System.out.println("Inseriu 0");
    }
    
}
