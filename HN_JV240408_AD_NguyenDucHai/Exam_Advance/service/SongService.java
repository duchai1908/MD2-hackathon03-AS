package HN_JV240408_AD_NguyenDucHai.Exam_Advance.service;

import HN_JV240408_AD_NguyenDucHai.Exam_Advance.model.Singer;
import HN_JV240408_AD_NguyenDucHai.Exam_Advance.model.Song;
import HN_JV240408_AD_NguyenDucHai.Exam_Advance.run.MusicManagement;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SongService {
    public static Song[] songs = new Song[100];
    public static int indexSong = 0;
    public static Song findSongById(String id){
        for (int i = 0; i < indexSong; i++) {
            if (songs[i].getSongId().equals(id)) {
                return songs[i];
            }
        }
        return null;
    }

    /*-------------------------------VALIDATE DATA-------------------------------*/
    //Input Song Id
    public static String inputSongId(String songId,Scanner sc){
        String songidRegex = "S\\w{3}";
        while (true){
            if(Pattern.matches(songidRegex,songId)){
                if(findSongById(songId) == null){
                    return songId;
                }
                else {
                    System.err.println("Id is exist,try again");
                }
            }else{
                System.err.println("The id must start with S and have at least 3 characters, please try again");
            }
            System.out.println("Enter song ID: ");
            songId = sc.nextLine();
        }
    }
    //Input Song Name
    public static String inputSongName(String songName,Scanner sc){
        while (true){
            if(songName.trim().isEmpty()){
                System.err.println("song name must not be empty, please try again");
                System.out.println("Enter Song Name");
                songName = sc.nextLine();
            }else {
                return songName;
            }
        }
    }

    //Input Singer
    public static Singer inputSinger(Scanner sc){
        System.out.println("List singer you can choose");
       for(int i = 0;i< SingerService.indexSinger;i++){
           System.out.println(SingerService.singers[i]);
       }
        System.out.println("Enter singer ID: ");
        int singerId = Integer.parseInt(sc.nextLine());
        while(true){
            if(SingerService.findSingerById(singerId) == null){
                System.err.println("Cant find singer with id " + singerId);
                System.out.println("Input Singer ");
                singerId = Integer.parseInt(sc.nextLine());
            }else{
                return SingerService.findSingerById(singerId);
            }
        }
    }

    //Input Song Writer
    public static String inputSongWriter(String songWriter,Scanner sc){
        while (true){
            if(songWriter.trim().isEmpty()){
                System.err.println("song writer must not be empty, please try again");
                System.out.println("Enter song Writer");
                songWriter = sc.nextLine();
            }else{
                return songWriter;
            }
        }
    }

    //Input Song Status
    public static boolean inputSongStatus(String songStatus,Scanner sc){
        while (true){
            if(songStatus.equals("true") || songStatus.equals("false")){
                return Boolean.parseBoolean(songStatus);
            }else{
                System.err.println("Your input is wrong,try again");
                System.out.println("Enter Song Status");
                songStatus = sc.nextLine().toLowerCase();
            }
        }
    }

    /*---------------------------------------CRUD---------------------------------------*/
    // Add Song
    public static void addSong(Scanner sc){
        System.out.println("Enter the amount you need to add ");
        int number = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.println("Input songs " + (i + 1));
            Song song = new Song();
            song.inputData(sc);
            songs[indexSong] = song;
            indexSong++;
        }
        System.out.println("Add " + number + " songs successfull");
    }

    // List Song
    public static void listSong(){
        if(indexSong == 0){
            System.err.println("List Song is Empty");
            return;
        }
        System.out.println("****************List Songs ******************");
       for(int i =0; i<indexSong;i++){
          songs[i].displayData();
       }
    }

    // Update Song
    public static void updateSong(Scanner sc){
        System.out.println("Enter the id you want to update");
        String id = sc.nextLine();
        if(findSongById(id) == null){
            System.err.println("Song not found");
            return;
        }
        System.out.println("Song Information");
        findSongById(id).displayData();
        System.out.println("Input new information for this song");
        findSongById(id).updateData(sc);
        System.out.println("Update song successfull");
    }

    // Delete Song
    public static void deleteSong(Scanner sc){
        while (true){
            System.out.println("Enter the id you want to delete");
            String id = sc.nextLine();
            int indexDelete = -1;
            for(int i = 0 ; i < indexSong ; i++){
                if(songs[i].getSongId().equals(id)){
                    indexDelete = i;
                    break;
                }
            }
            if(indexDelete == -1){
                System.err.println("Song not found");
            }else{
                for(int i = indexDelete ; i < indexSong ; i++){
                    songs[i] = songs[i+1];
                }
                System.out.println("Delete song successfully");
                indexSong--;
                break;
            }
        }
    }
}
