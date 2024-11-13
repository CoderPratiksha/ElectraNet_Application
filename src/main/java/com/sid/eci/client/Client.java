package tka.com.client;
import tka.com.controller.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;


import tka.com.entity.*;

public class Client {
    private static final Controller controller = new Controller();
    
    public static void main(String[] args) {
        System.out.println("Welcome to Election Commission of India");

        try (Scanner sc = new Scanner(System.in); BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            int choice;
            boolean exit = false;

            while (!exit) {
                displayMainMenu();
                choice = getUserChoice(sc);

                switch (choice) {
                    case 1 -> insertCandidate(sc, bf);
                    case 2 -> viewCandidates(sc, bf);
                    case 3 -> updateCandidate(sc, bf);
                    case 4 -> deleteCandidate(sc);
                    case 5 -> exit = true;
                    default -> System.out.println("Invalid input. Please choose a valid option.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void displayMainMenu() {
    	System.out.println(
    		    " --------------------\n" +
    		    "|       MENU        |\n" +
    		    " --------------------\n" +
    		    "|1. Insert Candidate|\n" +
    		    " --------------------\n" +
    		    "|2. View Candidate  |\n" +
    		    " --------------------\n" +
    		    "|3. Update Candidate|\n" +
    		    " --------------------\n" +
    		    "|4. Delete Candidate|\n" +
    		    " --------------------\n" +
    		    "|5. Exit            |\n" +
    		    " --------------------"
    		);

        System.out.println("Enter Choice:");
    }

    private static int getUserChoice(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1; // Return -1 for invalid input
        }
    }

    private static void insertCandidate(Scanner sc, BufferedReader bf) {
        try {
            System.out.println("Enter Candidate ID:");
            int cid = Integer.parseInt(sc.nextLine().trim());

            System.out.println("Enter Name:");
            String name = bf.readLine().trim();

            System.out.println("Enter Gender:");
            String gender = bf.readLine().trim();

            System.out.println("Enter Party:");
            String party = bf.readLine().trim();

            System.out.println("Enter State:");
            String state = bf.readLine().trim();

            System.out.println("Enter Assembly:");
            String assembly = bf.readLine().trim();

            System.out.println("Enter Age:");
            int age = Integer.parseInt(sc.nextLine().trim());

            String res = controller.addCandidate(cid, name, gender, party, state, assembly, age);
            System.out.println(res);
        } catch (Exception e) {
            System.out.println("Error inserting candidate: " + e.getMessage());
        }
    }

    private static void viewCandidates(Scanner sc, BufferedReader bf) {
        int viewChoice;
        do {
            displayViewMenu();
            viewChoice = getUserChoice(sc);

            try {
                switch (viewChoice) {
                    case 1 -> displayCandidates(controller.getAllCandidate());
                    case 2 -> {
                        System.out.println("Enter Party Name:");
                        String party = bf.readLine().trim();
                        displayCandidates(controller.getCandidateByParty(party));
                    }
                    case 3 -> {
                        System.out.println("Enter Gender (male/female):");
                        String gender = bf.readLine().trim();
                        displayCandidates(controller.getCandidateByGender(gender));
                    }
                    case 4 -> {
                        System.out.println("Enter Assembly:");
                        String assembly = bf.readLine().trim();
                        displayCandidates(controller.getCandidateByAssembly(assembly));
                    }
                    case 5 -> System.out.println("Returning to main menu.");
                    default -> System.out.println("Invalid input. Please select a valid option.");
                }
            } catch (Exception e) {
                System.out.println("Error retrieving candidates: " + e.getMessage());
            }
        } while (viewChoice != 5);
    }

    private static void displayViewMenu() {
    	System.out.println(
    		    " ------------------------------\n" +
    		    "|         VIEW MENU           |\n" +
    		    " ------------------------------\n" +
    		    "| 1. All Candidates of ECI 2024|\n" +
    		    " ------------------------------\n" +
    		    "| 2. ECI Candidate by Party    |\n" +
    		    " ------------------------------\n" +
    		    "| 3. ECI Candidate by Gender   |\n" +
    		    " ------------------------------\n" +
    		    "| 4. ECI Candidate by Assembly |\n" +
    		    " ------------------------------\n" +
    		    "| 5. Main Menu                 |\n" +
    		    " ------------------------------"
    		);
 System.out.println("Enter Choice:");
    }

    private static void displayCandidates(List<Candidate> candidates) {
        if (candidates.isEmpty()) {
            System.out.println("No candidates found.");
        } else {
            candidates.forEach(System.out::println);
        }
        System.out.println("____________________________________________________\n");
    }

    private static void updateCandidate(Scanner sc, BufferedReader bf) {
        try {
            System.out.println("Enter Candidate ID to update:");
            int oldCid = Integer.parseInt(sc.nextLine().trim());

            System.out.println("Enter Updated Candidate ID:");
            int updatedCid = Integer.parseInt(sc.nextLine().trim());

            System.out.println("Enter Updated Name:");
            String name = bf.readLine().trim();

            System.out.println("Enter Updated Party:");
            String party = bf.readLine().trim();

            System.out.println("Enter Updated Assembly:");
            String assembly = bf.readLine().trim();

            System.out.println("Enter Updated Age:");
            int age = Integer.parseInt(sc.nextLine().trim());

            String res = Controller.updateCandidateData(oldCid, updatedCid, name, party, assembly);
            System.out.println(res);
        } catch (Exception e) {
            System.out.println("Error updating candidate: " + e.getMessage());
        }
    }

    private static void deleteCandidate(Scanner sc) {
        try {
            System.out.println("Enter Candidate ID to delete:");
            int id = Integer.parseInt(sc.nextLine().trim());
            String res = Controller.deleteCadidate(id);
            System.out.println(res);
        } catch (Exception e) {
            System.out.println("Error deleting candidate: " + e.getMessage());
        }
    }
}
