
package acme.testing.administrator.paciente;

import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;

public class AdministratorPacienteListTest extends TestHarness {

	@Test
	public void test100Positive() {
		// Inicia sesión como administrador
		super.signIn("administrator", "administrator");

		// Accede al menú de pacientes y verifica que la lista de pacientes se muestra
		super.clickOnMenu("Patients", "Patient List");
		super.checkListingExists();  // Verifica que la lista de pacientes existe

		// Cierra la sesión
		super.signOut();
	}
}
