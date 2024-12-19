public class UninsuredPatient extends Patient implements InsuranceStatus {
    public UninsuredPatient(String firstName, String lastName, String tcNumber, String disease) {
        super(firstName, lastName, tcNumber, false, disease);
    }

    @Override
    public void checkInsuranceStatus() {
        System.out.println("Hasta SGK'lı olmadığı için muayene ücreti ödemeli.");
    }
}
