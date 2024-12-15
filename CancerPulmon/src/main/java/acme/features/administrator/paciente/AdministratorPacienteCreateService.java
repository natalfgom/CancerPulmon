
package acme.features.administrator.paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.accounts.Administrator;
import acme.framework.services.AbstractService;
import acme.roles.Paciente;

@Service
public class AdministratorPacienteCreateService extends AbstractService<Administrator, Paciente> {

	@Autowired
	private AdministratorPacienteRepository repository;


	@Override
	public void check() {
		super.getResponse().setChecked(true);
	}

	@Override
	public void authorise() {
		super.getResponse().setAuthorised(true);  // El administrador puede crear un paciente
	}

	@Override
	public void load() {
		Paciente object;

		// Crea una nueva instancia de la entidad Paciente.
		object = new Paciente();

		// Coloca el objeto paciente creado en el buffer, para que esté disponible en la respuesta o el modelo.
		super.getBuffer().setData(object);
	}

	@Override
	public void bind(final Paciente paciente) {
		assert paciente != null;
		super.bind(paciente, "nuhsa", "name", "surname", "genero", "fechaNacimiento", "grupoSanguineo", "userAccount");
	}

	@Override
	public void validate(final Paciente paciente) {
		if (paciente.getNuhsa() == null || paciente.getNuhsa().isEmpty())
			super.getBuffer().getErrors().add("nuhsa", "El nuhsa no puede estar vacío.");
	}

	@Override
	public void perform(final Paciente paciente) {
		assert paciente != null;

		this.repository.save(paciente);  // Guardar el paciente en la base de datos
	}

	@Override
	public void unbind(final Paciente paciente) {
		super.getResponse().setData(super.unbind(paciente, "nuhsa", "name", "surname", "genero", "fechaNacimiento", "grupoSanguineo", "userAccount"));
	}
}
