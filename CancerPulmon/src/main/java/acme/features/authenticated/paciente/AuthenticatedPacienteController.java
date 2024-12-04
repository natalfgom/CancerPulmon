
package acme.features.authenticated.paciente;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.framework.components.accounts.Authenticated;
import acme.framework.controllers.AbstractController;
import acme.roles.Paciente;

@Controller
public class AuthenticatedPacienteController extends AbstractController<Authenticated, Paciente> {

	@Autowired
	protected AuthenticatedPacienteListService	listService;
	@Autowired
	protected AuthenticatedPacienteShowService	showService;


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("list", this.listService);
		super.addBasicCommand("show", this.showService);
	}
}
