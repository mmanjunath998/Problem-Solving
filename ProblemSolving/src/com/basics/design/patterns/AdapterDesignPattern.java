package com.basics.design.patterns;

interface Pen{
	void write(String str);
}

class CelloPen {
	public void mark(String str){
		System.out.println(str);
	}
}

class PenAdapter implements Pen{
	
	private CelloPen celloPen;
	
	public PenAdapter(CelloPen celloPen) {
		super();
		this.celloPen = celloPen;
	}

	@Override
	public void write(String str){
		celloPen.mark(str);
	}
}

class AssignmentWork {
	
	private Pen pen;
	
	public void writeAssignment(String str){
		pen.write(str);
	}
	
	public Pen getPen() {
		return pen;
	}
	public void setPen(Pen pen) {
		this.pen = pen;
	}
	
}

public class AdapterDesignPattern {


	public static void main(String[] args){
		PenAdapter penAdapter = new PenAdapter(new CelloPen());
		
		AssignmentWork assingment = new AssignmentWork();
		assingment.setPen(penAdapter);
		assingment.writeAssignment("i need to complete the design patterns");
		
	}
}
