package pt.epcc.alunos.al220007.desafiofinal;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanActivity;

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
		this.teacherBtn.setOnClickListener(this);
		this.studentBtn = this.findViewById(R.id.studentBtn);
		this.studentBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Class<? extends HumanActivity> activityClass = this.getClass(v);

		if (activityClass != null) {
			Intent intent = new Intent(MainActivity.this, activityClass);
			this.startActivity(intent);
		}
	}

	private Class<? extends HumanActivity> getClass(View v) {
		if (v == this.teacherBtn) {
			return TeacherActivity.class;
		}
		if (v == this.studentBtn) {
			return StudentActivity.class;
		}

		return null;
	}
}