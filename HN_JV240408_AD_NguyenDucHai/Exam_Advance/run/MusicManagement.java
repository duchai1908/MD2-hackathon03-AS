package HN_JV240408_AD_NguyenDucHai.Exam_Advance.run;

import HN_JV240408_AD_NguyenDucHai.Exam_Advance.controller.SearchController;
import HN_JV240408_AD_NguyenDucHai.Exam_Advance.controller.SingerController;
import HN_JV240408_AD_NguyenDucHai.Exam_Advance.controller.SongController;

import java.util.Scanner;

public class MusicManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("****************************************");
            System.out.println("Welcome to the Music Management System!");
            System.out.println("****************************************");
            System.out.println("1.Singer Management");
            System.out.println("2.Song Management");
            System.out.println("3.Search Song");
            System.out.println("4.Exit");
            System.out.println("Select your collection");
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1:
                    SingerController.showSingerMenu(sc);
                    break;
                case 2:
                    SongController.menuSongManagement(sc);
                    break;
                case 3:
                    SearchController.searchManagement(sc);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Your choice is invalid, please try again");
            }
        }
    }
}
