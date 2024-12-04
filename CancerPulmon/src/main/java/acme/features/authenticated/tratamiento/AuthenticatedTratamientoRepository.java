
package acme.features.authenticated.tratamiento;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tratamiento.Tratamiento;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedTratamientoRepository extends AbstractRepository {

	@Query("select a from Tratamiento a where a.id = :id")
	Tratamiento findOneTratamientotById(int id);

	//Método para listar tratamientos
	@Query("select t from Tratamiento t")
	List<Tratamiento> findTratamientos();

}
