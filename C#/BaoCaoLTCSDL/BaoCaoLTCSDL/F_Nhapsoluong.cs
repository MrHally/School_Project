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
    public partial class F_Nhapsoluong : Form
    {
        public string UserInput { get; private set; }
        public F_Nhapsoluong()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            UserInput = textBox1.Text;
            if (string.IsNullOrEmpty(UserInput))
                return;

            if (int.TryParse(UserInput, out int quantity))
            {
                if (quantity <= 0)
                {
                    MessageBox.Show("Số lượng phải lớn hơn 0.");
                    return;
                }
                DialogResult = DialogResult.OK;
                Close();
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
            Close();
        }
    }
}
