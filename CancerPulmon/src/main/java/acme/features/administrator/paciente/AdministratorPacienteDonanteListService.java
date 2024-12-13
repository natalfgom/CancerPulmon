
package acme.features.administrator.paciente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.donante.Donante;
import acme.features.administrator.donante.AdministratorDonanteRepository;
import acme.framework.components.accounts.Administrator;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.GrupoSanguineo;
import acme.roles.Paciente;

@Service
public class AdministratorPacienteDonanteListService extends AbstractService<Administrator, Paciente> {

	@Autowired
	protected AdministratorPacienteRepository	pacienteRepository;

	@Autowired
	protected AdministratorDonanteRepository	donanteRepository;


	@Override
	public void check() {
		// Confirmamos que los datos necesarios están presentes en la solicitud
		final boolean status = super.getRequest().hasData("pacienteId", int.class) && super.getRequest().hasData("grupoSanguineo", String.class);
		super.getResponse().setChecked(status);
	}

	@Override
	public void authorise() {
		// Verificamos que el usuario tiene rol de administrador
		final boolean status = super.getRequest().getPrincipal().hasRole(Administrator.class);
		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		// Obtenemos el paciente y sus donantes compatibles
		final int pacienteId = super.getRequest().getData("pacienteId", int.class);
		final Paciente paciente = this.pacienteRepository.findOnePacienteById(pacienteId);

		// Recuperamos el grupo sanguíneo como String desde la solicitud
		final String grupoSanguineoStr = super.getRequest().getData("grupoSanguineo", String.class);
		GrupoSanguineo grupoSanguineo = null;

		// Convertimos el grupo sanguíneo de String a GrupoSanguineo (enum)
		try {
			grupoSanguineo = GrupoSanguineo.valueOf(grupoSanguineoStr);
		} catch (final IllegalArgumentException e) {
			throw new IllegalStateException("El valor de grupo sanguíneo no es válido: " + grupoSanguineoStr, e);
		}

		// Obtenemos los donantes compatibles según el grupo sanguíneo
		final List<Donante> compatibles = this.donanteRepository.findCompatibleDonantes(grupoSanguineo);

		// Pasamos los donantes compatibles al modelo
		final Tuple tuple = super.unbind(paciente, "name", "surname", "grupoSanguineo");
		tuple.put("donantes", compatibles);

		super.getResponse().setData(tuple);
	}

	@Override
	public void unbind(final Paciente entity) {
		assert entity != null;

		final Tuple tuple = super.unbind(entity, "name", "surname", "grupoSanguineo");
		super.getResponse().setData(tuple);
	}
}
