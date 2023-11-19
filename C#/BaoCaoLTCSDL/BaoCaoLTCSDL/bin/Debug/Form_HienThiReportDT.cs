using Microsoft.Reporting.WinForms;
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
    public partial class Form_HienThiReportDT : Form
    {
        List<DoanhThu> listDT;
        public Form_HienThiReportDT()
        {
            InitializeComponent();
        }

        private void Form_HienThiReportDT_Load(object sender, EventArgs e)
        {
            reportViewer1.ProcessingMode = ProcessingMode.Local;
            reportViewer1.LocalReport.ReportPath = "Report/ReportDoanhThu.rdlc";
            ReportDataSource reportDataSource = new ReportDataSource("DataSet1", listDT);
            reportViewer1.LocalReport.DataSources.Clear();
            reportViewer1.LocalReport.DataSources.Add(reportDataSource);
            reportViewer1.RefreshReport();
        }

        public void ImportData(List<DoanhThu> ds)
        {
            listDT = ds;
        }

        private void reportViewer1_Load(object sender, EventArgs e)
        {

        }
    }
}
