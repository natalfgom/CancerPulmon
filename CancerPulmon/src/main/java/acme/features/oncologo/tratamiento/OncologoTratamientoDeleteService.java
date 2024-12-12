
package acme.features.oncologo.tratamiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tratamiento.Tratamiento;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Oncologo;

@Service
public class OncologoTratamientoDeleteService extends AbstractService<Oncologo, Tratamiento> {

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
		int tratamientoId;
		Tratamiento tratamiento;

		tratamientoId = super.getRequest().getData("id", int.class);
		tratamiento = this.repository.findOneTratamientotById(tratamientoId);

		status = tratamiento != null && super.getRequest().getPrincipal().hasRole(Oncologo.class);

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Tratamiento tratamiento;
		int id;

		id = super.getRequest().getData("id", int.class);
		tratamiento = this.repository.findOneTratamientotById(id);

		super.getBuffer().setData(tratamiento);
	}

	@Override
	public void bind(final Tratamiento tratamiento) {
		assert tratamiento != null;
	}

	@Override
	public void validate(final Tratamiento tratamiento) {
		assert tratamiento != null;

	}

	@Override
	public void perform(final Tratamiento tratamiento) {
		assert tratamiento != null;

		this.repository.delete(tratamiento);
	}

	@Override
	public void unbind(final Tratamiento tratamiento) {
		assert tratamiento != null;

		// No es necesario unbind ya que estamos eliminando el Donante, pero si necesitas enviar datos puedes hacerlo aquí
		final Tuple tuple = super.unbind(tratamiento, "tipoTratamiento", "estadoTratamiento", "urgencia");

		super.getResponse().setData(tuple);
	}
}
