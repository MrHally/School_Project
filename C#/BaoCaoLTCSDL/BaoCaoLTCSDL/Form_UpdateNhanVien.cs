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

namespace BaoCaoLTCSDL
{
    public partial class Form_UpdateNhanVien : Form
    {
        string kn = @"Data Source=Dell_Anhson\SQLEXPRESS;Initial Catalog=CSDLFASTFOOD;Integrated Security=True";
        public Form_UpdateNhanVien(string idNV)
        {
            InitializeComponent();
            loadNV(idNV);
        }

        public void loadNV(string idNV)
        {
            using(SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("Select tenDangNhap, tenNhanVien from NhanVien where tenDangNhap = @id", con);
                    cmd.Parameters.AddWithValue("@id", idNV);
                    using (SqlDataReader reader = cmd.ExecuteReader())
                    {
                        if (reader.Read())
                        {
                            textBox1.Text = reader["tenDangNhap"].ToString();
                            textBox2.Text = reader["tenNhanVien"].ToString();
                        }
                    }
                    con.Close();
                }
                catch(Exception ex) {
                    MessageBox.Show(ex.Message + " Dòng 43", "Hệ Thống");
                }
            }
        }

        public void chinhsua(string id, string hoten)
        {
            using(SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("Update NhanVien set tenNhanVien = @name Where tenDangNhap = @id", con);
                    cmd.Parameters.AddWithValue("@name", hoten);
                    cmd.Parameters.AddWithValue("@id", id);
                    cmd.ExecuteNonQuery();
                    con.Close();
                }
                catch(Exception ex)
                {
                    MessageBox.Show(ex.Message + " Dòng 63", "Hệ Thống");
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            chinhsua(textBox1.Text, textBox2.Text);
            Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
