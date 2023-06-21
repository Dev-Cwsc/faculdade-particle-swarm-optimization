package br.com.dev.cwsc.particleswarmoptimization;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.util.ArrayList;

public class Graficos
{
    private XYDataset criarDataSetGbests(Particula[] vetGbest)
    {
        final XYSeries Gbests = new XYSeries("Gbest");
        final XYSeriesCollection dataSetGbests = new XYSeriesCollection();
        ArrayList<Particula> list = new ArrayList();
        int valor = 1;

        for(int j=0;j<vetGbest.length;j++)
        {
            list.add(vetGbest[j]);
        }

        for(int i=0;i<list.size();i++)
        {
            Gbests.add((double) valor, (double)list.get(i).getFitness());
            valor++;
        }
        dataSetGbests.addSeries(Gbests);
        return dataSetGbests;
    }

    private XYDataset criarDataSetMGbests(double[] vetMGbest)
    {
        final XYSeries MGbests = new XYSeries("Média");
        final XYSeriesCollection dataSetMGbests = new XYSeriesCollection();
        double[] list = new double[vetMGbest.length];
        int valor = 1;

        for(int j=0;j<vetMGbest.length;j++)
        {
            list[j] = vetMGbest[j];
        }

        for(int i=0;i<list.length;i++)
        {
            MGbests.add((double) valor, list[i]);
            valor++;
        }

        dataSetMGbests.addSeries(MGbests);

        return dataSetMGbests;
    }

    private JFreeChart plotarGrafico(XYDataset dadosparticulas, String x)
    {
        final JFreeChart chart;
        if(x=="Gbest")
        {
            chart = ChartFactory.createXYLineChart(
                    "Fitness do Gbest em cada iteração",
                    "Iterações",
                    "Fitness",
                    dadosparticulas,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false);
            chart.setBackgroundPaint(Color.LIGHT_GRAY);
            final XYPlot plot1 = chart.getXYPlot();
            plot1.setBackgroundPaint(Color.white);
            plot1.setDomainGridlinePaint(Color.black);
            plot1.setRangeGridlinePaint(Color.black);
        }else
        {
            chart = ChartFactory.createXYLineChart(
                    "Média entre as fitness das partículas em cada iteração",
                    "Iterações",
                    "Fitness média",
                    dadosparticulas,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false);
            chart.setBackgroundPaint(Color.LIGHT_GRAY);
            final XYPlot plot2 = chart.getXYPlot();
            plot2.setBackgroundPaint(Color.white);
            plot2.setDomainGridlinePaint(Color.black);
            plot2.setRangeGridlinePaint(Color.black);
        }
        return chart;
    }

    public ChartPanel setPainel(Particula[] vetGbest, String x)
    {
        XYDataset dados = this.criarDataSetGbests(vetGbest);
        JFreeChart grafico = this.plotarGrafico(dados, x);
        ChartPanel painelGrafico = new ChartPanel(grafico);
        painelGrafico.setPreferredSize(new java.awt.Dimension(500, 285));
        return painelGrafico;
    }

    public ChartPanel setMediaPainel(double[] vetMGbest, String x)
    {
        XYDataset dados = this.criarDataSetMGbests(vetMGbest);
        JFreeChart grafico = this.plotarGrafico(dados, x);
        ChartPanel painelGrafico = new ChartPanel(grafico);
        painelGrafico.setPreferredSize(new java.awt.Dimension(500, 285));
        return painelGrafico;
    }
}
