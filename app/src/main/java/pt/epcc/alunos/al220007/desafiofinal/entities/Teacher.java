package pt.epcc.alunos.al220007.desafiofinal.entities;

import android.os.Bundle;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Teacher extends Human {
	public static final String SCHOOL_KEY = "school";
	public static final String ACADEMIC_LEVEL_KEY = "lvl";
	public static final String MODULES_KEYS_KEY = "keys";

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

		Integer[] modulesKeys = new Integer[this.modules.size()];
		bundle.putIntegerArrayList(MODULES_KEYS_KEY, new ArrayList<>(
			Arrays.asList(this.modules.keySet().toArray(modulesKeys))
		));

		return bundle;
	}

	public void addSubjectModule(SubjectModule module) {
		this.modules.put(module.getId(), module);
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
