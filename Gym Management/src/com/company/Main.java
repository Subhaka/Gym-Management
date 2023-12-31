package com.company;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static final GymManager gymManager = new MyGymManager();
    public static boolean name(String in) {
        return Pattern.matches("^[a-zA-Z+\\s]+[a-zA-Z]||[a-zA-Z]", in);
    }

    private static Object addMember() {
        Scanner sc = new Scanner(System.in);
        Scanner scanner=new Scanner(System.in);
        DefaultMember object = null;
        while (true) {
            System.out.println("Enter Membership Id : ");
            int membershipNo = sc.nextInt();
            System.out.println("Enter Member Name ");
            String name = scanner.nextLine().toLowerCase();
            if (name(name)) {
                System.out.println("Enter Date in dd/mm/yyyy format:");
                String date = scanner.nextLine();

                Date dateFormat;
                try {
                    dateFormat = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                } catch (ParseException e) {
                    System.out.println("Please Enter the date in 'dd/MM/yyyy' format");
                    return null;
                }
                System.out.println("Please enter the type of Membership(1-'Default Member, '2-'School Member', 3-'Over60 Member'):");
                int member_Type = sc.nextInt();

                switch (member_Type) {

                    case 1:
                        object = new DefaultMember(membershipNo, name, "Default Member", dateFormat);
                        break;

                    case 2:
                        Scanner scc = new Scanner(System.in);
                        System.out.println("Enter School Name:");
                        String school_name = scc.nextLine();
                        object = new StudentMember(membershipNo, name, "Student Member", dateFormat, school_name);
                        break;
                    case 3:
                        Scanner ft = new Scanner(System.in);
                        System.out.println("Enter Age:");
                        int age = ft.nextInt();
                        if (age > 60) {
                            object = new Over60Member(membershipNo, name, "Over60 Member", dateFormat, age);

                        } else {
                            System.out.println("age should be above 60 ");
                        }
                        break;
                    default:
                        System.out.println("====Invalid Input !! Please Enter one of the Inputs mentioned above!====");
                        continue;
                }
                gymManager.addMember(object);
                break;
            }else {
                System.out.println("Invalid Input");
            }
    }

        return null;
    }
private static void deleteMembers(){
        Scanner sc=new Scanner(System.in);
    System.out.println("Enter Member Name to be Deleted");
    String name =sc.nextLine();
    gymManager.deleteMember(name);
}
private static void printMembers(){
        gymManager.printMember();
}
private static void sortMembers(){
        gymManager.sort();
}


    public static void main(String[] args) {
        System.out.println("=====================*********GYM MANAGEMENT SYSTEM**********==================\n");
        gymManager.retrieve();
        System.out.println("\n");
        menuLoop:
        while (true) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER 1 TO ADD A MEMBER");
        System.out.println("ENTER 2 TO DELETE A MEMBER");
        System.out.println("ENTER 3 TO PRINT ALL MEMBERS");
        System.out.println("ENTER 4 TO SORT MEMBERS BY NAME");
        System.out.println("ENTER 5 TO OPEN GUI");
        int userCase = sc.nextInt();

        switch (userCase) {
            case 1:
                addMember();
                gymManager.save();
                break;
            case 2:
                deleteMembers();
                gymManager.save();
                break;
            case 3:
                printMembers();
                break;
            case 4:
                sortMembers();
                break;
            case 5: GUI.main(args);
            break;
            default:
                System.out.println("====Invalid Input !! Please Enter one of the Inputs mentioned above!====");


        }
    }
    }
}
