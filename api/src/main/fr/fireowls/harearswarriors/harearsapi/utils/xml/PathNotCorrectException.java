package fr.fireowls.harearswarriors.harearsapi.utils.xml;

import java.io.File;

public class PathNotCorrectException extends Exception {

    public PathNotCorrectException(String path, File file) {
        System.err.println("The path: "+path+",\n is not valide in the document: "+file.getAbsoluteFile());
    }
}
