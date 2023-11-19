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
    public partial class Form_Signin : Form
    {
        string kn = @"Data Source=Dell_Anhson\SQLEXPRESS;Initial Catalog=CSDLFASTFOOD;Integrated Security=True";
        public bool dangnhap = false;
        public string tinhtrang = "";
        private Form1 parentForm;
        public Form_Signin(Form1 parentForm)
        {
            InitializeComponent();
            this.parentForm = parentForm;
        }

        public bool ktraNV(string user, string pass)
        {
            using (SqlConnection con = new SqlConnection(kn))
            {
                Boolean kiemtra = false;
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("Select tenDangNhap From NhanVien Where tenDangNhap = @user and matKhauNhanVien = @pass", con);
                    cmd.Parameters.AddWithValue("@user", user);
                    cmd.Parameters.AddWithValue("@pass", pass);
                    using(SqlDataReader reader = cmd.ExecuteReader())
                    {
                        if (reader.Read())
                        {
                            string Username = reader["tenDangNhap"].ToString();
                            reader.Close();
                            if(Username.ToLower() == "admin")
                            {
                                tinhtrang = "admin";
                            }
                            else
                            {
                                tinhtrang = "nhanvien";
                            }
                            kiemtra = true;
                        }
                        else
                        {
                            kiemtra = false;
                        }
                    }
                    con.Close();
                    return kiemtra;
                }
                catch(Exception ex)
                {
                    MessageBox.Show(ex.Message, "Hệ Thống");
                    return false;
                }
            }
        }

        public bool KiemtraDangNhap()
        {
            return dangnhap;
        }

        public string KiemtraTinhTrang()
        {
            return tinhtrang;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (!textBox1.Text.Equals("") || !textBox2.Text.Equals(""))
            {
                if (ktraNV(textBox1.Text, textBox2.Text))
                    {
                        MessageBox.Show("Đăng nhập thành công!", "Hệ Thống");
                        dangnhap = true;
                        this.Close();
                        parentForm.Show();
                    }
                else
                    {
                        MessageBox.Show("Tài khoản hoặc mật khẩu sai, Vui lòng thử lại", "Hệ Thống");
                    }
            }
            else
            {
                MessageBox.Show("Vui lòng nhập thông tin đầy đủ", "Hệ Thống");
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
            parentForm.Close();
        }

        private void Form_Signin_FormClosed(object sender, FormClosedEventArgs e)
        {
        }

        private void Form_Signin_Load(object sender, EventArgs e)
        {
                ktraNV(textBox1.Text, textBox2.Text);
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
