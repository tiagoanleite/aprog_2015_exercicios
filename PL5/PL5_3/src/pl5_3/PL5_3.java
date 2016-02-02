/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5_3;

import javax.swing.JOptionPane;

/**
 * Exercício 3 da PL5 (validado)
 * @summary Lê uma sequência de nomes e idades e mostra todos os nomes e a percentagem de pessoas >= 18 anos
 * @author Tiago Leite (115780)
 * @since 12/10/2015
 */
public class PL5_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nome, lista;
        int idade, cont18, contTotal;
        double percent18;
        
        lista = "";
        contTotal = 0;
        cont18 = 0;
        
        nome = JOptionPane.showInputDialog("Insira o nome");
        
       /* O comparador != não funciona com as strings
          O string.compareTo(string) retorna (int)0 se for igual
        */
        while(nome.compareTo("zzz") != 0){
            idade = Integer.parseInt(JOptionPane.showInputDialog("Insira a idade"));
            if(idade >= 18){
                cont18++; 
            }
            lista = lista + nome + ", ";
            contTotal++;
            nome = JOptionPane.showInputDialog("Insira o nome");
        }
        
        if(contTotal > 0){
            JOptionPane.showMessageDialog(null, "Nomes lidos: " + lista);
            if(cont18 > 0){
                percent18 = ((double)cont18 / (double)contTotal) * (double)100;
                JOptionPane.showMessageDialog(null, "Percentagem dos maiores de idade: " + percent18 + "%");
            }else{
                JOptionPane.showMessageDialog(null, "Não existem maiores de idade");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Não foram inseridos dados");
        }
        
        
    }
    
}
