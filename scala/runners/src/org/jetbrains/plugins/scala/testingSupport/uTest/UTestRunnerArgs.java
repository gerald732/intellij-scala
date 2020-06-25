package org.jetbrains.plugins.scala.testingSupport.uTest;

import org.jetbrains.plugins.scala.testingSupport.uTest.utils.UTestUtils;

import java.lang.reflect.Method;
import java.util.*;

public final class UTestRunnerArgs {

    final Map<String, Set<UTestPath>> classesToTests;

    public UTestRunnerArgs(Map<String, Set<UTestPath>> classesToTests) {
        this.classesToTests = new HashMap<>(classesToTests);
    }

    private static final String TEST_SUITE_KEY = "-s";
    private static final String TEST_NAME_KEY = "-testName";

    public static UTestRunnerArgs parse(String[] args) {
        Map<String, Set<UTestPath>> classesToTests = new HashMap<>();

        String currentClass = null;
        int argIdx = 0;
        while (argIdx < args.length) {
            switch (args[argIdx]) {
                case TEST_SUITE_KEY:
                    ++argIdx;
                    while (argIdx < args.length && !args[argIdx].startsWith("-")) {
                        String className = args[argIdx];
                        classesToTests.put(className, new HashSet<>());
                        currentClass = className;
                        ++argIdx;
                    }
                    break;
                case TEST_NAME_KEY:
                    ++argIdx;
                    if (currentClass == null)
                        throw new RuntimeException("Failed to run tests: no suite class specified for test " + args[argIdx]);
                    while (!args[argIdx].startsWith("-")) {
                        String testName = args[argIdx];
                        UTestPath testPath = parseTestPathSafe(currentClass, testName);
                        if (testPath != null)
                            classesToTests.get(currentClass).add(testPath);
                        ++argIdx;
                    }
                    break;
                default:
                    ++argIdx;
                    break;
            }
        }
        return new UTestRunnerArgs(classesToTests);
    }

    private static UTestPath parseTestPathSafe(String currentClass, String testName) {
        try {
            return parseTestPath(currentClass, testName);
        } catch (UTestRunExpectedError error) {
            System.err.println(error.getMessage());
            return null;
        }
    }

    private static UTestPath parseTestPath(String className, String argsString) throws UTestRunExpectedError {
        String[] nameArgs = argsString.split("\\\\");
        List<String> asList = Arrays.asList(nameArgs);
        // drop first element which corresponds to common `tests` method
        List<String> testPath = asList.subList(1, asList.size());
        final Class<?> clazz = UTestUtils.findClass(className);
        final Method method = UTestUtils.findTestDefinitionMethod(clazz);
        return new UTestPath(className, testPath, method);
    }
}
