package com.oracle.entity;

public class Nominee {
private String name;
private long phoneNo;
private String relationship;
private String address;
private byte[]  idProof;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(long phoneNo) {
	this.phoneNo = phoneNo;
}
public String getRelationship() {
	return relationship;
}
public void setRelationship(String relationship) {
	this.relationship = relationship;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public byte[] getIdProof() {
	return idProof;
}
public void setIdProof(byte[] idProof) {
	this.idProof = idProof;
}

}