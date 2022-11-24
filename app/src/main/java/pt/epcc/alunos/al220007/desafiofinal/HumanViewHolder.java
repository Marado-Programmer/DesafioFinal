package pt.epcc.alunos.al220007.desafiofinal;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

abstract public class HumanViewHolder extends ViewHolder implements View.OnClickListener {
	protected final View view;

	protected ImageView profilePic;
	protected TextView name;

	protected Context context;

	protected boolean isInit;

	protected HumanViewHolder(@NonNull View itemView) {
		super(itemView);

		itemView.setOnClickListener(this);

		this.profilePic = itemView.findViewById(R.id.profile_pic);
		this.findViews(itemView);

		this.view = itemView;
		this.isInit = false;
	}

	public void init(Context context) {
		if (this.isInit) {
			throw new RuntimeException("Already initiated");
		}

		this.context = context;
		this.isInit = true;
	}

	abstract protected void findViews(View view);
}
