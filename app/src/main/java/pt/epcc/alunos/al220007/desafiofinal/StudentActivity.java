package pt.epcc.alunos.al220007.desafiofinal;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewStub;

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

public class StudentActivity extends HumanActivity<Student, StudentExtraBuilder, StudentAdapter> {
	protected static List<Student> students;
	protected static List<Hobby> hobbies;

	@NonNull
	@Override
	public StudentAdapter createAdapter(HumanActivity<Student, StudentExtraBuilder, StudentAdapter> context) {
		return new StudentAdapter(context);
	}

	@Override
	public void createDetails(StudentExtraBuilder builder) {
		builder.start();
		builder.setHobbies();
	}

	@Override
	public StudentExtraBuilder createBuilder(@NonNull ViewStub view, Bundle human) {
		return new StudentExtraBuilder(view, human);
	}

	@NonNull
	@Override
	public Class<? extends DetailsActivity<Student, StudentExtraBuilder>> nextDetailsManager() {
		return StudentDetailsActivity.class;
	}

	@Override
	protected LayoutManagerType choseLayoutManager() {
		return LayoutManagerType.LINEAR;
	}

	@NonNull
	@Override
	public List<Student> genList() {
		generateHobbies();

		Log.d("NULL???", String.valueOf(students));

		if (students == null) {
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
}
