package org.bonn.se.ws15.uebung9;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtil {
    public static void logRegistration(int id, Class c) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        final String date = dateFormat.format(new Date()).toString();

        System.out.printf("Document with id %d was registered!%n", id);
        System.out.printf("Corresponding Class Name: %s%n", c.getName());
        System.out.printf("Date: %s%n%n", date);
    }
}
