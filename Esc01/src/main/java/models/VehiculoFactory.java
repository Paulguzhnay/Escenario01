/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author paul-
 */
public class VehiculoFactory {
    public static Vehiculo crearVehiculo(String tipo, String placa, int year) {
        switch (tipo.toLowerCase()) {
            case "auto":
                return new Auto(placa, year);
            case "camioneta":
                return new Camioneta(placa, year);
            case "camion":
                return new Camion(placa, year);
            default:
                throw new IllegalArgumentException("Tipo de vehículo no reconocido.");
        }
    }
}
