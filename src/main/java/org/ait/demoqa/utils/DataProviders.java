package org.ait.demoqa.utils;

import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> studentDataFromCSVFile() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(DataProviders.class
                .getResourceAsStream("/data.csv"))));


        String line = reader.readLine();
        while (line != null){
            list.add(line.split(","));
            line = reader.readLine();
        }


        return list.iterator();
    }
}
