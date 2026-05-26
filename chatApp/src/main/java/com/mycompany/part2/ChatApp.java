package com.mycompany.part2;

import com.mycompany.chatapp.Login;

public class ChatApp { 

    public static void main(String[] args) {

        MyRegistration registration = new MyRegistration();
        registration.register();

        Login login = new Login();
        login.loginUser();
    }
}