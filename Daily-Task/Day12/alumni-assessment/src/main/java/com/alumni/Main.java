
package com.alumni;

import com.alumni.model.*;
import com.alumni.service.AlumniService;
import com.alumni.exception.AlumniNotFoundException;
import com.alumni.exception.DuplicateAlumniException;

public class Main {

    public static void main(String[] args) {

        AlumniService service = new AlumniService();

        Alumni alumni1 = new Alumni(
                "A101", "Arun", "arun@gmail.com",
                "2020", "IT", "Google"
        );

        Alumni alumni2 = new Alumni(
                "A102", "Priya", "priya@gmail.com",
                "2021", "CSE", "Infosys"
        );

        // 1. Add alumni
        service.addAlumni(alumni1);
        service.addAlumni(alumni2);

        // 2. Display all alumni
        System.out.println("\n--- ALL ALUMNI ---");

        for (Alumni alumni : service.getAllAlumni()) {
            alumni.displayDetails();
        }

        // 3. Search alumni
        System.out.println("\n--- SEARCH ALUMNI ---");

        try {
            Alumni result = service.findAlumni("A101");
            result.displayDetails();

        } catch (AlumniNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 4. Test duplicate ID
        System.out.println("\n--- DUPLICATE TEST ---");

        try {
            Alumni duplicate = new Alumni(
                    "A101", "Another Person", "another@gmail.com",
                    "2022", "IT", "TCS"
            );

            service.addAlumni(duplicate);

        } catch (DuplicateAlumniException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 5. Test missing alumni
        System.out.println("\n--- NOT FOUND TEST ---");

        try {
            service.findAlumni("A999");

        } catch (AlumniNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 6. Remove alumni
        System.out.println("\n--- REMOVE TEST ---");

        try {
            service.removeAlumni("A102");

        } catch (AlumniNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nRemaining alumni: "
                + service.getAllAlumni().size());
    }
}
