
package acme.testing.administrator.donante;

import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;

public class AdministratorDonanteShowTest extends TestHarness {

	@Test
	public void test100Positive() {

		super.signIn("administrator", "administrator");

		super.clickOnMenu("Donors", "Available Donors");
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		super.checkFormExists();

		super.checkInputBoxHasValue("nhusa", "1122-C");
		super.checkInputBoxHasValue("nombre", "Maria");
		super.checkInputBoxHasValue("apellidos", "Rodriguez");
		super.checkInputBoxHasValue("grupoSanguineo", "AB_POSITIVO");
		super.checkInputBoxHasValue("organoDisponible", "Pulmon_completo_izquierdo");
		super.checkInputBoxHasValue("volumenPulmonar", "1,200.00");
		super.checkInputBoxHasValue("fechaExtraccion", "2023/11/04 00:00");

		super.signOut();
	}
}
