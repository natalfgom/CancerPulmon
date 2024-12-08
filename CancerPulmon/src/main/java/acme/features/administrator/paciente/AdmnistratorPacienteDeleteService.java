
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

		// Obtenemos el ID del Donante desde la solicitud
		id = super.getRequest().getData("id", int.class);
		paciente = this.repository.findOnePacienteById(id);

		// Solo autorizamos la operación si el Donante existe y el usuario tiene el rol de Administrator
		status = paciente != null && super.getRequest().getPrincipal().hasRole(Administrator.class);

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Paciente paciente;
		int id;

		// Obtenemos el Donante a eliminar a partir del ID en la solicitud
		id = super.getRequest().getData("id", int.class);
		paciente = this.repository.findOnePacienteById(id);

		super.getBuffer().setData(paciente);
	}

	@Override
	public void bind(final Paciente paciente) {
		assert paciente != null;

		// En este caso no necesitamos hacer nada con la información del Donante para la eliminación
	}

	@Override
	public void validate(final Paciente paciente) {
		assert paciente != null;

		// No necesitamos ninguna validación especial para eliminar un Donante
	}

	@Override
	public void perform(final Paciente paciente) {
		assert paciente != null;

		// Recupera la colección de tratamientos asociados al paciente
		final Collection<Tratamiento> tratamientos = this.repository.findTratamientosByPaciente(paciente);

		// Elimina los tratamientos asociados al paciente
		if (tratamientos != null && !tratamientos.isEmpty())
			this.repository.deleteAll(tratamientos);

		// Elimina el paciente
		this.repository.delete(paciente);
	}

	@Override
	public void unbind(final Paciente paciente) {
		assert paciente != null;

		// No es necesario unbind ya que estamos eliminando el Donante, pero si necesitas enviar datos puedes hacerlo aquí
		final Tuple tuple = super.unbind(paciente, "nuhsa", "name", "surname", "genero", "grupoSanguineo", "fechaNacimiento");

		super.getResponse().setData(tuple);
	}
}
