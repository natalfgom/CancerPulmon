
package acme.features.authenticated.tratamiento;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tratamiento.TipoTratamiento;
import acme.entities.tratamiento.Tratamiento;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedTratamientoRepository extends AbstractRepository {

	@Query("select a from Tratamiento a where a.id = :id")
	Tratamiento findOneTratamientotById(int id);

	//Método para listar tratamientos
	//@Query("select t from Tratamiento t")
	//List<Tratamiento> findTratamientos();

	@Query("SELECT t FROM Tratamiento t JOIN FETCH t.paciente p")
	Collection<Tratamiento> findAllTratamientosWithPaciente();

	@Query("select t from Tratamiento t where t.tipoTratamiento = :tipoTratamiento")
	List<Tratamiento> findByTipoTratamiento(TipoTratamiento tipoTratamiento);

	@Query("SELECT t FROM Tratamiento t WHERE t.tipoTratamiento = :tipoTratamiento ORDER BY t.urgencia, t.fechaInclusion")
	List<Tratamiento> findByTipoTratamientoOrderByUrgenciaAndFechaInclusion(TipoTratamiento tipoTratamiento);

}
