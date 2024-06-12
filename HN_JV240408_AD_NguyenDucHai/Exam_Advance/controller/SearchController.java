package HN_JV240408_AD_NguyenDucHai.Exam_Advance.controller;

import HN_JV240408_AD_NguyenDucHai.Exam_Advance.service.SearchService;

import java.util.Scanner;

public class SearchController {
    public static void searchManagement(Scanner sc){
        while (true) {
            System.out.println("**********************************");
            System.out.println("Welcome to the Search Management");
            System.out.println("**********************************");
            System.out.println("1.Search by song name or song genre");
            System.out.println("2.Search by singer name or singer genre");
            System.out.println("3.Displays song list in ascending order by name");
            System.out.println("4.Displays the 10 most recently posted songs");
            System.out.println("5.Back to main menu");
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1:
                    SearchService.searchSong(sc);
                    break;
                case 2:
                    SearchService.searchSinger(sc);
                    break;
                case 3:
                    SearchService.sortSingerByName();
                    break;
                case 4:
                    SearchService.displayTenSongsSoon();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Your choice is invalid, please try again");
            }
        }
    }
}
