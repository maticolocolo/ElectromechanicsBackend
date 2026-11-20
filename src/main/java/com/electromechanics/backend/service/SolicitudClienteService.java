
package com.electromechanics.backend.service;

import com.electromechanics.backend.Entity.SolicitudClienteEntity;
import com.electromechanics.backend.repository.SolicitudClienteRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudClienteService {

    private final SolicitudClienteRepository repository;

    public SolicitudClienteService(
            SolicitudClienteRepository repository
    ) {
        this.repository = repository;
    }

    public List<SolicitudClienteEntity> obtenerSolicitudes() {
        return repository.findAll();
    }

    public SolicitudClienteEntity crearSolicitud(
            String titulo,
            String descripcion,
            String tipo
    ) {
        SolicitudClienteEntity solicitud =
                new SolicitudClienteEntity(
                        titulo,
                        descripcion,
                        "Pendiente",
                        tipo
                );

        return repository.save(solicitud);
    }
}
