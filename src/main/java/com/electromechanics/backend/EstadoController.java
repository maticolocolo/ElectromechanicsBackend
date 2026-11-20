package com.electromechanics.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class EstadoController {

    @GetMapping("/")
    public Map<String, String> comprobarEstado() {
        return Map.of(
            "proyecto", "Electromechanics",
            "mensaje", "Backend funcionando correctamente",
            "estado", "OK"
        );
    }
}
