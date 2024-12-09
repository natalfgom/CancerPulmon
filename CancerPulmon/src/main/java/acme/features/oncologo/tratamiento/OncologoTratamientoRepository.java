
package acme.features.oncologo.tratamiento;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tratamiento.Tratamiento;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Paciente;

@Repository
public interface OncologoTratamientoRepository extends AbstractRepository {

	@Query("select a from Tratamiento a where a.id = :id")
	Tratamiento findOneTratamientotById(int id);

	//Método para listar tratamientos
	//@Query("select t from Tratamiento t")
	//List<Tratamiento> findTratamientos();

	@Query("SELECT t FROM Tratamiento t JOIN FETCH t.paciente p")
	Collection<Tratamiento> findAllTratamientosWithPaciente();

	@Query("select p from Paciente p where p.id = :id")
	Paciente findOnePacienteById(int id);

}
