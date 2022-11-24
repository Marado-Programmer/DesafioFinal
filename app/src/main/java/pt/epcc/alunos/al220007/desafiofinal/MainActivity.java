package pt.epcc.alunos.al220007.desafiofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	private Button teacherBtn, studentBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.findViews();
	}

	private void findViews() {
		this.teacherBtn = this.findViewById(R.id.teacherBtn);
		this.studentBtn = this.findViewById(R.id.studentBtn);
	}

	@Override
	public void onClick(View v) {
		if (v == this.teacherBtn) {

		}
	}
}