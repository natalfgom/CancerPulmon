
package acme.testing.administrator.donante;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import acme.entities.donante.Donante;
import acme.framework.repositories.AbstractRepository;

public interface AdministratorDonorRepositoryTest extends AbstractRepository {

	@Query("select d from Donante d")
	List<Donante> findDonantes();

}
