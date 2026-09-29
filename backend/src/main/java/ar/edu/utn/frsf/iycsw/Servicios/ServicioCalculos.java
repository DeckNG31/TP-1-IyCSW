package ar.edu.utn.frsf.iycsw.Servicios;

import org.springframework.stereotype.Service;

@Service 
public class ServicioCalculos {
    public double sumar(double a, double b){
        return a+b;
    }
    public double restar(double a, double b){
        return a - b;
    }
    public double multiplicar(double a, double b) {
        return a * b;
    }
}


