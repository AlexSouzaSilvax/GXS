package br.com.gxs.usuario;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class Usuario {

    private String idUsuario;
    private String login;
    private String senha;
    private String nome;
    private String email;
    private String situacao;
    private Date dataCadastro = new Date();

    public String acessar() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (login.equals("alex") && senha.equals("123")) {
            //context.addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Usuário Válido!", "Bem - Vindo: " + login));
            System.out.println("Usuário válido!\n" + "Login:  " + login + " | Senha: " + senha + "  Inseridos.");
            return "Template";
        }
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário Inválido", ""));
        System.err.println("Usuário inválido!\n" + "Login:  " + login + " | Senha: " + senha + "  Inseridos.");
        return "login";
    }

    public String sair() {
        System.out.println("Método sair chamado!");
        return "login";
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
