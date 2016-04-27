package Controllers;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JAJAJABLESES
 */
public class Report
{

    int reportId;
    String nameOfBuilding;
    String date;
    String address;
    String zipCode;
    //General info
    String yearBuild;
    int buildingSizeInSquareMetres;
    String buildingPurpose;
    //Outside conclusions
    Boolean roofNoticeBoolean;
    Boolean roofPictureBoolean;
    String roofNotice;
    Boolean wallNoticeBoolean;
    Boolean wallPictureBoolean;
    String wallNotice;
    ArrayList<Room> rooms;
    String writer;
    String coWriter;
    int condition;

    public Report(int reportId, String nameOfBuilding, String date, String address, String zipCode, String yearBuild, int buildingSizeInSquareMetres, String buildingPurpose, Boolean roofNoticeBoolean, Boolean roofPictureBoolean, String roofNotice, Boolean wallNoticeBoolean, Boolean wallPictureBoolean, String wallNotice, String writer, String coWriter, int condition)
    {
        this.reportId = reportId;
        this.nameOfBuilding = nameOfBuilding;
        this.date = date;
        this.address = address;
        this.zipCode = zipCode;
        this.yearBuild = yearBuild;
        this.buildingSizeInSquareMetres = buildingSizeInSquareMetres;
        this.buildingPurpose = buildingPurpose;
        this.roofNoticeBoolean = roofNoticeBoolean;
        this.roofPictureBoolean = roofPictureBoolean;
        this.roofNotice = roofNotice;
        this.wallNoticeBoolean = wallNoticeBoolean;
        this.wallPictureBoolean = wallPictureBoolean;
        this.wallNotice = wallNotice;
        rooms = new ArrayList();

        this.writer = writer;
        this.coWriter = coWriter;
        this.condition = condition;
    }

    public void addRoom(String roomName, Boolean notices, Boolean damagedRoom, String dateOfDamage, String descriptionOfLocation, String explanationOfDamage, String repairs, Boolean moisture, Boolean sponge, Boolean mold, Boolean fire, Boolean otherDamage, String moistureDesctription, String spongeDescription, String moldDescription, String fireDescription, String otherDamageDescription)
    {
        Room tempRoom = new Room(roomName, notices, damagedRoom, dateOfDamage, descriptionOfLocation, explanationOfDamage, repairs, moisture, sponge, mold, fire, otherDamage, moistureDesctription, spongeDescription, moldDescription, fireDescription, otherDamageDescription);
        rooms.add(tempRoom);
    }

    public int getReportId()
    {
        return reportId;
    }

    public void setReportId(int reportId)
    {
        this.reportId = reportId;
    }

    public String getNameOfBuilding()
    {
        return nameOfBuilding;
    }

    public void setNameOfBuilding(String nameOfBuilding)
    {
        this.nameOfBuilding = nameOfBuilding;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getYearBuild()
    {
        return yearBuild;
    }

    public void setYearBuild(String yearBuild)
    {
        this.yearBuild = yearBuild;
    }

    public int getBuildingSizeInSquareMetres()
    {
        return buildingSizeInSquareMetres;
    }

    public void setBuildingSizeInSquareMetres(int buildingSizeInSquareMetres)
    {
        this.buildingSizeInSquareMetres = buildingSizeInSquareMetres;
    }

    public String getBuildingPurpose()
    {
        return buildingPurpose;
    }

    public void setBuildingPurpose(String buildingPurpose)
    {
        this.buildingPurpose = buildingPurpose;
    }

    public Boolean getRoofNoticeBoolean()
    {
        return roofNoticeBoolean;
    }

    public void setRoofNoticeBoolean(Boolean roofNoticeBoolean)
    {
        this.roofNoticeBoolean = roofNoticeBoolean;
    }

    public Boolean getRoofPictureBoolean()
    {
        return roofPictureBoolean;
    }

    public void setRoofPictureBoolean(Boolean roofPictureBoolean)
    {
        this.roofPictureBoolean = roofPictureBoolean;
    }

    public String getRoofNotice()
    {
        return roofNotice;
    }

    public void setRoofNotice(String roofNotice)
    {
        this.roofNotice = roofNotice;
    }

    public Boolean getWallNoticeBoolean()
    {
        return wallNoticeBoolean;
    }

    public void setWallNoticeBoolean(Boolean wallNoticeBoolean)
    {
        this.wallNoticeBoolean = wallNoticeBoolean;
    }

    public Boolean getWallPictureBoolean()
    {
        return wallPictureBoolean;
    }

    public void setWallPictureBoolean(Boolean wallPictureBoolean)
    {
        this.wallPictureBoolean = wallPictureBoolean;
    }

    public String getWallNotice()
    {
        return wallNotice;
    }

    public void setWallNotice(String wallNotice)
    {
        this.wallNotice = wallNotice;
    }

    public ArrayList<Room> getRooms()
    {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms)
    {
        this.rooms = rooms;
    }

    public String getWriter()
    {
        return writer;
    }

    public void setWriter(String writer)
    {
        this.writer = writer;
    }

    public String getCoWriter()
    {
        return coWriter;
    }

    public void setCoWriter(String coWriter)
    {
        this.coWriter = coWriter;
    }

    public int getCondition()
    {
        return condition;
    }

    public void setCondition(int condition)
    {
        this.condition = condition;
    }

}
