package pt.epcc.alunos.al220007.desafiofinal.humancore;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import pt.epcc.alunos.al220007.desafiofinal.R;

abstract public class HumanViewHolder extends ViewHolder implements View.OnClickListener {
	protected final View view;
	protected final ViewStub include;

	protected ImageView profilePic;
	protected TextView name;

	protected Context context;

	protected boolean isInit;

	protected HumanViewHolder(@NonNull View itemView) {
		super(itemView);

		itemView.setOnClickListener(this);

		this.include = itemView.findViewById(R.id.card_view_extra);
		this.include.setLayoutResource(this.extraID());
		this.include.inflate();

		this.profilePic = itemView.findViewById(R.id.profile_pic);
		this.name = itemView.findViewById(R.id.name);
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

	abstract protected int extraID();
	abstract protected void findViews(View view);
}
