using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BaoCaoLTCSDL
{
    public partial class UC_Hoadon : UserControl
    {
        string kn = @"Data Source=Dell_Anhson\SQLEXPRESS;Initial Catalog=CSDLFASTFOOD;Integrated Security=True";
        public string idHoadon;
        public int soLuongThucAn {  get; private set; }
        public int idBan {  get; private set; }
        public double PhanTram {  get; private set; }
        public double Tongtien {  get; private set; }
        public UC_Hoadon(string idHoaDon)
        {
            InitializeComponent();
            idHoadon = idHoaDon;
            txt_mahd.Text = idHoaDon;
            loadTable();
            LoadHoaDon();

        }
        public void loadTable()
        {
            using (SqlConnection conn = new SqlConnection(kn))
            {
                try
                {
                    conn.Open();
                    SqlCommand cmd = new SqlCommand("Select * From Ban", conn);
                    using (SqlDataReader reader = cmd.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            string name = reader["soBan"].ToString();
                            int id = Convert.ToInt32(reader["idBan"]);

                            Button button = new Button
                            {
                                Text = name,
                                Tag = id,
                            };
                            button.Font = new Font("Corbel", 14);
                            button.BackColor = Color.Orange;
                            button.Size = new System.Drawing.Size(117, 111);
                            getidTableHD();

                            if (idBan == id)
                            {
                                ChangeButtonState(button);
                            }

                            button.Click += Button_Click;

                            flowLayoutPanel1.Controls.Add(button);
                        }
                    }
                    conn.Close();
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message + "Dòng 65");
                }
            }
        }

        private Button selectedButton = null;
        private void Button_Click(object sender, EventArgs e)
        {
            Button clickedButton = (Button)sender;

            if (selectedButton != clickedButton)
            {
                ChangeButtonState(clickedButton);
            }
            else
            {
                ChangeButtonState(null);
            }

            idBan = (int)clickedButton.Tag;
            updateTable(idBan);
        }

        private int idBanChon;
        public string tenBan;
        public void getidTableHD()
        {
            using(SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("Select A.idBan as IDB, soBan From HoaDon A, Ban B Where A.idBan = B.idBan And idHoaDon = @idhd", con);
                    cmd.Parameters.AddWithValue("@idhd", idHoadon);
                    SqlDataReader reader = cmd.ExecuteReader();
                    if (reader.Read())
                    {
                        if (!reader.IsDBNull(reader.GetOrdinal("IDB")))
                        {
                            int IDban = Convert.ToInt32(reader["IDB"].ToString());
                            string tenban = reader["soBan"].ToString();
                            idBan = IDban;
                            tenBan = tenban;
                        }
                        else
                        {
                            return;
                        }
                    }
                    con.Close();
                }
                catch(Exception ex)
                {
                    MessageBox.Show(ex.Message + " Dòng 114", "Hệ Thống");
                }
            }
        }
        public void updateTable(int idBan)
        {
            using (SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd1 = new SqlCommand("Select idBan From HoaDon Where idHoaDon = @idhd", con);
                    cmd1.Parameters.AddWithValue("@idhd", idHoadon);
                    SqlDataReader reader = cmd1.ExecuteReader();
                    if (reader.Read())
                    {
                        if (!reader.IsDBNull(reader.GetOrdinal("idBan")))
                        {
                            if (MessageBox.Show("Đã có bàn chọn, Bạn có muốn chuyển bàn không?", "Hệ Thống", MessageBoxButtons.YesNo) == DialogResult.Yes)
                            {
                                reader.Close();
                                SqlCommand cmd = new SqlCommand("Update HoaDon Set idBan = @idB Where idHoaDon = @idHD", con);
                                cmd.Parameters.AddWithValue("@idB", idBan);
                                cmd.Parameters.AddWithValue("@idHD", idHoadon);
                                cmd.ExecuteNonQuery();
                            }
                            else
                            {
                                reader.Close();
                                return;
                            }
                        }
                        else
                        {
                            reader.Close();
                            SqlCommand cmd2 = new SqlCommand("Update HoaDon Set idBan = @idB Where idHoaDon = @idHD", con);
                            cmd2.Parameters.AddWithValue("@idB", idBan);
                            cmd2.Parameters.AddWithValue("@idHD", idHoadon);
                            cmd2.ExecuteNonQuery();
                        }
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message + "Dòng 101", "Hệ Thống");
                }
            }
        }

        private void ChangeButtonState(Button button)
        {
            if (selectedButton != null)
            {
                selectedButton.BackColor = Color.White;
            }

            selectedButton = button;

            if (selectedButton != null)
            {
                selectedButton.BackColor = Color.LightBlue;
            }
        }

        public void LoadHoaDon()
        {
            using (SqlConnection conn = new SqlConnection(kn))
            {
                try
                {
                    conn.Open();
                    SqlCommand cmd = new SqlCommand("select tenThucAn as 'Món', soluong as 'Số lượng', Format(giaThucAn, 'N0') as 'Giá', Format((giaThucAn * soluong), 'N0') as 'Thành Tiền' " +
                        "from ThucAn A, ChiTietHD B where A.idThucAn = B.idThucAn and idHoaDon = @idHD", conn);
                    cmd.Parameters.AddWithValue("@idHD", idHoadon);
                    SqlDataAdapter cd = new SqlDataAdapter(cmd);
                    DataTable tb = new DataTable();
                    cd.Fill(tb);
                    dataGridView1.DataSource = tb;
                    SqlCommand cmd1 = new SqlCommand("Select Format(giamgiaHoaDon, 'N0') as giamgia, Format(tongtien, 'N0') as tong From HoaDon Where idHoaDon = @idHD", conn);
                    cmd1.Parameters.AddWithValue("@idHD", idHoadon);
                    using(SqlDataReader reader = cmd1.ExecuteReader())
                    {
                        if (reader.Read())
                        {
                            if (int.TryParse(reader["giamgia"].ToString(), out int giamgia))
                            {
                                PhanTram = giamgia;
                            }
                            else
                            {
                                PhanTram = 0;
                            }
                            Tongtien = Convert.ToDouble(reader["tong"].ToString());
                            reader.Close();
                            txt_giamgia.Text = PhanTram + "";
                            txt_tongtien.Text = Tongtien.ToString("N0") + "đ";
                        }
                    }
                    conn.Close();
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message + "Dòng 153", "Hệ Thông");
                }
            }
        }

        public void setPhanTramandTongtien(double phantram, double tongtien)
        {
            using (SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("Update HoaDon Set giamgiaHoaDon = @phantram, tongtien = @tongtien Where idHoaDon = @idHD", con);
                    cmd.Parameters.AddWithValue("@phantram", phantram);
                    cmd.Parameters.AddWithValue("@tongtien", tongtien);
                    cmd.Parameters.AddWithValue("@idHD", idHoadon);
                    cmd.ExecuteNonQuery();
                    con.Close();
                }
                catch(Exception ex)
                {
                    MessageBox.Show(ex.Message + " Dòng 174", "Hệ Thống");
                }
            }
        }

        public void TinhTong()
        {
            double phamtram = Convert.ToDouble(txt_giamgia.Text);
            double total = 0;
            using (SqlConnection conn = new SqlConnection(kn))
            {
                try
                {
                    conn.Open();
                    SqlCommand cmd = new SqlCommand("Select (giaThucAn * soluong) as giaThanh from ThucAn A, ChiTietHD B where idHoaDon = @idHD and A.idThucAn = B.idThucAn", conn);
                    cmd.Parameters.AddWithValue("@idHD", idHoadon);
                    using(SqlDataReader reader = cmd.ExecuteReader())
                    {
                        while(reader.Read())
                        {
                            double ThanhGia = Convert.ToDouble(reader["giaThanh"]);
                            total += ThanhGia;
                        }
                    }
                    PhanTram = phamtram;
                    Tongtien = total - (total * (phamtram / 100));
                    conn.Close();
                }
                catch(Exception ex)
                {
                    MessageBox.Show(ex.Message + "Dòng 202", "Hệ Thống");
                }
            }
        }
        
        public Boolean huyHD(string id)
        {
            using (SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    if (MessageBox.Show("Bạn có muốn hủy không?", "Hủy Hóa Đơn", MessageBoxButtons.YesNo) == DialogResult.Yes)
                    {
                        SqlCommand checkCmd = new SqlCommand("SELECT COUNT(*) FROM ChiTietHD WHERE idHoaDon = @id", con);
                        checkCmd.Parameters.AddWithValue("@id", id);
                        int count = (int)checkCmd.ExecuteScalar();

                        if (count > 0)
                        {
                            SqlCommand deleteChiTietCmd = new SqlCommand("Delete From ChiTietHD where idHoaDon = @id", con);
                            deleteChiTietCmd.Parameters.AddWithValue("@id", id);
                            deleteChiTietCmd.ExecuteNonQuery();
                        }

                        SqlCommand deleteHoaDonCmd = new SqlCommand("Delete From HoaDon where idHoaDon = @id", con);
                        deleteHoaDonCmd.Parameters.AddWithValue("@id", id);
                        deleteHoaDonCmd.ExecuteNonQuery();

                        MessageBox.Show("Xóa Thành Công", "Hệ Thống");
                    }
                    con.Close();
                    return true;
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message + " Dòng 238", "Hệ Thống");
                    return false;
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (huyHD(txt_mahd.Text))
            {
                this.Hide();
            }
        }
        public void addMonAn(int idMon, int soluong)
        {
            using (SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("Insert into ChitietHD values(@idHD, @idMon, @Sl)", con);
                    cmd.Parameters.AddWithValue("@idHD", idHoadon);
                    cmd.Parameters.AddWithValue("@idMon", idMon);
                    cmd.Parameters.AddWithValue("@Sl", soluong);
                    cmd.ExecuteNonQuery();
                    TinhTong();
                    MessageBox.Show("Thêm Thành Công Món", "Hệ Thống");
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message + " Dòng 269", "Hệ Thống");
                }
            }
        }

        private void button6_Click(object sender, EventArgs e)
        {
            Form_ChonThucAn chon = new Form_ChonThucAn(idHoadon);
            chon.ShowDialog();
        }

        private void UC_Hoadon_Load(object sender, EventArgs e)
        {
            dataGridView1.Refresh();
        }


        private void button10_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("Kiểm tra chắc chắn chưa?", "Thanh Toán Hóa Đơn", MessageBoxButtons.YesNo) == DialogResult.Yes)
            {
                DateTime dateTime = DateTime.Now;
                using (SqlConnection con = new SqlConnection(kn))
                {
                    try
                    {
                        con.Open();
                        SqlCommand cmd = new SqlCommand("Update Hoadon Set idBan = @idBan, ngaylapHoaDon = @Ngaylap, giamgiaHoaDon = @GiamGia, dathanhtoanHoaDon = 1, tongtien = @Tongtien Where idHoaDon = @idHoaDon", con);
                        cmd.Parameters.AddWithValue("@idHoaDon", idHoadon);
                        cmd.Parameters.AddWithValue("@idBan", idBan);
                        cmd.Parameters.AddWithValue("@Ngaylap", dateTime.ToString());
                        cmd.Parameters.AddWithValue("@GiamGia", txt_giamgia.Text);
                        cmd.Parameters.AddWithValue("@Tongtien", Tongtien);
                        cmd.ExecuteNonQuery();
                        con.Close();
                        ReportHD();
                    }
                    catch (Exception ex)
                    {
                        MessageBox.Show(ex.Message + " Dòng 310", "Hệ thống");
                    }
                }
            }
        }

        private void button8_Click(object sender, EventArgs e)
        {
            TinhTong();
            setPhanTramandTongtien(PhanTram, Tongtien);
            LoadHoaDon();
        }

        public int getidThucAn(string mon)
        {
            int idmon = 0;
            using(SqlConnection con = new SqlConnection(kn))
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("Select idThucAn From ThucAn Where tenThucAn = @mon", con);
                cmd.Parameters.AddWithValue("@mon", mon);
                using (SqlDataReader reader = cmd.ExecuteReader())
                {
                    if(reader.Read())
                    {
                        idmon = Convert.ToInt32(reader["idThucAn"].ToString());
                    }
                }
            }
            return idmon;
        }

        public void deleteThucAn(int id)
        {
            using (SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    if (MessageBox.Show("Bạn có muốn xóa không?", "Xóa Món", MessageBoxButtons.YesNo) == DialogResult.Yes)
                    {
                        con.Open();
                        SqlCommand cmd = new SqlCommand("Delete From ChiTietHD Where idThucAn = @id", con);
                        cmd.Parameters.AddWithValue("@id", id);
                        cmd.ExecuteNonQuery();

                        MessageBox.Show("Xóa Thành Công", "Hệ Thống");
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message + " Dòng 467", "Hệ Thống");
                }
            }
        }

        private void button7_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedCells.Count > 0)
            {
                int row = dataGridView1.SelectedCells[0].RowIndex;
                DataGridViewRow dataGridViewRow = dataGridView1.Rows[row];
                string tenmon = dataGridViewRow.Cells["Món"].Value.ToString();
                deleteThucAn(getidThucAn(tenmon));
            }
        }

        private void txt_giamgia_TextChanged(object sender, EventArgs e)
        {
            TinhTong();
            txt_tongtien.Text = Tongtien.ToString("N0") + "đ";
        }

        public void ReportHD()
        {
            DateTime now = DateTime.Now;
            List<HoaDon> ds = new List<HoaDon>();
            foreach (DataGridViewRow row in dataGridView1.Rows)
            {
                if (!row.IsNewRow)
                {
                    string IDHD = idHoadon.ToString();
                    string tban = tenBan;
                    string Ngaylap = now.ToString("dd/MM/yyyy");
                    string Giamgia = PhanTram.ToString();
                    string TongTienHD = Tongtien.ToString("N0");
                    string IDMon = row.Cells[0].Value.ToString();
                    string SoLuong = row.Cells[1].Value.ToString();
                    string GiaMon = row.Cells[2].Value.ToString();
                    string ThanhGia = row.Cells[3].Value.ToString();
                    HoaDon hd = new HoaDon
                    {
                        IDHoaDon = IDHD,
                        IDBan = tban,
                        NgayLap = Ngaylap,
                        GiamGia = Giamgia,
                        TongTien = TongTienHD,
                        TenMon = IDMon,
                        SoLuongMon = SoLuong,
                        GiaThanh = GiaMon,
                        ThanhTien = ThanhGia
                    };
                    ds.Add(hd);
                }
            }
            Form_HienThiReportHD hienthi = new Form_HienThiReportHD();
            hienthi.ImportData(ds);
            hienthi.ShowDialog();
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            ReportHD();
        }

        private void flowLayoutPanel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
    }
    public class HoaDon
    {
        public string IDHoaDon { get; set; }
        public string IDBan { get; set; }
        public string NgayLap { get; set; }
        public string GiamGia { get; set; }
        public string TongTien { get; set; }
        public string TenMon { get; set; }
        public string SoLuongMon { get; set; }
        public string GiaThanh { get; set; }
        public string ThanhTien { get; set; }
    }
}