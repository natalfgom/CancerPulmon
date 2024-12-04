
package acme.entities.listaEspera;

import javax.persistence.Entity;
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
public class listaEspera extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotNull
	protected Status			EstadoTransplante;

	// Relationships ----------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne
	protected Paciente			paciente;

}
