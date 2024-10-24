package hu.nemaberci;

import hu.nemaberci.api.*;
import hu.nemaberci.regex.api.RegexParser;
import hu.nemaberci.regex.container.RegexParserContainer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestMain {

    public static final String REGEX_PATTERN1 = ".{5,32} ";
    public static final String REGEX_PATTERN2 = "([a-fA-F0-9]{8}:){3}[a-fA-F0-9]{8}";
    public static final String REGEX_PATTERN3 = ".{2,6}[^A-Z]{5,8}ABCD";
    public static final String REGEX_PATTERN4 = "AB[A-Z]{2,}[a-z]{0,5}C";
    public static final String REGEX_PATTERN5 = ".{0,30}ABCDE";
    public static final String REGEX_PATTERN6 = "[a-f]+[g-q]*([^a-q])?a*";
    public static final String REGEX_PATTERN7 = "AB([A-K]{3,}|[C-Q]{0,7}|[N-Z]+)C";

    public static void main(String[] args) {
        Random random = new Random();
        final int strLength = 25_000_000;
        final int runs = 15;
        final int warmupRuns = 5;
        final boolean printInputString = false;
        final boolean writeInputString = true;
        final boolean checkResult = false;
        final boolean runTests = true;
        final boolean printBuiltIn = false;
        runFirstRegex(runs, random, strLength, runTests, checkResult, warmupRuns, printInputString, writeInputString, printBuiltIn);
        runSecondRegex(runs, random, strLength, runTests, checkResult, warmupRuns, printInputString, writeInputString, printBuiltIn);
        runThirdRegex(runs, random, 10_000_000, runTests, checkResult, warmupRuns, printInputString, writeInputString, printBuiltIn);
        runFourthRegex(runs, random, strLength, runTests, checkResult, warmupRuns, printInputString, writeInputString, printBuiltIn);
        runFifthRegex(runs, random,strLength, runTests, checkResult, warmupRuns, printInputString, writeInputString, printBuiltIn);
        runSixthRegex(runs, random, strLength, runTests, checkResult, warmupRuns, printInputString, writeInputString, printBuiltIn);
        runSeventhRegex(runs, random, strLength, runTests, checkResult, warmupRuns, printInputString, writeInputString, printBuiltIn);
    }

    private static void runSeventhRegex(
        int rounds,
        Random random,
        int strLength,
        boolean runTests,
        boolean checkResult,
        int warmupRuns,
        boolean printInputString,
        boolean writeInputString,
        boolean printBuiltIn
    ) {
        double[] roundTimesBuiltin;
        double[] roundTimesGenerated;
        int[] roundMatchesGenerated;
        roundTimesGenerated = new double[rounds];
        roundTimesBuiltin = new double[rounds];
        roundMatchesGenerated = new int[rounds];
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase7(random, strLength, 10);
            if (runTests && j >= warmupRuns) {
                Pattern pattern = checkResult(
                    REGEX_PATTERN7, testString,
                    RegexParserContainer.getImplementation(TestRegexParser7.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser7.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input6_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "7 (10): ",
            printBuiltIn
        );
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase7(random, strLength, 1);
            if (runTests && j >= warmupRuns) {
                Pattern pattern = checkResult(
                    REGEX_PATTERN7, testString,
                    RegexParserContainer.getImplementation(TestRegexParser7.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser7.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input6_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "7 (1): ",
            printBuiltIn
        );
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase7(random, strLength, 75);
            if (runTests && j >= warmupRuns) {
                Pattern pattern = checkResult(
                    REGEX_PATTERN7, testString,
                    RegexParserContainer.getImplementation(TestRegexParser7.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser7.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input6_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "7 (75): ",
            printBuiltIn
        );
    }

    private static void runSixthRegex(
        int rounds,
        Random random,
        int strLength,
        boolean runTests,
        boolean checkResult,
        int warmupRuns,
        boolean printInputString,
        boolean writeInputString,
        boolean printBuiltIn
    ) {
        double[] roundTimesBuiltin;
        double[] roundTimesGenerated;
        int[] roundMatchesGenerated;
        roundTimesGenerated = new double[rounds];
        roundTimesBuiltin = new double[rounds];
        roundMatchesGenerated = new int[rounds];
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase6(random, strLength, 75);
            if (runTests && j >= warmupRuns) {
                Pattern pattern = checkResult(
                    REGEX_PATTERN6, testString,
                    RegexParserContainer.getImplementation(TestRegexParser6.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser6.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input6_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "6 (75): ",
            printBuiltIn
        );
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase6(random, strLength, 10);
            if (runTests && j >= warmupRuns) {
                Pattern pattern = checkResult(
                    REGEX_PATTERN6, testString,
                    RegexParserContainer.getImplementation(TestRegexParser6.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser6.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input6_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "6 (10): ",
            printBuiltIn
        );
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase6(random, strLength, 500);
            if (runTests && j >= warmupRuns) {
                Pattern pattern = checkResult(
                    REGEX_PATTERN6, testString,
                    RegexParserContainer.getImplementation(TestRegexParser6.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser6.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input6_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "6 (500): ",
            printBuiltIn
        );
    }

    private static void runFifthRegex(
        int rounds,
        Random random,
        int strLength,
        boolean runTests,
        boolean checkResult,
        int warmupRuns,
        boolean printInputString,
        boolean writeInputString,
        boolean printBuiltIn
    ) {
        double[] roundTimesGenerated;
        double[] roundTimesBuiltin;
        int[] roundMatchesGenerated;
        roundTimesGenerated = new double[rounds];
        roundTimesBuiltin = new double[rounds];
        roundMatchesGenerated = new int[rounds];
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase5(random, strLength, 10);
            if (runTests && j >= warmupRuns) {
                Pattern pattern = checkResult(
                    REGEX_PATTERN5, testString,
                    RegexParserContainer.getImplementation(TestRegexParser5.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser5.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input5_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "5 (10): ",
            printBuiltIn
        );
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase5(random, strLength, 1);
            if (runTests && j >= warmupRuns) {
                Pattern pattern = checkResult(
                    REGEX_PATTERN5, testString,
                    RegexParserContainer.getImplementation(TestRegexParser5.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser5.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input5_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "5 (1): ",
            printBuiltIn
        );
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase5(random, strLength, 75);
            if (runTests && j >= warmupRuns) {
                Pattern pattern = checkResult(
                    REGEX_PATTERN5, testString,
                    RegexParserContainer.getImplementation(TestRegexParser5.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser5.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input5_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "5 (75): ",
            printBuiltIn
        );
    }

    private static void runFourthRegex(
        int rounds,
        Random random,
        int strLength,
        boolean runTests,
        boolean checkResult,
        int warmupRuns,
        boolean printInputString,
        boolean writeInputString,
        boolean printBuiltIn
    ) {
        double[] roundTimesBuiltin;
        double[] roundTimesGenerated;
        int[] roundMatchesGenerated;
        roundTimesGenerated = new double[rounds];
        roundTimesBuiltin = new double[rounds];
        roundMatchesGenerated = new int[rounds];
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase4(random, strLength, 50);
            if (runTests && j >= warmupRuns) {
                Pattern pattern = checkResult(
                    REGEX_PATTERN4, testString,
                    RegexParserContainer.getImplementation(TestRegexParser4.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser4.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input4_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "4 (50): ",
            printBuiltIn
        );
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase4(random, strLength, 20);
            if (runTests && j >= warmupRuns) {
                Pattern pattern = checkResult(
                    REGEX_PATTERN4, testString,
                    RegexParserContainer.getImplementation(TestRegexParser4.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser4.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input4_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "4 (20): ",
            printBuiltIn
        );
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase4(random, strLength, 85);
            if (runTests && j >= warmupRuns) {
                Pattern pattern = checkResult(
                    REGEX_PATTERN4, testString,
                    RegexParserContainer.getImplementation(TestRegexParser4.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser4.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input4_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "4 (85): ",
            printBuiltIn
        );
    }

    private static void runThirdRegex(
        int rounds,
        Random random,
        int strLength,
        boolean runTests,
        boolean checkResult,
        int warmupRuns,
        boolean printInputString,
        boolean writeInputString,
        boolean printBuiltIn
    ) {
        double[] roundTimesGenerated;
        double[] roundTimesBuiltin;
        int[] roundMatchesGenerated;
        roundTimesGenerated = new double[rounds];
        roundTimesBuiltin = new double[rounds];
        roundMatchesGenerated = new int[rounds];
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase3(random, strLength, 55, 100);
            if (runTests && j >= warmupRuns) {
                Pattern pattern = checkResult(
                    REGEX_PATTERN3, testString,
                    RegexParserContainer.getImplementation(TestRegexParser3.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser3.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input3_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "3 (55, 100): ",
            printBuiltIn
        );
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase3(random, strLength, 15, 575);
            if (runTests && j >= warmupRuns) {
                Pattern pattern = checkResult(
                    REGEX_PATTERN3, testString,
                    RegexParserContainer.getImplementation(TestRegexParser3.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser3.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input3_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "3 (15, 575): ",
            printBuiltIn
        );
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase3(random, strLength, 5, 100);
            if (runTests && j >= warmupRuns) {
                Pattern pattern = checkResult(
                    REGEX_PATTERN3, testString,
                    RegexParserContainer.getImplementation(TestRegexParser3.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser3.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input3_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "3 (5, 100): ",
            printBuiltIn
        );
    }

    private static void runSecondRegex(
        int rounds,
        Random random,
        int strLength,
        boolean runTests,
        boolean checkResult,
        int warmupRuns,
        boolean printInputString,
        boolean writeInputString,
        boolean printBuiltIn
    ) {
        double[] roundTimesGenerated = new double[rounds];
        double[] roundTimesBuiltin = new double[rounds];
        int[] roundMatchesGenerated = new int[rounds];
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase2(random, strLength, 50);
            if (runTests && j >= warmupRuns) {
                Pattern pattern = checkResult(
                    REGEX_PATTERN2, testString,
                    RegexParserContainer.getImplementation(TestRegexParser2.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser2.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input2_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "2 (50): ",
            printBuiltIn
        );
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase2(random, strLength, 95);
            if (runTests && j >= warmupRuns) {
                Pattern pattern = checkResult(
                    REGEX_PATTERN2, testString,
                    RegexParserContainer.getImplementation(TestRegexParser2.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser2.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input2_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "2 (95): ",
            printBuiltIn
        );
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase2(random, strLength, 5);
            if (runTests && j >= warmupRuns) {
                Pattern pattern = checkResult(
                    REGEX_PATTERN2, testString,
                    RegexParserContainer.getImplementation(TestRegexParser2.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser2.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input2_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "2 (5): ",
            printBuiltIn
        );
    }

    private static void runFirstRegex(
        int rounds,
        Random random,
        int strLength,
        boolean runTests,
        boolean checkResult,
        int warmupRuns,
        boolean printInputString,
        boolean writeInputString,
        boolean printBuiltIn
    ) {
        double[] roundTimesGenerated = new double[rounds];
        double[] roundTimesBuiltin = new double[rounds];
        int[] roundMatchesGenerated = new int[rounds];
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase1(random, strLength, 50);
            if (runTests && j >= warmupRuns) {
                Pattern pattern1 = checkResult(
                    REGEX_PATTERN1, testString,
                    RegexParserContainer.getImplementation(TestRegexParser1.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern1
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser1.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input1_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "1 (50): ",
            printBuiltIn
        );
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase1(random, strLength, 500);
            if (runTests && j >= warmupRuns) {
                Pattern pattern1 = checkResult(
                    REGEX_PATTERN1, testString,
                    RegexParserContainer.getImplementation(TestRegexParser1.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern1
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser1.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input1_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "1 (500): ",
            printBuiltIn
        );
        for (int j = 0; j < rounds + warmupRuns; j++) {
            String testString = generateInputForTestCase1(random, strLength, 5);
            if (runTests && j >= warmupRuns) {
                Pattern pattern1 = checkResult(
                    REGEX_PATTERN1, testString,
                    RegexParserContainer.getImplementation(TestRegexParser1.class),
                    checkResult
                );
                runJavaRegexParser(
                    roundTimesBuiltin,
                    j - warmupRuns,
                    testString,
                    pattern1
                );
                runGeneratedRegexParser(
                    RegexParserContainer.getImplementation(TestRegexParser1.class),
                    testString,
                    roundTimesGenerated,
                    roundMatchesGenerated,
                    j - warmupRuns
                );
            }
            if (printInputString) {
                System.out.println(testString);
            }
            if (writeInputString) {
                try {
                    Files.writeString(Paths.get("input1_" + j + "_.txt"), testString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        printResult(
            roundTimesGenerated,
            roundTimesBuiltin,
            roundMatchesGenerated,
            "1 (5): ",
            printBuiltIn
        );
    }

    private static void printResult(
        double[] roundTimesGenerated,
        double[] roundTimesBuiltin,
        int[] roundMatchesGenerated,
        String text,
        boolean printBuiltin
    ) {
        if (printBuiltin) {
            System.out.println(
                "Average of built-in: " + Arrays.stream(roundTimesBuiltin).summaryStatistics()
                    .getAverage());
        }
        System.out.println(
            text
                + Arrays.stream(roundTimesGenerated).sorted()
                .skip(((long) (roundTimesGenerated.length / 2)) - 1)
                .findFirst()
                .orElse(0)
                + ", "
                + Arrays.stream(roundMatchesGenerated).summaryStatistics()
                .getAverage());
    }

    private static String generateInputForTestCase1(Random random, int strLength, int chance) {
        var testStringBuilder = new StringBuilder();
        for (int i = 0; i < strLength; i++) {
            testStringBuilder.append((char) ('A' + random.nextInt(26)));
            if (random.nextInt(chance) == 0) {
                testStringBuilder.append(' ');
            }
        }
        return testStringBuilder.toString();
    }

    private static String generateInputForTestCase2(Random random, int strLength, int chance) {
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
                    break;
            }
            if (i % 8 == 0 && random.nextInt(100) < chance) {
                testStringBuilder.append(':');
            }
        }
        return testStringBuilder.toString();
    }

    private static String generateInputForTestCase3(Random random, int strLength, int c1, int c2) {
        var testStringBuilder = new StringBuilder();
        for (int i = 0; i < strLength; i++) {
            if (random.nextInt(100) < c1) {
                testStringBuilder.append((char) ('A' + random.nextInt(26)));
            } else {
                testStringBuilder.append((char) ('a' + random.nextInt(26)));
            }
            if (random.nextInt(1000) < c2) {
                testStringBuilder.append("ABCDE");
            }
        }
        return testStringBuilder.toString();
    }

    private static String generateInputForTestCase4(Random random, int strLength, int chance) {
        var testStringBuilder = new StringBuilder();
        for (int i = 0; i < strLength; i++) {
            if (i % 8 == 0 && random.nextInt(100) < chance) {
                testStringBuilder.append("AB");
            }
            if (i % 8 == 7 && random.nextInt(100) < chance) {
                testStringBuilder.append('C');
            }
            if (i % 8 < 4) {
                if (random.nextInt(100) < chance) {
                    testStringBuilder.append((char) ('A' + random.nextInt(26)));
                } else {
                    testStringBuilder.append((char) ('a' + random.nextInt(26)));
                }
            } else {
                if (random.nextInt(100) < chance) {
                    testStringBuilder.append((char) ('a' + random.nextInt(26)));
                } else {
                    testStringBuilder.append((char) ('A' + random.nextInt(26)));
                }
            }
        }
        return testStringBuilder.toString();
    }

    private static String generateInputForTestCase5(Random random, int strLength, int chance) {
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
            if (random.nextInt(100) < chance) {
                testStringBuilder.append("ABCDE");
            }
        }
        return testStringBuilder.toString();
    }

    private static String generateInputForTestCase6(Random random, int strLength, int chance) {
        var testStringBuilder = new StringBuilder();
        for (int i = 0; i < strLength; i++) {
            testStringBuilder.append((char) ('n' + random.nextInt(25)));
            if (random.nextInt(1000) < chance) {
                testStringBuilder.append((char) ('a' + random.nextInt(6)));
            }
        }
        return testStringBuilder.toString();
    }

    private static String generateInputForTestCase7(Random random, int strLength, int chance) {
        var testStringBuilder = new StringBuilder();
        for (int i = 0; i < strLength; i++) {
            testStringBuilder.append((char) ('A' + random.nextInt(26)));
            if (random.nextInt(100) < chance) {
                testStringBuilder.append("AB");
            }
            if (random.nextInt(100) < chance) {
                testStringBuilder.append('C');
            }
        }
        return testStringBuilder.toString();
    }

    private static Pattern checkResult(
        String regexPattern4, String testString,
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

    private static void runGeneratedRegexParser(
        RegexParser parser,
        String testString,
        double[] roundTimesGenerated,
        int[] roundMatchesGenerated,
        int j
    ) {
        var start = System.nanoTime();
        var res = parser
            .findMatches(testString).getMatches().stream()
            .map(result -> List.of(result.getStart(), result.getEnd()))
            .toList()
            .size();
        roundTimesGenerated[j] = (System.nanoTime() - start) / 1_000_000;
        roundMatchesGenerated[j] = res;
    }

    private static void runJavaRegexParser(
        double[] roundTimes,
        int j,
        String testString,
        Pattern pattern
    ) {
        var start = System.nanoTime();
        var matcher = pattern.matcher(testString);
        var res = matcher.results().map(result -> List.of(result.start(), result.end()))
            .collect(Collectors.toList()).size();
        roundTimes[j] = (System.nanoTime() - start) / 1_000_000;
    }

}
