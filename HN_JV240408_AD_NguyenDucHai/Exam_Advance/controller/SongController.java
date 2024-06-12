package HN_JV240408_AD_NguyenDucHai.Exam_Advance.controller;

import HN_JV240408_AD_NguyenDucHai.Exam_Advance.service.SongService;

import java.util.Scanner;

public class SongController {
    public static void menuSongManagement(Scanner sc) {
        while (true) {
            System.out.println("**********************************");
            System.out.println("Welcome to the Song Management");
            System.out.println("**********************************");
            System.out.println("1.Input your numbers song you want to add");
            System.out.println("2.Show list songs");
            System.out.println("3.Update song information by id");
            System.out.println("4.Delete song by id");
            System.out.println("5.Back to main menu");
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1:
                    SongService.addSong(sc);
                    break;
                case 2:
                    SongService.listSong();
                    break;
                case 3:
                    SongService.updateSong(sc);
                    break;
                case 4:
                    SongService.deleteSong(sc);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Your choice is invalid, please try again");
            }
        }
    }
}
