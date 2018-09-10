/*******************************/
/*****Creado por: R_A_V_R_*****/
/*******************************/

package cel;
/*librerias*/
import javax.microedition.midlet.*;
import javax.microedition.io.*;
import com.sun.lwuit.plaf.*;
import com.sun.lwuit.util.Resources;
import com.sun.lwuit.*;
import com.sun.lwuit.events.*;
import com.sun.lwuit.table.*;
import com.sun.lwuit.layouts.*;
import java.io.*;
import java.util.*;
import javax.microedition.io.file.*;
import net.sourceforge.mobilebio.png.Encoder;

/*class del area de trabajo po defaulta habre para crear monstruos*/
public class main extends MIDlet implements ActionListener{
	public List opciones;
	public Label label6; //label en el que se mostrara la imagen de la carta
	public ComboBox tipo, nivel; 
	public TextField ATK, DEF;
	public Button nuevo, guardar, salir, imagen, generar; //botones como barra de herramientas
	public int data=3; //variable que determina el tipo de carta
	public Image foto; //imagen a insertar en la carta
	public Image carta, cartareverso; //imagenes de la carta generada
	public int halado=0; //variable que determina si la carta ya tiene la imagen insertada
	/*inicializamos el tema*/
	public main(){
		Display.init(this);
		try{Resources r = Resources.open("/cel/tema.res");UIManager.getInstance().setThemeProps(r.getTheme(r.getThemeResourceNames()[0]));}
		catch(java.io.IOException e){System.err.println("tema no encontrado");}
	}
	/*constructor del formulario*/
	public void formulario(int data){
		this.data = data;
		Form formulario = new Form("Orica");
		TabbedPane lenguetas;
		Container panel_de_imagen, panel_de_datos, maquetador_de_paneles, panel_botones;
		TableLayout layout_de_imagen, layout_de_datos;
		TableLayout.Constraint atributos_layout_imagen, atributos_layout_datos;
		/*interfaz para crear hechizo o trampa*/
		if(data == 1 || data == 2){
			panel_botones = new Container();
			panel_botones.setLayout(new GridLayout(1,3));
			nuevo = new Button("Nuevo"); guardar = new Button("Guardar"); salir = new Button("Salir");
			nuevo.addActionListener(this); guardar.addActionListener(this); salir.addActionListener(this);
			panel_botones.addComponent(nuevo); panel_botones.addComponent(guardar); panel_botones.addComponent(salir);
			panel_de_datos = new Container();
			layout_de_datos = new TableLayout(1, 2);
			panel_de_datos.setLayout(layout_de_datos);
			atributos_layout_datos = layout_de_datos.createConstraint();
			atributos_layout_datos.setWidthPercentage(40);
			Label label1 = new Label("Imagen:");
			panel_de_datos.addComponent(atributos_layout_datos, label1);
			atributos_layout_datos = layout_de_datos.createConstraint();
			atributos_layout_datos.setWidthPercentage(60);
			imagen = new Button("PNG");
			imagen.addActionListener(this);
			panel_de_datos.addComponent(atributos_layout_datos, imagen);
			panel_de_imagen = new Container();
			layout_de_imagen = new TableLayout(2, 1);
			panel_de_imagen.setLayout(layout_de_imagen);
			atributos_layout_imagen = layout_de_imagen.createConstraint();
			Image img = null;
			/*hechizo*/
			if(data==1){
				try{img = Image.createImage("/cel/pro1.png");}catch(Exception e){}
			}
			/*trampa*/
			else{
				try{img = Image.createImage("/cel/pro2.png");}catch(Exception e){}
			}
			label6 = new Label(img);
			label6.setAlignment(Component.CENTER);
			panel_de_imagen.addComponent(label6);
			atributos_layout_imagen.setWidthPercentage(100);
			generar = new Button("Generar carta");
			generar.addActionListener(this);
			panel_de_imagen.addComponent(atributos_layout_imagen, generar);
		}
		/*interfaz para crear cartas monstruos*/
		else{
			panel_botones = new Container();
			panel_botones.setLayout(new GridLayout(1,3));
			nuevo = new Button("Nuevo"); guardar = new Button("Guardar"); salir = new Button("Salir");
			nuevo.addActionListener(this); guardar.addActionListener(this); salir.addActionListener(this);
			panel_botones.addComponent(nuevo); panel_botones.addComponent(guardar); panel_botones.addComponent(salir);
			panel_de_datos = new Container();
			layout_de_datos = new TableLayout(5, 2);
			panel_de_datos.setLayout(layout_de_datos);
			atributos_layout_imagen = layout_de_datos.createConstraint();
			atributos_layout_imagen.setWidthPercentage(40);
			Label label1 = new Label("Imagen:");
			panel_de_datos.addComponent(atributos_layout_imagen, label1);
			atributos_layout_imagen = layout_de_datos.createConstraint();
			atributos_layout_imagen.setWidthPercentage(60);
			imagen = new Button("PNG");
			imagen.addActionListener(this);
			panel_de_datos.addComponent(atributos_layout_imagen, imagen);
			atributos_layout_imagen = layout_de_datos.createConstraint();
			atributos_layout_imagen.setWidthPercentage(40);
			Label label2 = new Label("Tipo:");
			panel_de_datos.addComponent(atributos_layout_imagen, label2);
			atributos_layout_imagen = layout_de_datos.createConstraint();
			atributos_layout_imagen.setWidthPercentage(60);
			tipo = new ComboBox(new String[]{"Oscuridad","Tierra","Fuego","Luz","Agua","Viento"});
			panel_de_datos.addComponent(atributos_layout_imagen, tipo);
			atributos_layout_imagen = layout_de_datos.createConstraint();
			atributos_layout_imagen.setWidthPercentage(40);
			Label label3 = new Label("Nivel:");
			panel_de_datos.addComponent(atributos_layout_imagen, label3);
			atributos_layout_imagen = layout_de_datos.createConstraint();
			atributos_layout_imagen.setWidthPercentage(60);
			/*monstruo normal*/
			if(data==3){
				nivel = new ComboBox(new String[]{"1", "2", "3", "4", "5", "6", "7", "8"});
				panel_de_datos.addComponent(atributos_layout_imagen, nivel);
			}
			/*monstruo efecto*/
			if(data==4){
				nivel = new ComboBox(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});
				panel_de_datos.addComponent(atributos_layout_imagen, nivel);
			}
			/*monstruo fusion*/
			if(data==5){
				nivel = new ComboBox(new String[]{"5", "6", "7", "8", "9", "10"});
				panel_de_datos.addComponent(atributos_layout_imagen, nivel);
			}
			atributos_layout_imagen = layout_de_datos.createConstraint();
			atributos_layout_imagen.setWidthPercentage(40);
			Label label4 = new Label("ATK:");
			panel_de_datos.addComponent(atributos_layout_imagen, label4);
			atributos_layout_imagen = layout_de_datos.createConstraint();
			atributos_layout_imagen.setWidthPercentage(60);
			ATK = new TextField("");
			panel_de_datos.addComponent(atributos_layout_imagen, ATK);
			atributos_layout_imagen = layout_de_datos.createConstraint();
			atributos_layout_imagen.setWidthPercentage(40);
			Label label5 = new Label("DEF:");
			panel_de_datos.addComponent(atributos_layout_imagen, label5);
			atributos_layout_imagen = layout_de_datos.createConstraint();
			atributos_layout_imagen.setWidthPercentage(60);
			DEF = new TextField("");
			panel_de_datos.addComponent(atributos_layout_imagen, DEF);
			panel_de_imagen = new Container();
			layout_de_imagen = new TableLayout(2, 1);
			panel_de_imagen.setLayout(layout_de_imagen);
			atributos_layout_imagen = layout_de_imagen.createConstraint();
			Image img = null;
			/*monstruo normal*/
			if(data==3){
				try{img = Image.createImage("/cel/pro3.png");}catch(Exception e){}
			}
			/*monstruo efecto*/
			if(data==4){
				try{img = Image.createImage("/cel/pro4.png");}catch(Exception e){}
			}
			/*monstruo fusion*/
			if(data==5){
				try{img = Image.createImage("/cel/pro5.png");}catch(Exception e){}
			}
			label6 = new Label(img);
			label6.setAlignment(Component.CENTER);
			panel_de_imagen.addComponent(label6);
			atributos_layout_imagen.setWidthPercentage(100);
			generar = new Button("Generar carta");
			generar.addActionListener(this);
			panel_de_imagen.addComponent(atributos_layout_imagen, generar);
		}
		/*creamos leguetas*/
		lenguetas = new TabbedPane();
		lenguetas.addTab("Datos", panel_de_datos);
		lenguetas.addTab("Carta", panel_de_imagen);
		/*ordenamos el panel de botones y leguetas horizontalmente*/
		maquetador_de_paneles = formulario.getContentPane();
		maquetador_de_paneles.setLayout(new BorderLayout());
		maquetador_de_paneles.addComponent(BorderLayout.NORTH, panel_botones);
		maquetador_de_paneles.addComponent(BorderLayout.CENTER, lenguetas);
		/*mostramos el formulario*/
		formulario.show();
	}
	/*metodo para determinar la direccion del reverso*/
	public String dir_reverso(String cadena){
		char delimitador = '/'; String ruta = ""; int a = 0;
		for(int i=11;i<cadena.length();i++){if(cadena.charAt(i)==delimitador){a++;}}
		String[] carpeta = new String[a]; a = 0;
		for(int i=11;i<cadena.length();i++){ 
			if(cadena.charAt(i)==delimitador){carpeta[a]=ruta; a++; ruta="";} 
			else{ruta=ruta+cadena.charAt(i);}
		}
		ruta="";
		for(int i=0;i<a;i++){ 
			if(i==0){ruta = carpeta[i];}
			else{ruta = ruta + "/" +carpeta[i];}
		}
		return "file:///E:/" + ruta + "/" + "reverso.png";
	}
	/*abrimos el formulario para creacion de monstruo inicialmente*/
	public void startApp(){formulario(3);}
	/*accionamiento al pausar*/
	public void pauseApp(){}
	/*accionamiento al salir*/
	public void destroyApp(boolean unconditional){}
	/*accionamiento de eventos*/
	public void actionPerformed(ActionEvent e){
		/*selector de nueva carta*/
		if(e.getSource()==nuevo){
			Form formulario = new Form("Seleccione una opcion: ");
			opciones = new List(new String[]{"Hechizo", "Trampa", "Normal", "Efecto", "Fusion"});
			formulario.addComponent(opciones);
			opciones.addActionListener(this);
			formulario.show();
		}
		/*nuevo proyecto o nueva carta seleccionada*/
		if(e.getSource()==opciones){
			formulario(opciones.getSelectedIndex()+1);
		}
		/*abrir imagen para aderir a la carta*/
		if(e.getSource()==imagen){
			Container panel = new Container(new GridLayout(2, 1));
			TextField archivo = new TextField("file:///E:/"); Button ok = new Button("Aceptar"); panel.addComponent(archivo); panel.addComponent(ok);
			Dialog.show("Memoria Externa", panel, new Command[]{new Command("Aceptar")});
			try{
				FileConnection fconn = (FileConnection) Connector.open(archivo.getText(), Connector.READ);
				InputStream in = fconn.openInputStream();
				foto = Image.createImage(in); //variable global de la imagen a insertar en la carta
				in.close(); fconn.close();
				halado = 1;
			}catch(Exception a){halado = 0;Dialog.show("ERROR", new Label("Archivo no encontrado"), new Command[]{new Command("Aceptar")});}
		}
		/*crear carta*/
		if(e.getSource()==generar){
			try{
				/*invocamos la classe para crear una carta hechizo o trampa*/
				if(data==1 || data==2){
					orica carta_yugioh = new orica(data, foto);
					carta = carta_yugioh.crear_orica();  //variable global de la carta generada por la class orica
					cartareverso = carta_yugioh.crear_orica_boca_abajo();//variable global de la carta boca abajo generada por la class orica
					/*mostramos la imagen en el label*/
					Image redimensionada = Image.createImage(100, 146);
					Graphics grafico = redimensionada.getGraphics();
					grafico.drawImage(carta, 0, 0, 100, 146);
					label6.setIcon(redimensionada);
				}
				/*invocamos la classe para crear una carta monstruo*/
				else{
					int estrellitas = Integer.parseInt((String)nivel.getSelectedItem());
					int tipo_de_monstruo = tipo.getSelectedIndex()+1;
					int atacke = Integer.parseInt(this.ATK.getText());
					int defensa = Integer.parseInt(this.DEF.getText());
					if(atacke>=0 && atacke<=9999 && defensa>=0 && defensa<=9999){
						orica carta_yugioh = new orica(data, foto, estrellitas, tipo_de_monstruo, atacke, defensa);
						carta = carta_yugioh.crear_orica(); //variable global de la carta generada por la class orica
						/*mostramos la imagen en el label*/
						Image redimensionada = Image.createImage(100, 146);
						Graphics grafico = redimensionada.getGraphics();
						grafico.drawImage(carta, 0, 0, 100, 146);
						label6.setIcon(redimensionada);
					}
					else{Dialog.show("ADVERTENCIA", new Label("Datos invalidos"), new Command[]{new Command("Aceptar")});}
				}
			}catch(Exception a){Dialog.show("ADVERTENCIA", new Label("Sin datos"), new Command[]{new Command("Aceptar")});}
		}
		/*generar archivo y guardar la carta como archivo de imagen*/    
		if(e.getSource()==guardar){
			try{
				if(halado == 1){
					Container panel = new Container(new GridLayout(2, 1));
					TextField archivo = new TextField("file:///E:/"); Button ok = new Button("Aceptar"); panel.addComponent(archivo); panel.addComponent(ok);
					Dialog.show("Memoria Externa", panel, new Command[]{new Command("Aceptar")});
					FileConnection fconn = (FileConnection) Connector.open(archivo.getText(), Connector.WRITE); fconn.create();
					OutputStream out = fconn.openOutputStream();
					byte[] imageBytes = Encoder.toPNG(javax.microedition.lcdui.Image.createRGBImage(carta.getRGB(), carta.getWidth(), carta.getHeight(), true));
					out.write(imageBytes); //guardamos la carta generada
					out.close(); fconn.close(); imageBytes = null;
					fconn = (FileConnection) Connector.open(dir_reverso(archivo.getText()), Connector.READ_WRITE); 
					if(!fconn.exists()){ 
						fconn.create();
						out = fconn.openOutputStream();
						imageBytes = Encoder.toPNG(javax.microedition.lcdui.Image.createRGBImage(cartareverso.getRGB(), cartareverso.getWidth(), cartareverso.getHeight(), true));
						out.write(imageBytes); //guardamos la carta boca abajo generada
						out.close(); fconn.close(); imageBytes = null;
					}
					Dialog.show("INFORMACION", new Label("Archivo Guardado"), new Command[]{new Command("Aceptar")});
				}
				else{
					Dialog.show("ERROR", new Label("Sin datos"), new Command[]{new Command("Aceptar")});
				}
			}catch(Exception a){Dialog.show("ERROR", new Label("No guardado"), new Command[]{new Command("Aceptar")});}
		}
		/*salir*/
		if(e.getSource()==salir){
			destroyApp(true);
			notifyDestroyed();
		}
	}
}

/*class orica para la manipulacion y creacion de la orica*/
class orica{
	private int tipo_de_carta;
	private Image monstruo;
	private int nivel;
	private int tipo_de_monstruo;
	private int atacke;
	private int defensa;
	/*constructor de la orica, objeto poliformico para monstruos*/
	public orica(int tipo_de_carta, Image monstruo, int nivel, int tipo_de_monstruo, int atacke, int defensa){
		this.tipo_de_carta = tipo_de_carta;
		this.monstruo = monstruo;
		this.nivel = nivel;
		this.tipo_de_monstruo = tipo_de_monstruo;
		this.atacke = atacke;
		this.defensa = defensa;
	}
	/*constructor de la orica, objeto poliformico para hechizos y trampas*/
	public orica(int tipo_de_carta, Image monstruo){
		this.tipo_de_carta = tipo_de_carta;
		this.monstruo = monstruo;
	}
	/*metodo para crear la carta y retorna la imagen*/
	public Image crear_orica(){ 
		try{
			int width = 200, height = 291;
			Image tmp = Image.createImage(width, height);
			Graphics grafico = tmp.getGraphics();
			/*generamos carta hechizo o trampa*/
			if(tipo_de_carta==1 || tipo_de_carta==2){
				/*generamos carta hechizo*/
				if(tipo_de_carta==1){
					Image fondo = Image.createImage("/cel/carta1.png");
					grafico.drawImage(fondo, 0, 0);
				}
				/*generamos carta trampa*/
				else if(tipo_de_carta==2){
					Image fondo = Image.createImage("/cel/carta2.png");
					grafico.drawImage(fondo, 0, 0);
                		}
                		grafico.drawImage(monstruo, 4, 4, 192, 205);
                		/*retornamos el bufer de la imagen de la carta generada*/
				return tmp;
			}
			/*generamos carta monstruo*/
			else{
				/*generamos carta monstruo normal*/
				if(tipo_de_carta==3){
					Image fondo = Image.createImage("/cel/carta3.png");
					grafico.drawImage(fondo, 0, 0);
				}
				/*generamos carta monstruo efecto*/
				else if(tipo_de_carta==4){
					Image fondo = Image.createImage("/cel/carta4.png");
					grafico.drawImage(fondo, 0, 0);
				}
				/*generamos carta monstruo fusion*/
				else if(tipo_de_carta==5){
					Image fondo = Image.createImage("/cel/carta5.png");
					grafico.drawImage(fondo, 0, 0);
				}
				/*aderimos el monstruo*/
				grafico.drawImage(monstruo, 4, 4, 192, 205);
				/*aderimos las estrellas*/
				Image estrellas = Image.createImage("/cel/carta"+tipo_de_carta+"nivel"+nivel+".png");
				grafico.drawImage(estrellas, 0, 209);
				/*aderimos el tipo de monstruo*/
				Image img_tipo_de_monstruo = Image.createImage("/cel/tipo"+tipo_de_monstruo+".png");
				grafico.drawImage(img_tipo_de_monstruo, 163, 223);
				/*personalizamos tipo de letra*/
				Resources r = Resources.open("/cel/tema.res");
				Font f = r.getFont(r.getFontResourceNames()[0]); 
				grafico.setFont(f);
				/*aderimos el atacke*/
				if(atacke>=0&&atacke<=99){grafico.drawString(atacke+"", 46-1, 253-6);}
				else if(atacke>=100&&atacke<=999){grafico.drawString(atacke+"", 35-1, 253-6);}
				else{grafico.drawString(atacke+"", 25-1, 253-6);}
				/*aderimos la defensa*/
				if(defensa>=0 && defensa<=99){grafico.drawString(defensa+"", 137-1, 253-6);}
				else if(defensa>=100 && defensa<=999){grafico.drawString(defensa+"", 127-1, 253-6);}
				else{grafico.drawString(defensa+"", 116-1, 253-6);}
				/*retornamos la imagen de la carta generada*/
				return tmp;
			}
		}catch(Exception a){return null;}
	}  
	/*metodo para crear el reverso de la carta y retornar la imagen*/
	public Image crear_orica_boca_abajo(){ 
		try{
			Image tmp = Image.createImage("/cel/reverso.png");
			return tmp;
		}catch(Exception a){return null;}
	}
}
