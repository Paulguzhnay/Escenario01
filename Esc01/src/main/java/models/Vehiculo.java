 
package models;

 
public abstract class Vehiculo {
    protected String placa;
    protected int year;
    
    public Vehiculo(String placa, int year) {
        this.placa = placa;
        this.year = year;
    }
    public abstract double calcularCostoMatricula();
    
}
