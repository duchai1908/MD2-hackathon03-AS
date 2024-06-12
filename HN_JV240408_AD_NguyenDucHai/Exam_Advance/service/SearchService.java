package HN_JV240408_AD_NguyenDucHai.Exam_Advance.service;

import HN_JV240408_AD_NguyenDucHai.Exam_Advance.model.Singer;

import java.util.Scanner;

public class SearchService {
    /*================================Search Song=====================================*/
    public static void searchSong(Scanner sc){
        if(SongService.indexSong == 0){
            System.err.println("List song is empty, add song first");
            return;
        }
        if(SingerService.indexSinger == 0){
            System.err.println("List singer is empty, add song first");
            return;
        }
        System.out.println("Input song name or genre");
        String search = sc.nextLine();
        int count = 0;
        for(int i = 0; i< SongService.indexSong;i++){
            if(SongService.songs[i].getSinger().getSingerName().contains(search) || SongService.songs[i].getSinger().getGenre().contains(search)){
                SongService.songs[i].displayData();
                count++;
            }
        }
        if(count == 0){
            System.err.println("Cant find any song");
        }else {
            System.out.println("Found " + count + " songs");
        }
    }


    /*===============Search Singer===================*/
    public static void searchSinger(Scanner sc){
        if(SingerService.indexSinger == 0){
            System.err.println("List singer is empty, add song first");
            return;
        }
        System.out.println("Input singer name or genre");
        String search = sc.nextLine();
        int count = 0;
        for (int i = 0; i < SingerService.indexSinger;i++){
            if(SingerService.singers[i].getSingerName().contains(search) || SingerService.singers[i].getGenre().contains(search)){
                SingerService.singers[i].displayData();
                count++;
            }
        }
        if(count == 0){
            System.err.println("Cant find any singer");
        }else{
            System.out.println("Found " + count + " singers");
        }
    }

    /*===============Sort Singer===================*/
    public static void sortSingerByName() {
        for (int i = 0; i < SingerService.indexSinger - 1; i++) {
            for (int j = 0; j < SingerService.indexSinger - i - 1; j++) {
                if (SingerService.singers[j].getSingerName() != null && SingerService.singers[j + 1].getSingerName() != null) {
                    if (SingerService.singers[j].getSingerName().compareTo(SingerService.singers[j + 1].getSingerName()) > 0) {
                        Singer temp = SingerService.singers[j];
                        SingerService.singers[j] = SingerService.singers[j + 1];
                        SingerService.singers[j + 1] = temp;
                    }
                }
            }
        }
    }

    /*=================Displays the 10 most recently posted songs===================*/
    public static void displayTenSongsSoon(){
        if(SongService.indexSong < 10){
            System.err.println("List song must greater than 10");
            return;
        }
        int count = 0;
        for(int i = SongService.indexSong-1; count <= 10 ;i--){
            System.out.println("Song: "+(count+1));
            SongService.songs[i].displayData();
            count++;
        }
    }
}
