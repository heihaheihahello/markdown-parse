import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void links() throws IOException {
        ArrayList<String> output = new ArrayList<> ();
        Path fileName = Path.of("test-file3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        output.add("https://something.com");
        output.add("some-page.html");
        assertEquals("test for getlinks", output, links);

        
    }
}