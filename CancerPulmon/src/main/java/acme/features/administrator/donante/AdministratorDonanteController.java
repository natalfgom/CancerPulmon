
package acme.features.administrator.donante;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.donante.Donante;
import acme.framework.components.accounts.Administrator;
import acme.framework.controllers.AbstractController;

@Controller
public class AdministratorDonanteController extends AbstractController<Administrator, Donante> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorDonanteListService	listService;

	@Autowired
	protected AdministratorDonanteShowService	showService;

	@Autowired
	protected AdmnistratorDonanteUpdateService	updateService;

	@Autowired
	protected AdmnistratorDonanteDeleteService	deleteService;

	@Autowired
	protected AdmnistratorDonanteCreateService	createService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("list", this.listService);
		super.addBasicCommand("show", this.showService);
		super.addBasicCommand("update", this.updateService);
		super.addBasicCommand("delete", this.deleteService);
		super.addBasicCommand("create", this.createService);
	}

}
