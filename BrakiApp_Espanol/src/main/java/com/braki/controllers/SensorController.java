package com.braki.controllers;

import com.braki.utils.FriccionCalculator;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SensorController {

    // Cd fijo en backend: 0.32
    private static final double CD_FIXED = 0.32;

    @PostMapping("/calcular")
    public Map<String,Object> calcular(@RequestBody Map<String,Object> body){
        double v = ((Number) body.getOrDefault("v",25)).doubleValue();
        double m = ((Number) body.getOrDefault("m",1500)).doubleValue();
        double A = ((Number) body.getOrDefault("A",2.2)).doubleValue();
        // Cd fijo: ignore any incoming Cd
        double Cd = CD_FIXED;
        String superficie = (String) body.getOrDefault("superficie","Asfalto");
        String condicion = (String) body.getOrDefault("condicion","Seco");

        double mu = FriccionCalculator.getMu(superficie, condicion);
        double rho = 1.225;
        double g = 9.81;

        double Fa = 0.5 * Cd * A * rho * v * v;
        double Fb = mu * m * g;
        double a_total = (Fb + Fa) / m;
        double t = v / a_total;
        double d = v * v / (2 * a_total);

        Map<String,Object> out = new HashMap<>();
        out.put("superficie", superficie);
        out.put("condicion", condicion);
        out.put("mu", mu);
        out.put("Cd", Cd);
        out.put("Fa", Fa);
        out.put("Fb", Fb);
        out.put("a_total", a_total);
        out.put("t", t);
        out.put("d", d);
        return out;
    }
}
