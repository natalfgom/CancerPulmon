
package acme.features.oncologo.tratamiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tratamiento.Tratamiento;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Oncologo;

@Service
public class OncologoTratamientoShowService extends AbstractService<Oncologo, Tratamiento> {
	// Internal state ---------------------------------------------------------

	@Autowired
	protected OncologoTratamientoRepository repository;

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

	//@Override
	//public void load() {
	//Tratamiento object;
	//int id;

	//id = super.getRequest().getData("id", int.class);
	//object = this.repository.findOneTratamientotById(id);

	//super.getBuffer().setData(object);
	//}

	@Override
	public void load() {
		Tratamiento object;
		int id;

		// Obtenemos el id del tratamiento desde la petición
		id = super.getRequest().getData("id", int.class);

		// Buscamos el tratamiento por su id, asegurándonos de cargar el paciente asociado
		object = this.repository.findOneTratamientotById(id);

		// Pasamos el tratamiento (con su paciente asociado) al buffer
		super.getBuffer().setData(object);
	}

	@Override
	public void unbind(final Tratamiento object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "tipoTratamiento", "estadoTratamiento", "urgencia", "fechaInclusion");

		tuple.put("nuhsa", object.getPaciente().getNuhsa());
		tuple.put("name", object.getPaciente().getName());
		tuple.put("surname", object.getPaciente().getSurname());
		tuple.put("genero", object.getPaciente().getGenero());
		tuple.put("fechaNacimiento", object.getPaciente().getFechaNacimiento());
		tuple.put("grupoSanguineo", object.getPaciente().getGrupoSanguineo());
		tuple.put("afectado", object.getPaciente().getAfectado());

		super.getResponse().setData(tuple);
	}
}
