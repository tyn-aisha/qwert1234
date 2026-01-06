package qwert1234;

public class Veterinarian {
    private int vetId;
    private String name;
    private String specialization;
    private int experience;
    private String phone;

    // Constructor
    public Veterinarian(int vetId, String name, String specialization, int experience, String phone) {
        this.vetId = vetId;
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
        this.phone = phone;
    }

    // Getters
    public int getVetId() {
        return vetId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperience() {
        return experience;
    }

    public String getPhone() {
        return phone;
    }

    // Setters
    public void setVetId(int vetId) {
        if (vetId > 0) {
            this.vetId = vetId;
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void setSpecialization(String specialization) {
        if (specialization != null && !specialization.trim().isEmpty()) {
            this.specialization = specialization;
        }
    }

    public void setExperience(int experience) {
        if (experience >= 0 && experience <= 50) {
            this.experience = experience;
        }
    }

    public void setPhone(String phone) {
        if (phone != null && !phone.trim().isEmpty()) {
            this.phone = phone;
        }
    }

    // Methods
    public boolean isExperienced() {
        return experience >= 5;
    }

    public boolean canTreat(String species) {
        return specialization.equalsIgnoreCase(species);
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "vetId=" + vetId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experience=" + experience +
                ", phone='" + phone + '\'' +
                ", experienced=" + (isExperienced() ? "Yes" : "No") +
                '}';
    }
}