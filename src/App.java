import java.util.ArrayList;

public class App {
    // Part 5 – Collection of appointments

    // ArrayList to store appointments
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    // Method to create a new appointment and add to the list
    public static boolean createAppointment(String patientName, String patientMobile, String preferredTimeSlot, HealthProfessional selectedDoctor) {
        if (patientName == null || patientName.isEmpty() ||
            patientMobile == null || patientMobile.isEmpty() ||
            preferredTimeSlot == null || preferredTimeSlot.isEmpty() ||
            selectedDoctor == null) {
            System.out.println("Error: All appointment details must be provided.");
            return false;
        }
        Appointment newApp = new Appointment(patientName, patientMobile, preferredTimeSlot, selectedDoctor);
        appointments.add(newApp);
        System.out.println("Appointment created for " + patientName + ".");
        return true;
    }

    // Method to print all existing appointments
    public static void printExistingAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No existing appointments.");
        } else {
            for (Appointment app : appointments) {
                app.printDetails();
                System.out.println("------------------------------");
            }
        }
    }

    // Method to cancel a booking by patient mobile
    public static void cancelBooking(String patientMobile) {
        boolean found = false;
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getPatientMobile().equals(patientMobile)) {
                System.out.println("Cancelling appointment for " + appointments.get(i).getPatientName());
                appointments.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No appointment found for mobile: " + patientMobile);
        }
    }

    public static void main(String[] args) {
        // Part 3 – Using classes and objects

        GeneralPractitioner gp1 = new GeneralPractitioner(
            1,
            "Dr. Jane Doe",
            "Cardiology",
            "jane.doe@example.com",
            new String[]{"Monday 9-5", "Wednesday 9-5"},
            new String[]{"English", "Spanish"},
            new String[]{"Board Certified"},
            "Experienced cardiologist with 10 years in practice.",
            true
        );

        GeneralPractitioner gp2 = new GeneralPractitioner(
            2,
            "Dr. Alice Brown",
            "Family Medicine",
            "alice.brown@example.com",
            new String[]{"Tuesday 9-5", "Thursday 9-5"},
            new String[]{"English"},
            new String[]{"Board Certified"},
            "Family doctor with a focus on preventive care.",
            true
        );

        GeneralPractitioner gp3 = new GeneralPractitioner(
            3,
            "Dr. Mark Lee",
            "Internal Medicine",
            "mark.lee@example.com",
            new String[]{"Friday 9-5"},
            new String[]{"English", "Mandarin"},
            new String[]{"Board Certified"},
            "Internal medicine specialist.",
            false
        );

        Specialist sp1 = new Specialist(
            4,
            "Dr. John Smith",
            "Neurology",
            "john.smith@example.com",
            new String[]{"Tuesday 9-5"},
            new String[]{"English"},
            new String[]{"Board Certified"},
            "Neurologist with 5 years experience.",
            "Brain Surgery"
        );

        Specialist sp2 = new Specialist(
            5,
            "Dr. Emily White",
            "Dermatology",
            "emily.white@example.com",
            new String[]{"Monday 10-6"},
            new String[]{"English", "French"},
            new String[]{"Board Certified"},
            "Dermatologist specializing in skin cancer.",
            "Skin Cancer"
        );

        gp1.printDetails();
        gp2.printDetails();
        gp3.printDetails();
        sp1.printDetails();
        sp2.printDetails();
        System.out.println("------------------------------");

        // Part 5 – Collection of appointments
        System.out.println("// Part 5 – Collection of appointments");

        // Make 2 appointments with general practitioners
        createAppointment("John Doe", "1234567890", "Monday 10am", gp1);
        createAppointment("Jane Smith", "0987654321", "Tuesday 2pm", gp2);

        // Make 2 appointments with specialists
        createAppointment("Alice Green", "5551234567", "Wednesday 1pm", sp1);
        createAppointment("Bob White", "5559876543", "Thursday 3pm", sp2);

        System.out.println("------------------------------");
        System.out.println("Existing appointments:");
        printExistingAppointments();

        // Cancel one appointment
        cancelBooking("0987654321");

        System.out.println("------------------------------");
        System.out.println("Appointments after cancellation:");
        printExistingAppointments();

        System.out.println("------------------------------");
    }
}

// Base class
class HealthProfessional {
    private int id;
    public String name;
    public String specialty;
    public String contactInfo;
    public String[] availability;
    public String[] languagesSpoken;
    public String[] certifications;
    public String bio;

    public HealthProfessional() {
        System.out.println("HealthProfessional object created");
    }

    public HealthProfessional(int id, String name, String specialty, String contactInfo, String[] availability, String[] languagesSpoken, String[] certifications, String bio) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.contactInfo = contactInfo;
        this.availability = availability;
        this.languagesSpoken = languagesSpoken;
        this.certifications = certifications;
        this.bio = bio;
    }

    public int getId() {
        return this.id;
    }
}

// Child class 1
class GeneralPractitioner extends HealthProfessional {
    private boolean isFamilyDoctor;

    public GeneralPractitioner() {
        super();
        this.isFamilyDoctor = false;
    }

    public GeneralPractitioner(int id, String name, String specialty, String contactInfo, String[] availability, String[] languagesSpoken, String[] certifications, String bio, boolean isFamilyDoctor) {
        super(id, name, specialty, contactInfo, availability, languagesSpoken, certifications, bio);
        this.isFamilyDoctor = isFamilyDoctor;
    }

    public void printDetails() {
        System.out.println("The health professional details are:");
        System.out.println("Type: General Practitioner");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + name);
        System.out.println("Specialty: " + specialty);
        System.out.println("Contact Info: " + contactInfo);
        System.out.println("Availability: " + String.join(", ", availability));
        System.out.println("Languages Spoken: " + String.join(", ", languagesSpoken));
        System.out.println("Certifications: " + String.join(", ", certifications));
        System.out.println("Bio: " + bio);
        System.out.println("Is Family Doctor: " + isFamilyDoctor);
    }
}

// Child class 2
class Specialist extends HealthProfessional {
    private String areaOfExpertise;

    public Specialist() {
        super();
        this.areaOfExpertise = "";
    }

    public Specialist(int id, String name, String specialty, String contactInfo, String[] availability, String[] languagesSpoken, String[] certifications, String bio, String areaOfExpertise) {
        super(id, name, specialty, contactInfo, availability, languagesSpoken, certifications, bio);
        this.areaOfExpertise = areaOfExpertise;
    }

    public void printDetails() {
        System.out.println("The health professional details are:");
        System.out.println("Type: Specialist");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + name);
        System.out.println("Specialty: " + specialty);
        System.out.println("Contact Info: " + contactInfo);
        System.out.println("Availability: " + String.join(", ", availability));
        System.out.println("Languages Spoken: " + String.join(", ", languagesSpoken));
        System.out.println("Certifications: " + String.join(", ", certifications));
        System.out.println("Bio: " + bio);
        System.out.println("Area of Expertise: " + areaOfExpertise);
    }
}

class Appointment {
    private String patientName;
    private String patientMobile;
    private String preferredTimeSlot;
    private HealthProfessional selectedDoctor;

    // Default constructor
    public Appointment() {
        this.patientName = "";
        this.patientMobile = "";
        this.preferredTimeSlot = "";
        this.selectedDoctor = null;
    }

    // Constructor with all instance variables
    public Appointment(String patientName, String patientMobile, String preferredTimeSlot, HealthProfessional selectedDoctor) {
        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.preferredTimeSlot = preferredTimeSlot;
        this.selectedDoctor = selectedDoctor;
    }

    // Method to print all instance variables
    public void printDetails() {
        System.out.println("Appointment Details:");
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Mobile: " + patientMobile);
        System.out.println("Preferred Time Slot: " + preferredTimeSlot);
        if (selectedDoctor != null) {
            System.out.println("Doctor Details:");
            if (selectedDoctor instanceof GeneralPractitioner) {
                ((GeneralPractitioner)selectedDoctor).printDetails();
            } else if (selectedDoctor instanceof Specialist) {
                ((Specialist)selectedDoctor).printDetails();
            } else {
                System.out.println("Doctor: " + selectedDoctor.name);
            }
        } else {
            System.out.println("No doctor selected.");
        }
    }

    public String getPatientMobile() {
        return patientMobile;
    }
    public String getPatientName() {
        return patientName;
    }
}