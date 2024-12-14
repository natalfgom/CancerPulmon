
package acme.features.oncologo.tratamiento;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tratamiento.EstadoTratamiento;
import acme.entities.tratamiento.TipoTratamiento;
import acme.entities.tratamiento.Tratamiento;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Paciente;

@Repository
public interface OncologoTratamientoRepository extends AbstractRepository {

	@Query("select a from Tratamiento a where a.id = :id")
	Tratamiento findOneTratamientotById(int id);

	//Método para listar tratamientos
	//@Query("select t from Tratamiento t")
	//List<Tratamiento> findTratamientos();

	@Query("SELECT t FROM Tratamiento t JOIN FETCH t.paciente p")
	Collection<Tratamiento> findAllTratamientosWithPaciente();

	@Query("select p from Paciente p where p.id = :id")
	Paciente findOnePacienteById(int id);

	@Query("SELECT t FROM Tratamiento t WHERE t.tipoTratamiento = :tipoTratamiento AND t.estadoTratamiento = :estadoTratamiento ORDER BY " + "CASE t.urgencia " + "WHEN 'Alta' THEN 1 " + "WHEN 'Media' THEN 2 " + "WHEN 'Baja' THEN 3 " + "END")
	List<Tratamiento> findByTipoTratamientoAndEstadoOrderByUrgenciaAndFechaInclusion(TipoTratamiento tipoTratamiento, EstadoTratamiento estadoTratamiento);
}
