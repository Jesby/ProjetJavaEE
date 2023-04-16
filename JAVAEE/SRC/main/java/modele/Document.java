package modele;

public class Document {
	   private int id;
	   private int id_auteur;
	   private int id_type;
	   private int id_maison;
	   private String Libelle;
	   private String Description;
	   private String Domaine;

	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}

	    

	public int getId_auteur() {
		return id_auteur;
	}



	public void setId_auteur(int id_auteur) {
		this.id_auteur = id_auteur;
	}

     

	public int getId_type() {
		return id_type;
	}



	public void setId_type(int id_type) {
		this.id_type = id_type;
	}



	public int getId_maison() {
		return id_maison;
	}



	public void setId_maison(int id_maison) {
		this.id_maison = id_maison;
	}

   

	public Document(int id, int id_auteur, int id_type, int id_maison, String libelle, String description,
			String domaine) {
		super();
		this.id = id;
		this.id_auteur = id_auteur;
		this.id_type = id_type;
		this.id_maison = id_maison;
		Libelle = libelle;
		Description = description;
		Domaine = domaine;
	}



	public Document(int id, int id_auteur, String libelle, String description, String domaine) {
		super();
		this.id = id;
		this.id_auteur = id_auteur;
		Libelle = libelle;
		Description = description;
		Domaine = domaine;
	}



	public Document(String libelle, String description, String domaine) {
		super();
		Libelle = libelle;
		Description = description;
		Domaine = domaine;
	}
	

	public Document(int id, String libelle, String description, String domaine) {
		super();
		this.id = id;
		Libelle = libelle;
		Description = description;
		Domaine = domaine;
	}



	public Document(int idAuteur, int idTypeDoc, int idMaison, String name, String description2,
			String domaine2) {
		this.id_auteur = idAuteur;
		this.id_type = idTypeDoc;
		this.id_maison = idMaison;
		Libelle = name;
		Description = description2;
		Domaine = domaine2;
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLibelle() {
		return Libelle;
	}


	public void setLibelle(String libelle) {
		Libelle = libelle;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public String getDomaine() {
		return Domaine;
	}


	public void setDomaine(String domaine) {
		Domaine = domaine;
	}


	@Override
	public String toString() {
		return "Document [id=" + id + ", id_auteur=" + id_auteur + ", id_type=" + id_type + ", id_maison=" + id_maison
				+ ", Libelle=" + Libelle + ", Description=" + Description + ", Domaine=" + Domaine + "]";
	}
}
