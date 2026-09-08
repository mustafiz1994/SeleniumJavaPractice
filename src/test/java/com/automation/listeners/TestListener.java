package com.automation.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger logger =
            LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {

        logger.info(
                "========== TEST STARTED: {} ==========",
                result.getName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        logger.info(
                "========== TEST PASSED: {} ==========",
                result.getName()
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {

        logger.error(
                "========== TEST FAILED: {} ==========",
                result.getName()
        );

        if (result.getThrowable() != null) {

            logger.error(
                    "Failure reason: {}",
                    result.getThrowable().getMessage()
            );
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        logger.warn(
                "========== TEST SKIPPED: {} ==========",
                result.getName()
        );
    }
}