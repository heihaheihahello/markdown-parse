import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class test {
    @Test
    public void snippet3c() throws IOException {
        ArrayList<String> output = new ArrayList<> ();
        Path fileName = Path.of("Snippet3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse_copy3.getLinks(contents);
        output.add("https://ucsd-cse15l-w22.github.io/");
        assertEquals("test for snippet 3, using my new markdownparse", output, links);
    }
}
