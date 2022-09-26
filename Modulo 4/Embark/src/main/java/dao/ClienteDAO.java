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
import model.Cliente;

public class ClienteDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void saveUser(Cliente cliente) {


		String sql = "INSERT INTO cliente(nome, email, cidade, cep, senha, sobre_nome, estado)" + " VALUES(?,?,?,?,?,?,?)";

		try {
			
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);


			pstm.setString(1, cliente.getnome());
			pstm.setString(2, cliente.getemail());
			pstm.setString(3, cliente.getcidade());
			pstm.setInt(4, cliente.getcep());
			pstm.setString(5, cliente.getsenha());
			pstm.setString(6, cliente.getsobre_nome());
			pstm.setString(7, cliente.getestado());


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
		String sql = "DELETE FROM cliente" + " WHERE id_cliente = ?";

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
	
	public void removeById(int id_cliente) {

		String sql = "DELETE FROM cliente WHERE id_cliente = ?";

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id_cliente);

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

	
	public void updateUser(Cliente cliente) {
		String sql = "UPDATE cliente SET nome = ?,  email= ?, cidade = ?, cep = ?, senha = ?, sobre_nome = ?, estado = ? " + " WHERE id_cliente = ? ";
		
		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

						pstm.setString(1, cliente.getnome());
						pstm.setString(2, cliente.getemail());
						pstm.setString(3, cliente.getcidade());
						pstm.setInt(4, cliente.getcep());
						pstm.setString(5, cliente.getsenha());
						pstm.setString(6, cliente.getsobre_nome());
						pstm.setString(7, cliente.getestado());
						pstm.setInt(8, cliente.getid_cliente());
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
	
	
	
	
	public List<Cliente> readUsers() {
		String sql = "select * from cliente;";

		List<Cliente> Cliente = new ArrayList<Cliente>();

		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setid(rset.getInt("id_cliente"));
				cliente.setnome(rset.getString("nome"));
				cliente.setemail(rset.getString("email"));
				cliente.setcidade(rset.getString("cidade"));
				cliente.setcep(rset.getInt("cep"));
				cliente.setsenha(rset.getString("senha"));
				cliente.setsobre_nome(rset.getString("sobre_nome"));
				cliente.setestado(rset.getString("estado"));
				Cliente.add(cliente);
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

		return Cliente;
	}

	
	
	public Cliente getclienteByid(int id) {

		String sql = "SELECT * FROM cliente where id_cliente = ?";
		Cliente cliente = new Cliente();

		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			cliente.setid(rset.getInt("id_cliente"));
			cliente.setnome(rset.getString("nome"));
			cliente.setemail(rset.getString("email"));
			cliente.setcidade(rset.getString("cidade"));
			cliente.setcep(rset.getInt("cep"));
			cliente.setsenha(rset.getString("senha"));
			cliente.setsobre_nome(rset.getString("sobre_nome"));
			cliente.setestado(rset.getString("estado"));

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
		return cliente;
	}

}
