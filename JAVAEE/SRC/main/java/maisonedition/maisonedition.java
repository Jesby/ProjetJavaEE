package maisonedition;

public class maisonedition {
	private int id_Maison;
	private String NomsMaison;
	
	
	
    public maisonedition() {
		
			super();
		// TODO Auto-generated constructor stub
    }
    
    
    
    
	public maisonedition(int id_Maison, String nomsMaison) {
		super();
		this.id_Maison = id_Maison;
		NomsMaison = nomsMaison;
	}




	public maisonedition(String noms) {
		// TODO Auto-generated constructor stub
	}




	public int getId_Maison() {
		return id_Maison;
	}
	
	public void setId_Maison(int id_Maison) {
		this.id_Maison = id_Maison;
	}
	
	public String getNomsMaison() {
		return NomsMaison;
	}
	
	public void setNomsMaison(String nomsMaison) {
		NomsMaison = nomsMaison;
	}




	@Override
	public String toString() {
		return "maisonedition [id_Maison=" + id_Maison + ", NomsMaison=" + NomsMaison + "]";
	}
	
	
	
	
	

}
