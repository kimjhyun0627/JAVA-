package TeamProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MedObj {

	protected String med_ID;
	protected Date dateStart;
	protected String studentID;
	protected int med_num;
	protected boolean isAvailable;
	
	protected String ERR_MSG = "Fatal Error.";

	public MedObj() {
		
		med_ID = "";
		dateStart = new Date(2022, 6, 1, 12, 30, 10);
		studentID = "1234567890";
		med_num = 0;
	}
	
	//AddMedi에서 medInfo 확인용
	//Borrow에서 med 확인용
	public MedObj(String newID, String newStudentID, int newNum) {
		
		if (isValid(newID, newStudentID, newNum)) {
			
			med_ID = newID;
			studentID = newStudentID;
			setMedStatus();
		}
		else
			errorhandler("invalid initialization");
	}
	
	//CheckBorrow에서 medInfo 확인용
	public MedObj(String newID, Date newStart, String newStudentID, int newNum) {
		
		if (isValid(newID, newStart, newStudentID, newNum)) {
			
			med_ID = newID;
			dateStart = newStart;
			studentID = newStudentID;
			setMedStatus();
		}
		else
			errorhandler("invalid initialization");
	}
	
	public MedObj(MedObj BObj) {
		
		med_ID = BObj.med_ID;
		dateStart = BObj.dateStart;
		studentID = BObj.studentID;
		med_num = BObj.med_num;
	}
	
	public boolean equals(Object otherObj) {
		
		if (otherObj == null) return false;
		else if (!(otherObj instanceof MedObj))
		    return false;
		else {
			
		    MedObj otherMed = (MedObj) otherObj;
		    return (med_ID == otherMed.med_ID &&
		            dateStart.equals(otherMed.dateStart) &&
		            studentID.equals(otherMed.studentID) &&
		            med_num == otherMed.med_num &&
		            isAvailable == otherMed.isAvailable);
		}
	}
	
	public static MedObj[] dataGetter()
    {
        Scanner FileReader_OBJ = null;
        MedObj[] ObjList = new MedObj[3];

        try
        {
            FileReader_OBJ = new Scanner(new FileInputStream("./data/med.txt"));
            int count = 0;
            while (FileReader_OBJ.hasNext())
            {
                //ObjList: med_name, med_num
            	//약 개수 변동하는 거 구현해야 합니다,,
            		//AddMed에서 +
            		//Borrow에서 -
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        FileReader_OBJ.close();

        return ObjList;
    }
	
	public String getID() {

		return med_ID;
	}

	public Date getDateStart() {

		return new Date(dateStart);
	}
	
	public String getStudentID() {

		return studentID;
	}
	
	public int getNum() {
		
		return med_num;
	}
	
	public boolean getIsAvailble() {
		
        return this.isAvailable;
    }

	public void setMedStatus() {
		
		if (med_num < 0)
			isAvailable = false;
		else
			isAvailable = true;
		
	}

	private boolean isValid(String newID, String newStudID, int newNum) {
		
		return ((newID.length() > 0) && (newStudID.length() == 10) && (newNum > 0));
	}
	
	private boolean isValid(String newID, Date newStart, String newStudID, int newNum) {
		
		return ((newID.length() > 0) && (newStart.isValidTime()) && (newStudID.length() == 10) && (newNum > 0));
	}
	
	public String toFileString() {
		
		return "" + med_ID + "\t" + dateStart.toFileString() + "\t" + studentID + "\t" + med_num;
	}
	
	private void errorhandler(String errorType) {

		System.err.println("Error occured in Abstract BorrowObj class: " + errorType);
	}

}
