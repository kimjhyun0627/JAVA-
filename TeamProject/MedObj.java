package TeamProject;

public class MedObj extends BorrowObject{
	
	public MedObj(){
		super();
	}
	
	public MedObj(int objID, Date dateStart, String studentID) {
		super(objID, dateStart, studentID);
		setObjStatus();
	}
	
	public MedObj(MedObj BObj){
		objID = BObj.objID;
		dateStart = BObj.dateStart;
		studentID = BObj.studentID;
		isBorrowing = BObj.isBorrowing;
	}
	
	public boolean equals(Object otherObj){
		if(otherObj == null) return false;
		else if(!(otherObj instanceof MedObj))
			return false; 
		else {
			MedObj otherMed = (MedObj)otherObj;
			return (objID == otherMed.objID && 
					dateStart.equals(otherMed.dateStart) &&
					studentID.equals(otherMed.studentID) &&
					isBorrowing == otherMed.isBorrowing);
		}
	}
}
