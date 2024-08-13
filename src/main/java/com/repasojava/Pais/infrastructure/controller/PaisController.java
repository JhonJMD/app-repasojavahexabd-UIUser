package com.repasojava.Pais.infrastructure.controller;

import com.repasojava.Pais.application.CreatePaisUseCase;
import com.repasojava.Pais.application.FindPaisUseCase;
import com.repasojava.Pais.domain.entity.Pais;
import com.repasojava.Pais.domain.service.PaisService;
import com.repasojava.Pais.infrastructure.repository.PaisRepository;

import java.util.*;
import javax.swing.JOptionPane;

public class PaisController {
    private PaisService paisService;
    private CreatePaisUseCase createPaisUseCase;
    private  FindPaisUseCase findPaisUseCase;

    public PaisController() {
        this.paisService = new PaisRepository();
        this.createPaisUseCase = new CreatePaisUseCase(paisService);
        this.findPaisUseCase = new FindPaisUseCase(paisService);
    }

    public void mainMenu(){
        String opciones = "1. Add Country\n2. Search country\n3. Return main menu";
        int op;
        do{
            op =Integer.parseInt(JOptionPane.showInputDialog(null,opciones));
            switch (op) {
                case 1:
                    addCountry();
                    break;
                case 2:
                    findCountry();
                    break;
                case 3:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error en la opcion ingresada","Error",JOptionPane.ERROR_MESSAGE);
                    break;
            }

        }while(op!=3);

    }
    public void addCountry() {
        

            String name = JOptionPane.showInputDialog(null,"Country Name :");

            Pais pais = new Pais();
            pais.setName(name);

            createPaisUseCase.execute(pais);

    }
    public void findCountry() {
        try (Scanner scanner = new Scanner(System.in)) {
            Long id = Long.parseLong(JOptionPane.showInputDialog(null,"Country Id :"));
            findPaisUseCase.execute(id).ifPresentOrElse(
                countryFound -> {
                        JOptionPane.showMessageDialog(null, countryFound.toString(),"Error",JOptionPane.ERROR_MESSAGE);
                    },
                    () -> {
            });
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
