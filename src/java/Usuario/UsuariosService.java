/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.util.List;

/**
 *
 * @author guana
 */
public class UsuariosService {

    UsuariosBean userBean = new UsuariosBean();
    UsuariosDAO userDAO = new UsuariosDAO();

    private Integer tela = 0;

    public List<UsuariosBean> validacaoLogin(String login, String senha) {
        return userDAO.validacaoLogin(login, senha);
    }

    public List<UsuariosBean> lista(String pesquisa) {
        String clausula = " where id like '%" + pesquisa + "%' or nome like '%" + pesquisa + "%' or login like '%" + pesquisa + "%' or email like '%" + pesquisa + "%' or dtCadastro like '%" + pesquisa + "%';";
        return userDAO.lista(clausula);
    }

    public List<UsuariosBean> listaId() {
        return userDAO.listaId();
    }

    public UsuariosBean salvar(UsuariosBean user) {

        if (user.getId() == null || user.getId().equals("") || user.getId().equals("0")) {
            return userDAO.inserir(user);
        } else {
            return userDAO.alterar(user);
        }
    }

    public UsuariosBean deletar(UsuariosBean pUser) {
        return userDAO.deletar(pUser);
    }

    public UsuariosBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UsuariosBean userBean) {
        this.userBean = userBean;
    }

    public UsuariosDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UsuariosDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Integer getTela() {
        return tela;
    }

    public void setTela(Integer tela) {
        this.tela = tela;
    }

}
