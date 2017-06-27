package br.com.adrianob;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="OlaMundo",urlPatterns = {"/ola"})
public class OlaMundo extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		Produto p = new Produto();
		p.setNome(nome);
		Connection c = new ConnectionFactory().getConnection();
		try {
			PreparedStatement ps =	c.prepareStatement("insert into produto (nome) values (?)");
			ps.setString(1, p.getNome());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("/produto-adicionado.jsp");
		rd.forward(req, res);
	}
}
