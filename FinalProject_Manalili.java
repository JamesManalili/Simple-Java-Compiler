package FinalProject;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Font;
import java.awt.SystemColor;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class FinalProject_Manalili extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String out = "";
	private String pass = "";
	private String valOfAll = "";
	public JFrame frame;
	private JLabel lblResult;
	private JButton btnOpenFile;
	private JButton btnSyntax;
	private JButton btnClear;
	private JButton btnSemantic;
	private JLabel lblValue;
	private JButton btnLexical;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public FinalProject_Manalili() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setTitle("Mini Java Compiler");
		frame.setBounds(400, 100, 613, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblResult = new JLabel();
		lblResult.setBorder(UIManager.getBorder("TextField.border"));
		lblResult.setBackground(Color.WHITE);
		lblResult.setOpaque(true);
		lblResult.setHorizontalAlignment(SwingConstants.LEFT);
		lblResult.setText("   Result: ");
		lblResult.setFont(new Font("Arial", Font.BOLD, 12));
		lblResult.setBounds(190, 21, 388, 37);
		frame.getContentPane().add(lblResult);

		btnOpenFile = new JButton("Open File");
		btnOpenFile.setIcon(new ImageIcon(FinalProject_Manalili.class.getResource("/FinalProject/icons8-open-folder-16.png")));
		btnOpenFile.setDefaultCapable(false);
		btnOpenFile.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnOpenFile.setHideActionText(true);
		btnOpenFile.setFocusPainted(false);
		btnOpenFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblValue.getText().equals("")) {
					openFile();
					if (!lblValue.getText().equals("")) {
						btnLexical.setEnabled(true);
						btnOpenFile.setEnabled(false);
					}
				}
			}
		});
		btnOpenFile.setFont(new Font("Arial", Font.BOLD, 12));
		btnOpenFile.setBackground(SystemColor.textHighlightText);
		btnOpenFile.setBounds(10, 21, 168, 37);
		frame.getContentPane().add(btnOpenFile);

		btnLexical = new JButton("Lexical Analysis");
		btnLexical.setHorizontalAlignment(SwingConstants.LEFT);
		btnLexical.setIcon(new ImageIcon(FinalProject_Manalili.class.getResource("/FinalProject/icons8-right-arrow-16.png")));
		btnLexical.setEnabled(false);
		btnLexical.setFocusPainted(false);
		btnLexical.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LexicalAnalysis();
			}
		});
		btnLexical.setFont(new Font("Arial", Font.BOLD, 12));
		btnLexical.setBackground(SystemColor.textHighlightText);
		btnLexical.setBounds(10, 69, 168, 37);
		frame.getContentPane().add(btnLexical);

		btnSyntax = new JButton("Syntax Analysis");
		btnSyntax.setHorizontalAlignment(SwingConstants.LEFT);
		btnSyntax.setIcon(new ImageIcon(FinalProject_Manalili.class.getResource("/FinalProject/icons8-right-arrow-16.png")));
		btnSyntax.setEnabled(false);
		btnSyntax.setFocusPainted(false);
		btnSyntax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SyntaxAnalysis(out, pass);
			}
		});
		btnSyntax.setFont(new Font("Arial", Font.BOLD, 12));
		btnSyntax.setBackground(SystemColor.textHighlightText);
		btnSyntax.setBounds(10, 117, 168, 37);
		frame.getContentPane().add(btnSyntax);

		btnClear = new JButton("Clear");
		btnClear.setIcon(new ImageIcon(FinalProject_Manalili.class.getResource("/FinalProject/icons8-clear-16.png")));
		btnClear.setFocusPainted(false);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblResult.setText("   Result: ");
				lblValue.setText("");
				btnOpenFile.setEnabled(true);
				btnSyntax.setEnabled(false);
				btnSemantic.setEnabled(false);
				btnLexical.setEnabled(false);
				lblResult.setForeground(Color.BLACK);
			}
		});
		btnClear.setFont(new Font("Arial", Font.BOLD, 12));
		btnClear.setBackground(SystemColor.textHighlightText);
		btnClear.setBounds(10, 213, 168, 37);
		frame.getContentPane().add(btnClear);

		btnSemantic = new JButton("Semantic Analysis");
		btnSemantic.setHorizontalAlignment(SwingConstants.LEFT);
		btnSemantic.setIcon(new ImageIcon(FinalProject_Manalili.class.getResource("/FinalProject/icons8-right-arrow-16.png")));
		btnSemantic.setEnabled(false);
		btnSemantic.setFocusPainted(false);
		btnSemantic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SemanticAnalysis(valOfAll);
			}
		});
		btnSemantic.setFont(new Font("Arial", Font.BOLD, 12));
		btnSemantic.setBackground(SystemColor.textHighlightText);
		btnSemantic.setBounds(10, 165, 168, 37);
		frame.getContentPane().add(btnSemantic);

		lblValue = new JLabel("");
		lblValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblValue.setVerticalAlignment(SwingConstants.TOP);
		lblValue.setFont(new Font("Arial", Font.PLAIN, 12));
		lblValue.setHorizontalTextPosition(SwingConstants.LEFT);
		lblValue.setVerticalTextPosition(SwingConstants.TOP);
		lblValue.setBorder(UIManager.getBorder("TextField.border"));
		lblValue.setOpaque(true);
		lblValue.setBackground(Color.WHITE);
		lblValue.setBounds(190, 69, 388, 181);
		frame.getContentPane().add(lblValue);
	}

	public void LexicalAnalysis() {
		boolean LexicalisValid = true;
		String input = valOfAll;
		pass = input;
		input = input.replaceAll("([=,;])", " $1 ");
		String[] tokens = input.split("\\s+");
		for (String token : tokens) {
			if (token.matches("int|double|char|String|boolean|float|byte|long|short")) {
				out += "<data_type>";
			} else if (token.equals("=")) {
				out += "<assignment_operator>";
			} else if (token.equals(";")) {
				out += "<delimiter> ";
			} else if (token.matches("[-+]?\\d*\\.?\\d+(f|F)?|\"[^\"]*\"|'[^']*'|true|false")) {
				out += "<value>";
			} else if (token.matches("^[^\\d].*") && token.matches("^[^\\W_][\\w]*$")) {
				out += "<identifier>";
			} else {
				LexicalisValid = false;
				break;
			}
		}
		if (LexicalisValid) {
			lblResult.setText(lblResult.getText() + "Lexical analysis phase passed.");
			btnLexical.setEnabled(false);
			btnSyntax.setEnabled(true);
			// SyntaxAnalysis(out,pass);
		} else {
			lblResult.setForeground(Color.RED);
			lblResult.setText(lblResult.getText() + "Lexical analysis phase failed.");
			btnOpenFile.setEnabled(false);
			btnSyntax.setEnabled(false);
			btnSemantic.setEnabled(false);
			btnLexical.setEnabled(false);
		}
	}

	public void SyntaxAnalysis(String out, String pass) {
		// Syntax analysis
		String pattern = "<data_type><identifier><assignment_operator><value><delimiter>";
		boolean isValid = true;
		String[] words = out.split("\\s+");
		for (int i = 0; i < words.length; i++) {
			if (!words[i].equals(pattern)) {
				isValid = false;
				break;
			} else {
				isValid = true;
			}
		}
		if (isValid) {
			lblResult.setText("   Result: Syntax analysis phase passed.");
			btnSyntax.setEnabled(false);
			btnSemantic.setEnabled(true);
		} else {
			lblResult.setForeground(Color.RED);
			lblResult.setText("   Result: Syntax analysis phase failed.");
			btnOpenFile.setEnabled(false);
			btnSyntax.setEnabled(false);
			btnSemantic.setEnabled(false);
			btnLexical.setEnabled(false);
		}
	}

	public void SemanticAnalysis(String input) {
		boolean isValidSemantic = true;
		String[] declarations = input.split(";");

		for (String declaration : declarations) {
			// Trim leading and trailing spaces
			declaration = declaration.trim();

			// Split the declaration into tokens
			String[] tokens = declaration.split("\\s+");

			// Check if there are enough tokens for a valid declaration
			if (tokens.length >= 3) {
				String dataType = tokens[0];
				String value = tokens[3]; // Assuming the value is always at index 3
				// Perform semantic analysis
				if (isValidDataType(dataType) && isValidValue(dataType, value)) {
					isValidSemantic = true;
				} else {
					isValidSemantic = false;
					break;
				}
			}
		}
		if (isValidSemantic) {
			lblResult.setText("   Result: Semantic analysis phase passed.");
			btnOpenFile.setEnabled(false);
			btnSemantic.setEnabled(false);
		} else {
			lblResult.setForeground(Color.RED);
			lblResult.setText("   Result: Semantic analysis phase failed.");
			btnOpenFile.setEnabled(false);
			btnSyntax.setEnabled(false);
			btnSemantic.setEnabled(false);
			btnLexical.setEnabled(false);
		}
	}

	private boolean isValidDataType(String dataType) {
		// Check if the data type is one of the valid primitive types or String
		return dataType.equals("int") || dataType.equals("double") || dataType.equals("float")
				|| dataType.equals("char") || dataType.equals("boolean") || dataType.equals("String");
	}

	private boolean isValidValue(String dataType, String value) {
		// Perform additional checks based on the data type and value
		try {
			switch (dataType) {
			case "int":
				Integer.parseInt(value);
				break;
			case "double":
				Double.parseDouble(value);
				break;
			case "float":
				Float.parseFloat(value);
				break;
			case "char":
				if (value.length() == 3 && value.startsWith("'") && value.endsWith("'")) {
					// Valid char literal
					return true;
				}
				return false;
			case "boolean":
				if (value.equals("true") || value.equals("false")) {
					// Valid boolean literal
					return true;
				}
				return false;
			case "String":
				if (value.startsWith("\"") && value.endsWith("\"")) {
					return true;
				}
			default:
				return false;
			}
		} catch (NumberFormatException e) {
			return false; // Number format exception indicates an invalid value for numeric types
		}

		return true;
	}

	private void openFile() {
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			displayFileInfo(selectedFile);
		}
	}

	private void displayFileInfo(File file) {
		StringBuilder info = new StringBuilder();
		StringBuilder info2 = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				info.append(line.trim()).append(" ");
				info2.append(line).append("<br>  ");
			}
		} catch (IOException e) {
			e.printStackTrace();
			info.append("Error reading file: ").append(e.getMessage());
		}
		lblValue.setText("<html><pre>  " + info2.toString() + "</pre></html>");
		valOfAll = info.toString();
	}
}
