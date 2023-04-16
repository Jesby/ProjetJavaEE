package tydocument;

public class model {
	
	 private int id_Doc;
	 private String Designation;
	 
	
	public model() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public model(String noms) {
		// TODO Auto-generated constructor stub
	}

	public int getId_Doc() {
		return id_Doc;
	}
	
	public void setId_Doc(int id_Doc) {
		this.id_Doc = id_Doc;
	}
	
	public String getDesignation() {
		return Designation;
	}
	
	public void setDesignation(String designation) {
		Designation = designation;
	}
	 
	
	
	@Override
	public String toString() {
		return "model [id_Doc=" + id_Doc + ", Designation=" + Designation + "]";
	}
	 
	 
	 
}
