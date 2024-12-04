
package acme.features.authenticated.tratamiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tratamiento.Tratamiento;
import acme.framework.components.accounts.Authenticated;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;

@Service
public class AuthenticatedTratamientoShowService extends AbstractService<Authenticated, Tratamiento> {
	// Internal state ---------------------------------------------------------

	@Autowired
	protected AuthenticatedTratamientoRepository repository;

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
		final Tratamiento tratamiento;

		id = super.getRequest().getData("id", int.class);
		status = super.getRequest().getPrincipal() != null;

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Tratamiento object;
		int id;

		id = super.getRequest().getData("id", int.class);
		object = this.repository.findOneTratamientotById(id);

		super.getBuffer().setData(object);
	}

	@Override
	public void unbind(final Tratamiento object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "tipoTratamiento", "estadoTratamiento");

		super.getResponse().setData(tuple);
	}
}
