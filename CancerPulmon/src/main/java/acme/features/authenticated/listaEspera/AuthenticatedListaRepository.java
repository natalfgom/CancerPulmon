
package acme.features.authenticated.listaEspera;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.listaEspera.listaEspera;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedListaRepository extends AbstractRepository {

	@Query("select p from listaEspera p")
	List<listaEspera> findListas();

}
