package edu.project3;

import java.util.HashMap;
import java.util.Map;
import edu.project3.Analyzer.Analyzer;
import edu.project3.Entities.CustomLogReport;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Project3Test {
    @Test
    public void testAnalyzerAverageResponseSizeWithoutFilter() {
        Map<String, String> params = new HashMap<>();
        params.put("--path", "src/test/java/edu/project3/TestCases/withoutFilters.log");

        Analyzer analyzer = new Analyzer(params);
        CustomLogReport report = analyzer.getCustomLogRecord();

        assertEquals(490, report.getAverageResponseSize());
    }

    @Test
    public void testAnalyzerAverageResponseCodesWithoutFilter() {
        Map<String, String> params = new HashMap<>();
        params.put("--path", "src/test/java/edu/project3/TestCases/withoutFilters.log");

        Analyzer analyzer = new Analyzer(params);
        CustomLogReport report = analyzer.getCustomLogRecord();

        Map<Integer, Integer> responseCodes = report.getResponseCodes();
        Map<Integer, Integer> expectedResponseCodes = new HashMap<>();
        expectedResponseCodes.put(200, 2);

        for (Integer key : responseCodes.keySet()) {
            assertEquals(expectedResponseCodes.get(key), responseCodes.get(key));
        }
    }

    @Test
    public void testAnalyzerRequestedResourcesWithoutFilter() {
        Map<String, String> params = new HashMap<>();
        params.put("--path", "src/test/java/edu/project3/TestCases/withoutFilters.log");

        Analyzer analyzer = new Analyzer(params);
        CustomLogReport report = analyzer.getCustomLogRecord();

        Map<String, Integer> requestedResources = report.getRequestedResources();
        Map<String, Integer> expectedRequestedResources = new HashMap<>();
        expectedRequestedResources.put("/downloads/product_1", 1);
        expectedRequestedResources.put("/downloads/product_2", 1);

        for (String key : requestedResources.keySet()) {
            assertEquals(expectedRequestedResources.get(key), requestedResources.get(key));
        }
    }

    @Test
    public void testAnalyzerTotalRequestsWithoutFilters() {
        Map<String, String> params = new HashMap<>();
        params.put("--path", "src/test/java/edu/project3/TestCases/withoutFilters.log");

        Analyzer analyzer = new Analyzer(params);
        CustomLogReport report = analyzer.getCustomLogRecord();
        long totalRequests = report.getTotalRequests();

        assertEquals(2, totalRequests);
    }

    // Test group with filters by date
    @Test
    public void testAnalyzerAverageResponseSizeWithFilter() {
        Map<String, String> params = new HashMap<>();
        params.put("--path", "src/test/java/edu/project3/TestCases/withFilters.log");
        params.put("--from", "2015-05-16");
        params.put("--to", "2015-05-18");

        Analyzer analyzer = new Analyzer(params);
        CustomLogReport report = analyzer.getCustomLogRecord();

        assertEquals(270, report.getAverageResponseSize());
    }

    @Test
    public void testAnalyzerAverageResponseCodesWithFilter() {
        Map<String, String> params = new HashMap<>();
        params.put("--path", "src/test/java/edu/project3/TestCases/withFilters.log");
        params.put("--from", "2015-05-16");
        params.put("--to", "2015-05-18");

        Analyzer analyzer = new Analyzer(params);
        CustomLogReport report = analyzer.getCustomLogRecord();

        Map<Integer, Integer> responseCodes = report.getResponseCodes();
        Map<Integer, Integer> expectedResponseCodes = new HashMap<>();
        expectedResponseCodes.put(200, 1);
        expectedResponseCodes.put(300, 1);
        expectedResponseCodes.put(400, 1);
        expectedResponseCodes.put(500, 1);

        for (Integer key : responseCodes.keySet()) {
            assertEquals(expectedResponseCodes.get(key), responseCodes.get(key));
        }
    }

    @Test
    public void testAnalyzerRequestedResourcesWithFilter() {
        Map<String, String> params = new HashMap<>();
        params.put("--path", "src/test/java/edu/project3/TestCases/withFilters.log");
        params.put("--from", "2015-05-16");
        params.put("--to", "2015-05-18");

        Analyzer analyzer = new Analyzer(params);
        CustomLogReport report = analyzer.getCustomLogRecord();

        Map<String, Integer> requestedResources = report.getRequestedResources();
        Map<String, Integer> expectedRequestedResources = new HashMap<>();
        expectedRequestedResources.put("/downloads/product_1", 1);
        expectedRequestedResources.put("/downloads/product_2", 1);
        expectedRequestedResources.put("/downloads/product_3", 1);
        expectedRequestedResources.put("/downloads/product_4", 1);

        for (String key : requestedResources.keySet()) {
            assertEquals(expectedRequestedResources.get(key), requestedResources.get(key));
        }
    }

    @Test
    public void testAnalyzerTotalRequestsWithFilters() {
        Map<String, String> params = new HashMap<>();
        params.put("--path", "src/test/java/edu/project3/TestCases/withFilters.log");
        params.put("--from", "2015-05-16");
        params.put("--to", "2015-05-18");

        Analyzer analyzer = new Analyzer(params);
        CustomLogReport report = analyzer.getCustomLogRecord();


        long totalRequests = report.getTotalRequests();

        assertEquals(4, totalRequests);
    }
}
