package HN_JV240408_AD_NguyenDucHai.Exam_Advance.model;

import HN_JV240408_AD_NguyenDucHai.Exam_Advance.service.SingerService;

import java.util.Scanner;

public class Singer {
    private int singerId,age;
    private String singerName,nationality,genre;
    private boolean gender;

    public Singer() {
    }

    public Singer(int singerId, int age, String singerName, String nationality, String genre, boolean gender) {
        this.singerId = singerId;
        this.age = age;
        this.singerName = singerName;
        this.nationality = nationality;
        this.genre = genre;
        this.gender = gender;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
    /*----------------------------INPUT DATA------------------------------*/
    public void inputData(Scanner sc){
        this.singerId = SingerService.inputSingerId();
        System.out.println("Enter Singer Name");
        this.singerName = SingerService.inputSingerName(sc.nextLine(),sc);
        System.out.println("Enter Singer Age");
        this.age = SingerService.inputAge(Integer.parseInt(sc.nextLine()),sc);
        System.out.println("Enter Singer Nationality");
        this.nationality = SingerService.inputNationality(sc.nextLine(),sc);
        System.out.println("Enter Singer Gender");
        this.gender = SingerService.inputGender(sc.nextLine(),sc);
        System.out.println("Enter Singer Genre");
        this.genre = SingerService.inputGenre(sc.nextLine(),sc);
    }
    /*----------------------------UPDATE DATA------------------------------*/
    public void updateData(Scanner sc){
        System.out.println("Enter Singer Name");
        this.singerName = SingerService.inputSingerName(sc.nextLine(),sc);
        System.out.println("Enter Singer Age");
        this.age = SingerService.inputAge(Integer.parseInt(sc.nextLine()),sc);
        System.out.println("Enter Singer Nationality");
        this.nationality = SingerService.inputNationality(sc.nextLine(),sc);
        System.out.println("Enter Singer Gender");
        this.gender = SingerService.inputGender(sc.nextLine(),sc);
        System.out.println("Enter Singer Genre");
        this.genre = SingerService.inputGenre(sc.nextLine(),sc);
    }
    /*----------------------------DISPLAY DATA------------------------------*/
    public void displayData(){
        System.out.printf("ID : %3s | Name: %15s | Age: %3s | Genre %15s | Gender: %5s | Nationality: %15s \n",
                this.singerId,this.singerName,this.age,this.genre,this.gender?"Male":"Female",this.nationality);
    }
    public String toString(){
        return String.format("ID : %3s | Name: %15s\n",this.singerId,this.singerName);
    }

}
