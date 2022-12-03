package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.DetailsActivity;
import pt.epcc.alunos.al220007.desafiofinal.humancore.activities.HumanActivity;

public abstract class ViewHolder<E extends Human, T extends ExtraBuilder<E>, S extends DetailsActivity<E, T>> extends RecyclerView.ViewHolder implements View.OnClickListener {
	public static final boolean RECYCLABLE = false;

	protected final ImageView profilePic;
	protected final TextView name;

	protected final ViewStub extra;

	protected final HumanActivity<E, T, ? extends Adapter<E, ? extends ViewHolder<E, T, S>, ? extends ExtraBuilder<E>>> manager;

	protected E human;

	protected ViewHolder(
		@NonNull View itemView,
		HumanActivity<E, T, ? extends Adapter<E, ? extends ViewHolder<E, T, S>, ? extends ExtraBuilder<E>>> ctx
	) {
		super(itemView);

		setIsRecyclable(RECYCLABLE);

		manager = ctx;

		itemView.setOnClickListener(this);

		profilePic = itemView.findViewById(R.id.profile_pic);
		name = itemView.findViewById(R.id.name);

		ViewStub include = itemView.findViewById(R.id.id_extra);
		include.setLayoutResource(extraID());

		extra = include;
	}

	@Override
	public final void onClick(View v) {
		if (v != itemView) {
			return;
		}

		Bundle bundle = putExtras(new Bundle());

		Log.i("BUNDLE TO SET", String.valueOf(bundle.getInt(DetailsFragment.ID_KEY)));

		manager.setLastState(bundle);

		manager.firstTimeProcess();
	}

	abstract protected int extraID();

	protected Bundle putExtras(Bundle bundle) {
		bundle.putInt(DetailsFragment.EXTRA_KEY, extraID());
		bundle.putBundle(DetailsFragment.HUMAN_KEY, human.toBundle());
		bundle.putInt(DetailsFragment.ID_KEY, getLayoutPosition());

		return bundle;
	}

	public final void setHuman(E human) {
		this.human = human;
	}
}
