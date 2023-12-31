package com.company;

import java.util.Date;
import java.util.Objects;

public class Over60Member extends DefaultMember{
    private int age;


    public Over60Member(int membershipNo, String name, String memberType, Date date,int age) {
        super(membershipNo, name, memberType, date);
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Over60Member that = (Over60Member) o;
        return age == that.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), age);
    }

    @Override
    public String toString() {
        return super.toString()+
                "age=" + age;
    }
}
