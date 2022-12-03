package pt.epcc.alunos.al220007.desafiofinal;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import pt.epcc.alunos.al220007.desafiofinal.entities.Hobby;
import pt.epcc.alunos.al220007.desafiofinal.entities.Student;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.DetailsActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;

public class StudentActivity extends HumanActivity<Student, StudentAdapter> {
	protected static List<Student> students;
	protected static List<Hobby> hobbies;

	@Override
	protected LayoutManagerType choseLayoutManager() {
		return LayoutManagerType.LINEAR;
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
			hobbies = Arrays.stream(getResources().getStringArray(R.array.hobbies))
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
	public StudentAdapter createAdapter(HumanActivity<Student, StudentAdapter> context) {
		return new StudentAdapter(this);
	}
}
