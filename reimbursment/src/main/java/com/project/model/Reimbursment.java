package com.project.model;

public class Reimbursment {
private int  reimb_id;
private double  reimb_amount;
private String  reimb_submitted;
private String reimb_resolved;
private User  reimb_author;
private  User reimb_resolver;
private String reimb_description;
private ReimbursmentStatus status;
private ReimbursmentType  type;

public Reimbursment(int reimb_id, double reimb_amount, String reimb_submitted, String reimb_resolved, User reimb_author,
		User reimb_resolver, String reimb_description, ReimbursmentStatus status, ReimbursmentType type) {
	super();
	this.reimb_id = reimb_id;
	this.reimb_amount = reimb_amount;
	this.reimb_submitted = reimb_submitted;
	this.reimb_resolved = reimb_resolved;
	this.reimb_author = reimb_author;
	this.reimb_resolver = reimb_resolver;
	this.reimb_description = reimb_description;
	this.status = status;
	this.type = type;
}

public Reimbursment( double reimb_amount, User reimb_author,
		User reimb_resolver, String reimb_description, ReimbursmentStatus status, ReimbursmentType type) {
	super();
	this.reimb_id = reimb_id;
	this.reimb_amount = reimb_amount;

	this.reimb_author = reimb_author;
	this.reimb_resolver = reimb_resolver;
	this.reimb_description = reimb_description;
	this.status = status;
	this.type = type;
}

public int getReimb_id() {
	return reimb_id;
}

public void setReimb_id(int reimb_id) {
	this.reimb_id = reimb_id;
}

public double getReimb_amount() {
	return reimb_amount;
}

public void setReimb_amount(double reimb_amount) {
	this.reimb_amount = reimb_amount;
}

public String getReimb_submitted() {
	return reimb_submitted;
}

public void setReimb_submitted(String reimb_submitted) {
	this.reimb_submitted = reimb_submitted;
}

public String getReimb_resolved() {
	return reimb_resolved;
}

public void setReimb_resolved(String reimb_resolved) {
	this.reimb_resolved = reimb_resolved;
}

public User getReimb_author() {
	return reimb_author;
}

public void setReimb_author(User reimb_author) {
	this.reimb_author = reimb_author;
}

public User getReimb_resolver() {
	return reimb_resolver;
}

public void setReimb_resolver(User reimb_resolver) {
	this.reimb_resolver = reimb_resolver;
}

public String getReimb_description() {
	return reimb_description;
}

public void setReimb_description(String reimb_description) {
	this.reimb_description = reimb_description;
}

public ReimbursmentStatus getStatus() {
	return status;
}

public void setStatus(ReimbursmentStatus status) {
	this.status = status;
}

public ReimbursmentType getType() {
	return type;
}

public void setType(ReimbursmentType type) {
	this.type = type;
}

@Override
public String toString() {
	return "Reimbursment [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
			+ reimb_submitted + ", reimb_resolved=" + reimb_resolved + ", reimb_author=" + reimb_author
			+ ", reimb_resolver=" + reimb_resolver + ", reimb_description=" + reimb_description + ", status=" + status
			+ ", type=" + type + "]";
}




}
