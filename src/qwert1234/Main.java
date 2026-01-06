package qwert1234;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    private static ArrayList<Owner> owners = new ArrayList<>();
    private static ArrayList<Veterinarian> veterinarians = new ArrayList<>();
    private static ArrayList<Treatment> treatments = new ArrayList<>();

    private static Scanner s = new Scanner(System.in);

    private static void displayBase() {
        System.out.println("\n=====================================");
        System.out.println("VETERINARIAN CLINIC MANAGEMENT SYSTEM");
        System.out.println("=====================================");
        System.out.println("1. Add Owner");
        System.out.println("2. View Owners");
        System.out.println("3. Add Pets");
        System.out.println("4. View Pets");
        System.out.println("5. Add Veterinarians");
        System.out.println("6. View Veterinarians");
        System.out.println("7. Add Treatments");
        System.out.println("8. View Treatments");
        System.out.println("9. Polymorphism demo");
        System.out.println("0. Exit");
        System.out.println("=====================================");
        System.out.print("Enter your choice: >>> ");
    }

    private static void createOwner() {
        System.out.println("\n--- ADD OWNER ---");
        System.out.print("Enter Owner's name: >>> ");
        String name = s.nextLine();
        System.out.print("Enter Owner's phone number: >>> ");
        String phone = s.nextLine();
        Owner owner = new Owner(owners.size() + 1, name, phone);
        owners.add(owner);
        System.out.println("New Owner created successfully!");
    }

    private static void createPets() {
        System.out.println("\n--- ADD PET ---");
        System.out.print("Enter Pet's name: >>> ");
        String name = s.nextLine();
        System.out.print("Enter Pet's species: >>> ");
        String species = s.nextLine();
        System.out.print("Enter Pet's age: >>> ");
        int age = s.nextInt();
        s.nextLine();
        System.out.print("Enter Pet's owner name: >>> ");
        String ownerName = s.nextLine();

        Owner owner = null;
        for (Owner o : owners) {
            if (o.getName().equalsIgnoreCase(ownerName)) {
                owner = o;
                break;
            }
        }

        if (owner == null) {
            System.out.println("Owner not found!");
            return;
        }

        Pet pet = new Pet(name, species, age, owner);
        System.out.println("New Pet with ID " + pet.getPetId() + " created successfully!");
    }

    private static void createVeterinarians() {
        System.out.println("\n--- ADD VETERINARIAN ---");
        System.out.print("Enter Veterinarian's name: >>> ");
        String name = s.nextLine();
        System.out.print("Enter Veterinarian's specialization: >>> ");
        String specialization = s.nextLine();
        System.out.print("Enter Veterinarian's experience (years): >>> ");
        int experience = s.nextInt();
        s.nextLine();
        System.out.print("Enter Veterinarian's phone number: >>> ");
        String phone = s.nextLine();

        Veterinarian veterinarian = new Veterinarian(veterinarians.size() + 1, name,
                specialization, experience, phone);
        veterinarians.add(veterinarian);
        System.out.println("New Veterinarian created successfully!");
    }

    private static void createTreatments() {
        System.out.println("\n--- ADD TREATMENT ---");
        System.out.print("Enter Treatment's owner's name: >>> ");
        String ownerName = s.nextLine();
        System.out.print("Enter Treatment's veterinarian name: >>> ");
        String veterinarianName = s.nextLine();
        System.out.print("Enter Treatment's pet's name: >>> ");
        String petName = s.nextLine();
        System.out.print("Enter Treatment's status: >>> ");
        String status = s.nextLine();
        System.out.print("Enter Treatment's type (Treatment/Vaccination/Surgery): >>> ");
        String type = s.nextLine();

        Owner owner = null;
        Veterinarian veterinarian = null;
        Pet pet = null;

        // Find owner
        for (Owner o : owners) {
            if (o.getName().equalsIgnoreCase(ownerName)) {
                owner = o;
                break;
            }
        }
        if (owner == null) {
            System.out.println("Owner not found!");
            return;
        }

        // Find veterinarian
        for (Veterinarian v : veterinarians) {
            if (v.getName().equalsIgnoreCase(veterinarianName)) {
                veterinarian = v;
                break;
            }
        }
        if (veterinarian == null) {
            System.out.println("Veterinarian not found!");
            return;
        }

        // Find pet
        for (Pet p : owner.getPets()) {
            if (p.getName().equalsIgnoreCase(petName)) {
                pet = p;
                break;
            }
        }
        if (pet == null) {
            System.out.println("Pet not found!");
            return;
        }

        // Create appropriate treatment type
        Treatment treatment;
        if (type.equalsIgnoreCase("Vaccination")) {
            System.out.print("Enter Vaccine name: >>> ");
            String vaccineName = s.nextLine();
            treatment = new Vaccination(treatments.size() + 1, owner, pet, veterinarian,
                    status, vaccineName);
        } else if (type.equalsIgnoreCase("Surgery")) {
            System.out.print("Enter Surgery duration in hours: >>> ");
            int duration = s.nextInt();
            s.nextLine();
            treatment = new Surgery(treatments.size() + 1, owner, pet, veterinarian,
                    status, duration);
        } else {
            treatment = new Treatment(treatments.size() + 1, owner, pet, veterinarian, status);
        }

        treatments.add(treatment);
        System.out.println("New Treatment created successfully!");
    }

    private static void viewTreatments() {
        System.out.println("\n========================================");
        System.out.println("          ALL TREATMENTS");
        System.out.println("========================================");

        if (treatments.isEmpty()) {
            System.out.println("No treatments found.");
            return;
        }

        System.out.println("Total treatments: " + treatments.size());
        System.out.println();

        for (int i = 0; i < treatments.size(); i++) {
            Treatment t = treatments.get(i);
            System.out.println((i + 1) + ". " + t);

            // Use instanceof to show child-specific info
            if (t instanceof Vaccination) {
                Vaccination vaccination = (Vaccination) t;
                System.out.println("   Vaccine: " + vaccination.getVaccineName());
                if (vaccination.isAnnualVaccine()) {
                    System.out.println("   [ANNUAL VACCINE]");
                }
            } else if (t instanceof Surgery) {
                Surgery surgery = (Surgery) t;
                System.out.println("   Difficulty: " + surgery.getDifficulty());
                if (surgery.isMajorSurgery()) {
                    System.out.println("   [MAJOR SURGERY]");
                }
            }
            System.out.println();
        }
    }

    public static void demonstratePolymorphism() {
        System.out.println("\n========================================");
        System.out.println("     POLYMORPHISM DEMONSTRATION");
        System.out.println("========================================");
        System.out.println("Calling completeTreatment() on all treatments:\n");

        for (Treatment t : treatments) {
            t.completeTreatment();  // Polymorphism: Different behavior for each type!
        }

        System.out.println("\n[NOTICE] Same method name, different output!");
        System.out.println("         This is POLYMORPHISM in action!");
    }

    public static void main(String[] args) {
        // Add initial test data
        Owner owner1 = new Owner(1, "Dmitriy Rochshupkin", "03-03-03");
        Owner owner2 = new Owner(2, "Manas Agatayev", "10-10-10");
        Owner owner3 = new Owner(3, "Aidos Lazzatbekov", "16-16-16");

        owners.add(owner1);
        owners.add(owner2);
        owners.add(owner3);

        Pet dog1 = new Pet("Mishka", "dog", 2, owner1);
        Pet cat1 = new Pet("Karamel", "cat", 5, owner2);
        Pet parrot1 = new Pet("Sanyok", "parrot", 2, owner3);

        Veterinarian veterinarian1 = new Veterinarian(1, "Smith Johnson", "dog", 10, "00-00-01");
        Veterinarian veterinarian2 = new Veterinarian(2, "Lionel Messi", "dog", 3, "00-00-02");
        Veterinarian veterinarian3 = new Veterinarian(3, "Timur Iskakov", "cat", 16, "00-00-03");
        Veterinarian veterinarian4 = new Veterinarian(4, "Alexander Durov", "parrot", 2, "00-00-04");
        Veterinarian veterinarian5 = new Veterinarian(5, "Anna Nikolayeva", "rabbit", 1, "00-00-05");

        veterinarians.add(veterinarian1);
        veterinarians.add(veterinarian2);
        veterinarians.add(veterinarian3);
        veterinarians.add(veterinarian4);
        veterinarians.add(veterinarian5);

        Treatment treatment1 = new Treatment(1, owner1, dog1, veterinarian1, "Started");
        Treatment treatment2 = new Vaccination(2, owner2, cat1, veterinarian2, "Completed", "superVaccine");
        Treatment treatment3 = new Surgery(3, owner3, parrot1, veterinarian1, "Started", 3);

        treatments.add(treatment1);
        treatments.add(treatment2);
        treatments.add(treatment3);

        // Menu loop
        boolean running = true;
        while (running) {
            displayBase();
            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    createOwner();
                    break;
                case 2:
                    for (Owner o : owners) {
                        System.out.println(o.toString());
                    }
                    break;
                case 3:
                    createPets();
                    break;
                case 4:
                    for (Owner o : owners) {
                        for (Pet p : o.getPets()) {
                            System.out.println(p.toString());
                        }
                    }
                    break;
                case 5:
                    createVeterinarians();
                    break;
                case 6:
                    for (Veterinarian v : veterinarians) {
                        System.out.println(v.toString());
                    }
                    break;
                case 7:
                    createTreatments();
                    break;
                case 8:
                    viewTreatments();
                    break;
                case 9:
                    demonstratePolymorphism();
                    break;
                case 0:
                    System.out.println("\nIt was trial mode, to use this program again");
                    System.out.println("You have to give 100 points to Dmitriy Rochshupkin from IT-2505");
                    System.out.println("Thank you for using this program!");
                    running = false;
                    break;
                default:
                    System.out.println("Wrong choice!");
                    break;
            }

            if (running) {
                System.out.print("\nPress Enter to continue...");
                s.nextLine();
            }
        }
        s.close();
    }
}