package hu.nemaberci;

import hu.nemaberci.api.*;
import hu.nemaberci.regex.container.RegexParserContainer;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestMain {

    public static final String REGEX_PATTERN1 = ".{5,32} ";
    public static final String REGEX_PATTERN2 = "([a-fA-F0-9]{8}:){3}[a-fA-F0-9]{8}";
    public static final String REGEX_PATTERN3 = ".{2,6}[^A-Z]{5,8}ABCD";
    public static final String REGEX_PATTERN4 = "AB[A-Z]{2,5}[a-z]{2,5}C";
    public static final String REGEX_PATTERN5 = ".{0,30}ABCDE";

    public static void main(String[] args) {
        Random random = new Random();
        final int rounds = 10;
        final int strLength = 20_000_000;
        final int runs = 15;
        final int warmupRuns = 10;
        double[] roundTimesGenerated = new double[rounds];
        double[] roundTimesBuiltin = new double[rounds];
        for (int j = 0; j < rounds; j++) {
            var testStringBuilder = new StringBuilder();
            for (int i = 0; i < strLength; i++) {
                testStringBuilder.append((char) ('A' + random.nextInt(26)));
                if (random.nextInt(50) % 50 == 0) {
                    testStringBuilder.append(' ');
                }
            }
            var testString = testStringBuilder.toString();
            Pattern pattern1 = Pattern.compile(
                REGEX_PATTERN1
            );
            var test = pattern1.matcher(testString);
            var testResults = test.results().map(result -> List.of(result.start(), result.end()))
                .collect(Collectors.toList());
            var resultsMatch = testResults.equals(
                RegexParserContainer.getImplementation(TestRegexParser1.class)
                    .findMatches(testString).getMatches().stream()
                    .map(result -> List.of(result.getStart(), result.getEnd()))
                    .collect(Collectors.toList()));
            System.out.println(
                "Matches are " + testResults.size() + " and "
                    + RegexParserContainer.getImplementation(TestRegexParser1.class)
                    .findMatches(testString)
                    .getMatches().stream()
                    .map(result -> List.of(result.getStart(), result.getEnd()))
                    .collect(Collectors.toList()).size());
            System.out.println("Results match:");
            System.out.println(resultsMatch);
            long[] times = new long[runs];
            //System.out.println("Java regex compiler:");
            for (int i = 0; i < runs + warmupRuns; i++) {
                if (i >= warmupRuns) {
                    var start = System.nanoTime();
                    var matcher = pattern1.matcher(testString);
                    //System.out.println(
                    matcher.results().map(result -> List.of(result.start(), result.end()))
                        .collect(Collectors.toList()).size();
                    //System.out.println(
                    //    "Time: " + (System.nanoTime() - start) / 1_000_000 + " millis");
                    times[i - warmupRuns] = (System.nanoTime() - start) / 1_000_000;
                }
            }
            //System.out.println("Min: " + Arrays.stream(times).summaryStatistics().getMin());
            //System.out.println("Max: " + Arrays.stream(times).summaryStatistics().getMax());
            //System.out.println("Average: " + Arrays.stream(times).summaryStatistics().getAverage());
            roundTimesBuiltin[j] = Arrays.stream(times).summaryStatistics().getAverage();
            //System.out.println("Pre-generated regex parser:");
            for (int i = 0; i < warmupRuns + runs; i++) {
                if (i >= warmupRuns) {
                    var start = System.nanoTime();
                    RegexParserContainer.getImplementation(TestRegexParser1.class)
                        .findMatches(testString).getMatches().stream()
                        .map(result -> List.of(result.getStart(), result.getEnd()))
                        .collect(Collectors.toList()).size();
                    //System.out.println(
                    //    "Time: " + (System.nanoTime() - start) / 1_000_000 + " millis");
                    times[i - warmupRuns] = (System.nanoTime() - start) / 1_000_000;
                }
            }
            // System.out.println("Min: " + Arrays.stream(times).summaryStatistics().getMin());
            // System.out.println("Max: " + Arrays.stream(times).summaryStatistics().getMax());
            // System.out.println("Average: " + Arrays.stream(times).summaryStatistics().getAverage());
            //System.out.println(testString);
            roundTimesGenerated[j] = Arrays.stream(times).summaryStatistics().getAverage();
        }
        System.out.println(
            "Average of built-in: " + Arrays.stream(roundTimesBuiltin).summaryStatistics()
                .getAverage());
        System.out.println(
            "Average of generated: " + Arrays.stream(roundTimesGenerated).summaryStatistics()
                .getAverage());
        roundTimesGenerated = new double[rounds];
        roundTimesBuiltin = new double[rounds];
        for (int j = 0; j < rounds; j++) {
            var testStringBuilder = new StringBuilder();
            for (int i = 0; i < strLength; i++) {
                switch (random.nextInt(3)) {
                    case 0:
                        testStringBuilder.append((char) ('A' + random.nextInt(6)));
                        break;
                    case 1:
                        testStringBuilder.append((char) ('a' + random.nextInt(6)));
                        break;
                    default:
                        testStringBuilder.append((char) ('0' + random.nextInt(10)));
                }
                if (i % 8 == 0 && random.nextBoolean()) {
                    testStringBuilder.append(':');
                }
            }
            var testString = testStringBuilder.toString();
            Pattern pattern = Pattern.compile(
                REGEX_PATTERN2
            );
            var test = pattern.matcher(testString);
            var testResults = test.results().map(result -> List.of(result.start(), result.end()))
                .collect(Collectors.toList());
            var resultsMatch = testResults.equals(
                RegexParserContainer.getImplementation(TestRegexParser2.class)
                    .findMatches(testString).getMatches().stream()
                    .map(result -> List.of(result.getStart(), result.getEnd()))
                    .collect(Collectors.toList()));
            System.out.println(
                "Matches are " + testResults.size() + " and "
                   + RegexParserContainer.getImplementation(TestRegexParser2.class)
                   .findMatches(testString)
                   .getMatches().stream()
                    .map(result -> List.of(result.getStart(), result.getEnd()))
                    .collect(Collectors.toList()).size());
            System.out.println("Results match:");
            System.out.println(resultsMatch);
            long[] times = new long[runs];
            //System.out.println("Java regex compiler:");
            for (int i = 0; i < runs + warmupRuns; i++) {
                if (i >= warmupRuns) {
                    var start = System.nanoTime();
                    var matcher = pattern.matcher(testString);
                    //System.out.println(
                    matcher.results().map(result -> List.of(result.start(), result.end()))
                        .collect(Collectors.toList()).size();
                    //System.out.println(
                    //    "Time: " + (System.nanoTime() - start) / 1_000_000 + " millis");
                    times[i - warmupRuns] = (System.nanoTime() - start) / 1_000_000;
                }
            }
            //System.out.println("Min: " + Arrays.stream(times).summaryStatistics().getMin());
            //System.out.println("Max: " + Arrays.stream(times).summaryStatistics().getMax());
            //System.out.println("Average: " + Arrays.stream(times).summaryStatistics().getAverage());
            roundTimesBuiltin[j] = Arrays.stream(times).summaryStatistics().getAverage();
            //System.out.println("Pre-generated regex parser:");
            for (int i = 0; i < warmupRuns + runs; i++) {
                if (i >= warmupRuns) {
                    var start = System.nanoTime();
                    //System.out.println(
                    RegexParserContainer.getImplementation(TestRegexParser2.class)
                        .findMatches(testString).getMatches().stream()
                        .map(result -> List.of(result.getStart(), result.getEnd()))
                        .collect(Collectors.toList()).size();
                    //System.out.println(
                    //    "Time: " + (System.nanoTime() - start) / 1_000_000 + " millis");
                    times[i - warmupRuns] = (System.nanoTime() - start) / 1_000_000;
                }
            }
            //System.out.println("Min: " + Arrays.stream(times).summaryStatistics().getMin());
            //System.out.println("Max: " + Arrays.stream(times).summaryStatistics().getMax());
            //System.out.println("Average: " + Arrays.stream(times).summaryStatistics().getAverage());
            //System.out.println(testString);
            roundTimesGenerated[j] = Arrays.stream(times).summaryStatistics().getAverage();
        }
        System.out.println(
            "Average of built-in: " + Arrays.stream(roundTimesBuiltin).summaryStatistics()
                .getAverage());
        System.out.println(
            "Average of generated: " + Arrays.stream(roundTimesGenerated).summaryStatistics()
                .getAverage());
        roundTimesGenerated = new double[rounds];
        roundTimesBuiltin = new double[rounds];
        for (int j = 0; j < rounds; j++) {
            var testStringBuilder = new StringBuilder();
            for (int i = 0; i < strLength; i++) {
                if (random.nextBoolean()) {
                    testStringBuilder.append((char) ('A' + random.nextInt(26)));
                } else {
                    testStringBuilder.append((char) ('a' + random.nextInt(26)));
                }
                if (random.nextInt(20) % 50 == 0) {
                    testStringBuilder.append("ABCD");
                }
            }
            var testString = testStringBuilder.toString();
            Pattern pattern = Pattern.compile(
                REGEX_PATTERN3
            );
            var test = pattern.matcher(testString);
            var testResults = test.results().map(result -> List.of(result.start(), result.end()))
                .collect(Collectors.toList());
            var resultsMatch = testResults.equals(
                RegexParserContainer.getImplementation(TestRegexParser3.class)
                    .findMatches(testString).getMatches().stream()
                    .map(result -> List.of(result.getStart(), result.getEnd()))
                    .collect(Collectors.toList()));
            System.out.println(
                "Matches are " + testResults.size() + " and "
                    + RegexParserContainer.getImplementation(TestRegexParser3.class)
                    .findMatches(testString)
                    .getMatches().stream()
                    .map(result -> List.of(result.getStart(), result.getEnd()))
                    .collect(Collectors.toList()).size());
            System.out.println("Results match:");
            System.out.println(resultsMatch);
            long[] times = new long[runs];
            //System.out.println("Java regex compiler:");
            for (int i = 0; i < runs + warmupRuns; i++) {
                if (i >= warmupRuns) {
                    var start = System.nanoTime();
                    var matcher = pattern.matcher(testString);
                    //System.out.println(
                    matcher.results().map(result -> List.of(result.start(), result.end()))
                        .collect(Collectors.toList()).size();
                    //System.out.println(
                    //    "Time: " + (System.nanoTime() - start) / 1_000_000 + " millis");
                    times[i - warmupRuns] = (System.nanoTime() - start) / 1_000_000;
                }
            }
            //System.out.println("Min: " + Arrays.stream(times).summaryStatistics().getMin());
            //System.out.println("Max: " + Arrays.stream(times).summaryStatistics().getMax());
            //System.out.println("Average: " + Arrays.stream(times).summaryStatistics().getAverage());
            roundTimesBuiltin[j] = Arrays.stream(times).summaryStatistics().getAverage();
            //System.out.println("Pre-generated regex parser:");
            for (int i = 0; i < warmupRuns + runs; i++) {
                if (i >= warmupRuns) {
                    var start = System.nanoTime();
                    //System.out.println(
                    RegexParserContainer.getImplementation(TestRegexParser3.class)
                        .findMatches(testString).getMatches().stream()
                        .map(result -> List.of(result.getStart(), result.getEnd()))
                        .collect(Collectors.toList()).size();
                    //System.out.println(
                    //    "Time: " + (System.nanoTime() - start) / 1_000_000 + " millis");
                    times[i - warmupRuns] = (System.nanoTime() - start) / 1_000_000;
                }
            }
            //System.out.println("Min: " + Arrays.stream(times).summaryStatistics().getMin());
            //System.out.println("Max: " + Arrays.stream(times).summaryStatistics().getMax());
            //System.out.println("Average: " + Arrays.stream(times).summaryStatistics().getAverage());
            //System.out.println(testString);
            roundTimesGenerated[j] = Arrays.stream(times).summaryStatistics().getAverage();
        }
        System.out.println(
            "Average of built-in: " + Arrays.stream(roundTimesBuiltin).summaryStatistics()
                .getAverage());
        System.out.println(
            "Average of generated: " + Arrays.stream(roundTimesGenerated).summaryStatistics()
                .getAverage());
        roundTimesGenerated = new double[rounds];
        roundTimesBuiltin = new double[rounds];
        for (int j = 0; j < rounds; j++) {
            var testStringBuilder = new StringBuilder();
            for (int i = 0; i < strLength; i++) {
                if (random.nextBoolean()) {
                    testStringBuilder.append((char) ('A' + random.nextInt(26)));
                } else {
                    testStringBuilder.append((char) ('a' + random.nextInt(26)));
                }
                if (i % 10 == 0 && random.nextBoolean()) {
                    testStringBuilder.append("AB");
                }
                if (i % 10 == 9 && random.nextBoolean()) {
                    testStringBuilder.append("C");
                }
            }
            var testString = testStringBuilder.toString();
            Pattern pattern = Pattern.compile(
                REGEX_PATTERN4
            );
            var test = pattern.matcher(testString);
            var testResults = test.results().map(result -> List.of(result.start(), result.end()))
                .collect(Collectors.toList());
            var resultsMatch = testResults.equals(
                RegexParserContainer.getImplementation(TestRegexParser4.class)
                    .findMatches(testString).getMatches().stream()
                    .map(result -> List.of(result.getStart(), result.getEnd()))
                    .collect(Collectors.toList()));
            System.out.println(
                "Matches are " + testResults.size() + " and "
                    + RegexParserContainer.getImplementation(TestRegexParser4.class)
                    .findMatches(testString)
                    .getMatches().stream()
                    .map(result -> List.of(result.getStart(), result.getEnd()))
                    .collect(Collectors.toList()).size());
            System.out.println("Results match:");
            System.out.println(resultsMatch);
            long[] times = new long[runs];
            //System.out.println("Java regex compiler:");
            for (int i = 0; i < runs + warmupRuns; i++) {
                if (i >= warmupRuns) {
                    var start = System.nanoTime();
                    var matcher = pattern.matcher(testString);
                    //System.out.println(
                    matcher.results().map(result -> List.of(result.start(), result.end()))
                        .collect(Collectors.toList()).size();
                    //System.out.println(
                    //    "Time: " + (System.nanoTime() - start) / 1_000_000 + " millis");
                    times[i - warmupRuns] = (System.nanoTime() - start) / 1_000_000;
                }
            }
            //System.out.println("Min: " + Arrays.stream(times).summaryStatistics().getMin());
            //System.out.println("Max: " + Arrays.stream(times).summaryStatistics().getMax());
            //System.out.println("Average: " + Arrays.stream(times).summaryStatistics().getAverage());
            roundTimesBuiltin[j] = Arrays.stream(times).summaryStatistics().getAverage();
            //System.out.println("Pre-generated regex parser:");
            for (int i = 0; i < warmupRuns + runs; i++) {
                if (i >= warmupRuns) {
                    var start = System.nanoTime();
                    //System.out.println(
                    RegexParserContainer.getImplementation(TestRegexParser4.class)
                        .findMatches(testString).getMatches().stream()
                        .map(result -> List.of(result.getStart(), result.getEnd()))
                        .collect(Collectors.toList()).size();
                    //System.out.println(
                    //    "Time: " + (System.nanoTime() - start) / 1_000_000 + " millis");
                    times[i - warmupRuns] = (System.nanoTime() - start) / 1_000_000;
                }
            }
            //System.out.println("Min: " + Arrays.stream(times).summaryStatistics().getMin());
            //System.out.println("Max: " + Arrays.stream(times).summaryStatistics().getMax());
            //System.out.println("Average: " + Arrays.stream(times).summaryStatistics().getAverage());
            //System.out.println(testString);
            roundTimesGenerated[j] = Arrays.stream(times).summaryStatistics().getAverage();
        }
        System.out.println(
            "Average of built-in: " + Arrays.stream(roundTimesBuiltin).summaryStatistics()
                .getAverage());
        System.out.println(
            "Average of generated: " + Arrays.stream(roundTimesGenerated).summaryStatistics()
                .getAverage());
        roundTimesGenerated = new double[rounds];
        roundTimesBuiltin = new double[rounds];
        for (int j = 0; j < rounds; j++) {
            var testStringBuilder = new StringBuilder();
            for (int i = 0; i < strLength; i++) {
                switch (random.nextInt(3)) {
                    case 0:
                        testStringBuilder.append((char) ('A' + random.nextInt(26)));
                        break;
                    case 1:
                        testStringBuilder.append((char) ('a' + random.nextInt(26)));
                        break;
                    default:
                        testStringBuilder.append((char) ('0' + random.nextInt(10)));
                }
                if (random.nextInt(50) == 0) {
                    testStringBuilder.append("ABCDE");
                }
            }
            var testString = testStringBuilder.toString();
            Pattern pattern = Pattern.compile(
                REGEX_PATTERN5
            );
            var test = pattern.matcher(testString);
            var testResults = test.results().map(result -> List.of(result.start(), result.end()))
                .collect(Collectors.toList());
            var resultsMatch = testResults.equals(
                RegexParserContainer.getImplementation(TestRegexParser5.class)
                    .findMatches(testString).getMatches().stream()
                    .map(result -> List.of(result.getStart(), result.getEnd()))
                    .collect(Collectors.toList()));
            System.out.println(
                "Matches are " + testResults.size() + " and "
                    + RegexParserContainer.getImplementation(TestRegexParser5.class)
                    .findMatches(testString)
                    .getMatches().stream()
                    .map(result -> List.of(result.getStart(), result.getEnd()))
                    .collect(Collectors.toList()).size());
            System.out.println("Results match:");
            System.out.println(resultsMatch);
            long[] times = new long[runs];
            //System.out.println("Java regex compiler:");
            for (int i = 0; i < runs + warmupRuns; i++) {
                if (i >= warmupRuns) {
                    var start = System.nanoTime();
                    var matcher = pattern.matcher(testString);
                    matcher.results().map(result -> List.of(result.start(), result.end()))
                        .collect(Collectors.toList()).size();
                    //System.out.println(
                    //    "Time: " + (System.nanoTime() - start) / 1_000_000 + " millis");
                    times[i - warmupRuns] = (System.nanoTime() - start) / 1_000_000;
                }
            }
            //System.out.println("Min: " + Arrays.stream(times).summaryStatistics().getMin());
            //System.out.println("Max: " + Arrays.stream(times).summaryStatistics().getMax());
            //System.out.println("Average: " + Arrays.stream(times).summaryStatistics().getAverage());
            roundTimesBuiltin[j] = Arrays.stream(times).summaryStatistics().getAverage();
            //System.out.println("Pre-generated regex parser:");
            for (int i = 0; i < warmupRuns + runs; i++) {
                if (i >= warmupRuns) {
                    var start = System.nanoTime();
                    RegexParserContainer.getImplementation(TestRegexParser5.class)
                        .findMatches(testString).getMatches().stream()
                        .map(result -> List.of(result.getStart(), result.getEnd()))
                        .collect(Collectors.toList()).size();
                    //System.out.println(
                    //    "Time: " + (System.nanoTime() - start) / 1_000_000 + " millis");
                    times[i - warmupRuns] = (System.nanoTime() - start) / 1_000_000;
                }
            }
            //System.out.println("Min: " + Arrays.stream(times).summaryStatistics().getMin());
            //System.out.println("Max: " + Arrays.stream(times).summaryStatistics().getMax());
            //System.out.println("Average: " + Arrays.stream(times).summaryStatistics().getAverage());
            //System.out.println(testString);
            roundTimesGenerated[j] = Arrays.stream(times).summaryStatistics().getAverage();
        }
        System.out.println(
            "Average of built-in: " + Arrays.stream(roundTimesBuiltin).summaryStatistics()
                .getAverage());
        System.out.println(
            "Average of generated: " + Arrays.stream(roundTimesGenerated).summaryStatistics()
                .getAverage());
    }

}
