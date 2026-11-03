
package com.alumni.service;

import com.alumni.model.MentorshipRequest;

import java.util.*;

public class MentorshipService {

    private final Map<String, MentorshipRequest> requests = new HashMap<>();

    private final Queue<String> pendingRequests = new ArrayDeque<>();

    private final Set<String> processedRequests = new HashSet<>();

    // Student submits a mentorship request
    public void submitRequest(MentorshipRequest request) {

        if (request == null) {
            throw new IllegalArgumentException(
                    "Request cannot be null"
            );
        }

        String requestId = request.getRequestId();

        if (requestId == null || requestId.isBlank()) {
            throw new IllegalArgumentException(
                    "Request ID cannot be empty"
            );
        }

        requestId = requestId.trim();

        if (requests.containsKey(requestId)) {
            throw new IllegalArgumentException(
                    "Duplicate request ID: " + requestId
            );
        }

        requests.put(requestId, request);
        pendingRequests.offer(requestId);

        System.out.println("Mentorship request submitted!");
    }

    // Alumni accepts a request
    public void acceptRequest(String requestId) {
        processRequest(requestId, "ACCEPTED");
    }

    // Alumni rejects a request
    public void rejectRequest(String requestId) {
        processRequest(requestId, "REJECTED");
    }

    private void processRequest(String requestId, String status) {

        if (requestId == null || requestId.isBlank()) {
            throw new IllegalArgumentException(
                    "Request ID cannot be empty"
            );
        }

        requestId = requestId.trim();

        MentorshipRequest request = requests.get(requestId);

        if (request == null) {
            throw new IllegalArgumentException(
                    "Mentorship request not found: " + requestId
            );
        }

        if (processedRequests.contains(requestId)) {
            throw new IllegalStateException(
                    "Request has already been processed"
            );
        }

        request.setStatus(status);
        processedRequests.add(requestId);
        pendingRequests.remove(requestId);

        System.out.println("Request " + requestId + " " + status);
    }

    // Display all requests
    public List<MentorshipRequest> getAllRequests() {
        return List.copyOf(requests.values());
    }

    // Display pending requests in FIFO order
    public void displayPendingRequests() {

        System.out.println("\n--- PENDING REQUESTS ---");

        for (String id : pendingRequests) {
            System.out.println(requests.get(id));
        }
    }

    public int getPendingCount() {
        return pendingRequests.size();
    }
}
