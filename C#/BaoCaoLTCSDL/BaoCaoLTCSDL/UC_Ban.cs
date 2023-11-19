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
    public partial class UC_Ban : UserControl
    {
        string kn = @"Data Source=Dell_Anhson\SQLEXPRESS;Initial Catalog=CSDLFASTFOOD;Integrated Security=True";
        public UC_Ban()
        {
            InitializeComponent();
            loadBan();
        }

        public void loadBan()
        {
            using(SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    con.Open();
                    SqlCommand cmd = new SqlCommand("Select idBan as 'ID Bàn', soBan as 'Bàn' From Ban", con);
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

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            if (dataGridView1.SelectedCells.Count > 0)
            {
                int row = dataGridView1.SelectedCells[0].RowIndex;
                DataGridViewRow dataGridViewRow = dataGridView1.Rows[row];
                string idBan = dataGridViewRow.Cells["ID Bàn"].Value.ToString();
                textBox2.Text = idBan;
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            using (SqlConnection conn = new SqlConnection(kn))
            {
                int idban = 0;
                try
                {
                    conn.Open();

                    SqlCommand cmd = new SqlCommand("SELECT COUNT(*) AS total, MAX(idBan) AS MaxID FROM Ban", conn);
                    using (SqlDataReader count = cmd.ExecuteReader())
                    {
                        if(count.Read())
                        {
                            int total = Convert.ToInt32(count["total"]);
                            int maxID = Convert.ToInt32(count["MaxID"]);

                            if (total > 0)
                            {
                                idban = maxID + 1;
                            }
                            else
                            {
                                idban = 1;
                            }
                            count.Close();

                            SqlCommand cmd1 = new SqlCommand("INSERT INTO Ban VALUES (@soBan)", conn);
                            cmd1.Parameters.AddWithValue("@soBan", "Bàn số " + idban);
                            cmd1.ExecuteNonQuery();
                        }
                    }
                    conn.Close();
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message, "Hệ Thống");
                }
            }
            loadBan();
        }

        public void deleteBan(string id)
        {
            using (SqlConnection con = new SqlConnection(kn))
            {
                try
                {
                    if (MessageBox.Show("Bạn có muốn xóa không?", "Xóa bàn", MessageBoxButtons.YesNo) == DialogResult.Yes)
                    {
                        con.Open();
                        SqlCommand cmd = new SqlCommand("Delete From Ban where idBan = @id", con);
                        cmd.Parameters.AddWithValue("@id", id);
                        cmd.ExecuteNonQuery();
                        con.Close();
                        MessageBox.Show("Xóa Thành Công", "Hệ Thống");
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message, "Hệ Thống");
                }
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedCells.Count > 0)
            {
                int row = dataGridView1.SelectedCells[0].RowIndex;
                DataGridViewRow dataGridViewRow = dataGridView1.Rows[row];
                string idBan = dataGridViewRow.Cells["ID Bàn"].Value.ToString();
                deleteBan(idBan);
            }
            loadBan();
            textBox2.Text = "";
        }
    }
}
