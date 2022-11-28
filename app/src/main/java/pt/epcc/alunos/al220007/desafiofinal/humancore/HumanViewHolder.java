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

abstract public class HumanViewHolder<E extends Human> extends ViewHolder implements View.OnClickListener {
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

	abstract protected void findViews(View view);

	abstract protected Bundle helperBundle();

	@Override
	public final void onClick(View v) {
		if (v != this.view) {
			return;
		}


		Bundle bundle = this.helperBundle();

		if (
			this.context.getResources().getConfiguration().orientation
			== Configuration.ORIENTATION_LANDSCAPE
		) {
			Bundle bundleFragment = new Bundle();

			bundleFragment.putLong("id", getItemId());
			bundleFragment.putInt("extra", this.extraID());

			bundleFragment.putBundle("human", bundle);

			this.context.getSupportFragmentManager().beginTransaction()
				.setReorderingAllowed(true)
				.add(
					R.id.details,
					HumanDetailsFragment.class,
					bundleFragment
				).commit();
			return;
		}

		Intent intent = new Intent(this.context, HumanDetailsActivity.class);

		intent.putExtra("id", this.getItemId());
		intent.putExtra("extra", this.extraID());

		intent.putExtra("human", bundle);

		this.context.startActivity(intent);
	}

	public final void setHuman(E human) {
		this.human = human;
	}
}
