
package acme.features.administrator.paciente;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.donante.Donante;
import acme.entities.tratamiento.Tratamiento;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Paciente;

@Repository
public interface AdministratorPacienteRepository extends AbstractRepository {

	@Query("select a from Paciente a where a.id = :id")
	Paciente findOnePacienteById(int id);

	// Buscar paciente por su 'nuhsa'
	@Query("select p from Paciente p where p.nuhsa = :nuhsa")
	Optional<Paciente> findOnePacienteByNuhsa(String nuhsa);

	// Buscar todos los pacientes
	@Query("select p from Paciente p")
	Collection<Paciente> findAllPacientes();

	@Query("select t from Tratamiento t where t.paciente = :paciente")
	Collection<Tratamiento> findTratamientosByPaciente(Paciente paciente);

	@Query("select d from Donante d where d.grupoSanguineo = :grupoSanguineo")
	List<Donante> findCompatibleDonantes(String grupoSanguineo);

	// Guardar un paciente (el método save ya está incluido por JpaRepository)
	// No es necesario definirlo explícitamente, pero si fuera necesario sería:
	// void save(Paciente paciente);
}
