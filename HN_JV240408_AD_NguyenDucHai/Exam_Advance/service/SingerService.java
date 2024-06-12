package HN_JV240408_AD_NguyenDucHai.Exam_Advance.service;

import HN_JV240408_AD_NguyenDucHai.Exam_Advance.model.Singer;

import java.util.Scanner;

public class SingerService {
    public static Singer[] singers = new Singer[100];
    public static int indexSinger = 0;

    public static Singer findSingerById(int id) {
        for (int i = 0; i < indexSinger; i++) {
            if (singers[i].getSingerId() == id) {
                return singers[i];
            }
        }
        return null;
    }

    /*--------------------------------VALIDATE DATA-------------------------------*/

    //Input Singer Id
    public static int inputSingerId() {
        if (indexSinger == 0) {
            return 1;
        } else {
            int max = singers[0].getSingerId();
            for (int i = 0; i < indexSinger; i++) {
                if (max < singers[i].getSingerId()) {
                    max = singers[i].getSingerId();
                }
            }
            return max + 1;
        }
    }

    //Input Singer Name
    public static String inputSingerName(String singerName, Scanner sc) {
        while (true) {
            if (singerName.trim().isEmpty()) {
                System.err.println("Singer name must not be empty, please try again");
                System.out.println("Enter singer name: ");
                singerName = sc.nextLine();
            } else {
                return singerName;
            }
        }
    }

    //Input Singer Age
    public static int inputAge(int age, Scanner sc) {
        while (true) {
            if (age <= 0) {
                System.err.println("Age must be greater than 0");
                System.out.println("Enter Age");
                age = sc.nextInt();
            } else {
                return age;
            }
        }
    }

    //Input Singer Nationality
    public static String inputNationality(String nationality, Scanner sc) {
        while (true) {
            if (nationality.trim().isEmpty()) {
                System.err.println("Nationality must not be empty, please try again");
                System.out.println("Enter Nationality");
                nationality = sc.nextLine();
            } else {
                return nationality;
            }
        }
    }

    //Input Singer Gender
    public static boolean inputGender(String gender, Scanner sc) {
        while (true) {
            if (gender.equals("True") || gender.equals("False")) {
                return Boolean.parseBoolean(gender);
            } else {
                System.err.println("Your input is wrong,try again");
                System.out.println("Enter Gender");
                gender = sc.nextLine();
            }
        }
    }

    //Input Singer Genre
    public static String inputGenre(String genre, Scanner sc) {
        while (true) {
            if (genre.trim().isEmpty()) {
                System.err.println("Genre must not be empty, please try again");
                System.out.println("Enter Genre");
                genre = sc.nextLine();
            } else {
                return genre;
            }
        }
    }

    /*-------------------------CRUD---------------------------*/

    // Add Singer
    public static void addSinger(Scanner sc) {
        System.out.println("Enter the amount you need to add ");
        int number = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.println("Input singer " + (i + 1));
            Singer singer = new Singer();
            singer.inputData(sc);
            singers[indexSinger] = singer;
            indexSinger++;
        }
        System.out.println("Add " + number + " singers successfull");
    }

    //Show List Singer
    public static void showListSinger() {
        if (indexSinger == 0) {
            System.err.println("List singer is empty");
            return;
        }
        System.out.println("----------------Singer Information-------------");
        for (int i = 0; i < indexSinger; i++) {
            singers[i].displayData();
        }
    }

    //Update Singer
    public static void updateSinger(Scanner sc) {
        if (indexSinger == 0) {
            System.err.println("List singer is empty");
            return;
        }
        System.out.println("Enter the id singer you need to update ");
        int singerId = Integer.parseInt(sc.nextLine());
        if (findSingerById(singerId) == null) {
            System.err.println("Singer not found");
        } else {
            findSingerById(singerId).updateData(sc);
        }
    }

    //Delete Singer
    public static void deleteSinger(Scanner sc) {
        if (indexSinger == 0) {
            System.err.println("List singer is empty");
            return;
        }
        System.out.println("Enter the id singer you need to delete ");
        int singerId = Integer.parseInt(sc.nextLine());
        if (findSingerById(singerId) != null) {
            for (int i = 0; i < SongService.indexSong; i++) {
                if (singerId == SongService.songs[i].getSinger().getSingerId()) {
                    System.err.println("Cant delete singer have songs");
                    return;
                }
            }
            int indexDelete = -1;
            for (int i = 0; i < indexSinger; i++) {
                if (singers[i].getSingerId() == singerId) {
                    indexDelete = i;
                    break;
                }
            }
            for(int i = indexDelete; i < indexSinger; i++) {
                singers[i] = singers[i+1];
            }
            System.out.println("Delete singer successfully");
            indexSinger--;

        } else {
            System.err.println("Singer not found");
        }

    }
}
