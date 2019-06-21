package com.husheng.wangye_test.model;

public class StudentMathDomain {
    private Integer id;
    private String school;
    private Integer sex;
    private Integer age;
    private String address;
    private String famsize;
    private String Pstatus;
    private Integer Medu;
    private Integer Fedu;
    private String Mjob;
    private String Fjob;

    @Override
    public String toString() {
        return "StudentMathDomain{" +
                "id=" + id +
                ", school='" + school + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", famsize='" + famsize + '\'' +
                ", Pstatus='" + Pstatus + '\'' +
                ", Medu=" + Medu +
                ", Fedu=" + Fedu +
                ", Mjob='" + Mjob + '\'' +
                ", Fjob='" + Fjob + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFamsize() {
        return famsize;
    }

    public void setFamsize(String famsize) {
        this.famsize = famsize;
    }

    public String getPstatus() {
        return Pstatus;
    }

    public void setPstatus(String pstatus) {
        Pstatus = pstatus;
    }

    public Integer getMedu() {
        return Medu;
    }

    public void setMedu(Integer medu) {
        Medu = medu;
    }

    public Integer getFedu() {
        return Fedu;
    }

    public void setFedu(Integer fedu) {
        Fedu = fedu;
    }

    public String getMjob() {
        return Mjob;
    }

    public void setMjob(String mjob) {
        Mjob = mjob;
    }

    public String getFjob() {
        return Fjob;
    }

    public void setFjob(String fjob) {
        Fjob = fjob;
    }
}
