
package acme.features.administrator.donante;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.donante.Donante;
import acme.entities.tratamiento.Tratamiento;
import acme.framework.repositories.AbstractRepository;
import acme.roles.GrupoSanguineo;

@Repository
public interface AdministratorDonanteRepository extends AbstractRepository {

	@Query("select a from Donante a where a.id = :id")
	Donante findOneDonanteById(int id);

	// Método para listar todos los pacientes
	@Query("select d from Donante d")
	List<Donante> findDonantes();

	@Query("SELECT t FROM Tratamiento t WHERE t.id = :id")
	Tratamiento findTratamientoById(int id);

	@Query("SELECT d FROM Donante d WHERE d.grupoSanguineo = :grupoSanguineo")
	List<Donante> findDonantesByGrupoSanguineo(@NotNull GrupoSanguineo grupoSanguineo);

	@Query("select d from Donante d where d.grupoSanguineo = :grupoSanguineo")
	List<Donante> findCompatibleDonantes(GrupoSanguineo grupoSanguineo);

}
