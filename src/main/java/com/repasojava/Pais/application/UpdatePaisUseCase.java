package com.repasojava.Pais.application;

import com.repasojava.Pais.domain.entity.Pais;
import com.repasojava.Pais.domain.service.PaisService;

public class UpdatePaisUseCase {
    private final PaisService paisService;

    public UpdatePaisUseCase(PaisService paisService) {
        this.paisService = paisService;
    }

    public void execute(Pais pais) {
        paisService.updatePais(pais);
    } 
}
