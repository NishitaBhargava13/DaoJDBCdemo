package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Product;

public class ProductDAOImpl implements ProductDAO{
	private static final String DELETE = "delete from product where pid = ?";
	private static final String FIND_ALL = "select * from product order by pid ";
	private static final String  FIND_BY_ID = "select * from product where pid=?";
	private static final String FIND_BY_NAME = "select * from product where p_name=?";
	private static final String INSERT = "insert into product (pid , p_name , p_price) values(?,?,?) ";
	private static final String UPDATE = "update product set p_name = ?,p_price = ? where pid = ?";
	
	
	
	@Override
	public int delete(int pid){
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 int rs = 0 ;
		 try {
			con = DBConnection.dbCon();
			//statement creation
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, pid);
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			 
		}
		 finally {
			 try {
				 pstmt.close();
				 con.close();
			 }catch(SQLException   e) {
				 e.printStackTrace();
			 }
			 
			return rs;
		 }
	}

	
	@Override
	public List<Product> findAll() {
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 List<Product> prodList = new ArrayList<>();
		 try {
			con = DBConnection.dbCon();
			//statement creation
			pstmt = con.prepareStatement(FIND_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Product pObj = new Product();
//				pObj.setPid(rs.getInt(DELETE));
				pObj.setPid(rs.getInt(1));
				pObj.setName(rs.getString("p_name"));
				pObj.setPrice(rs.getFloat(3));
				prodList.add(pObj);
			}
		} catch (Exception e) {}
		 finally {
			 try {
				 pstmt.close();
				 con.close();
			 }catch(SQLException e) {
				 e.printStackTrace();
			 }
			 
		 }
		 return prodList;
	}

	
	@Override
	public Product findById(int pid) {
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 Product pObj = null;
		 try {
			con = DBConnection.dbCon();
			//statement creation
			pstmt = con.prepareStatement(FIND_BY_ID);
			pstmt.setInt(1, pid);
			ResultSet rs = pstmt.executeQuery() ;
			
			if(rs.next()) {
				pObj = new Product();
//				pObj.setPid(rs.getInt(DELETE));
				pObj.setPid(rs.getInt(1));
				pObj.setName(rs.getString("p_name"));
				pObj.setPrice(rs.getFloat(3));
				 
			}else {
				return null;
			}
		} catch (Exception e) {}
		 finally {
			 try {
				 pstmt.close();
				 con.close();
			 }catch(SQLException e) {
				 e.printStackTrace();
			 }
			  
		 }
		 return pObj;
	}

	
	@Override
	public Product findByName(String p_name) {
		 Connection con = null;
		 PreparedStatement pstmt = null;
		 Product pObj = null;
		 try {
			con = DBConnection.dbCon();
			//statement creation
			pstmt = con.prepareStatement(FIND_BY_NAME);
			pstmt.setString(1, p_name);
			ResultSet rs = pstmt.executeQuery() ;
			
			if(rs.next()) {
				pObj = new Product();
//				pObj.setPid(rs.getInt(DELETE));
				pObj.setPid(rs.getInt(1));
				pObj.setName(rs.getString("p_name"));
				pObj.setPrice(rs.getFloat(3));
			} 
		} catch (Exception e) {}
		 finally {
			 try {
				 pstmt.close();
				 con.close();
			 }catch(SQLException e) {
				 e.printStackTrace();
			 }
			  
		 }
		 return pObj;
	}

	
	@Override
	public int update(Product pObj) {
		 Connection con = null;
		 PreparedStatement pstmt = null;
	
		 int rs = 0;
		 try {
			con = DBConnection.dbCon();
			//statement creation
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, pObj.getName());
			pstmt.setFloat(2, pObj.getPrice());
			pstmt.setInt(3, pObj.getPid());
			rs = pstmt.executeUpdate() ;
		} catch (Exception e) {}
		 
				 finally {
					 try {
						 pstmt.close();
						 con.close();
					 }catch(SQLException e) {
						 e.printStackTrace();
					 } 
				 }
		 
		 return rs;
		
	}
 

	@Override
	public int insert(Product pObj) {
		Connection con = null;
		PreparedStatement pstmt = null;
        int rs = 0;
		 try {
			con = DBConnection.dbCon();
			//statement creation
			pstmt = con.prepareStatement(INSERT);
			
			pstmt.setInt(1, pObj.getPid());
			pstmt.setString(2, pObj.getName());
			pstmt.setFloat(3, pObj.getPrice());
			
			rs = pstmt.executeUpdate() ;
			
		} catch (Exception e) {}
		 
			 finally {
				 try {
					 pstmt.close();
					 con.close();
				 }catch(SQLException e) {
					 e.printStackTrace();
				 }
			 }
		 return rs;
	}
 
}
