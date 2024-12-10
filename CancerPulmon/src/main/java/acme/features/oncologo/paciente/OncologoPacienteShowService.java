
package acme.features.oncologo.paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Oncologo;
import acme.roles.Paciente;

@Service
public class OncologoPacienteShowService extends AbstractService<Oncologo, Paciente> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected OncologoPacienteRepository repository;

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
		final Paciente paciente;

		id = super.getRequest().getData("id", int.class);
		status = super.getRequest().getPrincipal() != null;
		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Paciente object;
		int id;

		id = super.getRequest().getData("id", int.class);
		object = this.repository.findOnePacienteById(id);

		super.getBuffer().setData(object);
	}

	@Override
	public void unbind(final Paciente object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "nuhsa", "name", "surname", "genero", "grupoSanguineo", "fechaNacimiento");

		// Pasamos el ID del paciente al modelo para la vista
		tuple.put("pacienteId", object.getId());
		super.getResponse().setData(tuple);
	}

}
