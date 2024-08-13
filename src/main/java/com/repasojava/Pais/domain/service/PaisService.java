package com.repasojava.Pais.domain.service;

import com.repasojava.Pais.domain.entity.Pais;
import java.util.Optional;
public interface PaisService {
    void createPais(Pais pais);
    Optional<Pais> findPaisById(Long id);
    void updatePais(Pais pais);
}
