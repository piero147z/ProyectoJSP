package nombredominio.modelsDAO;

import nombredominio.config.Conexion;
import nombredominio.models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAO {

	Conexion conectar = new Conexion();
	//asdlksadksañldksalñdksadñlaskdlñakd
	

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	Statement statement;

	Usuario usuario = new Usuario();
	ArrayList<Usuario> usuarios = new ArrayList<>();

	public Usuario save(Usuario usuario) {
		String sql="INSERT INTO usuario (nombre,email) VALUES ('"+ usuario.getNombre() + "','"
				+ usuario.getMail() +"')";
		
		try {
			conn = conectar.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return usuario;
	}

	public boolean delete(int id) {
		String sql = "DELETE FROM usuario WHERE id = " + id;
		conn = conectar.getConnection();
		Statement statement;

		try {
			statement = conn.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public Usuario update(Usuario usuario) {
		String sql = "UPDATE usuario SET nombre = '" + usuario.getNombre() + "', email = '" + usuario.getMail()
				+ "' WHERE id=" + usuario.getId();

		try {
			conn = conectar.getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usuario;
	}

	public Usuario find(int id) {
		String sql = "SELECT * FROM usuario WHERE id= " + id;

		try {

			conn = conectar.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				usuario.setId(rs.getInt("id"));
				usuario.setNombre("nombre");
				usuario.setMail("email");
				usuario.setContraseña("password");

				return usuario;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Usuario> all() {
		String sql = "SELECT * FROM usuario";

		try {

			conn = conectar.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setMail(rs.getString("email"));
				usuario.setContraseña(rs.getString("password"));
				usuarios.add(usuario);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usuarios;
	}
	
	public boolean validate(String email,String password) {
		String sql ="SELECT * FROM usuario where email = '" + email + "' AND password = '" + password + "'";
		
		try {

			conn = conectar.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			if(rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return false;
	}
	
	public Usuario getUsuario(String email,String password) {
		String sql ="SELECT * FROM usuario where email = '" + email + "' AND password = '" + password + "'";
		
		try {

			conn = conectar.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setMail(rs.getString("email"));
				usuario.setContraseña(rs.getString("password"));

				return usuario;
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
	}

}
