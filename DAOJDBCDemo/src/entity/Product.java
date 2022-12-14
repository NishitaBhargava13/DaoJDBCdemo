package entity;

public class Product {
private int pid;
private String name;
private float price;

public Product() {
	
}
public Product(int pid, String name, float price) {
	this.pid = pid;
	this.name = name;
	this.price = price;
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return  "PRoduct ["+ getPid()+" "+getName()+" "+getPrice()+"]";
}

public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
}
