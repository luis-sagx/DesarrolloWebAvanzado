/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package espe.edu.sagnay_luis.resources;

import espe.edu.sagnay_luis.model.Empleado;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Luis Sagnay
 */
@WebService
public interface EmpleadoWebService {
@WebMethod
    List<Empleado> listar();
    
    @WebMethod
    Empleado buscarPorId(@WebParam(name = "id") int id);

    @WebMethod
    String guardar(@WebParam(name = "empleado") Empleado empleado);

    @WebMethod
    String actualizar(@WebParam(name = "empleado") Empleado empleado);

    @WebMethod
    String eliminar(@WebParam(name = "id") int id);
}
