package HN_JV240408_AD_NguyenDucHai.Exam_Advance.controller;

import HN_JV240408_AD_NguyenDucHai.Exam_Advance.service.SingerService;
import HN_JV240408_AD_NguyenDucHai.Exam_Advance.model.Singer;

import java.util.Scanner;

public class SingerController {
    public static void showSingerMenu(Scanner sc){
        while (true) {
            System.out.println("**********************************");
            System.out.println("Welcome to the Singer Management");
            System.out.println("**********************************");
            System.out.println("1.Input your numbers singers you want to add");
            System.out.println("2.Show list singers");
            System.out.println("3.Update singer information");
            System.out.println("4.Delete singer by singer id");
            System.out.println("5.Back to main menu");
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1:
                    SingerService.addSinger(sc);
                    break;
                case 2:
                    SingerService.showListSinger();
                    break;
                case 3:
                    SingerService.updateSinger(sc);
                    break;
                case 4:
                    SingerService.deleteSinger(sc);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Your choice is invalid, please try again");
            }
        }
    }
}
