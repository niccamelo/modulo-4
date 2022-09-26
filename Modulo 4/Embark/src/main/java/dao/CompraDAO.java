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
import model.Compra;

public class CompraDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void saveUser(Compra compra) {


		String sql = "INSERT INTO compra (data_compra, nome_cliente, quantidade_compra, destino, valorCompra, nota_fiscal)" + " VALUES(?,?,?,?,?,?)";

		try {
			
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);


			pstm.setString(1, compra.getdata_compra());
			pstm.setString(2, compra.getnome_cliente());
			pstm.setInt(3, compra.getquantidade_compra());
			pstm.setString(4, compra.getdestino());
			pstm.setString(5, compra.getvalorCompra());
			pstm.setInt(6, compra.getnota_fiscal());

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
		String sql = "DELETE FROM compra" + " WHERE nota_fiscal = ?";

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

		String sql = "DELETE FROM compra WHERE nota_fiscal = ?";

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

	
	public void updateUser(Compra compra) {
		String sql = "UPDATE compra SET data_compra = ?,nome_cliente = ?, quantidade_compra = ?, destino = ?, valorCompra = ?" + " WHERE nota_fiscal = ?";
		
		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, compra.getdata_compra());
			pstm.setString(2, compra.getnome_cliente());
			pstm.setInt(3, compra.getquantidade_compra());
			pstm.setString(4, compra.getdestino());
			pstm.setString(5, compra.getvalorCompra());
			pstm.setInt(6, compra.getnota_fiscal());
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
	
	
	
	
	public List<Compra> readUsers() {
		String sql = "select * from compra;";

		List<Compra> Compra = new ArrayList<Compra>();

		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Compra compra = new Compra();
				
				compra.setnota_fiscal(rset.getInt("nota_fiscal"));
				compra.setnome_cliente(rset.getString("nome_cliente"));
				compra.setnome_cliente(rset.getString("data_compra"));
				compra.setquantidade_compra(rset.getInt("quantidade_compra"));
				compra.setdestino(rset.getString("destino"));
				compra.setvalorCompra(rset.getString("valorCompra"));
				Compra.add(compra);
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

		return Compra;
	}

	
	
	public Compra getcompraByid(int id) {

		String sql = "SELECT * FROM compra where nota_fiscal = ?";
		Compra compra = new Compra();

		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			compra.setnota_fiscal(rset.getInt("nota_fiscal"));
			compra.setdata_compra(rset.getString("data_compra"));
			compra.setnome_cliente(rset.getString("nome_cliente"));
			compra.setquantidade_compra(rset.getInt("quantidade_compra"));
			compra.setdestino(rset.getString("destino"));
			compra.setvalorCompra(rset.getString("valorCompra"));

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
		return compra;
	}

}
