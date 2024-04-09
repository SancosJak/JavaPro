package de.ait.lesson_2_task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User_main {
        public static void main(String[] args) throws IOException {

            List<User> users = new ArrayList<>();

            enterUsers(users);
            writeUsersToFile(users);
            readUsersFromFile();
        }

        public static void enterUsers(List<User> users) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Enter user name: ");
                String name = scanner.nextLine();
                if (name.isBlank()) {
                    break;
                }
                System.out.println("Enter user email: ");
                String email = scanner.nextLine();
                users.add(new User(name, email));
            }
            scanner.close();
        }

        public static void writeUsersToFile(List<User> users) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("users.txt"))) {
                for (User user : users) {
                    bufferedWriter.write(user.getName() + ", " + user.getEmail() + "\n");
                }
                System.out.println("All done!.");
            } catch (IOException e) {
                System.out.println("ERROR!");
                e.printStackTrace();
            }
        }

        public static void readUsersFromFile() {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("users.txt"))) {
                String file_line;
                System.out.println("Data from file:");
                while ((file_line = bufferedReader.readLine()) != null) {
                    System.out.println(file_line);
                }
            } catch (IOException e) {
                System.out.println("ERROR!");
                e.printStackTrace();
            }
        }
    }
