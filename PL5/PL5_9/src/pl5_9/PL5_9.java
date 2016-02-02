/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5_9;

import javax.swing.JOptionPane;
import java.lang.Math;

/**
 * Exercício 9 da PL5 (validado)
 * @summary Converte um número de binário para decimal
 * @author Tiago Leite (115780)
 * @since 19/10/2015
 */
public class PL5_9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long numB2 = Long.parseLong(JOptionPane.showInputDialog("Insira o número a converter"));
        int numB10 = 0;
        long temp;
        boolean binario = true;
        int ordem = 0;
        
        if(numB2 < 0){
            binario = false;
        }else{
            temp = numB2;
            while((temp > 0)&&(binario == true)){
                if((temp % 10) > 1){
                    binario = false;
                }
                temp = temp / 10;
            }
        }
        
        // O prof comentou que esta conversão podia estar dentro do else anterior
        if(binario){
            temp = numB2;
            do{
                numB10 = numB10 + ((int)temp % 10) * (int)Math.pow(2, ordem);
                temp = temp / 10;
                ordem++;
            }while(temp > 0);
            JOptionPane.showMessageDialog(null, numB2 + "(2) = " + numB10 + "(10)");
        }else{
            JOptionPane.showMessageDialog(null, "O número inserido não é binário");
        }
    }  
}
