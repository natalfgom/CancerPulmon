
package acme.features.authenticated.donante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.donante.Donante;
import acme.framework.components.accounts.Administrator;
import acme.framework.components.accounts.Authenticated;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;

@Service
public class AuthenticatedDonanteUpdateService extends AbstractService<Authenticated, Donante> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AuthenticatedDonanteRepository repository;

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
		int donanteId;
		Donante donante;

		donanteId = super.getRequest().getData("id", int.class);
		donante = this.repository.findOneDonanteById(donanteId);
		status = donante != null && super.getRequest().getPrincipal().hasRole(Administrator.class);

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
	public void bind(final Donante object) {
		assert object != null;

		super.bind(object, "nhusa", "nombre", "apellidos", "grupoSanguineo", "organoDisponible", "volumenPulmonar", "fechaExtraccion");
	}

	@Override
	public void validate(final Donante object) {
		assert object != null;
	}

	@Override
	public void perform(final Donante object) {
		assert object != null;

		this.repository.save(object);
	}

	@Override
	public void unbind(final Donante object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "nhusa", "nombre", "apellidos", "grupoSanguineo", "organoDisponible", "volumenPulmonar", "fechaExtraccion");

		super.getResponse().setData(tuple);
	}

}
