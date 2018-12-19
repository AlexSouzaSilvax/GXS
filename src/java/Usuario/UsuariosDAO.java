package Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import util.Conexao;

public class UsuariosDAO {

    public UsuariosBean inserir(UsuariosBean user) {

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps;

            ps = conexao.prepareStatement("INSERT INTO `usuarios` (`nome`,`email`,`login`,`senha`,`dtCadastro`, `dtUltAlteracao` ) VALUES (?,?,?,?,?,?)");

            ps.setString(1, user.getNome());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getLogin());
            ps.setString(4, user.getSenha());
            //ps.setString(4, user.getCpf());
            //ps.setString(5, user.getTel());
            //ps.setString(6, user.getWhatsapp());
            ps.setDate(5, new java.sql.Date(user.getDtCadastro().getTime()));
            //user.setDtUltAlteracao(new Date());
            ps.setDate(6, new java.sql.Date(user.getDtUltAlteracao().getTime()));

            ps.execute();
            Conexao.fecharConexao();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário salvo com sucesso!", ""));
            System.out.println("Salvo com sucesso. ID: " + user.getId());
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar DAO " + ex.getMessage());
        }
        return user;
    }

    public UsuariosBean alterar(UsuariosBean user) {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps;
            ps = conexao.prepareStatement("update usuarios set nome = ?, email = ?, login = ?, senha = ?, dtUltAlteracao = ? where id = ?");

            ps.setString(1, user.getNome());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getLogin());
            ps.setString(4, user.getSenha());
//            ps.setString(4, user.getCpf());
//            ps.setString(5, user.getTel());
//            ps.setString(6, user.getWhatsapp());
            // ps.setDate(8, new java.sql.Date(user.getDtCadastro().getTime())); private Date dtCadastro = new Date();
            user.setDtUltAlteracao(new Date());
            ps.setDate(5, new java.sql.Date(user.getDtUltAlteracao().getTime()));
            ps.setString(6, user.getId());

            ps.execute();
            Conexao.fecharConexao();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário alterado com sucesso!", ""));
            System.out.println("Alterado com sucesso. ID: " + user.getId());
        } catch (SQLException ex) {
            System.out.println("Erro ao alterar DAO " + ex.getMessage());
        }
        return user;
    }

    public List<UsuariosBean> lista(String clausula) {

        try {

            Connection conexao = Conexao.getConexao();
            List<UsuariosBean> listaUsers = new ArrayList<>();
            PreparedStatement ps = conexao.prepareStatement("select * from usuarios " + clausula);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                UsuariosBean user = new UsuariosBean();

                user.setId(rs.getString("id"));
                user.setNome(rs.getString("nome"));
                user.setEmail(rs.getString("email"));
                user.setLogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));
//                user.setCpf(rs.getString("cpf"));
//                user.setTel(rs.getString("tel"));
//                user.setWhatsapp(rs.getString("whatsapp"));

                user.setDtCadastro(rs.getDate("dtCadastro"));
                //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); Alex, impedindo de gerar o json
                //user.setDtCadastroFormatada(formato.format(user.getDtCadastro()));

                user.setDtUltAlteracao(rs.getDate("dtUltAlteracao"));
                // user.setDtUltAlteracaoFormatada(formato.format(user.getDtUltAlteracao()));

                listaUsers.add(user);

            }
            ps.execute();
            ps.close();
            Conexao.fecharConexao();

            return listaUsers;
        } catch (SQLException ex) {
            System.out.println("Erro ao listar DAO " + ex.getMessage());
            return null;
        }
    }

    public List<UsuariosBean> listaId() {

        try {

            Connection conexao = Conexao.getConexao();
            List<UsuariosBean> listaUsers = new ArrayList<>();
            PreparedStatement ps = conexao.prepareStatement("select id from usuarios ");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                UsuariosBean user = new UsuariosBean();

                user.setId(rs.getString("id"));
                listaUsers.add(user);

            }
            ps.execute();
            ps.close();
            Conexao.fecharConexao();

            return listaUsers;
        } catch (SQLException ex) {
            System.out.println("Erro ao listarID DAO " + ex.getMessage());
            return null;
        }
    }

    public UsuariosBean deletar(UsuariosBean pUser) {

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps;
            ps = conexao.prepareStatement("delete from `usuarios` where id = ?");

            ps.setString(1, pUser.getId());

            ps.execute();
            Conexao.fecharConexao();
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar DAO " + ex.getMessage());
        }
        return pUser;
    }

    public List<UsuariosBean> validacaoLogin(String nome, String senha) {

        List<UsuariosBean> usuarios = new ArrayList<>();
        String sql = "select * from usuarios  where login = '" + nome + "' and senha = '" + senha + "';";

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UsuariosBean user = new UsuariosBean();
                user.setId(rs.getString("id"));
                user.setLogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));
                usuarios.add(user);
            }

            Conexao.fecharConexao();
            return usuarios;
        } catch (SQLException ex) {
            System.out.println("Erro ao validar login DAO " + ex.getMessage());
        }
        return usuarios;
    }

}
