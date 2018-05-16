import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

import com.github.lgooddatepicker.components.*;



import java.time.*;

public class HomePage {
	private static void createAndShowGUI() {
 JFrame frame = new JFrame("Homepage");
 frame.setLayout(new GridLayout(5,4,50,50));


 JLabel title = new JLabel("Cinema Tickets");
 title.setPreferredSize(new Dimension(200, 50));
 
 
 
 DatePickerSettings dateSettings = new DatePickerSettings();
 dateSettings.setFirstDayOfWeek(DayOfWeek.MONDAY);
 DatePicker datePicker2 = new DatePicker(dateSettings);
 JLabel datetext = new JLabel("Please enter date first");
 JPanel date = new JPanel();
 date.add(datetext); 
 date.add(datePicker2);
 
 JLabel Standard = new JLabel("Standard");
 Integer [] standardAmount = {0,1,2,3,4,5,6,7,8,9,10};
 JComboBox<Integer> standardCombo = new JComboBox<Integer>(standardAmount);
 
 JLabel oap = new JLabel("Oap");
 Integer [] oapAmount = {0,1,2,3,4,5,6,7,8,9,10};
 JComboBox <Integer> oapCombo = new JComboBox<Integer>(oapAmount);
 
 JLabel Student = new JLabel("Student");
 Integer [] studentAmount = {0,1,2,3,4,5,6,7,8,9,10};
 JComboBox<Integer> studentCombo = new JComboBox<Integer>(studentAmount);

 
 JLabel Child = new JLabel ("Child");
 Integer [] childAmount = {0,1,2,3,4,5,6,7,8,9,10};
 JComboBox <Integer>childCombo = new JComboBox<Integer>(childAmount);
 
 JPanel mainPanel = new JPanel();
 mainPanel.setLayout(new GridLayout(0,4,15,15));
 mainPanel.add(title);
 
 JPanel datePanel = new JPanel();
 datePanel.setLayout(new GridLayout(1,2,10,10));
 
 JPanel ticketPanel = new JPanel();
 ticketPanel.setLayout(new GridLayout(1,4,15,15));
 ticketPanel.add(Standard);
 ticketPanel.add(standardCombo);
 ticketPanel.add(oap);
 ticketPanel.add(oapCombo);
 ticketPanel.add(Student);
 ticketPanel.add(studentCombo);
 ticketPanel.add(Child);
 ticketPanel.add(childCombo);
 

 
 JPanel button = new JPanel();
 button.setLayout(new GridLayout(1,1,5,5));
 JButton total = new JButton("Total");
 button.add(total);
 
 JTextArea dateArea = new JTextArea(5, 20);
 JScrollPane scrollone = new JScrollPane(dateArea); 
 dateArea.setEditable(false);

 JTextArea standardArea = new JTextArea(5, 20);
 JScrollPane scrollPane = new JScrollPane(standardArea); 
 standardArea.setEditable(false);
 
 JTextArea oapArea = new JTextArea(5, 20);
 JScrollPane scrolltwo = new JScrollPane(oapArea); 
 oapArea.setEditable(false);
 
 JTextArea studentArea = new JTextArea(5, 20);
 JScrollPane scrollthree = new JScrollPane(studentArea); 
 studentArea.setEditable(false);
 
 JTextArea childArea = new JTextArea(5, 5);
 JScrollPane scrollfour = new JScrollPane(childArea); 
 childArea.setEditable(false); 
 
 JTextArea totalArea = new JTextArea(5, 5);
 JScrollPane scrollfive = new JScrollPane(childArea); 
 totalArea.setEditable(false); 
 
 
 JPanel results = new JPanel();
 results.setLayout(new GridLayout(4,4,10,10));
 results.add(dateArea);
 results.add(standardArea);
 results.add(oapArea);
 results.add(studentArea);
 results.add(childArea);
 results.add(totalArea);
 
frame.getContentPane().add(mainPanel);
frame.add(date);
frame.add(ticketPanel);
frame.add(results); 
frame.add(button);
frame.pack(); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);

datePicker2.addPropertyChangeListener("date", new PropertyChangeListener() {

    @Override
    public void propertyChange(PropertyChangeEvent e) {
    	LocalDate datepicked = datePicker2.getDate();
    	dateArea.setText("You have choosen the date of: " + datepicked);
    	
    }
});
	standardCombo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        LocalDate choosendate = datePicker2.getDate();
        Integer standardpicked = (Integer)standardCombo.getSelectedIndex(); 
         if ((choosendate.getDayOfWeek() == DayOfWeek.WEDNESDAY)){
        	int discount1 = ((Pricesw.standardvalue-Pricesw.discountvalue)*standardpicked); 
        	String a1 = Integer.toString(discount1);
        	standardArea.setText("Standard Total " + "£" + a1);
         }
         else 
         {	 
          int standardtotal = (Pricesw.standardvalue*standardpicked);
          String a = Integer.toString(standardtotal);
            standardArea.setText("Standard Total " +"£" + a);
        }
   
	}
	});
	
	oapCombo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	
          LocalDate choosendate = datePicker2.getDate(); 
          Integer oappicked = (Integer)oapCombo.getSelectedIndex();
          if ((choosendate.getDayOfWeek() == DayOfWeek.WEDNESDAY)){
          	int discount2 = ((Pricesw.oapvalue-Pricesw.discountvalue)*oappicked); 
          	String b1 = Integer.toString(discount2);
          	oapArea.setText("Oap Total " + "£" + b1);
          }else
          {
          int oaptotal = (Pricesw.oapvalue*oappicked);
          String b = Integer.toString(oaptotal);
            oapArea.setText("OAP Total " + "£" + b);
          }}
   
	});
	
	studentCombo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	LocalDate choosendate = datePicker2.getDate();
       	    Integer studentpicked = (Integer)studentCombo.getSelectedIndex();
       	 if ((choosendate.getDayOfWeek() == DayOfWeek.WEDNESDAY)){
           	int discount3 = ((Pricesw.studentvalue-Pricesw.discountvalue)*studentpicked); 
           	String c1 = Integer.toString(discount3);
           	studentArea.setText("Student Total " + "£" + c1);
           }else
           {
          
          int studenttotal = (Pricesw.studentvalue*studentpicked);
          String c = Integer.toString(studenttotal);
            studentArea.setText("Student Total " + "£" + c);
          }
       	 }
          
	});
	
	
	childCombo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	LocalDate choosendate = datePicker2.getDate();
          Integer childpicked = (Integer)childCombo.getSelectedIndex();
      	 if ((choosendate.getDayOfWeek() == DayOfWeek.WEDNESDAY)){
            	int discount4 = ((Pricesw.childvalue-Pricesw.discountvalue)*childpicked); 
            	String d1 = Integer.toString(discount4);
            	childArea.setText("Child Total " + "£" + d1);
            }else
            {
           
          int childtotal = (Pricesw.childvalue*childpicked);
          String d = Integer.toString(childtotal);
           childArea.setText("Child Total " + "£" + d);
        }
        }
	});
	
	total.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	LocalDate choosendate = datePicker2.getDate();
        	 if (choosendate == null) {
        		 dateArea.setText("You must select a date");
        	 }
        	 if ((choosendate.getDayOfWeek() == DayOfWeek.WEDNESDAY)) {
        	int c1 = (Pricesw.standardvalue-Pricesw.discountvalue)*studentCombo.getSelectedIndex();
            int c2 = (Pricesw.oapvalue-Pricesw.discountvalue)*oapCombo.getSelectedIndex();
            int c3 = (Pricesw.studentvalue-Pricesw.discountvalue)*studentCombo.getSelectedIndex();
            int c4 = (Pricesw.childvalue-Pricesw.discountvalue)*childCombo.getSelectedIndex();
            int t1 = c1 + c2 + c3 + c4;
        		totalArea.setText("Total Amount is.." + t1);
        	 }
        	 
        	 else
        	 {
        	 int c5 = standardCombo.getSelectedIndex() * Pricesw.standardvalue;
             int c6 = oapCombo.getSelectedIndex() * Pricesw.oapvalue;
             int c7 = studentCombo.getSelectedIndex() *Pricesw.studentvalue;
             int c8 = childCombo.getSelectedIndex()* Pricesw.childvalue;
             int t2 = c5 + c6 + c7 + c8;
              totalArea.setText("Total Amount is.." + t2);
        	 }
             {
        		 
        	 }
        }
   
	});
	
	}
	 

	
public static void main(String[] args) {
	  javax.swing.SwingUtilities.invokeLater(new Runnable() {
          public void run() {
              createAndShowGUI();
	
}
          });

