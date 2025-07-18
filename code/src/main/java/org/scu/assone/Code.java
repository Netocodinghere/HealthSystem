/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.scu.assone;

/**
 *
 * @author Neto
 */
public class Code {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }


    public class HealthProfessional{
        public int id;
        public String title;
        public String name;
        public String bio;
        public String[] availableDays;
      
          /**
         * Constructor for HealthProfessional
         * @param id Unique identifier for the health professional
         * @param title Title of the health professional (e.g., Dr., Nurse)
         * @param name Name of the health professional
         * @param bio Short biography or description of the health professional
         * @param availableDays Array of days when the health professional is available
         */

        //Default constructor
        HealthProfessional(){
            this.id = 0;
            this.title = "";
            this.name = "";
            this.bio = "";
            this.availableDays = new String[]{};

            System.out.println("HealthProfessional object created with default values.");
        }

        // Secondary constructor 
        HealthProfessional(int id, String title, String name, String bio, String[] availableDays){
            this.id = id;
            this.title = title;
            this.name = name;
            this.bio = bio;
            this.availableDays = availableDays;
            
        }


    }
}
