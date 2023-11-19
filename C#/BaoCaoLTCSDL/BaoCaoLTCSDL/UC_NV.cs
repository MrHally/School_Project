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
    public partial class UC_NV : UserControl
    {
        string kn = @"Data Source=Dell_Anhson\SQLEXPRESS;Initial Catalog=CSDLFASTFOOD;Integrated Security=True";
        public UC_NV()
        {
            InitializeComponent();
            loadNV();
        }

        public void loadNV()
        {
            using (SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("Select tenDangNhap as 'Username', tenNhanVien as 'Họ Tên' From NhanVien", con);
                    SqlDataAdapter cd = new SqlDataAdapter(cmd);
                    DataTable tb = new DataTable();
                    cd.Fill(tb);
                    dataGridView1.DataSource = tb;
                    con.Close();
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message, "Hệ Thống");
                }
            }
        }

        public void insertNV(string id, string hoten)
        {
            using (SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd1 = new SqlCommand("Select Count(*) From NhanVien Where tenDangNhap = @id", con);
                    cmd1.Parameters.AddWithValue("@id", id);
                    int userCount = (int)cmd1.ExecuteScalar();
                    if(userCount > 0)
                    {
                        MessageBox.Show("Trùng tên đăng nhập! Vui lòng nhập khác", "Hệ Thống");
                        return;
                    }

                    SqlCommand cmd = new SqlCommand("Insert into NhanVien Values(@user, @hoten, '1')", con);
                    cmd.Parameters.AddWithValue("@user", id);
                    cmd.Parameters.AddWithValue("@hoten", hoten);
                    cmd.ExecuteNonQuery();
                    MessageBox.Show("Thêm Thành Công", "Hệ Thống");
                    con.Close();
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message, "Hệ Thống");
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (!txt_hoten.Text.Equals("") || !txt_username.Text.Equals(""))
            {
                insertNV(txt_username.Text, txt_hoten.Text);
                loadNV();
                txt_username.Text = "";
                txt_hoten.Text = "";
            }
            else
            {
                MessageBox.Show("Vui lòng nhập thông tin!", "Hệ Thống");
            }
            
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedCells.Count > 0)
            {
                int row = dataGridView1.SelectedCells[0].RowIndex;
                DataGridViewRow dataGridViewRow = dataGridView1.Rows[row];
                string idNV = dataGridViewRow.Cells["Username"].Value.ToString();
                deleteNV(idNV);
            }
        }

        private void deleteNV(string idNV)
        {
            using (SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("Delete From NhanVien Where tenDangNhap = @id", con);
                    cmd.Parameters.AddWithValue("@id", idNV);
                    cmd.ExecuteNonQuery();
                    MessageBox.Show("Xóa Thành Công", "Hệ Thống");
                    con.Close();
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message, "Hệ Thống");
                }
            }
            loadNV();
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (dataGridView1.SelectedCells.Count > 0)
            {
                int row = dataGridView1.SelectedCells[0].RowIndex;
                DataGridViewRow dataGridViewRow = dataGridView1.Rows[row];
                string idNV = dataGridViewRow.Cells["Username"].Value.ToString();
                string tenNV = dataGridViewRow.Cells["Họ Tên"].Value.ToString();

                txt_username.Text = idNV;
                txt_hoten.Text = tenNV;
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedCells.Count > 0)
            {
                int row = dataGridView1.SelectedCells[0].RowIndex;
                DataGridViewRow dataGridViewRow = dataGridView1.Rows[row];
                string idNV = dataGridViewRow.Cells["Username"].Value.ToString();
                Form_UpdateNhanVien chinhsua = new Form_UpdateNhanVien(idNV);
                chinhsua.ShowDialog();
            }
            loadNV();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            try
            {
                if (dataGridView1.SelectedCells.Count > 0)
                {
                    int row = dataGridView1.SelectedCells[0].RowIndex;
                    DataGridViewRow dataGridViewRow = dataGridView1.Rows[row];
                    string idNV = dataGridViewRow.Cells["Username"].Value.ToString();
                    Form_ResetMK reset = new Form_ResetMK(idNV);
                    reset.ShowDialog();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Hệ Thống");
            }
        }
    }
}