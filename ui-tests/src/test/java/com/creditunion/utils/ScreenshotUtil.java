package com.creditunion.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");

    public static String capture(WebDriver driver, String name){
        try{
            byte[] data = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            String ts = sdf.format(new Date());
            Path dir = Path.of("ui-tests","target","screenshots");
            Files.createDirectories(dir);
            Path out = dir.resolve(name + "_" + ts + ".png");
            Files.write(out, data);
            return out.toString();
        }catch (IOException ex){
            System.err.println("Failed to save screenshot: " + ex.getMessage());
            return "";
        }
    }
}
