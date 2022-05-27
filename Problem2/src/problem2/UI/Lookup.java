/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2.UI;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import problem2.dao.BookOnTapeDAO;
import problem2.dao.BookOnTapeDAOImpl;
import problem2.dao.FurnitureDAO;
import problem2.dao.FurnitureDAOImpl;
import problem2.dao.ThingDAO;
import problem2.dao.ThingDAOImpl;
import problem2.dao.VideoDAO;
import problem2.dao.VideoDAOImpl;
import problem2.exceptions.EmptyInputException;
import problem2.exceptions.WrongInputTypeException;
import problem2.models.BookOnTape;
import problem2.models.Furniture;
import problem2.models.Thing;
import problem2.models.Video;

/**
 *
 * @author LENOVO
 */
public class Lookup {
    private FurnitureDAO furnitureDAO;
    private VideoDAO videoDAO;
    private BookOnTapeDAO bookOnTapeDAO;
    private ThingDAO thingDAO;

    public Lookup(FurnitureDAO furnitureDAO, VideoDAO videoDAO, BookOnTapeDAO bookOnTapeDAO, ThingDAO thingDAO) {
        this.furnitureDAO = furnitureDAO;
        this.videoDAO = videoDAO;
        this.bookOnTapeDAO = bookOnTapeDAO;
        this.thingDAO = thingDAO;
    }

    
    public void execute() {    
        while (true) {
            System.out.println("Select your option: ");
            System.out.println("1. Add thing");
            System.out.println("2. Show all furniture");
            System.out.println("3. Find item by serial number");
            System.out.println("4. Exit");
            System.out.println("Your option: ");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("What kind of item do you want to add? Choose one:");
                    System.out.println("1. Furniture");
                    System.out.println("2. Book On Tape");
                    System.out.println("3. Video");
                    int optionToAdd = sc.nextInt();
                    switch (optionToAdd) {
                        case 1:
                            try {
                            System.out.println("Please input information of furniture: ");
                            System.out.println("Serial Number: ");
                            String serialNumber = sc.next();
                            System.out.println("Name: ");
                            sc.nextLine();
                            String name = sc.nextLine();
                            System.out.println("Price: ");
                            float price = sc.nextFloat();
                            System.out.println("Category: ");
                            String category = sc.next();
                            System.out.println("Color: ");
                            String color = sc.next();
                            sc.nextLine();
                            System.out.println("Height: ");
                            float height = sc.nextFloat();
                            System.out.println("Width: ");
                            float width = sc.nextFloat();

                            if (serialNumber.isEmpty() || name.isEmpty() || category.isEmpty()
                                    || color.isEmpty()) {
                                throw new EmptyInputException();
                            }

                            Furniture furnitureToAdd = new Furniture(serialNumber, name, price,
                                    category, color, height, width);
                            
                            boolean addResult = furnitureDAO.addFurniture(furnitureToAdd);
                            if (addResult) {
                                System.out.println("You have successfully add furniture: " + furnitureToAdd.getDescription());
                            }
                        } catch (InputMismatchException exception) {
                            System.out.println("Please Type In Right Input Type");
                        } catch (EmptyInputException ex) {
                            System.out.println(ex);
                        }
                        break;

                        case 2:
                            try {
                            System.out.println("Please input information of bool on tape: ");
                            System.out.println("Serial Number: ");
                            String serialNumber = sc.next();
                            System.out.println("Name: ");
                            sc.nextLine();
                            String name = sc.nextLine();
                            System.out.println("Price: ");
                            float price = sc.nextFloat();
                            System.out.println("Quality: ");
                            String bookCatgory = sc.next();
                            sc.nextLine();
                            System.out.println("Duration: ");
                            String duration = sc.nextLine();
                            if (serialNumber.isEmpty() || name.isEmpty() || bookCatgory.isEmpty()
                                    || duration.isEmpty()) {
                                throw new EmptyInputException();
                            }
                            BookOnTape bookOnTapeToAdd = new BookOnTape(serialNumber, name, price,
                                    bookCatgory, duration);
                            
                            boolean addResult = bookOnTapeDAO.addBookOnTape(bookOnTapeToAdd);
                            if (addResult) {
                                System.out.println("You have successfully add book on tape: " + bookOnTapeToAdd.getDescription());
                            }
                        } catch (InputMismatchException exception) {
                            System.out.println("Please Type In Right Input Type");
                        } catch (EmptyInputException ex) {
                            System.out.println(ex);
                        }
                        break;
                        case 3:
                            try {
                            System.out.println("Please input information of video: ");
                            System.out.println("Serial Number: ");
                            String serialNumber = sc.next();
                            System.out.println("Name: ");
                            sc.nextLine();
                            String name = sc.nextLine();
                            System.out.println("Price: ");
                            float price = sc.nextFloat();
                            System.out.println("Quality: ");
                            String quality = sc.next();
                            sc.nextLine();
                            System.out.println("Duration: ");
                            String duration = sc.nextLine();
                            if (serialNumber.isEmpty() || name.isEmpty() || quality.isEmpty()
                                    || duration.isEmpty()) {
                                throw new EmptyInputException();
                            }
                            Video videoToAdd = new Video(serialNumber, name, price,
                                    quality, duration);
                            
                            boolean addResult = videoDAO.addVideo(videoToAdd);
                            if (addResult) {
                                System.out.println("You have successfully add furniture: " + videoToAdd.getDescription());
                            }
                        } catch (InputMismatchException exception) {
                            System.out.println("Please Type In Right Input Type");
                        } catch (EmptyInputException ex) {
                            System.out.println(ex);
                        }

                        break;
                        default:
                            System.out.println("Please choose a proper option(1,2,3,4)");
                            break;
                    }

                    break;
                case 2:
                    System.out.println("All furniture: ");
                    
                    List<Furniture> allFurnitures = furnitureDAO.getAllFurnitures();
                    allFurnitures.stream().forEach(furniture -> {
                        System.out.println(furniture.getDescription());
                    });
                    break;

                case 3:
                    System.out.println("Type in thing serial number: ");
                    String serialNumber = sc.next();
     
                    Thing thing = thingDAO.getThingBySerialNumber(serialNumber);
                    System.out.println(thing.getDescription());
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please choose a proper option(1,2,3,4)");
                    break;
            }
        }
    }

}
