
package acme.features.administrator.donante;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.donante.Donante;
import acme.entities.tratamiento.Tratamiento;
import acme.framework.components.accounts.Administrator;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.GrupoSanguineo;

@Service
public class AdministratorDonanteCompatibleListService extends AbstractService<Administrator, Donante> {

	@Autowired
	protected AdministratorDonanteRepository repository;


	@Override
	public void check() {
		// Verifica si el tratamientoId está presente en la solicitud.
		final boolean status = super.getRequest().hasData("tratamientoId", int.class);
		super.getResponse().setChecked(status);
	}

	@Override
	public void authorise() {
		boolean status;

		// Obtener el tratamientoId desde la solicitud
		final int tratamientoId = super.getRequest().getData("tratamientoId", int.class);

		// Obtener el tratamiento correspondiente utilizando el id
		final Tratamiento tratamiento = this.repository.findTratamientoById(tratamientoId);

		// Verificar si el tratamiento existe
		status = tratamiento != null;

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		int tratamientoId;
		Tratamiento tratamiento;
		List<Donante> donantes;

		// Obtener el tratamientoId desde la solicitud
		tratamientoId = super.getRequest().getData("tratamientoId", int.class);

		// Obtener el tratamiento correspondiente utilizando el id
		tratamiento = this.repository.findTratamientoById(tratamientoId);

		// Si se encuentra el tratamiento, buscar los donantes compatibles

		// Obtener el grupo sanguíneo del paciente asociado al tratamiento
		final @NotNull GrupoSanguineo grupoSanguineo = tratamiento.getPaciente().getGrupoSanguineo();

		// Buscar donantes compatibles con el grupo sanguíneo
		donantes = this.repository.findDonantesByGrupoSanguineo(grupoSanguineo);

		// Colocar los donantes en el buffer de datos
		super.getBuffer().setData(donantes);

	}

	@Override
	public void unbind(final Donante donante) {
		assert donante != null;

		Tuple tuple;

		// Desvinculamos los atributos del donante para enviarlos a la vista
		tuple = super.unbind(donante, "nombre", "nhusa");

		super.getResponse().setData(tuple);
	}
}
