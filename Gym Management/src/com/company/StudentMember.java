package com.company;

import java.util.Date;
import java.util.Objects;

public class StudentMember extends DefaultMember {

private String schoolName;

    public StudentMember(int membershipNo, String name, String memberType, Date date,String schoolName) {
        super(membershipNo, name, memberType, date);
        this.schoolName=schoolName;
    }


    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentMember member = (StudentMember) o;
        return Objects.equals(schoolName, member.schoolName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), schoolName);
    }

    @Override
    public String toString() {
        return super.toString()+
                "School Name='" + schoolName;
    }

}
