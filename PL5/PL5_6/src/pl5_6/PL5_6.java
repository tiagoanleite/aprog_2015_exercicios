/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5_6;

import javax.swing.JOptionPane;

/**
 * Exercício 6 da PL5 (validado)
 * @summary Lê duas sequências de números (a primeira termina em 0 e a segunda em -1) e determina qual tem mais números pares
 * @author Tiago Leite (115780)
 * @since 13/10/2015
 */
public class PL5_6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int pares1, pares2, n;
        
        pares1 = 0;
        pares2 = 0;
        
        // 1ª sequência
        n = Integer.parseInt(JOptionPane.showInputDialog("Insira n"));
        // Termina com 0
        while(n != 0){
            if((n % 2) != 0){
                pares1++;
            }
            n = Integer.parseInt(JOptionPane.showInputDialog("Insira n"));
        }
        
        // 2ª sequência
        n = Integer.parseInt(JOptionPane.showInputDialog("Insira n"));
        // Termina com -1
        while(n != -1){
            if((n % 2) != 0){
                pares2++;
            }
            n = Integer.parseInt(JOptionPane.showInputDialog("Insira n"));
        }
        
        if(pares1 > pares2){
            JOptionPane.showMessageDialog(null, "Pares 1");
        }else if(pares2 > pares1){
            JOptionPane.showMessageDialog(null, "Pares 2");
        }else{
            JOptionPane.showMessageDialog(null, "Iguais");
        }
        
        
    }
    
}
