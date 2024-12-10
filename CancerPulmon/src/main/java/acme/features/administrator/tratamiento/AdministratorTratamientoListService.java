
package acme.features.administrator.tratamiento;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tratamiento.Tratamiento;
import acme.framework.components.accounts.Administrator;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;

@Service
public class AdministratorTratamientoListService extends AbstractService<Administrator, Tratamiento> {
	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorTratamientoRepository repository;

	// AbstractService interface ----------------------------------------------


	@Override
	public void check() {
		super.getResponse().setChecked(true);
	}

	@Override
	public void authorise() {
		super.getResponse().setAuthorised(true);
	}

	@Override
	public void load() {
		Collection<Tratamiento> objects;

		objects = this.repository.findAllTratamientosWithPaciente();

		super.getBuffer().setData(objects);
	}

	@Override
	public void unbind(final Tratamiento object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "tipoTratamiento", "estadoTratamiento");

		if (object.getPaciente() != null)
			tuple.put("nuhsa", object.getPaciente().getNuhsa());
		else
			tuple.put("nuhsa", "No disponible");

		super.getResponse().setData(tuple);
	}

}
