
package acme.testing.administrator.paciente;

import org.junit.jupiter.params.ParameterizedTest;

import acme.testing.TestHarness;

public class AdministratorPacienteListTest extends TestHarness {

	@ParameterizedTest
	//	@CsvFileSource(resources = "/administrator/paciente/list-positive.csv", encoding = "utf-8", numLinesToSkip = 1)

	public void test100Positive(final int recordIndex, final String nuhsa, final String name, final String surname) {
		// HINT: this test signs in as an employer, lists all of the jobs, 
		// HINT+ and then checks that the listing shows the expected data.

		super.signIn("administrator", "administrator");

		super.clickOnMenu("Patients", "Patient List");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.checkColumnHasValue(recordIndex, 0, nuhsa);
		super.checkColumnHasValue(recordIndex, 1, name);
		super.checkColumnHasValue(recordIndex, 2, surname);

		super.signOut();
	}

	//	@Test
	//	public void test200Negative() {
	//		// HINT: there aren't any negative tests for this feature because it's a listing
	//		// HINT+ that doesn't involve entering any data in any forms.
	//	}
	//
	//	@Test
	//	public void test300Hacking() {
	//		// HINT: this test tries to list all of the jobs using 
	//		// HINT+ inappropriate roles.
	//
	//		super.checkLinkExists("Sign in");
	//		super.request("/employer/job/list-all");
	//		super.checkPanicExists();
	//
	//		super.signIn("administrator", "administrator");
	//		super.request("/employer/job/list-all");
	//		super.checkPanicExists();
	//		super.signOut();
	//
	//		super.signIn("worker1", "worker1");
	//		super.request("/employer/job/list-all");
	//		super.checkPanicExists();
	//		super.signOut();
	//	}

}
