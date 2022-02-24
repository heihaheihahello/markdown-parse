// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse_copy {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        //System.out.println("Before loop currentIndex: " + currentIndex);
        int nextOpenBracket = markdown.indexOf("[", currentIndex);
        String beforefirstbracket = markdown.substring(0, nextOpenBracket);
        //int backticks = 0;
        for (int i = 0; i<beforefirstbracket.length(); i++) {
            nextOpenBracket = markdown.indexOf("[", currentIndex);
    
        }
        while(currentIndex < markdown.length()) {
            nextOpenBracket = markdown.indexOf("[", currentIndex);
            if(nextOpenBracket == -1){
                break;
            } 
            //System.out.println("Beggining of loop currentIndex: " + currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            String StrinBracket = markdown.substring(nextOpenBracket, nextCloseBracket);
            if (StrinBracket.contains("`")) {

            }
            System.out.println("]:"+nextCloseBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            //System.out.println("current openparn: " + openParen);
            if (openParen == -1) {
                break;
            }
            int closeParen = markdown.indexOf(")", openParen);
            //System.out.println("current closeparn: " + closeParen);
            if(nextOpenBracket == 0 || markdown.substring(nextOpenBracket-1, nextOpenBracket).equals("!") == false){
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }
            //toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1; //one after closed paren
            //System.out.println("current index: " + currentIndex);
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}