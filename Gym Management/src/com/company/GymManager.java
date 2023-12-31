package com.company;

public interface GymManager {
void addMember(DefaultMember defaultMember);
void deleteMember(String memberName);
void printMember();
void sort();
void save();
void retrieve();
}
