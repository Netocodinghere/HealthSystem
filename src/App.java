public class App {
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
        System.out.println("------------------------------");
        gp2.printDetails();
        System.out.println("------------------------------");
        gp3.printDetails();
        System.out.println("------------------------------");
        sp1.printDetails();
        System.out.println("------------------------------");
        sp2.printDetails();
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