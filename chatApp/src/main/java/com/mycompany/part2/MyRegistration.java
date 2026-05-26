package com.mycompany.part2;

import java.util.Scanner;

public class MyRegistration {

    Scanner input = new Scanner(System.in);

    public void register() {

        boolean registered = false;

        while (!registered) {

            System.out.println("\n===== REGISTRATION =====");
            
 System.out.println("Your Username must contain an underscore (_) and a maximum of 5 letters.");
            System.out.print("Enter username: ");
            String username = input.nextLine();

            System.out.print("Enter first name: ");
            String firstName = input.nextLine();

            System.out.print("Enter last name: ");
            String lastName = input.nextLine();
            
 System.out.println("Cellphone number must be a RSA number, starting with +27 and followed by 9 digits.");
            System.out.print("Enter cell number: ");
            String cellNumber = input.nextLine();
            
 System.out.print("Your Password must have a minimum of 8 letters, 1 capital letter, a number, and one special char.\nEnter Password: ");
            System.out.print("Enter password: ");
            String password = input.nextLine();

            String result =
                    registerUser(username,
                            cellNumber,
                            password);

            System.out.println(result);

            if (result.equals("Registration successful!")) {

                User user = User.getInstance();

                user.setCredentials(username, password);

                user.setFirstName(firstName);

                user.setLastName(lastName);

                registered = true;
            }
        }
    }

    private String registerUser(String username,
                                String cellNumber,
                                String password) {

        if (!checkUsername(username)) {

            return """
                   Username is not correctly formatted.
                   Username must contain an underscore
                   and be no more than 8 characters.
                   """;
        }

        if (!isCellNumberValid(cellNumber)) {

            return """
                   Cell number incorrectly formatted.
                   Example: +27831234567
                   """;
        }

        if (!checkPasswordComplexity(password)) {

            return """
                   Password must contain:
                   - 8 characters
                   - Capital letter
                   - Number
                   - Special character
                   """;
        }

        return "Registration successful!";
    }

    public static boolean checkUsername(String username) {

        return username.contains("_")
                && username.length() <= 8;
    }

    public static boolean isCellNumberValid(String cellNumber) {

        return cellNumber.matches("^\\+27\\d{9}$");
    }

    public static boolean checkPasswordComplexity(String password) {

        return password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*[a-z].*")
                && password.matches(".*\\d.*")
                && password.matches(".*[!@#$%^&*()].*");
    }
}