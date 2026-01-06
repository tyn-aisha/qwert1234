package qwert1234;

public class Vaccination extends Treatment {
    private String vaccineName;

    // Constructor
    public Vaccination(int treatmentId, Owner owner, Pet pet, Veterinarian veterinarian,
                       String status, String vaccineName) {
        super(treatmentId, owner, pet, veterinarian, status);
        this.vaccineName = vaccineName;
    }

    // Getter and Setter
    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        if (vaccineName != null && !vaccineName.trim().isEmpty()) {
            this.vaccineName = vaccineName;
        }
    }

    // Override methods
    @Override
    public void completeTreatment() {
        this.status = "Completed";
        System.out.println("Vaccination '" + vaccineName + "' completed for " + pet.getName() +
                " by Dr. " + veterinarian.getName());
    }

    @Override
    public String getTreatmentType() {
        return "Vaccination";
    }

    // Additional method
    public boolean isAnnualVaccine() {
        return vaccineName.toLowerCase().contains("annual") ||
                vaccineName.toLowerCase().contains("rabies");
    }

    @Override
    public String toString() {
        return super.toString() + " | Vaccine: " + vaccineName;
    }
}