
package acme.features.oncologo.paciente;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Oncologo;
import acme.roles.Paciente;

@Service
public class OncologoPacienteListService extends AbstractService<Oncologo, Paciente> {
	// Internal state ---------------------------------------------------------

	@Autowired
	protected OncologoPacienteRepository repository;

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
