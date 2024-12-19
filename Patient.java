public class Patient {
    private String firstName;
    private String lastName;
    private String tcNumber;
    private boolean isInsured;
    private String disease;
    private String room;
    private boolean isAdmitted;

    public Patient(String firstName, String lastName, String tcNumber, boolean isInsured, String disease) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tcNumber = tcNumber;
        this.isInsured = isInsured;
        this.disease = disease;
        this.room = determineRoom(disease);
        this.isAdmitted = false; // Başlangıçta hasta yatış yapmamış.
    }

    public String determineRoom(String disease) {
        switch (disease.toLowerCase()) {
            case "grip":
                return "Yeşil Alan";
            case "yüksek ateş(havale)":
                return "Sarı Alan";
            case "kalp krizi":
                return "Kırmızı Alan";
            default:
                return "Genel Alan";
        }
    }

    public void displayInfo() {
        System.out.println("Ad: " + firstName + " " + lastName);
        System.out.println("Soy Ad: " + tcNumber);
        System.out.println("Sigorta Durumu: " + (isInsured ? "SGK" : "Sigortalı Değil"));
        System.out.println("Tanı: " + disease);
        System.out.println("Alan Türü: " + room);
        System.out.println("Hasta Yatış: " + (isAdmitted ? "Evet" : "Hayır"));
    }

    public void admitPatient() {
        this.isAdmitted = true;
    }

    public String getTcNumber() {
        return tcNumber;
    }
}
