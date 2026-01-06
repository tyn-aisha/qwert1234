package qwert1234;

public class Surgery extends Treatment {
    private int durationHours;

    // Constructor
    public Surgery(int treatmentId, Owner owner, Pet pet, Veterinarian veterinarian,
                   String status, int durationHours) {
        super(treatmentId, owner, pet, veterinarian, status);
        this.durationHours = durationHours;
    }

    // Getter and Setter
    public int getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(int durationHours) {
        if (durationHours > 0 && durationHours <= 12) {
            this.durationHours = durationHours;
        }
    }

    // Additional method for difficulty
    public String getDifficulty() {
        if (durationHours <= 2) {
            return "Simple";
        } else if (durationHours <= 5) {
            return "Moderate";
        } else {
            return "Complex";
        }
    }

    // Override methods
    @Override
    public void completeTreatment() {
        this.status = "Completed";
        System.out.println("Surgery (" + getDifficulty() + ") completed for " + pet.getName() +
                " by Dr. " + veterinarian.getName() +
                " - Duration: " + durationHours + " hours");
    }

    @Override
    public String getTreatmentType() {
        return "Surgery";
    }

    // Additional method
    public boolean isMajorSurgery() {
        return durationHours > 4;
    }

    @Override
    public String toString() {
        return super.toString() + " | Duration: " + durationHours +
                " hours | Difficulty: " + getDifficulty();
    }
}