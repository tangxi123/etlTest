package testcase.base.tests.metadata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testcase.base.StartApplication;
import testcase.base.adapter.LogTestListener;
import testcase.base.mapper.ods.OdsMetadataMapper;
import testcase.base.tool.ReadCSV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@SpringBootTest(classes = StartApplication.class)
@Listeners(LogTestListener.class)
public class MetadataTest extends AbstractTestNGSpringContextTests {
    Logger logger = LoggerFactory.getLogger(MetadataTest.class);

    @Autowired
    OdsMetadataMapper odsMetadataMapper;

    @DataProvider(name = "test1")
    public Iterator<Object[]> getMetadata() {
        final ArrayList<Object[]> objects = new ArrayList<>();
        final ArrayList<HashMap<String, Object>> odsMetaData = odsMetadataMapper.getOdsMetaData();

        final Iterator<HashMap<String, Object>> iterator = odsMetaData.iterator();
        while (iterator.hasNext()) {
            objects.add(new Object[]{iterator.next()});

        }
        return objects.iterator();

    }


    @Test(dataProvider = "test1")
    public void metadataTest(HashMap<String, Object> odsMetadata) throws IOException {
//        System.out.println(odsMetadata.toString());
        final ArrayList<HashMap<String, Object>> hashMaps = ReadCSV.readFile();
        final Iterator<HashMap<String, Object>> iterator = hashMaps.iterator();

        while (iterator.hasNext()) {
            final HashMap<String, Object> next = iterator.next();
            if (odsMetadata.get("TABLE_NAME").equals(next.get("TABLE_NAME")) && odsMetadata.get("COLUMN_NAME").equals(next.get("COLUMN_NAME"))) {
                logger.info("数据类型对比{},{}",odsMetadata.get("DATA_TYPE").toString(), next.get("DATA_TYPE").toString());
                Assert.assertEquals(odsMetadata.get("DATA_TYPE").toString(), next.get("DATA_TYPE").toString(), "数据类型对比");
                Assert.assertEquals(odsMetadata.get("IS_NULLABLE").toString(), next.get("IS_NULLABLE").toString(), "是否可以为空对比");
                Assert.assertEquals(odsMetadata.get("MAX_LENGTH").toString(), next.get("MAX_LENGTH").toString(), "字段最大长度对比");
            }
        }


    }


}
