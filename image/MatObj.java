package TeamProject;

public class MatObj extends BorrowObject{
	
	public MatObj(){
		super();
	}
	
	public MatObj(int objID, Date dateStart, Date dateEnd, String StudentID) {
		super(objID, dateStart, dateEnd, StudentID);
		dateHaveto = new Date(setHaveto(dateStart));
		setObjStatus();
	}
	
	public MatObj(int objID, Date dateStart, Date dateHaveto, Date dateEnd, String StudentID) {
		super(objID, dateStart, dateHaveto, dateEnd, StudentID);
		setObjStatus();
	}
	
	public MatObj(MatObj BObj){
		objID = BObj.objID;
		dateStart = BObj.dateStart;
		dateHaveto = BObj.dateHaveto;
		dateEnd = BObj.dateEnd;
		studentID = BObj.studentID;
		isBorrowing = BObj.isBorrowing;
	}
}
