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
    public partial class UC_SP : UserControl
    {
        string kn = @"Data Source=Dell_Anhson\SQLEXPRESS;Initial Catalog=CSDLFASTFOOD;Integrated Security=True";
        
        public void loadData()
        {
            using(SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("Select idThucAn as 'ID Thức Ăn', tenThucAn as 'Tên Thức Ăn', giaThucAn as 'Giá Thành' From ThucAn", con);
                    SqlDataAdapter cd = new SqlDataAdapter(cmd);
                    DataTable tb = new DataTable();
                    cd.Fill(tb);
                    dataGridView1.DataSource = tb;
                    SqlCommand cmd1 = new SqlCommand("Select idDanhMuc, tenDanhMuc From DanhMuc", con);
                    SqlDataAdapter cd1 = new SqlDataAdapter(cmd1);
                    DataTable tb1 = new DataTable();
                    cd1.Fill(tb1);
                    cb_danhmuc.DataSource = tb1;
                    cb_danhmuc.DisplayMember = "tenDanhMuc";
                    cb_danhmuc.ValueMember = "idDanhMuc";
                    con.Close();
                }catch(Exception ex)
                {
                    MessageBox.Show(ex.Message + "Dòng 33");
                }
            }
        }

        public void loadDanhMuc()
        {
            using(SqlConnection conn = new SqlConnection(kn))
            {
                try
                {
                    conn.Open();
                    SqlCommand cmd = new SqlCommand("Select * From DanhMuc",conn);
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
                            button.Font = new Font("Corbel", 14);
                            button.BackColor = Color.Orange;
                            button.Size = new System.Drawing.Size(100, 90);


                            button.Click += Button_Click;

                            fpl_danhmuc.Controls.Add(button);
                        }
                    }
                    conn.Close();
                }catch(Exception ex)
                {
                    MessageBox.Show(ex.Message + "Dòng 71");
                }
            }
        }

        public void loadThucAnTheoDanhMuc(string id)
        {
            using(SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("Select idThucAn as 'ID Thức Ăn', tenThucAn as 'Tên Thức Ăn', giaThucAn as 'Giá Thành' From ThucAn Where idDanhMuc = @id", con);
                    cmd.Parameters.AddWithValue("@id", id);
                    SqlDataAdapter cd = new SqlDataAdapter(cmd);
                    DataTable tb = new DataTable();
                    cd.Fill(tb);
                    dataGridView1.DataSource = tb;
                    con.Close();
                }catch(Exception ex)
                {
                    MessageBox.Show(ex.Message + " Dòng 92");
                }
            }
        }

        private void Button_Click(object sender, EventArgs e)
        {
            dataGridView1.DataSource = null;
            Button click = (Button)sender;
            int id = (int)click.Tag;
            loadThucAnTheoDanhMuc(id.ToString());
        }

        public UC_SP()
        {
            InitializeComponent();
            loadData();
            loadDanhMuc();
        }

        public void insertThucAn(string ten, string gia, string id)
        {
            using(SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("Insert into ThucAn values(@ten, @gia, @id)", con);
                    cmd.Parameters.AddWithValue("@ten", ten);
                    cmd.Parameters.AddWithValue("@gia", gia);
                    cmd.Parameters.AddWithValue("@id", id);
                    cmd.ExecuteNonQuery();

                    MessageBox.Show("Thêm thành công", "Hệ Thống");
                }catch(Exception ex)
                {
                    MessageBox.Show(ex.Message + "Dòng 128", "Hệ thống");
                }
            }
        }

        public void deleteThucAn(string id)
        {
            using(SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    if (MessageBox.Show("Bạn có muốn xóa không?", "Xóa món ăn", MessageBoxButtons.YesNo) == DialogResult.Yes)
                    {
                        con.Open();
                        SqlCommand cmd = new SqlCommand("Delete From ThucAn where idThucAn = @id", con);
                        cmd.Parameters.AddWithValue("@id", id);
                        cmd.ExecuteNonQuery();

                        MessageBox.Show("Xóa Thành Công", "Hệ Thống");
                    }
                }catch(Exception ex)
                {
                    MessageBox.Show(ex.Message, "Hệ Thống");
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            insertThucAn(txt_ten.Text, txt_gia.Text, cb_danhmuc.SelectedValue.ToString());
            loadThucAnTheoDanhMuc(cb_danhmuc.SelectedValue.ToString());
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if(dataGridView1.SelectedCells.Count > 0)
            {
                int row = dataGridView1.SelectedCells[0].RowIndex;
                DataGridViewRow dataGridViewRow = dataGridView1.Rows[row];
                string idThucAn = dataGridViewRow.Cells["ID Thức Ăn"].Value.ToString();
                Form_UpdateThucAn chinhsua = new Form_UpdateThucAn(idThucAn);
                chinhsua.ShowDialog();
            }
            loadData();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedCells.Count > 0)
            {
                int row = dataGridView1.SelectedCells[0].RowIndex;
                DataGridViewRow dataGridViewRow = dataGridView1.Rows[row];
                string idThucAn = dataGridViewRow.Cells["ID Thức Ăn"].Value.ToString();
                deleteThucAn(idThucAn);
            }
            loadData();
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
    }
}
