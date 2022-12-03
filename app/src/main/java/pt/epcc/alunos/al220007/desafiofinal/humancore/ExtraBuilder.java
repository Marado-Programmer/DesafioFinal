package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

@SuppressWarnings("UnusedReturnValue")
public abstract class ExtraBuilder<E extends Human> {
	protected final ViewStub include;
	protected final Bundle human;
	protected final Context ctx;
	protected View view;

	public ExtraBuilder(ViewStub view, Bundle human) {
		include = view;
		this.human = human;

		ctx = view.getContext();
	}

	public ExtraBuilder<E> start() {
		view = include.inflate();

		return this;
	}

	protected <T extends View> T view(int id) {
		return view.findViewById(id);
	}

	protected <T extends View> T hide(int id) {
		T v = view(id);
		v.setVisibility(View.GONE);
		return v;
	}

	protected <T extends View> T show(int id) {
		T v = view(id);
		v.setVisibility(View.VISIBLE);
		return v;
	}
}
