
package acme.features.authenticated.paciente;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.accounts.Authenticated;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Paciente;

@Service
public class AuthenticatedPacienteListService extends AbstractService<Authenticated, Paciente> {
	// Internal state ---------------------------------------------------------

	@Autowired
	protected AuthenticatedPacienteRepository repository;

	// AbstractService interface ----------------------------------------------


	@Override
	public void check() {
		super.getResponse().setChecked(true);
	}

	@Override
	public void authorise() {
		super.getResponse().setAuthorised(true);
	}

	@Override
	public void load() {
		Collection<Paciente> objects;

		objects = this.repository.findPacientes();

		super.getBuffer().setData(objects);
	}

	@Override
	public void unbind(final Paciente object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "nuhsa", "name", "surname");

		super.getResponse().setData(tuple);
	}

}
