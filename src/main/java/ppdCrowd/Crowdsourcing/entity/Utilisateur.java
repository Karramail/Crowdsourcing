package ppdCrowd.Crowdsourcing.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur {
	
	
	
	@Id
	private int id;
	
	private Date createdAt;
	
	private String userType;
	
	private String email;
	
	private String username;
	
	@OneToMany(mappedBy="idDemandeur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Import> imports;
	
	public Utilisateur() {
		super();
		
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Import> getImports() {
		return imports;
	}

	public void setImports(List<Import> imports) {
		this.imports = imports;
	}

	


}
