package TeamProject;

public class Student
{
    private static final String mailForm = "@knu.ac.kr";
    private String ID = "";
    private String name = "";
    private String phoneNumber = "";
    private String webMailAddress = "";
    private Cabinet cabinet = null;
    private Boolean isCouncil = false;

    public Student()
    {
        ID = "";
        name = "";
        phoneNumber = "";
        webMailAddress = "";
        cabinet = new Cabinet(0, "0000");
        isCouncil = false;
    }

    public Student(String newID, String newname, String newphone, String newmail, int newcabID, String newcabPW, boolean newCouncil)
    {
        if (isValidData(newID, newname, newphone))
        {
            ID = newID;
            name = newname;
            phoneNumber = newphone;
            webMailAddress = newmail;
            cabinet = new Cabinet(newcabID, newcabPW);
            isCouncil = newCouncil;
        }
        else
            errorhandler("invalid initialization");
    }

    private boolean isValidData(String newID, String newname, String newphone)
    {
        return ((newID.length() == 10) && (newname.length() >= 2) && (newname.length() < 20)
                && (newphone.length() == 11));
    }

    public String getID()
    {
        return ID;
    }

    public String getName()
    {
        return name;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getWebMailAddress()
    {
        return webMailAddress;
    }

    public int getCabID()
    {
        return cabinet.getID();
    }

    public String getCabPW()
    {
        return cabinet.getPW();
    }

    public void setCabPW(String newPW)
    {
        cabinet.setPW(newPW);
    }

    public boolean getCouncil()
    {
        return isCouncil;
    }

    public String toString()
    {
        String phoneNumberLong = phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3, 7) + "-" + phoneNumber.substring(7);
        return "" + ID + "\t" + name + "\t" + phoneNumberLong + "\t" + webMailAddress + mailForm + "\t" + "\tcouncil: "
                + isCouncil;
    }

    public String toFileString()
    {
        return "" + ID + "\t" + name + "\t" + phoneNumber + "\t" + webMailAddress + "\t" + cabinet.getID() + "\t" + cabinet.getPW() + "\t"
                + isCouncil;
    }

    private void errorhandler(String errorType)
    {
        System.err.println("Error occured in Student class: " + errorType);
    }
}