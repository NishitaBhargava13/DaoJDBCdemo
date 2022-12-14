 import java.util.List;
import java.util.Scanner;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import entity.Product;
 
public class Main {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 ProductDAO pDAOobj = new ProductDAOImpl();
		  
		 while(true) {
			 System.out.println("Welcome to Fashionista Store");
			 System.out.println("1.Add \n2.View \n3.Update \n4.Delete \n5.Search by Id \n6.Search by Name \n7.Exit");
			 System.out.println("enter the choice between 1 to 8");
			 int choice = sc.nextInt();
			 
			 switch(choice) {
			 case 1:{
				 System.out.println("Enter product id:");
				 int Id = sc.nextInt();
				 sc.nextLine();
				 System.out.println("Enter product name");
				 String name = sc.nextLine();
				 System.out.println("Enter product price:");
				 float price = sc.nextFloat();
				 
				 Product prodObj = new Product(Id  , name , price);
				 int rs = pDAOobj.insert(prodObj);
				 if( rs > 0)
					 System.out.println("Product inserted successfully");
				 else
					 System.out.println("Failed to add product record");
				 break;
			 }
			 case 2:{
				 List<Product> lst = pDAOobj.findAll();
				 for(Product p : lst) {
					 System.out.println(p.getPid()+" "+p.getName()+" "+p.getPrice());
				 }
				 break;
			 }
			 case 3:{
				 System.out.println("Enter product id whose record you want to update:");
				 int Id = sc.nextInt();
				 sc.nextLine();
				 System.out.println("Enter updated product name");
				 String name = sc.nextLine();
				 System.out.println("Enter updated product price:");
				 float price = sc.nextFloat();
				 
				 Product prodObj =  new Product(Id , name,price);
				 int rs =  pDAOobj.update(prodObj);
				 if( rs > 0)
					 System.out.println("Produt updated successfully");
				 else
					 System.out.println("Failed to update the product,Product with given ID not found!!!");
				 break;
			 }
			 case 4:{
				 System.out.println("Enter product id whose record you want to delete:");
				 int Id = sc.nextInt();
				 int rs = pDAOobj.delete(Id);
				 if(rs>0)
					 System.out.println("Deleted Successfully");
				 else
					 System.out.println("failed to delete product with specified id");
				 break;
			 }
			 case 5:{
				 System.out.println("Enter product(Id) which you want to search by id:");
				 int Id = sc.nextInt();
				 Product p = pDAOobj.findById(Id);
				 if(p != null) {
					 System.out.println("Product Found******");
					 System.out.println(p.getPid()+" "+p.getName()+" "+p.getPrice());
				 }
				 else
					 System.out.println("failed to Load product with specified id");
				 break;
			 }
			 case 6:{
				 System.out.println("Enter product(name) which you want to search by name:");
				 sc.nextLine();
				 String name = sc.nextLine();
				 Product p = pDAOobj.findByName(name);
				 if(p != null) {
					 System.out.println("Product Found******");
					 System.out.println(p.getPid()+" "+p.getName()+" "+p.getPrice());
				 }else
					 System.out.println("failed to Load product with specified id");
				  break;
			 }
			 case 7:{
				 System.out.println("Thankyou , have a nice day!!");
				  System.exit(0);
			 }
			 }
		 }

	}

}
