package hu.nemaberci;

import hu.nemaberci.api.*;
import hu.nemaberci.regex.api.RegexParser;
import hu.nemaberci.regex.container.RegexParserContainer;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.LongUnaryOperator;
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
        final int strLength = 10_000_000;
        final int runs = 15;
        final int warmupRuns = 10;
        final boolean printRunTimes = true;
        final boolean printInputString = false;
        final boolean checkResult = false;
        double[] roundTimesGenerated = new double[rounds];
        double[] roundTimesBuiltin = new double[rounds];
        for (int j = 0; j < rounds; j++) {
            String testString = generateInputForTestCase1(random, strLength);
            Pattern pattern1 = checkResult(
                REGEX_PATTERN1, testString,
                RegexParserContainer.getImplementation(TestRegexParser1.class),
                checkResult
            );
            long[] times = new long[warmupRuns + runs];
            runJavaRegexParser(
                runs, warmupRuns, printRunTimes, roundTimesBuiltin, j, testString, pattern1, times);
            runGeneratedRegexParser(
                printRunTimes, warmupRuns, runs,
                RegexParserContainer.getImplementation(TestRegexParser1.class),
                testString, times, roundTimesGenerated, j
            );
            if (printInputString) {
                System.out.println(testString);
            }
        }
        printResult(roundTimesGenerated, roundTimesBuiltin);
        roundTimesGenerated = new double[rounds];
        roundTimesBuiltin = new double[rounds];
        for (int j = 0; j < rounds; j++) {
            String testString = generateInputForTestCase2(random, strLength);
            Pattern pattern = checkResult(
                REGEX_PATTERN2, testString,
                RegexParserContainer.getImplementation(TestRegexParser2.class),
                checkResult
            );
            long[] times = new long[warmupRuns + runs];
            runJavaRegexParser(
                runs, warmupRuns, printRunTimes, roundTimesBuiltin, j, testString, pattern, times);
            runGeneratedRegexParser(
                printRunTimes, warmupRuns, runs,
                RegexParserContainer.getImplementation(TestRegexParser2.class),
                testString, times, roundTimesGenerated, j
            );
            if (printInputString) {
                System.out.println(testString);
            }
        }
        printResult(roundTimesGenerated, roundTimesBuiltin);
        roundTimesGenerated = new double[rounds];
        roundTimesBuiltin = new double[rounds];
        for (int j = 0; j < rounds; j++) {
            String testString = generateInputForTestCase3(random, strLength);
            Pattern pattern = checkResult(
                REGEX_PATTERN3, testString,
                RegexParserContainer.getImplementation(TestRegexParser3.class),
                checkResult
            );
            long[] times = new long[warmupRuns + runs];
            runJavaRegexParser(
                runs, warmupRuns, printRunTimes, roundTimesBuiltin, j, testString, pattern, times);
            runGeneratedRegexParser(
                printRunTimes, warmupRuns, runs,
                RegexParserContainer.getImplementation(TestRegexParser3.class),
                testString, times, roundTimesGenerated, j
            );
            if (printInputString) {
                System.out.println(testString);
            }
        }
        printResult(roundTimesGenerated, roundTimesBuiltin);
        roundTimesGenerated = new double[rounds];
        roundTimesBuiltin = new double[rounds];
        for (int j = 0; j < rounds; j++) {
            String testString = generateInputForTestCase4(random, strLength);
            Pattern pattern = checkResult(
                REGEX_PATTERN4, testString,
                RegexParserContainer.getImplementation(TestRegexParser4.class),
                checkResult
            );
            long[] times = new long[warmupRuns + runs];
            runJavaRegexParser(
                runs, warmupRuns, printRunTimes, roundTimesBuiltin, j, testString, pattern, times);
            runGeneratedRegexParser(
                printRunTimes, warmupRuns, runs,
                RegexParserContainer.getImplementation(TestRegexParser4.class),
                testString, times, roundTimesGenerated, j
            );
            if (printInputString) {
                System.out.println(testString);
            }
        }
        printResult(roundTimesGenerated, roundTimesBuiltin);
        roundTimesGenerated = new double[rounds];
        roundTimesBuiltin = new double[rounds];
        for (int j = 0; j < rounds; j++) {
            String testString = generateInputForTestCase5(random, strLength);
            Pattern pattern = checkResult(
                REGEX_PATTERN5, testString,
                RegexParserContainer.getImplementation(TestRegexParser5.class),
                checkResult
            );
            long[] times = new long[warmupRuns + runs];
            runJavaRegexParser(
                runs, warmupRuns, printRunTimes, roundTimesBuiltin, j, testString, pattern, times);
            runGeneratedRegexParser(
                printRunTimes, warmupRuns, runs,
                RegexParserContainer.getImplementation(TestRegexParser5.class),
                testString, times, roundTimesGenerated, j
            );
            if (printInputString) {
                System.out.println(testString);
            }
        }
        printResult(roundTimesGenerated, roundTimesBuiltin);
    }

    private static void printResult(double[] roundTimesGenerated, double[] roundTimesBuiltin) {
        System.out.println(
            "Average of built-in: " + Arrays.stream(roundTimesBuiltin).summaryStatistics()
                .getAverage());
        System.out.println(
            "Average of generated: " + Arrays.stream(roundTimesGenerated).summaryStatistics()
                .getAverage());
    }

    private static String generateInputForTestCase1(Random random, int strLength) {
        var testStringBuilder = new StringBuilder();
        for (int i = 0; i < strLength; i++) {
            testStringBuilder.append((char) ('A' + random.nextInt(26)));
            if (random.nextInt(50) % 50 == 0) {
                testStringBuilder.append(' ');
            }
        }
        return testStringBuilder.toString();
    }

    private static String generateInputForTestCase2(Random random, int strLength) {
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
        return testStringBuilder.toString();
    }

    private static String generateInputForTestCase4(Random random, int strLength) {
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
        return testStringBuilder.toString();
    }

    private static String generateInputForTestCase3(Random random, int strLength) {
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
        return testStringBuilder.toString();
    }

    private static String generateInputForTestCase5(Random random, int strLength) {
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
        return testStringBuilder.toString();
    }

    private static Pattern checkResult(String regexPattern4, String testString,
        RegexParser parser, boolean checkResult
    ) {
        Pattern pattern = Pattern.compile(
            regexPattern4
        );
        if (checkResult) {
            var test = pattern.matcher(testString);
            var testResults = test.results().map(result -> List.of(result.start(), result.end()))
                .collect(Collectors.toList());
            var resultsMatch = testResults.equals(
                parser
                    .findMatches(testString).getMatches().stream()
                    .map(result -> List.of(result.getStart(), result.getEnd()))
                    .collect(Collectors.toList()));
            System.out.println(
                "Matches are " + testResults.size() + " and "
                    + parser
                    .findMatches(testString)
                    .getMatches().stream()
                    .map(result -> List.of(result.getStart(), result.getEnd()))
                    .collect(Collectors.toList()).size());
            System.out.println("Results match:");
            System.out.println(resultsMatch);
        }
        return pattern;
    }

    private static void runGeneratedRegexParser(boolean printRunTimes, int warmupRuns, int runs,
        RegexParser parser, String testString, long[] times, double[] roundTimesGenerated, int j
    ) {
        for (int i = 0; i < warmupRuns + runs; i++) {
            var start = System.nanoTime();
            var res = parser
                .findMatches(testString).getMatches().stream()
                .map(result -> List.of(result.getStart(), result.getEnd()))
                .collect(Collectors.toList()).size();
            times[i] = (System.nanoTime() - start) / 1_000_000;
        }
        if (printRunTimes) {
            System.out.println(
                Arrays.stream(times).mapToObj(Long::toString).collect(Collectors.joining(",")));
        }
        roundTimesGenerated[j] = Arrays.stream(times).skip(warmupRuns).summaryStatistics().getAverage();
    }

    private static void runJavaRegexParser(int runs, int warmupRuns, boolean printRunTimes,
        double[] roundTimesBuiltin, int j, String testString, Pattern pattern, long[] times
    ) {
        for (int i = 0; i < runs + warmupRuns; i++) {
            var start = System.nanoTime();
            var matcher = pattern.matcher(testString);
            var res = matcher.results().map(result -> List.of(result.start(), result.end()))
                .collect(Collectors.toList()).size();
            times[i] = (System.nanoTime() - start) / 1_000_000;
        }
        if (printRunTimes) {
            System.out.println(
                Arrays.stream(times).mapToObj(Long::toString).collect(Collectors.joining(",")));
        }
        roundTimesBuiltin[j] = Arrays.stream(times).skip(warmupRuns).summaryStatistics().getAverage();
    }

}
