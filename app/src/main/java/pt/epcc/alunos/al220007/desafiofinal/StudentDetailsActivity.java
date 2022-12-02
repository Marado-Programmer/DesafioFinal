package pt.epcc.alunos.al220007.desafiofinal;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import pt.epcc.alunos.al220007.desafiofinal.entities.Student;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.Adapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanDetailsActivity;

public class StudentDetailsActivity extends HumanDetailsActivity<Student> {
	@Override
	public void createDetails(View view, Bundle bundle) {
		ListView hobbies = view.findViewById(R.id.studentHobbies);
		hobbies.setAdapter(
			new ArrayAdapter<>(
				this,
				R.layout.simple_list_item,
				bundle.getStringArrayList(Student.HOBBIES_KEY)
			)
		);
	}

	@Override
	protected Class<? extends HumanActivity<Student, ? extends Adapter>> aClass() {
		return StudentActivity.class;
	}
}
