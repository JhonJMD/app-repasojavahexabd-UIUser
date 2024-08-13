package com.repasojava.Pais.application;

import com.repasojava.Pais.domain.entity.Pais;
import com.repasojava.Pais.domain.service.PaisService;

public class CreatePaisUseCase {
    private final PaisService paisService;

    public CreatePaisUseCase(PaisService paisService) {
        this.paisService = paisService;
    }

    public void execute(Pais pais) {
        paisService.createPais(pais);
    }
}
