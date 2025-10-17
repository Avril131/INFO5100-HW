package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HomeworkTwelve {

    // Read this file from your Java program
    // and print the phrase in the Java terminal
    public static void printFile(String filename) {
        File file = new File(filename);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
        }
    }

    public static void saveFile(String filename, String words) {
        try {
            File file = new File(filename);
            FileWriter writer = new FileWriter(file, true); // true for append mode
            writer.write(words + "\n"); // add newline and append
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving file: " + filename);
        }
    }

    // connect to database
    public static void connectToDatabase() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error connecting to database");
        }
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "mysql123");
        Statement statement = connection.createStatement();
        
        // First query - print students
        ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
        System.out.println("Original students:");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("id") + " " + resultSet.getString("name"));
        }
        resultSet.close(); // Close first ResultSet
        
        System.out.println("--------------------------------");
        System.out.println("Inserting students...");
        // insert students (id name) - use INSERT IGNORE to avoid replacing existing records
        statement.executeUpdate("INSERT IGNORE INTO student (id, name) VALUES (1, 'John')");
        statement.executeUpdate("INSERT IGNORE INTO student (id, name) VALUES (2, 'Jane')");
        System.out.println("--------------------------------");
        
        // Second query - print students after insert
        resultSet = statement.executeQuery("SELECT * FROM student");
        System.out.println("Students after insert:");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("id") + " " + resultSet.getString("name"));
        }
        resultSet.close(); // Close second ResultSet

        // delete student with id 1
        System.out.println("Deleting student with id 1...");
        statement.executeUpdate("DELETE FROM student WHERE id = 1");
        System.out.println("--------------------------------");
        
        // Third query - print students after delete
        resultSet = statement.executeQuery("SELECT * FROM student");
        System.out.println("Students after delete:");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("id") + " " + resultSet.getString("name"));
        }
        resultSet.close(); // Close third ResultSet

        // close the connection
        statement.close();
        connection.close();
    }

    public static void main(String[] args) throws SQLException {
        final String filename = "my_test_file.txt";
        // print the file
        System.out.println("Reading file: my_test_file.txt");
        System.out.println("--------------------------------");
        printFile(filename);
        System.out.println("--------------------------------");

        // input some words to save to the file
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some words to save to this file: ");
        String words = scanner.nextLine();
        saveFile(filename, words);
        scanner.close();
        System.out.println("--------------------------------");
        printFile(filename);
        System.out.println("--------------------------------");

        // connect to database
        System.out.println("Connecting to database...");
        System.out.println("--------------------------------");
        connectToDatabase();
        System.out.println("--------------------------------");
    }
}
