
package acme.features.authenticated.listaEspera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.listaEspera.listaEspera;
import acme.framework.components.accounts.Authenticated;
import acme.framework.controllers.AbstractController;

@Controller
public class AuthenticatedListaController extends AbstractController<Authenticated, listaEspera> {

	@Autowired
	protected AuthenticatedListaListService listService;
	//@Autowired
	//protected AuthenticatedListaShowService	showService;

	//@PostConstruct

	//protected void initialise() {
	//super.addBasicCommand("list", this.listService);
	//super.addBasicCommand("show", this.showService);
	//}

}
