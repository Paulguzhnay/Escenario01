/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author paul-
 */
public class Auto extends Vehiculo{

    public Auto(String placa, int year) {
        super(placa, year);
    }

    @Override
    public double calcularCostoMatricula() {
        double precio = 200;
        if(2024-year>10){
            return precio*0.5;
        }else if (2024-year<5){
            return precio*1.30;
        }
        return precio;
    }
    
}
