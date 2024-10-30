package com.example.kulb_csd214test2;

public class StudentCollege {
    private int studentId;
    private String studentName;
    private String collegeName;
    private int collegeRank;
    public StudentCollege(int studentId, String studentName, String collegeName, int collegeRank) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.collegeName = collegeName;
        this.collegeRank = collegeRank;
    }
    public int getStudentId() {
        return studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public String getCollegeName() {
        return collegeName;
    }
    public int getCollegeRank() {
        return collegeRank;
    }

}


