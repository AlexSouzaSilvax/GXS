/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

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

/**
 *
 * @author guana
 */
public class ClientesDAO {

    public ClientesBean inserir(ClientesBean cli) {

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps;

            ps = conexao.prepareStatement("INSERT INTO `clientes` (`nome`,`email`,`cpf_cnpj`,`telefone`, `whatsapp`, `desconto`, `totalCompras`, `dtCadastro`, `dtUltAlteracao`, `dtUltCompra`) VALUES (?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, cli.getNome());
            ps.setString(2, cli.getEmail());
            ps.setString(3, cli.getCpf_cnpj());
            ps.setString(4, cli.getTelefone());
            ps.setString(5, cli.getWhatsapp());
            ps.setDouble(6, cli.getDesconto());
            ps.setInt(7, cli.getTotalCompras());
            ps.setDate(8, new java.sql.Date(cli.getDtCadastro().getTime()));
            ps.setDate(9, new java.sql.Date(cli.getDtUltAlteracao().getTime()));
            ps.setDate(10, new java.sql.Date(cli.getDtUltCompra().getTime()));

            ps.execute();
            Conexao.fecharConexao();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente salvo com sucesso!", ""));
            System.out.println("Salvo com sucesso. ID: " + cli.getId());
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar DAO " + ex.getMessage());
        }
        return cli;
    }

    public ClientesBean alterar(ClientesBean cli) {
        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps;
            ps = conexao.prepareStatement("update clientes set nome = ?, email = ?, cpf_cnpj = ?, telefone = ?, whatsapp = ?, desconto = ?, dtUltAlteracao = ? where id = ?");

            ps.setString(1, cli.getNome());
            ps.setString(2, cli.getEmail());
            ps.setString(3, cli.getCpf_cnpj());
            ps.setString(4, cli.getTelefone());
            ps.setString(5, cli.getWhatsapp());
            ps.setDouble(6, cli.getDesconto());

            cli.setDtUltAlteracao(new Date());
            ps.setDate(7, new java.sql.Date(cli.getDtUltAlteracao().getTime()));

            ps.setString(8, cli.getId());

            ps.execute();
            Conexao.fecharConexao();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente alterado com sucesso!", ""));
            System.out.println("Alterado com sucesso. ID: " + cli.getId());
        } catch (SQLException ex) {
            System.out.println("Erro ao alterar DAO " + ex.getMessage());
        }
        return cli;
    }

    public List<ClientesBean> lista(String clausula) {

        try {

            Connection conexao = Conexao.getConexao();
            List<ClientesBean> listaClientes = new ArrayList<>();
            PreparedStatement ps = conexao.prepareStatement("select * from clientes " + clausula);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ClientesBean cli = new ClientesBean();

                cli.setId(rs.getString("id"));
                cli.setNome(rs.getString("nome"));
                cli.setEmail(rs.getString("email"));
                cli.setCpf_cnpj(rs.getString("cpf_cnpj"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setWhatsapp(rs.getString("whatsapp"));
                cli.setDesconto(rs.getDouble("desconto"));
                cli.setTotalCompras(rs.getInt("totalCompras"));

                cli.setDtCadastro(rs.getDate("dtCadastro"));
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                cli.setDtCadastroFormatada(formato.format(cli.getDtCadastro()));

                cli.setDtUltAlteracao(rs.getDate("dtUltAlteracao"));
                cli.setDtUltAlteracaoFormatada(formato.format(cli.getDtUltAlteracao()));

                cli.setDtUltCompra(rs.getDate("dtUltCompra"));
                cli.setDtUltCompraFormatada(formato.format(cli.getDtUltCompra()));

                listaClientes.add(cli);

            }
            ps.execute();
            ps.close();
            Conexao.fecharConexao();

            return listaClientes;
        } catch (SQLException ex) {
            System.out.println("Erro ao listar DAO " + ex.getMessage());
            return null;
        }
    }

    public List<ClientesBean> listaId() {

        try {

            Connection conexao = Conexao.getConexao();
            List<ClientesBean> listaClientes = new ArrayList<>();
            PreparedStatement ps = conexao.prepareStatement("select id from clientes ");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ClientesBean cli = new ClientesBean();

                cli.setId(rs.getString("id"));
                listaClientes.add(cli);

            }
            ps.execute();
            ps.close();
            Conexao.fecharConexao();

            return listaClientes;
        } catch (SQLException ex) {
            System.out.println("Erro ao listarID DAO " + ex.getMessage());
            return null;
        }
    }

    public ClientesBean deletar(ClientesBean pCli) {

        try {
            Connection conexao = Conexao.getConexao();
            PreparedStatement ps;
            ps = conexao.prepareStatement("delete from `clientes` where id = ?");

            ps.setString(1, pCli.getId());

            ps.execute();
            Conexao.fecharConexao();
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar DAO " + ex.getMessage());
        }
        return pCli;
    }

}
