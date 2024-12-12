
package acme.features.oncologo.tratamiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tratamiento.EstadoTratamiento;
import acme.entities.tratamiento.TipoTratamiento;
import acme.entities.tratamiento.Tratamiento;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Oncologo;
import acme.roles.Paciente;

@Service
public class OncologoTratamientoCreateService extends AbstractService<Oncologo, Tratamiento> {

	@Autowired
	protected OncologoTratamientoRepository repository;


	@Override
	public void check() {
		final boolean status = super.getRequest().hasData("pacienteId", int.class);
		super.getResponse().setChecked(status);
	}

	@Override
	public void authorise() {
		boolean status;

		final int pacienteId = super.getRequest().getData("pacienteId", int.class);
		final Paciente paciente = this.repository.findOnePacienteById(pacienteId);
		status = paciente != null && super.getRequest().getPrincipal().hasRole(Oncologo.class);

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Tratamiento object;
		int pacienteId;

		// Obtenemos el paciente correspondiente usando el id
		pacienteId = super.getRequest().getData("pacienteId", int.class);
		final Paciente paciente = this.repository.findOnePacienteById(pacienteId);

		// Creamos un nuevo objeto Tratamiento y lo configuramos
		object = new Tratamiento();
		object.setPaciente(paciente);
		object.setEstadoTratamiento(EstadoTratamiento.PENDIENTE); // Estado por defecto
		object.setTipoTratamiento(TipoTratamiento.OTRO);

		// Colocamos el objeto en el buffer para que esté disponible en la vista
		super.getBuffer().setData(object);
	}

	@Override
	public void bind(final Tratamiento object) {
		assert object != null;

		// Vinculamos los datos del formulario con los atributos del objeto tratamiento
		super.bind(object, "tipoTratamiento", "estadoTratamiento", "urgencia");
	}

	@Override
	public void validate(final Tratamiento object) {
		assert object != null;

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
		final Tuple tuple = super.unbind(object, "tipoTratamiento", "estadoTratamiento", "urgencia");

		if (object.getPaciente() != null) {
			tuple.put("nuhsa", object.getPaciente().getNuhsa());
			tuple.put("name", object.getPaciente().getName());
			tuple.put("surname", object.getPaciente().getSurname());
			tuple.put("genero", object.getPaciente().getGenero());
			tuple.put("fechaNacimiento", object.getPaciente().getFechaNacimiento());
			tuple.put("grupoSanguineo", object.getPaciente().getGrupoSanguineo());
		} else {

			tuple.put("nuhsa", "No disponible");
			tuple.put("name", "No disponible");
			tuple.put("surname", "No disponible");
			tuple.put("genero", "No disponible");
			tuple.put("fechaNacimiento", "No disponible");
			tuple.put("grupoSanguineo", "No disponible");
		}

		// Pasamos el ID del paciente al modelo para la vista
		tuple.put("pacienteId", object.getPaciente().getId());

		// Colocamos el tuple en la respuesta
		super.getResponse().setData(tuple);
	}
}
