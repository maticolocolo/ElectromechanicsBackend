
package com.electromechanics.backend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/informes")
public class InformesController {

    private final List<Map<String, Object>> informes = new ArrayList<>();

    @PostMapping
    public ResponseEntity<?> registrarInforme(
            @RequestBody Map<String, Object> solicitud) {

        Object servicioId = solicitud.get("servicioId");
        Object trabajoRealizado = solicitud.get("trabajoRealizado");
        Object repuestos = solicitud.get("repuestosUtilizados");
        Object comentarios = solicitud.get("comentariosTecnicos");

        if (servicioId == null ||
                trabajoRealizado == null ||
                trabajoRealizado.toString().isBlank()) {

            return ResponseEntity.badRequest().body(
                    Map.of("mensaje", "Faltan datos obligatorios")
            );
        }

        Map<String, Object> informe = Map.of(
                "id", informes.size() + 1,
                "servicioId", servicioId,
                "trabajoRealizado", trabajoRealizado,
                "repuestosUtilizados", repuestos == null ? "" : repuestos,
                "comentariosTecnicos", comentarios == null ? "" : comentarios
        );

        informes.add(informe);

        return ResponseEntity.status(HttpStatus.CREATED).body(informe);
    }

    @GetMapping
    public List<Map<String, Object>> obtenerInformes() {
        return informes;
    }
}
