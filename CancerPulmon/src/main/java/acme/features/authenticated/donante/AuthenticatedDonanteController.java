
package acme.features.authenticated.donante;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.donante.Donante;
import acme.framework.components.accounts.Authenticated;
import acme.framework.controllers.AbstractController;

@Controller
public class AuthenticatedDonanteController extends AbstractController<Authenticated, Donante> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AuthenticatedDonanteListService	listService;

	@Autowired
	protected AuthenticatedDonanteShowService	showService;

	@Autowired
	protected AuthenticatedDonanteUpdateService			updateService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("list", this.listService);
		super.addBasicCommand("show", this.showService);
		super.addBasicCommand("update", this.updateService);
	}

}
