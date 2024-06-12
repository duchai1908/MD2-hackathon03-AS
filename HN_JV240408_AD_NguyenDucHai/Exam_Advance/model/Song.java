package HN_JV240408_AD_NguyenDucHai.Exam_Advance.model;

import HN_JV240408_AD_NguyenDucHai.Exam_Advance.run.MusicManagement;
import HN_JV240408_AD_NguyenDucHai.Exam_Advance.service.SingerService;
import HN_JV240408_AD_NguyenDucHai.Exam_Advance.service.SongService;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Song {
    private String songId,songName,description,songWriter;
    private Singer singer;
    private Date createdDate;
    private boolean songStatus;

    public Song() {
    }

    public Song(String songId, String songName, String description, String songWriter, Singer singer, Date createdDate, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.description = description;
        this.songWriter = songWriter;
        this.singer = singer;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    /*----------------------------INPUT DATA------------------------------*/
    public void inputData(Scanner sc){
        if(SingerService.indexSinger == 0){
            System.err.println("List Singer is empty, you should add singer first");
            return;
        }
        System.out.println("Enter song ID: ");
        this.songId = SongService.inputSongId(sc.nextLine(),sc);
        System.out.println("Enter Song Name");
        this.songName = SongService.inputSongName(sc.nextLine(),sc);
        System.out.println("Enter description: ");
        this.description = sc.nextLine();
        this.singer = SongService.inputSinger(sc);
        System.out.println("Enter Song Writer: ");
        this.songWriter = SongService.inputSongWriter(sc.nextLine(),sc);
        this.createdDate = new Date();
        System.out.println("Enter Song Status: ");
        this.songStatus = SongService.inputSongStatus(sc.nextLine().toLowerCase(),sc);
    }

    /*----------------------------UPDATE DATA------------------------------*/
    public void updateData(Scanner sc){
        System.out.println("Enter Song Name");
        this.songName = SongService.inputSongName(sc.nextLine(),sc);
        System.out.println("Enter description: ");
        this.description = sc.nextLine();
        this.singer = SongService.inputSinger(sc);
        System.out.println("Enter Song Writer: ");
        this.songWriter = SongService.inputSongWriter(sc.nextLine(),sc);
        this.createdDate = new Date();
        System.out.println("Enter Song Status: ");
        this.songStatus = SongService.inputSongStatus(sc.nextLine().toLowerCase(),sc);
    }

    /*----------------------------DISPLAY DATA------------------------------*/
    public void displayData(){
        System.out.printf("ID : %3s | Name: %15s | Descriptons: %15s | SongWriter %10s | Singer: %15s | Created: %15s | Status %3s\n",
                this.songId,this.songName,this.description,this.songWriter,this.singer.getSingerName(),this.createdDate,this.songStatus?"Active":"inActive");
    }
    /*----------------------------INPUT AND VALIDATE DATA------------------------------*/








}
