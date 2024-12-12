
package acme.features.paciente.tratamiento;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.tratamiento.Tratamiento;
import acme.framework.controllers.AbstractController;
import acme.roles.Paciente;

@Controller
public class PacienteTratamientoController extends AbstractController<Paciente, Tratamiento> {

	@Autowired
	protected PacienteTratamientoList listService;


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("list", this.listService);
	}

}
