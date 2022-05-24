package Respaldo;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Formatter;
import java.util.Properties;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.util.*;
import javax.swing.JLayeredPane;
/**
 *
 * @author isaac
 */
public class Ventas extends JFrame implements ActionListener{
JLabel ID,Nombre,Pais,color,lblTotal,stock;
JLabel textofech,titfecha;
JPanel pTicket;
JTextField txtid,txtid2,txtprod,txtcant,txtcant2,txtPrec,Total,CanProd;
JTextArea txtArea;
JButton Agregar,Mostrar,Pagar,Eliminar,Ventas,Finanzas,rec,Ticket;
JComboBox CbID;
JScrollPane scroll;
JScrollPane Scroll2;
ImageIcon imagen;
Icon icono;
int cantidad;
float precio;

String barra= File.separator;
String ubicacion= System.getProperty("user.dir")+barra+"Registros"+barra;
JTable Tabla;
String ubicacion2=System.getProperty("user.dir")+barra+"Ventas"+barra;
File contenedor= new File(ubicacion);
File contenedor2= new File(ubicacion2);
File[ ] registros= contenedor.listFiles();
File[ ] registros2=contenedor2.listFiles();
String []dato= new String[5];
String [] titulos={"Producto","Cantidad","Precio","Pago"};
DefaultTableModel dtm= new DefaultTableModel(null,titulos);

public  Ventas(){
    super ("Ventas");
    ((JPanel)getContentPane()).setOpaque(false);
    ImageIcon uno=new ImageIcon(this.getClass().getResource("/Imagenes/Ventastt.jpg"));
    JLabel fondo= new JLabel();
    fondo.setIcon(uno);
    getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
    fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());

Ventana();
Componentes();
Listener();
MostrarCombo();
MiTabla();
fecha2();

}
public static  String fecha(){
    Date fecha= new Date();
    SimpleDateFormat formatofecha=new SimpleDateFormat("dd/MM/YYYY");
    return formatofecha.format(fecha);
    
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
public void Componentes(){
//etiquetas y textos
ID=new JLabel("ID");
ID.setBounds(80, 50, 100, 25);
ID.setFont(new java.awt.Font("Tahoma", 1, 18));
ID.setForeground(new java.awt.Color(255, 255, 255));
txtid=new JTextField();
/*txtid.setBounds(150, 50, 100, 25);*/
CanProd= new JTextField();
CanProd.setBounds(550, 100, 100, 30);
txtid2=new JTextField();
txtid2.setBounds(150, 53, 100, 30);
Nombre=new JLabel("Producto");
Nombre.setBounds(50, 100, 100, 25);
Nombre.setFont(new java.awt.Font("Tahoma", 1, 18));
Nombre.setForeground(new java.awt.Color(255, 255, 255));
txtprod=new JTextField();
txtprod.setBounds(151, 103, 100, 25);
Pais=new JLabel("Cantidad");
Pais.setBounds(50, 150, 100, 25);
Pais.setForeground(new java.awt.Color(255, 255, 255));
Pais.setFont(new java.awt.Font("Tahoma", 1, 18));
txtcant=new JTextField();
txtcant.setBounds(338, 148, 30, 25);
txtcant2= new JTextField();
txtcant2.setBounds(150, 150, 100, 25);
stock= new JLabel("STOCK");
stock.setBounds(320, 115, 140, 25);
stock.setFont(new java.awt.Font("Tahoma", 1, 18));
stock.setForeground(new java.awt.Color(255, 255, 255));
color=new JLabel("Precio");
color.setBounds(50, 200, 100, 25);
color.setForeground(new java.awt.Color(255, 255, 255));
color.setFont(new java.awt.Font("Tahoma", 1, 18));
txtPrec=new JTextField();
txtPrec.setBounds(151, 200, 100, 25);

Total= new JTextField("");
Total.setBounds(714, 731, 100, 30);
Total.setFont(new java.awt.Font("Tahoma", 1, 18));

lblTotal= new JLabel("Total ");
lblTotal.setBounds(650, 725, 100, 30);
lblTotal.setFont(new java.awt.Font("Tahoma", 1, 18));
lblTotal.setForeground(new java.awt.Color(255, 255, 255));
//etiquetas y textos
//Botones
Agregar= new JButton("Agregar");
Agregar.setBounds(464, 218, 110, 30);
Agregar.setFont(new java.awt.Font("Tahoma", 1, 18));

Pagar=new JButton("Pagar");
Pagar.setBounds(751, 222, 110, 26);
Pagar.setFont(new java.awt.Font("Tahoma", 1, 18));

Eliminar= new JButton("Eliminar");
Eliminar.setBounds(605, 219, 110, 30);
Eliminar.setFont(new java.awt.Font("Tahoma", 1, 18));

rec= new JButton("N");
rec.setBounds(690,220,50,30);
rec.setFont(new java.awt.Font("Tahoma", 1, 18));
rec.setForeground(new java.awt.Color(16, 16, 16));

Ventas= new JButton("Inventario");
Ventas.setBounds(656, 148, 139, 28);
Ventas.setFont(new java.awt.Font("Tahoma", 1, 18));

Finanzas= new JButton("Finanzas");
Finanzas.setBounds(504, 147, 120, 30);
Finanzas.setFont(new java.awt.Font("Tahoma", 1, 18));
//Botones
titfecha =new JLabel("Fecha");
titfecha.setBounds(50, 10, 100, 25);
titfecha.setFont(new java.awt.Font("Tahoma", 1, 18));
titfecha.setForeground(new java.awt.Color(255, 255, 255));
textofech =new JLabel("DD/MM/YYYY ");
textofech.setBounds(160, 10, 140, 25);
textofech.setFont(new java.awt.Font("Tahoma", 1, 18));
textofech.setForeground(new java.awt.Color(255, 255, 255));
//ComboBox
CbID= new JComboBox();
CbID.setBounds(308, 55, 140, 25);
//COmboBox

//añadir a panel
add(ID);
add(Nombre);
add(Pais);
add(color);
add(txtid);
add(txtprod);
add(txtcant);
add(stock);
add(txtcant2);
add(txtPrec);
add(Agregar);
add(Ventas);
add(Finanzas);
/*add(rec);*/
add(txtid2);
//add(CanProd);
/* add(Mostrar);*/
add(textofech);
add(titfecha);
add(Pagar);
add(Eliminar);
add(CbID);
add(Total);
add(lblTotal);
}
public void Productos(){
       CanProd.setText("0");
   int ta=dtm.getRowCount();
   int c=0;
   do 
       try {
          int f=c++;
          int n1=Integer.parseInt(dtm.getValueAt(f, 1).toString());
          String nu=CanProd.getText();
          int nu2=Integer.parseInt(nu);
          long re=n1+nu2;
          CanProd.setText(String.valueOf(re));
       } catch (Exception qweq) {
       }
    while(c<ta);
}

public void MiTabla(){
         

         
         dtm= new DefaultTableModel (){
             
             @Override
             public boolean isCellEditable(int filas,int columnas){
                 return columnas==2;
             }
         };
         
       Tabla = new JTable(dtm);
         
       Tabla.setBorder(new BevelBorder(BevelBorder.RAISED,null,null,null,null));
        
       Tabla.setBackground(Color.white);
       this.add( scroll = new JScrollPane(Tabla));
       this.add( Scroll2 = new JScrollPane());
         
       JTableHeader encabezado=Tabla.getTableHeader();
       encabezado.setForeground(Color.BLACK);
       encabezado.setFont(new Font("Tahoma",1,15));
       encabezado.setBackground(new Color(120, 238, 179));
       Tabla.setSelectionBackground(Color.BLACK);
       Tabla.setSelectionForeground(Color.WHITE);
       
       Tabla.setFont(new Font("Tahoma",1,15));
        
       dtm.addColumn("Producto");
       dtm.addColumn("Cantidad");
       dtm.addColumn("Precio");
       dtm.addColumn("Pago");
        
       
       Tabla.setModel(dtm);
        
       Scroll2.setBounds(50, 270, 800, 450);
       scroll.setBounds(50, 270, 800, 450);
       Tabla.setBounds(50,270, 800, 450);
     
    }

public void Listener(){
//ActionListener
Agregar.addActionListener(this);
/* Mostrar.addActionListener(this);*/
Pagar.addActionListener(this);
Eliminar.addActionListener(this);
CbID.addActionListener(this);
Ventas.addActionListener(this);
Finanzas.addActionListener(this);
rec.addActionListener(this);
}

private void Crear(){
    String archivo= txtid2.getText()+".txt";
    File crea_ubicacion = new File(ubicacion2);
    File crea_archivo = new File(ubicacion2+archivo);
    if(txtid2.getText().equals("")){
        JOptionPane.showMessageDialog(rootPane, "No hay ID");
    }else{
        try {
                 if(crea_archivo.exists()){
            JOptionPane.showMessageDialog(rootPane,"El registro ya existe");
              }else{
 //mkdirs sirve para crear carpetas dentro de la ubicacion
                    crea_ubicacion.mkdirs();
                    Formatter crea = new Formatter(ubicacion2+archivo);
                    crea.format("%s\r\n%s\r\n%s\r\n%s",
                                 "ID="+txtid2.getText(),
                                 "Cantidad="+textofech.getText() 
                                   ,"Producto="+CanProd.getText()
                                 ,"Pago="+Total.getText());
                                    txtid2.setText("");
                                    txtprod.setText("");
                                    txtcant.setText("");
                                    txtPrec.setText("");
                    
            crea.close();
            CbID.removeAllItems();
            registros2= contenedor2.listFiles();
            MostrarCombo();
        } 
                         }catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"NOOO SE PUDO");
        }
     
  
              
                
                
    }}

public void Recibo(JTable miTabla,String nom,String talla,String sumaTotal){
        
        JFrame vtnaTicket = new JFrame();
        JPanel pTicket = new JPanel();
        vtnaTicket.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vtnaTicket.setVisible(true);
        vtnaTicket.setTitle("Ticket de compra");
        pTicket.setLayout(null);
        vtnaTicket.setSize(350,800);
        JTextArea txtArea = new JTextArea();
        String infoAcum = "";
        int precioFacum = 0;
        for (int i = 0; i < dtm.getRowCount(); i++) {
            infoAcum += ""
                    + "\n Num Producto: " + (i+1) + "\n"+
                        "Producto: " + dtm.getValueAt(i, 0)+ "\n" + 
                        "Cantidad: " + dtm.getValueAt(i, 1)+ "\n"+
                        "Precio: " + dtm.getValueAt(i, 2)+ "\n"+ 
                        "Pago: "+ dtm.getValueAt(i, 3)+"\n"+"--------------------";
           
        }
        int fila,costo=0;
        String costoFinal = "";
        
        for(int i = 0;  i<dtm.getRowCount(); i++){
                fila  = Integer.parseInt(dtm.getValueAt(i,3).toString());
                costo += fila;
        }
        costoFinal = costo + "";
        txtArea.setText(infoAcum+ "\n" +"\nCosto Final: "+ costoFinal);
        pTicket.add(txtArea);
        txtArea.setBounds(5,100,340,600);
        /*        pTicket.add(lbempleado);
        lbempleado.setBounds(20, 30, 300, 25);*/
        JLabel lbtienda = new JLabel("DPRTS");
        lbtienda.setFont(new java.awt.Font("Tahoma", 1, 60));
        lbtienda.setForeground(new java.awt.Color(73, 199, 140));
        JLabel precios = new JLabel(sumaTotal);
        pTicket.add(lbtienda);
        lbtienda.setBounds(55, 20, 300, 60);
        pTicket.add(precios); 
        
        
        
        
        vtnaTicket.setContentPane(pTicket);
         vtnaTicket.setLocationRelativeTo(null);
    }

private void Mostrar(){
File url= new File(ubicacion+txtid.getText()+".txt");
if(txtid.getText().equals("")){
}
else{
if(url.exists()){
try {
FileInputStream fis= new FileInputStream(url);
Properties mostrar= new Properties();
mostrar.load(fis);

txtprod.setText(mostrar.getProperty("Producto"));
txtcant.setText(mostrar.getProperty("Cantidad"));
txtPrec.setText(mostrar.getProperty("Precio"));
} catch (Exception e) {
}
}else{
JOptionPane.showMessageDialog(rootPane,"Ese registro no existe");
}
}
}

private void fecha2(){
    textofech.setText(fecha());
}

public void actionPerformed(ActionEvent e) {
Object objeto=e.getSource();
if(objeto==Agregar){
    try{
        
        int stock = Integer.parseInt(txtcant.getText());
        int cantidad=Integer.parseInt(txtcant2.getText());
        
String Cant1,Cant,Prec;    
int ent1,ent2,ent3;
Cant=txtcant2.getText();
Prec=txtPrec.getText();
ent2=Integer.parseInt(Prec);
ent1=Integer.parseInt(Cant);
ent1=ent1*ent2;
Cant=Integer.toString(ent1);
              dato[0]=txtprod.getText();
              dato[1]=txtcant2.getText();
              dato[2]=txtPrec.getText();
              dato[3]=Cant;
                if(cantidad>stock){
                    JOptionPane.showMessageDialog(this, "No hay suficiente Producto","advertencia",JOptionPane.WARNING_MESSAGE);
                    txtcant2.setText("");
                    txtcant2.requestFocus();
                }else
                {   
                dtm.addRow(dato);
          
                txtprod.setText(null); 
                txtcant2.setText(null);
                txtPrec.setText(null);   
                
                    
           
                }

                
               }catch(Exception er){            
       JOptionPane.showMessageDialog(null,"Llene todos los Datos.","ADVERTENCIA",JOptionPane.ERROR_MESSAGE);
    
}     Total.setText("0");
   int ta=dtm.getRowCount();
   int c=0;
   do 
       try {
          int f=c++;
          int n1=Integer.parseInt(dtm.getValueAt(f, 3).toString());
          String nu=Total.getText();
          int nu2=Integer.parseInt(nu);
          long re=n1+nu2;
          Total.setText(String.valueOf(re));

          txtcant.setText("");
          txtPrec.setText("");
          txtcant.setText("");
          txtprod.setText("");
          
          
       } catch (Exception qweq) {
       }
    while(c<ta); 
        
    }     
if(objeto==Pagar){   
    Productos();
     int res;
     res=JOptionPane.showConfirmDialog(null, "¿Confirmar Pgo?", "CONFIRMAR", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
     if(res==0){  
   
   Crear();
   Recibo(Tabla, barra, barra, ubicacion);
   DefaultTableModel modelo=(DefaultTableModel)Tabla.getModel();
   int filas=Tabla.getRowCount();
   for(int i=0;filas>i;i++){
   modelo.removeRow(0);
   Total.setText("");

   }
            }else{
                
            }
}
     
    

if(objeto==Eliminar){
    int fil;
       if (dtm.getRowCount()>0){
           if (Tabla.getSelectedRow()!=-1){
               fil=Tabla.getSelectedRow();
               dtm.removeRow(fil);
           }else{
               JOptionPane.showMessageDialog(null, "Seleccione Una Fila");
           }
       }else{ JOptionPane.showMessageDialog(null, "No hay Filas en la Tabla");}
    }

if(objeto==CbID){
String copiar=(String)CbID.getSelectedItem();
txtid.setText(copiar);
Mostrar();
}
if(objeto==Ticket){
    
}
if(objeto==Ventas){
Inventario I=new Inventario();
I.setVisible(true);
dispose();

}
if(objeto==Finanzas){
    Finanzas f= new Finanzas();
    f.setVisible(true);
    dispose();
}
}

public static void main(String[] args) {
    Ventas v= new Ventas();
v.setVisible(true);

}}