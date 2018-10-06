import java.util.List;

public class FileReader {

    TsvParserSettings settings = new TsvParserSettings();

    TsvParser parser = new TsvParser(settings);

    List<String[]> allRows = parser.parseAll(/*Input*/);
}
