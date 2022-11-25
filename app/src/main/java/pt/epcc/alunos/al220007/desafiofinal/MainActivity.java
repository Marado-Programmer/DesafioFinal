package pt.epcc.alunos.al220007.desafiofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanAdapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanViewHolder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	private Button teacherBtn, studentBtn;
	private RelativeLayout header;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.findViews();
	}

	private void findViews() {
		this.header = this.findViewById(R.id.header);
		this.header.setOnClickListener(this);

		this.teacherBtn = this.findViewById(R.id.teacherBtn);
		this.teacherBtn.setOnClickListener(this);
		this.studentBtn = this.findViewById(R.id.studentBtn);
		this.studentBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == header) {
			this.switchActivity(HeaderActivity.class);
		}

		Class<? extends HumanActivity<? extends Human, ? extends HumanAdapter<? extends HumanViewHolder>>> activityClass = this.getClass(v);

		if (activityClass != null) {
			this.switchActivity(activityClass);
		}
	}

	private Class<? extends HumanActivity<? extends Human, ? extends HumanAdapter<? extends HumanViewHolder>>> getClass(View v) {
		if (v == this.teacherBtn) {
			return TeacherActivity.class;
		}
		if (v == this.studentBtn) {
			return StudentActivity.class;
		}

		return null;
	}

	private void switchActivity(Class<?> activityClass) {
		Intent intent = new Intent(MainActivity.this, activityClass);
		this.startActivity(intent);
	}
}