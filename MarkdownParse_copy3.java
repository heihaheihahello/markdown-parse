// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse_copy3 {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        //System.out.println("Before loop currentIndex: " + currentIndex);
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            if(nextOpenBracket == -1){
                break;
            } 
            //System.out.println("Beggining of loop currentIndex: " + currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            //System.out.println("current openparn: " + openParen);
            if (openParen == -1) {
                break;
            }
            int closeParen = markdown.indexOf(")", openParen);
            
            //System.out.println("current closeparn: " + closeParen);
            if(nextOpenBracket == 0 || markdown.substring(nextOpenBracket-1, nextOpenBracket).equals("!") == false){
                toReturn.add(markdown.substring(openParen + 1, closeParen).trim());
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
        //System.out.println(contents.substring(65,67).contains("\n"));
        //System.out.println(contents.substring(67,69).contains("\n"));
        //System.out.println(contents.indexOf("\n", 0));
        //System.out.print(contents.substring(65, 69));
        //System.out.println(contents.substring(65,68).equals("\n\n"));
        //System.out.print("\n\n");
        //MarkdownParse_copy3 trytry = new MarkdownParse_copy3();
        //System.out.println(trytry.checkempty(131, 241, contents));
        
    }
}