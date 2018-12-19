package Usuario;

import java.util.Date;

public class UsuariosBean {

    private String id;
    private String nome;
    private String login;
    private String senha;
    //private String cpf;
    //private String tel;
    //private String whatsapp;
    private String email;

    private Date dtCadastro = new Date();
    //private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    // private String dtCadastroFormatada = formato.format(dtCadastro);

    private Date dtUltAlteracao = dtCadastro;
    //private String dtUltAlteracaoFormatada = formato.format(dtUltAlteracao);

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }
//
//    public SimpleDateFormat getFormato() {
//        return formato;
//    }
//
//    public void setFormato(SimpleDateFormat formato) {
//        this.formato = formato;
//    }
//
//    public String getDtCadastroFormatada() {
//        return dtCadastroFormatada;
//    }
//
//    public void setDtCadastroFormatada(String dtCadastroFormatada) {
//        this.dtCadastroFormatada = dtCadastroFormatada;
//    }

    public Date getDtUltAlteracao() {
        return dtUltAlteracao;
    }

    public void setDtUltAlteracao(Date dtUltAlteracao) {
        this.dtUltAlteracao = dtUltAlteracao;
    }
//
//    public String getDtUltAlteracaoFormatada() {
//        return dtUltAlteracaoFormatada;
//    }
//
//    public void setDtUltAlteracaoFormatada(String dtUltAlteracaoFormatada) {
//        this.dtUltAlteracaoFormatada = dtUltAlteracaoFormatada;
//    }

}
