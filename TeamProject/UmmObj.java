package TeamProject;

public class UmmObj extends BorrowObject{
	
	public UmmObj(){
		super();
	}
	
	public UmmObj(int objID, Date dateStart, Date dateEnd, String studentID) {
		super(objID, dateStart, dateEnd, studentID);
		dateHaveto = new Date();
		dateHaveto.AddDate(dateStart);
		setObjStatus();
	}
	
	public UmmObj(int objID, Date dateStart, Date dateHaveto, Date dateEnd, String studentID) {
		super(objID, dateStart, dateHaveto, dateEnd, studentID);
		setObjStatus();
	}
	
	public UmmObj(MatObj BObj){
		objID = BObj.objID;
		dateStart = BObj.dateStart;
		dateHaveto = BObj.dateHaveto;
		dateEnd = BObj.dateEnd;
		studentID = BObj.studentID;
		isBorrowing = BObj.isBorrowing;
	}
	
	public boolean equals(Object otherObj){
		if(otherObj == null) return false;
		else if(!(otherObj instanceof UmmObj))
			return false; 
		else {
			UmmObj otherUmm = (UmmObj)otherObj;
			return (objID == otherUmm.objID && 
					dateStart.equals(otherUmm.dateStart) &&
					dateHaveto.equals(otherUmm.dateHaveto) &&
					dateEnd.equals(otherUmm.dateEnd) &&
					studentID.equals(otherUmm.studentID) &&
					isBorrowing == otherUmm.isBorrowing);
		}
	}

}
