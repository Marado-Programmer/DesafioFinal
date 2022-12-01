package pt.epcc.alunos.al220007.desafiofinal.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class SubjectModule implements Serializable {
	private static final Map<Integer, SubjectModule> modules = new HashMap<>();

	private int id = -1;

	private final Subject subject;

	private final String name;

	private final SchoolYear year;

	private boolean completed = false;

	private final int duration;
	private int currentDuration;

	private final String completedModuleErrStr = "Module already completed.";
	private final String exceedLimitErrStr;

	private SubjectModule(String name, SchoolYear year, Subject subject, int duration) {
		this.name = name;
		this.year = year;
		this.subject = subject;
		this.duration = duration * 60;

		exceedLimitErrStr = String.format(
			Locale.ROOT,
			"Exceeding limit duration of %d hours.",
			duration
		);

		currentDuration = 0;

		isCompleted();
	}

	public static SubjectModule getInstance(int id) {
		if (!modules.containsKey(id)) {
			throw new RuntimeException("");
		}

		return modules.get(id);
	}

	public static SubjectModule createInstance(int id, String name, SchoolYear year, Subject subject, int duration) {
		SubjectModule module = new SubjectModule(name, year, subject, duration);
		module.setId(id);

		return module;
	}

	public static SubjectModule createOrGetInstance(int id, String name, SchoolYear year, Subject subject, int duration) {
		if (!modules.containsKey(id)) {
			return createInstance(id, name, year, subject, duration);
		}

		return getInstance(id);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public SchoolYear getYear() {
		return year;
	}

	public Subject getSubject() {
		return subject;
	}

	public boolean getCompleted() {
		return isCompleted();
	}

	public int getDuration() {
		return duration;
	}

	public String getDurationString() {
		String time = "";

		if (Math.floor(duration / 60) != 0) {
			time = ((int) Math.floor(duration / 60)) + "h";
		}

		if (duration % 60 != 0) {
			time += (duration % 60) + "min";
		}
		return time;
	}

	public int getCurrentDuration() {
		return currentDuration;
	}

	public String getCurrentDurationString() {
		String time = "";

		if (Math.floor(currentDuration / 60) != 0) {
			time = ((int) Math.floor(currentDuration / 60)) + "h";
		}

		if ((currentDuration % 60) != 0) {
			time += (currentDuration % 60) + "min";
		}

		return time;
	}

	private void setId(int id) {
		if (id < 0) {
			throw new RuntimeException("");
		}

		if (modules.containsKey(id)) {
			throw new RuntimeException("");
		}

		modules.put(id, this);
		this.id = id;
	}

	private boolean isCompleted() {
		if (currentDuration >= duration) {
			completed = true;
		}

		return completed;
	}

	public void addHours(int hours) {
		if (isCompleted()) {
			throw new RuntimeException(completedModuleErrStr);
		}

		if ((currentDuration + hours * 60) > duration) {
			throw new RuntimeException(exceedLimitErrStr);
		}

		currentDuration += hours * 60;
	}

	public void addMinutes(int minutes) {
		if (isCompleted()) {
			throw new RuntimeException(completedModuleErrStr);
		}

		if (currentDuration + minutes > duration) {
			throw new RuntimeException(exceedLimitErrStr);
		}

		currentDuration += minutes;
	}
}
