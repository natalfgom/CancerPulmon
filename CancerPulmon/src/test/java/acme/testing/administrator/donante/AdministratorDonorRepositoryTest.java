
package acme.testing.administrator.donante;

import org.springframework.data.jpa.repository.Query;

import acme.entities.donante.Donante;
import acme.framework.repositories.AbstractRepository;

public interface AdministratorDonorRepositoryTest extends AbstractRepository {

	@Query("SELECT d FROM Donante d ORDER BY RAND()")
	Donante findRandomDonante();

}
