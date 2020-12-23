package com.wipro.assignment.phonedirectory;

class Directory implements Comparable<Object> {
	int id;
	String name;
	String address;
	int phoneNo;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
    @Override
	public int compareTo(Object ob) throws ClassCastException {
		if (!(ob instanceof Directory))
			throw new ClassCastException("Error");
		int ide = ((Directory) ob).getId();
		return this.id - ide;
	}
}