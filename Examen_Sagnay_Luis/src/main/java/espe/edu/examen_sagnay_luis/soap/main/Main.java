/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espe.edu.examen_sagnay_luis.soap.main;
import espe.edu.examen_sagnay_luis.soap.HotelService;
import jakarta.xml.ws.Endpoint;

/**
 *
 * @author Luis Sagnay
 */

public class Main {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8081/ws/hoteles", new HotelService());
        System.out.println("Servicio SOAP publicado en: http://localhost:8081/ws/hoteles?wsdl");
    }
}
