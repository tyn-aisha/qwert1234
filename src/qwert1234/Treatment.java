package qwert1234;

public class Treatment {
    protected int treatmentId;
    protected Owner owner;
    protected Pet pet;
    protected Veterinarian veterinarian;
    protected String status;

    // Constructor
    public Treatment(int treatmentId, Owner owner, Pet pet, Veterinarian veterinarian, String status) {
        this.treatmentId = treatmentId;
        this.owner = owner;
        this.pet = pet;
        this.veterinarian = veterinarian;
        this.status = status;
    }

    // Getters
    public int getTreatmentId() {
        return treatmentId;
    }

    public Owner getOwner() {
        return owner;
    }

    public Pet getPet() {
        return pet;
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setTreatmentId(int treatmentId) {
        if (treatmentId > 0) {
            this.treatmentId = treatmentId;
        }
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public void setStatus(String status) {
        if (status != null && !status.trim().isEmpty()) {
            this.status = status;
        }
    }

    // Methods to be overridden
    public void completeTreatment() {
        this.status = "Completed";
        System.out.println("Treatment " + treatmentId + " completed for " + pet.getName());
    }

    public String getTreatmentType() {
        return "General Treatment";
    }

    public boolean isCompleted() {
        return status.equalsIgnoreCase("Completed");
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "treatmentId=" + treatmentId +
                ", owner='" + owner.getName() + '\'' +
                ", pet='" + pet.getName() + '\'' +
                ", veterinarian='" + veterinarian.getName() + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}