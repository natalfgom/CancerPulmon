
package acme.testing.administrator.donante;

import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;

public class AdministratorDonanteListTest extends TestHarness {

	@Test
	public void test100Positive() {
		// Inicia sesión como administrador
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Donors", "Available Donors");
		super.checkListingExists();

		// Cierra la sesión
		super.signOut();
	}

}
