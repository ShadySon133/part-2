package com.mycompany.chatapp;

import com.mycompany.part2.User;
import com.mycompany.part2.WelcomeToQuickChat;
import java.util.Scanner;

public class Login {

    Scanner input = new Scanner(System.in);

    public void loginUser() {

        boolean loggedIn = false;

        while (!loggedIn) {

            System.out.println("\n===== LOGIN =====");

            System.out.print("Enter username: ");
            String username = input.nextLine();

            System.out.print("Enter password: ");
            String password = input.nextLine();

            boolean isValid =
                    checkLoginCredentials(username,
                            password);

            if (isValid) {

                System.out.println("\nLogin successful!");

                loggedIn = true;

                WelcomeToQuickChat.startChat();

            } else {

                System.out.println(
                        "\nInvalid username or password.");

                System.out.println(
                        "Please try again.");
            }
        }
    }

    private boolean checkLoginCredentials(String username,
                                          String password) {

        User user = User.getInstance();

        return user.getUsername() != null
                && user.getPassword() != null
                && user.getUsername().equals(username)
                && user.getPassword().equals(password);
    }
}