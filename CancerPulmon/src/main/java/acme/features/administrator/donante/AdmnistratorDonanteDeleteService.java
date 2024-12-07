
package acme.features.administrator.donante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.donante.Donante;
import acme.framework.components.accounts.Administrator;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;

@Service
public class AdmnistratorDonanteDeleteService extends AbstractService<Administrator, Donante> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorDonanteRepository repository;


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
		int donanteId;
		Donante donante;

		// Obtenemos el ID del Donante desde la solicitud
		donanteId = super.getRequest().getData("id", int.class);
		donante = this.repository.findOneDonanteById(donanteId);

		// Solo autorizamos la operación si el Donante existe y el usuario tiene el rol de Administrator
		status = donante != null && super.getRequest().getPrincipal().hasRole(Administrator.class);

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Donante donante;
		int id;

		// Obtenemos el Donante a eliminar a partir del ID en la solicitud
		id = super.getRequest().getData("id", int.class);
		donante = this.repository.findOneDonanteById(id);

		super.getBuffer().setData(donante);
	}

	@Override
	public void bind(final Donante donante) {
		assert donante != null;

		// En este caso no necesitamos hacer nada con la información del Donante para la eliminación
	}

	@Override
	public void validate(final Donante donante) {
		assert donante != null;

		// No necesitamos ninguna validación especial para eliminar un Donante
	}

	@Override
	public void perform(final Donante donante) {
		assert donante != null;
		// Eliminamos el Donante de la base de datos
		this.repository.delete(donante);
	}

	@Override
	public void unbind(final Donante donante) {
		assert donante != null;

		// No es necesario unbind ya que estamos eliminando el Donante, pero si necesitas enviar datos puedes hacerlo aquí
		final Tuple tuple = super.unbind(donante, "nhusa", "nombre", "apellidos", "grupoSanguineo", "organoDisponible", "volumenPulmonar", "fechaExtraccion");

		super.getResponse().setData(tuple);
	}
}
