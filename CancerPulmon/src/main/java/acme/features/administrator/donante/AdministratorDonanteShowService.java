
package acme.features.administrator.donante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.donante.Donante;
import acme.framework.components.accounts.Administrator;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;

@Service
public class AdministratorDonanteShowService extends AbstractService<Administrator, Donante> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorDonanteRepository repository;

	// AbstractService interface ----------------------------------------------


	@Override
	public void check() {
		boolean status;

		status = super.getRequest().hasData("id", int.class);

		super.getResponse().setChecked(status);
	}

	@Override
	public void authorise() {
		boolean status;
		int id;
		final Donante donante;

		id = super.getRequest().getData("id", int.class);
		status = super.getRequest().getPrincipal() != null;
		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Donante object;
		int id;

		id = super.getRequest().getData("id", int.class);
		object = this.repository.findOneDonanteById(id);

		super.getBuffer().setData(object);
	}

	@Override
	public void unbind(final Donante object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "nhusa", "nombre", "apellidos", "grupoSanguineo", "organoDisponible", "volumenPulmonar", "fechaExtraccion");

		super.getResponse().setData(tuple);
	}

}
