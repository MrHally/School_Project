namespace BaoCaoLTCSDL
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.flowLayoutPanel1 = new System.Windows.Forms.FlowLayoutPanel();
            this.panel1 = new System.Windows.Forms.Panel();
            this.bt_Main = new System.Windows.Forms.Button();
            this.bt_ThucAn = new System.Windows.Forms.Button();
            this.bt_Ban = new System.Windows.Forms.Button();
            this.bt_DoanhThu = new System.Windows.Forms.Button();
            this.bt_NV = new System.Windows.Forms.Button();
            this.bt_SignOut = new System.Windows.Forms.Button();
            this.pl_container = new System.Windows.Forms.Panel();
            this.flowLayoutPanel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // flowLayoutPanel1
            // 
            this.flowLayoutPanel1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(128)))), ((int)(((byte)(0)))));
            this.flowLayoutPanel1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("flowLayoutPanel1.BackgroundImage")));
            this.flowLayoutPanel1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.flowLayoutPanel1.Controls.Add(this.panel1);
            this.flowLayoutPanel1.Controls.Add(this.bt_Main);
            this.flowLayoutPanel1.Controls.Add(this.bt_ThucAn);
            this.flowLayoutPanel1.Controls.Add(this.bt_Ban);
            this.flowLayoutPanel1.Controls.Add(this.bt_DoanhThu);
            this.flowLayoutPanel1.Controls.Add(this.bt_NV);
            this.flowLayoutPanel1.Controls.Add(this.bt_SignOut);
            this.flowLayoutPanel1.Dock = System.Windows.Forms.DockStyle.Left;
            this.flowLayoutPanel1.FlowDirection = System.Windows.Forms.FlowDirection.TopDown;
            this.flowLayoutPanel1.Location = new System.Drawing.Point(0, 0);
            this.flowLayoutPanel1.Name = "flowLayoutPanel1";
            this.flowLayoutPanel1.Size = new System.Drawing.Size(206, 673);
            this.flowLayoutPanel1.TabIndex = 0;
            // 
            // panel1
            // 
            this.panel1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("panel1.BackgroundImage")));
            this.panel1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.panel1.Location = new System.Drawing.Point(3, 3);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(202, 182);
            this.panel1.TabIndex = 0;
            // 
            // bt_Main
            // 
            this.bt_Main.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(128)))), ((int)(((byte)(0)))));
            this.bt_Main.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("bt_Main.BackgroundImage")));
            this.bt_Main.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.bt_Main.FlatAppearance.BorderColor = System.Drawing.Color.Black;
            this.bt_Main.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.bt_Main.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.bt_Main.ForeColor = System.Drawing.Color.Black;
            this.bt_Main.Image = ((System.Drawing.Image)(resources.GetObject("bt_Main.Image")));
            this.bt_Main.ImageAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.bt_Main.Location = new System.Drawing.Point(3, 191);
            this.bt_Main.Name = "bt_Main";
            this.bt_Main.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.bt_Main.Size = new System.Drawing.Size(202, 52);
            this.bt_Main.TabIndex = 1;
            this.bt_Main.Text = "Trang Chính";
            this.bt_Main.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.bt_Main.UseVisualStyleBackColor = false;
            this.bt_Main.Click += new System.EventHandler(this.button1_Click);
            // 
            // bt_ThucAn
            // 
            this.bt_ThucAn.BackColor = System.Drawing.Color.Transparent;
            this.bt_ThucAn.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("bt_ThucAn.BackgroundImage")));
            this.bt_ThucAn.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.bt_ThucAn.FlatAppearance.BorderColor = System.Drawing.Color.Black;
            this.bt_ThucAn.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.bt_ThucAn.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.bt_ThucAn.ForeColor = System.Drawing.Color.Black;
            this.bt_ThucAn.Image = ((System.Drawing.Image)(resources.GetObject("bt_ThucAn.Image")));
            this.bt_ThucAn.ImageAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.bt_ThucAn.Location = new System.Drawing.Point(3, 249);
            this.bt_ThucAn.Name = "bt_ThucAn";
            this.bt_ThucAn.Size = new System.Drawing.Size(202, 52);
            this.bt_ThucAn.TabIndex = 2;
            this.bt_ThucAn.Text = "Món Ăn";
            this.bt_ThucAn.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.bt_ThucAn.UseVisualStyleBackColor = false;
            this.bt_ThucAn.Click += new System.EventHandler(this.button2_Click);
            // 
            // bt_Ban
            // 
            this.bt_Ban.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(128)))), ((int)(((byte)(0)))));
            this.bt_Ban.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("bt_Ban.BackgroundImage")));
            this.bt_Ban.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.bt_Ban.FlatAppearance.BorderColor = System.Drawing.Color.Black;
            this.bt_Ban.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.bt_Ban.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.bt_Ban.ForeColor = System.Drawing.Color.Black;
            this.bt_Ban.Image = ((System.Drawing.Image)(resources.GetObject("bt_Ban.Image")));
            this.bt_Ban.ImageAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.bt_Ban.Location = new System.Drawing.Point(3, 307);
            this.bt_Ban.Name = "bt_Ban";
            this.bt_Ban.Size = new System.Drawing.Size(202, 52);
            this.bt_Ban.TabIndex = 3;
            this.bt_Ban.Text = "Bàn";
            this.bt_Ban.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.bt_Ban.UseVisualStyleBackColor = false;
            this.bt_Ban.Click += new System.EventHandler(this.button3_Click);
            // 
            // bt_DoanhThu
            // 
            this.bt_DoanhThu.BackColor = System.Drawing.Color.Black;
            this.bt_DoanhThu.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("bt_DoanhThu.BackgroundImage")));
            this.bt_DoanhThu.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.bt_DoanhThu.FlatAppearance.BorderColor = System.Drawing.Color.Black;
            this.bt_DoanhThu.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.bt_DoanhThu.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.bt_DoanhThu.ForeColor = System.Drawing.Color.Black;
            this.bt_DoanhThu.Image = ((System.Drawing.Image)(resources.GetObject("bt_DoanhThu.Image")));
            this.bt_DoanhThu.ImageAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.bt_DoanhThu.Location = new System.Drawing.Point(3, 365);
            this.bt_DoanhThu.Name = "bt_DoanhThu";
            this.bt_DoanhThu.Size = new System.Drawing.Size(202, 52);
            this.bt_DoanhThu.TabIndex = 4;
            this.bt_DoanhThu.Text = "Doanh Thu";
            this.bt_DoanhThu.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.bt_DoanhThu.UseVisualStyleBackColor = false;
            this.bt_DoanhThu.Click += new System.EventHandler(this.button4_Click);
            // 
            // bt_NV
            // 
            this.bt_NV.BackColor = System.Drawing.Color.Black;
            this.bt_NV.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("bt_NV.BackgroundImage")));
            this.bt_NV.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.bt_NV.Cursor = System.Windows.Forms.Cursors.Arrow;
            this.bt_NV.FlatAppearance.BorderColor = System.Drawing.Color.Black;
            this.bt_NV.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.bt_NV.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.bt_NV.ForeColor = System.Drawing.Color.Black;
            this.bt_NV.Image = ((System.Drawing.Image)(resources.GetObject("bt_NV.Image")));
            this.bt_NV.ImageAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.bt_NV.Location = new System.Drawing.Point(3, 423);
            this.bt_NV.Name = "bt_NV";
            this.bt_NV.Size = new System.Drawing.Size(202, 52);
            this.bt_NV.TabIndex = 5;
            this.bt_NV.Text = "Nhân Viên";
            this.bt_NV.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.bt_NV.UseVisualStyleBackColor = false;
            this.bt_NV.Click += new System.EventHandler(this.button5_Click);
            // 
            // bt_SignOut
            // 
            this.bt_SignOut.BackColor = System.Drawing.Color.Black;
            this.bt_SignOut.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("bt_SignOut.BackgroundImage")));
            this.bt_SignOut.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.bt_SignOut.FlatAppearance.BorderColor = System.Drawing.Color.Black;
            this.bt_SignOut.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.bt_SignOut.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(163)));
            this.bt_SignOut.ForeColor = System.Drawing.Color.Black;
            this.bt_SignOut.Image = ((System.Drawing.Image)(resources.GetObject("bt_SignOut.Image")));
            this.bt_SignOut.ImageAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.bt_SignOut.Location = new System.Drawing.Point(3, 481);
            this.bt_SignOut.Name = "bt_SignOut";
            this.bt_SignOut.Size = new System.Drawing.Size(202, 52);
            this.bt_SignOut.TabIndex = 6;
            this.bt_SignOut.Text = "Đăng Xuất";
            this.bt_SignOut.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.bt_SignOut.UseVisualStyleBackColor = false;
            this.bt_SignOut.Click += new System.EventHandler(this.button6_Click);
            // 
            // pl_container
            // 
            this.pl_container.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.pl_container.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pl_container.Dock = System.Windows.Forms.DockStyle.Fill;
            this.pl_container.Location = new System.Drawing.Point(206, 0);
            this.pl_container.Name = "pl_container";
            this.pl_container.Size = new System.Drawing.Size(1056, 673);
            this.pl_container.TabIndex = 1;
            this.pl_container.Paint += new System.Windows.Forms.PaintEventHandler(this.pl_container_Paint);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1262, 673);
            this.Controls.Add(this.pl_container);
            this.Controls.Add(this.flowLayoutPanel1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Quản lý bán đồ ăn nhanh";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.flowLayoutPanel1.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.FlowLayoutPanel flowLayoutPanel1;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Button bt_Main;
        private System.Windows.Forms.Button bt_ThucAn;
        private System.Windows.Forms.Button bt_Ban;
        private System.Windows.Forms.Button bt_DoanhThu;
        private System.Windows.Forms.Button bt_NV;
        private System.Windows.Forms.Button bt_SignOut;
        private System.Windows.Forms.Panel pl_container;
    }
}

