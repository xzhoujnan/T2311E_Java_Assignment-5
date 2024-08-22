package com.example.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ValidateProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ValidateProgram vp = new ValidateProgram();

        System.out.println("====== Validate Program ======");

        // Kiểm tra số điện thoại
        while (true) {
            System.out.print("Phone number: ");
            String phone = scanner.nextLine();
            String phoneResult = vp.checkPhone(phone);
            System.out.println(phoneResult);
            if (phoneResult.equals("Phone number is valid")) break;
        }

        // Kiểm tra email
        while (true) {
            System.out.print("Email: ");
            String email = scanner.nextLine();
            String emailResult = vp.checkEmail(email);
            System.out.println(emailResult);
            if (emailResult.equals("Email is valid")) break;
        }

        // Kiểm tra ngày tháng
        while (true) {
            System.out.print("Date (dd/MM/yyyy): ");
            String date = scanner.nextLine();
            String dateResult = vp.checkDate(date);
            System.out.println(dateResult);
            if (dateResult.equals("Date is valid")) break;
        }

        scanner.close();
    }

    public String checkPhone(String phone) {
        if (!phone.matches("\\d+")) {
            return "Phone number must be a number";
        }
        if (phone.length() != 10) {
            return "Phone number must be 10 digits";
        }
        return "Phone number is valid";
    }

    public String checkEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (!email.matches(emailRegex)) {
            return "Email must be in correct format";
        }
        return "Email is valid";
    }

    public String checkDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return "Date is valid";
        } catch (ParseException e) {
            return "Date must be in correct format (dd/MM/yyyy)";
        }
    }
}
