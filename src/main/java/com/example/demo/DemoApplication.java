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
        //String apiKey = "";
        //String workplaceSlug = "";
        System.out.println("Insert your API key");
        String api = sc.nextLine();
        System.out.println("Insert workplace slug");
        String workplaceSlug = sc.nextLine();
        String responseGet;
        System.out.println("p -> Project, s -> State, la -> Label, li -> Link, i -> Issue, ia -> I. activity, ic -> I. comment, it -> I. types, ip -> I. properties, ipo -> I. property options, ipv -> I. p. values, iatt -> I. attachments, m -> Module, mi -> Module issue, c -> Cycle, ci -> C. issue, ii -> Intake issue, w -> Worklogs, mem -> Members");
        userInput1 = sc.nextLine();
        if (userInput1.matches(".*\\d.*") == false) //sprawdza czy userinput ma cyfry, do ulepszenia, najlepiej żeby patrzyło czy patern pasuje
        {
            switch (userInput1) {
                case "p":
                    System.out.println("Choose the action you want performed.\n 1 -> Add project \n 2 -> List projects \n 3 -> Get project details \n 4 -> Update project \n 5 -> Delete project");
                    break;

                case "s":
                    System.out.println("Choose the action you want performed.\n 1 -> Add state \n 2 -> List states \n 3 -> Get state details \n 4 -> Update state \n 5 -> Delete state");
                    break;

                case "la":
                    System.out.println("Choose the action you want performed.\n 1 -> Add label \n 2 -> List labels \n 3 -> Get label details \n 4 -> Update label \n 5 -> Delete label");
                    break;

                case "li":
                    System.out.println("Choose the action you want performed.\n 1 -> Add link \n 2 -> List links \n 3 -> Get link details \n 4 -> Update link \n 5 -> Delete link");
                    break;

                case "i":
                    System.out.println("Choose the action you want performed.\n 1 -> Add issue \n 2 -> List issues \n 3 -> Get issue details \n 4 -> Update issue \n 5 -> Delete issue");
                    break;

                case "ia":
                    System.out.println("Choose the action you want performed.\n 1 -> List issue activities \n 2 -> Get activity details");
                    break;

                case "ic":
                    System.out.println("Choose the action you want performed.\n 1 -> Add comment \n 2 -> List comments \n 3 -> Get comment details \n 4 -> Update comment \n 5 -> Delete comment");
                    break;

                case "it":
                    System.out.println("Choose the action you want performed.\n 1 -> List issue types"); //trzeba dodać więcej
                    break;

                case "ip":
                    System.out.println("Choose the action you want performed.\n 1 -> Add issue property \n 2 -> List issue properties \n 3 -> Get property details \n 4 -> Update property \n 5 -> Delete property");
                    break;

                case "ipo":
                    System.out.println("Choose the action you want performed.\n 1 -> Add property option \n 2 -> List property options \n 3 -> Get option details \n 4 -> Update option \n 5 -> Delete option");
                    break;

                case "ipv":
                    System.out.println("Choose the action you want performed.\n 1 -> Add property value \n 2 -> List property values \n 3 -> Get value details \n 4 -> Update value \n 5 -> Delete value");
                    break;

                case "iatt":
                    System.out.println("Choose the action you want performed.\n 1 -> Add attachment \n 2 -> List attachments \n 3 -> Get attachment details \n 4 -> Delete attachment");
                    break;

                case "m":
                    System.out.println("Choose the action you want performed.\n 1 -> Add module \n 2 -> List modules \n 3 -> Get module details \n 4 -> Update module \n 5 -> Delete module");
                    break;

                case "mi":
                    System.out.println("Choose the action you want performed.\n 1 -> Add issue to module \n 2 -> List module issues \n 3 -> Get module issue details \n 4 -> Update module issue \n 5 -> Delete module issue");
                    break;

                case "c":
                    System.out.println("Choose the action you want performed.\n 1 -> Add cycle \n 2 -> List cycles \n 3 -> Get cycle details \n 4 -> Update cycle \n 5 -> Delete cycle");
                    break;

                case "ci":
                    System.out.println("Choose the action you want performed.\n 1 -> Add issue to cycle \n 2 -> List cycle issues \n 3 -> Get cycle issue details \n 4 -> Update cycle issue \n 5 -> Delete cycle issue");
                    break;

                case "ii":
                    System.out.println("Choose the action you want performed.\n 1 -> Add intake issue \n 2 -> List intake issues \n 3 -> Get intake issue details \n 4 -> Update intake issue \n 5 -> Delete intake issue");
                    break;

                case "w":
                    System.out.println("Choose the action you want performed.\n 1 -> Add worklog \n 2 -> List worklogs \n 3 -> Get worklog details \n 4 -> Update worklog \n 5 -> Delete worklog");
                    break;

                case "mem":
                    System.out.println("Choose the action you want performed.\n 1 -> Add member \n 2 -> List members \n 3 -> Get member details \n 4 -> Update member \n 5 -> Remove member");
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
            System.out.print(userInput1);
            userInput1 = userInput1 + sc.nextLine();
        }
        System.out.println(userInput1);
        if (userInput2 == 1) {
            responseGet = apiController.getRequests(userInput2, apiKey, workplaceSlug, userInput4, userInput5);
            System.out.println("GET Response: " + responseGet);
        } else if (userInput2 == 2 || userInput2 == 3) {
            System.out.println("Insert project id:");
            userInput4 = sc.nextLine();
            userInput4 = sc.nextLine();
            System.out.println(userInput4);

            responseGet = apiController.getRequests(userInput2, apiKey, workplaceSlug, userInput4, userInput5);
            System.out.println("GET Response: " + responseGet);
        } else if (userInput2 == 4){
            System.out.println("Insert issue sequence ID:");
            userInput4 = sc.nextLine();
            userInput4 = sc.nextLine();
            System.out.println(userInput4);

            responseGet = apiController.getRequests(userInput2, apiKey, workplaceSlug, userInput4, userInput5);
            System.out.println("GET Response: " + responseGet);
        } else if (userInput2 >= 5 && userInput2 <= 9) {
            System.out.println("Insert additional parameter for userInput5 (or press Enter to skip):");
            userInput5 = sc.nextLine();

            responseGet = apiController.postRequests(userInput2 - 3, apiKey, workplaceSlug, userInput4, userInput5);
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
