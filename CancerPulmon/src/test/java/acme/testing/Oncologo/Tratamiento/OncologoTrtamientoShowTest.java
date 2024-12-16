
package acme.testing.Oncologo.Tratamiento;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.tratamiento.Tratamiento;
import acme.testing.TestHarness;

public class OncologoTrtamientoShowTest extends TestHarness {

	@Autowired
	protected OncologoTratamientoRepository2 repository;


	@ParameterizedTest
	@CsvFileSource(resources = "/oncologo/positive-show-tratamiento.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void test100Positive(final int recordIndex, final String key, final String tipoTratamiento, final String estadoTratamiento, final String urgencia, final String paciente, final String fechaInclusion) {
		// HINT: this test signs in as an employer, lists all of the jobs, click on  
		// HINT+ one of them, and checks that the form has the expected data.

		// Inicia sesión como administrador
		super.signIn("oncologo1", "oncologo1");

		super.clickOnMenu("Treatments", "Edit Treatments");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();

		super.checkInputBoxHasValue("tipoTratamiento", tipoTratamiento);
		super.checkInputBoxHasValue("estadoTratamiento", estadoTratamiento);
		super.checkInputBoxHasValue("urgencia", urgencia);
		super.checkInputBoxHasValue("fechaInclusion", fechaInclusion);

		// Cierra la sesión
		super.signOut();
	}

	@Test
	public void test300Hacking() {

		final Collection<Tratamiento> tratamientos = this.repository.findTratamientos();

		super.signIn("paciente1", "paciente1");

		for (final Tratamiento tratamiento : tratamientos) {
			final String param = String.format("id=%d", tratamiento.getId());
			super.request("/oncologo/tratamiento/list", param);
			super.checkPanicExists();
		}

		super.signOut();
	}

}
