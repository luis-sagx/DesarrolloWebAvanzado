package espe.edu.app1.dao;
import espe.edu.app1.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public boolean save(User user) {
        String sql = "INSERT INTO user (name, lastName, age) VALUES (?,?,?)";
        try(Connection conn = Conection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLastName());
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
        try(Connection conn = Conection.getConnection();
                PreparedStatement stmt =  conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()){
            
            while(rs.next()){
                User user =  new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("lastName"));
                user.setAge(rs.getInt("age"));
                users.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return users;
    }
    
    public User findById(Long id) {
        String sql = "Select * FROM user WHERE id = ?";
        User user = null;
        try(Connection conn = Conection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    user = new User();
                    user.setId(rs.getLong("id"));
                    user.setName(rs.getString("name"));
                    user.setLastName(rs.getString("lastName"));
                    user.setAge(rs.getInt("age"));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }
    
    public boolean update(User user) {
        String sql = "UPDATE user set name = ?, lastName = ?, age = ? WHERE id = ?";
        try(Connection conn = Conection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLastName());
            stmt.setInt(3, user.getAge());
            stmt.setLong(4, user.getId());
            
            return stmt.executeUpdate()>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
     
    public boolean delete(Long id) {
        String sql = "DELETE FROM user WHERE id = ?";
        try(Connection conn = Conection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}