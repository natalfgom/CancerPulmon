
package acme.features.paciente.tratamiento;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tratamiento.EstadoTratamiento;
import acme.entities.tratamiento.TipoTratamiento;
import acme.entities.tratamiento.Tratamiento;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface PacienteTratamientoRepository extends AbstractRepository {

	@Query("SELECT t FROM Tratamiento t WHERE t.tipoTratamiento = :tipoTratamiento AND t.estadoTratamiento = :estadoTratamiento ORDER BY " + "CASE t.urgencia " + "WHEN 'Alta' THEN 1 " + "WHEN 'Media' THEN 2 " + "WHEN 'Baja' THEN 3 " + "END")
	List<Tratamiento> findByTipoTratamientoAndEstadoOrderByUrgenciaAndFechaInclusion(TipoTratamiento tipoTratamiento, EstadoTratamiento estadoTratamiento);
}
