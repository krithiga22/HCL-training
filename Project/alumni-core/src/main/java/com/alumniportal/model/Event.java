package com.alumniportal.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.alumniportal.exception.DuplicateRsvpException;
import com.alumniportal.exception.EventCapacityExceededException;

public class Event extends BaseEntity {

    private int eventId;
    private String title;
    private String description;
    private String location;
    private int capacity;
    private Set<Integer> rsvpUserIds;

    public Event(int eventId, String title, String description, String location, int capacity) {
        super((long) eventId);
        this.eventId = eventId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.capacity = capacity;
        this.rsvpUserIds = new HashSet<>();
    }

    public synchronized void registerRsvp(int userId) {
        if (rsvpUserIds.contains(userId)) {
            throw new DuplicateRsvpException(
                "Registration failed: User (ID: " + userId + ") has already RSVP'd for event '" + title + "'."
            );
        }
        if (rsvpUserIds.size() >= capacity) {
            throw new EventCapacityExceededException(
                "Registration failed: Event '" + title + "' is full. Capacity reached: " + capacity
            );
        }
        rsvpUserIds.add(userId);
    }

    public int getEventId() {
        return eventId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getRegisteredCount() {
        return rsvpUserIds.size();
    }

    public Set<Integer> getRsvpUserIds() {
        return Collections.unmodifiableSet(rsvpUserIds);
    }
}
