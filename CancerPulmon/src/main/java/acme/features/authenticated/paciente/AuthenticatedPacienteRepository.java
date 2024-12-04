
package acme.features.authenticated.paciente;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;
import acme.roles.Paciente;

@Repository
public interface AuthenticatedPacienteRepository extends AbstractRepository {

	@Query("select a from Paciente a where a.id = :id")
	Paciente findOnePacienteById(int id);

	// Método para listar todos los pacientes
	@Query("select p from Paciente p")
	List<Paciente> findPacientes();

}
