
package acme.features.administrator.tratamiento;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.tratamiento.Tratamiento;
import acme.framework.components.accounts.Administrator;
import acme.framework.controllers.AbstractController;

@Controller
public class AdministratorTratamientoController extends AbstractController<Administrator, Tratamiento> {

	@Autowired
	protected AdministratorTratamientoListService			listService;
	@Autowired
	protected AdministratorTratamientoShowService			showService;

	@Autowired
	protected AdministratorTratamientoListaEsperaService	listaEspera;


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("list", this.listService);
		super.addBasicCommand("show", this.showService);
		super.addCustomCommand("list-all", "list", this.listaEspera);
	}
}
