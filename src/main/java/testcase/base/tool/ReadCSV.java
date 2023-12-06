package testcase.base.tool;

import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import de.siegmar.fastcsv.reader.NamedCsvReader;
import de.siegmar.fastcsv.reader.NamedCsvRow;
import jdk.nashorn.internal.ir.CallNode;
import net.minidev.json.JSONUtil;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ClassUtils;

import javax.annotation.Resource;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ReadCSV {

    public static void main(String[] args) throws IOException {
        readFile();
    }

    public static ArrayList<HashMap<String, Object>> readFile() throws IOException {

        final InputStream input = ClassUtils.getDefaultClassLoader().getResourceAsStream("metadata/metadataExpect.csv");
        Reader reader = new InputStreamReader(input, "UTF-8");
        final CsvReader csvRows = CsvReader.builder().build(reader);
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
