package Domain;


import Domain.Report;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Henrik
 */
public class Building
{

    int ID;
    String name;
    String address;
    int condition;
    String owner;
    String parcelNo;
    ArrayList<Report> reports = new ArrayList();

    
    public void Building()
    {
        
    }
    
    public Building(String name, String address, int condition, String owner, String parcelNo)
    {
        this.name = name;
        this.address = address;
        this.condition = condition;
        this.owner = owner;
        this.parcelNo = parcelNo;
    }
    public void addReport(int reportId, String nameOfBuilding, String date, String address, String zipCode, String yearBuild, int buildingSizeInSquareMetres, String buildingPurpose, Boolean roofNoticeBoolean, Boolean roofPictureBoolean, String roofNotice, Boolean wallNoticeBoolean, Boolean wallPictureBoolean, String wallNotice, String writer, String coWriter, int condition)
    {
        Report tempReport = new Report(reportId, nameOfBuilding, date, address, zipCode, yearBuild, buildingSizeInSquareMetres, buildingPurpose, roofNoticeBoolean, roofPictureBoolean, roofNotice, wallNoticeBoolean, wallPictureBoolean, wallNotice, writer, coWriter, condition);
        reports.add(tempReport);
    }
    
    public ArrayList<Report> getReports()
    {
        return reports;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public int getCondition()
    {
        return condition;
    }

    public void setCondition(int condition)
    {
        this.condition = condition;
    }

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public String getParcelNo()
    {
        return parcelNo;
    }

    public void setParcelNo(String parcelNo)
    {
        this.parcelNo = parcelNo;
    }

    public Building()
    {

    }

    public Building(String name)
    {
        this.name = name;
    }
    

}
