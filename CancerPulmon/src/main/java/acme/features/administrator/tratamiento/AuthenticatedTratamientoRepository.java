
package acme.features.administrator.tratamiento;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.donante.Donante;
import acme.entities.tratamiento.EstadoTratamiento;
import acme.entities.tratamiento.TipoTratamiento;
import acme.entities.tratamiento.Tratamiento;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedTratamientoRepository extends AbstractRepository {

	@Query("select a from Tratamiento a where a.id = :id")
	Tratamiento findOneTratamientotById(int id);

	@Query("SELECT t FROM Tratamiento t JOIN FETCH t.paciente p")
	Collection<Tratamiento> findAllTratamientosWithPaciente();

	@Query("select t from Tratamiento t where t.tipoTratamiento = :tipoTratamiento")
	List<Tratamiento> findByTipoTratamiento(TipoTratamiento tipoTratamiento);

	@Query("SELECT t FROM Tratamiento t WHERE t.tipoTratamiento = :tipoTratamiento AND t.estadoTratamiento = :estadoTratamiento ORDER BY " + "CASE t.urgencia " + "WHEN 'Alta' THEN 1 " + "WHEN 'Media' THEN 2 " + "WHEN 'Baja' THEN 3 " + "END")
	List<Tratamiento> findByTipoTratamientoAndEstadoOrderByUrgenciaAndFechaInclusion(TipoTratamiento tipoTratamiento, EstadoTratamiento estadoTratamiento);

	// Consulta para obtener un tratamiento por su ID
	@Query("SELECT t FROM Tratamiento t WHERE t.id = :id")
	Tratamiento findTratamientoById(int id);

	// Consulta para obtener los donantes compatibles según el grupo sanguíneo
	@Query("SELECT d FROM Donante d WHERE d.grupoSanguineo = :grupoSanguineo")
	List<Donante> findDonantesByGrupoSanguineo(String grupoSanguineo);

}
