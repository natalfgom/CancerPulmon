
package acme.testing.Oncologo.Tratamiento;

import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;

public class OncologoTratamientoListTest extends TestHarness {

	@Test
	public void test100Positive() {
		// Inicia sesión como administrador
		super.signIn("oncologo1", "oncologo1");

		// Accede al menú de pacientes y verifica que la lista de pacientes se muestra
		super.clickOnMenu("Treatments", "Edit Treatments");
		super.checkListingExists();  // Verifica que la lista de pacientes existe

		// Cierra la sesión
		super.signOut();
	}

}
