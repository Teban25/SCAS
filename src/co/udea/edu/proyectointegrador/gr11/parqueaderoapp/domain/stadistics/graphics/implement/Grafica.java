/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.graphics.implement;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.BussinessException;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.HoraDelDiaEstadistica;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.TipoUsuarioEstadistica;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.TipoVehiculoEstadistica;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.graphics.IGrafica;
import java.awt.Color;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.Rotation;

/**
 *
 * @author ASUS
 */
public class Grafica implements IGrafica {

    private static final String TITLE_OF_PIE_CHART = "Ingresos por tipo de Usuario";
    private static final String TITLE_OF_BAR_CHART = "Ingresos por tipo de vehiculo";
    private static final String NO_DATA_TO_DISPLAY = "No hay datos para mostrar";
    private static final String UNIQUE_SERIE_TO_VEHICLE = "Tipo de vehiculo";
    private static final String DOMAIN_AXIS_LABEL = "Tipo de vehiculo";
    private static final String RANGE_AXIS_LABEL = "Numero de ingresos";
    private static final String DOMAIN_AXIS_LABEL_HOUR = "Hora del dia";
    private static final String NAME_OF_HOUR_SERIE = "Numero de ingresos por horas del dia";
    private static final String TITLE_OF_XY_CHART = "Ingresos por horas del dia";

    @Override
    public JFreeChart createPieToUserType(List<TipoUsuarioEstadistica> tipoUsuarios) throws BussinessException {
        if (tipoUsuarios == null || tipoUsuarios.isEmpty()) {
            throw new BussinessException("No hay datos para realizar la estadística por tipo de usuario");
        }
        //Se crea el conjunto de datos para el tipo de usuario
        PieDataset dataset = createDataForUserType(tipoUsuarios);

        JFreeChart pie = ChartFactory.createPieChart3D(
                TITLE_OF_PIE_CHART, //Titulo del grafigo
                dataset,//Conjunto de datos
                true, //Incluir leyenda
                true,
                false);
        final PiePlot piePlot = (PiePlot) pie.getPlot();
        piePlot.setStartAngle(200);
        piePlot.setDirection(Rotation.CLOCKWISE);
        piePlot.setForegroundAlpha(0.5f);
        piePlot.setNoDataMessage(NO_DATA_TO_DISPLAY);
        return pie;
    }

    @Override
    public JFreeChart createBarChartToVehicleType(List<TipoVehiculoEstadistica> tipoVehiculos) throws BussinessException {
        if (tipoVehiculos == null || tipoVehiculos.isEmpty()) {
            throw new BussinessException("No hay datos para realizar la estadística por tipo de vehiculo");
        }
        //Se crea el conjunto de datos para realizar el grafico de barras

        DefaultCategoryDataset dataset = createDataForVehicleType(tipoVehiculos);

        //Se crea el grafico de barras
        final JFreeChart chart = ChartFactory.createBarChart3D(
                TITLE_OF_BAR_CHART, //Titulo del gráfico
                DOMAIN_AXIS_LABEL, //Nombre del dominio
                RANGE_AXIS_LABEL, //Nombre del Rango
                dataset, //Conjunto de datos
                PlotOrientation.VERTICAL, //Orientacion del grafico
                true,//Incluye leyendas
                true,
                false);
        //Se pinta el fondo de blanco
        chart.setBackgroundPaint(Color.WHITE);

        //Se pintan el fondo del grafico de gris y las lineas de blanco
        final CategoryPlot categoryPlot = chart.getCategoryPlot();
        categoryPlot.setBackgroundPaint(Color.LIGHT_GRAY);
        categoryPlot.setDomainGridlinePaint(Color.WHITE);
        categoryPlot.setRangeGridlinePaint(Color.WHITE);

        //Se configura para que solo muestre números enteros
        final NumberAxis rangeAxis = (NumberAxis) categoryPlot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        final BarRenderer barRenderer = (BarRenderer) categoryPlot.getRenderer();
        barRenderer.setDrawBarOutline(false);

        return chart;
    }

    @Override
    public JFreeChart createXYLineChartToHoursOfDay(List<HoraDelDiaEstadistica> horasDelDia) throws BussinessException {
        if (horasDelDia == null || horasDelDia.isEmpty()) {
            throw new BussinessException("No hay datos para realizar la estadística por horas del dia");
        }

        //Se obtiene el conjunto de datos
        XYDataset dataset = createDataForHoursOfDay(horasDelDia);

        final JFreeChart chart = ChartFactory.createXYLineChart(
                TITLE_OF_XY_CHART, //Titulo del grafico
                DOMAIN_AXIS_LABEL_HOUR, //Nombre del Rango
                RANGE_AXIS_LABEL,//Nombre del dominio
                dataset, //conjunto de datos
                PlotOrientation.VERTICAL, //Orientacion del grafico
                true, //incluir leyendas
                true,
                false);

        //Se pinta el fondo de blanco
        chart.setBackgroundPaint(Color.WHITE);

        //Se pintan el fondo del grafico de gris y las lineas de blanco
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.LIGHT_GRAY);
        plot.setDomainGridlinePaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.WHITE);
        
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        plot.setRenderer(renderer);

        
        //Se configura para que solo muestre números enteros en el rango
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        //Se configura para que solo muestre números enteros en el dominio
        final NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return chart;
    }

    private PieDataset createDataForUserType(List<TipoUsuarioEstadistica> tipoUsuarios) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (TipoUsuarioEstadistica tipoUsuario : tipoUsuarios) {
            dataset.setValue(tipoUsuario.getTipoUsuario().getTipoUsuarioDescripcion(), tipoUsuario.getNumeroDeIngresos());
        }
        return dataset;
    }

    private DefaultCategoryDataset createDataForVehicleType(List<TipoVehiculoEstadistica> tipoVehiculos) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (TipoVehiculoEstadistica tipoVehiculo : tipoVehiculos) {
            dataset.addValue(tipoVehiculo.getNumeroDeIngresos(),
                    UNIQUE_SERIE_TO_VEHICLE,
                    tipoVehiculo.getTipoVehiculo().getTipoVehiculoDescripcion());
        }
        return dataset;
    }

    private XYDataset createDataForHoursOfDay(List<HoraDelDiaEstadistica> horasDelDia) {
        final XYSeries series = new XYSeries(NAME_OF_HOUR_SERIE);
        
        for (HoraDelDiaEstadistica horaDelDia : horasDelDia) {
            series.add(horaDelDia.getHoraDelDia(),horaDelDia.getNumeroDeIngresos());
          
        }
        
        final XYSeriesCollection dataSet = new XYSeriesCollection(series);
      
        return dataSet;
    }

}
