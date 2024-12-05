
package acme.entities.tratamiento;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import acme.framework.data.AbstractEntity;
import acme.roles.Paciente;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Tratamiento extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotNull
	@Enumerated(EnumType.STRING)
	protected TipoTratamiento	tipoTratamiento; //Enum

	@Enumerated(EnumType.STRING)
	@NotNull
	protected EstadoTratamiento	estadoTratamiento; // Enum: EN_CURSO, FINALIZADO, PENDIENTE

	// Relationships ----------------------------------------------------------
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Paciente			paciente; //Con la entidad paciente


	public Paciente getPaciente() {
		return this.paciente;
	}
}
