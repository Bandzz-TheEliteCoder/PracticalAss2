/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practicalassignment;

/**
 *
 * @author uriel
 */



/**
 *
 * @author uriel
 */
public class PracticalAssignment {

   
    public static void main(String[] args) {
        
   int nextChoice;
   do {
    nextChoice=Series.StartUp();
    
    
    

    switch (nextChoice) {
            case 1:
                CaptureSeries();
                break;
                
            case 2:
                Series.SearchSeries();
                break;
            
            case 3:
                Series.UpdateSeries();
                break;
                
            case 4:
                Series.DeleteSeries();
                break;
                
            case 5:
                Series.DisplaySeriesReport();
                break;
                
                
            case 6:
                System.out.println("Exiting application... "
                                 + "Goodbye!\n");
                break;
            default:
                System.out.println("Feature not implemented yet.");
        }
   } while (nextChoice !=6);
    
}
}
