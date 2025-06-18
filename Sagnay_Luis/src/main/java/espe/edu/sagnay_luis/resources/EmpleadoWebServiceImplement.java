/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package espe.edu.sagnay_luis.resources;

import espe.edu.sagnay_luis.dao.EmpleadoDao;
import espe.edu.sagnay_luis.model.Empleado;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Luis Sagnay
 */
@WebService(endpointInterface = "com.espe.sagnay_luis.resources.EmpleadoWebService")
public class EmpleadoWebServiceImplement implements EmpleadoWebService {

    private final EmpleadoDao dao = new EmpleadoDao();

    @Override
    public List<Empleado> listar() {
        return dao.findAll();
    }

    @Override
    public Empleado buscarPorId(int id) {
        return dao.findById(id);
    }

    @Override
    public String guardar(Empleado empleado) {
        dao.save(empleado);
        return "Empleado guardado exitosamente";
    }

    @Override
    public String actualizar(Empleado empleado) {
        dao.update(empleado);
        return "Empleado actualizado exitosamente";
    }

    public String eliminar(int id) {
        dao.delete(id);
        return "Empleado eliminado exitosamente";
    }

}