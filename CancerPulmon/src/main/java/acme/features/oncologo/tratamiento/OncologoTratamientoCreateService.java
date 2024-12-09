
package acme.features.oncologo.tratamiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tratamiento.EstadoTratamiento;
import acme.entities.tratamiento.Tratamiento;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Oncologo;
import acme.roles.Paciente;

@Service
public class OncologoTratamientoCreateService extends AbstractService<Oncologo, Tratamiento> {

	@Autowired
	protected OncologoTratamientoRepository repository;

	// AbstractService interface methods


	@Override
	public void check() {
		// Cambia el nombre del parámetro 'id' en vez de 'masterId'
		final boolean status = super.getRequest().hasData("id", int.class);
		super.getResponse().setChecked(status);
	}

	@Override
	public void authorise() {
		boolean status;

		// Asegúrate de que el usuario tiene el rol de Oncólogo
		final int pacienteId = super.getRequest().getData("id", int.class);
		final Paciente paciente = this.repository.findOnePacienteById(pacienteId);
		status = paciente != null && super.getRequest().getPrincipal().hasRole(Oncologo.class);

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Tratamiento object;
		int pacienteId;

		// Obtenemos el paciente correspondiente usando el id
		pacienteId = super.getRequest().getData("id", int.class);
		final Paciente paciente = this.repository.findOnePacienteById(pacienteId);

		if (paciente == null)
			throw new IllegalArgumentException("Paciente no encontrado con id: " + pacienteId);

		// Creamos un nuevo objeto Tratamiento y lo configuramos
		object = new Tratamiento();
		object.setPaciente(paciente);
		object.setEstadoTratamiento(EstadoTratamiento.PENDIENTE); // Estado por defecto
		object.setTipoTratamiento(null);

		// Activamos el modo borrador para el tratamiento
		object.setDraftMode(true);

		// Colocamos el objeto en el buffer para que esté disponible en la vista
		super.getBuffer().setData(object);
	}

	@Override
	public void bind(final Tratamiento object) {
		assert object != null;

		// Vinculamos los datos del formulario con los atributos del objeto tratamiento
		super.bind(object, "tipoTratamiento", "estadoTratamiento");
	}

	@Override
	public void validate(final Tratamiento object) {
		assert object != null;

		// Añadir validaciones específicas si es necesario
	}

	@Override
	public void perform(final Tratamiento object) {
		assert object != null;

		// Guardamos el tratamiento en la base de datos
		this.repository.save(object);
	}

	@Override
	public void unbind(final Tratamiento object) {
		assert object != null;

		// Desvinculamos el tratamiento para enviarlo a la vista
		final Tuple tuple = super.unbind(object, "tipoTratamiento", "estadoTratamiento");

		// Pasamos el ID del paciente al modelo para la vista
		tuple.put("pacienteId", object.getPaciente().getId());

		// Colocamos el tuple en la respuesta
		super.getResponse().setData(tuple);
	}
}
