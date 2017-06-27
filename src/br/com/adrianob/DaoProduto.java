package br.com.adrianob;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoProduto {

	
	public List<Produto> getLista(){
		List<Produto> lst = new ArrayList<Produto>();
		Connection c = new ConnectionFactory().getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("select * from produto");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getLong("id"));
				p.setNome(rs.getString("nome"));
				lst.add(p);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);			
		}
		return lst;
		
	}
	
	public DaoProduto() {
		// TODO Auto-generated constructor stub
	}
	
}
