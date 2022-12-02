package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

abstract public class HumanViewHolder<E extends Human, T extends HumanDetailsActivity<E>> extends ViewHolder implements View.OnClickListener, DetailsManager {
	protected final View view;

	protected int id;

	protected ImageView profilePic;
	protected TextView name;

	protected View extra;

	protected HumanActivity context;

	protected E human;

	protected HumanViewHolder(@NonNull View itemView, HumanActivity context) {
		super(itemView);
		this.context = context;

		itemView.setOnClickListener(this);

		profilePic = itemView.findViewById(R.id.profile_pic);
		name = itemView.findViewById(R.id.name);

		ViewStub include = itemView.findViewById(R.id.id_extra);
		include.setLayoutResource(miniExtraID());

		extra = include.inflate();

		view = itemView;
	}

	abstract protected int extraID();

	abstract protected int miniExtraID();

	final public int profilePic() {
		return this.human.getImage();
	}

	final public String name() {
		return this.human.getName();
	}

	@Override
	public final void onClick(View v) {
		if (v != view) {
			return;
		}

		Bundle bundleFragment = new Bundle();

		bundleFragment.putLong("id", getItemId());
		bundleFragment.putInt("extra", extraID());
		bundleFragment.putBundle("human", human.toBundle());
		bundleFragment.putInt("last", id);

		context.setLast(bundleFragment);

		if (
			this.context.getResources().getConfiguration().orientation
			== Configuration.ORIENTATION_LANDSCAPE
		) {

			HumanDetailsFragment fragment = new HumanDetailsFragment(this, bundleFragment);

			context.getSupportFragmentManager().beginTransaction()
				.setReorderingAllowed(true)
				.replace(
					R.id.details,
					fragment
				).commit();
			return;
		}

		Intent intent = new Intent(context, aClass());

		intent.putExtra("id", getItemId());
		intent.putExtra("extra", extraID());
		intent.putExtra("human", human.toBundle());

		this.context.startActivity(intent);
	}

	public final void setHuman(E human) {
		this.human = human;
	}

	public void setId(int id) {
		this.id = id;
	}

	protected abstract Class<T> aClass();
}
