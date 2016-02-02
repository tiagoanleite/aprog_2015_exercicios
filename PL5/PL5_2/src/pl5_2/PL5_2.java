/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5_2;

import javax.swing.JOptionPane;

/**
 * Exercício 2 da PL5 (validado)
 * @summary Lê as temperaturas máximas registadas em N dias e classifica o dia com a temperatura mais alta
 * @author Tiago Leite (115780)
 * @since 12/10/2015
 */
public class PL5_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int temp, limite, max;
        
        do{
           limite = Integer.parseInt(JOptionPane.showInputDialog("Insira o número de dias a ler")); 
        }while(limite < 0);
        
        if (limite < 1){
            temp = Integer.parseInt(JOptionPane.showInputDialog("Insira a temperatura máxima"));
            limite--;
            max = temp;

            while(limite > 0){
                temp = Integer.parseInt(JOptionPane.showInputDialog("Insira a temperatura máxima"));

                if(temp > max){
                    max = temp;
                }
                limite--;
            }

            if (max < -30){
                JOptionPane.showMessageDialog(null, "Temperatura extrema");
            }else if(max < 9){
                JOptionPane.showMessageDialog(null, "Muito frio");
            }else if (max < 15){
                JOptionPane.showMessageDialog(null, "Frio");
            }else if (max < 20){
                JOptionPane.showMessageDialog(null, "Ameno");
            }else if (max < 30){
                JOptionPane.showMessageDialog(null, "Quente");
            }else if (max < 50){
                JOptionPane.showMessageDialog(null, "Muito quente");
            }else{
                JOptionPane.showMessageDialog(null, "Temperatura extrema");
            }
        }
        
    }
    
}
