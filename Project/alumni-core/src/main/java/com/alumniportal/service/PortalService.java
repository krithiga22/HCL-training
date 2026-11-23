package com.alumniportal.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.alumniportal.constants.Constants;
import com.alumniportal.exception.AlumniNotVerifiedException;
import com.alumniportal.exception.InvalidDonationAmountException;
import com.alumniportal.model.AlumniProfile;
import com.alumniportal.model.Event;
import com.alumniportal.model.Job;
import com.alumniportal.model.MentorshipRequest;

public class PortalService {

    // 1. Map for fast O(1) lookup of alumni by ID
    private final Map<Integer, AlumniProfile> alumniMap = new HashMap<>();

    // 2. List to store jobs chronologically
    private final List<Job> jobList = new ArrayList<>();

    // 3. Map to store events by ID (each event holds a Set of RSVPs internally)
    private final Map<Integer, Event> eventMap = new HashMap<>();

    // 4. Queue (FIFO) to manage incoming mentorship requests
    private final Queue<MentorshipRequest> mentorshipQueue = new LinkedList<>();

    // 5. List to record successful donations
    private final List<Double> donationHistory = new ArrayList<>();

    // --- ALUMNI METHODS ---
    public void registerAlumni(AlumniProfile profile) {
        alumniMap.put(profile.getProfileId(), profile);
    }

    public AlumniProfile getAlumni(int profileId) {
        return alumniMap.get(profileId);
    }

    // --- JOB POSTING (Checks Alumni Verification Status) ---
    public void postJob(int alumniProfileId, Job job) {
        AlumniProfile alumni = alumniMap.get(alumniProfileId);
        if (alumni == null) {
            throw new IllegalArgumentException("Alumni profile not found with ID: " + alumniProfileId);
        }

        if (!Constants.STATUS_VERIFIED.equalsIgnoreCase(alumni.getVerificationStatus())) {
            throw new AlumniNotVerifiedException(
                "Posting rejected: Alumnus (ID: " + alumniProfileId + ") status is '" +
                alumni.getVerificationStatus() + "'. Only VERIFIED alumni can post jobs."
            );
        }

        jobList.add(job);
    }

    public List<Job> getAllJobs() {
        return Collections.unmodifiableList(jobList);
    }

    // --- EVENTS & RSVP (Uses Set inside Event to guard duplicates & capacity) ---
    public void createEvent(Event event) {
        eventMap.put(event.getEventId(), event);
    }

    public Event getEvent(int eventId) {
        return eventMap.get(eventId);
    }

    public void rsvpEvent(int eventId, int userId) {
        Event event = eventMap.get(eventId);
        if (event == null) {
            throw new IllegalArgumentException("Event not found with ID: " + eventId);
        }
        // Event checks duplicate RSVP and capacity in its internal Set
        event.registerRsvp(userId);
    }

    // --- MENTORSHIP REQUESTS (Queue - FIFO processing) ---
    public void enqueueMentorshipRequest(MentorshipRequest request) {
        mentorshipQueue.offer(request);
    }

    public MentorshipRequest processNextMentorshipRequest() {
        return mentorshipQueue.poll();
    }

    public int getPendingMentorshipCount() {
        return mentorshipQueue.size();
    }

    // --- DONATIONS (Validates amount > 0) ---
    public void processDonation(int donorUserId, double amount) {
        if (amount <= 0) {
            throw new InvalidDonationAmountException(amount);
        }
        donationHistory.add(amount);
    }

    public double getTotalDonations() {
        return donationHistory.stream().mapToDouble(Double::doubleValue).sum();
    }
}
