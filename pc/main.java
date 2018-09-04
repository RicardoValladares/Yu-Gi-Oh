/*******************************/
/*****Creado por: R_A_V_R_*****/
/*******************************/

package pc;
/*librerias*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;

/*class que se ejecutara primero (elementos de la interfaz bloqueados)*/
class main extends JFrame implements ActionListener{
	private JMenuItem opcion1, opcion2, opcion3, opcion4;
	/*constructor del formulario*/
	public main(){
		setLayout(null);
		setTitle("Creador de oricas Yu-Gi-Oh!");
		JMenuBar barra = new JMenuBar();
		JMenu menu1 = new JMenu("Archivo");
		JMenu menu2 = new JMenu("Sobre");
		opcion1 = new JMenuItem("Nuevo");
		opcion2 = new JMenuItem("Guardar");
		opcion3 = new JMenuItem("Version");
		opcion4 = new JMenuItem("Sobre Mi");
		menu1.add(opcion1);
		menu1.add(opcion2);
		menu2.add(opcion3);
		menu2.add(opcion4);
		barra.add(menu1);
		barra.add(menu2);
		String[] itemstipos = new String[]{"Oscuridad","Tierra","Fuego","Luz","Agua","Viento"};
		String[] itemsnivel = new String[]{"LV1", "LV2", "LV3", "LV4", "LV5", "LV6", "LV7", "LV8", "LV9", "LV10"};
		JComboBox tipo = new JComboBox(itemstipos);
		JComboBox nivel = new JComboBox(itemsnivel);
		JLabel label1 = new JLabel("Imagen:");
		JLabel label2 = new JLabel("Tipo:");
		JLabel label3 = new JLabel("Nivel:");
		JLabel label4 = new JLabel("ATK:");
		JLabel label5 = new JLabel("DEF:");
		JLabel label6 = new JLabel();
		JLabel img1 = new JLabel();
		JLabel img2 = new JLabel();
		JButton archivo = new JButton("PNG");
		JButton carta = new JButton("Generar carta");
		JTextField ATK = new JTextField(5);
		JTextField DEF = new JTextField(5);
		add(barra);
		add(tipo);
		add(nivel);
		add(label1);
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		add(label6);
		add(img1);
		add(img2);
		add(archivo);
		add(carta);
		add(ATK);
		add(DEF);
		barra.setBounds(0,0,440,25);
		tipo.setBounds(70,70,90,25);
		nivel.setBounds(70,145,60,25);
		label1.setBounds(10,35,60,25);
		label2.setBounds(10,70,60,25);
		label3.setBounds(10,145,60,25);
		label4.setBounds(10,180,60,25);
		label5.setBounds(10,215,60,25);
		label6.setBounds(170,35,165,240);
		img1.setBounds(15,105,145,25);
		img2.setBounds(135,145,25,25);
		archivo.setBounds(70,35,90,25);
		carta.setBounds(10,250,150,25);
		ATK.setBounds(70,180,90,25);
		DEF.setBounds(70,215,90,25);
		tipo.setEnabled(false);
		nivel.setEnabled(false);
		label1.setEnabled(false);
		label2.setEnabled(false);
		label3.setEnabled(false);
		label4.setEnabled(false);
		label5.setEnabled(false);
		label6.setEnabled(false);
		img1.setEnabled(false);
		img2.setEnabled(false);
		archivo.setEnabled(false);
		carta.setEnabled(false);
		ATK.setEnabled(false);
		DEF.setEnabled(false);
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/pc/carta3.png"));
		ImageIcon image1 = new ImageIcon(getClass().getResource("/pc/tipos.png"));
		ImageIcon image2 = new ImageIcon(getClass().getResource("/pc/estrellas.png"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(label6.getWidth(),label6.getHeight(), Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		label6.setIcon(iconoEscalado);
		img1.setIcon(image1);
		img2.setIcon(image2);
		opcion1.addActionListener(this);
		opcion2.addActionListener(this);
		opcion3.addActionListener(this);
		opcion4.addActionListener(this);
	}
	/*accionamiento de eventos*/
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==opcion1){
			proyecto nuevopro = new proyecto();
			this.setVisible(false);
		}
		if(e.getSource()==opcion2){
			JOptionPane.showMessageDialog(this,"Cree un nuevo proyecto","ADVERTENCIA",2);
		}
		if(e.getSource()==opcion3){
			JOptionPane.showMessageDialog(this,"Versio: 1.0","INFORMACION",1);
		}
		if(e.getSource()==opcion4){
			JOptionPane.showMessageDialog(this,"Creado por: R_A_V_R_","INFORMACION",1);
		}
	}
	/*metodo principal*/
	public static void main (String[] args) {
		try{JFrame.setDefaultLookAndFeelDecorated(true);JDialog.setDefaultLookAndFeelDecorated(true);UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");}catch (Exception e){e.printStackTrace();}
		main formulario = new main();
		formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		formulario.setSize(350,315);
		formulario.setLocationRelativeTo(null);
		formulario.setResizable(false);
		formulario.setVisible(true);
	}
}

/*class que se ejecutara para seleccionar tipo de carta a crear*/
class proyecto extends JFrame implements ActionListener{
	ButtonGroup opciones;
	JRadioButton opcion1;
	JRadioButton opcion2;
	JRadioButton opcion3;
	JRadioButton opcion4;
	JRadioButton opcion5;
	JButton ok;
	/*constructor del formulario y metodo principal*/
	public proyecto(){
		setLayout(null);
		setTitle("Nuevo proyecto");
		JLabel label1 = new JLabel("Seleccione carta:");
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		JLabel label4 = new JLabel();
		JLabel label5 = new JLabel();
		JLabel label6 = new JLabel();
		ImageIcon carta1 = new ImageIcon(getClass().getResource("/pc/proyecto1.png"));
		ImageIcon carta2 = new ImageIcon(getClass().getResource("/pc/proyecto2.png"));
		ImageIcon carta3 = new ImageIcon(getClass().getResource("/pc/proyecto3.png"));
		ImageIcon carta4 = new ImageIcon(getClass().getResource("/pc/proyecto4.png"));
		ImageIcon carta5 = new ImageIcon(getClass().getResource("/pc/proyecto5.png"));
		label2.setIcon(carta1);
		label3.setIcon(carta2);
		label4.setIcon(carta3);
		label5.setIcon(carta4);
		label6.setIcon(carta5);
		opciones = new ButtonGroup();
		opcion1 = new JRadioButton("hechizo");
		opcion2 = new JRadioButton("trampa");
		opcion3 = new JRadioButton("normal");
		opcion4 = new JRadioButton("efecto");
		opcion5 = new JRadioButton("fusion");
		opciones.add(opcion1);  
		opciones.add(opcion2);
		opciones.add(opcion3);
		opciones.add(opcion4);
		opciones.add(opcion5);
		ok = new JButton("aceptar");
		add(label1);
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		add(label6);
		add(opcion1);
		add(opcion2);
		add(opcion3);
		add(opcion4);
		add(opcion5);
		add(ok);
		label1.setBounds(0,0,130,25);
		label2.setBounds(25,65,100,146);
		label3.setBounds(135,65,100,146);
		label4.setBounds(245,65,100,146);
		label5.setBounds(355,65,100,146);
		label6.setBounds(465,65,100,146);
		opcion1.setBounds(35,40,80,25);
		opcion2.setBounds(150,40,80,25);
		opcion3.setBounds(255,40,80,25);
		opcion4.setBounds(370,40,80,25);
		opcion5.setBounds(480,40,80,25);
		ok.setBounds(465,220,100,25);
		ok.addActionListener(this);
		setSize(600,300);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//addWindowListener(new WindowAdapter(){@Override public void windowClosing(WindowEvent e){  }});
	}
	/*accionamiento de eventos*/
	public void actionPerformed(ActionEvent a){
		if(a.getSource()==ok){
			int opcion;
			if(opcion1.isSelected()){
				opcion = 1;
			}
			else if(opcion2.isSelected()){
				opcion = 2;
			}
			else if(opcion3.isSelected()){
				opcion = 3;
			}
			else if(opcion4.isSelected()){
				opcion = 4;
			}
			else if(opcion5.isSelected()){
				opcion = 5;
			}
			else{
				opcion = 0;
			}
			if(opcion==0){
				JOptionPane.showMessageDialog(this,"Por favor seleccione una opcion");
			}
			else{
				programa cargar = new programa(opcion);
				this.setVisible(false);
			}
		}
	}
}

/*class del area de trabajo (elementos de la interfaz desbloqueados)*/
class programa extends JFrame implements ActionListener{
	private JMenuItem opcion1, opcion2, opcion3, opcion4;
	private JLabel label6; //label en el que se mostrara la imagen de la carta
	private JComboBox tipo, nivel;
	private JTextField ATK, DEF;
	private JButton archivo, carta; //boton archivo para halar imagen llamada foto, boton carta para generar la carta y mostrarla en el label6
	private int data; //variable que determina el tipo de carta
	private Image foto; //imagen a insertar en la carta
	private BufferedImage bufercarta, bufercartareverso; //bufer de las imagenes de la carta generada
	private int halado; //variable que determina si la carta ya tiene la imagen insertada
	/*constructor del formulario y metodo principal*/
	public programa(int data){
		this.data = data; 
		setLayout(null);
		setTitle("Creador de oricas Yu-Gi-Oh!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,315);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		carta = new JButton("Generar carta");
		JMenuBar barra = new JMenuBar();
		JMenu menu1 = new JMenu("Archivo");
		JMenu menu2 = new JMenu("Sobre");
		opcion1 = new JMenuItem("Nuevo");
		opcion2 = new JMenuItem("Guardar");
		opcion3 = new JMenuItem("Version");
		opcion4 = new JMenuItem("Sobre Mi");
		menu1.add(opcion1);
		menu1.add(opcion2);
		menu2.add(opcion3);
		menu2.add(opcion4);
		barra.add(menu1);
		barra.add(menu2);
		add(barra);
		add(carta);
		barra.setBounds(0,0,440,25);
		carta.setBounds(10,250,150,25);
		opcion1.addActionListener(this);
		opcion2.addActionListener(this);
		opcion3.addActionListener(this);
		opcion4.addActionListener(this);
		carta.addActionListener(this);
		carta.setEnabled(false);
		/*interfaz para crear hechizo o trampa*/
		if(data==1 || data==2){
			archivo = new JButton("PNG");
			label6 = new JLabel();
			JLabel label1 = new JLabel("Imagen:");
			add(archivo);
			add(label6);
			add(label1);
			archivo.setBounds(70,35,90,25);
			label6.setBounds(170,35,165,240);
			label1.setBounds(10,35,60,25);
			archivo.addActionListener(this);
			/*hechizo*/
			if(data==1){
				ImageIcon imgIcon = new ImageIcon(getClass().getResource("/pc/carta1.png"));
				Image imgEscalada = imgIcon.getImage().getScaledInstance(label6.getWidth(),label6.getHeight(), Image.SCALE_SMOOTH);
				Icon iconoEscalado = new ImageIcon(imgEscalada);
				label6.setIcon(iconoEscalado);
			}
			/*trampa*/
			if(data==2){
				ImageIcon imgIcon = new ImageIcon(getClass().getResource("/pc/carta2.png"));
				Image imgEscalada = imgIcon.getImage().getScaledInstance(label6.getWidth(),label6.getHeight(), Image.SCALE_SMOOTH);
				Icon iconoEscalado = new ImageIcon(imgEscalada);
				label6.setIcon(iconoEscalado);
			}
		}
		/*interfaz para crear cartas monstruos*/
		else{
			String[] itemstipos = new String[]{"Oscuridad","Tierra","Fuego","Luz","Agua","Viento"};
			tipo = new JComboBox(itemstipos);
			ATK = new JTextField(5);
			DEF = new JTextField(5);
			archivo = new JButton("PNG");
			label6 = new JLabel();
			JLabel label1 = new JLabel("Imagen:");
			JLabel label2 = new JLabel("Tipo:");
			JLabel label3 = new JLabel("Nivel:");
			JLabel label4 = new JLabel("ATK:");
			JLabel label5 = new JLabel("DEF:");
			JLabel img2 = new JLabel();
			JLabel img1 = new JLabel();
			ImageIcon image1 = new ImageIcon(getClass().getResource("/pc/tipos.png"));
			ImageIcon image2 = new ImageIcon(getClass().getResource("/pc/estrellas.png"));
			add(archivo);
			add(label6);
			add(label1);
			add(label2);
			add(label3);
			add(label4);
			add(label5);
			add(img1);
			add(img2);
			add(tipo);
			add(ATK);
			add(DEF);
			img1.setIcon(image1);
			img2.setIcon(image2);
			archivo.setBounds(70,35,90,25);
			label6.setBounds(170,35,165,240);
			label1.setBounds(10,35,60,25);
			label2.setBounds(10,70,60,25);
			label3.setBounds(10,145,60,25);
			label4.setBounds(10,180,60,25);
			label5.setBounds(10,215,60,25);
			img1.setBounds(15,105,145,25);
			img2.setBounds(135,145,25,25);
			tipo.setBounds(70,70,90,25);
			ATK.setBounds(70,180,90,25);
			DEF.setBounds(70,215,90,25);
			archivo.addActionListener(this);
			/*monstruo normal*/
			if(data==3){
				String[] itemsnivel = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
				nivel = new JComboBox(itemsnivel);
				ImageIcon imgIcon = new ImageIcon(getClass().getResource("/pc/carta3.png"));
				Image imgEscalada = imgIcon.getImage().getScaledInstance(label6.getWidth(),label6.getHeight(), Image.SCALE_SMOOTH);
				Icon iconoEscalado = new ImageIcon(imgEscalada);
				add(nivel);
				label6.setIcon(iconoEscalado);
				nivel.setBounds(70,145,60,25);
			}
			/*monstruo efecto*/
			if(data==4){
				String[] itemsnivel = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
				nivel = new JComboBox(itemsnivel);
				ImageIcon imgIcon = new ImageIcon(getClass().getResource("/pc/carta4.png"));
				Image imgEscalada = imgIcon.getImage().getScaledInstance(label6.getWidth(),label6.getHeight(), Image.SCALE_SMOOTH);
				Icon iconoEscalado = new ImageIcon(imgEscalada);
				add(nivel);
				label6.setIcon(iconoEscalado);
				nivel.setBounds(70,145,60,25);
			}
			/*monstruo fusion*/
			if(data==5){
				String[] itemsnivel = new String[]{"5", "6", "7", "8", "9", "10"};
				nivel = new JComboBox(itemsnivel);
				ImageIcon imgIcon = new ImageIcon(getClass().getResource("/pc/carta5.png"));
				Image imgEscalada = imgIcon.getImage().getScaledInstance(label6.getWidth(),label6.getHeight(), Image.SCALE_SMOOTH);
				Icon iconoEscalado = new ImageIcon(imgEscalada);
				add(nivel);
				label6.setIcon(iconoEscalado);
				nivel.setBounds(70,145,60,25);
			}
			halado=0;
		}
	}
	/*accionamiento de eventos*/
	public void actionPerformed(ActionEvent e){
		/*nuevo proyecto o nueva carta*/
		if(e.getSource()==opcion1){
			proyecto nuevopro = new proyecto();
			this.setVisible(false);
		}
		/*abrir imagen para aderir a la carta*/
		if(e.getSource()==archivo){
			try{
				JFileChooser selectordearchivo = new JFileChooser();
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("PNG & JPG","png","jpg");
				selectordearchivo.setFileFilter(filtro);
				int estado = selectordearchivo.showOpenDialog(this);
				if(estado==JFileChooser.APPROVE_OPTION){ 
					File file = selectordearchivo.getSelectedFile(); 
					foto = ImageIO.read(file); //variable global de la imagen a insertar en la carta
					carta.setEnabled(true); //debloqueamos boton para generar carta
					halado=1;
				}
			}catch(Exception a){JOptionPane.showMessageDialog(this,"ERROR","ERROR",0);}
		}
		/*crear carta*/
		if(e.getSource()==carta){
			try{
				/*invocamos la classe para crear una carta hechizo o trampa*/
				if(data==1 || data==2){
					orica carta_yugioh = new orica(data, foto);
					bufercarta = carta_yugioh.crear_orica(); //variable global de la carta generada por la class orica
					bufercartareverso = carta_yugioh.crear_orica_boca_abajo();//variable global de la carta boca abajo generada por la class orica
					/*finalmente mostramos la carta en el label6*/
					ImageIcon icono = new ImageIcon(bufercarta);
					Image ims = icono.getImage().getScaledInstance(label6.getWidth(),label6.getHeight(),Image.SCALE_SMOOTH); 
					Icon iconoEscalado = new ImageIcon(ims);
					label6.setIcon(iconoEscalado);
				}
				/*invocamos la classe para crear una carta monstruo*/
				else{
					int estrellitas = Integer.parseInt((String)this.nivel.getSelectedItem());
					int tipo_de_monstruo = tipo.getSelectedIndex()+1;
					int atacke = Integer.parseInt(this.ATK.getText());
					int defensa = Integer.parseInt(this.DEF.getText());
					if(atacke>=0 && atacke<=9999 && defensa>=0 && defensa<=9999){
						orica carta_yugioh = new orica(data, foto, estrellitas, tipo_de_monstruo, atacke, defensa);
						bufercarta = carta_yugioh.crear_orica(); //variable global de la carta generada por la class orica
						bufercartareverso = carta_yugioh.crear_orica_boca_abajo();//variable global de la carta boca abajo generada por la class orica
						/*finalmente mostramos la carta en el label6*/
						ImageIcon icono = new ImageIcon(bufercarta);
						Image ims = icono.getImage().getScaledInstance(label6.getWidth(),label6.getHeight(),Image.SCALE_SMOOTH); 
						Icon iconoEscalado = new ImageIcon(ims);
						label6.setIcon(iconoEscalado);
					}
					else{JOptionPane.showMessageDialog(this,"Introduzca datos validos","ADVERTENCIA",2);}
				}
			}catch(Exception a){JOptionPane.showMessageDialog(this,"Introduzca datos validos","ADVERTENCIA",2);}
		}
		/*generar archivo y guardar la carta como archivo de imagen*/        
		if(e.getSource()==opcion2){
			try{
				if(halado==1){
					JFileChooser selectordearchivo = new JFileChooser(); 
					FileNameExtensionFilter filtro=new FileNameExtensionFilter("*.PNG","png");
					selectordearchivo.setFileFilter(filtro); 
					int estado = selectordearchivo.showSaveDialog(this); 
					File file = selectordearchivo.getSelectedFile();
					if(estado==JFileChooser.APPROVE_OPTION){ 
						ImageIO.write(bufercarta, "PNG", new File(file+".png")); //guardamos la carta generada
						ImageIO.write(bufercartareverso, "PNG", new File(file.getParentFile()+File.separator+"reverso.png")); //guardamos la carta boca abajo generada
						JOptionPane.showMessageDialog(this,"Archivo Guardado","INFORMACION",1);
					}
				}
				else{
					JOptionPane.showMessageDialog(this,"Sin datos","ERROR",2);
				}
			}catch(Exception a){JOptionPane.showMessageDialog(this,"ERROR","ERROR",0);}
		}
		/*mostrar version*/
		if(e.getSource()==opcion3){
			JOptionPane.showMessageDialog(this,"Versio: 1.0","INFORMACION",1);
		}
		/*mostrar creador*/
		if(e.getSource()==opcion4){
			JOptionPane.showMessageDialog(this,"Creado por: R_A_V_R_","INFORMACION",1);
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
	/*metodo para crear la carta y retorna el bufer de la imagen*/
	public BufferedImage crear_orica(){ 
		try{
			int width = 570, height = 831;
			BufferedImage bufer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D grafico = bufer.createGraphics();
			/*generamos carta hechizo o trampa*/
			if(tipo_de_carta==1 || tipo_de_carta==2){
				/*generamos carta hechizo*/
				if(tipo_de_carta==1){
					Image fondo = ImageIO.read(getClass().getResource("/pc/carta1.png"));
					grafico.drawImage(fondo, 0, 0, null);
				}
				/*generamos carta trampa*/
				else if(tipo_de_carta==2){
					Image fondo = ImageIO.read(getClass().getResource("/pc/carta2.png"));
					grafico.drawImage(fondo, 0, 0, null);
				}
				grafico.drawImage(monstruo, 13, 14, 544, 582, null);
				/*retornamos el bufer de la imagen de la carta generada*/
				return bufer;
			}
			/*generamos carta monstruo*/
			else{
				/*generamos carta monstruo normal*/
				if(tipo_de_carta==3){
					Image fondo = ImageIO.read(getClass().getResource("/pc/carta3.png"));
					grafico.drawImage(fondo, 0, 0, null);
				}
				/*generamos carta monstruo efecto*/
				else if(tipo_de_carta==4){
					Image fondo = ImageIO.read(getClass().getResource("/pc/carta4.png"));
					grafico.drawImage(fondo, 0, 0, null);
				}
				/*generamos carta monstruo fusion*/
				else if(tipo_de_carta==5){
					Image fondo = ImageIO.read(getClass().getResource("/pc/carta5.png"));
					grafico.drawImage(fondo, 0, 0, null);
				}
				/*aderimos el monstruo*/
				grafico.drawImage(monstruo, 13, 14, 544, 582, null);
				/*aderimos las estrellas*/
				Image estrellas = ImageIO.read(getClass().getResource("/pc/carta"+tipo_de_carta+"nivel"+nivel+".png"));
				grafico.drawImage(estrellas, 0, 596, null);
				/*aderimos el tipo de monstruo*/
				Image img_tipo_de_monstruo = ImageIO.read(getClass().getResource("/pc/tipo"+tipo_de_monstruo+".png"));
				grafico.drawImage(img_tipo_de_monstruo, 463, 637, null);
				/*personalizamos tipo de letra*/
				InputStream is = this.getClass().getResourceAsStream("/pc/letra.ttf");
				Font helvetica = Font.createFont(Font.TRUETYPE_FONT, is);
				grafico.setFont(helvetica.deriveFont(80f));
				grafico.setPaint(Color.black);
				/*aderimos el atacke*/
				if(atacke>=0&&atacke<=99){grafico.drawString(atacke+"", 130, 774);}
				else if(atacke>=100&&atacke<=999){grafico.drawString(atacke+"", 100, 774);}
				else{grafico.drawString(atacke+"", 70, 774);}
				/*aderimos la defensa*/
				if(defensa>=0 && defensa<=99){grafico.drawString(defensa+"", 390, 774);}
				else if(defensa>=100 && defensa<=999){grafico.drawString(defensa+"", 360, 774);}
				else{grafico.drawString(defensa+"", 330, 774);}
				/*retornamos el bufer de la imagen de la carta generada*/
				return bufer;
			}
		}catch(Exception a){return null;}
	}
	/*metodo para crear el reverso de la carta y retornar el bufer de la imagen*/
	public BufferedImage crear_orica_boca_abajo(){ 
		try{
			int width = 441, height = 642;
			BufferedImage bufer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D grafico = bufer.createGraphics();
			Image carta = ImageIO.read(getClass().getResource("/pc/reverso.png"));
			grafico.drawImage(carta, 0, 0, null);
			return bufer;
		}catch(Exception a){return null;}
	}
}
