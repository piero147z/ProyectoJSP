package nombredominio.models;

public class Usuario {

	private int id;
	private String nombre;
	private String mail;
	private String contraseña;
	public Usuario() {
		this.id = id;
		this.nombre = nombre;
		this.mail = mail;
		this.contraseña = contraseña;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", mail=" + mail + ", contraseña=" + contraseña + "]";
	}
	
}
