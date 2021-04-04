package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FileClass {

    public static void main(String[] args) {
        File file = new File("D:");
        file.list();
        file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return false;
            }
        });
        Arrays.sort(new String[]{},String.CASE_INSENSITIVE_ORDER);

    }
}
