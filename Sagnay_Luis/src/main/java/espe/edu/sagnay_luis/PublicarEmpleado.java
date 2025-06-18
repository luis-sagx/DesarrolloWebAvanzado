/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espe.edu.sagnay_luis;

import espe.edu.sagnay_luis.resources.EmpleadoWebServiceImplement;
import jakarta.xml.ws.Endpoint;

/**
 *
 * @author Luis Sagnay
 */
public class PublicarEmpleado {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8088/ws/empleado", new EmpleadoWebServiceImplement());
        System.out.println("Servicio SOAP publicado en http://localhost:8080/ws/empleado?wsdl");
    }
}
