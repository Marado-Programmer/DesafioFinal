package pt.epcc.alunos.al220007.desafiofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	private Button teacherBtn, studentBtn;
	private RelativeLayout header;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.findViews();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		this.getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		if (item.getItemId() == R.id.visit) {
			startActivity(new Intent(getApplicationContext(), VisitActivity.class));
		} else if (item.getItemId() == R.id.settings) {
			Toast.makeText(getApplicationContext(), "TODO", Toast.LENGTH_SHORT).show();
		}

		return false;
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

		Class<? extends HumanActivity> activityClass = this.getClass(v);

		if (activityClass != null) {
			this.switchActivity(activityClass);
		}
	}

	private Class<? extends HumanActivity> getClass(View v) {
		if (v == this.teacherBtn) {
			return  TeacherActivity.class;
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