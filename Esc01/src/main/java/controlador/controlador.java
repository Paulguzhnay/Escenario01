package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import models.*;
import vista.*;

public class controlador {
    private view viewV;
    private ArrayList<String> historialMatriculas; // Almacena los cálculos de matrícula

    // Constructor que recibe la vista y inicializa el ArrayList
    public controlador(view viewV) {
        this.viewV = viewV;
        this.historialMatriculas = new ArrayList<>();
        this.viewV.addCalcularListener(new CalcularListener()); // Añadir listener para el botón de cálculo
        this.viewV.addHistorialListener(new HistorialListener()); // Añadir listener para el botón de historial
    }

    // Clase interna que implementa la funcionalidad al hacer clic en el botón de calcular
    class CalcularListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (viewV != null) {
                    String tipo = viewV.getTipo(); // Obtener el tipo de vehículo desde la vista
                    String placa = viewV.getPlaca(); // Obtener la placa desde la vista
                    int year = viewV.getYear(); // Obtener el año desde la vista

                    // Crear el vehículo usando el Factory Method
                    Vehiculo vehiculo = VehiculoFactory.crearVehiculo(tipo, placa, year);

                    // Calcular el costo de la matrícula
                    double costoMatricula = vehiculo.calcularCostoMatricula();

                    // Almacenar el resultado en el historial
                    String resultado = "Vehículo: " + tipo + " | Placa: " + placa + " | Año: " + year + " | Costo: $" + costoMatricula;
                    historialMatriculas.add(resultado); // Agregar el resultado al ArrayList

                    // Mostrar el resultado en la vista
                    viewV.setResultado("Costo de Matrícula: $" + costoMatricula);
                }
            } catch (NumberFormatException ex) {
                viewV.setResultado("Error: El año debe ser un número.");
            } catch (IllegalArgumentException ex) {
                viewV.setResultado(ex.getMessage());
            }
        }
    }

    // Clase interna para manejar el botón de historial
    class HistorialListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mostrarHistorial(); // Mostrar el historial cuando se presiona el botón
        }
    }

    // Método para obtener el historial de cálculos de matrícula
    public ArrayList<String> getHistorialMatriculas() {
        return historialMatriculas;
    }

    // Método para mostrar el historial en la vista
    public void mostrarHistorial() {
        StringBuilder historialTexto = new StringBuilder();
        for (String registro : historialMatriculas) {
            historialTexto.append(registro).append("\n");
        }
        viewV.setHistorial(historialTexto.toString()); // Mostrar historial en la vista
    }
}
