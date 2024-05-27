package com.syskimy.scatalog.resources.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class CsvCategoryResource {
    @CsvBindByName(column = "name")
    private String name;
}
