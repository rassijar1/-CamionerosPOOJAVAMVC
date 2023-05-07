/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.InOut;
import java.util.ArrayList;
import Modelo.Entrega;

public class Procesoentrega {

    InOut ob = new InOut();
    ArrayList<Entrega> norte1 = new ArrayList<Entrega>();
    ArrayList<Entrega> sur1 = new ArrayList<Entrega>();
    ArrayList<Entrega> este1 = new ArrayList<Entrega>();
    ArrayList<Entrega> oeste1 = new ArrayList<Entrega>();
    ArrayList<Entrega> entregatotal = new ArrayList<Entrega>();
    int tam = 0;

    Entrega em = new Entrega();

    public void llenarentrega() {

        String placa = "";
        String nombrepropi = "";
        int ccpropi = 0, cccliente = 0, capcarg = 0, numplac = 0;
        String zona = "";
        String cliente = "";
        String servicio = "";
        double costo = 0;
        String pico = "";
        String dia1 = "lunes,jueves";
        String dia2 = "martes,viernes";
        String dia3 = "Miercoles,sabados";
        String norte = "norte";
        String sur = "sur";
        String occidente = "occidente";
        String oriente = "oriente";

        tam = ob.pedirentero("¿Cuantos vehiculos desea registar?");
        while (tam < 0) {
            ob.mostrar("Error, el numero debe ser positivo.");
            tam = ob.pedirentero("¿Cuantos vehiculos desea registar?");
        }

        for (int i = 0; i < tam; i++) {
            ob.mostrar("Dias de pico y placa: " + "\nLunes: Placas terminadadas en 0-1-2-3." + "\nMartes: Placas terminadas en 4-5-6." + "\nMiercoles: Placas terminadas en 7-8-9." + "\nJueves : Placas terminadadas en 0-1-2-3." + "\nViernes: Placas terminadas en 4-5-6." + "\nSabados: Placas terminadas en 7-8-9.");

            placa = ob.pedircaracter("Digite la parte alfabetica de la placa:");
            em.setPlacaalf(placa);

            numplac = ob.pedirentero("Digite la parte numerica de la placa :");

            while (numplac < 0 || numplac > 999) {
                ob.mostrar("Error, digite una placa entre 000 y 999.");
                numplac = ob.pedirentero("digite el numero de placa del vehiculo:");
            }
            em.setPlacanum(numplac);
            if (numplac % 10 == 0 || numplac % 10 == 1 || numplac % 10 == 2 || numplac % 10 == 3) {
                ob.mostrar("Tiene pico y placa los dias lunes y los jueves.");
                pico = ob.pedircaracter("Ingrese los dias de pico y placa separados por una coma (dia,dia).");
                while (pico.equalsIgnoreCase(dia1) == false) {
                    ob.mostrar("Error, digite los dias correctos de la siguiente manera (Lunes,Jueves) sin los parentesis.");
                    pico = ob.pedircaracter("Ingrese los dias de pico y placa separados por una coma (Dia,Dia).");
                }

                em.setPico(pico);
            }
            if (numplac % 10 == 4 || numplac % 10 == 5 || numplac % 10 == 6) {
                ob.mostrar("Tiene pico y placa los dias martes y viernes.");
                pico = ob.pedircaracter("Ingrese los dias de pico y placa separados por una coma (Dia,Dia).");
                while (pico.equalsIgnoreCase(dia2) == false) {
                    ob.mostrar("Error, digite los dias correctos de la siguiente manera (Martes,Viernes) sin los parentesis.");
                    pico = ob.pedircaracter("Ingrese los dias de pico y placa separados por una coma (Dia,Dia).");
                }
                em.setPico(pico);
            }
            if (numplac % 10 == 7 || numplac % 10 == 8 || numplac % 10 == 9) {
                ob.mostrar("Tiene pico y placa los dias miercoles y sabados.");
                pico = ob.pedircaracter("Ingrese los dias de pico y placa separados por una coma (Dia,Dia)");
                while (pico.equalsIgnoreCase(dia3) == false) {
                    ob.mostrar("Error, digite los dias correctos de la siguiente manera (Miercoles,Sabados) sin los parentesis");
                    pico = ob.pedircaracter("Ingrese los dias de pico y placa separados por una coma (Dia,Dia)");
                }
                em.setPico(pico);

            }

            nombrepropi = ob.pedircaracter("Digite el nombre del propietario del vehiculo:");
            em.setNombrepro(nombrepropi);
            ccpropi = ob.pedirentero("Digite el numero de cedula del propietario:");
            while (validarpropietario(ccpropi) || ccpropi < 0) {
                ob.mostrar("Error,vuelva a digitar.");
                ccpropi = ob.pedirentero("Digite el numero de cedula del propietario:");
            }

            em.setCcpro(ccpropi);
            capcarg = ob.pedirentero("Ingrese la capacidad de carga de vehiculo: " + "\nrecuerde que la mimima capacidad de carga es de 1000 kg y la maxima capacidad es de 4000 kg");
            while ( capcarg > 4000 || capcarg < 1000) {
                ob.mostrar("Error, recuerde que la minima capacidad de carga es de 1000 kg y la maxima capacidad es de 4000 kg");
                capcarg = ob.pedirentero("Ingrese la capacidad de carga de vehiculo" + "\nrecuerde que la mimima capacidad de carga es de 1000 kg y la maxima capacidad es de 4000 kg: ");
            }

            zona = ob.pedircaracter("Digite la zona del propietario");
            while ((zona.equalsIgnoreCase(norte) || zona.equalsIgnoreCase(sur) || zona.equalsIgnoreCase(occidente) || zona.equalsIgnoreCase(oriente)) == false) {
                ob.mostrar("Error, las zonas a digitar deben ser sur, norte, ocidente u oriente");
                zona = ob.pedircaracter("Digite la zona del propietario");
            }
            em.setZona(zona);

            if (zona.equalsIgnoreCase(norte)) {
                servicio = ob.pedircaracter("Ingrese el servicio a realizar:");
                em.setServicio(servicio);
                cliente = ob.pedircaracter("Ingrese el nombre del cliente:");
                em.setCliente(cliente);
                cccliente = ob.pedirentero("Ingrese el numero de documento del cliente:");
                while (cccliente < 0) {
                    ob.mostrar("Error");
                    cccliente = ob.pedirentero("Ingrese el numero de documento del cliente:");
                }
                em.setCccliente(cccliente);
                costo = ob.pedirdouble("Ingrese el costo del servicio");
                while (costo < 0) {
                    ob.mostrar("Error.");
                    costo = ob.pedirdouble("Ingrese el costo del servicio");
                }
                em.setCostoser(costo);

                norte1.add(new Entrega(placa, numplac, nombrepropi, ccpropi, capcarg, zona, cliente, cccliente, servicio, costo, pico));
                ob.mostrar("Registro añadido a la zona norte.");
            }

            if (zona.equalsIgnoreCase(sur)) {
                servicio = ob.pedircaracter("Ingrese el servicio a realizar");
                em.setServicio(servicio);
                cliente = ob.pedircaracter("Ingrese el nombre del cliente");
                em.setCliente(cliente);
                cccliente = ob.pedirentero("Ingrese el numero de documento del cliente");
                while (cccliente < 0) {
                    ob.mostrar("Error.");
                    cccliente = ob.pedirentero("ingrese el numero de documento del cliente");
                }
                em.setCccliente(cccliente);
                costo = ob.pedirdouble("ingrese el costo del servicio");
                while (costo < 0) {
                    ob.mostrar("Error.");
                    costo = ob.pedirdouble("ingrese el costo del servicio");
                }
                em.setCostoser(costo);

                sur1.add(new Entrega(placa, numplac, nombrepropi, ccpropi, capcarg, zona, cliente, cccliente, servicio, costo, pico));
                ob.mostrar("Registro añadido a la zona sur.");
            }

            if (zona.equalsIgnoreCase(occidente)) {
                servicio = ob.pedircaracter("Ingrese el servicio a realizar:");
                em.setServicio(servicio);
                cliente = ob.pedircaracter("Ingrese el nombre del cliente:");
                em.setCliente(cliente);
                cccliente = ob.pedirentero("Ingrese el numero de documento del cliente:");
                while (cccliente < 0) {
                    ob.mostrar("Error.");
                    cccliente = ob.pedirentero("Ingrese el numero de documento del cliente:");
                }
                em.setCccliente(cccliente);
                costo = ob.pedirdouble("Ingrese el costo del servicio:");
                while (costo < 0) {
                    ob.mostrar("Error.");
                    costo = ob.pedirdouble("Ingrese el costo del servicio:");
                }
                em.setCostoser(costo);

                este1.add(new Entrega(placa, numplac, nombrepropi, ccpropi, capcarg, zona, cliente, cccliente, servicio, costo, pico));
                ob.mostrar("Registro añadido a la zona occidente.");
            }
            if (zona.equalsIgnoreCase(oriente)) {
                servicio = ob.pedircaracter("Ingrese el servicio a realizar:");
                em.setServicio(servicio);
                cliente = ob.pedircaracter("Ingrese el nombre del cliente:");
                em.setCliente(cliente);
                cccliente = ob.pedirentero("Ingrese el numero de documento del cliente:");
                while (cccliente < 0) {
                    ob.mostrar("Error.");
                    cccliente = ob.pedirentero("Ingrese el numero de documento del cliente:");
                }
                em.setCccliente(cccliente);
                costo = ob.pedirdouble("Ingrese el costo del servicio:");
                while (costo < 0) {
                    ob.mostrar("Error.");
                    costo = ob.pedirdouble("Ingrese el costo del servicio:");
                }
                em.setCostoser(costo);

                oeste1.add(new Entrega(placa, numplac, nombrepropi, ccpropi, capcarg, zona, cliente, cccliente, servicio, costo, pico));
                ob.mostrar("Registro añadido a la zona oriente.");
            }

            entregatotal.add(new Entrega(placa, numplac, nombrepropi, ccpropi, capcarg, zona, cliente, cccliente, servicio, costo, pico));

        }

    }

    public void mostrarnorte() {
        double acum = 0;
        ob.mostrar("Datos de la zona norte:");
        for (int i = 0; i < norte1.size(); i++) {

            ob.mostrar("\nDatos del propietario: " + "\nplaca: " + norte1.get(i).getPlacaalf() + " " + norte1.get(i).getPlacanum() + "\nNombre del propietario: " + norte1.get(i).getNombrepro() + "\nDias de pico y placa: " + norte1.get(i).getPico() + "\nCC del propietario: " + norte1.get(i).getCcpro() + "\nCapacidad de carga en kg: " + norte1.get(i).getCapcarga() + "\nZona :" + norte1.get(i).getZona());
            ob.mostrar("\nDatos del cliente:" + "\nservicio a realizar: " + norte1.get(i).getServicio() + "\nNombre del cliente: " + norte1.get(i).getCliente() + "\nCC del cliente: " + norte1.get(i).getCccliente() + "\nCosto del servicio: " + norte1.get(i).getCostoser());
            acum = norte1.get(i).getCostoser() * 0.20;
            ob.mostrar("El pago al propietario por el servicio Realizado es: " + acum);
        }
        
    }

    public void mostrarsur() {
        
        double acum = 0;
        ob.mostrar("Datos de la zona sur:");
        for (int i = 0; i < sur1.size(); i++){
         ob.mostrar("\nDatos del propietario: " + "\nplaca: " + sur1.get(i).getPlacaalf() + " " + sur1.get(i).getPlacanum() + "\nNombre del propietario: " + sur1.get(i).getNombrepro() + "\nDias de pico y placa: " + sur1.get(i).getPico() + "\nCC del propietario: " + sur1.get(i).getCcpro() + "\nCapacidad de carga en kg: " + sur1.get(i).getCapcarga() + "\nZona :" + sur1.get(i).getZona());
            ob.mostrar("\nDatos del cliente:" + "\nservicio a realizar: " + sur1.get(i).getServicio() + "\nNombre del cliente: " + sur1.get(i).getCliente() + "\nCC del cliente: " + sur1.get(i).getCccliente() + "\nCosto del servicio: " + sur1.get(i).getCostoser());
            acum = sur1.get(i).getCostoser() * 0.20;
            ob.mostrar("El pago al propietario por el servicio Realizado es: " + acum);
        }
        
         
    }

    public void mostraroccidente() {
        double acum = 0;
        ob.mostrar("Datos de la zona occidente:");
        for (int i = 0; i < este1.size(); i++){
            ob.mostrar("\nDatos del propietario: " + "\nplaca: " + este1.get(i).getPlacaalf() + " " + este1.get(i).getPlacanum() + "\nNombre del propietario: " + este1.get(i).getNombrepro() + "\nDias de pico y placa: " + este1.get(i).getPico() + "\nCC del propietario: " + este1.get(i).getCcpro() + "\nCapacidad de carga en kg: " + este1.get(i).getCapcarga() + "\nZona :" + este1.get(i).getZona());
            ob.mostrar("\nDatos del cliente:" + "\nservicio a realizar: " + este1.get(i).getServicio() + "\nNombre del cliente: " + este1.get(i).getCliente() + "\nCC del cliente: " + este1.get(i).getCccliente() + "\nCosto del servicio: " + este1.get(i).getCostoser());
            acum = este1.get(i).getCostoser() * 0.20;
            ob.mostrar("El pago al propietario por el servicio Realizado es: " + acum);
        }
         
    }

    public void mostraroriente() {
        
        double acum = 0;
        ob.mostrar("Datos de la zona oriente:");
        for (int i = 0; i < oeste1.size(); i++){
        ob.mostrar("\nDatos del propietario: " + "\nplaca: " + oeste1.get(i).getPlacaalf() + " " + oeste1.get(i).getPlacanum() + "\nNombre del propietario: " + oeste1.get(i).getNombrepro() + "\nDias de pico y placa: " + oeste1.get(i).getPico() + "\nCC del propietario: " + oeste1.get(i).getCcpro() + "\nCapacidad de carga en kg: " + oeste1.get(i).getCapcarga() + "\nZona :" + oeste1.get(i).getZona());
            ob.mostrar("\nDatos del cliente:" + "\nservicio a realizar: " + oeste1.get(i).getServicio() + "\nNombre del cliente: " + oeste1.get(i).getCliente() + "\nCC del cliente: " + oeste1.get(i).getCccliente() + "\nCosto del servicio: " + oeste1.get(i).getCostoser());
            acum = oeste1.get(i).getCostoser() * 0.20;
            ob.mostrar("El pago al propietario por el servicio Realizado es:" + acum);
        }
        
         
        
    }

    public boolean buscarpropietario(int ccpropi) {
        int a = 0;

        for (int i = 0; i < entregatotal.size(); i++) {
            if (entregatotal.get(i).getCcpro() == ccpropi) {
                ob.mostrar("\nDatos del propietario: " + "\nplaca: " + entregatotal.get(i).getPlacaalf() + " " + entregatotal.get(i).getPlacanum() + "\nNombre del propietario: " + entregatotal.get(i).getNombrepro() + "\nDias de pico y placa: " + entregatotal.get(i).getPico() + "\nCC del propietario: " + entregatotal.get(i).getCcpro() + "\nCapacidad de carga en kg: " + entregatotal.get(i).getCapcarga() + "\nZona :" + entregatotal.get(i).getZona());
                ob.mostrar("\nDatos del cliente:" + "\nservicio a realizar: " + entregatotal.get(i).getServicio() + "\nNombre del cliente: " + entregatotal.get(i).getCliente() + "\nCC del cliente: " + entregatotal.get(i).getCccliente() + "\nCosto del servicio: " + entregatotal.get(i).getCostoser());
                  a = 1;
            }
            
        }

        if (a == 1) {
            return true;
        } else {
            ob.mostrar("El usuario no esta registrado.");
            return false;
        }
    }

    public boolean validarpropietario(int ccpropi) {
        int a = 0;
        for (int i = 0; i < entregatotal.size(); i++) {
            if (entregatotal.get(i).getCcpro() == ccpropi) {
                ob.mostrar(ccpropi + "==" + entregatotal.get(i).getCcpro());
                a = 1;
            }

        }

        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }
}
