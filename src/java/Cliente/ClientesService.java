/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.util.List;

/**
 *
 * @author guana
 */
public class ClientesService {

    ClientesBean clientesBean = new ClientesBean();
    ClientesDAO clientesDAO = new ClientesDAO();

    private Integer tela = 0;

    public List<ClientesBean> lista(String pesquisa) {
        String clausula = " where id like '%" + pesquisa + "%' or nome like '%" + pesquisa + "%' or email like '%" + pesquisa + "%' or dtCadastro like '%" + pesquisa + "%';";
        return clientesDAO.lista(clausula);
    }

    public List<ClientesBean> listaId() {
        return clientesDAO.listaId();
    }

    public ClientesBean salvar(ClientesBean cli) {

        if (cli.getId() == null || cli.getId().equals("") || cli.getId().equals("0")) {
            return clientesDAO.inserir(cli);
        } else {
            return clientesDAO.alterar(cli);
        }
    }

    public ClientesBean deletar(ClientesBean pCli) {
        return clientesDAO.deletar(pCli);
    }

    public ClientesBean getClientesBean() {
        return clientesBean;
    }

    public void setClientesBean(ClientesBean clientesBean) {
        this.clientesBean = clientesBean;
    }

    public ClientesDAO getClientesDAO() {
        return clientesDAO;
    }

    public void setClientesDAO(ClientesDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
    }

    public Integer getTela() {
        return tela;
    }

    public void setTela(Integer tela) {
        this.tela = tela;
    }

}
