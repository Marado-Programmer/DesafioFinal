package pt.epcc.alunos.al220007.desafiofinal;

import android.os.Bundle;
import android.view.ViewStub;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import pt.epcc.alunos.al220007.desafiofinal.entities.Student;
import pt.epcc.alunos.al220007.desafiofinal.humancore.ExtraBuilder;

@SuppressWarnings("UnusedReturnValue")
public class StudentExtraBuilder extends ExtraBuilder<Student> {
	public StudentExtraBuilder(ViewStub view, Bundle human) {
		super(view, human);
	}

	public StudentExtraBuilder setHobbies() {
		ListView v = view(R.id.studentHobbies);
		v.setAdapter(
			new ArrayAdapter<>(
				ctx,
				R.layout.simple_list_item,
				human.getStringArray(Student.HOBBIES_KEY)
			)
		);

		return this;
	}
}
