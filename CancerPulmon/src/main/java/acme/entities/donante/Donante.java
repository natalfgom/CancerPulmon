
package acme.entities.donante;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.framework.data.AbstractEntity;
import acme.roles.GrupoSanguineo;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Donante extends AbstractEntity {
	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	protected String			nhusa; // Identificador único del paciente

	@NotBlank
	protected String			nombre;

	@NotBlank
	protected String			apellidos;

	@NotNull
	@Enumerated(EnumType.STRING)
	protected GrupoSanguineo	grupoSanguineo;

	@NotNull
	@Enumerated(EnumType.STRING)
	protected OrganoDisponible	organoDisponible;  // Enum: PULMON_COMPLETO_IZQUIERDO, PULMON_COMPLETO_DERECHO, LOBULO_PULMONAR

	@NotNull
	protected Double			volumenPulmonar;  // Volumen pulmonar

	@NotNull
	protected Date				fechaExtraccion;

}
