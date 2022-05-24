package Respaldo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
public class login1 extends JFrame {
 JLabel usuario , contraseña, jLabel1,jLabel2, 
         lbl_titulo,lbl_banner,fondo; 
 JTextField Tus,Tcon, txtUsuario;
 JPasswordField txtPassword;
 JButton Entrar,btn_iniciar,btn_cancelar;
 Component confirmation;
 String user,pass;
 



public login1(){
        super("DPRTS");
        metodoVentana();
        metodoDiseño();
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/Login.jpg"));
        JLabel fondo= new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        txtUsuario.setFocusable(true);
        
        
}

public void metodoVentana(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(260,300);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
    /* txtUsuario.setFocusable(true);*/
    }
public void metodoDiseño(){

        usuario= new JLabel("USUARIO");
        usuario.setBounds(75, 10, 100, 25);
        usuario.setFont(new java.awt.Font("Tahoma", 1, 18));
        usuario.setForeground(new java.awt.Color(255, 255, 255));
    

    
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        
        txtUsuario = new JTextField();
        txtUsuario.setBounds(30, 50, 200, 40);
        txtUsuario.setBackground(new java.awt.Color(16, 16, 16));
        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        txtUsuario.setForeground(new java.awt.Color(73, 199, 140));
        
        lbl_titulo = new JLabel("CONTRASEÑA");
        lbl_titulo.setBounds(60, 100,350, 40);
        lbl_titulo.setFont(new java.awt.Font("Tahoma", 1, 18));
        lbl_titulo.setForeground(new java.awt.Color(255, 255,255));
        lbl_banner = new JLabel();
        
        txtPassword = new JPasswordField();
        txtPassword.setBounds(30, 150, 200, 40);
        txtPassword.setBackground(new java.awt.Color(16, 16, 16));
        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        txtPassword.setForeground(new java.awt.Color(73, 199, 140));
        

        
        btn_iniciar = new JButton("ENTRAR");
        btn_iniciar.setBounds(75, 215, 100, 50);
        btn_iniciar.setBackground(new java.awt.Color(106, 216, 190));
        btn_iniciar.setForeground(new java.awt.Color(255, 255, 255));
        
        //agregar al panel
        this.add(usuario);
        this.add(btn_iniciar);
        this.add(jLabel1);
        this.add(jLabel2);
        this.add(txtUsuario);
        this.add(txtPassword);
        this.add(lbl_titulo);
        this.add(lbl_banner);
        
        //ACTIONLISTENER
         btn_iniciar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciarActionPerformed(evt);
            }
        });

    }
    public void datos(String us, String pas){
        user = "Admin"; 
        pass = "admin";
}
    public static void main (String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {


            @Override
            public void run() {
                        login1 Ventana= new login1();
                        Ventana.setVisible(true);
            }
        });
    }

   private void btn_iniciarActionPerformed(java.awt.event.ActionEvent evt) {
    datos(user, pass);
    if(user.equals(txtUsuario.getText()) && pass.equals(txtPassword.getText())){
         Ventas fra;
        fra = new Ventas();
         fra.setVisible(true);
         this.dispose();
    }else if(txtUsuario.getText().equals("") && txtPassword.getText().equals("")){
        JOptionPane.showMessageDialog(this,"Usuario y/o Contraseña estan vacios\nIngrese los por favor.");
        txtUsuario.setFocusable(true);
    }else if(txtUsuario.getText().equals("")){
        JOptionPane.showMessageDialog(this,"Usuario está vacio\nIngrese lo por favor.");
        txtUsuario.setFocusable(true);
    }else if(txtPassword.getText().equals("")){
        JOptionPane.showMessageDialog(this,"Contraseña está vacio\nIngrese lo por favor.");
        txtPassword.setFocusable(true);
    }
    else if(txtUsuario.getText().compareTo(user)!=0 && txtPassword.getText().compareTo(pass)!=0){
        JOptionPane.showMessageDialog(this,"Usuario y/o Contraseña no válidos\nIngrese nuevamente.");
         txtUsuario.setFocusable(true);
         txtUsuario.setText("");
         txtPassword.setText("");
    }
    else if(txtUsuario.getText().compareTo(user)!=0){
        JOptionPane.showMessageDialog(this,"Usuario no valido\nIngrese nuevamente.");
        txtUsuario.setFocusable(true);
        txtUsuario.setText("");
        }
    else if(txtPassword.getText().compareTo(pass )!=0){
        JOptionPane.showMessageDialog(this,"Contraseña no válida\nIngrese nuevamente.");
        txtPassword.setFocusable(true);
        txtPassword.setText("");
    }
}}