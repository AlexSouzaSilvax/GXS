package br.com.gxs.usuario;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class Usuario {

    private String seqUsuario;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private String situacao;
    private String telefone;
    private Date dataCadastro;

    public String getSeqUsuario() {
        return seqUsuario;
    }

    public void setSeqUsuario(String seqUsuario) {
        this.seqUsuario = seqUsuario;
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

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String acessar() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (login.equals("alex") && senha.equals("123")) {
            //context.addMessage(FacesMessage.FACES_MESSAGES, new FacesMessage("Usuário Válido!", "Bem - Vindo: " + login));
            System.out.println("Usuário válido!\n" + "Login:  " + login + " | Senha: " + senha + "  Inseridos.");
            return "teste";
        }
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário Inválido", ""));
        System.err.println("Usuário inválido!\n" + "Login:  " + login + " | Senha: " + senha + "  Inseridos.");
        return "login";
    }

    public String sair() {
        System.out.println("Método sair chamado!");
        return "login";
    }
}
