package utility;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import stockManagement.Pen;
import stockManagement.PenType;

public class UtilityManagement {

	static ArrayList<Pen> penList = new ArrayList<>();

	public static void addPen(int id, String brand, String color, String inkColor, String material, String pentype,
			double price) {

		PenType type = validateType(pentype);
		LocalDate date = LocalDate.now();
		Pen pen = new Pen(id, brand, color, inkColor, material, type, price, date);
		penList.add(pen);

	}

	public static PenType validateType(String pentype) throws IllegalArgumentException {

		for (PenType search : PenType.values()) {
			if (search.name().equalsIgnoreCase(pentype)) {
				return PenType.valueOf(pentype.toUpperCase());
			}

		}
		throw new IllegalArgumentException("Value wrong");
	}

	public static void ShowStock() {
		for (Pen a : penList) {
			System.out.println(a);
		}

	}

	public static void removePenOld() {
		for (int i = 0; i < penList.size(); i++) {
			if (penList.get(i).getInserDate().isBefore(LocalDate.now().minusMonths(3))) {
				penList.remove(i);

			}
		}
	}

	public static void updateDate(int id, String modifydate) {
		for (int i = 0; i < penList.size(); i++) {
			if (penList.get(i).getId() == id)

			{
				penList.get(i).setInserDate(LocalDate.parse(modifydate));

			}
		}

	}

	public static void setDiscountFoOldPen() {
		for (int i = 0; i < penList.size(); i++) {
			if (penList.get(i).getInserDate().isBefore(LocalDate.now().minusMonths(8))) {
				penList.get(i).setDiscount(30.00);

			}
		}

	}
	
	
	public static void writefile(String fileName) throws Exception
	{
		FileOutputStream fileoutputstream= new FileOutputStream(fileName);
		ObjectOutputStream objectoutpustream=new ObjectOutputStream(fileoutputstream);
		
		objectoutpustream.writeObject(penList);
		objectoutpustream.close();
		fileoutputstream.close();
		
	}
	public static ArrayList<Pen> readfile(String fileName) throws Exception
	{
		FileInputStream fileinputstream= new FileInputStream(fileName);
		ObjectInputStream objectinpustream=new ObjectInputStream(fileinputstream);
		
		 @SuppressWarnings("unchecked")
		ArrayList<Pen> temp=( ArrayList<Pen>)objectinpustream.readObject();
		objectinpustream.close();
		fileinputstream.close();
		return temp;
	}
	
	public static void sortById() {
		
		Collections.sort(penList);
		for(Pen trav:penList) 
		{
			System.out.println(trav);
		}
	}

}
