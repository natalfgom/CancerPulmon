
package acme.testing.administrator.donante;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AdministratorDonanteCreateTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/donante-create-positive2.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void test100Positive(final int recordIndex, final String nhusa, final String nombre, final String apellidos, final String grupoSanguineo, final String organoDisponible, final String volumenPulmonar, final String fechaExtraccion) {
		super.signIn("administrator", "administrator");

		// Navegar al menú de donantes disponibles
		super.clickOnMenu("Donors", "Create Donor");

		super.fillInputBoxIn("nhusa", nhusa);
		super.fillInputBoxIn("nombre", nombre);
		super.fillInputBoxIn("apellidos", apellidos);
		super.fillInputBoxIn("grupoSanguineo", grupoSanguineo);
		super.fillInputBoxIn("organoDisponible", organoDisponible);
		super.fillInputBoxIn("volumenPulmonar", volumenPulmonar);
		super.fillInputBoxIn("fechaExtraccion", fechaExtraccion);
		super.clickOnSubmit("Create Donor");

		super.clickOnMenu("Donors", "Available Donors");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.checkColumnHasValue(recordIndex, 0, nhusa);
		super.checkColumnHasValue(recordIndex, 1, nombre);
		super.checkColumnHasValue(recordIndex, 2, apellidos);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		// Verificar valores actualizados
		super.checkInputBoxHasValue("nhusa", nhusa);
		super.checkInputBoxHasValue("nombre", nombre);
		super.checkInputBoxHasValue("apellidos", apellidos);
		super.checkInputBoxHasValue("grupoSanguineo", grupoSanguineo);
		super.checkInputBoxHasValue("organoDisponible", organoDisponible);
		super.checkInputBoxHasValue("volumenPulmonar", volumenPulmonar);
		super.checkInputBoxHasValue("fechaExtraccion", fechaExtraccion);

		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/donante-create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void test200Negative(final int recordIndex, final String nhusa, final String nombre, final String apellidos, final String grupoSanguineo, final String organoDisponible, final String volumenPulmonar, final String fechaExtraccion) {
		super.signIn("administrator", "administrator");

		// Navegar al menú de donantes disponibles
		super.clickOnMenu("Donors", "Create Donor");

		super.fillInputBoxIn("nhusa", nhusa);
		super.fillInputBoxIn("nombre", nombre);
		super.fillInputBoxIn("apellidos", apellidos);
		super.fillInputBoxIn("grupoSanguineo", grupoSanguineo);
		super.fillInputBoxIn("organoDisponible", organoDisponible);
		super.fillInputBoxIn("volumenPulmonar", volumenPulmonar);
		super.fillInputBoxIn("fechaExtraccion", fechaExtraccion);
		super.clickOnSubmit("Create Donor");

		super.checkErrorsExist();

		super.signOut();
	}

	@Test
	public void test300Hacking() {
		// HINT: this test tries to create a job using principals with
		// HINT+ inappropriate roles.

		super.checkLinkExists("Sign in");
		super.request("/employer/job/create");
		super.checkPanicExists();

		super.signIn("oncologo1", "oncologo1");
		super.request("/administrator/donante/create");
		super.checkPanicExists();
		super.signOut();

		super.signIn("paciente1", "paciente1");
		super.request("/administrator/donante/create");
		super.checkPanicExists();
		super.signOut();
	}
}
