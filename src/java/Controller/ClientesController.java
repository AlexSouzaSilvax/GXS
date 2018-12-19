/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cliente.ClientesBean;
import Cliente.ClientesService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author guana
 */
@ManagedBean
@ViewScoped
public class ClientesController {

    ClientesService clientesService = new ClientesService();
    ClientesBean clientes = new ClientesBean();
    List<ClientesBean> listaClientes = new ArrayList<>();

    private String pesquisa;
    private Integer tela = 0;

    public void mudarTela(Integer pTela) {
        tela = pTela;
    }

    public void voltar() {
        setPesquisa("");
        listaClientes.clear();
        tela = 0;
    }

    public void novo() {
        clientes = new ClientesBean();
        tela = 1;
    }

    public void lista() throws SQLException {
        listaClientes = clientesService.lista(pesquisa);
    }

    public void seleciona(ClientesBean pClientes) {
        clientes = pClientes;
        tela = 1;
    }

    public void salvar() {

        ClientesBean cli = new ClientesBean();

        if (cli.getId() == null) {
            cli.setId("");
        } else {
            cli.setId(cli.getId());
        }

        cli = clientes;
        clientesService.salvar(cli);

        ClientesBean newCli = new ClientesBean();
        voltar();
    }

    public void deletar() {

        ClientesBean cli = new ClientesBean();

        cli.setId(clientes.getId());
        clientesService.deletar(cli);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário deletado com sucesso!", ""));
        System.out.println("Deletado com sucesso. ID: " + cli.getId());

        ClientesBean newCli = new ClientesBean();
        voltar();
    }

    public ClientesService getClientesService() {
        return clientesService;
    }

    public void setClientesService(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    public ClientesBean getClientes() {
        return clientes;
    }

    public void setClientes(ClientesBean clientes) {
        this.clientes = clientes;
    }

    public List<ClientesBean> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<ClientesBean> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public Integer getTela() {
        return tela;
    }

    public void setTela(Integer tela) {
        this.tela = tela;
    }

}
