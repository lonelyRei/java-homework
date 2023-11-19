package edu.project3.Entities;

import java.time.LocalDate;
import java.util.Map;

public class CustomLogReport {
    private LocalDate fromDate;
    private LocalDate toDate;
    private long totalRequests;
    private int averageResponseSize;
    private Map<String, Integer> requestedResources;
    private Map<Integer, Integer> responseCodes;

    public CustomLogReport(
        LocalDate fromDate,
        LocalDate toDate,
        long totalRequests,
        int averageResponseSize,
        Map<String, Integer> requestedResources,
        Map<Integer, Integer> responseCodes
    ) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.totalRequests = totalRequests;
        this.averageResponseSize = averageResponseSize;
        this.requestedResources = requestedResources;
        this.responseCodes = responseCodes;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public long getTotalRequests() {
        return totalRequests;
    }

    public void setTotalRequests(int totalRequests) {
        this.totalRequests = totalRequests;
    }

    public int getAverageResponseSize() {
        return averageResponseSize;
    }

    public void setAverageResponseSize(int averageResponseSize) {
        this.averageResponseSize = averageResponseSize;
    }

    public Map<String, Integer> getRequestedResources() {
        return requestedResources;
    }

    public void setRequestedResources(Map<String, Integer> requestedResources) {
        this.requestedResources = requestedResources;
    }

    public Map<Integer, Integer> getResponseCodes() {
        return responseCodes;
    }

    public void setResponseCodes(Map<Integer, Integer> responseCodes) {
        this.responseCodes = responseCodes;
    }
}
