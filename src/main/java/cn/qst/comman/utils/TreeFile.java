package cn.qst.comman.utils;

public class TreeFile {
	private String fid;
	private String fname;
	private boolean isChildFile;
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public boolean isChildFile() {
		return isChildFile;
	}
	public void setChildFile(boolean isChildFile) {
		this.isChildFile = isChildFile;
	}
	@Override
	public String toString() {
		return "TreeFile [fid=" + fid + ", fname=" + fname + ", isChildFile=" + isChildFile + "]";
	}
	
}
