package fr.fireowls.harearswarriors.harearsapi.utils.files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDocument {

    private File file;
    private List<String> content;

    private Scanner fileScanner;
    private PrintWriter filePrinter;

    public FileDocument(String file) {
        this(new File(file));
    }

    public FileDocument(File file) {
        this.file = file;
        this.content = new ArrayList<String>();

        fileScanner = null;
        filePrinter = null;

        try {

            if (!file.exists())
                file.createNewFile();

            fileScanner = new Scanner(
                    new BufferedInputStream(
                            new FileInputStream(file)));
            filePrinter = new PrintWriter(
                    new BufferedOutputStream(
                            new FileOutputStream(file)));

            while(fileScanner.hasNext()) {
                content.add(fileScanner.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void print(String...lines) {
        for (String line : lines) {
            filePrinter.print(line);
            content.add(line);
        }
    }

    public void println(String...lines) {
        for (String line : lines) {
            print(line+"\n");
        }
    }

    public List<String> getContent() {
        return content;
    }

    public File getFile() {
        return file;
    }

    public void close() {
        fileScanner.close();
        filePrinter.close();
    }

    @Override
    public String toString() {
        String content = "";
        for (String line : this.content) {
            content += line;
        }
        return content;
    }
}
