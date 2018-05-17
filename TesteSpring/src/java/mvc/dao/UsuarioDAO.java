package mvc.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import mvc.bean.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Raymison
 */
@Repository
public class UsuarioDAO {
    private final Connection connection;
    
    @Autowired
    public UsuarioDAO(DataSource dataSource){
        try{
            this.connection = dataSource.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public boolean adcUsuario(Usuario usuario){
        String sql = "insert into usuarios (usulogin,ususenha) values (?,?)";
        try(
        PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return true;
    }
    
    public List<Usuario> listarUsuarios(){
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        String sql = "select * from usuarios order by usulogin";
        try(
        PreparedStatement stmt = connection.prepareStatement(sql)){
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("usuid"));
            usuario.setLogin(rs.getString("usulogin"));
            //usuario.setSenha(rs.getString("senha"));
            listaUsuarios.add(usuario);
        }
      }catch(SQLException e){
          throw new RuntimeException(e);
      }
      return listaUsuarios;
    }
    
    public boolean removerUsuario(int id){
        String sql = "delete from usuarios where usuid=?";
        try(
                PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return true;
    }
    
    public Usuario buscarUsuarioPorId(int id) throws SQLException{
        String sql="select * from usuarios where usuid=?";
        Usuario usuario = new Usuario(); 
        
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                
                usuario.setId(rs.getInt("usuid"));
                usuario.setLogin("usulogin");
                usuario.setSenha("ususenha");
            }
        
        return usuario;
    }
    
    public boolean alterarUsuario(Usuario usuario){
        String sql = "update usuarios set usulogin=?,"
                +"ususenha=? where usuid=?";
        try(
              PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setInt(3, usuario.getId());
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return true;
    }
}

