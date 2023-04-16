package modele;

public class modeleAuteur {
	    private int id;
	    private String noms;
	    private String prenom;
	    private String nation;
	    
	    
	    public modeleAuteur() {
			
			super();
		// TODO Auto-generated constructor stub
		
	}
	    
		public modeleAuteur(String noms, String prenom, String nation) {
			super();
			this.noms = noms;
			this.prenom = prenom;
			this.nation = nation;
		}


		public modeleAuteur(int id, String noms, String prenom, String nation) {
			super();
			this.id = id;
			this.noms = noms;
			this.prenom = prenom;
			this.nation = nation;
		}


		


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getNoms() {
			return noms;
		}


		public void setNoms(String noms) {
			this.noms = noms;
		}


		public String getPrenom() {
			return prenom;
		}


		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}


		public String getNation() {
			return nation;
		}


		public void setNation(String nation) {
			this.nation = nation;
		}
	    
		
		@Override
		public String toString() {
			return "modeleAuteur [id=" + id + ", Noms=" + noms + ", Prenom=" + prenom + ", Nation=" + nation
					+ "]";
		}
}
