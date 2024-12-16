
package acme.features.administrator.paciente;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tratamiento.Tratamiento;
import acme.framework.components.accounts.Administrator;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Paciente;

@Service
public class AdmnistratorPacienteDeleteService extends AbstractService<Administrator, Paciente> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorPacienteRepository repository;


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
		Paciente paciente;

		id = super.getRequest().getData("id", int.class);
		paciente = this.repository.findOnePacienteById(id);

		status = paciente != null && super.getRequest().getPrincipal().hasRole(Administrator.class);

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Paciente paciente;
		int id;

		id = super.getRequest().getData("id", int.class);
		paciente = this.repository.findOnePacienteById(id);

		super.getBuffer().setData(paciente);
	}

	@Override
	public void bind(final Paciente paciente) {
		assert paciente != null;

	}

	@Override
	public void validate(final Paciente paciente) {
		assert paciente != null;

	}

	@Override
	public void perform(final Paciente paciente) {
		assert paciente != null;

		final Collection<Tratamiento> tratamientos = this.repository.findTratamientosByPaciente(paciente);

		if (tratamientos != null && !tratamientos.isEmpty())
			this.repository.deleteAll(tratamientos);

		this.repository.delete(paciente);
	}

	@Override
	public void unbind(final Paciente paciente) {
		assert paciente != null;

		final Tuple tuple = super.unbind(paciente, "nuhsa", "name", "surname", "genero", "grupoSanguineo", "fechaNacimiento", "afectado");

		super.getResponse().setData(tuple);
	}
}
