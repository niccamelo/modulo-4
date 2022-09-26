package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.connection;
import model.Hospedagem;

public class HospDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void saveUser(Hospedagem hospedagem) {


		String sql = "INSERT INTO hospedagem (nomeHosp, cidade, estado, rua)" + " VALUES(?,?,?,?)";

		try {
			
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);


			pstm.setString(1, hospedagem.getnomeHosp());
			pstm.setString(2, hospedagem.getcidade());
			pstm.setString(3, hospedagem.getestado());
			pstm.setString(4, hospedagem.getrua());


			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void deleteUser(int id) {
		String sql = "DELETE FROM hospedagem" + " WHERE id_hosp = ?";

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void removeById(int id) {

		String sql = "DELETE FROM hospedagem WHERE id_hosp = ?";

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	
	public void updateUser(Hospedagem hospedagem) {
		String sql = "UPDATE hospedagem SET nomeHosp = ?,cidade = ?, estado = ?, rua = ?" + " WHERE id_hosp = ?";
		
		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, hospedagem.getnomeHosp());
			pstm.setString(2, hospedagem.getcidade());
			pstm.setString(3, hospedagem.getestado());
			pstm.setString(4, hospedagem.getrua());
			pstm.setInt(5, hospedagem.getid_hosp());
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		}
	}
	
	
	
	
	public List<Hospedagem> readUsers() {
		String sql = "select * from hospedagem;";

		List<Hospedagem> Hospedagem = new ArrayList<Hospedagem>();

		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Hospedagem hospedagem = new Hospedagem();
				
				hospedagem.setid_hosp(rset.getInt("id_hosp"));
				hospedagem.setnomeHosp(rset.getString("nomeHosp"));
				hospedagem.setcidade(rset.getString("cidade"));
				hospedagem.setestado(rset.getString("estado"));
				hospedagem.setrua(rset.getString("rua"));
				Hospedagem.add(hospedagem);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return Hospedagem;
	}

	
	
	public Hospedagem gethospedagemByid(int id) {

		String sql = "SELECT * FROM hospedagem where id_hosp = ?";
		Hospedagem hospedagem = new Hospedagem();

		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			hospedagem.setid_hosp(rset.getInt("id_hosp"));
			hospedagem.setnomeHosp(rset.getString("nomeHosp"));
			hospedagem.setcidade(rset.getString("cidade"));
			hospedagem.setestado(rset.getString("estado"));
			hospedagem.setrua(rset.getString("rua"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return hospedagem;
	}

}
