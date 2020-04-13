package dashboard;
import org.knowm.xchart.*;
import org.knowm.xchart.style.PieStyler;
import java.awt.*;
import java.util.ArrayList;

public class DonutChart{

        public DonutChart () {
        }

    Font font = new Font("./Louis George Cafe.ttf", Font.PLAIN, 18 );
    Font font2 = new Font("./Louis George Cafe.ttf", Font.PLAIN, 16 );


    public PieChart getChart(ArrayList<String> names, ArrayList<Integer> occ, String chartName) {

        // Create Chart
        PieChart chart = new PieChartBuilder().width(450).height(350).title(chartName).build();


        // Customize Chart
        chart.getStyler().setChartBackgroundColor(Color.WHITE);
        chart.getStyler().setLegendVisible(true);
        chart.getStyler().setAnnotationType(PieStyler.AnnotationType.Percentage);
        chart.getStyler().setAnnotationDistance(1);
        chart.getStyler().setPlotContentSize(0.7);
        chart.getStyler().setDefaultSeriesRenderStyle(PieSeries.PieSeriesRenderStyle.Donut);
        chart.getStyler().setPlotBorderVisible(false);
        chart.getStyler().setChartTitleFont(font);
        chart.getStyler().setAnnotationsFont(font2);
        //chart.getStyler().setCircular(false);

        // Series
        for(int i=0; i<names.size(); i++){
            chart.addSeries(names.get(i), occ.get(i));
        }
        //chart.addSeries(serieName1, successValue).setFillColor(Color.decode("#26A69A"));
        //chart.addSeries(serieName2, failedValue).setFillColor(Color.decode("#80CBC4"));
        //chart.addSeries(serieName3, notRunned).setFillColor(Color.decode("#B2DFDB"));

        return chart;
    }

    public PieChart getFuncDataChart(int compliance, int accounting, int finance, int risk, int collections, int juridique, int operations){
        PieChart chart = new PieChartBuilder().width(550).height(450).title("Functional Tests").build();

        chart.getStyler().setChartBackgroundColor(Color.WHITE);
        chart.getStyler().setLegendVisible(true);
        chart.getStyler().setAnnotationType(PieStyler.AnnotationType.Percentage);
        chart.getStyler().setAnnotationDistance(1);
        chart.getStyler().setPlotContentSize(0.8);
        chart.getStyler().setDefaultSeriesRenderStyle(PieSeries.PieSeriesRenderStyle.Donut);
        chart.getStyler().setPlotBorderVisible(false);
        chart.getStyler().setLegendBorderColor(Color.WHITE);
        chart.getStyler().setChartTitleFont(font);
        chart.getStyler().setAnnotationsFont(font2);

        chart.addSeries(compliance+" Compliance", compliance);
        chart.addSeries(accounting+" Accounting", accounting);
        chart.addSeries(finance+" Finance", finance);
        chart.addSeries(risk+" Risk", risk);
        chart.addSeries(collections+" Collections", collections);
        chart.addSeries(juridique+" Juridique", juridique);
        chart.addSeries(operations+" Operations", operations);

        return chart;
    }

    public PieChart getTechDataChart(int ui, int batch, int crossTest){
        PieChart chart = new PieChartBuilder().width(550).height(450).title("Technical Tests").build();

        chart.getStyler().setChartBackgroundColor(Color.WHITE);
        chart.getStyler().setLegendVisible(true);
        chart.getStyler().setAnnotationType(PieStyler.AnnotationType.Percentage);
        chart.getStyler().setAnnotationDistance(1);
        chart.getStyler().setPlotContentSize(0.8);
        chart.getStyler().setDefaultSeriesRenderStyle(PieSeries.PieSeriesRenderStyle.Donut);
        chart.getStyler().setPlotBorderVisible(false);
        chart.getStyler().setLegendBorderColor(Color.WHITE);
        chart.getStyler().setChartTitleFont(font);
        chart.getStyler().setAnnotationsFont(font2);

        chart.addSeries(ui+" UI", ui);
        chart.addSeries(batch+" Batch", batch);
        chart.addSeries(crossTest+" crossTest", crossTest);

        return chart;
    }

}
