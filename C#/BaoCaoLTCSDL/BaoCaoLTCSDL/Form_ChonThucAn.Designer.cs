namespace BaoCaoLTCSDL
{
    partial class Form_ChonThucAn
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form_ChonThucAn));
            this.panel1 = new System.Windows.Forms.Panel();
            this.label1 = new System.Windows.Forms.Label();
            this.fpl_danhmuc = new System.Windows.Forms.FlowLayoutPanel();
            this.fpl_monan = new System.Windows.Forms.FlowLayoutPanel();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("panel1.BackgroundImage")));
            this.panel1.Controls.Add(this.label1);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(755, 50);
            this.panel1.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(128)))), ((int)(((byte)(0)))));
            this.label1.Font = new System.Drawing.Font("Century Gothic", 22.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Image = ((System.Drawing.Image)(resources.GetObject("label1.Image")));
            this.label1.Location = new System.Drawing.Point(293, 5);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(157, 44);
            this.label1.TabIndex = 0;
            this.label1.Text = "Món Ăn";
            // 
            // fpl_danhmuc
            // 
            this.fpl_danhmuc.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("fpl_danhmuc.BackgroundImage")));
            this.fpl_danhmuc.Dock = System.Windows.Forms.DockStyle.Top;
            this.fpl_danhmuc.Location = new System.Drawing.Point(0, 50);
            this.fpl_danhmuc.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.fpl_danhmuc.Name = "fpl_danhmuc";
            this.fpl_danhmuc.Size = new System.Drawing.Size(755, 90);
            this.fpl_danhmuc.TabIndex = 1;
            // 
            // fpl_monan
            // 
            this.fpl_monan.AutoScroll = true;
            this.fpl_monan.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("fpl_monan.BackgroundImage")));
            this.fpl_monan.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.fpl_monan.Dock = System.Windows.Forms.DockStyle.Fill;
            this.fpl_monan.Location = new System.Drawing.Point(0, 140);
            this.fpl_monan.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.fpl_monan.Name = "fpl_monan";
            this.fpl_monan.Size = new System.Drawing.Size(755, 482);
            this.fpl_monan.TabIndex = 2;
            this.fpl_monan.Paint += new System.Windows.Forms.PaintEventHandler(this.fpl_monan_Paint);
            // 
            // Form_ChonThucAn
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.ClientSize = new System.Drawing.Size(755, 622);
            this.Controls.Add(this.fpl_monan);
            this.Controls.Add(this.fpl_danhmuc);
            this.Controls.Add(this.panel1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.Name = "Form_ChonThucAn";
            this.Text = "Form_ChonThucAn";
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.FlowLayoutPanel fpl_danhmuc;
        private System.Windows.Forms.FlowLayoutPanel fpl_monan;
    }
}