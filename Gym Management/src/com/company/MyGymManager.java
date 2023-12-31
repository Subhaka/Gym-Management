package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class MyGymManager implements GymManager{

    public ArrayList<DefaultMember> getMembers() {
        return members;
    }

    private static final ArrayList<DefaultMember>members=new ArrayList<>(20);
    int max_count=100;

    @Override
    public void addMember(DefaultMember defaultMember) {

            for (DefaultMember object1 : members) {
                if (defaultMember.equals(object1)) {       //checking if the object entered already exist in arraylist or not
                    System.out.println("Member already exist!!!");
                    return;
                }
            }
            if (members.size() <= max_count) {
                members.add(defaultMember);
                System.out.println(defaultMember.getName() + " Member added successfully");
                System.out.println(members.size() + " members exist!!");                //adding object to aaraylist
                System.out.println(max_count - members.size() + " No.of members can be added");
            } else if (defaultMember instanceof StudentMember || defaultMember instanceof Over60Member) {
                members.add(defaultMember);
                System.out.println(defaultMember.getName() + " Member added successfully");
                System.out.println(members.size() + " member exist");
                System.out.println(max_count - members.size() + " No.of teams can be added ");
            } else System.out.println(" members cannot be added");

    }

    @Override
    public void deleteMember(String memberName) {
        for(DefaultMember member: members){
           if(member.getName().equals(memberName)){
               System.out.println(member.getName()+ " member has been deleted successfully ");
               members.remove(member);
               System.out.println(members.size()+" no.of members exist");
                System.out.println(100-members.size()+" no.of members can be added");
            }
        }

    }

    @Override
    public void printMember() {
        for(DefaultMember member:members){
            System.out.println(member+"\n");
        }

    }

    @Override
    public void sort() {
        Collections.sort(members);

//        int n = members.size();
//        if (n > 0) {
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n - 1; j++) {
//                    if (members.get(j).getMembershipNo() > members.get(j + 1).getMembershipNo()){
//                        // swap arr[j+1] and arr[i]
//                        DefaultMember temp = members.get(j);
//                        members.set(j, members.get(j + 1));
//                        members.set(j + 1, temp);
//                    }
//                }
//            }
//        } else {
//            System.out.println("no members added");
////            break;
//        }
//        System.out.println(members);
//        break;
//        System.out.println(members);

        for (DefaultMember member:members){
            System.out.println(member+"\n");
        }
    }




    @Override
    public void save() {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("memberlist.txt");
        } catch (FileNotFoundException exception) {
            System.out.println("File Not Found!!");
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
        } catch (IOException exception) {
            System.out.println("Error occured while adding check in th file");
        }
        for (DefaultMember member : members) {
            try {
                objectOutputStream.writeObject(member);       //saving club details to file as objects
            } catch (IOException exception) {
                System.out.println("error");
            } catch (NullPointerException e) {
                System.out.println();

            }
        }
        try {
            objectOutputStream.flush();
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public void retrieve() {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream("memberlist.txt");
            } catch (FileNotFoundException exception) {
                System.out.println("File Not Found!!");
            }
            ObjectInputStream objectInputStream = null;
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);
            } catch (IOException exception) {
                System.out.println("Members Not Found");
            }
            for (; ; ) {
                try {
                    DefaultMember defaultMember = (DefaultMember) objectInputStream.readObject(); //retrieving objects from file to arraylist
                    members.add(defaultMember);
                    System.out.println(defaultMember);
                } catch (EOFException e) {
                    break;
                } catch (IOException exception) {
                    System.out.println("error");
                } catch (ClassNotFoundException e) {
                    System.out.println("Class is not found!!");

                } catch (NullPointerException e) {
                    return;
                }
            }

            if (members.isEmpty()) {
                System.out.println("No clubs Found");  //checking if club list is empty
            }
            try {
                fileInputStream.close();
                objectInputStream.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }

    }

}
