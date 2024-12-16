
package acme.testing.Oncologo.Tratamiento;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class OncologoTratamientoCreate extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/oncologo/positive-create-tratamiento.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void test100Positive(final int recordIndex, final String tipoTratamiento, final String estadoTratamiento, final String urgencia) {
		// Inicia sesión como administrador
		super.signIn("oncologo1", "oncologo1");

		// Accede al menú de pacientes y verifica que la lista de pacientes se muestra
		super.clickOnMenu("Patients", "Patient List");
		super.checkListingExists();  // Verifica que la lista de pacientes existe
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		super.clickOnButton("Add Treatment");
		super.fillInputBoxIn("tipoTratamiento", tipoTratamiento);
		super.fillInputBoxIn("estadoTratamiento", estadoTratamiento);
		super.fillInputBoxIn("urgencia", urgencia);
		super.clickOnSubmit("Create Treatment");

		super.clickOnMenu("Treatments", "Edit Treatments");
		super.checkListingExists();
		super.sortListing(5, "desc");

		super.checkColumnHasValue(recordIndex, 2, estadoTratamiento);
		super.checkColumnHasValue(recordIndex, 1, tipoTratamiento);
		super.checkColumnHasValue(recordIndex, 4, urgencia);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("tipoTratamiento", tipoTratamiento);
		super.checkInputBoxHasValue("estadoTratamiento", estadoTratamiento);
		super.checkInputBoxHasValue("urgencia", urgencia);

		// Cierra la sesión
		super.signOut();
	}

}
