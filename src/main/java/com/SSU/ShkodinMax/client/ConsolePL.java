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
    private static final OrderedService orderedService = new OrderedServiceImpl();
    private static final OrderService orderService = new OrderServiceImpl();
    private static final ProductService productService = new ProductServiceImpl();
    private static final ProviderService providerService = new ProviderServiceImpl();
    private static final StaffService staffService = new StaffServiceImpl();
    private static final TypeService typeService = new TypeServiceImpl();
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
        System.out.println("1. Sign in \n" + "2. Sign up");
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

    private static String[] getLoginAndPasswordToSign(){
        Scanner sc = new Scanner(System.in);
        System.out.print("login:");
        String login = sc.nextLine();
        System.out.print("password:");
        String password = sc.nextLine();
        return new String[]{login, password};
    }
    public static void main(String[] args) throws Exception {
        boolean isExit = false;
        printLoginMenu();
        switch (getChoice(1,2)){
            case 1:
                System.out.println("Please sign in: ");
                boolean isSignInSuccess = false;
                while (!isSignInSuccess) {
                    String[] loginAndPassword = getLoginAndPasswordToSign();
                    if(userService.checkUser(new User(loginAndPassword[0],loginAndPassword[1]))){
                        isSignInSuccess  = true;
                    }
                    else
                    {
                        System.out.println("Incorrect login or password, please try again");
                    }
                }
                break;
            case 2:
                String[] loginAndPassword = getLoginAndPasswordToSign();
                userService.addUser(new User(loginAndPassword[0],loginAndPassword[1]));
                break;
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
                            ClientIOHelper.getALl(clientService);
                            break;
                        case 2:
                            ClientIOHelper.addClient(clientService);
                            break;
                        case 3:
                            ClientIOHelper.updateClient(clientService);
                            break;
                        case 4:
                            ClientIOHelper.deleteClient(clientService);
                            break;
                    }
                    break;
                case 2:
                    switch (choiceOperation){
                        case 1:
                            OrderIOHelper.getALl(orderService);
                            break;
                        case 2:
                            OrderIOHelper.addOrder(orderService,clientService,staffService);
                            break;
                        case 3:
                            OrderIOHelper.updateOrder(orderService,clientService,staffService);
                            break;
                        case 4:
                            OrderIOHelper.deleteOrder(orderService);
                            break;
                    }
                    break;
                case 3:
                    switch (choiceOperation){
                        case 1:
                            OrderedIOHelper.getALl(orderedService);
                            break;
                        case 2:
                            OrderedIOHelper.addOrdered(orderedService,orderService,productService);
                            break;
                        case 3:
                            OrderedIOHelper.updateOrdered(orderedService);
                            break;
                        case 4:
                            OrderedIOHelper.deleteOrdered(orderedService);
                            break;
                    }
                    break;
                case 4:
                    switch (choiceOperation){
                        case 1:
                            ProductIOHelper.getALl(productService);
                            break;
                        case 2:
                            ProductIOHelper.addProduct(productService,typeService,providerService);
                            break;
                        case 3:
                            ProductIOHelper.updateProduct(productService,typeService,providerService);
                            break;
                        case 4:
                            ProductIOHelper.deleteProduct(productService);
                            break;
                    }
                    break;
                case 5:
                    switch (choiceOperation){
                        case 1:
                            ProviderIOHelper.getALl(providerService);
                            break;
                        case 2:
                            ProviderIOHelper.addProvider(providerService);
                            break;
                        case 3:
                            ProviderIOHelper.updateProvider(providerService);
                            break;
                        case 4:
                            ProviderIOHelper.deleteProvider(providerService);
                            break;
                    }
                    break;
                case 6:
                    switch (choiceOperation){
                        case 1:
                            StaffIOHelper.getALl(staffService);
                            break;
                        case 2:
                            StaffIOHelper.addStaff(staffService);
                            break;
                        case 3:
                            StaffIOHelper.updateStaff(staffService);
                            break;
                        case 4:
                            StaffIOHelper.deleteStaff(staffService);
                            break;
                    }
                    break;

                case 7:
                    switch (choiceOperation){
                        case 1:
                            TypeIOHelper.getALl(typeService);
                            break;
                        case 2:
                            TypeIOHelper.addType(typeService);
                            break;
                        case 3:
                            TypeIOHelper.updateType(typeService);
                            break;
                        case 4:
                            TypeIOHelper.deleteType(typeService);
                            break;
                    }
                    break;

            }
       }


    }


}
