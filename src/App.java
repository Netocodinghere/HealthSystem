public class App {

    public static void main(String[] args) {
        GeneralPractitioner hp = new GeneralPractitioner(
            1,
            "Dr. Jane Doe",
            "Cardiology",
            "jane.doe@example.com",
            new String[]{"Monday 9-5", "Wednesday 9-5"},
            new String[]{"English", "Spanish"},
            new String[]{"Board Certified"},
            "Experienced cardiologist with 10 years in practice."
        );
        hp.displayDetails();
    }
}

// Define GeneralPractitioner as a separate top-level class
class GeneralPractitioner {
    private int id;
    public String name;
    public String specialty;
    public String contactInfo;
    public String[] availability;
    public String[] languagesSpoken;
    public String[] certifications;
    public String bio;

    //Setter For ID
    public  void setId(int id) {
        this.id = id;
    }

    //Getter For ID
    public int getId(){
        return this.id;
    }

    public GeneralPractitioner() { 
        System.out.println("GeneralPractitioner object created");  
    }

    public GeneralPractitioner(int id, String name, String specialty, String contactInfo, String[] availability, String[] languagesSpoken, String[] certifications, String bio) {
        setId(id);
        this.name = name;
        this.specialty = specialty;
        this.contactInfo = contactInfo;
        this.availability = availability;
        this.languagesSpoken = languagesSpoken;
        this.certifications = certifications;
        this.bio = bio;
    }

    
    

    public void displayDetails() {

        System.out.println("ID: " + getId());
        System.out.println("Name: " + name);
        System.out.println("Specialty: " + specialty);
        System.out.println("Contact Info: " + contactInfo);
        System.out.println("Availability: " + String.join(", ", availability)); 
        System.out.println("Languages Spoken: " + String.join(", ", languagesSpoken));
        System.out.println("Certifications: " + String.join(", ", certifications));
        System.out.println("Bio: " + bio);
    }


}