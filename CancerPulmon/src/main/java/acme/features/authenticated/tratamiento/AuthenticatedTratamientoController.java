
package acme.features.authenticated.tratamiento;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.tratamiento.Tratamiento;
import acme.framework.components.accounts.Authenticated;
import acme.framework.controllers.AbstractController;

@Controller
public class AuthenticatedTratamientoController extends AbstractController<Authenticated, Tratamiento> {

	@Autowired
	protected AuthenticatedTratamientoListService			listService;
	@Autowired
	protected AuthenticatedTratamientoShowService			showService;

	@Autowired
	protected AuthenticatedTratamientoListaEsperaService	listaEspera;


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("list", this.listService);
		super.addBasicCommand("show", this.showService);
		super.addCustomCommand("list-all", "list", this.listaEspera);
	}
}
