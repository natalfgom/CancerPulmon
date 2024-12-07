
// package acme.features.administrator.donante;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
//
// import acme.entities.donante.Donante;
// import acme.framework.components.accounts.Administrator;
// import acme.framework.components.models.Tuple;
// import acme.framework.services.AbstractService;
//
// @Service
// public class AdmnistratorDonanteCreateService extends AbstractService<Administrator, Donante> {
// // Internal state ---------------------------------------------------------
//
// @Autowired
// protected AdministratorDonanteRepository repository;
//
//
// // AbstractService interface ----------------------------------------------
// @Override
// public void check() {
// boolean status;
//
// status = super.getRequest().hasData("masterId", int.class);
//
// super.getResponse().setChecked(status);
// }
//
// @Override
// public void authorise() {
// boolean status;
//
// // Solo los administradores pueden crear Donantes
// status = super.getRequest().getPrincipal().hasRole(Administrator.class);
//
// super.getResponse().setAuthorised(status);
// }

// @Override
// public void load() {
// // Creamos un nuevo Donante vacío para que el formulario pueda ser llenado
// final Donante donante = new Donante();
// donante.setNhusa("");
// donante.setNombre("");
// donante.setApellidos("");
// donante.setGrupoSanguineo(null); // No establecer un valor por defecto
// donante.setOrganoDisponible(null); // No establecer un valor por defecto
// donante.setVolumenPulmonar(0.0);
// donante.setFechaExtraccion(null);
//
// // Usamos un buffer para almacenar temporalmente el objeto
// super.getBuffer().setData(donante);
// }
//
// @Override
// public void bind(final Donante object) {
// assert object != null;
//
// // Vincula los datos de la solicitud con el objeto Donante
// super.bind(object, "nhusa", "nombre", "apellidos", "grupoSanguineo", "organoDisponible", "volumenPulmonar", "fechaExtraccion");
// }
//
// @Override
// public void validate(final Donante object) {
// assert object != null;
//
// // Aquí puedes agregar validaciones adicionales si es necesario
// // Ejemplo: Verificar que el nhusa sea único o que el volumen pulmonar sea positivo
// }
//
// @Override
// public void perform(final Donante object) {
// assert object != null;
//
// // Guardamos el Donante en la base de datos
// this.repository.save(object);
// }
//
// @Override
// public void unbind(final Donante object) {
// assert object != null;
//
// // Desvinculamos el objeto Donante para preparar la respuesta
// final Tuple tuple = super.unbind(object, "nhusa", "nombre", "apellidos", "grupoSanguineo", "organoDisponible", "volumenPulmonar", "fechaExtraccion");
//
// super.getResponse().setData(tuple);
// }

/*
 * AdministratorDonanteCreateService.java
 *
 * Copyright (C) 2012-2023 Rafael Corchuelo.
 *
 * En coherencia con el propósito tradicional de fomentar la educación y la investigación,
 * es política del propietario de los derechos de autor permitir el uso y la redistribución
 * no comercial de este software. Ha sido probado cuidadosamente, pero no se garantiza para
 * ningún propósito en particular. El propietario de los derechos de autor no ofrece ninguna
 * garantía ni representación, ni acepta ninguna responsabilidad al respecto.
 */

package acme.features.administrator.donante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.donante.Donante;
import acme.entities.donante.OrganoDisponible;
import acme.framework.components.accounts.Administrator;
import acme.framework.components.models.Tuple;
import acme.framework.services.AbstractService;
import acme.roles.GrupoSanguineo;

@Service
public class AdmnistratorDonanteCreateService extends AbstractService<Administrator, Donante> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorDonanteRepository repository;

	// AbstractService interface ----------------------------------------------


	@Override
	public void check() {
		boolean status;

		// Comprueba si la petición incluye los datos necesarios.
		status = true; // Puedes añadir validaciones específicas si es necesario.

		super.getResponse().setChecked(status);
	}

	@Override
	public void authorise() {
		boolean status;

		// Solo los administradores pueden crear Donantes.
		status = super.getRequest().getPrincipal().hasRole(Administrator.class);

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Donante object;

		// Crea una nueva instancia de Donante con valores iniciales por defecto.
		object = new Donante();
		object.setNhusa("");
		object.setNombre("");
		object.setApellidos("");
		object.setGrupoSanguineo(GrupoSanguineo.O_POSITIVO);
		object.setOrganoDisponible(OrganoDisponible.Lobulo_pulmonar);
		object.setVolumenPulmonar(0.0);
		object.setFechaExtraccion(null);

		// Coloca el objeto en el buffer para su uso en la vista.
		super.getBuffer().setData(object);
	}

	@Override
	public void bind(final Donante object) {
		assert object != null;

		// Vincula los datos enviados desde el formulario a la entidad.
		super.bind(object, "nhusa", "nombre", "apellidos", "grupoSanguineo", "organoDisponible", "volumenPulmonar", "fechaExtraccion");
	}

	@Override
	public void validate(final Donante object) {
		assert object != null;

		// Añade validaciones específicas si es necesario.
		// Por ejemplo: validación del formato del NHUSA o del grupo sanguíneo.
	}

	@Override
	public void perform(final Donante object) {
		assert object != null;

		// Guarda el objeto Donante en la base de datos.
		this.repository.save(object);
	}

	@Override
	public void unbind(final Donante object) {
		assert object != null;

		Tuple tuple;

		// Desvincula la entidad para enviarla a la vista.
		tuple = super.unbind(object, "nhusa", "nombre", "apellidos", "grupoSanguineo", "organoDisponible", "volumenPulmonar", "fechaExtraccion");

		// Coloca el tuple en la respuesta para el cliente.
		super.getResponse().setData(tuple);
	}

}
