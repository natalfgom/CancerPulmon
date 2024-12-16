
package acme.testing.Oncologo.Tratamiento;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class OncologoTrtamientoEditTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/oncologo/positive-update-tratamiento.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void test100Positive(final int recordIndex, final String key, final String tipoTratamiento, final String estadoTratamiento, final String urgencia, final String paciente, final String fechaInclusion) {
		// HINT: this test logs in as an oncologist, lists all treatments, 
		// HINT+ selects one of them, updates it, and then checks that 
		// HINT+ the update has actually been performed.

		super.signIn("oncologo1", "oncologo1");

		super.clickOnMenu("Treatments", "Edit Treatments");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.fillInputBoxIn("tipoTratamiento", tipoTratamiento);
		super.fillInputBoxIn("estadoTratamiento", estadoTratamiento);
		super.fillInputBoxIn("urgencia", urgencia);
		super.clickOnSubmit("Save Changes");

		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 1, tipoTratamiento);
		super.checkColumnHasValue(recordIndex, 2, estadoTratamiento);
		super.checkColumnHasValue(recordIndex, 4, urgencia);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("tipoTratamiento", tipoTratamiento);
		super.checkInputBoxHasValue("estadoTratamiento", estadoTratamiento);
		super.checkInputBoxHasValue("urgencia", urgencia);

		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/oncologo/negative-update-tratamiento.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void test200Negative(final int recordIndex, final String key, final String tipoTratamiento, final String estadoTratamiento, final String urgencia, final String paciente, final String fechaInclusion) {
		// HINT: this test attempts to update a job with wrong data.

		super.signIn("oncologo1", "oncologo1");

		super.clickOnMenu("Treatments", "Edit Treatments");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.fillInputBoxIn("tipoTratamiento", tipoTratamiento);
		super.fillInputBoxIn("estadoTratamiento", estadoTratamiento);
		super.fillInputBoxIn("urgencia", urgencia);
		super.clickOnSubmit("Save Changes");

		super.checkErrorsExist();

		super.signOut();

	}

}
