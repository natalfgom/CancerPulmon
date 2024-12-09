
package acme.features.oncologo.tratamiento;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.tratamiento.Tratamiento;
import acme.framework.controllers.AbstractController;
import acme.roles.Oncologo;

@Controller
public class OncologoTratamientoController extends AbstractController<Oncologo, Tratamiento> {

	@Autowired
	protected OncologoTratamientoListService	listService;
	@Autowired
	protected OncologoTratamientoShowService	showService;
	@Autowired
	protected OncologoTratamientoUpdateService	updateService;
	@Autowired
	protected OncologoTratamientoDeleteService	deleteService;
	@Autowired
	protected OncologoTratamientoCreateService	createService;


	@PostConstruct
	protected void initialise() {
		super.addBasicCommand("list", this.listService);
		super.addBasicCommand("show", this.showService);
		super.addBasicCommand("update", this.updateService);
		super.addBasicCommand("delete", this.deleteService);
		super.addBasicCommand("create", this.createService);
	}
}
