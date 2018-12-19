/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Usuario.UsuariosBean;
import Usuario.UsuariosService;
import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author guana
 */
@ManagedBean
@ViewScoped
public class UsuarioController {

    UsuariosService userService = new UsuariosService();
    UsuariosBean usuario = new UsuariosBean();
    List<UsuariosBean> listaUsuarios = new ArrayList<>();

    private String pesquisa;
    private Integer tela = 0;

    private StreamedContent file;

    public StreamedContent gerarJson() throws IOException {

        try {

            if (true) {

            } else {
            }

            Gson gson = new Gson();
            String json = gson.toJson(listaUsuarios);

            System.out.println(json);

            Date hoje = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("ddMMyy");
            String today = formato.format(hoje);

            String nome = today + "_";
            int nome2 = listaUsuarios.size();
            //String nome3 = usuario.getId();

            String caminho = "C:\\Alex\\Projetos\\NOVO\\temp\\" + nome + nome2 + ".json";

            FileWriter filePath = new FileWriter(caminho);
            BufferedWriter bw = new BufferedWriter(filePath);
            bw.write(json);
            bw.close();
            filePath.close();
            System.out.println("arquivo criado com sucesso.. " + nome + nome2);

            FileInputStream stream = new FileInputStream(caminho);
            file = new DefaultStreamedContent(stream, "text/json", nome + nome2 + ".json");
            System.out.println("Download feito com sucesso.");

            System.out.println("Caminho do json: " + caminho);
            
            return file;

        } catch (FileNotFoundException e) {
            System.out.println("Erro ao gerar json: " + e.getMessage());
            return null;
        }
    }

    public void mudarTela(Integer pTela) {
        tela = pTela;
    }

    public void voltar() {
        setPesquisa("");
        listaUsuarios.clear();
        tela = 0;
    }

    public void novo() {
        usuario = new UsuariosBean();
        tela = 1;
    }

    public void validacaoLogin() {
        List<UsuariosBean> listaUsuario = userService.validacaoLogin(usuario.getLogin(), usuario.getSenha());

        if (!listaUsuario.isEmpty()) {
            LoginController logincon = new LoginController();
            logincon.mudarPagina("/principal/principal.jsf");
            System.out.println("Sucesso,\n   ID: " + listaUsuario.get(0).getId() + "\n   LOGIN: " + listaUsuario.get(0).getLogin() + "\n   SENHA: " + listaUsuario.get(0).getSenha());
            usuario = listaUsuario.get(0);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario ou senha inválidos!", ""));
            System.out.println("Erro no login");
        }
    }

    public void lista() throws SQLException {
        listaUsuarios = userService.lista(pesquisa);
    }

    public void seleciona(UsuariosBean pUser) {
        usuario = pUser;
        tela = 1;
    }

    public void salvar() {

        UsuariosBean user = new UsuariosBean();

        if (user.getId() == null) {
            user.setId("");
        } else {
            user.setId(user.getId());
        }

        user = usuario;
        userService.salvar(user);

        UsuariosBean newUser = new UsuariosBean();
        voltar();
    }

    public void deletar() {

        UsuariosBean user = new UsuariosBean();

        user.setId(usuario.getId());
        userService.deletar(user);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário deletado com sucesso!", ""));
        System.out.println("Deletado com sucesso. ID: " + user.getId());

        UsuariosBean newUser = new UsuariosBean();
        voltar();
    }

    public UsuariosService getUserService() {
        return userService;
    }

    public void setUserService(UsuariosService userService) {
        this.userService = userService;
    }

    public UsuariosBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariosBean usuario) {
        this.usuario = usuario;
    }

    public List<UsuariosBean> getListaUsuarios() {
        return listaUsuarios;
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

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }

}
