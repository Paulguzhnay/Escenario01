/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package grupo05.esc01;

import controlador.controlador;
import vista.view;

/**
 *
 * @author paul-
 */
public class Esc01 {

    public static void main(String[] args) {
        view v = new view();
        v.setVisible(true);
        controlador Vcontrolador = new controlador(v);
    }
}
