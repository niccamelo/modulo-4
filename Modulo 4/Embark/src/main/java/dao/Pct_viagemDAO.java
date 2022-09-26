package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.connection;
import model.Pct_viagem;
import model.Hospedagem;

public class Pct_viagemDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void saveUser(Pct_viagem pct_viagem) {


		String sql = "INSERT INTO pct_viagem (preço, data_da_viagem, destino, condução, id_hosp)" + " VALUES(?,?,?,?,?)";

		try {
			
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);


			pstm.setString(1, pct_viagem.getpreço());
			pstm.setString(2, pct_viagem.getdata_da_viagem());
			pstm.setString(3, pct_viagem.getdestino());
			pstm.setString(4, pct_viagem.getcondução());
		pstm.setInt(5, pct_viagem.getid_hosp());


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
		String sql = "DELETE FROM pct_viagem" + " WHERE id_hosp = ?";

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
	
	
	
	public void updateUser(Pct_viagem pct_viagem) {
		String sql = "UPDATE pct_viagem SET preço = ?,data_da_viagem = ?, destino = ?, condução = ?" + " WHERE id_destino = ? AND id_hosp = ?";
		
		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pct_viagem.getpreço());
			pstm.setString(2, pct_viagem.getdata_da_viagem());
			pstm.setString(3, pct_viagem.getdestino());
			pstm.setString(4, pct_viagem.getcondução());
			pstm.setInt(5, pct_viagem.getid_hosp());
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
	
	
	
	
	public List<Pct_viagem> readUsers() {
		String sql = "select * from pct_viagem;";

		List<Pct_viagem> Pct_viagem = new ArrayList<Pct_viagem>();

		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Pct_viagem pct_viagem = new Pct_viagem();
				
				pct_viagem.setpreço(rset.getString("preço"));
				pct_viagem.setdata_da_viagem(rset.getString("data_da_viagem"));
				pct_viagem.setdestino(rset.getString("destino"));
				pct_viagem.setcondução(rset.getString("condução"));
			pct_viagem.setid_hosp(rset.getInt("id_hosp"));
				Pct_viagem.add(pct_viagem);
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

		return Pct_viagem;
	}

	
	
	public Pct_viagem getPct_viagemByid(int id) {

		String sql = "SELECT * FROM pct_viagem where id_destino = ?";
		Pct_viagem pct_viagem = new Pct_viagem();

		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			pct_viagem.setpreço(rset.getString("preço"));
			pct_viagem.setdata_da_viagem(rset.getString("data_da_viagem"));
			pct_viagem.setdestino(rset.getString("destino"));
			pct_viagem.setcondução(rset.getString("condução"));
			pct_viagem.setid_hosp(rset.getInt("id_hosp"));

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
		return pct_viagem;
	}
	
	


}
