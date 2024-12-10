
package acme.features.oncologo.donante;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.donante.Donante;
import acme.framework.controllers.AbstractController;
import acme.roles.Oncologo;

@Controller
public class OncologoDonanteController extends AbstractController<Oncologo, Donante> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected OncologoDonanteListService	listService;

	@Autowired
	protected OncologoDonanteShowService	showService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("list", this.listService);
		super.addBasicCommand("show", this.showService);
	}

}
