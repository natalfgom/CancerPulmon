
package acme.roles;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.framework.data.AbstractRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Paciente extends AbstractRole {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	protected String			nuhsa;

	@NotBlank
	protected String			name;

	@NotBlank
	protected String			surname;

	@NotNull
	protected Genero			genero;

	@NotNull
	protected GrupoSanguineo	GrupoSanguineo;

	@NotNull
	protected Date				fechaNacimiento;

	protected boolean			draftMode;

	//@OneToMany(cascade = {
	//CascadeType.REMOVE, CascadeType.REFRESH
	//})
	//protected Collection<Tratamiento>	tratamientos;

}
