package test;
import java.io.*;
@SuppressWarnings("serial")
public class BookDetailsBean implements Serializable
{
 public BookDetailsBean()
 {
	 //Default Constructor
 }
 private String bCode,bName,Aname;
 private float bPrice;
public String getbCode() {
	return bCode;
}
public void setbCode(String bCode) {
	this.bCode = bCode;
}
public String getbName() {
	return bName;
}
public void setbName(String bName) {
	this.bName = bName;
}
public String getAname() {
	return Aname;
}
public void setAname(String aname) {
	Aname = aname;
}
public float getbPrice() {
	return bPrice;
}
public void setbPrice(float bPrice) {
	this.bPrice = bPrice;
}

}
