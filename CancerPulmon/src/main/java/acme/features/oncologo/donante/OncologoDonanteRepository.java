
package acme.features.oncologo.donante;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.donante.Donante;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface OncologoDonanteRepository extends AbstractRepository {

	@Query("select a from Donante a where a.id = :id")
	Donante findOneDonanteById(int id);

	// Método para listar todos los pacientes
	@Query("select d from Donante d")
	List<Donante> findDonantes();

}
