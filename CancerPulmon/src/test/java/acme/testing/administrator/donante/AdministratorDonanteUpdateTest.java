
package acme.testing.administrator.donante;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AdministratorDonanteUpdateTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/donante-update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void test100Positive(final int recordIndex, final String nhusa, final String nombre, final String apellidos, final String grupoSanguineo, final String organoDisponible, final String volumenPulmonar, final String fechaExtraccion) {
		super.signIn("administrator", "administrator");

		// Navegar al menú de donantes disponibles
		super.clickOnMenu("Donors", "Available Donors");
		super.checkListingExists();

		// Si existe ordenación, ajustar
		super.sortListing(0, "asc");

		// Acceder al registro específico
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();

		// Actualizar campos
		super.fillInputBoxIn("nhusa", nhusa);
		super.fillInputBoxIn("nombre", nombre);
		super.fillInputBoxIn("apellidos", apellidos);
		super.fillInputBoxIn("grupoSanguineo", grupoSanguineo);
		super.fillInputBoxIn("organoDisponible", organoDisponible);
		super.fillInputBoxIn("volumenPulmonar", volumenPulmonar);
		super.fillInputBoxIn("fechaExtraccion", fechaExtraccion);
		super.clickOnSubmit("Save changes");

		// Verificar cambios en el listado
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);

		// Verificar valores actualizados
		super.checkFormExists();
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
	@CsvFileSource(resources = "/administrator/donante-update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void test200Negative(final int recordIndex, final String nhusa, final String nombre, final String apellidos, final String grupoSanguineo, final String organoDisponible, final String volumenPulmonar, final String fechaExtraccion) {
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Donors", "Available Donors");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.fillInputBoxIn("nhusa", nhusa);
		super.fillInputBoxIn("nombre", nombre);
		super.fillInputBoxIn("apellidos", apellidos);
		super.fillInputBoxIn("grupoSanguineo", grupoSanguineo);
		super.fillInputBoxIn("organoDisponible", organoDisponible);
		super.fillInputBoxIn("volumenPulmonar", volumenPulmonar);
		super.fillInputBoxIn("fechaExtraccion", fechaExtraccion);
		super.clickOnSubmit("Save changes");

		super.checkErrorsExist();

		super.signOut();
	}

	@Test
	public void test300Hacking() {
		// HINT: this test tries to update a job with a role other than "Employer",
		// HINT+ or using an employer who is not the owner.

		String param;
		param = String.format("id=%d", 53);
		super.signIn("oncologo1", "oncologo1");
		super.request("/administrator/donante/update", "53");
		super.checkPanicExists();
		super.signOut();

		super.signIn("paciente1", "paciente1");
		super.request("/administrator/donante/update", "53");
		super.checkPanicExists();
		super.signOut();
	}

}
