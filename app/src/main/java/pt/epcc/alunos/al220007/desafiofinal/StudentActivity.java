package pt.epcc.alunos.al220007.desafiofinal;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pt.epcc.alunos.al220007.desafiofinal.entities.Student;
import pt.epcc.alunos.al220007.desafiofinal.humancore.HumanActivity;

public class StudentActivity extends HumanActivity<Student, StudentAdapter> {
	@Override
	protected LayoutManagerType choseLayoutManager() {
		return LayoutManagerType.LINEAR;
	}

	@Override
	public List<Student> generateList() {
		return new ArrayList<>(Arrays.asList(
			new Student(R.drawable.logo_epcc, "Zara G"),
			new Student(R.drawable.logo_epcc, "Gson"),
			new Student(R.drawable.logo_epcc, "Kroa"),
			new Student(R.drawable.logo_epcc, "Zizzy Jr"),

			new Student(R.drawable.logo_epcc, "Zara G"),
			new Student(R.drawable.logo_epcc, "Gson"),
			new Student(R.drawable.logo_epcc, "Kroa"),
			new Student(R.drawable.logo_epcc, "Zizzy Jr"),

			new Student(R.drawable.logo_epcc, "Zara G"),
			new Student(R.drawable.logo_epcc, "Gson"),
			new Student(R.drawable.logo_epcc, "Kroa"),
			new Student(R.drawable.logo_epcc, "Zizzy Jr"),

			new Student(R.drawable.logo_epcc, "Zara G"),
			new Student(R.drawable.logo_epcc, "Gson"),
			new Student(R.drawable.logo_epcc, "Kroa"),
			new Student(R.drawable.logo_epcc, "Zizzy Jr"),

			new Student(R.drawable.logo_epcc, "Zara G"),
			new Student(R.drawable.logo_epcc, "Gson"),
			new Student(R.drawable.logo_epcc, "Kroa"),
			new Student(R.drawable.logo_epcc, "Zizzy Jr"),

			new Student(R.drawable.logo_epcc, "Zara G"),
			new Student(R.drawable.logo_epcc, "Gson"),
			new Student(R.drawable.logo_epcc, "Kroa"),
			new Student(R.drawable.logo_epcc, "Zizzy Jr"),

			new Student(R.drawable.logo_epcc, "Zara G"),
			new Student(R.drawable.logo_epcc, "Gson"),
			new Student(R.drawable.logo_epcc, "Kroa"),
			new Student(R.drawable.logo_epcc, "Zizzy Jr"),

			new Student(R.drawable.logo_epcc, "Zara G"),
			new Student(R.drawable.logo_epcc, "Gson"),
			new Student(R.drawable.logo_epcc, "Kroa"),
			new Student(R.drawable.logo_epcc, "Zizzy Jr")
			)
		);
	}

	@NonNull
	@Override
	public StudentAdapter createAdapter(HumanActivity<Student, StudentAdapter> context) {
		return new StudentAdapter(context);
	}
}
