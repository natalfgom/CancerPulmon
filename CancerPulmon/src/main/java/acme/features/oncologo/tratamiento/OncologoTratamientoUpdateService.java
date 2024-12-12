
package acme.features.oncologo.tratamiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tratamiento.Tratamiento;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Oncologo;

@Service
public class OncologoTratamientoUpdateService extends AbstractService<Oncologo, Tratamiento> {

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
		final int tratamientoId;
		final Tratamiento tratamiento;

		tratamientoId = super.getRequest().getData("id", int.class);
		tratamiento = this.repository.findOneTratamientotById(tratamientoId);
		status = tratamiento != null && super.getRequest().getPrincipal().hasRole(Oncologo.class);

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Tratamiento object;
		int id;

		id = super.getRequest().getData("id", int.class);
		object = this.repository.findOneTratamientotById(id);

		super.getBuffer().setData(object);
	}

	@Override
	public void bind(final Tratamiento object) {
		assert object != null;

		super.bind(object, "tipoTratamiento", "estadoTratamiento", "urgencia");
	}

	@Override
	public void validate(final Tratamiento object) {
		assert object != null;
	}

	@Override
	public void perform(final Tratamiento object) {
		assert object != null;

		this.repository.save(object);
	}

	@Override
	public void unbind(final Tratamiento object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "tipoTratamiento", "estadoTratamiento", "urgencia");

		super.getResponse().setData(tuple);
	}

}
