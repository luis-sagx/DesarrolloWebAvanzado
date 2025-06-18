package espe.edu.app.dao;
import espe.edu.app.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public boolean save(User user) {
        String sql = "INSERT INTO users(name, lastname,age) VALUES (?,?,?)";
        try(Connection conn = Conexion.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, user.getfName());
            stmt.setString(2, user.getlName());
            stmt.setInt(3, user.getAge());
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    };
    
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try(Connection conn = Conexion.getConnection();
                PreparedStatement stmt =  conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()){
            
            while(rs.next()){
                User user =  new User();
                user.setId(rs.getLong("id"));
                user.setfName(rs.getString("name"));
                user.setlName(rs.getString("lastname"));
                user.setAge(rs.getInt("age"));
                users.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return users;
    }
    
    public User findById(Long id) {
        String sql = "Select * FROM users WHERE id = ?";
        User user = null;
        try(Connection conn = Conexion.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    user = new User();
                    user.setId(rs.getLong("id"));
                    user.setfName(rs.getString("name"));
                    user.setlName(rs.getString("lastname"));
                    user.setAge(rs.getInt("age"));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }
    
    public boolean update(User user) {
        String sql = "UPDATE users set name = ?, lastName = ?, age = ? WHERE id = ?";
        try(Connection conn = Conexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, user.getfName());
            stmt.setString(2, user.getlName());
            stmt.setInt(3, user.getAge());
            stmt.setLong(3, user.getId());
            
            return stmt.executeUpdate()>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
     
    public boolean delete(Long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try(Connection conn = Conexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}