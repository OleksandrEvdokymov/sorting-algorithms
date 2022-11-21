package edu.khai.algorithms.sorting.view;

import com.github.appreciated.apexcharts.ApexCharts;
import com.github.appreciated.apexcharts.ApexChartsBuilder;
import com.github.appreciated.apexcharts.config.builder.*;
import com.github.appreciated.apexcharts.config.chart.Type;
import com.github.appreciated.apexcharts.config.chart.builder.ZoomBuilder;
import com.github.appreciated.apexcharts.config.grid.builder.RowBuilder;
import com.github.appreciated.apexcharts.config.stroke.Curve;
import com.github.appreciated.apexcharts.config.subtitle.Align;
import com.github.appreciated.apexcharts.helper.Series;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import edu.khai.algorithms.sorting.*;
import edu.khai.algorithms.sorting.util.ArrayGenerator;

import java.util.Arrays;

@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        int[] quantity = new int[]{1000, 2330, 5900, 8315, 12120, 39600, 70700};

        String[] labels = Arrays.stream(quantity).mapToObj(String::valueOf).toArray(String[]::new);

        Double[] timesBubble = Arrays.stream(quantity).mapToObj(n -> {
            ArrayGenerator arrayGenerator = new ArrayGenerator();
            int[] generatedArray = arrayGenerator.generate(n);
            BubbleSorting bubbleSorting = new BubbleSorting();
            long startTime = System.nanoTime();
            bubbleSorting.sort(generatedArray);
            long endTime = System.nanoTime();
            return (endTime - startTime) / 1e9;
        }).toArray(Double[]::new);

        Double[] timesHeap = Arrays.stream(quantity).mapToObj(n -> {
            ArrayGenerator arrayGenerator = new ArrayGenerator();
            int[] generatedArray = arrayGenerator.generate(n);
            HeapSorting bubbleSorting = new HeapSorting();
            long startTime = System.nanoTime();
            bubbleSorting.sort(generatedArray);
            long endTime = System.nanoTime();
            return (endTime - startTime) / 1e9;
        }).toArray(Double[]::new);

        Double[] timesInsertion = Arrays.stream(quantity).mapToObj(n -> {
            ArrayGenerator arrayGenerator = new ArrayGenerator();
            int[] generatedArray = arrayGenerator.generate(n);
            InsertionSorting bubbleSorting = new InsertionSorting();
            long startTime = System.nanoTime();
            bubbleSorting.sort(generatedArray);
            long endTime = System.nanoTime();
            return (endTime - startTime) / 1e9;
        }).toArray(Double[]::new);

        Double[] timesQuick = Arrays.stream(quantity).mapToObj(n -> {
            ArrayGenerator arrayGenerator = new ArrayGenerator();
            int[] generatedArray = arrayGenerator.generate(n);
            QuickSorting bubbleSorting = new QuickSorting();
            long startTime = System.nanoTime();
            bubbleSorting.sort(generatedArray);
            long endTime = System.nanoTime();
            return (endTime - startTime) / 1e9;
        }).toArray(Double[]::new);

        Double[] timesSelection = Arrays.stream(quantity).mapToObj(n -> {
            ArrayGenerator arrayGenerator = new ArrayGenerator();
            int[] generatedArray = arrayGenerator.generate(n);
            SelectionSorting bubbleSorting = new SelectionSorting();
            long startTime = System.nanoTime();
            bubbleSorting.sort(generatedArray);
            long endTime = System.nanoTime();
            return (endTime - startTime) / 1e9;
        }).toArray(Double[]::new);

        Double[] timesShell = Arrays.stream(quantity).mapToObj(n -> {
            ArrayGenerator arrayGenerator = new ArrayGenerator();
            int[] generatedArray = arrayGenerator.generate(n);
            ShellSorting bubbleSorting = new ShellSorting();
            long startTime = System.nanoTime();
            bubbleSorting.sort(generatedArray);
            long endTime = System.nanoTime();
            return (endTime - startTime) / 1e9;
        }).toArray(Double[]::new);

        ApexCharts lineChart = ApexChartsBuilder.get()
                .withChart(ChartBuilder.get()
                        .withType(Type.LINE)
                        .withZoom(ZoomBuilder.get()
                                .withEnabled(false)
                                .build())
                        .build())
                .withStroke(StrokeBuilder.get()
                        .withCurve(Curve.STRAIGHT)
                        .build())
                .withTitle(TitleSubtitleBuilder.get()
                        .withText("Порівняння швидкості сортування даних різними алгоритмами")
                        .withAlign(Align.LEFT)
                        .build())
                .withGrid(GridBuilder.get()
                        .withRow(RowBuilder.get()
                                .withColors("#f3f3f3", "transparent")
                                .withOpacity(0.5).build()
                        ).build())
                .withXaxis(XAxisBuilder.get()
                        .withCategories(labels)
                        .build())
                .withYaxis(YAxisBuilder.get()
                        .withMin(0)
                        .withMax(20)
                        .build())
                .withSeries(new Series<>("Bubble", timesBubble), new Series<>("Heap", timesHeap),
                        new Series<>("Insertion", timesInsertion), new Series<>("Quick", timesQuick),
                        new Series<>("Selection", timesSelection), new Series<>("Shell", timesShell))
                .build();
        add(lineChart);
        setWidth("80%");
        setHeight("80%");
    }
}
