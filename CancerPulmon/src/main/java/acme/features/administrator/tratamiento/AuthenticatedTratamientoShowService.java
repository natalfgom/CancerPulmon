
package acme.features.administrator.tratamiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tratamiento.Tratamiento;
import acme.framework.components.accounts.Administrator;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;

@Service
public class AuthenticatedTratamientoShowService extends AbstractService<Administrator, Tratamiento> {
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

		tuple = super.unbind(object, "tipoTratamiento", "estadoTratamiento", "urgencia");

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

		super.getResponse().setData(tuple);
	}
}
