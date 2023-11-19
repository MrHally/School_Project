using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace BaoCaoLTCSDL
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            bt_NV.Hide();
        }


        public void Dangnhap()
        {
            Form_Signin signInForm = new Form_Signin(this);
            signInForm.ShowDialog();
            if (signInForm.KiemtraDangNhap())
            {
                if (signInForm.KiemtraTinhTrang() == "admin")
                {
                    UC_Home home = new UC_Home(this);
                    addUserControl(home);
                    QuyenAdmin();
                }
                else if(signInForm.KiemtraTinhTrang() == "nhanvien")
                {
                    UC_Home home = new UC_Home(this);
                    addUserControl(home);
                    QuyenNhanVien();
                }
                else
                {
                    UC_Home home = new UC_Home(this);
                    addUserControl(home);
                    QuyenNhanVien();
                }
            }
            else
            {
                this.Close();
            }
        }

        public void QuyenAdmin()
        {
            bt_NV.Show();
        }

        public void QuyenNhanVien()
        {
            
            bt_NV.Hide();
        }

        public void addUserControl(UserControl userControl)
        {
            userControl.Dock = DockStyle.Fill;
            pl_container.Controls.Clear();
            pl_container.Controls.Add(userControl);
            userControl.BringToFront();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            UC_Home home = new UC_Home(this);
            addUserControl(home);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            UC_SP sp = new UC_SP();
            addUserControl(sp);
        }

        private void button3_Click(object sender, EventArgs e)
        {
            UC_Ban ban = new UC_Ban();
            addUserControl(ban);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            UC_DoanhThu dh = new UC_DoanhThu();
            addUserControl(dh);
        }

        private void button6_Click(object sender, EventArgs e)
        {
            Hide();
            Form_Signin signInForm = new Form_Signin(this);
            signInForm.tinhtrang = "";
            signInForm.ShowDialog();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            UC_NV nv = new UC_NV();
            addUserControl(nv);
        }

        private void bt_HoaDon_Click(object sender, EventArgs e)
        {
            UC_Hoadon hd = new UC_Hoadon("");
            addUserControl(hd);
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            Dangnhap();
        }

        private void pl_container_Paint(object sender, PaintEventArgs e)
        {

        }
    }
}
