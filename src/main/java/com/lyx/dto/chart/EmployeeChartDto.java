package com.lyx.dto.chart;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeChartDto {
    private List<String> xAxisData;
    private List<Integer> yAxisData;
}
