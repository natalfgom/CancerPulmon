
package acme.features.administrator.paciente;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.framework.components.accounts.Administrator;
import acme.framework.controllers.AbstractController;
import acme.roles.Paciente;

@Controller
public class AdministratorPacienteController extends AbstractController<Administrator, Paciente> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorPacienteCreateService		createService;

	@Autowired
	protected AdmnistratorPacienteUpdateService			updateService;

	@Autowired
	protected AdmnistratorPacienteDeleteService			deleteService;

	@Autowired
	protected AdministratorPacienteShowService			showService;

	@Autowired
	protected AdministratorPacienteListService			listService;

	@Autowired
	protected AdministratorPacienteDonanteListService	compatibles;;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("list", this.listService);
		super.addBasicCommand("show", this.showService);
		super.addBasicCommand("create", this.createService);
		super.addBasicCommand("update", this.updateService);
		super.addBasicCommand("delete", this.deleteService);
		super.addCustomCommand("compatibles", "list", this.compatibles);

	}

}
