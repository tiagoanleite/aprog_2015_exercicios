/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5_5;

import java.util.Scanner;

/**
 * Exercício 5 da PL5 (validado)
 * @summary Cria um novo número com os dígitos ímpares de um número
 * @author Tiago Leite (115780)
 * @since 20/10/2015
 */
public class PL5_5 {
    static Scanner input = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num, d, aux, res;
        res = 0;
        aux = 1;
        System.out.println("num");
        num = input.nextInt();
        while(num != 0){
            d = num % 10;
            if((d % 2) == 1){
                res += d * aux;
                aux *= 10;
            }
            num = num / 10;
        }
        System.out.println("O resultado é: " + res);
    }
    
}
