package com.mycompany.practicalassignment;

import java.util.ArrayList;




public class Series_ArrayList {

    // declaration of feilds for one series
    public static class SeriesStorage {
        String seriesid;
        String seriesname;
        String seriesAgeRestriction;
        String seriesNumberOfEpisodes;

        //constructor to retrieve the values/ data of the series
        public SeriesStorage(String id, String name, String ageRestriction, String numberOfEpisodes) {
            this.seriesid = id;
            this.seriesname = name;
            this.seriesAgeRestriction = ageRestriction;
            this.seriesNumberOfEpisodes = numberOfEpisodes;
        }
    }

    // storing of all the series details in one list
    public static class SeriesList {
        static ArrayList<SeriesStorage> seriesList = new ArrayList<>();
    }

    // logic to add a new series to the list
    public void AddSeries(String id, String name, String ageRestriction, String numberOfEpisodes) {
        SeriesStorage newSeries = new SeriesStorage(id, name, ageRestriction, numberOfEpisodes);
        SeriesList.seriesList.add(newSeries); 
    }
}

