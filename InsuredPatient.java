public class InsuredPatient extends Patient implements InsuranceStatus {
    public InsuredPatient(String firstName, String lastName, String tcNumber, String disease) {
        super(firstName, lastName, tcNumber, true, disease);
    }

    @Override
    public void checkInsuranceStatus() {
        System.out.println("Hasta SGK'lı.");
    }
}
