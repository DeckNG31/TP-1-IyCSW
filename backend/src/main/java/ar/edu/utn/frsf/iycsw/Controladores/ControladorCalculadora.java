package ar.edu.utn.frsf.iycsw.Controladores;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


import ar.edu.utn.frsf.iycsw.Servicios.ServicioCalculos;


@RestController
public class ControladorCalculadora {
    private final ServicioCalculos servicioCalculos;

    public ControladorCalculadora(ServicioCalculos servicioCalculos) {
        this.servicioCalculos = servicioCalculos;
    }

    @PostMapping("/restar")
    public double restar(@RequestBody Operacion operacion) {
        return servicioCalculos.restar(operacion.a(), operacion.b());
    }
    
    @PostMapping("/multiplicar")
    public double multiplicar(@RequestBody Operacion operacion) {
        return servicioCalculos.multiplicar(operacion.a(), operacion.b());
    }


    @PostMapping("/sumar")
    public double sumar(@RequestBody Operacion operacion) {
        return servicioCalculos.sumar(operacion.a(), operacion.b());
  }    

   @PostMapping("/dividir")
public double dividir(@RequestBody Operacion operacion) {
    try {
        return servicioCalculos.dividir(operacion.a(), operacion.b());
    } catch (IllegalArgumentException e) {
        // Convierte el dato inválido en una respuesta HTTP 400.
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
    }
}

    public record Operacion(double a, double b) {}
    
}
