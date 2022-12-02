package pt.epcc.alunos.al220007.desafiofinal;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import pt.epcc.alunos.al220007.desafiofinal.entities.Hobby;
import pt.epcc.alunos.al220007.desafiofinal.entities.Student;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.Adapter;

public class StudentAdapter extends Adapter<Student, StudentViewHolder> {
	protected static List<Student> students;
	protected static List<Hobby> hobbies;

	public StudentAdapter(Context context) {
		super(context);
	}

	@Override
	public List<Student> generateList() {
		generateHobbies();

		if (students != null) {
			students = new ArrayList<>(
				Arrays.asList(
					createHumanWithRandomHobbies(
						R.drawable.logo_epcc,
						"Zara G"
					),
					createHumanWithRandomHobbies(
						R.drawable.logo_epcc,
						"Gson"
					),
					createHumanWithRandomHobbies(
						R.drawable.logo_epcc,
						"Kroa"
					),
					createHumanWithRandomHobbies(
						R.drawable.logo_epcc,
						"Zizzy Jr"
					)
				)
			);
		}

		return students;
	}

	protected void generateHobbies() {
		if (hobbies == null) {
			hobbies = Arrays.stream(
				context.getResources()
					.getStringArray(R.array.hobbies)
				)
				.map(Hobby::new)
				.collect(Collectors.toList());
		}
	}

	protected Student createHumanWithRandomHobbies(int image, String name) {
		Random random = new Random();
		int numHobbies = random.nextInt(5);

		Student student = new Student(image, name);

		for (int i = 0; i < numHobbies; i++) {
			if (hobbies.size() <= 0) {
				generateHobbies();
			}

			student.addHobby(hobbies.remove(random.nextInt(hobbies.size())));
		}

		return student;
	}

	@Override
	protected void manageTinyExtra(View view, Student human) {

	}

	@Override
	protected LayoutManagerType getDefaultLayout() {
		return LayoutManagerType.LINEAR;
	}

	@NonNull
	@Override
	public StudentViewHolder createViewHolder(View view, HumanActivity<Student, ? extends Adapter<Student, StudentViewHolder>> context) {
		return new StudentViewHolder(view, context);
	}
}
