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

    public double raizCuadrada(double a) {
    if (a < 0.0) {
        throw new IllegalArgumentException("No se puede calcular la raíz cuadrada de un número negativo");
    }
    return Math.sqrt(a);
    }

  public double dividir(double a, double b) {
    if (b == 0.0) { // También detecta -0.0
        throw new IllegalArgumentException("No se puede dividir por cero");
    }
    return a / b;
    }
}


