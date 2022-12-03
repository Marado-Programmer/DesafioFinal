package pt.epcc.alunos.al220007.desafiofinal.entities;

import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class SubjectModule implements Serializable {
	private static final Map<Integer, SubjectModule> modules = new HashMap<>();
	private static final String DOES_NOT_EXIST_ERR_STR = "Subject doesn't exist.";
	private static final String INVALID_ID_ERR_STR = "Negative IDs aren't allowed.";
	private static final String USED_ID_ERR_STR = "ID already in use.";
	private static final String COMPLETED_MODULE_ERR_STR = "Module already completed.";
	private final Subject subject;
	private final String name;
	private final SchoolYear year;
	private final int duration;
	private final String EXCEED_LIMIT_ERR_STR;
	private int id = RecyclerView.NO_POSITION;
	private boolean completed = false;
	private int currentDuration;

	private SubjectModule(String name, SchoolYear year, Subject subject, int duration) {
		this.name = name;
		this.year = year;
		this.subject = subject;
		this.duration = duration * 60;

		EXCEED_LIMIT_ERR_STR = String.format(
			Locale.ROOT,
			"Exceeding limit duration of %d hours.",
			duration
		);

		currentDuration = 0;

		isCompleted();
	}

	public static SubjectModule getInstance(int id) {
		if (!modules.containsKey(id)) {
			throw new RuntimeException(DOES_NOT_EXIST_ERR_STR);
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

	private void setId(int id) {
		if (id < 0) {
			throw new RuntimeException(INVALID_ID_ERR_STR);
		}

		if (modules.containsKey(id)) {
			throw new RuntimeException(USED_ID_ERR_STR);
		}

		modules.put(id, this);
		this.id = id;
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

		if (Math.floor(duration / (float) 60) != 0) {
			time = ((int) Math.floor(duration / (float) 60)) + "h";
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

		if (Math.floor(currentDuration / (float) 60) != 0) {
			time = ((int) Math.floor(currentDuration / (float) 60)) + "h";
		}

		if ((currentDuration % 60) != 0) {
			time += (currentDuration % 60) + "min";
		}

		return time;
	}

	private boolean isCompleted() {
		if (currentDuration >= duration) {
			completed = true;
		}

		return completed;
	}

	public void addHours(int hours) {
		if (isCompleted()) {
			throw new RuntimeException(COMPLETED_MODULE_ERR_STR);
		}

		if ((currentDuration + hours * 60) > duration) {
			throw new RuntimeException(EXCEED_LIMIT_ERR_STR);
		}

		currentDuration += hours * 60;
	}

	public void addMinutes(int minutes) {
		if (isCompleted()) {
			throw new RuntimeException(COMPLETED_MODULE_ERR_STR);
		}

		if (currentDuration + minutes > duration) {
			throw new RuntimeException(EXCEED_LIMIT_ERR_STR);
		}

		currentDuration += minutes;
	}
}
