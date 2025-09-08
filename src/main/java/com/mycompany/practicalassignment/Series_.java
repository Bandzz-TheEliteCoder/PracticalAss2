/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicalassignment;

import java.util.Scanner;

/**
 *
 * @author uriel
 */
public class Series_ {
    
    

    
    //method to launch first-glance menu
    public int StartUp() {
    Scanner sc = new Scanner(System.in);

    System.out.println("*************************************************************");
    System.out.println("                   LATEST SERIES-2025");
    System.out.println("*************************************************************");

    System.out.println("Press (1) to launch the menu or any other key to exit");
    String input = sc.nextLine();

    if (!input.equals("1")) {
        return 6;// to exit (as [6] is set to the default exit key
    }

    // Displaying of menu options
    System.out.println("Please select one of the following options\n" +
                       "(Use numbers 1-6 to make a selection)\n" +
                       "(1) Capture a new series\n" +
                       "(2) Search for a series\n" +
                       "(3) Update series age restriction\n" +
                       "(4) Delete a series\n" +
                       "(5) Print series report\n" +
                       "(6) Exit Application\n");
    System.out.print("Enter your choice >> ");
    String choiceInput = sc.nextLine();

    if (!choiceInput.matches("[1-6]")) {
        System.out.println("Invalid selection! Exiting...");
        return 1; // as [1] is set to the default menu key
    }

    return Integer.parseInt(choiceInput); 
}
    
    //method to capture series
    public void CaptureSeries() {
    Scanner sc = new Scanner(System.in);

    System.out.println("---------------------------------------------------");
    System.out.println("              Capture A New Series");
    System.out.println("---------------------------------------------------");

    System.out.print("Enter the series ID: ");
    String seriesId = sc.nextLine();

    System.out.print("Enter the series name: ");
    String seriesName = sc.nextLine();

    // Age restriction validation
    int ageRestriction = 0;
    while (true) {
        System.out.print("Enter the age restriction: "
                        + "(Must be betewwn the ages of 6 and 21).\n");
        String ageInput = sc.nextLine();

         //execption handling for age restriction
        if (ageInput.matches("\\d+")) {
            ageRestriction = Integer.parseInt(ageInput);
            if (ageRestriction >= 6 && ageRestriction <= 21) {
                break;
            } else {
                System.out.println("Invalid age restriction! Please ensure the age is between the ages of 6 and 21.");
            }
        } else {
            System.out.println("Invalid input! Please enter a number.");
        }
    }

    System.out.print("Enter the number of episodes for \"" + seriesName + "\": ");
    String episodeInput = sc.nextLine();

    
    //logic to store the series details in the array
    Series_ArrayList.SeriesStorage newSeries= new Series_ArrayList.SeriesStorage(seriesId, seriesName, String.valueOf(ageRestriction), episodeInput);
    Series_ArrayList.SeriesList.seriesList.add(newSeries);
    
    
    System.out.println("Series captured successfully!");
    
    }
    
        //method to search for series by ID
        public void SearchSeries() {
    Scanner sc = new Scanner(System.in);

    System.out.println("---------------------------------------------");
    System.out.println("           Search For Series                 ");
    System.out.println("---------------------------------------------");

    System.out.print("Enter Series ID to search: ");
    String searchId = sc.nextLine();

    boolean found = false;

    for (Series_ArrayList.SeriesStorage series : Series_ArrayList.SeriesList.seriesList) {
        if (series.seriesid.equalsIgnoreCase(searchId)) {
            System.out.println("Series Found: ");
            System.out.println("ID: " + series.seriesid);
            System.out.println("Name: " + series.seriesname);
            System.out.println("Age Restriction: " + series.seriesAgeRestriction);
            System.out.println("Number of Episodes: " + series.seriesNumberOfEpisodes);
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("No series found with ID: " + searchId);
    }
}
    
    
    //method to update series details
       public static void UpdateSeries() {
    Scanner sc = new Scanner(System.in);

    System.out.println("---------------------------------------------");
    System.out.println("           Update Series Details             ");
    System.out.println("---------------------------------------------");

    System.out.print("Enter the series ID to update: ");
    String IdUpdate = sc.nextLine();

    boolean found = false;
    
    //loop through the array to retrieve the series details via the ID
    for (Series_ArrayList.SeriesStorage series : Series_ArrayList.SeriesList.seriesList) {
        
        if (series.seriesid.equalsIgnoreCase(IdUpdate)) { // if the series is found, then allow the user to update it

            System.out.print("Enter the new series name: ");
            series.seriesname = sc.nextLine();

            System.out.print("Enter the new age restriction: ");
            series.seriesAgeRestriction = sc.nextLine();

            System.out.print("Enter the new number of episodes: ");
            series.seriesNumberOfEpisodes = sc.nextLine();

            System.out.println("Series updated successfully!");
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("No series found with ID: " + IdUpdate);
    }
}
    
    
    //method to delete sries
     public void DeleteSeries() {
    Scanner sc = new Scanner(System.in);

    System.out.println("---------------------------------------------");
    System.out.println("             Delete a Series                 ");
    System.out.println("---------------------------------------------");

    System.out.print("Enter the series ID to delete: ");
    String deleteID = sc.nextLine().trim();

    boolean found = false;

    // loop through the array 
    for (int i = 0; i < Series_ArrayList.SeriesList.seriesList.size(); i++) {
        Series_ArrayList.SeriesStorage series = Series_ArrayList.SeriesList.seriesList.get(i);

        if (series.seriesid.equalsIgnoreCase(deleteID)) {
            Series_ArrayList.SeriesList.seriesList.remove(i);
            System.out.println("Series with ID: " + deleteID + " has been successfully deleted.");
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("No series with ID: " + deleteID + "has been found.");
    }
}
    
    
    
    //method to display series report
    public void DisplaySeriesReport() {
    System.out.println("------------------------------------------");
    System.out.println("             Series Report                ");
    System.out.println("------------------------------------------");

    if (Series_ArrayList.SeriesList.seriesList.isEmpty()) {
        System.out.println("No series have been captured yet.");
        return;
    }
    for (int i = 0; i < Series_ArrayList.SeriesList.seriesList.size(); i++) {
        Series_ArrayList.SeriesStorage series = Series_ArrayList.SeriesList.seriesList.get(i);
        System.out.println("Series " + (i + 1));
        System.out.println("-------------------------------------------");
        System.out.println("ID: " + series.seriesid);
        
       
        System.out.println("Name: " + series.seriesname);
        System.out.println("Age Restriction: " + series.seriesAgeRestriction);
        System.out.println("Number of Episodes: " + series.seriesNumberOfEpisodes);
        System.out.println("------------------------------------------");
    }
}
    
    
    
    
    
    
    
}

    
    
    
    
    
    
    
