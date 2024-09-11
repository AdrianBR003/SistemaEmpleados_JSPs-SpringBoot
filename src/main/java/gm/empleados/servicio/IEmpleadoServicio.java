package gm.empleados.servicio;

import gm.empleados.modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio{

    // Metodos Comandos MySQL
    public List<Empleado> listarEmpleados();
    public Empleado buscarEmpleadoporId(Integer idEmpleado);
    public void guardarEmpleado(Empleado empleado); // Si el 'id' de empleado es nulo, se crea, sino se sobreescribe
    public void eliminarEmpleado(Empleado empleado);

}
