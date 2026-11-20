package com.electromechanics.backend.repository;

import com.electromechanics.backend.Entity.SolicitudClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudClienteRepository
        extends JpaRepository<SolicitudClienteEntity, Long> {
}
