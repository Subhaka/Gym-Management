package com.company;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class DefaultMember implements Comparable<DefaultMember>, Serializable {
    private  int membershipNo;
    private  String name;
    private String memberType;
    private Date date;

    public DefaultMember(int membershipNo, String name, String memberType, Date date) {
        this.membershipNo = membershipNo;
        this.name = name;
        this.memberType = memberType;
        this.date = date;
    }

    public int getMembershipNo() {
        return membershipNo;
    }

    public void setMembershipNo(int membershipNo) {
        this.membershipNo = membershipNo;
    }

    public String getName() {
        return name;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultMember that = (DefaultMember) o;
        return Objects.equals(membershipNo, that.membershipNo) &&
                Objects.equals(name, that.name) &&
                Objects.equals(memberType, that.memberType) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(membershipNo, name, memberType, date);
    }

    @Override
    public String toString() {
        return "MembershipNo='" + membershipNo + '\'' +" "+
                "Name='" + name + '\'' + "  "+
                "Member Type='" + memberType + '\'' + " "+
                "Date=" + date+ " ";
    }

    @Override
    public int compareTo(DefaultMember o) {
        return this.name.compareTo(o.name);
    }
}
