import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.Color;

public class RegisterForm {

	public static void main(String[] args) {
		final JFrame f = new JFrame("Registration Form");
		f.setSize(500, 1000);
		f.setLayout(null);
		f.getContentPane().setBackground(Color.orange);

		JLabel lblEnrl = new JLabel("Enrollment No. : ");
		lblEnrl.setBounds(50, 50, 150, 25);
		f.add(lblEnrl);

		final JTextField txtEnrl = new JTextField();
		txtEnrl.setBounds(170, 50, 250, 25);
		f.add(txtEnrl);

		JLabel lblRoll = new JLabel("Roll No. : ");
		lblRoll.setBounds(50, 90, 150, 25);
		f.add(lblRoll);

		final JTextField txtRoll = new JTextField();
		txtRoll.setBounds(170, 90, 250, 25);
		f.add(txtRoll);

		JLabel lblFnm = new JLabel("First Name : ");
		lblFnm.setBounds(50, 130, 150, 25);
		f.add(lblFnm);

		final JTextField txtFnm = new JTextField();
		txtFnm.setBounds(170, 130, 250, 25);
		f.add(txtFnm);

		JLabel lblMnm = new JLabel("Middle Name : ");
		lblMnm.setBounds(50, 170, 150, 25);
		f.add(lblMnm);

		final JTextField txtMnm = new JTextField();
		txtMnm.setBounds(170, 170, 250, 25);
		f.add(txtMnm);

		JLabel lblLnm = new JLabel("Last Name : ");
		lblLnm.setBounds(50, 210, 150, 25);
		f.add(lblLnm);

		final JTextField txtLmn = new JTextField();
		txtLmn.setBounds(170, 210, 250, 25);
		f.add(txtLmn);

		JLabel lblGen = new JLabel("Gender : ");
		lblGen.setBounds(50, 250, 150, 25);
		f.add(lblGen);

		final JRadioButton rbtnMale = new JRadioButton("Male");
		rbtnMale.setBounds(170, 250, 100, 25);
		f.add(rbtnMale);

		final JRadioButton rbtnFemale = new JRadioButton("Female");
		rbtnFemale.setBounds(290, 250, 100, 25);
		f.add(rbtnFemale);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rbtnMale);
		bg.add(rbtnFemale);

		JLabel lblDOB = new JLabel("Date of Birth : ");
		lblDOB.setBounds(50, 290, 150, 25);
		f.add(lblDOB);

		final JTextField txtDate = new JTextField();
		txtDate.setBounds(170, 290, 250, 25);
		f.add(txtDate);

		JLabel lblMobile = new JLabel("Mobile Number : ");
		lblMobile.setBounds(50, 330, 150, 25);
		f.add(lblMobile);

		final JTextField txtMobile = new JTextField();
		txtMobile.setBounds(170, 330, 250, 25);
		f.add(txtMobile);

		JLabel lblCity = new JLabel("City : ");
		lblCity.setBounds(50, 370, 150, 25);
		f.add(lblCity);

		String city[] = { "--SELECT--", "Rajkot", "Surat", "Surendranagar", "Ahemdabad" };

		final JComboBox<String> cmbCity = new JComboBox<String>(city);
		cmbCity.setBounds(170, 370, 250, 25);
		f.add(cmbCity);

		JLabel lblState = new JLabel("State : ");
		lblState.setBounds(50, 420, 150, 25);
		f.add(lblState);

		String state[] = { "--SELECT--", "Gujarat", "Maharastra", "UP", "Panjab", "Odisha" };

		final JComboBox<String> cmbState = new JComboBox<String>(state);
		cmbState.setBounds(170, 420, 250, 25);
		f.add(cmbState);

		JLabel lblCountry = new JLabel("Country : ");
		lblCountry.setBounds(50, 460, 150, 25);
		f.add(lblCountry);

		String country[] = { "--SELECT--", "India", "US", "Pakistan", "Shree Lanka", "England" };

		final JComboBox<String> cmbCountry = new JComboBox<String>(country);
		cmbCountry.setBounds(170, 460, 250, 25);
		f.add(cmbCountry);

		JLabel lblEmail = new JLabel("Email Address : ");
		lblEmail.setBounds(50, 500, 150, 25);
		f.add(lblEmail);

		final JTextField txtEmail = new JTextField();
		txtEmail.setBounds(170, 500, 250, 25);
		f.add(txtEmail);

		JLabel lblHobby = new JLabel("Hobby : ");
		lblHobby.setBounds(50, 540, 150, 25);
		f.add(lblHobby);

		final JCheckBox chkReading = new JCheckBox("Reading");
		chkReading.setBounds(170, 540, 80, 25);
		f.add(chkReading);

		final JCheckBox chkSport = new JCheckBox("Sport");
		chkSport.setBounds(260, 540, 60, 25);
		f.add(chkSport);

		final JCheckBox chkTravel = new JCheckBox("Travelling");
		chkTravel.setBounds(330, 540, 90, 25);
		f.add(chkTravel);

		JButton btnAdd = new JButton("Insert");
		btnAdd.setBounds(90, 580, 70, 25);
		f.add(btnAdd);

		JButton btnShow = new JButton("Show");
		btnShow.setBounds(180, 580, 70, 25);
		f.add(btnShow);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(270, 580, 80, 25);
		f.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(120, 620, 80, 25);
		f.add(btnDelete);

		JButton btnClear = new JButton("Reset");
		btnClear.setBounds(220, 620, 80, 25);
		f.add(btnClear);

		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String gn = "Male";
				String hb = "";
				if (rbtnFemale.isSelected()) {
					gn = "Female";
				}
				if (chkReading.isSelected()) {
					hb += "Reading ";
				}
				if (chkSport.isSelected()) {
					hb += "Sport ";
				}
				if (chkTravel.isSelected()) {
					hb += "Travelling ";
				}
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String connUrl = "jdbc:mysql://localhost:3307/jdbc_f1_demo?user=root";
					Connection conn = DriverManager.getConnection(connUrl);
					String sql = "insert into user values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement st = conn.prepareStatement(sql);
					st.setString(1, txtEnrl.getText());
					st.setString(2, txtRoll.getText());
					st.setString(3, txtFnm.getText());
					st.setString(4, txtMnm.getText());
					st.setString(5, txtLmn.getText());
					st.setString(6, gn);
					st.setString(7, txtDate.getText());
					st.setString(8, txtMobile.getText());
					st.setString(9, cmbCity.getSelectedItem().toString());
					st.setString(10, cmbState.getSelectedItem().toString());
					st.setString(11, cmbCountry.getSelectedItem().toString());
					st.setString(12, txtEmail.getText());
					st.setString(13, hb);

					int res = st.executeUpdate();
					if (res > 0) {
						JOptionPane.showMessageDialog(f, "record inserted...");
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}

			}
		});

		btnShow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// String column[]={"ID","NAME","SALARY"};
				String column[] = { "Enrollment", "Roll No", "First Name", "Middle Name", "Last Name", "Gender", "DOB",
						"Mobile", "City", "State", "Country", "Email", "Hobby" };
				String[][] data = new String[4][13];

				try {
					JFrame f2 = new JFrame();
					f2.setSize(1200, 500);
					f2.setVisible(true);

					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3307/jdbc_f1_demo?user=root";
					Connection con = DriverManager.getConnection(url);
					Statement stat = con.createStatement();
					ResultSet rs = stat.executeQuery("select * from user limit 0,10");
					int i = 0;
					while (rs.next()) {
						for (int j = 0; j < 13; j++) {
							// System.out.println("Enrollment : "+rs.getString(1));
							data[i][j] = rs.getString(j + 1);
						}
						// System.out.println();
						i = i + 1;
					}
					JTable table = new JTable(data, column);

					JScrollPane scroll = new JScrollPane(table);
					f2.add(scroll);
				} catch (Exception ex) {
					System.out.println(ex);
				}

			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String gn = "Male";
				String hb = "";
				if (rbtnFemale.isSelected()) {
					gn = "Female";
				}
				if (chkReading.isSelected()) {
					hb += "Reading ";
				}
				if (chkSport.isSelected()) {
					hb += "Sport ";
				}
				if (chkTravel.isSelected()) {
					hb += "Travelling ";
				}
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String connUrl = "jdbc:mysql://localhost:3307/jdbc_f1_demo?user=root";
					Connection conn = DriverManager.getConnection(connUrl);

					String sql = "update user set RollNo=?, Fname=?, Mname=?, Lname=?, Gender=?, DOB=?, Mobile=?, City=?, State=?, Country=?, Email=?, Hobby=? where Enrollment=?";
					PreparedStatement st = conn.prepareStatement(sql);
					st.setString(1, txtRoll.getText());
					st.setString(2, txtFnm.getText());
					st.setString(3, txtMnm.getText());
					st.setString(4, txtLmn.getText());
					st.setString(5, gn);
					st.setString(6, txtDate.getText());
					st.setString(7, txtMobile.getText());
					st.setString(8, cmbCity.getSelectedItem().toString());
					st.setString(9, cmbState.getSelectedItem().toString());
					st.setString(10, cmbCountry.getSelectedItem().toString());
					st.setString(11, txtEmail.getText());
					st.setString(12, hb);
					st.setString(13, txtEnrl.getText());

					int res = st.executeUpdate();
					if (res > 0) {
						JOptionPane.showMessageDialog(f, "record updated...");
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}

			}
		});

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String dbconn = "jdbc:mysql://localhost:3307/jdbc_f1_demo?user=root";
					Connection conn = DriverManager.getConnection(dbconn);
					String sql = "Delete from user where Enrollment=?";
					PreparedStatement st = conn.prepareStatement(sql);
					st.setString(1, txtEnrl.getText());
					if (st.executeUpdate() > 0) {
						JOptionPane.showMessageDialog(f, "Record deleted...");
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});

		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtEnrl.setText("");
				txtRoll.setText("");
				txtFnm.setText("");
				txtMnm.setText("");
				txtLmn.setText("");
				txtDate.setText("");
				txtEmail.setText("");
				txtMobile.setText("");
				rbtnMale.setSelected(false);
				rbtnFemale.setSelected(false);
				cmbCity.setSelectedIndex(0);
				cmbState.setSelectedIndex(0);
				cmbCountry.setSelectedIndex(0);
				chkReading.setSelected(false);
				chkSport.setSelected(false);
				chkTravel.setSelected(false);
			}
		});

		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}