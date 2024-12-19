import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Registration registration = new Registration();
        boolean exit = false;
        boolean loggedIn = false;

        while (!exit) {
            System.out.println("\n--- Hastane Kayıt Sistemi(VEZNE) ---");

            if (!loggedIn) {
                // Sisteme giriş yapılmamışsa sadece giriş seçeneği göster
                System.out.println("1. Sisteme Giriş");
                System.out.println("6. Sistemden Çıkış");
                System.out.print("Seçenekleri gör: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        // Giriş kısmı
                        System.out.println("Lütfen giriş yapmak için admin şifresini girin.");
                        System.out.print("Şifre: ");
                        String password = scanner.nextLine();
                        if (password.equals("gamze123")) {
                            loggedIn = true;  // Giriş başarılı
                            System.out.println("Giriş başarılı.");
                        } else {
                            System.out.println("Yanlış Şifre.");
                        }
                        break;

                    case 6:
                        System.out.println("Sistemden çıkılıyor...");
                        exit = true;
                        break;

                    default:
                        System.out.println("Yanlış seçim, lütfen tekrar deneyin.");
                        break;
                }
            } else {
                // Giriş yapıldıysa seçenekler aktif
                System.out.println("2. Hasta Girişi");
                System.out.println("3. Sistemdeki Hastaları Görüntüle");
                System.out.println("4. Hasta Yatışı Gir");
                System.out.println("5. İşlemi sonlandır");
                System.out.println("6. Sistemden çıkış");
                System.out.print("Seçenekleri seç: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 2:
                        // Hasta ekleme işlemi
                        System.out.println("Hasta bilgilerini gir:");

                        System.out.print("Ad: ");
                        String firstName = scanner.nextLine();

                        System.out.print("Soyad: ");
                        String lastName = scanner.nextLine();

                        System.out.print("TC Kimlik Numarası: ");
                        String tcNumber = scanner.nextLine();

                        System.out.print("Tanı - Hastalık (grip, yüksek ateş(havale), kalp krizi): ");
                        String disease = scanner.nextLine();

                        System.out.print("Hasta SGK'lı mı? (evet/hayır): ");
                        String insuranceStatus = scanner.nextLine();

                        Patient patient;
                        if (insuranceStatus.equalsIgnoreCase("evet")) {
                            patient = new InsuredPatient(firstName, lastName, tcNumber, disease);
                        } else {
                            patient = new UninsuredPatient(firstName, lastName, tcNumber, disease);
                        }

                        registration.addPatient(patient);
                        System.out.println("Hasta başarıyla sisteme eklendi.");
                        break;

                    case 3:
                        // Hastaları görüntüle
                        registration.displayAllPatients();
                        break;

                    case 4:
                        // Hasta yatışı yap
                        System.out.print("Hasta yatışını vermek için tc kimlik numarası gir: ");
                        String admitTc = scanner.nextLine();
                        registration.admitPatientByTc(admitTc);
                        break;

                    case 5:
                        // Çıkış işlemi
                        System.out.println("İşlem sonlandırılıyor...");
                        loggedIn = false;  // Kullanıcı çıkış yapar
                        break;

                    case 6:
                        System.out.println("Sistemden çıkış yapılıyor...");
                        exit = true;
                        break;

                    default:
                        System.out.println("Yanlış seçim, lütfen tekrar deneyin.");
                        break;
                }
            }
        }

        scanner.close();
    }
}
