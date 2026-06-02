package csd230.s26.lab1.pojos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Abstract POJO representing a generic Video Game.
 * Extends the core Product POJO.
 */
/**
 * DTO for {@link csd230.s26.lab1.entities.VideoGameEntity}
 */
public abstract class VideoGame extends Product {

    private String title;
    private String genre;
    private String platform;
    private double price = 0.0;

    public VideoGame() {
        super();
    }

    public VideoGame(String productId, String title, String genre, String platform, double price) {
        super(productId);
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void initialize(Scanner input) {
        System.out.print("Enter video game title: ");
        this.title = getInput(input, "PacMan");

        System.out.print("Enter game genre: ");
        this.genre = getInput(input, "Arcade");

        System.out.print("Enter compatible platforms (separated by commas, e.g., PC, PS5, Switch): ");
        this.platform = getInput(input, "PC");
    }

    @Override
    public void edit(Scanner input) {

        System.out.print("Enter new title (Current: " + this.title + ") [Or press Enter to skip]: ");
        this.title = getInput(input, title);

        System.out.print("Enter new genre (Current: " + this.genre + ") [Or press Enter to skip]: ");
        this.genre = getInput(input, genre);

        System.out.print("Enter new platform (Current: " + this.platform + "): ");
        this.platform = getInput(input, platform);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VideoGame videoGame = (VideoGame) o;
        return Objects.equals(title, videoGame.title) && Objects.equals(genre, videoGame.genre) && Objects.equals(platform, videoGame.platform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, platform);
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", platforms=" + platform +
                '}';
    }


}