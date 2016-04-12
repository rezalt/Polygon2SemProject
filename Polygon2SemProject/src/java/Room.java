/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JAJAJABLESES
 */
public class Room
{

    String roomName;
    Boolean notices;
    Boolean damagedRoom;
    String dateOfDamage;
    String descriptionOfLocation;
    String explanationOfDamage;
    String repairs;
    Boolean moisture;
    Boolean sponge;
    Boolean mold;

    Boolean fire;
    Boolean otherDamage;
    String moistureDesctription;
    String spongeDescription;
    String moldDescription;
    String fireDescription;
    String otherDamageDescription;

    public Room(String roomName, Boolean notices, Boolean damagedRoom, String dateOfDamage, String descriptionOfLocation, String explanationOfDamage, String repairs, Boolean moisture, Boolean sponge, Boolean mold, Boolean fire, Boolean otherDamage, String moistureDesctription, String spongeDescription, String moldDescription, String fireDescription, String otherDamageDescription)
    {
        this.roomName = roomName;
        this.notices = notices;
        this.damagedRoom = damagedRoom;
        this.dateOfDamage = dateOfDamage;
        this.descriptionOfLocation = descriptionOfLocation;
        this.explanationOfDamage = explanationOfDamage;
        this.repairs = repairs;
        this.moisture = moisture;
        this.sponge = sponge;
        this.mold = mold;
        this.fire = fire;
        this.otherDamage = otherDamage;
        this.moistureDesctription = moistureDesctription;
        this.spongeDescription = spongeDescription;
        this.moldDescription = moldDescription;
        this.fireDescription = fireDescription;
        this.otherDamageDescription = otherDamageDescription;
    }

    public String getRoomName()
    {
        return roomName;
    }

    public void setRoomName(String roomName)
    {
        this.roomName = roomName;
    }

    public Boolean getNotices()
    {
        return notices;
    }

    public void setNotices(Boolean notices)
    {
        this.notices = notices;
    }

    public Boolean getDamagedRoom()
    {
        return damagedRoom;
    }

    public void setDamagedRoom(Boolean damagedRoom)
    {
        this.damagedRoom = damagedRoom;
    }

    public String getDateOfDamage()
    {
        return dateOfDamage;
    }

    public void setDateOfDamage(String dateOfDamage)
    {
        this.dateOfDamage = dateOfDamage;
    }

    public String getDescriptionOfLocation()
    {
        return descriptionOfLocation;
    }

    public void setDescriptionOfLocation(String descriptionOfLocation)
    {
        this.descriptionOfLocation = descriptionOfLocation;
    }

    public String getExplanationOfDamage()
    {
        return explanationOfDamage;
    }

    public void setExplanationOfDamage(String explanationOfDamage)
    {
        this.explanationOfDamage = explanationOfDamage;
    }

    public String getRepairs()
    {
        return repairs;
    }

    public void setRepairs(String repairs)
    {
        this.repairs = repairs;
    }

    public Boolean getMoisture()
    {
        return moisture;
    }

    public void setMoisture(Boolean moisture)
    {
        this.moisture = moisture;
    }

    public Boolean getSponge()
    {
        return sponge;
    }

    public void setSponge(Boolean sponge)
    {
        this.sponge = sponge;
    }

    public Boolean getMold()
    {
        return mold;
    }

    public void setMold(Boolean mold)
    {
        this.mold = mold;
    }

    public Boolean getFire()
    {
        return fire;
    }

    public void setFire(Boolean fire)
    {
        this.fire = fire;
    }

    public Boolean getOtherDamage()
    {
        return otherDamage;
    }

    public void setOtherDamage(Boolean otherDamage)
    {
        this.otherDamage = otherDamage;
    }

    public String getMoistureDesctription()
    {
        return moistureDesctription;
    }

    public void setMoistureDesctription(String moistureDesctription)
    {
        this.moistureDesctription = moistureDesctription;
    }

    public String getSpongeDescription()
    {
        return spongeDescription;
    }

    public void setSpongeDescription(String spongeDescription)
    {
        this.spongeDescription = spongeDescription;
    }

    public String getMoldDescription()
    {
        return moldDescription;
    }

    public void setMoldDescription(String moldDescription)
    {
        this.moldDescription = moldDescription;
    }

    public String getFireDescription()
    {
        return fireDescription;
    }

    public void setFireDescription(String fireDescription)
    {
        this.fireDescription = fireDescription;
    }

    public String getOtherDamageDescription()
    {
        return otherDamageDescription;
    }

    public void setOtherDamageDescription(String otherDamageDescription)
    {
        this.otherDamageDescription = otherDamageDescription;
    }

}
