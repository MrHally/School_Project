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
    public partial class Form_ResetMK : Form
    {
        string kn = @"Data Source=Dell_Anhson\SQLEXPRESS;Initial Catalog=CSDLFASTFOOD;Integrated Security=True";
        private string id { get; set; }
        public Form_ResetMK(string idNV)
        {
            InitializeComponent();
            textBox1.Text = idNV;
            id = idNV;
        }

        public bool checkMKCu(string mk)
        {
            Boolean check = false;
            using(SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("Select matkhauNhanVien From NhanVien Where tenDangNhap = @id", con);
                    cmd.Parameters.AddWithValue("@id", id);
                    using (SqlDataReader reader = cmd.ExecuteReader())
                    {
                        if(reader.Read())
                        {
                            string matkhau = reader["matkhauNhanVien"].ToString();
                            if (matkhau.Equals(mk))
                            {
                                check = true;
                            }
                            else
                            {
                                check = false;
                            }
                        }
                    }
                    con.Close();
                    return check;
                }
                catch(Exception ex) {
                    MessageBox.Show(ex.Message + " Dòng 54", "Hệ Thống");
                    return false;
                }
            }
        }

        public void caidat(string mk)
        {
            using(SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("Update NhanVien Set matkhauNhanVien = @mk Where tenDangNhap = @id", con);
                    cmd.Parameters.AddWithValue("@mk", mk);
                    cmd.Parameters.AddWithValue("@id", id);
                    cmd.ExecuteNonQuery();
                    con.Close();
                }
                catch(Exception ex)
                {
                    MessageBox.Show(ex.Message + " Dòng 75", "Hệ Thống");
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if( !txt_mkcu.Text.Equals("") || !txt_mkmoi.Text.Equals(""))
            {
                string mkcu = txt_mkcu.Text;
                string mkmoi = txt_mkmoi.Text;
                string mkcheck = txt_check.Text;
                if (checkMKCu(mkcu))
                {
                    if (mkmoi.Equals(mkcheck))
                    {
                        caidat(mkmoi);
                        MessageBox.Show("Cài Đặt Thành Công", "Hệ Thống");
                        Close();
                    }
                    else
                    {
                        MessageBox.Show("Mật khẩu mới nhập lại không chính xác! Vui lòng kiểm tra lại", "Hệ Thống");
                    }
                }
                else
                {
                    MessageBox.Show("Mật khẩu cũ không đúng! Vui lòng thử lại", "Hệ Thống");
                }
            }
            else
            {
                MessageBox.Show("Vui lòng nhập mật khẩu", "Hệ Thống");
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
