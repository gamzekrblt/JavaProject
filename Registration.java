import java.util.List;
import java.util.ArrayList;

public class Registration {
    private List<Patient> patients;

    public Registration() {
        patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
        } else {
            for (Patient patient : patients) {
                patient.displayInfo();
                if (patient instanceof InsuranceStatus) {
                    ((InsuranceStatus) patient).checkInsuranceStatus();
                }
                System.out.println();
            }
        }
    }

    public Patient getPatientByTc(String tcNumber) {
        for (Patient patient : patients) {
            if (patient.getTcNumber().equals(tcNumber)) {
                return patient;
            }
        }
        return null; // TC numarası bulunamazsa null döner.
    }

    public void admitPatientByTc(String tcNumber) {
        Patient patient = getPatientByTc(tcNumber);
        if (patient != null) {
            patient.admitPatient();
            System.out.println("Hasta başarıyla eklendi.");
        } else {
            System.out.println("Patient with TC number " + tcNumber + " not found.");
        }
    }
}
