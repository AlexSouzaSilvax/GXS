/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author guana
 */
public class ClientesBean {

    private String id;
    private String nome;
    private String email;
    private String cpf_cnpj;
    private String telefone;
    private String whatsapp;
    private double desconto;
    private int totalCompras;

    private Date dtCadastro = new Date();
    private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    private String dtCadastroFormatada = formato.format(dtCadastro);
    
    private Date dtUltAlteracao = new Date();
    private String dtUltAlteracaoFormatada = formato.format(dtUltAlteracao);

    private Date dtUltCompra = new Date(); // DEIXAR ELA RECEBENDO POR ENQUANTO A DATA DE HOJE, DEPOIS ELA DEVERÁ RECEBER A DATA DA ULTIMA COMPRA DO CLIENTE.
    private String dtUltCompraFormatada = formato.format(dtUltCompra);

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public int getTotalCompras() {
        return totalCompras;
    }

    public void setTotalCompras(int totalCompras) {
        this.totalCompras = totalCompras;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public SimpleDateFormat getFormato() {
        return formato;
    }

    public void setFormato(SimpleDateFormat formato) {
        this.formato = formato;
    }

    public String getDtCadastroFormatada() {
        return dtCadastroFormatada;
    }

    public void setDtCadastroFormatada(String dtCadastroFormatada) {
        this.dtCadastroFormatada = dtCadastroFormatada;
    }

    public Date getDtUltCompra() {
        return dtUltCompra;
    }

    public void setDtUltCompra(Date dtUltCompra) {
        this.dtUltCompra = dtUltCompra;
    }

    public String getDtUltCompraFormatada() {
        return dtUltCompraFormatada;
    }

    public void setDtUltCompraFormatada(String dtUltCompraFormatada) {
        this.dtUltCompraFormatada = dtUltCompraFormatada;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public Date getDtUltAlteracao() {
        return dtUltAlteracao;
    }

    public void setDtUltAlteracao(Date dtUltAlteracao) {
        this.dtUltAlteracao = dtUltAlteracao;
    }

    public String getDtUltAlteracaoFormatada() {
        return dtUltAlteracaoFormatada;
    }

    public void setDtUltAlteracaoFormatada(String dtUltAlteracaoFormatada) {
        this.dtUltAlteracaoFormatada = dtUltAlteracaoFormatada;
    }

}
