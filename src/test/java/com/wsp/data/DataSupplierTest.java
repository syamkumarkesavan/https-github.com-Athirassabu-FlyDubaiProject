package com.wsp.data;

import com.wsp.testdata.TestData;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.TestDataReader;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;
import org.testng.annotations.Test;

public class DataSupplierTest {

    @Test(dataProvider = "getData")
    public void dataSupplierTest(TestData testData) {
    }

    @DataSupplier
    public StreamEx<TestData> getData(){
        return TestDataReader.use(XlsxReader.class)
                .withTarget(TestData.class)
                .withSource("testdata.xlsx")
                .read();
    }

}
