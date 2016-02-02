/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5_10;

import javax.swing.JOptionPane;
import java.lang.Math;

/**
 * Exercício 10 da PL5 (validado)
 * @summary Converte um número de octal para decimal
 * @author Tiago Leite (115780)
 * @since 19/10/2015
 */
public class PL5_10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numB8 = Integer.parseInt(JOptionPane.showInputDialog("Insira o número a converter"));
        int numB10 = 0;
        long temp;
        boolean octal = true;
        int ordem = 0;
        
        if(numB8 < 0){
            octal = false;
        }else{
            temp = numB8;
            while((temp > 0)&&(octal == true)){
                if((temp % 10) > 7){
                    octal = false;
                }
                temp = temp / 10;
            }
        }
        
        // O prof comentou que esta conversão podia estar dentro do else anterior
        if(octal){
            temp = numB8;
            do{
                numB10 = numB10 + (int)(temp % 10) * (int)Math.pow(8, ordem);
                temp = temp / 10;
                ordem++;
            }while(temp > 0);
            JOptionPane.showMessageDialog(null, numB8 + "(8) = " + numB10 + "(10)");
        }else{
            JOptionPane.showMessageDialog(null, "O número inserido não é octal");
        }
    }  
}
