/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Usuario.UsuariosBean;
import Usuario.UsuariosService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author SQL
 */
@SessionScoped
@ManagedBean(name = "loginController")
public class LoginController implements HttpSessionListener {

    private HttpSession session;
    private String vEmail = null;
    private String color = "-blue";
    String home;

    private StreamedContent logo;

    UsuarioController userControll = new UsuarioController();
    UsuariosService userService = new UsuariosService();
    UsuariosBean usuario = new UsuariosBean();
    List<UsuariosBean> listaUsuarios = new ArrayList<>();

    public void iniciar() {
//        List<UsuariosBean> listaId = userService.listaId();
//
//        if (!listaId.isEmpty()) {
//            System.out.println("Sucesso,\n   ID: " + listaId.get(0).getId());
//            usuario = listaId.get(usuario);
//        } else if (listaId.get(usuario).getId() == null || listaId.get(usuario).getId().equals("") || listaId.get(usuario).getId().equals("0")) {
//            System.out.println("Você não tem acesso a essa página!\nFaça login novamente...");
//            listaId.get(usuario).setId("0");
//            mudarPagina("/principal/acessonegado.jsf");
//        }
    }

    public void mudarPagina(String pPagina) {
        try {
            FacesContext ctx = FacesContext.getCurrentInstance();
            FacesContext.getCurrentInstance().getExternalContext().redirect(ctx.getExternalContext().getRequestContextPath() + pPagina);

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarlogo() {
        try {
            //FileInputStream in = new FileInputStream(new File("C:\\Projetos\\CIM\\web\\images\\logo1pqn.png"));
            //System.out.println("C:\\Projetos\\CIM\\web\\images\\logo.png");
            //logo = new DefaultStreamedContent(in);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void sair() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession s = (HttpSession) fc.getExternalContext().getSession(false);
        s.invalidate();
        FacesContext ctx = FacesContext.getCurrentInstance();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(ctx.getExternalContext().getRequestContextPath() + "/");
            userControll.usuario.setId("0");
            System.out.println("Limpo id");

        } catch (IOException ex) {
            System.out.println("Erro ao sair " + ex.getMessage());
        }
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

    public void setListaUsuarios(List<UsuariosBean> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public String getvEmail() {
        return vEmail;
    }

    public void setvEmail(String vEmail) {
        this.vEmail = vEmail;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public StreamedContent getLogo() {
        return logo;
    }

    public void setLogo(StreamedContent logo) {
        this.logo = logo;
    }

}
