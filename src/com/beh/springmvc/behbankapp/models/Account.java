package com.beh.springmvc.behbankapp.models;


public class Account {
//    @NotNull(message="Account # cant be blank")
	private Integer accountNumber;
    
//    @NotNull(message="Account Holder Name cant be blank")
	private String accountHolderName;
    
//    @NotNull(message="Account Balance is required")
	private Integer accountBalance;
   
//   @NotNull(message="Account Type cant be null")
//	private String accountType;
//
//    @DateTimeFormat(pattern="MM/dd/yyyy")
//    @NotNull(message="Date of birth can't be null")
//	private Date dateOfBirth;
//   
//    @NotNull(message="PS Code is required")
//	private String psCode;
	
	public Account() {
		this.accountNumber = 0;
		this.accountHolderName = "";
		this.accountBalance = 0;
//		this.accountType="";
//		this.dateOfBirth=new Date();
//		this.psCode="";
	}

	
	public Account(Integer accNumber, String accHolderName, Integer accBalance) {
//		,String accType, Date dob, String psCod) {

		this.accountNumber = accNumber;
		this.accountHolderName = accHolderName;
		this.accountBalance = accBalance;
//		this.accountType = accType;
//		this.dateOfBirth = dob;
//		this.psCode = psCod;
	}


	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Integer getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Integer accountBalance) {
		this.accountBalance = accountBalance;
	}
	

//	public String getAccountType() {
//		return accountType;
//	}
//
//
//	public void setAccountType(String accountType) {
//		this.accountType = accountType;
//	}
//
//	public Date getDateOfBirth() {
//		return dateOfBirth;
//	}
//
//
//	public void setDateOfBirth(Date dateOfBirth) {
//		this.dateOfBirth = dateOfBirth;
//	}
//
//	public String getPsCode() {
//		return psCode;
//	}
//
//	public void setPsCode(String psCode) {
//		this.psCode = psCode;
//	}


	

}
