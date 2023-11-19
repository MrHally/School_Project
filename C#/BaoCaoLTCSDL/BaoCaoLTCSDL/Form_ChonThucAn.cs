using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Microsoft.VisualBasic;

namespace BaoCaoLTCSDL
{
    public partial class Form_ChonThucAn : Form
    {
        string kn = @"Data Source=Dell_Anhson\SQLEXPRESS;Initial Catalog=CSDLFASTFOOD;Integrated Security=True";
        public int idThucAn { get; set; }
        public int soLuong {  get; set; }
        public string idhoadon;
        public Form_ChonThucAn(string idHoaDon)
        {
            InitializeComponent();
            idhoadon = idHoaDon;
            loadDanhMuc();
            loadData();
        }

        public void loadData()
        {
            using (SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("Select idThucAn, tenThucAn, giaThucAn From ThucAn", con);
                    using (SqlDataReader reader = cmd.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            string name = reader["tenThucAn"].ToString();
                            string gia = reader["giaThucAn"].ToString();
                            int id = Convert.ToInt32(reader["idThucAn"]);
                            double giaFormatted = Convert.ToDouble(gia);

                            Button button = new Button
                            {
                                Text = $"{name} \n {giaFormatted.ToString("N0")} đ",
                                Tag = id,
                            };
                            button.Font = new Font("Corbel", 12);
                            button.BackColor = Color.Orange;
                            button.Size = new System.Drawing.Size(250, 150);
                            button.Click += bt_themgiohang;

                            fpl_monan.Controls.Add(button);
                        }
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message + "Dòng 62");
                }
            }
        }

        public void loadDanhMuc()
        {
            using (SqlConnection conn = new SqlConnection(kn))
            {
                try
                {
                    conn.Open();
                    SqlCommand cmd = new SqlCommand("Select * From DanhMuc", conn);
                    using (SqlDataReader reader = cmd.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            string name = reader["tenDanhMuc"].ToString();
                            int id = Convert.ToInt32(reader["idDanhMuc"]);

                            Button button = new Button
                            {
                                Text = name,
                                Tag = id,
                            };
                            button.Size = new System.Drawing.Size(60, 80);
                            button.Font = new Font("Corbel", 12);
                            button.BackColor = Color.Orange;
                            button.AutoSize = true;


                            button.Click += Button_Click;

                            fpl_danhmuc.Controls.Add(button);
                        }
                    }
                    conn.Close();
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message + "Dòng 102");
                }
            }
        }

        private void Button_Click(object sender, EventArgs e)
        {
            Button click = (Button)sender;
            int id = (int)click.Tag;
            fpl_monan.Controls.Clear();
            loadThucAnTheoDanhMuc(id.ToString());
        }
        public void loadThucAnTheoDanhMuc(string idDanhMuc)
        {
            using (SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("Select idThucAn, tenThucAn, giaThucAn From ThucAn Where idDanhMuc = @id", con);
                    cmd.Parameters.AddWithValue("id", idDanhMuc);
                    using (SqlDataReader reader = cmd.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            string name = reader["tenThucAn"].ToString();
                            string gia = reader["giaThucAn"].ToString();
                            int id = Convert.ToInt32(reader["idThucAn"]);
                            double giaFormatted = Convert.ToDouble(gia);

                            Button button = new Button
                            {
                                Text = $"{name} \n {giaFormatted.ToString("N0")} đ",
                                Tag = id,
                            };
                            button.Font = new Font("Corbel", 12);
                            button.BackColor = Color.Orange;
                            button.Size = new System.Drawing.Size(250, 150);
                            button.Click += bt_themgiohang;


                            fpl_monan.Controls.Add(button);
                        }
                    }
                    con.Close();
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message + " Dòng 150");
                }
            }
        }

        private void bt_themgiohang(object sender, EventArgs e)
        {
            Button click = (Button)sender;
            int id = (int)click.Tag;
            using (F_Nhapsoluong inputDialog = new F_Nhapsoluong())
            {
                if (inputDialog.ShowDialog() == DialogResult.OK)
                {
                    soLuong = Convert.ToInt32(inputDialog.UserInput);
                    idThucAn = id;
                    UC_Hoadon hd = new UC_Hoadon(idhoadon);
                    hd.addMonAn(id, soLuong);
                    Close();
                }
            }
        }

        private void fpl_monan_Paint(object sender, PaintEventArgs e)
        {

        }
    }
}
