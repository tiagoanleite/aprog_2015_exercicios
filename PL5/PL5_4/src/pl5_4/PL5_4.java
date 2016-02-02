/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5_4;

import java.util.Scanner;

/**
 * Exercício 4 da PL5 (validado)
 * @summary Mostra os N primeiros números perfeitos
 * @author Tiago Leite (115780)
 * @since 13/10/2015
 * 
 * TODO: corrigir a aplicação da fórmula
 */
public class PL5_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int limite;
        long n;
        boolean primo = true;
        Scanner leitura = new Scanner(System.in);
        
        System.out.println("Insira N");
        limite = leitura.nextInt();
        
        if(limite > 0){
            // Para a fórmula funcionar, i-1 > 0
            for (int i = 2; limite > 0; i++){
                primo = true;
                
                // Para a fórmula funcionar, 2^(i) - 1 tem de ser primo
                n = (int)Math.pow(2, i) - 1;
                for(int x = 2; (x < n) && (primo == true); x++){
                    if(n % x == 0){
                        primo = false;
                    }
                }

                if(primo){
                    // n = 2^(i-1) * (2^(i) - 1) <- Fórmula de Euclides
                    n = (int)Math.pow(2, i-1) * n;
                    System.out.println(n);
                    limite--;
                }
            }
        }else{
            System.out.println("Limite inválido");
        }
        
    }
}
