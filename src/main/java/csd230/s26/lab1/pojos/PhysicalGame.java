package csd230.s26.lab1.pojos;

import java.util.List;
import java.util.Scanner;

/**
 * Concrete POJO representing a physical copy of a video game.
 */
/**
 * DTO for {@link csd230.s26.lab1.entities.PhysicalGameEntity}
 */
public class PhysicalGame extends VideoGame {

    private String mediaType;
    private int numberOfDiscs;
    private int copies;

    public PhysicalGame() {
        super();
    }

    public PhysicalGame(String productId, String title, String genre, String platform, double price, String mediaType, int numberOfDiscs, int copies) {
        super(productId, title, genre, platform, price);
        this.mediaType = mediaType;
        this.numberOfDiscs = numberOfDiscs;
        this.copies = copies;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public int getNumberOfDiscs() {
        return numberOfDiscs;
    }

    public void setNumberOfDiscs(int numberOfDiscs) {
        this.numberOfDiscs = numberOfDiscs;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input);

        System.out.print("Enter media type (e.g., Blu-ray, Cartridge): ");
        this.mediaType = input.nextLine();

        System.out.print("How many discs does it include?: (0+)");
        if (this.numberOfDiscs < 0 || this.numberOfDiscs > 10) {
            System.out.print("Cannot have less than 0 or more than 10 discs");
            initialize(input);
        }
        this.numberOfDiscs = input.nextInt();
        input.nextLine();

        System.out.print("How many copies do you want?: (0+)");
        if (this.copies < 0) {
            System.out.print("Cannot have less than 0 copies");
            initialize(input);
        }
        this.copies = input.nextInt();
    }

    @Override
    public void edit(Scanner input) {
        super.edit(input);

        System.out.print("Enter new media type (Current: " + this.mediaType + "): ");
        this.mediaType = getInput(input, "Blu-ray");

        System.out.print("Update number of discs? (Current: " + this.numberOfDiscs + ")");
        this.numberOfDiscs = getInput(input, 1);
    }

    @Override
    public void sellItem() {
        if (this.getCopies() > 0) {
            this.setCopies(getCopies() - 1);
            System.out.println("Dispensing physical media package (" + this.mediaType + ") for: " + getTitle());
            System.out.println("Remaining physical media stock: " + getCopies());
        } else {
            System.out.println("Error: Cannot sell physical copy. Out of stock!");
        }
    }
}