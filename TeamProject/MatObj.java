package TeamProject;

public class MatObj extends BorrowObject{
	
	public MatObj(){
		super();
	}
	
	public MatObj(int objID, Date dateStart, Date dateEnd, String studentID) {
		super(objID, dateStart, dateEnd, studentID);
		dateHaveto = new Date();
		dateHaveto.AddDate(dateStart);
		setObjStatus();
	}
	
	public MatObj(int objID, Date dateStart, Date dateHaveto, Date dateEnd, String studentID) {
		super(objID, dateStart, dateHaveto, dateEnd, studentID);
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
	
	public boolean equals(Object otherObj){
		if(otherObj == null) return false;
		else if(!(otherObj instanceof MatObj))
			return false; 
		else {
			MatObj otherMat = (MatObj)otherObj;
			return (objID == otherMat.objID && 
					dateStart.equals(otherMat.dateStart) &&
					dateHaveto.equals(otherMat.dateHaveto) &&
					dateEnd.equals(otherMat.dateEnd) &&
					studentID.equals(otherMat.studentID) &&
					isBorrowing == otherMat.isBorrowing);
		}
	}
}

