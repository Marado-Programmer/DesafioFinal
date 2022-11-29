package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import pt.epcc.alunos.al220007.desafiofinal.R;
import pt.epcc.alunos.al220007.desafiofinal.entities.Human;

abstract public class HumanViewHolder<E extends Human, T extends HumanDetailsActivity<E>> extends ViewHolder implements View.OnClickListener, DetailsManager {
	protected final View view;

	protected ImageView profilePic;
	protected TextView name;

	protected HumanActivity context;

	protected E human;

	protected boolean isInit;

	protected HumanViewHolder(@NonNull View itemView, HumanActivity context) {
		super(itemView);
		this.context = context;

		itemView.setOnClickListener(this);

		this.profilePic = itemView.findViewById(R.id.profile_pic);
		this.name = itemView.findViewById(R.id.name);

		this.view = itemView;
		this.isInit = false;
	}

	abstract protected int extraID();

	final public int profilePic() {
		return this.human.getImage();
	}

	final public String name() {
		return this.human.getName();
	}

	@Override
	public final void onClick(View v) {
		if (v != this.view) {
			return;
		}

		if (
			this.context.getResources().getConfiguration().orientation
			== Configuration.ORIENTATION_LANDSCAPE
		) {
			Bundle bundleFragment = new Bundle();

			bundleFragment.putLong("id", getItemId());
			bundleFragment.putInt("extra", extraID());
			bundleFragment.putBundle("human", human.toBundle());

			HumanDetailsFragment<E> fragment = new HumanDetailsFragment<>(this, bundleFragment);

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

	protected abstract Class<T> aClass();
}
