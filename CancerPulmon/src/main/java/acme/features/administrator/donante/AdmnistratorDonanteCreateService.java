
package acme.features.administrator.donante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.donante.Donante;
import acme.framework.components.accounts.Administrator;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;

@Service
public class AdmnistratorDonanteCreateService extends AbstractService<Administrator, Donante> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorDonanteRepository repository;

	// AbstractService interface ----------------------------------------------


	@Override
	public void check() {
		boolean status;

		// Comprueba si la petición incluye los datos necesarios.
		status = true; // Puedes añadir validaciones específicas si es necesario.

		super.getResponse().setChecked(status);
	}

	@Override
	public void authorise() {
		boolean status;

		// Solo los administradores pueden crear Donantes.
		status = super.getRequest().getPrincipal().hasRole(Administrator.class);

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Donante object;

		// Crea una nueva instancia de Donante con valores iniciales por defecto.
		object = new Donante();

		// Coloca el objeto en el buffer para su uso en la vista.
		super.getBuffer().setData(object);
	}

	@Override
	public void bind(final Donante object) {
		assert object != null;

		// Vincula los datos enviados desde el formulario a la entidad.
		super.bind(object, "nhusa", "nombre", "apellidos", "grupoSanguineo", "organoDisponible", "volumenPulmonar", "fechaExtraccion");
	}

	@Override
	public void validate(final Donante object) {
		assert object != null;

		// Añade validaciones específicas si es necesario.
		// Por ejemplo: validación del formato del NHUSA o del grupo sanguíneo.
	}

	@Override
	public void perform(final Donante object) {
		assert object != null;

		// Guarda el objeto Donante en la base de datos.
		this.repository.save(object);
	}

	@Override
	public void unbind(final Donante object) {
		assert object != null;

		Tuple tuple;

		// Desvincula la entidad para enviarla a la vista.
		tuple = super.unbind(object, "nhusa", "nombre", "apellidos", "grupoSanguineo", "organoDisponible", "volumenPulmonar", "fechaExtraccion");

		// Coloca el tuple en la respuesta para el cliente.
		super.getResponse().setData(tuple);
	}

}
