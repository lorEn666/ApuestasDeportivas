package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JPanel panelApuesta;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblEquipos;
	private JLabel lblEquipoLocal;
	private JLabel lblEquipoVisitante;
	private JComboBox textEquipoLocal;
	private JComboBox textEquipoVisitante;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JLabel lblApuestas;
	private JLabel lblNombre;
	private JLabel lblApuesta;
	private JTextField textNombre;
	private JSeparator separator_4;
	private JComboBox comboBoxLocal;
	private JComboBox comboBoxVisitante;
	private JCheckBox chckbxPagado;
	private JButton btnAnadirApostante;
	private JLabel lblResultado;
	private JSeparator separator_5;
	private JLabel lblResultadoLocal;
	private JLabel lblResultadoVisitante;
	private JTextArea textAreaApostantes;
	private JLabel lblPartido;
	private JMenuBar menuBarra;
	private JMenu mnPrograma;
	private JMenuItem mntmSalir;
	private ArrayList<Apostante> vApostante;
	private JButton btnComprobar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Apuestas");
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 496);

		menuBarra = new JMenuBar();
		setJMenuBar(menuBarra);

		mnPrograma = new JMenu("Programa");
		mnPrograma.setHorizontalAlignment(SwingConstants.CENTER);
		menuBarra.add(mnPrograma);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new MntmSalirActionListener());
		mntmSalir.setHorizontalAlignment(SwingConstants.CENTER);
		mnPrograma.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelApuesta = new JPanel();
		panelApuesta.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelApuesta.setBounds(10, 11, 350, 412);
		contentPane.add(panelApuesta);
		panelApuesta.setLayout(null);

		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		separator.setBounds(10, 48, 330, 2);
		panelApuesta.add(separator);

		lblEquipos = new JLabel("Equipos:");
		lblEquipos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEquipos.setBounds(10, 11, 109, 26);
		panelApuesta.add(lblEquipos);

		lblEquipoLocal = new JLabel("Equipo local:");
		lblEquipoLocal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEquipoLocal.setBounds(10, 66, 109, 20);
		panelApuesta.add(lblEquipoLocal);

		lblEquipoVisitante = new JLabel("Equipo visitante:");
		lblEquipoVisitante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEquipoVisitante.setBounds(10, 97, 109, 20);
		panelApuesta.add(lblEquipoVisitante);

		textEquipoLocal = new JComboBox();
		textEquipoLocal.setInheritsPopupMenu(true);
		textEquipoLocal.addItemListener(new TextEquipoLocalItemListener());
		textEquipoLocal.setBackground(Color.WHITE);
		textEquipoLocal.setModel(new DefaultComboBoxModel(
				new String[] { "ALAV\u00C9S", "ATHLETIC", "ATL\u00C9TICO", "BARCELONA", "CELTA", "EIBAR", "ESPANYOL",
						"GETAFE", "GRANADA", "LEGAN\u00C9S", "LEVANTE", "MALLORCA", "OSASUNA", "REAL BETIS",
						"REAL MADRID", "REAL SOCIEDAD", "REAL VALLADOLID", "SEVILLA", "VALENCIA CF", "VILLARREAL" }));
		textEquipoLocal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textEquipoLocal.setBounds(129, 68, 211, 20);
		panelApuesta.add(textEquipoLocal);

		textEquipoVisitante = new JComboBox();
		textEquipoVisitante.addItemListener(new TextEquipoVisitanteItemListener());
		textEquipoVisitante.setBackground(Color.WHITE);
		textEquipoVisitante.setModel(new DefaultComboBoxModel(
				new String[] { "ALAV\u00C9S", "ATHLETIC", "ATL\u00C9TICO", "BARCELONA", "CELTA", "EIBAR", "ESPANYOL",
						"GETAFE", "GRANADA", "LEGAN\u00C9S", "LEVANTE", "MALLORCA", "OSASUNA", "REAL BETIS",
						"REAL MADRID", "REAL SOCIEDAD", "REAL VALLADOLID", "SEVILLA", "VALENCIA CF", "VILLARREAL" }));
		textEquipoVisitante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textEquipoVisitante.setBounds(129, 99, 211, 20);
		panelApuesta.add(textEquipoVisitante);

		separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		separator_2.setBounds(10, 134, 330, 2);
		panelApuesta.add(separator_2);

		separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		separator_3.setBounds(10, 186, 330, 2);
		panelApuesta.add(separator_3);

		lblApuestas = new JLabel("Apuestas:");
		lblApuestas.setHorizontalAlignment(SwingConstants.CENTER);
		lblApuestas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApuestas.setBounds(10, 147, 109, 26);
		panelApuesta.add(lblApuestas);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(10, 199, 109, 20);
		panelApuesta.add(lblNombre);

		lblApuesta = new JLabel("Apuesta:");
		lblApuesta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApuesta.setBounds(10, 235, 109, 20);
		panelApuesta.add(lblApuesta);

		textNombre = new JTextField();
		textNombre.addKeyListener(new TextNombreKeyListener());
		textNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNombre.setColumns(10);
		textNombre.setBounds(129, 201, 211, 20);
		panelApuesta.add(textNombre);

		separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBounds(223, 245, 21, 2);
		panelApuesta.add(separator_4);

		comboBoxLocal = new JComboBox();
		comboBoxLocal.setModel(new DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5" }));
		comboBoxLocal.setBackground(Color.WHITE);
		comboBoxLocal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxLocal.setBounds(155, 232, 50, 26);
		panelApuesta.add(comboBoxLocal);

		comboBoxVisitante = new JComboBox();
		comboBoxVisitante.setModel(new DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5" }));
		comboBoxVisitante.setBackground(Color.WHITE);
		comboBoxVisitante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxVisitante.setBounds(261, 232, 50, 26);
		panelApuesta.add(comboBoxVisitante);

		chckbxPagado = new JCheckBox("Pagado");
		chckbxPagado.addItemListener(new ChckbxPagadoItemListener());
		chckbxPagado.setFocusPainted(false);
		chckbxPagado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxPagado.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxPagado.setBounds(121, 294, 97, 23);
		panelApuesta.add(chckbxPagado);

		btnAnadirApostante = new JButton("A\u00F1adir apostante");
		btnAnadirApostante.addMouseListener(new BtnAnadirApostanteMouseListener());
		btnAnadirApostante.setFocusPainted(false);
		btnAnadirApostante.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAnadirApostante.setBounds(99, 353, 145, 23);
		panelApuesta.add(btnAnadirApostante);

		separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		separator_1.setBounds(370, 59, 334, 2);
		contentPane.add(separator_1);

		lblResultado = new JLabel("Resultado:");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResultado.setBounds(473, 92, 131, 21);
		contentPane.add(lblResultado);

		separator_5 = new JSeparator();
		separator_5.setForeground(Color.BLACK);
		separator_5.setBounds(526, 145, 21, 2);
		contentPane.add(separator_5);

		lblResultadoLocal = new JLabel("");
		lblResultadoLocal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblResultadoLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultadoLocal.setBounds(439, 124, 40, 39);
		contentPane.add(lblResultadoLocal);

		lblResultadoVisitante = new JLabel("");
		lblResultadoVisitante.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultadoVisitante.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblResultadoVisitante.setBounds(588, 124, 40, 39);
		contentPane.add(lblResultadoVisitante);

		textAreaApostantes = new JTextArea();
		textAreaApostantes.setEditable(false);
		textAreaApostantes.setCaretColor(Color.BLACK);
		textAreaApostantes.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, null));
		textAreaApostantes.setBounds(370, 205, 342, 218);
		contentPane.add(textAreaApostantes);

		lblPartido = new JLabel("");
		lblPartido.setHorizontalAlignment(SwingConstants.CENTER);
		lblPartido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPartido.setBounds(405, 20, 264, 28);
		contentPane.add(lblPartido);

		vApostante = new ArrayList<Apostante>();

		textNombre.setEditable(false);
		comboBoxLocal.setEnabled(false);
		comboBoxVisitante.setEnabled(false);
		chckbxPagado.setEnabled(false);
		btnAnadirApostante.setEnabled(false);

		btnComprobar = new JButton("Comprobar apuestas");
		btnComprobar.addMouseListener(new BtnComprobarMouseListener());
		btnComprobar.setFocusPainted(false);
		btnComprobar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnComprobar.setBounds(449, 171, 179, 23);
		contentPane.add(btnComprobar);
		btnComprobar.setEnabled(false);
	}

	private void compruebaElementosDiferentesComboBox() {
		if (textEquipoLocal.getSelectedItem() == textEquipoVisitante.getSelectedItem()) {
			textNombre.setEditable(false);
			lblPartido.setText("");
		} else {
			textNombre.setEditable(true);
			lblPartido.setText(textEquipoLocal.getSelectedItem() + "   -   " + textEquipoVisitante.getSelectedItem());
		}
	}

	private class TextEquipoLocalItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			compruebaElementosDiferentesComboBox();
		}
	}

	private class TextEquipoVisitanteItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			compruebaElementosDiferentesComboBox();
		}
	}

	private class TextNombreKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			if (!textNombre.getText().isEmpty()) {
				textEquipoLocal.setEnabled(false);
				textEquipoVisitante.setEnabled(false);
				comboBoxLocal.setEnabled(true);
				comboBoxVisitante.setEnabled(true);
				chckbxPagado.setEnabled(true);
			} else {
				textEquipoLocal.setEnabled(true);
				textEquipoVisitante.setEnabled(true);
				comboBoxLocal.setEnabled(false);
				comboBoxVisitante.setEnabled(false);
				chckbxPagado.setEnabled(false);
				chckbxPagado.setSelected(false);
			}
		}
	}

	private class ChckbxPagadoItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (chckbxPagado.isSelected()) {
				btnAnadirApostante.setEnabled(true);
			} else {
				btnAnadirApostante.setEnabled(false);
			}
		}
	}

	private void actualizarTextArea() {
		String linea = "";
		for (Iterator iterator = vApostante.iterator(); iterator.hasNext();) {
			linea += iterator.next().toString();
		}
		textAreaApostantes.setText(linea);
	}

	private class BtnAnadirApostanteMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (btnAnadirApostante.isEnabled()) {
				for (Iterator<Apostante> iterator = vApostante.iterator(); iterator.hasNext();) {
					if (iterator.next().getNombre().equals(textNombre.getText())) {
						JOptionPane.showMessageDialog(rootPane, "Sólo puede realizar una apuesta por persona", "Error",
								2);
						return;
					}

				}
				vApostante.add(new Apostante(textNombre.getText(), lblPartido.getText(),
						(int) Integer.valueOf((String) comboBoxLocal.getSelectedItem()),
						Integer.valueOf((String) comboBoxVisitante.getSelectedItem())));
				actualizarTextArea();

				textNombre.setText("");
				comboBoxLocal.setSelectedIndex(0);
				comboBoxVisitante.setSelectedIndex(0);
				comboBoxLocal.setEnabled(false);
				comboBoxVisitante.setEnabled(false);
				chckbxPagado.setSelected(false);
				chckbxPagado.setEnabled(false);
				textEquipoLocal.setEnabled(true);
				textEquipoVisitante.setEnabled(true);
				btnComprobar.setEnabled(true);
				textNombre.requestFocus();
			}
		}
	}

	private class BtnComprobarMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (btnComprobar.isEnabled()) {
				Random resultado = new Random();
				lblResultadoLocal.setText(String.valueOf(resultado.nextInt(6)));
				lblResultadoVisitante.setText(String.valueOf(resultado.nextInt(6)));
				actualizaTextAreaGanadores();
			}
		}
	}
	private class MntmSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	private void actualizaTextAreaGanadores() {
		String linea = "";
		Apostante posicion = null;
		for (Iterator<Apostante> iterator = vApostante.iterator(); iterator.hasNext();) {
			posicion = iterator.next();
			if (posicion.getPartido().equals(lblPartido.getText())
					&& String.valueOf(posicion.getResultadoLocal()).equals(lblResultadoLocal.getText()) && String
							.valueOf(posicion.getResultadoVisitante()).equals(lblResultadoVisitante.getText())) {
				linea += "¡" + posicion.getNombre() + " ha ganado!\n";
			}
		}
		if (!linea.isEmpty()) {
			JOptionPane.showMessageDialog(panelApuesta, linea);
		}
	}
}
