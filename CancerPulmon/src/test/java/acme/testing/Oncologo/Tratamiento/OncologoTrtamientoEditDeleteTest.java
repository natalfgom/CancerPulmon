
package acme.testing.Oncologo.Tratamiento;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class OncologoTrtamientoEditDeleteTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/oncologo/positive-show-tratamiento.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void test100Positive(final int recordIndex, final String key, final String tipoTratamiento, final String estadoTratamiento, final String urgencia, final String paciente, final String fechaInclusion) {
		// HINT: this test logs in as an oncologist, lists all treatments, 
		// HINT+ selects one of them, updates it, and then checks that 
		// HINT+ the update has actually been performed.

		super.signIn("oncologo1", "oncologo1");

		super.clickOnMenu("Treatments", "Edit Treatments");
		super.checkListingExists();  // Verifica que la lista de pacientes existe

		super.sortListing(0, "asc");

		super.checkColumnHasValue(recordIndex, 0, key);
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.fillInputBoxIn("key", key);
		super.fillInputBoxIn("tipoTratamiento", tipoTratamiento);
		super.fillInputBoxIn("estadoTratamiento", estadoTratamiento);
		super.fillInputBoxIn("urgencia", urgencia);
		super.clickOnSubmit("Save Changes");

		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, key);
		super.checkColumnHasValue(recordIndex, 1, estadoTratamiento);
		super.checkColumnHasValue(recordIndex, 2, urgencia);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("key", key);
		super.checkInputBoxHasValue("tipoTratamiento", tipoTratamiento);
		super.checkInputBoxHasValue("estadoTratamiento", estadoTratamiento);
		super.checkInputBoxHasValue("urgencia", urgencia);
	}

}
