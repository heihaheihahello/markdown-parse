import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class MarkdownParseTest {

    @Test
    public void snippet1a() throws IOException {
        ArrayList<String> output = new ArrayList<> ();
        Path fileName = Path.of("Snippet1.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        output.add("`google.com");
        output.add("google.com");
        output.add("ucsd.edu");
        assertEquals("test for snippet 1, using my markdownparse", output, links);
    }

    @Test
    public void snippet1b() throws IOException {
        ArrayList<String> output = new ArrayList<> ();
        Path fileName = Path.of("Snippet1.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParseReview.getLinks(contents);
        output.add("`google.com");
        output.add("google.com");
        output.add("ucsd.edu");
        assertEquals("test for snippet 1, using reivewed markdownparse", output, links);
    }

    @Test
    public void snippet2a() throws IOException {
        ArrayList<String> output = new ArrayList<> ();
        Path fileName = Path.of("Snippet2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        output.add("a.com");
        output.add("a.com(())");
        output.add("example.com");
        assertEquals("test for snippet 2, using my markdownparse", output, links);
    }

    @Test
    public void snippet2b() throws IOException {
        ArrayList<String> output = new ArrayList<> ();
        Path fileName = Path.of("Snippet2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParseReview.getLinks(contents);
        output.add("a.com");
        output.add("a.com(())");
        output.add("example.com");
        assertEquals("test for snippet 2, using reivewed markdownparse", output, links);
    }

    @Test
    public void snippet3a() throws IOException {
        ArrayList<String> output = new ArrayList<> ();
        Path fileName = Path.of("Snippet3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse_copy3.getLinks(contents);
        output.add("https://ucsd-cse15l-w22.github.io/");
        assertEquals("test for snippet 3, using my markdownparse", output, links);
    }

    @Test
    public void snippet3b() throws IOException {
        ArrayList<String> output = new ArrayList<> ();
        Path fileName = Path.of("Snippet3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParseReview.getLinks(contents);
        output.add("https://ucsd-cse15l-w22.github.io/");
        assertEquals("test for snippet 3, using reivewed markdownparse", output, links);
    }
}