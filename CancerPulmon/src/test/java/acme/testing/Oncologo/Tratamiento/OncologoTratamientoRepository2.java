
package acme.testing.Oncologo.Tratamiento;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import acme.entities.tratamiento.Tratamiento;
import acme.framework.repositories.AbstractRepository;

public interface OncologoTratamientoRepository2 extends AbstractRepository {

	@Query("select t from Tratamiento t")
	List<Tratamiento> findTratamientos();

}
