/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5_8;

import javax.swing.JOptionPane;

/**
 * Exercício 8 da PL5 (validado)
 * @summary Lê um número e verifica se é binário
 * @author Tiago Leite (115780)
 * @since 19/10/2015
 */
public class PL5_8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long numero = Long.parseLong(JOptionPane.showInputDialog("Insira o número a verificar"));
        boolean binario = true;
        
        if(numero < 0){
            binario = false;
        }else{
            while((numero > 0)&&(binario == true)){
                if((numero % 10) > 1){
                    binario = false;
                }
                numero = numero / 10;
            }
        }
        
        if(binario){
            JOptionPane.showMessageDialog(null, "O número inserido é binário"); 
        }else{
            JOptionPane.showMessageDialog(null, "O número inserido não é binário");
        }
    }
    
}
