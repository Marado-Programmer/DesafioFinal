package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
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

public abstract class ViewHolder<E extends Human, T extends DetailsActivity<E>> extends RecyclerView.ViewHolder implements View.OnClickListener, DetailsManager {
	protected ImageView profilePic;
	protected TextView name;

	protected View extra;

	protected HumanActivity<E, ? extends Adapter<E, ? extends ViewHolder<E, T>>> context;

	protected E human;

	protected ViewHolder(
		@NonNull View itemView,
		HumanActivity<E, ? extends Adapter<E, ? extends ViewHolder<E, T>>> ctx
	) {
		super(itemView);

		setIsRecyclable(false);

		context = ctx;

		itemView.setOnClickListener(this);

		profilePic = itemView.findViewById(R.id.profile_pic);
		name = itemView.findViewById(R.id.name);

		ViewStub include = itemView.findViewById(R.id.id_extra);
		include.setLayoutResource(miniExtraID());

		extra = include.inflate();
	}

	@Override
	public final void onClick(View v) {
		if (v != itemView) {
			return;
		}

		Bundle bundleFragment = putExtras(new Bundle());

		//Adapter<E, ? extends ViewHolder<E, ? extends DetailsActivity<E>>> adapter = (Adapter<E, ? extends ViewHolder<E, ? extends DetailsActivity<E>>>) getBindingAdapter();

		context.setLastState(bundleFragment);

		if (
			this.context.getResources().getConfiguration().orientation
				== Configuration.ORIENTATION_LANDSCAPE
		) {

			DetailsFragment fragment = new DetailsFragment(this, bundleFragment);

			context.getSupportFragmentManager().beginTransaction()
				.setReorderingAllowed(true)
				.replace(
					R.id.details,
					fragment
				).commit();
			return;
		}

		context.startActivity(putExtras(new Intent(context, aClass())));
	}

	abstract protected int extraID();

	abstract protected int miniExtraID();

//	final public int profilePic() {
//		return this.human.getImage();
//	}
//
//	final public String name() {
//		return this.human.getName();
//	}

	protected Intent putExtras(Intent intent) {
		intent.putExtra(DetailsFragment.EXTRA_KEY, extraID());
		intent.putExtra(DetailsFragment.HUMAN_KEY, human.toBundle());
		intent.putExtra(DetailsFragment.ID_KEY, getLayoutPosition());

		return intent;
	}

	protected Bundle putExtras(Bundle bundle) {
		bundle.putInt(DetailsFragment.EXTRA_KEY, extraID());
		bundle.putBundle(DetailsFragment.HUMAN_KEY, human.toBundle());
		bundle.putInt(DetailsFragment.ID_KEY, getLayoutPosition());

		return bundle;
	}

	public final void setHuman(E human) {
		this.human = human;
	}

	protected abstract Class<T> aClass();
}
