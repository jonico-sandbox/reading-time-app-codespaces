package com.github.demo.servlet;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import javax.servlet.ServletException;
import java.io.File;
import java.util.List;

public class BookServletTest {

    private static final int TOMCAT_PORT = 9091;

    private static final String URL = "http://localhost:" + TOMCAT_PORT;

    private static final String BOOKS_XPATH = "//td/div/div/h4";

    private static Tomcat tomcat;

    private static WebDriver driver;

    @BeforeClass
    public static void startTomcat() throws LifecycleException, ServletException {

        tomcat = new Tomcat();
        tomcat.setPort(TOMCAT_PORT);

        StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File("src/main/webapp/").getAbsolutePath());
        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);

        tomcat.start();

        driver = new HtmlUnitDriver();
    }

    @Test
    public void testHeadTitle() {
        driver.get(URL);
        Assert.assertEquals("It's time to read!", driver.getTitle());
    }

    @Test
    public void testBookListSize() {
        driver.get(URL);
        List books = driver.findElements(By.xpath(BOOKS_XPATH));
        Assert.assertTrue(books.size() >= 4);
    }

    @AfterClass
    public static void stopTomcat() throws LifecycleException {
        driver.quit();
        tomcat.stop();
    }
}
