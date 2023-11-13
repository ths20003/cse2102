package com.example.demo;
public class PasswordQuality {

    public static boolean isPasswordStrong(String password) {
        int minLength = 8;

        boolean hasUppercase = !password.equals(password.toLowerCase());

        boolean hasLowercase = !password.equals(password.toUpperCase());

        boolean hasDigit = password.matches(".*\\d.*");


        boolean hasSpecialChar = !password.matches("[A-Za-z0-9 ]*");

        return password.length() >= minLength && hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }
}
