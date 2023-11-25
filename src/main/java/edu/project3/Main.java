package edu.project3;

import edu.project3.Analyzer.Analyzer;
import edu.project3.Entities.CustomLogReport;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private Main() {

    }

    @SuppressWarnings("RegexpSinglelineJava")
    public static void main(String[] args) {
        Analyzer analyzer = new Analyzer(getStartParameters(args));

        // Генерируем вывод
        String output = generateOutput(analyzer.getCustomLogRecord(), null);

        // Выводим информацию
        System.out.println(output);
    }

    @SuppressWarnings("ModifiedControlVariable")
    private static HashMap<String, String> getStartParameters(String[] args) {
        HashMap<String, String> startParameters = new HashMap<>();
        startParameters.put("--path", null);
        startParameters.put("--format", null);
        startParameters.put("--from", null);
        startParameters.put("--to", null);

        for (int i = 0; i < args.length; i++) {
            if (startParameters.containsKey(args[i])) {
                if (i + 1 < args.length) {
                    startParameters.put(args[i], args[i + 1]);
                    i++;
                }
            }
        }

        return startParameters;
    }

    // todo: Add work with format
    @SuppressWarnings("MultipleStringLiterals")
    private static String generateOutput(CustomLogReport report, String format) {
        StringBuilder result = new StringBuilder();

        result.append("Дата начала: " + report.getFromDate() + "\n");
        result.append("Дата конца: " + report.getToDate() + "\n");
        result.append("Общее количество запросов: " + report.getTotalRequests() + "\n");
        result.append("Наиболее часто запрашиваемые ресурсы: \n");

        Map<String, Integer> resources = report.getRequestedResources();
        for (String key : resources.keySet()) {
            result.append(key + " - " + resources.get(key) + "\n");
        }

        result.append("Наиболее часто встречающиеся коды ответов: \n");

        Map<Integer, Integer> codes = report.getResponseCodes();
        for (Integer key : codes.keySet()) {
            result.append(key + " - " + resources.get(key) + "\n");
        }

        result.append("Средний размер ответа: " + report.getAverageResponseSize());

        return result.toString();
    }
}
