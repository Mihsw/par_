package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private ApiController apiController;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String userInput1;
        int userInput2 = 0;
        String userInput4 = "";
        String userInput5 = "";
        // System.out.println("Insert your API key");
        // String api = sc.nextLine();
        String api = "31";
        System.out.println("Insert workplace slug");
        String userInput3 = sc.nextLine();
        String responseGet;
            System.out.println("Choose what type of action you want performed.\n 1 ->  Get \n 2 -> Post \n 3 -> Edit \n exit -> Exit");
            userInput1 = sc.nextLine();
            switch (userInput1) {
                case "1":
                    System.out.println("Choose the action you want performed.\n 1 -> List projects \n 2 -> List cycles  \n 3 -> List issues");
                    userInput2 = sc.nextInt();
                    if (userInput2 < 0 || userInput2 > 3) {userInput2 = 0;}
                    break;

                case "2":
                    System.out.println("Choose the action you want performed.\n 1 ->   \n 2 ->  \n 3 -> ");
                    userInput2 = sc.nextInt();
                    if (userInput2 < 0 || userInput2 > 3) {userInput2 = 0;}
                    userInput2 += 3;
                    break;


                case "3":
                    System.out.println("Choose the action you want performed.\n 1 ->   \n 2 ->  \n 3 -> ");
                    userInput2 = sc.nextInt();
                    if (userInput2 < 0 || userInput2 > 3) {userInput2 = 0;}
                    userInput2 += 6;
                        break;

                case "exit":
                    System.exit(0);
                    break;
                default:
            }
        if (userInput2 == 1) {
            responseGet = apiController.getRequests(userInput2, api, userInput3, userInput4, userInput5);
            System.out.println("GET Response: " + responseGet);
        } else if (userInput2 == 2 || userInput2 == 3) {
            System.out.println("Insert project id for userInput4:");
            userInput4 = sc.nextLine();
            userInput4 = sc.nextLine();

            responseGet = apiController.getRequests(userInput2, api, userInput3, userInput4, userInput5);
            System.out.println("GET Response: " + responseGet);
        } else if (userInput2 >= 4 && userInput2 <= 9) {
            System.out.println("Insert additional parameter for userInput5 (or press Enter to skip):");
            userInput5 = sc.nextLine();

            responseGet = apiController.postRequests(userInput2 - 3, api);
            System.out.println("POST Response: " + responseGet);
        } else {
            System.out.println("Invalid option. Next time please type 1, 2, or 3.");
        }


        //if (userInput2 == 1) {
      //    responseGet = apiController.getRequests(userInput2, api, userInput3, userInput4, userInput5);
      //    System.out.println("GET Response: " + responseGet);}
      //} else if  (userInput2 < 4) {
      //    userInput2 = userInput2;
      //}
      //else if (userInput2 >= 4 && userInput2 <= 9) {
      //    responseGet = apiController.postRequests(userInput2 - 3, api);
      //    System.out.println("POST Response: " + responseGet);
      //} else {
      //    System.out.println("Invalid option. Next time please type 1, 2, or 3.");}
      //if (userInput2 > 3 || userInput2 < 2) {System.exit(0);}
      //System.out.println("Insert project id");
      //userInput4 = sc.nextLine();
      //responseGet = apiController.getRequests(userInput2, api, userInput3, userInput4, userInput5);
      //System.out.println("GET Response: " + responseGet);

    }
}
