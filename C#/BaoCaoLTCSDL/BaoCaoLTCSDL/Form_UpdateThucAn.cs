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
    public partial class Form_UpdateThucAn : Form
    {
        string kn = @"Data Source=Dell_Anhson\SQLEXPRESS;Initial Catalog=CSDLFASTFOOD;Integrated Security=True";
        
        public void LoadThucAn(string id)
        {
            using(SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd1 = new SqlCommand("Select * from DanhMuc", con);
                    SqlDataAdapter cd1 = new SqlDataAdapter(cmd1);
                    DataTable tb1 = new DataTable();
                    cd1.Fill(tb1);
                    cb_danhmuc.DataSource = tb1;
                    cb_danhmuc.DisplayMember = "tenDanhMuc";
                    cb_danhmuc.ValueMember = "idDanhMuc";
                    SqlCommand cmd = new SqlCommand("Select * From ThucAn Where idThucAn = @id", con);
                    cmd.Parameters.AddWithValue("@id", id);
                    SqlDataAdapter cd = new SqlDataAdapter(cmd);
                    DataTable tb = new DataTable();
                    cd.Fill(tb);
                    if(tb.Rows.Count > 0)
                    {
                        txt_id.Text = tb.Rows[0]["idThucAn"].ToString();
                        txt_ten.Text = tb.Rows[0]["tenThucAn"].ToString();
                        txt_gia.Text = tb.Rows[0]["giaThucAn"].ToString();
                        cb_danhmuc.SelectedValue = tb.Rows[0]["idDanhMuc"].ToString();
                    }
                    con.Close();
                }
                catch(Exception ex)
                {
                    MessageBox.Show(ex.Message + " Dòng 48", "Hệ Thống");
                }
            }
        }
        public Form_UpdateThucAn(string idThucAn)
        {
            InitializeComponent();
            LoadThucAn(idThucAn);
        }

        public void ChinhSua(string id, string ten, string gia, string danhmuc)
        {
            using(SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("Update ThucAn Set tenThucAn = @ten, giaThucAn = @gia, idDanhMuc = @DM Where idThucAn = @id", con);
                    cmd.Parameters.AddWithValue("@id", id);
                    cmd.Parameters.AddWithValue("@ten", ten);
                    cmd.Parameters.AddWithValue("@gia", gia);
                    cmd.Parameters.AddWithValue("@DM", danhmuc);
                    cmd.ExecuteNonQuery();

                    MessageBox.Show("Chỉnh sửa thành công", "Hệ Thống");
                    con.Close();
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message + " Dòng 77", "Hệ Thống");
                }
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            ChinhSua(txt_id.Text, txt_ten.Text, txt_gia.Text, cb_danhmuc.SelectedValue.ToString());
            this.Close();
        }

        private void txt_id_TextChanged(object sender, EventArgs e)
        {

        }

        private void Form_UpdateThucAn_Load(object sender, EventArgs e)
        {

        }
    }
}
