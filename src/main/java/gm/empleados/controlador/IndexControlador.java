package gm.empleados.controlador;

import gm.empleados.modelo.Empleado;
import gm.empleados.servicio.EmpleadoServicio;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class IndexControlador { // Controlador de la pagina de inicio
    private static final Logger logger =
            LoggerFactory.getLogger(IndexControlador.class); // Mandamos la información de esta clase a la consola

    @Autowired // Trabajar con la capa de servicio
    EmpleadoServicio empleadoServicio;

    // Va a informar del archivo JSP que vamos a utilizar
    @RequestMapping(value = "/", method = RequestMethod.GET) // Especificamos la URL que vamos a utilizar
    public String iniciar(ModelMap modelo) {
        List<Empleado> empleados = empleadoServicio.listarEmpleados();
        empleados.forEach((empleado -> logger.info(empleado.toString()))); // enviamos los empleados de la lista por consola
        // Compartimos el modelo con la vista
        modelo.put("empleados", empleados); // Especificamos el 'id' y luego la información que sería la variable
        return "index"; // index.jsp
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.GET)
    public String mostrarAgregar() {
        return "agregar"; // agregar.jsp -> Redireccionamiento
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public String agregar(@ModelAttribute("empleadoForma") Empleado empleado,
                          HttpServletRequest request) {
        logger.info("Empleado a agregar: " + empleado);
        empleadoServicio.guardarEmpleado(empleado);
        return "redirect:/"; // Redirige al path de  "/" inicial!
    }

}
