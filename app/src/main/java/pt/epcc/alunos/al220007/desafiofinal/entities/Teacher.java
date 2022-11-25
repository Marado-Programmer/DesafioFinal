package pt.epcc.alunos.al220007.desafiofinal.entities;

import java.util.HashMap;
import java.util.Map;

import pt.epcc.alunos.al220007.desafiofinal.AcademicLevel;
import pt.epcc.alunos.al220007.desafiofinal.SubjectModule;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

public class Teacher extends Human {
	private String school;
	private AcademicLevel academicLevel;
	private Map<Integer, SubjectModule> modules;

	public Teacher(int image, String name, String school, AcademicLevel academicLevel) {
		super(image, name);
		this.school = school;
		this.academicLevel = academicLevel;
		this.modules = new HashMap<>();
	}

	public void addSubject(int id, SubjectModule module) {
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
