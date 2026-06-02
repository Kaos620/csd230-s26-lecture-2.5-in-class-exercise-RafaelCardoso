package csd230.s26.lab1.pojos;

import java.util.List;
import java.util.Scanner;

/**
 * Concrete POJO representing a digitally distributed video game.
 */
/**
 * DTO for {@link csd230.s26.lab1.entities.DigitalGameEntity}
 */
public class DigitalGame extends VideoGame {

    private double storageSizeGb;
    private String version;

    public DigitalGame() {
        super();
    }

    public DigitalGame(String productId, String title, String genre, String platform, double price, double storageSizeGb, String version) {
        super(productId, title, genre, platform, price);
        this.storageSizeGb = storageSizeGb;
        this.version = version;
    }

    public double getStorageSizeGb() {
        return storageSizeGb;
    }

    public void setStorageSizeGb(double storageSizeGb) {
        this.storageSizeGb = storageSizeGb;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input);

        System.out.print("Enter storage size in GB: ");
        while (!input.hasNextDouble()) {
            System.out.print("Invalid input. Enter a number for storage size: ");
            input.next();
        }
        this.storageSizeGb = input.nextDouble();
        input.nextLine();

        System.out.print("Enter digital version (e.g., Standard, Deluxe): ");
        this.version = input.nextLine();
    }

    @Override
    public void edit(Scanner input) {
        super.edit(input);

        System.out.print("Enter new storage size in GB (Current: " + this.storageSizeGb + "): ");
        String sizeInput = input.nextLine();
        if (!sizeInput.trim().isEmpty()) {
            this.storageSizeGb = Double.parseDouble(sizeInput);
        }

        System.out.print("Enter digital version of the game: (Current: " + this.version + "): ");
        String version = input.nextLine();
        if (!version.trim().isEmpty()) {
            this.version = version;
        }
    }

    @Override
    public void sellItem() {
        // Digital items have infinite stock, so selling one always succeeds
        System.out.println("Processing digital license generation...");
        System.out.println("Successfully sold digital copy of: " + getTitle());
        System.out.println("Version of game sold: " + this.version);
    }
}