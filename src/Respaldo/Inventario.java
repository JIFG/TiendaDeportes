package Respaldo;
import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author isaac
 */
public class Inventario extends JFrame implements ActionListener{

JLabel ID,Nombre,Pais,color;
JTextField txtid,txtnombre,txtpais,txtcolor;
JButton Crear,Mostrar,Editar,Eliminar,Ventas,Finanzas;
JComboBox CbID;
JScrollPane scroll;
JScrollPane Scroll2;
String barra= File.separator;
String ubicacion= System.getProperty("user.dir")+barra+"Registros"+barra;
JTable Tabla;
     
File contenedor= new File(ubicacion);
File[ ] registros= contenedor.listFiles();

String [] titulos={"Codigo","Producto","Cantidad","Precio"};
DefaultTableModel dtm= new DefaultTableModel(null,titulos);

public  Inventario(){
    super ("inventario");
    ((JPanel)getContentPane()).setOpaque(false);
    ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/Inventario33.jpg"));
    JLabel fondo= new JLabel();
    fondo.setIcon(uno);
    getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
    fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
Ventana();
Componentes();
Listener();
MostrarCombo();
Tabla();
RegTabla();
ActualizarTabla();
TablaOyenteRaton();
}
private void RegTabla(){
    for (int i = 0; i <registros.length; i++) {
        File url= new File(ubicacion+registros[i].getName());
        try {
            FileInputStream fis= new FileInputStream(url);
            Properties mostrar= new Properties();
            mostrar.load(fis);
            String filas[]={registros[i].getName().replace(".txt", ""),
            mostrar.getProperty("Producto"),mostrar.getProperty("Cantidad"),mostrar.getProperty("Precio"),
            };
            dtm.addRow(filas);
            
           } catch (Exception e) {
        }
    }
    
    Tabla.setModel(dtm);
}

public void Ventana(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,800);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
    }

public void MostrarCombo(){
    for (int i = 0; i <registros.length; i++) {
        CbID.addItem(registros[i].getName().replace(".txt", ""));
        
    }
    
}

public void Tabla(){
     Tabla= new JTable();
     this.add( scroll = new JScrollPane(Tabla));
    

     this.add( scroll = new JScrollPane(Tabla));
     this.add( Scroll2 = new JScrollPane());
     Scroll2.setBounds(50, 350, 800, 400);
     scroll.setBounds(50, 350, 800, 400);
     Tabla.setBounds(50, 350, 800, 400);
       JTableHeader encabezado=Tabla.getTableHeader();
       encabezado.setForeground(Color.BLACK);
       encabezado.setFont(new Font("Tahoma",1,15));
       encabezado.setBackground(new Color(120, 238, 179));
       Tabla.setSelectionBackground(Color.BLACK);
       Tabla.setSelectionForeground(Color.WHITE);
       
       Tabla.setFont(new Font("Tahoma",1,15));
     setVisible(true);
    }

public void Componentes(){
    //etiquetas y textos
 ID=new JLabel("ID");
 ID.setBounds(80, 45, 100, 25);
 ID.setFont(new java.awt.Font("Tahoma", 1, 18));
 ID.setForeground(new java.awt.Color(255, 255, 255));
 txtid=new JTextField();
 txtid.setBounds(145, 43, 100, 25);
 Nombre=new JLabel("Producto");
 Nombre.setBounds(50, 95, 100, 25);
 Nombre.setFont(new java.awt.Font("Tahoma", 1, 18));
 Nombre.setForeground(new java.awt.Color(255, 255, 255));
 txtnombre=new JTextField();
 txtnombre.setBounds(145, 95, 100, 25);
 Pais=new JLabel("Cantidad");
 Pais.setBounds(50, 145, 100, 25);
 Pais.setForeground(new java.awt.Color(255, 255, 255));
 Pais.setFont(new java.awt.Font("Tahoma", 1, 18));
 txtpais=new JTextField();
 txtpais.setBounds(147, 147, 100, 25);
 color=new JLabel("Precio");
 color.setBounds(50, 195, 100, 25);
 color.setForeground(new java.awt.Color(255, 255, 255));
 color.setFont(new java.awt.Font("Tahoma", 1, 18));
 txtcolor=new JTextField();
 txtcolor.setBounds(146, 198, 100, 25);
 //etiquetas y textos
 //Botones
 Crear= new JButton("Agregar");
 Crear.setBounds(459, 304, 110, 30);
 Crear.setFont(new java.awt.Font("Tahoma", 1, 18));
 /* Mostrar= new JButton("Mostrar");
 Mostrar.setBounds(150, 300, 110, 30);
 Mostrar.setFont(new java.awt.Font("Tahoma", 1, 18));*/
 Editar=new JButton("Editar");
 Editar.setBounds(599, 304, 110, 30);
 Editar.setFont(new java.awt.Font("Tahoma", 1, 18));
 Eliminar= new JButton("Eliminar");
 Eliminar.setBounds(739, 303, 110, 30);
 Eliminar.setFont(new java.awt.Font("Tahoma", 1, 18));
 Ventas= new JButton("Ventas");
 Ventas.setBounds(652, 138, 120, 30);
 Ventas.setFont(new java.awt.Font("Tahoma", 1, 18));
 Finanzas= new JButton("Finanzas");
 Finanzas.setBounds(499, 137, 120, 30);
 Finanzas.setFont(new java.awt.Font("Tahoma", 1, 18));
 //Botones
 //ComboBox
 CbID= new JComboBox();
 CbID.setBounds(297, 43, 100, 25);

 
 //añadir a panel
 add(ID);
 add(Nombre);
 add(Pais);
 add(color);
 add(txtid);
 add(txtnombre);
 add(txtpais);
 add(txtcolor);
 add(Crear);
 add(Ventas);
 add(Finanzas);
 /* add(Mostrar);*/
 add(Editar);
 add(Eliminar);
 add(CbID);
}

private void TablaOyenteRaton(){
    MouseListener TablaClick= new MouseListener()
            
    {

        @Override
        public void mouseClicked(MouseEvent me) {
        int seleccion= Tabla.rowAtPoint(me.getPoint());
        txtid.setText(String.valueOf(Tabla.getValueAt(seleccion, 0)));
        txtnombre.setText(String.valueOf(Tabla.getValueAt(seleccion,1)));
        txtpais.setText(String.valueOf(Tabla.getValueAt(seleccion,2)));
        txtcolor.setText(String.valueOf(Tabla.getValueAt(seleccion,3)));
}

        @Override
        public void mousePressed(MouseEvent me) {
            
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
        }
    };
    Tabla.addMouseListener(TablaClick);
}

public void Listener(){
 //ActionListener
 Crear.addActionListener(this);
 Finanzas.addActionListener(this);
 Editar.addActionListener(this);
 Eliminar.addActionListener(this);
 CbID.addActionListener(this);
 Ventas.addActionListener(this);
}

private void Crear(){
    String archivo= txtid.getText()+".txt";
    File crea_ubicacion = new File(ubicacion);
    File crea_archivo = new File(ubicacion+archivo);
    if(txtid.getText().equals("")){
        JOptionPane.showMessageDialog(rootPane, "No hay ID");
    }else{
        try {
                 if(crea_archivo.exists()){
            JOptionPane.showMessageDialog(rootPane,"El registro ya existe");
              }else{
 //mkdirs sirve para crear carpetas dentro de la ubicacion
                    crea_ubicacion.mkdirs();
                    Formatter crea = new Formatter(ubicacion+archivo);
                    crea.format("%s\r\n%s\r\n%s\r\n%s",
                                 "ID="+txtid.getText(),
                                   "Producto="+txtnombre.getText()
                                 ,"Cantidad="+txtpais.getText()
                                 ,"Precio="+txtcolor.getText());
                    txtid.setText("");
                    txtnombre.setText("");
                    txtpais.setText("");
                    txtcolor.setText("");
                    
            crea.close();
            JOptionPane.showMessageDialog(rootPane,"Producto añadido");
            CbID.removeAllItems();
            registros= contenedor.listFiles();
            MostrarCombo();
            ActualizarTabla();
        } 
        }catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"NOOO SE PUDO");
        }
     
  
              
                
                
    }
}

private void Mostrar(){
 File url= new File(ubicacion+txtid.getText()+".txt");
 if(txtid.getText().equals("")){
     /*     JOptionPane.showMessageDialog(rootPane,"Indique el ID para mostrar");*/
 }else{
     if(url.exists()){
         try {
             FileInputStream fis= new FileInputStream(url);
             Properties mostrar= new Properties();
             mostrar.load(fis);
             txtnombre.setText(mostrar.getProperty("Producto"));
             txtpais.setText(mostrar.getProperty("Cantidad"));
             txtcolor.setText(mostrar.getProperty("Precio"));
             } catch (Exception e) {
         }
      }else{
         JOptionPane.showMessageDialog(rootPane,"Ese registro no existe");
     }
 }
}

private void Editar(){
    File url= new File(ubicacion+txtid.getText()+".txt");
    if(txtid.getText().equals("")){
        JOptionPane.showMessageDialog(rootPane,"Indique el registro a editar");
    }else{
        if(url.exists()){
            try {
                
        FileWriter permite_escribir= new FileWriter(ubicacion+txtid.getText()+".txt");
        String Id="ID=";
        String name="Producto=";
        String pais="Cantidad=";
        String color="Precio=";
        
                PrintWriter guardar= new PrintWriter(permite_escribir);
                guardar.println(Id+txtid.getText());
                guardar.println(name+txtnombre.getText());
                guardar.println(pais+txtpais.getText());
                guardar.println(color+txtcolor.getText());
                permite_escribir.close();
                JOptionPane.showMessageDialog(rootPane,"Registro editado correctamente");
                ActualizarTabla();
        } catch (Exception e) {
        JOptionPane.showMessageDialog(rootPane,"Error"+e);
        }
    }else{
            JOptionPane.showMessageDialog(rootPane, "El registro no existe");
        }
 }
}

private void Eliminar(){
    File url= new File(ubicacion+txtid.getText()+".txt"); 
    String btns[]={"Eliminar","Cancelar"};
    if(txtid.getText().equals("")){
        JOptionPane.showMessageDialog(rootPane,"Indique cual registro desea eliminar");
    }else{
        if(url.exists()){
          
            try {
                FileInputStream cerrar=new FileInputStream(url);
                cerrar.close();
                System.gc();
                int seguro= JOptionPane.showOptionDialog(rootPane,
                        "¿Quiere elimar el registro"+txtid.getText()
                        , "Eliminacion", 0, 0, null, btns, null);
                if(seguro==JOptionPane.YES_OPTION){
                    url.delete();
                    JOptionPane.showMessageDialog(rootPane,"Registro eliminado");
                    CbID.removeItem(txtid.getText());
                    txtid.setText("");
                    txtnombre.setText("");
                    txtpais.setText("");
                    txtcolor.setText("");
                    ActualizarTabla();
                }
                if(seguro==JOptionPane.NO_OPTION){
                    
                }
            } catch (Exception e) {
            }
            
        }else{
            JOptionPane.showMessageDialog(rootPane,"Ese archivo no existe");
        }
    }
}

private void ActualizarTabla(){
    registros=contenedor.listFiles();
    dtm.setRowCount(0);
    RegTabla();
   }

public void actionPerformed(ActionEvent e) {
           Object objeto=e.getSource();
           if(objeto==Crear){
               Crear();
           }
           if(objeto==Mostrar){
               Mostrar();
           }
           if(objeto==Editar){
               Editar();
           }
           if(objeto==Eliminar){
               Eliminar();
           }
           if(objeto==CbID){
              String copiar=(String)CbID.getSelectedItem();
              txtid.setText(copiar);
              Mostrar();
           }
           if(objeto==Ventas){
               Ventas v=new Ventas();
               v.setVisible(true);
               dispose();
           }
           if(objeto==Finanzas){
               Finanzas f= new Finanzas();
               f.setVisible(true);
               dispose();
           }
}

    public static void main(String[] args) {
        Inventario v= new Inventario();
        v.setVisible(true);
    }
}
