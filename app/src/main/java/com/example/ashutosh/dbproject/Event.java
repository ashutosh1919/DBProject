package com.example.ashutosh.dbproject;

public class Event {
    private int Team_Size;
    private String Event_Name;
    private String Date;
    private String Event_ID;
    private String Venue;
    private String Organizer;
    private String Level;
    private String Award_Type;

    public int getTeam_Size() {
        return Team_Size;
    }

    public void setTeam_Size(int team_Size) {
        Team_Size = team_Size;
    }

    public String getEvent_Name() {
        return Event_Name;
    }

    public void setEvent_Name(String event_Name) {
        Event_Name = event_Name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getEvent_ID() {
        return Event_ID;
    }

    public void setEvent_ID(String event_ID) {
        Event_ID = event_ID;
    }

    public String getVenue() {
        return Venue;
    }

    public void setVenue(String venue) {
        Venue = venue;
    }

    public String getOrganizer() {
        return Organizer;
    }

    public void setOrganizer(String organizer) {
        Organizer = organizer;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }

    public String getAward_Type() {
        return Award_Type;
    }

    public void setAward_Type(String award_Type) {
        Award_Type = award_Type;
    }
}
