package com.repasojava;


import com.repasojava.Pais.infrastructure.controller.PaisController;
import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {

       
        String opciones = "1. Country\n2. Exit...oooo";
        int op;
        do{
            op =Integer.parseInt(JOptionPane.showInputDialog(null,opciones));
            switch (op) {
                case 1:
                        PaisController consoleAdapter = new PaisController();
                        consoleAdapter.mainMenu();
                    break;
                case 2:
                        JOptionPane.showMessageDialog(null, "Suerte nos vemos....");
                    break;
                default:
                        JOptionPane.showMessageDialog(null, "Error opcion invalida");
                    break;
            }

        }while(op!=2);

        


        //consoleAdapter.addCountry();

    }
}