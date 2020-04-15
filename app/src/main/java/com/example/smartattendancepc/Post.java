package com.example.smartattendancepc;

import com.google.gson.annotations.SerializedName;

public class Post {
   // private int emp_id;
//    private int id;
//    private int userId;
//    private String title;

    private String emp_id;
    private String name;
    private String company;
    private String department;
    private String team;
    private String plant;

    public String getEmp_id() {
        return emp_id;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getDepartment() {
        return department;
    }

    public String getTeam() {
        return team;
    }

    public String getPlant() {
        return plant;
    }

    //    public int getEmp_id() {
//        return emp_id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getCompany() {
//        return company;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public String getTeam() {
//        return team;
//    }
//
//    public String getPlant() {
//        return plant;
//    }


    //    @SerializedName("body")
//    private String text;

//    public int getId() {
//        return id;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getText() {
//        return text;
//    }
}
