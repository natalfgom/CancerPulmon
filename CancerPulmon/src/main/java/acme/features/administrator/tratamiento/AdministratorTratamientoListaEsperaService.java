
package acme.features.administrator.tratamiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tratamiento.TipoTratamiento;
import acme.entities.tratamiento.Tratamiento;
import acme.framework.components.accounts.Administrator;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;

@Service

public class AdministratorTratamientoListaEsperaService extends AbstractService<Administrator, Tratamiento> {
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
		List<Tratamiento> objects;

		final TipoTratamiento tipo = TipoTratamiento.TRASPLANTE;

		objects = this.repository.findByTipoTratamiento(tipo);

		super.getBuffer().setData(objects);
	}

	@Override
	public void unbind(final Tratamiento object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "estadoTratamiento");

		if (object.getPaciente() != null)
			tuple.put("nuhsa", object.getPaciente().getNuhsa());
		else
			tuple.put("nuhsa", "No disponible");

		super.getResponse().setData(tuple);
	}

}
