
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
    String adress;
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
    
    
    
}
