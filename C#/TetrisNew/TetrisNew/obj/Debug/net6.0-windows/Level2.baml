   M S B A M L   `   `   `  ����D  @TetrisNew, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null%clr-namespace:TetrisNew	TetrisNew  5   	       TetrisNew.Level2   5   	   W SPresentationCore, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   )localclr-namespace:TetrisNew     5   	   -   5          � Title$  Level2��5   	    � WindowStartupLocation$ CenterScreen=�6   $	��600��6=   $	��800��6J   $	��600��6V   $	��600��6f   
�������$��Comic Sans MS)�6�   $��28(�6�   .��5	      �  � RowDefinitions 5
   
   �� 5      $
��auto �6   �� 5      $��* �6    � ColumnDefinitions 5   
   �� 5      $��* �6   �� 5      $
��auto �6   �� 5      $��* �6   ��5   
   �� 5       �� ImageSource$ Assets/background2.png��6   .+�5   
   (� $��1��6   $��1��6   $��0,0,0,20q�6/   .��5      �� -   5         ��Name$ 
GameCanvas��5      ���#101010$	��250��6>   $	��510��6J   $
}�True��6W   6k   5      �� 5   
   -   5         ��Name$ Level��5      $��0��6#   $��1��60   $��Level 2��6@   $��0,20,0,0q�6O    �� TextAlignment$ Center=�6a   �� 5   
   $��1��6   $��0��6"   $��Center=�62   $��Center=�6M   .+�5      �� -   5        $ 	ScoreText��5      $��Score: ��6+   $
��0,20q�6:   �� 5       -   5        $
 Goal��5       $��Goal: 10��6&   5!      �� 5$   
   $��1��6   $��2��6"   $��Center=�62   $
��Left=�6M   .+�5%      �� $��Next: ��6   $ Center=�6&   �� 5&      -   5         ��Name$ 	NextImage��5&      $��20q�6'   $	��125��63   5'      � 5)   
   -   5        	 �Name$	 GameWinMenu��5)      ���	#CC000000$��2��6;   $��3��6L   $y�Hidden=�6`   .+�5*      �� $��Center=�6   $��Center=�66   .+�5+      �� $��You win��6   $��28(�6+   $ Center=�69   �� 5,      $��Goal: 10��6   
������$��28(�6D   $ Center=�6R   �� 5-      -   5        $ FinalScoreText1��5-      $��Score: ��65   $��36(�6D   $ Center=�6R   �� 5.      -	   5        $��Next Level?��5.      
�������$��0,20,0,0q�6F   $��5q�6X   6d   �� 5/      -
   5        $��Lobby��5/      
�������$��0,20,0,0q�6@   $��5q�6R   6^   50      51      � 53   
   -   5        $	 GameOveMenu��53      ���	#CC000000$��2��6;   $��3��6L   $y�Hidden=�6`   .+�54      �� $��Center=�6   $��Center=�66   .+�55      �� $��	Game Over��6   $��48(�6-   $ Center=�6;   �� 56      $��Goal: 10��6   
���  ��$��28(�6=   $ Center=�6K   �� 57      -   5        $ FinalScoreText��57      $��Score: ��64   $��36(�6C   $ Center=�6Q   �� 58      -   5        $��Play Again?��58      
�������$��0,20,0,0q�6F   $��5q�6X   6d   �� 59      -   5        $��Lobby��59      
�������$��0,20,0,0q�6@   $��5q�6R   6^   5:      5;      5<      5=      