
package com.alumni.service;

import com.alumni.model.Alumni;
import com.alumni.exception.AlumniNotFoundException;
import com.alumni.exception.DuplicateAlumniException;
import com.alumni.repository.AlumniRepository;
import java.util.ArrayList;
import java.util.List;

public class AlumniService {

    private final AlumniRepository alumniRepository = new AlumniRepository();

    // Add alumni
    public void addAlumni(Alumni alumni) {

        if (alumni == null) {
            throw new IllegalArgumentException("Alumni cannot be null");
        }

        if (findByIdInternal(alumni.getUserId()) != null) {
            throw new DuplicateAlumniException(
                    "Alumni ID already exists: " + alumni.getUserId()
            );
        }

        alumniRepository.save(alumni);
        System.out.println("Alumni added successfully!");
    }

    // Search alumni
    public Alumni findAlumni(String alumniId)
            throws AlumniNotFoundException {

        if (alumniId == null || alumniId.isBlank()) {
            throw new IllegalArgumentException("Alumni ID cannot be empty");
        }

        Alumni alumni = findByIdInternal(alumniId);

        if (alumni == null) {
            throw new AlumniNotFoundException(
                    "Alumni not found: " + alumniId
            );
        }

        return alumni;
    }

    // Internal lookup
private Alumni findByIdInternal(String alumniId) {

    if (alumniId == null) {
        return null;
    }

    return alumniRepository.findById(alumniId.trim())
            .orElseGet(() ->
                    alumniRepository.findAll().stream()
                            .filter(a -> a.getUserId()
                                    .equalsIgnoreCase(alumniId.trim()))
                            .findFirst()
                            .orElse(null)
            );
}

    // Display all alumni
   public List<Alumni> getAllAlumni() {
    return alumniRepository.findAll();
}
    // Remove alumni
    public void removeAlumni(String alumniId)
            throws AlumniNotFoundException {

        Alumni alumni = findAlumni(alumniId);
        alumniRepository.deleteById(alumni.getUserId());
        System.out.println("Alumni removed successfully!");
    }
}
