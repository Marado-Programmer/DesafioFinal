package pt.epcc.alunos.al220007.desafiofinal.entities;

import android.os.Bundle;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Teacher extends Human {
	public static final String SCHOOL_KEY = "school";
	public static final String ACADEMIC_LEVEL_KEY = "lvl";

	private final String school;
	private final AcademicLevel academicLevel;
	private final Map<Integer, SubjectModule> modules;

	public Teacher(int image, String name, String school, AcademicLevel academicLevel) {
		super(image, name);
		this.school = school;
		this.academicLevel = academicLevel;
		this.modules = new HashMap<>();
	}

	@NonNull
	@Override
	public Bundle toBundle() {
		Bundle bundle = getBaseBundle();

		bundle.putString(SCHOOL_KEY, school);

		bundle.putString(
			ACADEMIC_LEVEL_KEY,
			String.valueOf(academicLevel).toLowerCase(Locale.ROOT)
		);

		return bundle;
	}

	public void addSubjectModule(int id, SubjectModule module) {
		this.modules.put(id, module);
	}

	public String getSchool() {
		return this.school;
	}

	public AcademicLevel getAcademicLevel() {
		return this.academicLevel;
	}

	public Map<Integer, SubjectModule> getModules() {
		return this.modules;
	}
}
