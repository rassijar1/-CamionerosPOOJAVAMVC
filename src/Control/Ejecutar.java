/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Vista.InOut;
import Modelo.Procesoentrega;

public class Ejecutar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InOut ob = new InOut();
        Procesoentrega ob1 = new Procesoentrega();
        int op = 0;
        do {
            op = ob.pedirentero("\nIngrese opcion:\n1.Registrar vehiculos. \n2.Mostrar registro zona norte. \n3.Mostrar registros zona sur. \n4.Mostrar registros zona occidente. \n5.Mostrar registros zona oriente. \n6.Buscar vehiculo.\n7.Salir.");
            switch (op) {
                case 1:
                    ob1.llenarentrega();
                    break;
                case 2:
                    ob1.mostrarnorte();
                    break;
                case 3:
                    ob1.mostrarsur();
                    break;
                case 4:
                    ob1.mostraroccidente();
                    break;
                case 5:
                    ob1.mostraroriente();
                    break;
                case 6: {
                    int cc = ob.pedirentero("Ingrese el documento de identidad del propietario del vehiculo a buscar:");
                    ob1.buscarpropietario(cc);
                }

            }
        } while (op != 7);
        ob.mostrar("Gracias por usar este programa, que tenga buen dia.");

    }

}
