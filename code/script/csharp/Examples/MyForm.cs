using System;
using System.Windows.Forms; 

namespace HelloWin
{
	public class MyForm : Form
	{
		private TextBox txtEnter;
		private Label lblDisplay;
		private Button btn0k;
		
		public MyForm()
		{
			this.txtEnter = new TextBox();
			this.lblDisplay = new Label();
			this.btn0k = new Button();
			this.Text = "My HelloWin App!";
			
			// txtEnter
			this.txtEnter.Location = new System.Drawing.Point(16, 32);
			this.txtEnter.Size = new System.Drawing.Size(264, 20);
			
			// lblDisplay
			this.lblDisplay.Location = new System.Drawing.Point(16, 72);
			this.lblDisplay.Size = new System.Drawing.Size(264, 128);
			
			// btn0k
			this.btn0k.Location = new System.Drawing.Point(88, 224);
			this.btn0k.Text = "OK";
			this.btn0k.Click +=
						new System.EventHandler(this.btn0k_Click);
			// MyForm
			this.Controls.AddRange(new Control[] 
		{
					this.txtEnter, this.lblDisplay, this.btn0k});
		}
		
		static void Main()
		{
			Application.Run(new MyForm());
		}
		
		private void btn0k_Click(object sender, System.EventArgs e)
		{
			lblDisplay.Text = txtEnter.Text + "\n" + lblDisplay.Text;
		}
	}
}