
package acme.testing.administrator.donante;

import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;

public class AdministratorDonanteShowTest extends TestHarness {

	protected AdministratorDonorRepositoryTest repository;


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

	@Test
	public void test300Hacking() {

		String param;
		param = String.format("id=%d", 53);

		super.signIn("paciente1", "paciente1");
		super.request("/administrator/donante/list", param);
		super.checkPanicExists();
		super.signOut();
	}
}
