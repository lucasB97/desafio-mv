package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CollaboratorDAO {

	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://ec2-54-209-187-69.compute-1.amazonaws.com:5432/d431jgn17ernmu?sslmode=require";
	private String user = "shjvtlmecpvxxy";
	private String password = "a81613ae79d8c484515134832615c50ab45ce5a50c0e0d7f698d3a3582efcf1a";

	// Conexão
	private Connection connect() {
		Connection con = null;
		try {
			// Lendo o driver do db
			Class.forName(driver);
			// Obtendo os paramêtros de conexão
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void insertCollaborator(CollaboratorModel collaborator) {
		Connection con = connect();
		String create = "insert into collaborator (cpf, contributor_name, breakfast_food) values (?,?,?)";
		String verifiesCpf = "select * from collaborator where cpf = ? or breakfast_food = ?";
		try {
			PreparedStatement pstCPF = con.prepareStatement(verifiesCpf);
			pstCPF.setString(1, collaborator.getCpf());
			pstCPF.setString(2, collaborator.getbreakfastFood());
			ResultSet rs = pstCPF.executeQuery();
			if (rs.next()) {
				throw new Exception("Cpf ou comida já cadastrada");
			} else {
				// Preparando a query
				PreparedStatement pst = con.prepareStatement(create);
				// substituindo parâmetros
				pst.setString(1, collaborator.getCpf());
				pst.setString(2, collaborator.getcontributorName());
				pst.setString(3, collaborator.getbreakfastFood());
				// Executando a query
				pst.executeUpdate();
				// Fechando conexão
				con.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<CollaboratorModel> listCollaborator() {
		String read = "select * from collaborator order by contributor_name";
		ArrayList<CollaboratorModel> collaborators = new ArrayList<>();
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(read);
			// Armazenar o retorno do db temporariamente
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// Vatiáveis para receber os dados do db
				String id = rs.getString(1);
				String cpf = rs.getString(2);
				String contributorName = rs.getString(3);
				String breakfastFood = rs.getString(4);
				// Populando o ArrayList
				collaborators.add(new CollaboratorModel(id, cpf, contributorName, breakfastFood));
			}
			con.close();
			return collaborators;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void selectCollaborator(CollaboratorModel collaborator) {
		String select = "select * from collaborator where id = ?";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(select);
			pst.setString(1, collaborator.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				collaborator.setId(rs.getString(1));
				collaborator.setCpf(rs.getString(2));
				collaborator.setcontributorName(rs.getString(3));
				collaborator.setbreakfastFood(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateCollaborator(CollaboratorModel collaborator) {
		String update = "update collaborator set cpf=?, contributor_name=?, breakfast_food=? where id=?";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, collaborator.getCpf());
			pst.setString(2, collaborator.getcontributorName());
			pst.setString(3, collaborator.getbreakfastFood());
			pst.setString(4, collaborator.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deleteCollaborator(CollaboratorModel collaborator) {
		String delete = "delete from collaborator where id=?";
		try {
			Connection con = connect();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, collaborator.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
