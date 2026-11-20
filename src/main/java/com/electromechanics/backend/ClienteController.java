
package com.electromechanics.backend;

import com.electromechanics.backend.Entity.SolicitudClienteEntity;
import com.electromechanics.backend.service.SolicitudClienteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes/solicitudes")
public class ClienteController {

    private final SolicitudClienteService service;

    public ClienteController(SolicitudClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<SolicitudClienteEntity> obtenerSolicitudes() {
        return service.obtenerSolicitudes();
    }

    @PostMapping
    public ResponseEntity<SolicitudClienteEntity> crearSolicitud(
            @RequestBody SolicitudClienteRequest request
    ) {

        if (
                request.titulo() == null ||
                request.titulo().isBlank() ||
                request.descripcion() == null ||
                request.descripcion().isBlank() ||
                request.tipo() == null ||
                request.tipo().isBlank()
        ) {
            return ResponseEntity.badRequest().build();
        }

        SolicitudClienteEntity nueva = service.crearSolicitud(
                request.titulo(),
                request.descripcion(),
                request.tipo()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nueva);
    }

    public record SolicitudClienteRequest(
            String titulo,
            String descripcion,
            String tipo
    ) {}
}
