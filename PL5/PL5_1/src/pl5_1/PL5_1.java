/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5_1;

import javax.swing.JOptionPane;

/**
 * Exercício 1 da PL5 (validado)
 * @summary Lê N número indicando a média de todos e a percentagem de pares 
 * @author Tiago Leite (1150780)
 * @since 12/10/2015
 */
public class PL5_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int limite, num, soma, pares, i;
        double media;
        
        soma = 0;
        pares = 0;
        
        do{
            limite = Integer.parseInt(JOptionPane.showInputDialog("Insira limite"));
        }while(limite <= 0);
        
       for(i = 1; i <= limite; i++){
           num = Integer.parseInt(JOptionPane.showInputDialog("Insira um número"));
           
           if(num % 2 == 0){
               pares++;
               soma += num;
           }
       }
       
       if(pares != 0){
           media = soma/(double)pares;
           JOptionPane.showMessageDialog(null, "Média = " + media + " Percentagem de pares = " + pares/(double)limite);
       }else{
           JOptionPane.showMessageDialog(null, "Não existem números pares");
       }
    }
    
}
