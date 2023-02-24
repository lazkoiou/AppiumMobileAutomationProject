package com.smoke.tests;

import gr.qa.SetUp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class SampleMobileTests extends SetUp {

    private final static Logger logger = LogManager.getLogger(SampleMobileTests.class);

    @BeforeClass
    void initialize() {
        startAppiumServer();
        setupMobileDriver();
        logger.info("Starting SmokeMobileTests Suite...");
    }

    @AfterClass (alwaysRun = true)
    void tearDown() {
        tearDownAndroidDriver();
        logger.info("Finished SmokeTests Suite ...\n");
    }

    @Test
    void FirstTest() {
        logger.info("Starting PagkratiSearchAdsTest...");
    }

}
