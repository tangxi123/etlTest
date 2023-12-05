package testcase.base.tool;

import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import de.siegmar.fastcsv.reader.NamedCsvReader;
import de.siegmar.fastcsv.reader.NamedCsvRow;
import jdk.nashorn.internal.ir.CallNode;
import net.minidev.json.JSONUtil;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ReadCSV {

    public static void main(String[] args) throws IOException {
        readFile();
    }

    public static ArrayList<HashMap<String, Object>> readFile() throws IOException {
        String path = "src/main/resources/metadata/metadataExpect.csv";
        final File file = new File(path);
        final Path path1 = file.toPath();
        final CsvReader csvRows = CsvReader.builder().build(path1, Charset.forName("GBK"));
        final ArrayList<HashMap<String, Object>> hashMaps = new ArrayList<>();
        for (CsvRow row : csvRows) {
            final HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("TABLE_NAME", row.getField(0));
            hashMap.put("COLUMN_NAME", row.getField(1));
            hashMap.put("IS_NULLABLE", row.getField(2));
            hashMap.put("DATA_TYPE", row.getField(3));
            if (row.getField(4).equals("")) {
                hashMap.put("MAX_LENGTH", 0);
            } else {
                hashMap.put("MAX_LENGTH", row.getField(4));
            }
            hashMaps.add(hashMap);
        }
        return hashMaps;

    }


}
