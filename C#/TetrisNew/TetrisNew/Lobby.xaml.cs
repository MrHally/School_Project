using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace TetrisNew
{
    /// <summary>
    /// Interaction logic for Lobby.xaml
    /// </summary>
    public partial class Lobby : Window
    {
        public Lobby()
        {
            InitializeComponent();
            Level1_button.Click += (o, e) => ShowWindow(new Level1(), this);
            Level2_button.Click += (o, e) => ShowWindow(new Level2(), this);
            Level3_button.Click += (o, e) => ShowWindow(new Level3(), this);
            Level4_button.Click += (o, e) => ShowWindow(new Level4(), this);
            Level5_button.Click += (o, e) => ShowWindow(new Level5(), this);
            Level6_button.Click += (o, e) => ShowWindow(new Level6(), this);
        }

        public static void ShowWindow(Window winshow, Window winhide)

        {
            winshow.Show();
            winhide.Close();
        }
    }
}
