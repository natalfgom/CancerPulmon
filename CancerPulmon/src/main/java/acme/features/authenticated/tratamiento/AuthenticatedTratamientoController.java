
package acme.features.authenticated.tratamiento;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.tratamiento.Tratamiento;
import acme.framework.components.accounts.Authenticated;
import acme.framework.controllers.AbstractController;

public class AuthenticatedTratamientoController extends AbstractController<Authenticated, Tratamiento> {

	@Autowired
	protected AuthenticatedTratamientoListService	listService;
	@Autowired
	protected AuthenticatedTratamientoShowService	showService;


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("list", this.listService);
		super.addBasicCommand("show", this.showService);
	}
}