package stockManagement;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Pen implements Serializable,Comparable<Pen>{

	private int id;
	private String Brand;
	private String Color;
	private String InkColor;
	private String Material;
	private PenType pentype;
	private double price;
	private double Discount = 20;
	LocalDate InserDate;

	public Pen(int id, String brand, String color, String inkColor, String material, PenType pentype, double price,
			LocalDate inserDate) {
		super();
		this.id = id;
		Brand = brand;
		Color = color;
		InkColor = inkColor;
		Material = material;
		this.pentype = pentype;
		this.price = price;
		InserDate = inserDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public String getInkColor() {
		return InkColor;
	}

	public void setInkColor(String inkColor) {
		InkColor = inkColor;
	}

	public String getMaterial() {
		return Material;
	}

	public void setMaterial(String material) {
		Material = material;
	}

	public PenType getPentype() {
		return pentype;
	}

	public void setPentype(PenType pentype) {
		this.pentype = pentype;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return Discount;
	}

	public void setDiscount(double discount) {
		Discount = discount;
	}

	public void setInserDate(LocalDate inserDate) {
		InserDate = inserDate;
	}

	@Override
	public String toString() {
		return "Pen [id=" + id + ", Brand=" + Brand + ", Color=" + Color + ", InkColor=" + InkColor + ", Material="
				+ Material + ", pentype=" + pentype + ", price=" + price + ", Discount=" + Discount + ", InserDate="
				+ InserDate + "]";
	}

	public LocalDate getInserDate() {
		// TODO Auto-generated method stub
		return InserDate;
	}
	
	@Override
	public int compareTo(Pen that)
	{
		if(this.id<that.id) 
		{
			return -1;
			
		}else
		return 1;
		
		
	}
 

}
