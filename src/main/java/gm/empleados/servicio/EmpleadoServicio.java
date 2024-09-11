package gm.empleados.servicio;

import gm.empleados.modelo.Empleado;
import gm.empleados.repositorio.IEmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpleadoServicio implements IEmpleadoServicio{

    @Autowired
    private IEmpleadoRepositorio empleadoRepositorio; // Va a ser nuestro intermediario con la base de datos

    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepositorio.findAll();
    }

    @Override
    public Empleado buscarEmpleadoporId(Integer idEmpleado) {
        return empleadoRepositorio.findById(idEmpleado).orElse(null);
    }

    @Override
    public void guardarEmpleado(Empleado empleado) {
        empleadoRepositorio.save(empleado); // Si el id = null -> insert, sino update [Hibernate]
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadoRepositorio.delete(empleado);
    }
}
