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
    public partial class UC_DoanhThu : UserControl
    {
        string kn = @"Data Source=Dell_Anhson\SQLEXPRESS;Initial Catalog=CSDLFASTFOOD;Integrated Security=True";
        public double TongDT;
        public UC_DoanhThu()
        {
            InitializeComponent();
        }

        public void loadDoanhThu()
        {
            string ngaytu = dateTimePicker1.Value.ToString();
            string ngaychon = dateTimePicker2.Value.ToString();
            using (SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("SELECT idHoaDon as 'Mã Hóa Đơn', soBan as 'Bàn', Format(ngaylapHoaDon,'d') as 'Ngày lập', giamgiaHoaDon as 'Giảm giá'," +
                        "CASE WHEN dathanhtoanHoaDon = 0 THEN 'Chưa Thanh Toán' WHEN dathanhtoanHoaDon = 1 THEN 'Đã Thanh Toán' END as 'Trạng Thái', Format(tongtien, 'N0') as 'Tổng Tiền' " +
                        "FROM HoaDon A, Ban B WHERE A.idBan = B.idBan AND ngaylapHoaDon BETWEEN @ngaytu AND @ngaychon ORDER BY ngaylapHoaDon desc", con);

                    cmd.Parameters.AddWithValue("@ngaytu", ngaytu);
                    cmd.Parameters.AddWithValue("@ngaychon", ngaychon);

                    SqlDataAdapter cd = new SqlDataAdapter(cmd);
                    DataTable tb = new DataTable();
                    cd.Fill(tb);
                    dataGridView1.DataSource = tb;

                    con.Close();
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message + " Dòng 37", "Hệ Thống");
                }
            }
        }

        public void tinhTongDoanhThu()
        {
            string ngaytu = dateTimePicker1.Value.ToString("dd/MM/yyyy");
            string ngaychon = dateTimePicker2.Value.ToString("dd/MM/yyyy");
            using (SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("Select Sum(Tongtien) as Tongdoanhthu From HoaDon WHERE ngaylapHoaDon BETWEEN @ngaytu AND @ngaychon", con);
                    cmd.Parameters.AddWithValue("@ngaytu", ngaytu);
                    cmd.Parameters.AddWithValue("@ngaychon", ngaychon);
                    using (SqlDataReader reader = cmd.ExecuteReader())
                    {
                        if (reader.HasRows)
                        {
                            reader.Read();
                            double TongDoanhThu = Convert.ToDouble(reader["Tongdoanhthu"].ToString());
                            textBox1.Text = TongDoanhThu.ToString("N0") + "đ";
                            TongDT = TongDoanhThu;
                        }
                        else
                        {
                            textBox1.Text = "0đ";
                        }
                    }
                    con.Close();
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message + " Dòng 77", "Hệ Thống");
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            loadDoanhThu();
            tinhTongDoanhThu();
        }

        public void ReportDoanhThu()
        {
            List<DoanhThu> ds = new List<DoanhThu>();
            foreach(DataGridViewRow row in dataGridView1.Rows)
            {
                if (!row.IsNewRow)
                {
                    string ngaytu = dateTimePicker1.Value.ToString("dd/MM/yyyy");
                    string ngaychon = dateTimePicker2.Value.ToString("dd/MM/yyyy");
                    string IDHD = row.Cells[0].Value.ToString();
                    string tenB = row.Cells[1].Value.ToString();
                    string Ngaylap = row.Cells[2].Value.ToString();
                    string Giamgia = row.Cells[3].Value.ToString();
                    string Ghichu;
                    if(row.Cells[4].Value.ToString().ToLower() == "chua thanh toán")
                    {
                        Ghichu = "Chưa Thanh Toán";
                    }
                    else
                    {
                        Ghichu = "";
                    }
                    string TongHD = row.Cells[5].Value.ToString();
                    string tongdt = TongDT.ToString("N0");
                    DoanhThu dt = new DoanhThu
                    {
                        ngayTu = ngaytu,
                        ngayChon = ngaychon,
                        idHoaDon = IDHD,
                        tenBan = tenB,
                        ngayLap = Ngaylap,
                        giamgia = Giamgia,
                        ghichu = Ghichu,
                        gia = TongHD,
                        Tongdt = tongdt
                    };
                    ds.Add(dt);
                }
            }
            Form_HienThiReportDT hienthi = new Form_HienThiReportDT();
            hienthi.ImportData(ds);
            hienthi.ShowDialog();
        }
        private void button2_Click(object sender, EventArgs e)
        {
            ReportDoanhThu();
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

                if (ParentForm.Controls.ContainsKey("pl_container"))
                {
                    Panel panel = (Panel)ParentForm.Controls["pl_container"];
                    panel.Controls.Clear();
                    panel.Controls.Add(ucHoadon);
                }
            }
        }
    }
    public class DoanhThu
    {
        public string ngayTu { get; set; }
        public string ngayChon { get; set; }
        public string idHoaDon { get; set; }
        public string tenBan { get; set; }
        public string ngayLap { get; set; }
        public string giamgia { get; set; }
        public string gia { get; set; }
        public string ghichu { get; set; }
        public string Tongdt { get; set; }
    }
}