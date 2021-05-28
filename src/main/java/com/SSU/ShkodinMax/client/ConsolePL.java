package com.SSU.ShkodinMax.client;

import com.SSU.ShkodinMax.model.Client;
import com.SSU.ShkodinMax.model.User;
import com.SSU.ShkodinMax.services.*;
import com.SSU.ShkodinMax.services.impl.*;
import com.SSU.ShkodinMax.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsolePL {
    private static final ClientService clientService = new ClientServiceImpl();
    private final OrderedService orderedService = new OrderedServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();
    private final ProductService productService = new ProductServiceImpl();
    private final ProviderService providerService = new ProviderServiceImpl();
    private final StaffService staffService = new StaffServiceImpl();
    private final TypeService typeService = new TypeServiceImpl();
    private static final UserService userService = new UserServiceImpl();

    private static int getChoice(int minValue, int maxValue)
    {
        int choice = -1;
        Scanner sc;
        boolean isCorrect = false;
        while(!isCorrect){
            sc = new Scanner(System.in);
            System.out.print("Your choice:");
            try{
                choice = sc.nextInt();
                if (choice>=minValue && choice<=maxValue){
                    isCorrect = true;
                }
                else{
                    System.out.println("Wrong value please repeat!");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Wrong value please repeat!");

            }
        }
        return choice;
    }
    private static void printLoginMenu(){
        System.out.print("1. Sign in +\n" + "2. Sign up");
    }
    private static void printMainMenu()
    {
        System.out.println("Choice entity to work with: \n" +
                "1. Client\n" +
                "2. Order\n" +
                "3. Ordered\n" +
                "4. Product\n" +
                "5. Provider\n" +
                "6. Staff\n" +
                "7. Type\n");

    }
    private static void printOperationMenu()
    {
        System.out.println("1. Get ALL \n" +
                "2. Save \n" +
                "3. Update \n" +
                "4. Delete \n");
    }
    private static Client AddClient(){
        Scanner sc = new Scanner(System.in);

        Client clientToReturn = new Client();
        System.out.print("Enter Fullname:");
        clientToReturn.setFullName(sc.nextLine());
        System.out.print("Enter Address:");
        clientToReturn.setAddress(sc.nextLine());
        System.out.print("Enter Email:");
        clientToReturn.setEmail(sc.nextLine());
        System.out.print("Enter Phone number:");
        clientToReturn.setPhoneNumber(sc.nextLine());
        return clientToReturn;
    }

    private static String[] getLoginAndPasswordToSignIn(){
        Scanner sc = new Scanner(System.in);
        System.out.print("login:");
        String login = sc.nextLine();
        System.out.print("password:");
        String password = sc.nextLine();
        return new String[]{login, password};
    }
    public static void main(String[] args) throws Exception {
        boolean isExit = false;
        System.out.println("Please sign in: ");
        boolean isSignInSuccess = true;
        //String[] loginAndPassword = getLoginAndPasswordToSignIn();
        while (!isSignInSuccess) {
            String[] loginAndPassword = getLoginAndPasswordToSignIn();
            if(userService.checkUser(new User(loginAndPassword[0],loginAndPassword[1]))){
                isSignInSuccess  = true;
            }
            else
            {
                System.out.println("Incorrect login or password, please try again");
            }
        }
        while (!isExit) {

            printMainMenu();
            int choice = getChoice(1,7);
            printOperationMenu();
            int choiceOperation = getChoice(1,4);
            switch (choice){
                case 1:
                    switch (choiceOperation){
                        case 1:
                            break;
                        case 2:
                            ClientIOHelper.addClient(clientService);
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
            }
       }


    }


}
