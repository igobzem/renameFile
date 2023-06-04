package org.example;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String path = Paths.get("").toAbsolutePath().toString();
        if (args.length > 0) {
            path = args[0];
        }

        String fileName = "cache_";
        if (args.length > 1) {
            fileName = args[1];
        }

        String rename = "cache";
        if (args.length > 2) {
            rename = args[2];
        }

        System.out.print("from " + path + " rename file " + fileName + " to " + rename);
        Scanner scanner = new Scanner(System.in);
        System.out.print(" Y/N?");

        String userInput = scanner.nextLine();  // Read user input
        if ("Y".equals(userInput) || "y".equals(userInput)) {
            System.out.println("start...");

            File folder = new File(path);

            Collection<File> files = FileUtils.listFiles(folder, null, true);
            for (File file : files)
                if (file.getName().equals(fileName)) {
                    System.out.println(file.getParent());
                    file.renameTo(new File(file.getParent() + "\\" + rename));
                }

        }

    }
}
