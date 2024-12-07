
package acme.features.administrator.donante;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.donante.Donante;
import acme.framework.components.accounts.Administrator;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;

@Service
public class AdministratorDonanteListService extends AbstractService<Administrator, Donante> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorDonanteRepository repository;

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
		Collection<Donante> objects;

		objects = this.repository.findDonantes();

		super.getBuffer().setData(objects);
	}

	@Override
	public void unbind(final Donante object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "nhusa", "nombre", "apellidos");

		super.getResponse().setData(tuple);
	}

}
