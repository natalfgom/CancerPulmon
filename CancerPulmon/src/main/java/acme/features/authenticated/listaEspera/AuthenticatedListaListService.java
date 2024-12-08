
package acme.features.authenticated.listaEspera;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.listaEspera.listaEspera;
import acme.features.authenticated.paciente.AuthenticatedPacienteRepository;
import acme.framework.components.accounts.Authenticated;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;

@Service
public class AuthenticatedListaListService extends AbstractService<Authenticated, listaEspera> {
	// Internal state ---------------------------------------------------------

	@Autowired
	protected AuthenticatedListaRepository repository;

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
		Collection<listaEspera> objects;

		objects = this.repository.findListas();

		super.getBuffer().setData(objects);
	}


	@Autowired
	protected AuthenticatedPacienteRepository repositoryp;


	@Override

	public void unbind(final listaEspera object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "nuhsa", "name", "surname");

		super.getResponse().setData(tuple);
	}

}
