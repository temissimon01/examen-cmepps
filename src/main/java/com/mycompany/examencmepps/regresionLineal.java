package com.mycompany.examencmepps;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

public class regresionLineal extends JFrame {

    private ArrayList<RegisterEntry> entries;
    
    public regresionLineal(ArrayList<RegisterEntry> entries) {
        this.entries = entries;
        initUI();
    }

    private void initUI() {

        XYDataset dataset = createDatasetRL();
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Line chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public float RegresionLineal(int HDU){
        
        if(this.entries == null || this.entries.size() == 0){
            return 0.0f;
        }
        
        int n = this.entries.size();
        
        float sum_x = 0.0f;
        float sum_y = 0.0f;        
        float sum_xy = 0.0f;
        float sum_x2 = 0.0f;
        for(RegisterEntry e : this.entries){
            sum_xy += (float)e.Tamaño_estimado_en_puntos_historia * e.Esfuerzo;
            sum_x += (float)e.Tamaño_estimado_en_puntos_historia;
            sum_y += (float)e.Esfuerzo;   
            sum_x2 += (float)e.Tamaño_estimado_en_puntos_historia * (float)e.Tamaño_estimado_en_puntos_historia;
        }
        
        float a = (n*sum_xy - sum_x*sum_y)/(n*sum_x2 - (sum_x * sum_x));
        
        float b = (sum_y - a*sum_x)/n;
        
        return a*HDU + b;
    }

    private XYDataset createDatasetRL() {

        var series1 = new XYSeries("Regresion");
        var series2 = new XYSeries("Datos");
        
        for(RegisterEntry entry : this.entries){
            series1.add(entry.Tamaño_estimado_en_puntos_historia, RegresionLineal(entry.Tamaño_estimado_en_puntos_historia));
            series2.add(entry.Tamaño_estimado_en_puntos_historia, entry.Esfuerzo);
        }

        var dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        return dataset;
    }
    
    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Regresion Lineal",
                "Historias de usuario",
                "Esfuerzo",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        var renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Regresion Lineal",
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );

        return chart;
    }
}