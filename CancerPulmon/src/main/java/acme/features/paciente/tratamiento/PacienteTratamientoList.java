
package acme.features.paciente.tratamiento;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tratamiento.EstadoTratamiento;
import acme.entities.tratamiento.TipoTratamiento;
import acme.entities.tratamiento.Tratamiento;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.Paciente;

@Service

public class PacienteTratamientoList extends AbstractService<Paciente, Tratamiento> {
	// Internal state ---------------------------------------------------------

	@Autowired
	protected PacienteTratamientoRepository repository;

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
		List<Tratamiento> allTreatments;

		final TipoTratamiento tipo = TipoTratamiento.TRASPLANTE;
		final EstadoTratamiento estado = EstadoTratamiento.PENDIENTE;
		final int userId = super.getRequest().getPrincipal().getActiveRoleId();

		// Obtiene todos los tratamientos del tipo solicitado, ordenados globalmente por urgencia
		allTreatments = this.repository.findByTipoTratamientoAndEstadoOrderByUrgenciaAndFechaInclusion(tipo, estado);

		// Asigna el orden dinámico globalmente
		for (int i = 0; i < allTreatments.size(); i++) {
			final Tratamiento tratamiento = allTreatments.get(i);
			tratamiento.setOrden(i + 1); // Asigna el orden comenzando 1
		}

		// Filtra por el paciente actual
		final List<Tratamiento> objects = allTreatments.stream().filter(tratamiento -> tratamiento.getPaciente() != null && tratamiento.getPaciente().getId() == userId).collect(Collectors.toList());

		super.getBuffer().setData(objects);
	}

	@Override
	public void unbind(final Tratamiento object) {
		assert object != null;

		Tuple tuple;

		tuple = super.unbind(object, "estadoTratamiento", "tipoTratamiento", "urgencia", "orden");

		if (object.getPaciente() != null)
			tuple.put("nuhsa", object.getPaciente().getNuhsa());
		else
			tuple.put("nuhsa", "No disponible");

		super.getResponse().setData(tuple);
	}

}
