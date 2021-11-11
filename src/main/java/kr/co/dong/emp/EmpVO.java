package kr.co.dong.emp;

import java.util.Date;

public class EmpVO {
	public int empNo;
	public String eName;
	public String empJob;
	public int empMgr;
	public Date empHiredate;
	public int empsal;
	public int empComm;
	public int empDeptno;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getEmpJob() {
		return empJob;
	}
	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}
	public int getEmpMgr() {
		return empMgr;
	}
	public void setEmpMgr(int empMgr) {
		this.empMgr = empMgr;
	}
	public Date getEmpHiredate() {
		return empHiredate;
	}
	public void setEmpHiredate(Date empHiredate) {
		this.empHiredate = empHiredate;
	}
	public int getEmpsal() {
		return empsal;
	}
	public void setEmpsal(int empsal) {
		this.empsal = empsal;
	}
	public int getEmpComm() {
		return empComm;
	}
	public void setEmpComm(int empComm) {
		this.empComm = empComm;
	}
	public int getEmpDeptno() {
		return empDeptno;
	}
	public void setEmpDeptno(int empDeptno) {
		this.empDeptno = empDeptno;
	}
	@Override
	public String toString() {
		return "EmpVO [empNo=" + empNo + ", eName=" + eName + ", empJob=" + empJob + ", empMgr=" + empMgr
				+ ", empHiredate=" + empHiredate + ", empsal=" + empsal + ", empComm=" + empComm + ", empDeptno="
				+ empDeptno + "]";
	}
	
}
