package com.pal.thirstymission.search_project;

import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

public class Projects {

    @SerializedName("id")  private int Id;

    @SerializedName("title") private String Title;

    @SerializedName("descp") private String Descp;
    @SerializedName("user_id")  private int Uid;
    @SerializedName("time")  private String time;





    public int getId() {
        return Id;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescp() {
        return Descp;
    }

    public int getUid() {
       return Uid;
    }
      public String getTime() {
       return time;
    }



}