package com.example.domain;

import java.util.Date;

public class FileUpload {

	private int id;
	private String name;
	private byte[] file;
	private String type;
	private String path;
	private long size;
	private int flag;
	private Date inserttime;

	public FileUpload(String name, String type, String path, long size) {
		this.name = name;
		this.type = type;
		this.path = path;
		this.size = size;
	}

	public FileUpload() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getInserttime() {
		return inserttime;
	}

	public void setInserttime(Date inserttime) {
		this.inserttime = inserttime;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "FileUpload [id=" + id + ", name=" + name + ", path=" + path + "]";
	}

}