package roundrobinsimulation;

import java.time.LocalDate;  
import java.time.ZoneOffset;  
import java.util.ArrayList;
import java.util.Date;  
import javax.swing.JFrame;  
import javax.swing.SwingUtilities;  
import javax.swing.WindowConstants;  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.data.category.IntervalCategoryDataset;  
import org.jfree.data.gantt.Task;  
import org.jfree.data.gantt.TaskSeries;  
import org.jfree.data.gantt.TaskSeriesCollection;  
  
public class GanttChart extends JFrame {  
  
   private static final long serialVersionUID = 1L; 
   private ArrayList<String[]> timingDetails;
  
   public GanttChart(String title, ArrayList<String[]> timingDetails) {  
      super(title);  
      // Create dataset  
      this.timingDetails = timingDetails;
      IntervalCategoryDataset dataset = getCategoryDataset();  
      
      // Create chart  
      JFreeChart chart = ChartFactory.createGanttChart(  
            "Round Robin Simulation", // Chart title  
            "Processes", // X-Axis Label  
            "Timeline", // Y-Axis Label  
            dataset);  
  
      ChartPanel panel = new ChartPanel(chart);  
      setContentPane(panel); 
      
   }  
  
   private IntervalCategoryDataset getCategoryDataset() {  
       
       TaskSeries series = new TaskSeries("Burst Time");
       int len = this.timingDetails.size();
       System.out.println(len);
       for (int i=0; i<len; i++){
           String[] temp = timingDetails.get(i);
           String tempName = temp[2]+"-"+Integer.toString(i);
           String from = temp[0];
           String to = temp[1];
           series.add(new Task(tempName,Date.from(LocalDate.of(Integer.parseInt(from), 1,1).atStartOfDay().toInstant(ZoneOffset.UTC)),  
            Date.from(LocalDate.of(Integer.parseInt(to), 1,1).atStartOfDay().toInstant(ZoneOffset.UTC))  
            ));
       }
       
        TaskSeriesCollection dataset = new TaskSeriesCollection();  
        dataset.add(series);
        return dataset;  
  
//TaskSeries series1 = new TaskSeries("Estimated Date"); series1.add(new Task("Requirement",  
//Date.from(LocalDate.of(0,7,3).atStartOfDay().toInstant(ZoneOffset.UTC)),  
//Date.from(LocalDate.of(2018, 7,3).atStartOfDay().toInstant(ZoneOffset.UTC))  
//         ));  
//        
// series1.add(new Task("Design",Date.from(LocalDate.of(2018, 7,3).atStartOfDay().toInstant(ZoneOffset.UTC)),  
// Date.from(LocalDate.of(2019, 7,3).atStartOfDay().toInstant(ZoneOffset.UTC))  
//         ));  
//        
// series1.add(new Task("Coding",Date.from(LocalDate.of(2019, 7,3).atStartOfDay().toInstant(ZoneOffset.UTC)),  
// Date.from(LocalDate.of(2020, 7,3).atStartOfDay().toInstant(ZoneOffset.UTC))  
//         ));  
//        
// series1.add(new Task("Testing", Date.from(LocalDate.of(2020, 7,3).atStartOfDay().toInstant(ZoneOffset.UTC)),  
// Date.from(LocalDate.of(2021, 7,3).atStartOfDay().toInstant(ZoneOffset.UTC))  
//         ));  
//        
// series1.add(new Task("Deployment", Date.from(LocalDate.of(2021, 7,3).atStartOfDay().toInstant(ZoneOffset.UTC)),  
// Date.from(LocalDate.of(2022, 7,3).atStartOfDay().toInstant(ZoneOffset.UTC))  
//         ));  
//        
//        
//TaskSeries series2 = new TaskSeries("Actual Date");  
//series2.add(new Task("Requirement",Date.from(LocalDate.of(2022, 7,3).atStartOfDay().toInstant(ZoneOffset.UTC)),  
//Date.from(LocalDate.of(2023, 7, 05).atStartOfDay().toInstant(ZoneOffset.UTC))  
//         ));  
//        
// series2.add(new Task("Design",  
// Date.from(LocalDate.of(2017, 7, 6).atStartOfDay().toInstant(ZoneOffset.UTC)),  
// Date.from(LocalDate.of(2017, 7, 17).atStartOfDay().toInstant(ZoneOffset.UTC))  
//         ));  
//        
// series2.add(new Task("Coding",  
// Date.from(LocalDate.of(2017, 7, 18).atStartOfDay().toInstant(ZoneOffset.UTC)),  
// Date.from(LocalDate.of(2017, 7, 27).atStartOfDay().toInstant(ZoneOffset.UTC))  
//         ));  
//        
// series2.add(new Task("Testing",  
// Date.from(LocalDate.of(2017, 7, 28).atStartOfDay().toInstant(ZoneOffset.UTC)),  
// Date.from(LocalDate.of(2017, 8, 1).atStartOfDay().toInstant(ZoneOffset.UTC))  
//         ));  
//        
// series2.add(new Task("Deployment",  
// Date.from(LocalDate.of(2017, 8, 2).atStartOfDay().toInstant(ZoneOffset.UTC)),  
// Date.from(LocalDate.of(2017, 8, 4).atStartOfDay().toInstant(ZoneOffset.UTC))  
//         ));  
  

   }  
  
// public static void main(String[] args) {  
// SwingUtilities.invokeLater(() -> {  
// GanttChartExample example = new GanttChartExample("Gantt Chart Example");  
//         example.setSize(800, 400);  
//         example.setLocationRelativeTo(null);  
//         example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
//         example.setVisible(true);  
//      });  
//   }  
}  
