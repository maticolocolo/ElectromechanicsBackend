package com.electromechanics.backend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/servicios")
public class ServiciosController {

    private final List<Map<String, Object>> servicios =
            new ArrayList<>(List.of(
                    Map.of(
                            "id", 1,
                            "titulo", "Mantenimiento preventivo",
                            "descripcion", "Revision de equipo industrial",
                            "estado", "Pendiente",
                            "tecnicoAsignado", "TECNICO-DEMO-001",
                            "sucursal", "Sucursal Norte"
                    ),
                    Map.of(
                            "id", 2,
                            "titulo", "Reparacion de maquinaria",
                            "descripcion", "Revision y reparacion de motor",
                            "estado", "En Proceso",
                            "tecnicoAsignado", "TECNICO-DEMO-001",
                            "sucursal", "Sucursal Sur"
                    )
            ));

    @GetMapping
    public List<Map<String, Object>> obtenerServicios() {
        return servicios;
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<?> actualizarEstado(
            @PathVariable int id,
            @RequestBody Map<String, String> solicitud) {

        String nuevoEstado = solicitud.get("estado");

        if (nuevoEstado == null ||
                !List.of("Pendiente", "En Proceso", "Finalizado")
                        .contains(nuevoEstado)) {

            return ResponseEntity.badRequest().body(
                    Map.of("mensaje", "Estado no valido")
            );
        }

        for (int i = 0; i < servicios.size(); i++) {

            if ((int) servicios.get(i).get("id") == id) {

                Map<String, Object> servicioActual = servicios.get(i);

                Map<String, Object> servicioActualizado = Map.of(
                        "id", id,
                        "titulo", servicioActual.get("titulo"),
                        "descripcion", servicioActual.get("descripcion"),
                        "estado", nuevoEstado,
                        "tecnicoAsignado", servicioActual.get("tecnicoAsignado"),
                        "sucursal", servicioActual.get("sucursal")
                );

                servicios.set(i, servicioActualizado);

                return ResponseEntity.ok(servicioActualizado);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("mensaje", "Servicio no encontrado")
        );
    }
}
