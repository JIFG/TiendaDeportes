package Respaldo;

import java.awt.Color;
import java.awt.Font;
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
public class Finanzas extends JFrame implements ActionListener{

JLabel ID,Nombre,Pais,color,lblTotal;
JTextField txtid,txtnombre,txtpais,txtcolor,Total;
JButton Crear,Mostrar,Editar,Eliminar,Ventas,Inventario,rec;
JComboBox CbID;
JScrollPane scroll;
JScrollPane Scroll2;
String barra= File.separator;
String ubicacion2= System.getProperty("user.dir")+barra+"Ventas"+barra;
JTable Tabla;
     
File contenedor2= new File(ubicacion2);
File[ ] registros= contenedor2.listFiles();

String [] titulos={"Cliente","Productos","Fecha","Pago"};
DefaultTableModel dtm= new DefaultTableModel(null,titulos);

public  Finanzas(){
    super ("Finanzas");
    ((JPanel)getContentPane()).setOpaque(false);
    ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/Finanzas3.jpg"));
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
        File url= new File(ubicacion2+registros[i].getName());
        try {
            FileInputStream fis= new FileInputStream(url);
            Properties mostrar= new Properties();
            mostrar.load(fis);
            String filas[]={registros[i].getName().replace(".txt", ""),
            mostrar.getProperty("Producto"),mostrar.getProperty("Cantidad"),mostrar.getProperty("Pago"),
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
 ID.setBounds(80, 50, 100, 25);
 ID.setFont(new java.awt.Font("Tahoma", 1, 18));
 ID.setForeground(new java.awt.Color(255, 255, 255));
 txtid=new JTextField();
 txtid.setBounds(150, 50, 100, 25);
 Nombre=new JLabel("Producto");
 Nombre.setBounds(50, 100, 100, 25);
 Nombre.setFont(new java.awt.Font("Tahoma", 1, 18));
 Nombre.setForeground(new java.awt.Color(255, 255, 255));
 txtnombre=new JTextField();
 txtnombre.setBounds(150, 100, 100, 25);
 Pais=new JLabel("Cantidad");
 Pais.setBounds(50, 150, 100, 25);
 Pais.setFont(new java.awt.Font("Tahoma", 1, 18));
 Pais.setForeground(new java.awt.Color(255, 255, 255));
 txtpais=new JTextField();
 txtpais.setBounds(150, 150, 100, 25);
 color=new JLabel("Precio");
 color.setBounds(50, 200, 100, 25);
 color.setFont(new java.awt.Font("Tahoma", 1, 18));
 color.setForeground(new java.awt.Color(255, 255, 255));
 txtcolor=new JTextField();
 txtcolor.setBounds(150, 200, 100, 25);
Total= new JTextField("");
Total.setBounds(710, 725, 100, 30);
Total.setFont(new java.awt.Font("Tahoma", 1, 18));
lblTotal= new JLabel("Total ");
lblTotal.setBounds(650, 725, 100, 30);
lblTotal.setFont(new java.awt.Font("Tahoma", 1, 18));
 //etiquetas y textos
 //Botones
 Crear= new JButton("Agregar");
 Crear.setBounds(462, 304, 110, 28);
 Crear.setFont(new java.awt.Font("Tahoma", 1, 18));
 Editar=new JButton("Editar");
 Editar.setBounds(602, 304, 110, 28);
 Editar.setFont(new java.awt.Font("Tahoma", 1, 18));
 Eliminar= new JButton("Eliminar");
 Eliminar.setBounds(743, 304, 110, 28);
 Eliminar.setFont(new java.awt.Font("Tahoma", 1, 18));
  Ventas= new JButton("Ventas");
  Ventas.setBounds(650, 165, 130, 25);
  Ventas.setFont(new java.awt.Font("Tahoma", 1, 18));
 Inventario= new JButton("Inventario");
 Inventario.setBounds(500, 165, 130, 25);
 Inventario.setFont(new java.awt.Font("Tahoma", 1, 18));
 //Botones
 //ComboBox
 CbID= new JComboBox();
 CbID.setBounds(302, 51, 99, 25);

 
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
 add(Inventario);
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
 Editar.addActionListener(this);
 Eliminar.addActionListener(this);
 CbID.addActionListener(this);
 Ventas.addActionListener(this);
 Inventario.addActionListener(this);
}



private void Mostrar(){
 File url= new File(ubicacion2+txtid.getText()+".txt");
 if(txtid.getText().equals("")){
     /*     JOptionPane.showMessageDialog(rootPane,"Indique el ID para mostrar");*/
 }else{
     if(url.exists()){
         try {
             FileInputStream fis= new FileInputStream(url);
             Properties mostrar= new Properties();
             mostrar.load(fis);
             txtid.setText(mostrar.getProperty("Nombre"));
             txtnombre.setText(mostrar.getProperty("Cantidad"));
             txtpais.setText(mostrar.getProperty("Producto"));
             txtcolor.setText(mostrar.getProperty("Pago"));
             } catch (Exception e) {
         }
      }else{
         JOptionPane.showMessageDialog(rootPane,"Ese registro no existe");
     }
 }
}

private void Editar(){
    File url= new File(ubicacion2+txtid.getText()+".txt");
    if(txtid.getText().equals("")){
        JOptionPane.showMessageDialog(rootPane,"Indique el registro a editar");
    }else{
        if(url.exists()){
            try {
                
        FileWriter permite_escribir= new FileWriter(ubicacion2+txtid.getText()+".txt");
        String Id="ID=";
        String name="Producto=";
        String pais="Cantidad=";
        String color="Pago=";
        
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
    File url= new File(ubicacion2+txtid.getText()+".txt"); 
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
    registros=contenedor2.listFiles();
    dtm.setRowCount(0);
    RegTabla();
   }

public void actionPerformed(ActionEvent e) {
           Object objeto=e.getSource();
           if(objeto==Crear){
           }
           if(objeto==Mostrar){
          DefaultTableModel modelo=(DefaultTableModel)Tabla.getModel();
          int filas=Tabla.getRowCount();
          for(int i=0;filas>i;i++){
              modelo.removeRow(0);
              Total.setText("");
          }
           }
           if(objeto==Editar){
               Editar();
           }
           if(objeto==rec){
           DefaultTableModel modelo=(DefaultTableModel)Tabla.getModel();
          int filas=dtm.getRowCount();
          for(int i=0;filas>i;i++){
              modelo.removeRow(0);
              Total.setText("");
           }}
           if(objeto==Eliminar){
               Eliminar();
           }
           if(objeto==CbID){
              String copiar=(String)CbID.getSelectedItem();
              txtid.setText(copiar);
              Mostrar();
           }
           if(objeto==Inventario){
               Inventario I=new Inventario();
               I.setVisible(true);
               dispose();
           }
           if(objeto==Ventas){
               Ventas v=new Ventas();
               v.setVisible(true);
               dispose();
           }
}

    public static void main(String[] args) {
        Finanzas f= new Finanzas();
        f.setVisible(true);
    }
}
