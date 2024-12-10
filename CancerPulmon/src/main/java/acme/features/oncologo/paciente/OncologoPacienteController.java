
package acme.features.oncologo.paciente;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.framework.controllers.AbstractController;
import acme.roles.Oncologo;
import acme.roles.Paciente;

@Controller
public class OncologoPacienteController extends AbstractController<Oncologo, Paciente> {

	@Autowired
	protected OncologoPacienteListService	listService;
	@Autowired
	protected OncologoPacienteShowService	showService;


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("list", this.listService);
		super.addBasicCommand("show", this.showService);
	}
}
