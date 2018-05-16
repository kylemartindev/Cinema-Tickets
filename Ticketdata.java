import java.time.DayOfWeek;
import java.time.LocalDate;

class Pricesw extends HomePage{
	public static int standardvalue = 8;
	public static int oapvalue = 6;
	public static int studentvalue = 6;
	public static int childvalue = 4;
	public static int discountvalue = 2;

	public Pricesw(Integer standardvalue, Integer oapvalue, Integer studentvalue, Integer childvalue, Integer discountvalue) {
		    standardvalue = standardvalue; 
		    oapvalue = oapvalue;
		    studentvalue = studentvalue;
		    childvalue = childvalue;
		    discountvalue = discountvalue;
	}

	public int getStandardvalue() {
		return standardvalue;
	}
	public int getOapvalue() {
		return oapvalue;
	}
	public int getStudentvalue() {
		return studentvalue;
	}
	public int getChildvalue() {
		return childvalue;
	}
	public int getDiscountvalue() {
		return discountvalue;
	}
	
public abstract class Ticketdata extends Pricesw {
	private Integer standard;
	private Integer oap;
	private Integer student;
	private Integer child; 
	private Object day;

public Ticketdata (Integer standardvalue, Integer oapvalue, Integer studentvalue, Integer childvalue, Integer discountvalue,Integer standardCombo,Integer oapCombo, Integer studentCombo, Integer childCombo, Object datepicker2)
{ super (standardvalue, oapvalue, studentvalue,childvalue, discountvalue );
	standard = standardCombo;
	oap = oapCombo;
	student = studentCombo;
	child = childCombo;
	day = datepicker2; 
 
}
public Integer getStandard()
{return standard;}

public Integer getOap()
{return oap;}

public Integer getStudent()
{return student;}

public Integer getChild()
{return child;}

public Object getDay()
{return day;}
public String totaldata() {
	
	int c1 = standard * standardvalue;
    int c2 = oap * oapvalue;
    int c3 = student *studentvalue;
    int c4 = child* childvalue;
    int t1 = c1 + c2 + c3 + c4;
    if ((((LocalDate) day).getDayOfWeek() == DayOfWeek.WEDNESDAY)) {
     standardvalue = standardvalue-discountvalue; 
     oapvalue = oapvalue-discountvalue;
     studentvalue = studentvalue-discountvalue;
     childvalue = childvalue-discountvalue;
     
    }
	return ("You have choosen Standard Tickets" + standard + "@" + standardvalue +"=" + c1 +
			"\n You have choosen Oap Tickets" + oap + "@" + oapvalue + "=" + c2 +
			"\n You have choosen Student Tickets" + student + "@" + "=" + c3 +
			"\n You have choosen Child Tickets " + child + "@" + "=" + c4 +
			"\n Total Amount is " + t1);
	
}

}	

}