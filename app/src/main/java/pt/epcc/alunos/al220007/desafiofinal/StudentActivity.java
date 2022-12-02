package pt.epcc.alunos.al220007.desafiofinal;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;

import pt.epcc.alunos.al220007.desafiofinal.entities.Student;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.DetailsActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;

public class StudentActivity extends HumanActivity<Student, StudentAdapter> {
	@Override
	protected LayoutManagerType choseLayoutManager() {
		return LayoutManagerType.LINEAR;
	}

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

	@NonNull
	@Override
	protected Class<? extends DetailsActivity<Student>> nextDetailsManager() {
		return StudentDetailsActivity.class;
	}

	@NonNull
	@Override
	public StudentAdapter createAdapter(Context context) {
		return new StudentAdapter(context);
	}
}
