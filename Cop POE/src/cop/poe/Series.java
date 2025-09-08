

package cop.poe;

import java.util.Scanner;

public class Series {

    
    
    
    
    // Launch first-glance menu and get user's choice
public static int StartUp() {
    Scanner sc = new Scanner(System.in);

    System.out.println("*************************************************************");
    System.out.println("                   LATEST SERIES-2025");
    System.out.println("*************************************************************");

    System.out.println("Press (1) to launch the menu or any other key to exit");
    String input = sc.nextLine();

    if (!input.equals("1")) {
        return 6; // exit
    }

    // Display menu options
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
        return 1; // default menu key
    }

    return Integer.parseInt(choiceInput);
}

    // =========================
    // LOGIC METHODS (for testing)
    // =========================

    // Capture a series (testable logic)
    public static void captureSeries(String seriesId, String seriesName, int ageRestriction, String episodes) {
        Series_ArrayList.SeriesStorage newSeries =
                new Series_ArrayList.SeriesStorage(seriesId, seriesName, String.valueOf(ageRestriction), episodes);
        Series_ArrayList.SeriesList.seriesList.add(newSeries);
    }

    // Search for a series by ID (returns the SeriesStorage object or null if not found)
    public static Series_ArrayList.SeriesStorage searchSeries(String seriesId) {
        for (Series_ArrayList.SeriesStorage s : Series_ArrayList.SeriesList.seriesList) {
            if (s.seriesid.equalsIgnoreCase(seriesId)) {
                return s;
            }
        }
        return null;
    }

    // Update a series by ID
    public static boolean updateSeries(String seriesId, String newName, String newAgeRestriction, String newEpisodes) {
        for (Series_ArrayList.SeriesStorage s : Series_ArrayList.SeriesList.seriesList) {
            if (s.seriesid.equalsIgnoreCase(seriesId)) {
                s.seriesname = newName;
                s.seriesAgeRestriction = newAgeRestriction;
                s.seriesNumberOfEpisodes = newEpisodes;
                return true;
            }
        }
        return false; // not found
    }

    // Delete a series by ID
    public static boolean deleteSeries(String seriesId) {
        return Series_ArrayList.SeriesList.seriesList.removeIf(
                s -> s.seriesid.equalsIgnoreCase(seriesId)
        );
    }

    // Display series report (returns a String instead of printing)
    public static String displaySeriesReportLogic() {
        if (Series_ArrayList.SeriesList.seriesList.isEmpty()) {
            return "No series have been captured yet.";
        }

        StringBuilder report = new StringBuilder();
        int i = 1;
        for (Series_ArrayList.SeriesStorage s : Series_ArrayList.SeriesList.seriesList) {
            report.append("Series ").append(i++).append("\n");
            report.append("ID: ").append(s.seriesid).append("\n");
            report.append("Name: ").append(s.seriesname).append("\n");
            report.append("Age Restriction: ").append(s.seriesAgeRestriction).append("\n");
            report.append("Number of Episodes: ").append(s.seriesNumberOfEpisodes).append("\n\n");
        }
        return report.toString();
    }

    // =========================
    // UI METHODS (for console)
    // =========================

    public static void CaptureSeries() {
        Scanner sc = new Scanner(System.in);

        System.out.println("---------------------------------------------------");
        System.out.println("              Capture A New Series");
        System.out.println("---------------------------------------------------");

        System.out.print("Enter the series ID: ");
        String seriesId = sc.nextLine();

        System.out.print("Enter the series name: ");
        String seriesName = sc.nextLine();

        int ageRestriction = 0;
        while (true) {
            System.out.print("Enter the age restriction (6–21): ");
            String ageInput = sc.nextLine();

            if (ageInput.matches("\\d+")) {
                ageRestriction = Integer.parseInt(ageInput);
                if (ageRestriction >= 6 && ageRestriction <= 21) {
                    break;
                }
            }
            System.out.println("Invalid input! Please try again.");
        }

        System.out.print("Enter the number of episodes: ");
        String episodes = sc.nextLine();

        captureSeries(seriesId, seriesName, ageRestriction, episodes);

        System.out.println("Series captured successfully!");
    }

    public static void SearchSeries() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------------");
        System.out.println("           Search For Series                 ");
        System.out.println("---------------------------------------------");

        System.out.print("Enter Series ID to search: ");
        String searchId = sc.nextLine();

        Series_ArrayList.SeriesStorage s = searchSeries(searchId);

        if (s != null) {
            System.out.println("Series Found: ");
            System.out.println("ID: " + s.seriesid);
            System.out.println("Name: " + s.seriesname);
            System.out.println("Age Restriction: " + s.seriesAgeRestriction);
            System.out.println("Number of Episodes: " + s.seriesNumberOfEpisodes);
        } else {
            System.out.println("No series found with ID: " + searchId);
        }
    }

    public static void UpdateSeries() {
        Scanner sc = new Scanner(System.in);

        System.out.println("---------------------------------------------");
        System.out.println("           Update Series Details             ");
        System.out.println("---------------------------------------------");

        System.out.print("Enter the series ID to update: ");
        String IdUpdate = sc.nextLine();

        Series_ArrayList.SeriesStorage s = searchSeries(IdUpdate);

        if (s != null) {
            System.out.print("Enter the new series name: ");
            String newName = sc.nextLine();

            System.out.print("Enter the new age restriction: ");
            String newAge = sc.nextLine();

            System.out.print("Enter the new number of episodes: ");
            String newEpisodes = sc.nextLine();

            updateSeries(IdUpdate, newName, newAge, newEpisodes);

            System.out.println("Series updated successfully!");
        } else {
            System.out.println("No series found with ID: " + IdUpdate);
        }
    }

   public static void DeleteSeries() {
    Scanner sc = new Scanner(System.in);

    System.out.println("---------------------------------------------");
    System.out.println("             Delete a Series                 ");
    System.out.println("---------------------------------------------");

    System.out.print("Enter the series ID to delete: ");
    String deleteID = sc.nextLine().trim();

    Series_ArrayList.SeriesStorage s = searchSeries(deleteID); // find the series first

    if (s != null) {
        Series_ArrayList.SeriesList.seriesList.remove(s);
        System.out.println("Series \"" + s.seriesname + "\" has been successfully deleted.");
    } else {
        System.out.println("No series with ID: " + deleteID + " has been found.");
    }
}


    public static void DisplaySeriesReport() {
        System.out.println("------------------------------------------");
        System.out.println("             Series Report                ");
        System.out.println("------------------------------------------");
        System.out.println(displaySeriesReportLogic());
    }
}




















/*
package cop.poe;
import java.util.Scanner;
/**
 *
 * @author uriel
 
public class Series {
    
    //method to launch first-glance menu
    public static int StartUp() {
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
    public static void CaptureSeries() {
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
        public static void SearchSeries() {
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
     public static void DeleteSeries() {
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
    public static void DisplaySeriesReport() {
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
*/