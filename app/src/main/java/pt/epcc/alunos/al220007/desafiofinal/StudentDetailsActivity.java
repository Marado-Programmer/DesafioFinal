package pt.epcc.alunos.al220007.desafiofinal;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import pt.epcc.alunos.al220007.desafiofinal.entities.Student;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.Adapter;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.DetailsActivity;

public class StudentDetailsActivity extends DetailsActivity {
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
