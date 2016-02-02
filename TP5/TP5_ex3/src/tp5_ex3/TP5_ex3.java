/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5_ex3;

import javax.swing.JOptionPane;

/**
 * Exercício 3 da Ficha TP5
 * @summary Reportar o modelo de um relógio com base no seu modelo
 * @author Tiago Leite (1150780)
 * @since 12/10/2015
 */
public class TP5_ex3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Recebe o input da JOptionPane
         */
        String entrada;
        
        /**
         * Código do relógio
         */
        Integer codigo;
        
        /**
         * Modelo do relógio
         */
        String modelo;
        
        Do{
            entrada = JOptionPane.showInputDialog("Qual é o modelo do relógio?");
            codigo = Integer.parseInt(entrada);
        }while((codigo < 100) && (codigo > 999));
        
        codigo = codigo / 100;
        
        switch(codigo){
            case 1: modelo = "Tag Heuer";
                break;
            case 2: modelo = "Rolex";
                break;
            case 3: modelo = "Omega";
                break;
            case 4: modelo = "Cartier";
                break;
            case 5: modelo = "Bvlgari";
                break;
            case 6: modelo = "Raymond Weil";
                break;
            default: modelo = "Marca inválida";
                break;
        }
        
        JOptionPane.showMessageDialog(null, modelo);
    }
    
}
