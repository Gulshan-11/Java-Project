package com.oracle.entity;

public class Program {
	private String loanType;
	private String programName;
	private long min_amt;
	private long max_amt;
	private long min_tenure;
	private long max_tenure;
	private float roi;
	private String programDescription;
	
	public Program() {
	}
	public Program(String loanType, String programName, long min_amt, long max_amt, long min_tenure, long max_tenure,
			float roi, String programDescription) {
		super();
		this.loanType = loanType;
		this.programName = programName;
		this.min_amt = min_amt;
		this.max_amt = max_amt;
		this.min_tenure = min_tenure;
		this.max_tenure = max_tenure;
		this.roi = roi;
		this.programDescription = programDescription;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public long getMin_amt() {
		return min_amt;
	}
	public void setMin_amt(long min_amt) {
		this.min_amt = min_amt;
	}
	public long getMax_amt() {
		return max_amt;
	}
	public void setMax_amt(long max_amt) {
		this.max_amt = max_amt;
	}
	public long getMin_tenure() {
		return min_tenure;
	}
	public void setMin_tenure(long min_tenure) {
		this.min_tenure = min_tenure;
	}
	public long getMax_tenure() {
		return max_tenure;
	}
	public void setMax_tenure(long max_tenure) {
		this.max_tenure = max_tenure;
	}
	public float getRoi() {
		return roi;
	}
	public void setRoi(float roi) {
		this.roi = roi;
	}
	public String getProgramDescription() {
		return programDescription;
	}
	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}
	
	

}
