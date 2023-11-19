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
    public partial class UC_Home : UserControl
    {
        string kn = @"Data Source=Dell_Anhson\SQLEXPRESS;Initial Catalog=CSDLFASTFOOD;Integrated Security=True";
        private Form parentForm;
        public UC_Home(Form form)
        {
            InitializeComponent();
            parentForm = form;
            LoadHD();
            loadDoanhThuNgay();
        }
        static string CreateID()
        {
            Random random = new Random();
            string kitu = "QWERTYUIOPASDFGHJKLZXCVBNM0123456789";
            char[] id = new char[8];

            for (int i = 0; i < 6; i++)
            {
                id[i] = kitu[random.Next(kitu.Length)];
            }

            return new string(id);
        }

        public Boolean insertHoaDon(string id, DateTime date)
        {
            using (SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("Insert Into HoaDon Values(@id,NULL,@date,0,0,0)", con);
                    cmd.Parameters.AddWithValue("@id", id);
                    cmd.Parameters.AddWithValue("@date", date.ToString());
                    cmd.ExecuteNonQuery();
                    con.Close();
                    return true;
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message + "Dòng 55");
                    return false;
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string id = CreateID();
            DateTime date = DateTime.Now;

            if(insertHoaDon(id, date))
            {
                System.Threading.Thread.Sleep(100);
                UC_Hoadon ucHoadon = new UC_Hoadon(id);
                ucHoadon.Dock = DockStyle.Fill;

                if (parentForm.Controls.ContainsKey("pl_container"))
                {
                    Panel panel = (Panel)parentForm.Controls["pl_container"];
                    panel.Controls.Clear();
                    panel.Controls.Add(ucHoadon);
                }
            }
        } 

        public void loadDoanhThuNgay()
        {
            DateTime ngaylap = DateTime.Now;
            using(SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("Select Count(idHoaDon) as TongHD, Sum(tongtien) as TongDoanhThu From HoaDon Where ngaylapHoaDon = @ngaylap", con);
                    cmd.Parameters.AddWithValue("@ngaylap", ngaylap.ToString());
                    using (SqlDataReader reader = cmd.ExecuteReader())
                    {
                        if(reader.Read())
                        {
                            int? TongHD = reader["TongHD"] as int?;
                            decimal? TongDoanhThu = reader["TongDoanhThu"] as decimal?;

                            txt_TongHD.Text = TongHD != null ? TongHD.ToString() : "0";
                            txt_TongDH.Text = TongDoanhThu != null ? TongDoanhThu + "đ" : "0đ";
                        }
                        else
                        {
                            txt_TongHD.Text = "0";
                            txt_TongDH.Text = "0đ";
                        }
                    }

                    con.Close();
                }
                catch(Exception ex)
                {
                    MessageBox.Show(ex.Message + " Dòng 112", "Hệ Thống");
                }
            }
        }

        public void LoadHD()
        {
            DateTime ngaylap = DateTime.Now;
            using(SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("select idHoaDon as 'Mã Hóa Đơn', soBan as 'Bàn', ngaylapHoaDon as 'Ngày lập', giamgiaHoaDon as 'Giảm giá', " +
                        "Case when dathanhtoanHoaDon = 0 then 'Chưa Thanh Toán' when dathanhtoanHoaDon = 1 then 'Đã Thanh Toán' end as 'Trạng Thái', tongtien as 'Tổng Tiền' " +
                        "From HoaDon A, Ban B where A.idBan = B.idBan and ngaylapHoaDon = @ngaylap", con);
                    cmd.Parameters.AddWithValue("@ngaylap", ngaylap.ToString());
                    SqlDataAdapter cd = new SqlDataAdapter(cmd);
                    DataTable tb = new DataTable();
                    cd.Fill(tb);
                    dataGridView1.DataSource = tb;
                    con.Close();
                }
                catch(Exception ex)
                {
                    MessageBox.Show(ex.Message + " Dòng 135", "Hệ Thống");
                }
            }
        }

        public void LoadHoaDon(string idHD)
        {

        }

        private void dataGridView1_CellContentDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            if (dataGridView1.SelectedCells.Count > 0)
            {
                int row = dataGridView1.SelectedCells[0].RowIndex;
                DataGridViewRow dataGridViewRow = dataGridView1.Rows[row];
                string idHD = dataGridViewRow.Cells["Mã Hóa Đơn"].Value.ToString();

                System.Threading.Thread.Sleep(100);
                UC_Hoadon ucHoadon = new UC_Hoadon(idHD);
                ucHoadon.Dock = DockStyle.Fill;

                if (parentForm.Controls.ContainsKey("pl_container"))
                {
                    Panel panel = (Panel)parentForm.Controls["pl_container"];
                    panel.Controls.Clear();
                    panel.Controls.Add(ucHoadon);
                }
            }
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (dataGridView1.SelectedCells.Count > 0)
            {
                int row = dataGridView1.SelectedCells[0].RowIndex;
                DataGridViewRow dataGridViewRow = dataGridView1.Rows[row];
                string idHD = dataGridViewRow.Cells["Mã Hóa Đơn"].Value.ToString();

                System.Threading.Thread.Sleep(100);
                UC_Hoadon ucHoadon = new UC_Hoadon(idHD);
                ucHoadon.Dock = DockStyle.Fill;

                if (parentForm.Controls.ContainsKey("pl_container"))
                {
                    Panel panel = (Panel)parentForm.Controls["pl_container"];
                    panel.Controls.Clear();
                    panel.Controls.Add(ucHoadon);
                }
            }
        }
    }
}
